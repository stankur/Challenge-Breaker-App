package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChallengesGroupTest {
    private Challenge testChallenge;
    private ChallengesGroup testChallengesGroup;

    @BeforeEach
    void runBefore() {
        testChallenge = new Challenge("challenge 1", "description 1");
        testChallengesGroup = new ChallengesGroup(testChallenge);
    }

    @Test
    void testConstructor() {
        assertTrue(testChallengesGroup.getChallenges().isEmpty());
    }

    @Test
    void testAddChallenge() {
        Challenge challenge1 = new Challenge("name1", "description1");
        Challenge challenge2 = new Challenge("name2", "description2");
        Challenge challenge3 = new Challenge("name3", "description3");

        testChallengesGroup.addChallenge(challenge1);

        assertEquals(1, testChallengesGroup.getChallenges().size());
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(0));

        testChallengesGroup.addChallenge(challenge2);

        assertEquals(2, testChallengesGroup.getChallenges().size());
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(0));
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(1));

        testChallengesGroup.addChallenge(challenge3);

        assertEquals(3, testChallengesGroup.getChallenges().size());
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(0));
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(1));
        assertEquals(challenge3, testChallengesGroup.getChallenges().get(2));
    }

    @Test
    void testRemoveChallenge() {
        Challenge challenge1 = new Challenge("name1", "description1");
        Challenge challenge2 = new Challenge("name2", "description2");
        Challenge challenge3 = new Challenge("name3", "description3");

        testChallengesGroup.addChallenge(challenge1);
        testChallengesGroup.removeChallenge(challenge1);
        assertEquals(0, testChallengesGroup.getChallenges().size());

        testChallengesGroup.addChallenge(challenge1);
        testChallengesGroup.addChallenge(challenge2);
        testChallengesGroup.removeChallenge(challenge2);
        assertEquals(1, testChallengesGroup.getChallenges().size());
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(0));

        testChallengesGroup.addChallenge(challenge2);
        testChallengesGroup.removeChallenge(challenge1);
        assertEquals(1, testChallengesGroup.getChallenges().size());
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(0));

        testChallengesGroup.addChallenge(challenge1);
        testChallengesGroup.addChallenge(challenge3);
        testChallengesGroup.removeChallenge(challenge3);
        assertEquals(2, testChallengesGroup.getChallenges().size());
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(0));
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(1));

        testChallengesGroup.removeChallenge(challenge1);
        assertEquals(1, testChallengesGroup.getChallenges().size());
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(0));

        testChallengesGroup.removeChallenge(challenge2);
        assertEquals(0, testChallengesGroup.getChallenges().size());
    }

    @Test
    void testChangePosition () {
        Challenge challenge1 = new Challenge("name1", "description1");
        Challenge challenge2 = new Challenge("name2", "description2");
        Challenge challenge3 = new Challenge("name3", "description3");
        Challenge challenge4 = new Challenge("name4", "description4");

        testChallengesGroup.addChallenge(challenge1);
        testChallengesGroup.addChallenge(challenge2);
        testChallengesGroup.addChallenge(challenge3);
        testChallengesGroup.addChallenge(challenge4);

        testChallengesGroup.changePosition(0, 0);
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(0));
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(1));
        assertEquals(challenge3, testChallengesGroup.getChallenges().get(2));
        assertEquals(challenge4, testChallengesGroup.getChallenges().get(3));

        testChallengesGroup.changePosition(0, 1);
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(0));
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(1));
        assertEquals(challenge3, testChallengesGroup.getChallenges().get(2));
        assertEquals(challenge4, testChallengesGroup.getChallenges().get(3));

        testChallengesGroup.changePosition(0, 2);
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(0));
        assertEquals(challenge3, testChallengesGroup.getChallenges().get(1));
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(2));
        assertEquals(challenge4, testChallengesGroup.getChallenges().get(3));

        testChallengesGroup.changePosition(3, 1);
        assertEquals(challenge1, testChallengesGroup.getChallenges().get(0));
        assertEquals(challenge4, testChallengesGroup.getChallenges().get(1));
        assertEquals(challenge3, testChallengesGroup.getChallenges().get(2));
        assertEquals(challenge2, testChallengesGroup.getChallenges().get(3));
    }

    @Test
    void testAddChallengeToCheckedParent() {
        testChallenge.toggleCheck();

        Challenge challenge1 = new Challenge("name1", "description1");
        Challenge challenge2 = new Challenge("name2", "description2");
        Challenge challenge3 = new Challenge("name3", "description3");

        testChallengesGroup.addChallenge(challenge1);
        testChallengesGroup.addChallenge(challenge2);
        testChallengesGroup.addChallenge(challenge3);

        assertTrue(challenge1.isChecked());
        assertTrue(challenge2.isChecked());
        assertTrue(challenge3.isChecked());
    }
}
