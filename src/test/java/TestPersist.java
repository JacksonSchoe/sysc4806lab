import Spring.AddressBook;
import Spring.BuddyInfo;
import org.junit.Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static org.junit.Assert.*;

public class TestPersist {

    @Test
    public void performJPA() {

        // Creating objects representing some products
        BuddyInfo buddy;
        BuddyInfo buddy2;
        buddy = new BuddyInfo();
        buddy2 = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNumber((long)6131234567.0);
        buddy2.setName("Peter");
        buddy2.setAddress("57 Quahog Dr.");
        buddy2.setPhoneNumber((long)6139876543.0);

        //Spring.AddressBook addressBook = new Spring.AddressBook();

        //addressBook.insert(buddy);
        //addressBook.insert(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy);
        //em.persist(addressBook);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM Spring.BuddyInfo b");

        //@SuppressWarnings("unchecked")
        List<BuddyInfo> buddyResults = q.getResultList();

        assertEquals(1,buddyResults.size());

        assertEquals(buddy.getName(),buddyResults.get(0).getName());

        // Querying the contents of the database using JPQL query
        //Query q2 = em.createQuery("SELECT a FROM Spring.AddressBook a");

        //@SuppressWarnings("unchecked")
        //List<Spring.AddressBook> bookResults = q2.getResultList();

        //assertEquals(1,bookResults.size());

        //assertEquals(addressBook.getBuddyList().get(0).getName(), bookResults.get(0).getBuddyList().get(0).getName());


        // Closing connection
        em.close();

        emf.close();
    }

    @Test
    public void performJPAAddress() {
        // Creating objects representing some products
        BuddyInfo buddy;
        BuddyInfo buddy2;
        buddy = new BuddyInfo();
        buddy2 = new BuddyInfo();
        buddy.setName("Homer");
        buddy.setAddress("1125 Colonel By");
        buddy.setPhoneNumber((long)6131234567.0);
        buddy2.setName("Peter");
        buddy2.setAddress("57 Quahog Dr.");
        buddy2.setPhoneNumber((long)6139876543.0);

        AddressBook addressBook = new AddressBook();
        addressBook.insert(buddy);
        addressBook.insert(buddy2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(addressBook);

        tx.commit();


        // Querying the contents of the database using JPQL query
        Query q2 = em.createQuery("SELECT a FROM Spring.AddressBook a");

        //@SuppressWarnings("unchecked")
        List<AddressBook> bookResults = q2.getResultList();

        assertEquals(1,bookResults.size());

        assertEquals(addressBook.getBuddyList().get(0).getName(), bookResults.get(0).getBuddyList().get(0).getName());

        assertEquals(2,bookResults.get(0).getBuddyList().size());

        // Closing connection
        em.close();

        emf.close();
    }

}
