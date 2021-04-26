import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        while (true){
            System.out.println("Please enter Course Id");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            if (id > 0 && id <= 45){
                System.out.println(session.get(Course.class, id).getName() + " - "
                        + session.get(Course.class, id).getStudentsCount());
            }else {
                session.close();
                break;
            }
        }
    }
}