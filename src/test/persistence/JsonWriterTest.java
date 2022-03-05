// inspired by:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/test/persistence/JsonWriterTest.java

package persistence;

import model.Challenge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest {
    private Challenge root;
    private Challenge twoLayers;
    private Challenge threeLayers;

    @BeforeEach
    void runBefore() {
        root = new Challenge("name", "description");

        twoLayers = new Challenge("name", "description");
        twoLayers.addElaboratedMiniChallenge(new Challenge("name0", "description0"));
        twoLayers.addElaboratedMiniChallenge(new Challenge("name1", "description1"));
        twoLayers.addElaboratedMiniChallenge(new Challenge("name2", "description2"));

        threeLayers = new Challenge("name", "description");
        threeLayers.addElaboratedMiniChallenge(new Challenge("name0", "description0"));
        threeLayers.addElaboratedMiniChallenge(new Challenge("name1", "description1"));
        threeLayers.addElaboratedMiniChallenge(new Challenge("name2", "description2"));

        Challenge challenge0 = threeLayers.getElaboratedMiniChallenges().getChallenges().get(0);

        challenge0.addElaboratedMiniChallenge(new Challenge("name00", "description00"));
        challenge0.addElaboratedMiniChallenge(new Challenge("name01", "description01"));
        challenge0.addElaboratedMiniChallenge(new Challenge("name02", "description02"));


    }

    @Test
    void testWriterInvalidFile() {
        try {
            Challenge challenge = new Challenge("how to jump off the window", "lmao i have no lyf");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterJustRootUnchecked() {
        try {
            Challenge challenge = new Challenge("name", "description");
            JsonWriter writer = new JsonWriter("./data/testWriterJustRootUnchecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterJustRootUnchecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());
            assertTrue(challenge.getElaboratedMiniChallenges().getChallenges().isEmpty());
        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }

    @Test
    void testWriterJustRootChecked() {
        try {
            Challenge challenge = new Challenge("name", "description");
            challenge.toggleCheck();

            JsonWriter writer = new JsonWriter("./data/testWriterJustRootChecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterJustRootChecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertTrue(challenge.isChecked());
            assertTrue(challenge.getElaboratedMiniChallenges().getChallenges().isEmpty());
        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }

    @Test
    void testWriterTwoLayersAllUnchecked() {
        try {
            Challenge challenge = new Challenge("name", "description");
            challenge.addElaboratedMiniChallenge(new Challenge("name0", "description0"));
            challenge.addElaboratedMiniChallenge(new Challenge("name1", "description1"));
            challenge.addElaboratedMiniChallenge(new Challenge("name2", "description2"));


            JsonWriter writer = new JsonWriter("./data/testWriterTwoLayersAllUnchecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTwoLayersAllUnchecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());
            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge0 = challenge.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name0", challenge0.getName());
            assertEquals("description0", challenge0.getDescription());
            assertFalse(challenge0.isChecked());
            assertEquals(0, challenge0.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge1 = challenge.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name1", challenge1.getName());
            assertEquals("description1", challenge1.getDescription());
            assertFalse(challenge1.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge2 = challenge.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name2", challenge2.getName());
            assertEquals("description2", challenge2.getDescription());
            assertFalse(challenge2.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }

    @Test
    void testWriterTwoLayersLeafChecked() {
        try {
            Challenge challenge = new Challenge("name", "description");
            challenge.addElaboratedMiniChallenge(new Challenge("name0", "description0"));
            challenge.addElaboratedMiniChallenge(new Challenge("name1", "description1"));

            Challenge challenge2 = new Challenge("name2", "description2");
            challenge.addElaboratedMiniChallenge(challenge2);
            challenge2.toggleCheck();

            JsonWriter writer = new JsonWriter("./data/testWriterTwoLayersAllUnchecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTwoLayersAllUnchecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());
            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge0 = challenge.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name0", challenge0.getName());
            assertEquals("description0", challenge0.getDescription());
            assertFalse(challenge.isChecked());
            assertEquals(0, challenge0.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge1 = challenge.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name1", challenge1.getName());
            assertEquals("description1", challenge1.getDescription());
            assertFalse(challenge.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

            challenge2 = challenge.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name2", challenge2.getName());
            assertEquals("description2", challenge2.getDescription());
            assertTrue(challenge2.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }

    @Test
    void testWriterThreeLayersAllUnchecked() {
        try {
            Challenge challenge = new Challenge("name", "description");

            Challenge challenge0 = new Challenge("name0", "description0");
            challenge0.addElaboratedMiniChallenge(new Challenge("name00", "description00"));
            challenge0.addElaboratedMiniChallenge(new Challenge("name01", "description01"));
            challenge0.addElaboratedMiniChallenge(new Challenge("name02", "description02"));

            challenge.addElaboratedMiniChallenge(challenge0);
            challenge.addElaboratedMiniChallenge(new Challenge("name1", "description1"));
            challenge.addElaboratedMiniChallenge(new Challenge("name2", "description2"));

            JsonWriter writer = new JsonWriter("./data/testWriterTwoLayersAllUnchecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTwoLayersAllUnchecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());
            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            challenge0 = challenge.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name0", challenge0.getName());
            assertEquals("description0", challenge0.getDescription());
            assertFalse(challenge0.isChecked());
            assertEquals(3, challenge0.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge00 = challenge0.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name00", challenge00.getName());
            assertEquals("description00", challenge00.getDescription());
            assertFalse(challenge00.isChecked());
            assertEquals(0, challenge00.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge01 = challenge0.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name01", challenge01.getName());
            assertEquals("description01", challenge01.getDescription());
            assertFalse(challenge01.isChecked());
            assertEquals(0, challenge01.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge02 = challenge0.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name02", challenge02.getName());
            assertEquals("description02", challenge02.getDescription());
            assertFalse(challenge02.isChecked());
            assertEquals(0, challenge02.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge1 = challenge.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name1", challenge1.getName());
            assertEquals("description1", challenge1.getDescription());
            assertFalse(challenge1.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge2 = challenge.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name2", challenge2.getName());
            assertEquals("description2", challenge2.getDescription());
            assertFalse(challenge2.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }

    @Test
    void testWriterThreeLayersLeafChecked() {
        try {
            Challenge challenge = new Challenge("name", "description");

            Challenge challenge0 = new Challenge("name0", "description0");
            Challenge challenge00 = new Challenge("name00", "description00");

            challenge0.addElaboratedMiniChallenge(challenge00);
            challenge0.addElaboratedMiniChallenge(new Challenge("name01", "description01"));
            challenge0.addElaboratedMiniChallenge(new Challenge("name02", "description02"));

            challenge00.toggleCheck();

            challenge.addElaboratedMiniChallenge(challenge0);
            challenge.addElaboratedMiniChallenge(new Challenge("name1", "description1"));
            challenge.addElaboratedMiniChallenge(new Challenge("name2", "description2"));

            JsonWriter writer = new JsonWriter("./data/testWriterTwoLayersAllUnchecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTwoLayersAllUnchecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());
            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            challenge0 = challenge.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name0", challenge0.getName());
            assertEquals("description0", challenge0.getDescription());
            assertFalse(challenge0.isChecked());
            assertEquals(3, challenge0.getElaboratedMiniChallenges().getChallenges().size());

            challenge00 = challenge0.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name00", challenge00.getName());
            assertEquals("description00", challenge00.getDescription());
            assertTrue(challenge00.isChecked());
            assertEquals(0, challenge00.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge01 = challenge0.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name01", challenge01.getName());
            assertEquals("description01", challenge01.getDescription());
            assertFalse(challenge01.isChecked());
            assertEquals(0, challenge01.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge02 = challenge0.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name02", challenge02.getName());
            assertEquals("description02", challenge02.getDescription());
            assertFalse(challenge02.isChecked());
            assertEquals(0, challenge02.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge1 = challenge.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name1", challenge1.getName());
            assertEquals("description1", challenge1.getDescription());
            assertFalse(challenge1.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge2 = challenge.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name2", challenge2.getName());
            assertEquals("description2", challenge2.getDescription());
            assertFalse(challenge2.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }

    @Test
    void testWriterThreeLayersMidChecked() {
        try {
            Challenge challenge = new Challenge("name", "description");

            Challenge challenge0 = new Challenge("name0", "description0");

            challenge0.addElaboratedMiniChallenge(new Challenge("name00", "description00"));
            challenge0.addElaboratedMiniChallenge(new Challenge("name01", "description01"));
            challenge0.addElaboratedMiniChallenge(new Challenge("name02", "description02"));

            challenge0.toggleCheck();

            challenge.addElaboratedMiniChallenge(challenge0);
            challenge.addElaboratedMiniChallenge(new Challenge("name1", "description1"));
            challenge.addElaboratedMiniChallenge(new Challenge("name2", "description2"));

            JsonWriter writer = new JsonWriter("./data/testWriterTwoLayersAllUnchecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTwoLayersAllUnchecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertFalse(challenge.isChecked());
            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            challenge0 = challenge.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name0", challenge0.getName());
            assertEquals("description0", challenge0.getDescription());
            assertTrue(challenge0.isChecked());
            assertEquals(3, challenge0.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge00 = challenge0.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name00", challenge00.getName());
            assertEquals("description00", challenge00.getDescription());
            assertTrue(challenge00.isChecked());
            assertEquals(0, challenge00.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge01 = challenge0.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name01", challenge01.getName());
            assertEquals("description01", challenge01.getDescription());
            assertTrue(challenge01.isChecked());
            assertEquals(0, challenge01.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge02 = challenge0.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name02", challenge02.getName());
            assertEquals("description02", challenge02.getDescription());
            assertTrue(challenge02.isChecked());
            assertEquals(0, challenge02.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge1 = challenge.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name1", challenge1.getName());
            assertEquals("description1", challenge1.getDescription());
            assertFalse(challenge1.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge2 = challenge.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name2", challenge2.getName());
            assertEquals("description2", challenge2.getDescription());
            assertFalse(challenge2.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }

    @Test
    void testWriterThreeLayersRootChecked() {
        try {
            Challenge challenge = new Challenge("name", "description");
            challenge.toggleCheck();

            Challenge challenge0 = new Challenge("name0", "description0");
            challenge0.addElaboratedMiniChallenge(new Challenge("name00", "description00"));
            challenge0.addElaboratedMiniChallenge(new Challenge("name01", "description01"));
            challenge0.addElaboratedMiniChallenge(new Challenge("name02", "description02"));

            challenge.addElaboratedMiniChallenge(challenge0);
            challenge.addElaboratedMiniChallenge(new Challenge("name1", "description1"));
            challenge.addElaboratedMiniChallenge(new Challenge("name2", "description2"));

            JsonWriter writer = new JsonWriter("./data/testWriterTwoLayersAllUnchecked.json");
            writer.open();
            writer.write(challenge);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterTwoLayersAllUnchecked.json");
            challenge = reader.read();

            assertEquals("name", challenge.getName());
            assertEquals("description", challenge.getDescription());
            assertTrue(challenge.isChecked());
            assertEquals(3, challenge.getElaboratedMiniChallenges().getChallenges().size());

            challenge0 = challenge.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name0", challenge0.getName());
            assertEquals("description0", challenge0.getDescription());
            assertTrue(challenge0.isChecked());
            assertEquals(3, challenge0.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge00 = challenge0.getElaboratedMiniChallenges().getChallenges().get(0);

            assertEquals("name00", challenge00.getName());
            assertEquals("description00", challenge00.getDescription());
            assertTrue(challenge00.isChecked());
            assertEquals(0, challenge00.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge01 = challenge0.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name01", challenge01.getName());
            assertEquals("description01", challenge01.getDescription());
            assertTrue(challenge01.isChecked());
            assertEquals(0, challenge01.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge02 = challenge0.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name02", challenge02.getName());
            assertEquals("description02", challenge02.getDescription());
            assertTrue(challenge02.isChecked());
            assertEquals(0, challenge02.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge1 = challenge.getElaboratedMiniChallenges().getChallenges().get(1);

            assertEquals("name1", challenge1.getName());
            assertEquals("description1", challenge1.getDescription());
            assertTrue(challenge1.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

            Challenge challenge2 = challenge.getElaboratedMiniChallenges().getChallenges().get(2);

            assertEquals("name2", challenge2.getName());
            assertEquals("description2", challenge2.getDescription());
            assertTrue(challenge2.isChecked());
            assertEquals(0, challenge1.getElaboratedMiniChallenges().getChallenges().size());

        } catch (IOException e) {
            fail("not expected to catch IOException");
        }
    }



}


