import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        insertInTable(session);

        transaction.commit();
        sessionFactory.close();
    }

    private static void insertInTable (Session session){
        List<PurchaseList> purchaseList = session.createQuery("From PurchaseList").getResultList();
        for (PurchaseList purchase : purchaseList) {

            DetachedCriteria studentsCriteria = DetachedCriteria.forClass(Student.class)
                    .add(Restrictions.eq("name", purchase.getStudentName()));
            Student student = (Student) studentsCriteria.getExecutableCriteria(session).list().stream()
                    .findFirst().get();

            DetachedCriteria coursesCriteria = DetachedCriteria.forClass(Course.class)
                    .add(Restrictions.eq("name", purchase.getCourseName()));
            Course course = (Course) coursesCriteria.getExecutableCriteria(session).list().stream()
                    .findFirst().get();

            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(
                    new LinkedPurchaseList.Key(student.getId(), course.getId()), student, course);

            session.save(linkedPurchaseList);
        }

    }
}