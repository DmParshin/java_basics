import com.mongodb.client.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import java.util.Arrays;
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

            }else if (command.length == 1 && command[0].matches("statistic")){

                AggregateIterable<Document> documents = collectionShops.aggregate(Arrays.asList(
                        Document.parse(
                                "{ $lookup: { " +
                                        "from: 'products', " +
                                        "localField: 'products', " +
                                        "foreignField: 'name', " +
                                        "as: 'product_list' } }, " +
                                "{ $unwind: {" +
                                        "path: '$product_list'} }," +
                                "{ $group: {" +
                                        "_id: '$name'," +
                                        "count_products: { $sum: 1}," +
                                        "avgprice: {$avg: $product_list.price}," +
                                        "maxprice: {$max: $product_list.price}," +
                                        "minprice: {$min: $product_list.price}," +
                                        "'count_products < 100': { $sum: {$cond: [{ $lt: [ $product_list.price, 100]}, 1, 0]}}}"
                        )));

                for (Document document : documents) {
                    System.out.println(document.toJson());
                    System.out.println("Total products: " + document.getInteger("count_products"));
                }
            }else System.out.println("WRONG COMMAND");
        }
    }
}
