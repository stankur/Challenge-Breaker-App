package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ChallengeTest {
    private Challenge testChallenge;

    private Challenge testChallengeTree;
    private Challenge testChallengeTree0;
    private Challenge testChallengeTree1;
    private Challenge testChallengeTree2;
    private Challenge testChallengeTree00;
    private Challenge testChallengeTree01;
    private Challenge testChallengeTree02;
    private Challenge testChallengeTree10;
    private Challenge testChallengeTree11;
    private Challenge testChallengeTree12;
    private Challenge testChallengeTree20;
    private Challenge testChallengeTree21;
    private Challenge testChallengeTree000;
    private Challenge testChallengeTree001;

    @BeforeEach
    void runBefore() {
        testChallenge = new Challenge(
                "eat instant ramen", "strategy break-down to eating instant ramen"
        );

        testChallengeTree = new Challenge("name", "description");
        testChallengeTree0 = new Challenge("name0", "description0");
        testChallengeTree1 = new Challenge("name1", "description1");
        testChallengeTree2 = new Challenge("name2", "description2");
        testChallengeTree00 = new Challenge("name00", "description00");
        testChallengeTree01 = new Challenge("name01", "description01");
        testChallengeTree02 = new Challenge("name02", "description02");
        testChallengeTree10 = new Challenge("name10", "description10");
        testChallengeTree11 = new Challenge("name11", "description11");
        testChallengeTree12 = new Challenge("name12", "description12");
        testChallengeTree20 = new Challenge("name20", "description20");
        testChallengeTree21 = new Challenge("name21", "description21");
        testChallengeTree000 = new Challenge("name000", "description000");
        testChallengeTree001 = new Challenge("name001", "description001");

        testChallengeTree.addElaboratedMiniChallenge(testChallengeTree0);
        testChallengeTree.addElaboratedMiniChallenge(testChallengeTree1);
        testChallengeTree.addElaboratedMiniChallenge(testChallengeTree2);
        testChallengeTree0.addElaboratedMiniChallenge(testChallengeTree00);
        testChallengeTree0.addElaboratedMiniChallenge(testChallengeTree01);
        testChallengeTree0.addElaboratedMiniChallenge(testChallengeTree02);
        testChallengeTree1.addElaboratedMiniChallenge(testChallengeTree10);
        testChallengeTree1.addElaboratedMiniChallenge(testChallengeTree11);
        testChallengeTree1.addElaboratedMiniChallenge(testChallengeTree12);
        testChallengeTree2.addElaboratedMiniChallenge(testChallengeTree20);
        testChallengeTree2.addElaboratedMiniChallenge(testChallengeTree21);
        testChallengeTree00.addElaboratedMiniChallenge(testChallengeTree000);
        testChallengeTree00.addElaboratedMiniChallenge(testChallengeTree001);
    }

    @Test
    void testConstructor() {
        assertEquals("eat instant ramen", testChallenge.getName());
        assertEquals("strategy break-down to eating instant ramen", testChallenge.getDescription());
        assertTrue(testChallenge.getElaboratedMiniChallenges().getChallenges().isEmpty());
        assertFalse(testChallenge.isChecked());
        assertTrue(Objects.isNull(testChallenge.getChallengesGroup()));
        assertEquals(testChallenge, testChallenge.getElaboratedMiniChallenges().getParentChallenge());
    }

    @Test
    void testAddElaboratedMiniChallenge() {
        Challenge challenge1 = new Challenge("obtain", "buy the instant ramen");
        Challenge challenge2 = new Challenge("cook", "prepare the instant ramen for serving");
        Challenge challenge3 = new Challenge("consume", "eat the ramen");

        testChallenge.addElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));

        testChallenge.addElaboratedMiniChallenge(challenge2);
        assertEquals(2, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));

        testChallenge.addElaboratedMiniChallenge(challenge3);
        assertEquals(3, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().getChallenges().get(2));
    }

    @Test
    void testRemoveElaboratedMiniChallenge() {
        Challenge challenge1 = new Challenge("obtain", "buy the instant ramen");
        Challenge challenge2 = new Challenge("cook", "prepare the instant ramen for serving");
        Challenge challenge3 = new Challenge("consume", "eat the ramen");

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.removeElaboratedMiniChallenge(challenge1);
        assertEquals(0, testChallenge.getElaboratedMiniChallenges().getChallenges().size());

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.addElaboratedMiniChallenge(challenge2);
        testChallenge.removeElaboratedMiniChallenge(challenge2);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));

        testChallenge.addElaboratedMiniChallenge(challenge2);
        testChallenge.removeElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.addElaboratedMiniChallenge(challenge3);
        testChallenge.removeElaboratedMiniChallenge(challenge3);
        assertEquals(2, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));

        testChallenge.removeElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));

        testChallenge.removeElaboratedMiniChallenge(challenge2);
        assertEquals(0, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
    }

    @Test
    void testChangePosition() {
        Challenge challenge1 = new Challenge("obtain", "buy the instant ramen");
        Challenge challenge2 = new Challenge("cook", "prepare the instant ramen for serving");
        Challenge challenge3 = new Challenge("consume", "eat the ramen");
        Challenge challenge4 = new Challenge("dummy", "some dummy");

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.addElaboratedMiniChallenge(challenge2);
        testChallenge.addElaboratedMiniChallenge(challenge3);
        testChallenge.addElaboratedMiniChallenge(challenge4);

        testChallenge.changePosition(0, 0);
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().getChallenges().get(2));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().getChallenges().get(3));

        testChallenge.changePosition(0, 1);
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().getChallenges().get(2));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().getChallenges().get(3));

        testChallenge.changePosition(0, 2);
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(2));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().getChallenges().get(3));

        testChallenge.changePosition(3, 1);
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().getChallenges().get(2));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(3));
    }

    @Test
    void testEditName() {
        testChallenge.editName("create cpsc 210 project");
        assertEquals("create cpsc 210 project", testChallenge.getName());

        testChallenge.editName("sleep 8 hours in 1 hour");
        assertEquals("sleep 8 hours in 1 hour", testChallenge.getName());
    }

    @Test
    void testEditDescription() {
        testChallenge.editDescription("guide to survive through the last days of the month");
        assertEquals(
                "guide to survive through the last days of the month", testChallenge.getDescription()
        );

        testChallenge.editDescription("lorem ipsum");
        assertEquals("lorem ipsum", testChallenge.getDescription());
    }

    @Test
    void testGetName() {
        assertEquals("eat instant ramen" , testChallenge.getName());
    }

    @Test
    void testGetDescription() {
        assertEquals("strategy break-down to eating instant ramen", testChallenge.getDescription());
    }

    @Test
    void testGetElaboratedMiniChallenges() {
        Challenge challenge1 = new Challenge("obtain", "buy the instant ramen");
        Challenge challenge2 = new Challenge("cook", "prepare the instant ramen for serving");
        Challenge challenge3 = new Challenge("consume", "eat the ramen");

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.addElaboratedMiniChallenge(challenge2);
        testChallenge.addElaboratedMiniChallenge(challenge3);

        assertEquals(3, testChallenge.getElaboratedMiniChallenges().getChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().getChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().getChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().getChallenges().get(2));
    }

    @Test
    void testToggleCheckRoot() {
        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertFalse(testChallengeTree001.isChecked());

        testChallengeTree.toggleCheck();

        assertTrue(testChallengeTree.isChecked());
        assertTrue(testChallengeTree0.isChecked());
        assertTrue(testChallengeTree1.isChecked());
        assertTrue(testChallengeTree2.isChecked());
        assertTrue(testChallengeTree00.isChecked());
        assertTrue(testChallengeTree01.isChecked());
        assertTrue(testChallengeTree02.isChecked());
        assertTrue(testChallengeTree10.isChecked());
        assertTrue(testChallengeTree11.isChecked());
        assertTrue(testChallengeTree12.isChecked());
        assertTrue(testChallengeTree20.isChecked());
        assertTrue(testChallengeTree21.isChecked());
        assertTrue(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());

        testChallengeTree.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertFalse(testChallengeTree001.isChecked());
    }

    @Test
    void testToggleLeaf() {
        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertFalse(testChallengeTree001.isChecked());

        testChallengeTree001.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());

        testChallengeTree001.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertFalse(testChallengeTree001.isChecked());
    }

    @Test
    void testToggleMid() {
        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertFalse(testChallengeTree001.isChecked());

        testChallengeTree00.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertTrue(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertTrue(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());

        testChallengeTree00.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertFalse(testChallengeTree001.isChecked());
    }

    @Test
    void testCheckAllMiniChallengesChecksParent() {
        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertFalse(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertFalse(testChallengeTree001.isChecked());

        testChallengeTree00.toggleCheck();
        testChallengeTree01.toggleCheck();
        testChallengeTree02.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertTrue(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertTrue(testChallengeTree00.isChecked());
        assertTrue(testChallengeTree01.isChecked());
        assertTrue(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertTrue(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());
    }

    @Test
    void testCheckAllMiniChallengesChecksMultipleLayersParents() {
        testChallengeTree001.toggleCheck();
        testChallengeTree01.toggleCheck();
        testChallengeTree02.toggleCheck();
        testChallengeTree1.toggleCheck();
        testChallengeTree2.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertTrue(testChallengeTree1.isChecked());
        assertTrue(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertTrue(testChallengeTree01.isChecked());
        assertTrue(testChallengeTree02.isChecked());
        assertTrue(testChallengeTree10.isChecked());
        assertTrue(testChallengeTree11.isChecked());
        assertTrue(testChallengeTree12.isChecked());
        assertTrue(testChallengeTree20.isChecked());
        assertTrue(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());

        testChallengeTree000.toggleCheck();

        assertTrue(testChallengeTree.isChecked());
        assertTrue(testChallengeTree0.isChecked());
        assertTrue(testChallengeTree1.isChecked());
        assertTrue(testChallengeTree2.isChecked());
        assertTrue(testChallengeTree00.isChecked());
        assertTrue(testChallengeTree01.isChecked());
        assertTrue(testChallengeTree02.isChecked());
        assertTrue(testChallengeTree10.isChecked());
        assertTrue(testChallengeTree11.isChecked());
        assertTrue(testChallengeTree12.isChecked());
        assertTrue(testChallengeTree20.isChecked());
        assertTrue(testChallengeTree21.isChecked());
        assertTrue(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());


    }

    @Test
    void testUncheckChallengeInAllCheckedCGUnchecksParent() {
        testChallengeTree00.toggleCheck();
        testChallengeTree01.toggleCheck();
        testChallengeTree02.toggleCheck();

        testChallengeTree02.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertFalse(testChallengeTree1.isChecked());
        assertFalse(testChallengeTree2.isChecked());
        assertTrue(testChallengeTree00.isChecked());
        assertTrue(testChallengeTree01.isChecked());
        assertFalse(testChallengeTree02.isChecked());
        assertFalse(testChallengeTree10.isChecked());
        assertFalse(testChallengeTree11.isChecked());
        assertFalse(testChallengeTree12.isChecked());
        assertFalse(testChallengeTree20.isChecked());
        assertFalse(testChallengeTree21.isChecked());
        assertTrue(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());
    }

    @Test
    void testUncheckChallengeUnchecksMultipleParentLayers() {
        testChallengeTree.toggleCheck();

        assertTrue(testChallengeTree.isChecked());
        assertTrue(testChallengeTree0.isChecked());
        assertTrue(testChallengeTree1.isChecked());
        assertTrue(testChallengeTree2.isChecked());
        assertTrue(testChallengeTree00.isChecked());
        assertTrue(testChallengeTree01.isChecked());
        assertTrue(testChallengeTree02.isChecked());
        assertTrue(testChallengeTree10.isChecked());
        assertTrue(testChallengeTree11.isChecked());
        assertTrue(testChallengeTree12.isChecked());
        assertTrue(testChallengeTree20.isChecked());
        assertTrue(testChallengeTree21.isChecked());
        assertTrue(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());

        testChallengeTree000.toggleCheck();

        assertFalse(testChallengeTree.isChecked());
        assertFalse(testChallengeTree0.isChecked());
        assertTrue(testChallengeTree1.isChecked());
        assertTrue(testChallengeTree2.isChecked());
        assertFalse(testChallengeTree00.isChecked());
        assertTrue(testChallengeTree01.isChecked());
        assertTrue(testChallengeTree02.isChecked());
        assertTrue(testChallengeTree10.isChecked());
        assertTrue(testChallengeTree11.isChecked());
        assertTrue(testChallengeTree12.isChecked());
        assertTrue(testChallengeTree20.isChecked());
        assertTrue(testChallengeTree21.isChecked());
        assertFalse(testChallengeTree000.isChecked());
        assertTrue(testChallengeTree001.isChecked());
    }

}