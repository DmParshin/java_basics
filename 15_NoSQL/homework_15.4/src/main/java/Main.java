import com.mongodb.client.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MongoClient mongoClient = MongoClients.create();;

        MongoDatabase database = mongoClient.getDatabase("homework_15_4");

        MongoCollection<Document> collectionShops = database.getCollection("shops");

        MongoCollection<Document> collectionProducts = database.getCollection("products");
        TimeUnit.SECONDS.sleep(1);
        while (true){
            System.out.println("EXAMPLES COMMAND:"
                    + "\n\taddshop shopname"
                    + "\n\taddproduct productname price"
                    + "\n\texhibitproduct shopname productname"
                    + "\n\tstatistic");
            System.out.println("Please enter command:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[]command = input.split("\s");

            if (command.length == 2 && command[0].matches("addshop")){
                Document tempDocument = Document.parse(String.format("{name: '%s', products: []}", command[1]));
                collectionShops.insertOne(tempDocument);

            }else if (command.length == 3 && command[0].matches("addproduct")){
                Document tempDocument = Document.parse(String.format("{name: '%s', price: '%s'}", command[1], command[2]));
                collectionProducts.insertOne(tempDocument);

            }else if (command.length == 3 && command[0].matches("exhibitproduct")){
                Document tempDocument = Document.parse(String.format("{name : '%s'}, {$addToSet: {products: '$s'}}", command[1], command[2]));
                collectionShops.insertOne(tempDocument);

                if (collectionProducts.find(new Document(command[1], new Document("$eq", command[2]))).first() == null ||
                        collectionShops.find(new Document(command[2], new Document("$eq", command[1]))).first() == null) {
                    System.out.println("Shopname or Productname not found");
                    return;
                }

                Document document = new Document(command[2], new Document("$eq", command[1]));

                Double priceToAdd = (Double) collectionProducts.find(new Document(command[1], new Document("$eq", command[2]))).first().get("price");

                Document document1 = new Document("$addToSet", new Document("$product_list",
                        new Document(command[1], command[2]).append("price", priceToAdd)));

                collectionShops.updateOne(document, document1);

            }else if (command.length == 1 && command[0].matches("statistic")){

                Bson lookup = new Document("$lookup",
                        new Document("from", "products")
                                .append("localField", "products")
                                .append("foreignField", "name")
                                .append("as", "product_list"));

                Bson unwind = new Document("$unwind",
                        new Document("path", "$product_list"));

                Bson group = new Document("$group",
                        new Document ("_id", "$name")
                        .append("count_products", new Document ("$sum", 1))
                        .append("avgprice", new Document("$avg", "$product_list.price"))
                        .append("maxprice", new Document("$max", "$product_list.price"))
                        .append("minprice", new Document("$min", "$product_list.price"))
                        .append("count_products < 100", new Document("$sum", new Document("$cond", Arrays.asList(new Document("$lt", Arrays.asList("$product_list.price", 100)), 1, 0 ))))
                );

                List<Bson> filters = new ArrayList<>();
                filters.add(lookup);
                filters.add(unwind);
                filters.add(group);

                AggregateIterable<Document> documents = collectionShops.aggregate(filters);

                System.out.println("STATISTIC:");
                for (Document document : documents) {
                    System.out.println(document.toJson());
                }
            }else System.out.println("WRONG COMMAND");
        }
    }
}
