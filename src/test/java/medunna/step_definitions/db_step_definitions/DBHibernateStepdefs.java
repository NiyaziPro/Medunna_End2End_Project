package medunna.step_definitions.db_step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import medunna.hibernate.Room;
import medunna.hibernate.TestItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBHibernateStepdefs {
    Configuration configuration;
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    List<Room> result;


    @Given("user connects with the database")
    public void userConnectsWithTheDatabase() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(TestItem.class);

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

    }

    @And("send query for test item")
    public void sendQueryForTestItem() {
        TestItem testItem = session.get(TestItem.class,DBTestItemStepDefs.testItemId);
        System.out.println("testItem = " + testItem);

    }

    @Then("verifies that the Test Item is created")
    public void verifiesThatTheTestItemIsCreated() {
    }

    @And("closes the connection")
    public void closesTheConnection() {

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
