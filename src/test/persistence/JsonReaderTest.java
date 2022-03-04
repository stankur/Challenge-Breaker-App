// inspired by:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/test/persistence/JsonReaderTest.java

package persistence;

import model.Challenge;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    @Test
    void testNonExistentFile() {
        JsonReader reader = new JsonReader("./data/ayylmaohaha.json");
        try {
            Challenge challenge = reader.read();
            fail("expected IOException to be thrown");
        } catch (IOException e) {
            // IOException expected
        }
    }

    @Test
    void testJustRootChecked() {
        JsonReader reader = new JsonReader("./data/testJustRootChecked.json");
        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertTrue(challenge.isChecked());
            assertTrue(challenge.getElaboratedMiniChallenges().getChallenges().isEmpty());
        } catch (IOException e) {
            fail("couldn't read from file");
        }
    }

    @Test
    void testJustRootUnchecked() {
        JsonReader reader = new JsonReader("./data/testJustRootUnchecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());
            assertTrue(challenge.getElaboratedMiniChallenges().getChallenges().isEmpty());
        } catch (IOException e) {
            fail("couldn't read from file");
        }
    }

    @Test
    void testTwoLayersAllUnchecked() {
        JsonReader reader = new JsonReader("./data/testTwoLayersAllUnchecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());

            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            ArrayList<Challenge> challenges = challenge.getElaboratedMiniChallenges().getChallenges();

            assertEquals("name0", challenges.get(0).getName());
            assertEquals("description0", challenges.get(0).getDescription());
            assertFalse(challenges.get(0).isChecked());

            assertEquals("name1", challenges.get(1).getName());
            assertEquals("description1", challenges.get(1).getDescription());
            assertFalse(challenges.get(1).isChecked());

            assertEquals("name2", challenges.get(2).getName());
            assertEquals("description2", challenges.get(2).getDescription());
            assertFalse(challenges.get(2).isChecked());

        } catch (IOException e) {
            fail("couldn't read from file");
        }


    }

    @Test
    void testTwoLayersLeafChecked() {
        JsonReader reader = new JsonReader("./data/testTwoLayersLeafChecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());

            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            ArrayList<Challenge> challenges = challenge.getElaboratedMiniChallenges().getChallenges();

            assertEquals("name0", challenges.get(0).getName());
            assertEquals("description0", challenges.get(0).getDescription());
            assertFalse(challenges.get(0).isChecked());

            assertEquals("name1", challenges.get(1).getName());
            assertEquals("description1", challenges.get(1).getDescription());
            assertFalse(challenges.get(1).isChecked());

            assertEquals("name2", challenges.get(2).getName());
            assertEquals("description2", challenges.get(2).getDescription());
            assertTrue(challenges.get(2).isChecked());

        } catch (IOException e) {
            fail("couldn't read from file");
        }
    }

    @Test
    void testTwoLayersRootChecked() {
        JsonReader reader = new JsonReader("./data/testTwoLayersRootChecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertTrue(challenge.isChecked());

            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            ArrayList<Challenge> challenges = challenge.getElaboratedMiniChallenges().getChallenges();

            assertEquals("name0", challenges.get(0).getName());
            assertEquals("description0", challenges.get(0).getDescription());
            assertTrue(challenges.get(0).isChecked());

            assertEquals("name1", challenges.get(1).getName());
            assertEquals("description1", challenges.get(1).getDescription());
            assertTrue(challenges.get(1).isChecked());

            assertEquals("name2", challenges.get(2).getName());
            assertEquals("description2", challenges.get(2).getDescription());
            assertTrue(challenges.get(2).isChecked());

        } catch (IOException e) {
            fail("couldn't read from file");
        }

    }

    @Test
    void testThreeLayersAllUnchecked() {
        JsonReader reader = new JsonReader("./data/testThreeLayersAllUnchecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());

            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            ArrayList<Challenge> challenges = challenge.getElaboratedMiniChallenges().getChallenges();

            assertEquals("name0", challenges.get(0).getName());
            assertEquals("description0", challenges.get(0).getDescription());
            assertFalse(challenges.get(0).isChecked());

            assertEquals("name1", challenges.get(1).getName());
            assertEquals("description1", challenges.get(1).getDescription());
            assertFalse(challenges.get(1).isChecked());

            assertEquals("name2", challenges.get(2).getName());
            assertEquals("description2", challenges.get(2).getDescription());
            assertFalse(challenges.get(2).isChecked());

            challenges = challenges.get(0).getElaboratedMiniChallenges().getChallenges();

            assertEquals("name00", challenges.get(0).getName());
            assertEquals("description00", challenges.get(0).getDescription());
            assertFalse(challenges.get(0).isChecked());

            assertEquals("name01", challenges.get(1).getName());
            assertEquals("description01", challenges.get(1).getDescription());
            assertFalse(challenges.get(1).isChecked());

            assertEquals("name02", challenges.get(2).getName());
            assertEquals("description02", challenges.get(2).getDescription());
            assertFalse(challenges.get(2).isChecked());


        } catch (IOException e) {
            fail("couldn't read from file");
        }

    }

    @Test
    void testThreeLayersLeafChecked() {
        JsonReader reader = new JsonReader("./data/testThreeLayersLeafChecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());

            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            ArrayList<Challenge> challenges = challenge.getElaboratedMiniChallenges().getChallenges();

            assertEquals("name0", challenges.get(0).getName());
            assertEquals("description0", challenges.get(0).getDescription());
            assertFalse(challenges.get(0).isChecked());

            assertEquals("name1", challenges.get(1).getName());
            assertEquals("description1", challenges.get(1).getDescription());
            assertFalse(challenges.get(1).isChecked());

            assertEquals("name2", challenges.get(2).getName());
            assertEquals("description2", challenges.get(2).getDescription());
            assertFalse(challenges.get(2).isChecked());

            challenges = challenges.get(0).getElaboratedMiniChallenges().getChallenges();

            assertEquals("name00", challenges.get(0).getName());
            assertEquals("description00", challenges.get(0).getDescription());
            assertTrue(challenges.get(0).isChecked());

            assertEquals("name01", challenges.get(1).getName());
            assertEquals("description01", challenges.get(1).getDescription());
            assertFalse(challenges.get(1).isChecked());

            assertEquals("name02", challenges.get(2).getName());
            assertEquals("description02", challenges.get(2).getDescription());
            assertFalse(challenges.get(2).isChecked());


        } catch (IOException e) {
            fail("couldn't read from file");
        }

    }

    @Test
    void testThreeLayersMidChecked() {
        JsonReader reader = new JsonReader("./data/testThreeLayersMidChecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());

            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            ArrayList<Challenge> challenges = challenge.getElaboratedMiniChallenges().getChallenges();

            assertEquals("name0", challenges.get(0).getName());
            assertEquals("description0", challenges.get(0).getDescription());
            assertTrue(challenges.get(0).isChecked());

            assertEquals("name1", challenges.get(1).getName());
            assertEquals("description1", challenges.get(1).getDescription());
            assertFalse(challenges.get(1).isChecked());

            assertEquals("name2", challenges.get(2).getName());
            assertEquals("description2", challenges.get(2).getDescription());
            assertFalse(challenges.get(2).isChecked());

            challenges = challenges.get(0).getElaboratedMiniChallenges().getChallenges();

            assertEquals("name00", challenges.get(0).getName());
            assertEquals("description00", challenges.get(0).getDescription());
            assertTrue(challenges.get(0).isChecked());

            assertEquals("name01", challenges.get(1).getName());
            assertEquals("description01", challenges.get(1).getDescription());
            assertTrue(challenges.get(1).isChecked());

            assertEquals("name02", challenges.get(2).getName());
            assertEquals("description02", challenges.get(2).getDescription());
            assertTrue(challenges.get(2).isChecked());


        } catch (IOException e) {
            fail("couldn't read from file");
        }

    }

    @Test
    void testThreeLayersRootChecked() {
        JsonReader reader = new JsonReader("./data/testThreeLayersRootChecked.json");

        try {
            Challenge challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertTrue(challenge.isChecked());

            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            ArrayList<Challenge> challenges = challenge.getElaboratedMiniChallenges().getChallenges();

            assertEquals("name0", challenges.get(0).getName());
            assertEquals("description0", challenges.get(0).getDescription());
            assertTrue(challenges.get(0).isChecked());

            assertEquals("name1", challenges.get(1).getName());
            assertEquals("description1", challenges.get(1).getDescription());
            assertTrue(challenges.get(1).isChecked());

            assertEquals("name2", challenges.get(2).getName());
            assertEquals("description2", challenges.get(2).getDescription());
            assertTrue(challenges.get(2).isChecked());

            challenges = challenges.get(0).getElaboratedMiniChallenges().getChallenges();

            assertEquals("name00", challenges.get(0).getName());
            assertEquals("description00", challenges.get(0).getDescription());
            assertTrue(challenges.get(0).isChecked());

            assertEquals("name01", challenges.get(1).getName());
            assertEquals("description01", challenges.get(1).getDescription());
            assertTrue(challenges.get(1).isChecked());

            assertEquals("name02", challenges.get(2).getName());
            assertEquals("description02", challenges.get(2).getDescription());
            assertTrue(challenges.get(2).isChecked());


        } catch (IOException e) {
            fail("couldn't read from file");
        }

    }
}
