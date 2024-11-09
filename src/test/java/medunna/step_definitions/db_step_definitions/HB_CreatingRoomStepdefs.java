package medunna.step_definitions.db_step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import medunna.hibernate.Room;

import static medunna.step_definitions.db_step_definitions.DBHibernateStepdefs.session;

public class HB_CreatingRoomStepdefs {

    Room room;
    @Given("user create room in database with hibernate")
    public void userCreateRoomInDatabaseWithHibernate() {
        room = new Room(151617183,"DELUXE",true,155,"This is created with HB");

    }

    @And("send query for creating a room")
    public void sendQueryForCreatingARoom() {
        session.save(room);
    }

    @Then("verify A new Room is created")
    public void verifyANewRoomIsCreated() {
    }
}
