package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChallengeNodeTest {
    private ChallengeNode testChallengeNode;

    @BeforeEach
    void runBefore() {
        testChallengeNode = new ChallengeNode(
                "eat instant ramen", "strategy break-down to eating instant ramen"
        );
    }

    @Test
    void testConstructor() {
        assertEquals("eat instant ramen", testChallengeNode.getName());
        assertEquals("strategy break-down to eating instant ramen", testChallengeNode.getDescription());
        assertTrue(testChallengeNode.getElaboratedMiniChallenges().isEmpty());
    }

    @Test
    void testAddElaboratedMiniChallenge() {
        ChallengeNode challenge1 = new ChallengeNode("obtain", "buy the instant ramen");
        ChallengeNode challenge2 = new ChallengeNode("cook", "prepare the instant ramen for serving");
        ChallengeNode challenge3 = new ChallengeNode("consume", "eat the ramen");

        testChallengeNode.addElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));

        testChallengeNode.addElaboratedMiniChallenge(challenge2);
        assertEquals(2, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(1));

        testChallengeNode.addElaboratedMiniChallenge(challenge3);
        assertEquals(3, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallengeNode.getElaboratedMiniChallenges().get(2));
    }

    @Test
    void testRemoveElaboratedMiniChallenge() {
        ChallengeNode challenge1 = new ChallengeNode("obtain", "buy the instant ramen");
        ChallengeNode challenge2 = new ChallengeNode("cook", "prepare the instant ramen for serving");
        ChallengeNode challenge3 = new ChallengeNode("consume", "eat the ramen");

        testChallengeNode.addElaboratedMiniChallenge(challenge1);
        testChallengeNode.removeElaboratedMiniChallenge(challenge1);
        assertEquals(0, testChallengeNode.getElaboratedMiniChallenges().size());

        testChallengeNode.addElaboratedMiniChallenge(challenge1);
        testChallengeNode.addElaboratedMiniChallenge(challenge2);
        testChallengeNode.removeElaboratedMiniChallenge(challenge2);
        assertEquals(1, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));

        testChallengeNode.addElaboratedMiniChallenge(challenge2);
        testChallengeNode.removeElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(0));

        testChallengeNode.addElaboratedMiniChallenge(challenge1);
        testChallengeNode.addElaboratedMiniChallenge(challenge3);
        testChallengeNode.removeElaboratedMiniChallenge(challenge3);
        assertEquals(2, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(1));

        testChallengeNode.removeElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(0));

        testChallengeNode.removeElaboratedMiniChallenge(challenge2);
        assertEquals(0, testChallengeNode.getElaboratedMiniChallenges().size());
    }

    @Test
    void testChangePosition() {
        ChallengeNode challenge1 = new ChallengeNode("obtain", "buy the instant ramen");
        ChallengeNode challenge2 = new ChallengeNode("cook", "prepare the instant ramen for serving");
        ChallengeNode challenge3 = new ChallengeNode("consume", "eat the ramen");
        ChallengeNode challenge4 = new ChallengeNode("dummy", "some dummy");

        testChallengeNode.addElaboratedMiniChallenge(challenge1);
        testChallengeNode.addElaboratedMiniChallenge(challenge2);
        testChallengeNode.addElaboratedMiniChallenge(challenge3);
        testChallengeNode.addElaboratedMiniChallenge(challenge4);

        testChallengeNode.changePosition(0, 0);
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallengeNode.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge4, testChallengeNode.getElaboratedMiniChallenges().get(3));

        testChallengeNode.changePosition(0, 1);
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallengeNode.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge4, testChallengeNode.getElaboratedMiniChallenges().get(3));

        testChallengeNode.changePosition(0, 2);
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge3, testChallengeNode.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge4, testChallengeNode.getElaboratedMiniChallenges().get(3));

        testChallengeNode.changePosition(3, 1);
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge4, testChallengeNode.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallengeNode.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(3));
    }

    @Test
    void testEditName() {
        testChallengeNode.editName("create cpsc 210 project");
        assertEquals("create cpsc 210 project", testChallengeNode.getName());

        testChallengeNode.editName("sleep 8 hours in 1 hour");
        assertEquals("sleep 8 hours in 1 hour", testChallengeNode.getName());
    }

    @Test
    void testEditDescription() {
        testChallengeNode.editDescription("guide to survive through the last days of the month");
        assertEquals(
                "guide to survive through the last days of the month", testChallengeNode.getDescription()
        );

        testChallengeNode.editDescription("lorem ipsum");
        assertEquals("lorem ipsum", testChallengeNode.getDescription());
    }

    @Test
    void testGetName() {
        assertEquals("eat instant ramen" ,testChallengeNode.getName());
    }

    @Test
    void testGetDescription() {
        assertEquals("strategy break-down to eating instant ramen", testChallengeNode.getDescription());
    }

    @Test
    void testGetElaboratedMiniChallenges() {
        ChallengeNode challenge1 = new ChallengeNode("obtain", "buy the instant ramen");
        ChallengeNode challenge2 = new ChallengeNode("cook", "prepare the instant ramen for serving");
        ChallengeNode challenge3 = new ChallengeNode("consume", "eat the ramen");

        testChallengeNode.addElaboratedMiniChallenge(challenge1);
        testChallengeNode.addElaboratedMiniChallenge(challenge2);
        testChallengeNode.addElaboratedMiniChallenge(challenge3);

        assertEquals(3, testChallengeNode.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallengeNode.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallengeNode.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallengeNode.getElaboratedMiniChallenges().get(2));

    }


}