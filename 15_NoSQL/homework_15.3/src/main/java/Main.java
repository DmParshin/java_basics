import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.BsonDocument;
import org.bson.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    final static Path PATH = Path.of("files/mongo.csv");

    public static void main(String[] args) throws IOException {
        MongoClient mongoClient = new MongoClient( "127.0.0.1", 27017 );

        MongoDatabase database = mongoClient.getDatabase("homework_15_3");

        // Создаем коллекцию
        MongoCollection<Document> collection = database.getCollection("homework");

        // Удалим из нее все документы
        collection.drop();

        if (Files.exists(PATH)) {
            Parse parse = new Parse(PATH.toString());
            for(CsvObject csvObject: parse.csvObjectList){

                Document tempDocument = new Document()
                        .append("firstName", csvObject.getFirstName())
                        .append("lastName", csvObject.getLastname())
                        .append("age", csvObject.getAge())
                        .append("courses", csvObject.getCourses());

                collection.insertOne(tempDocument);
            }
//            parse.print();
        }
        else {
            System.out.println("Файла не существует!");
        }

        System.out.println("Общее количество студентов в базе: " + collection.countDocuments());
        System.out.println("Количество студентов старше 40 лет: " + collection.countDocuments(BsonDocument.parse("{age: {$gt: 40}}")));

        FindIterable<Document> findDoc= collection.find().sort(BsonDocument.parse("{age:1}")).limit(1);
        for (Document document: findDoc) {
            System.out.print("Имя самого молодого студента: ");
            System.out.println(document.get("firstName") + " " + document.get("lastName"));
        }

        FindIterable<Document> findDoc1= collection.find().sort(BsonDocument.parse("{age:-1}")).limit(1);
        for (Document document: findDoc1) {
            System.out.print("Список курсов самого старого студента: ");
            System.out.println(document.get("courses"));
        }

    }
}
