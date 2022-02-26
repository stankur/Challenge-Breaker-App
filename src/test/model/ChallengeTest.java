package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChallengeTest {
    private Challenge testChallenge;

    @BeforeEach
    void runBefore() {
        testChallenge = new Challenge(
                "eat instant ramen", "strategy break-down to eating instant ramen"
        );
    }

    @Test
    void testConstructor() {
        assertEquals("eat instant ramen", testChallenge.getName());
        assertEquals("strategy break-down to eating instant ramen", testChallenge.getDescription());
        assertTrue(testChallenge.getElaboratedMiniChallenges().isEmpty());
    }

    @Test
    void testAddElaboratedMiniChallenge() {
        Challenge challenge1 = new Challenge("obtain", "buy the instant ramen");
        Challenge challenge2 = new Challenge("cook", "prepare the instant ramen for serving");
        Challenge challenge3 = new Challenge("consume", "eat the ramen");

        testChallenge.addElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));

        testChallenge.addElaboratedMiniChallenge(challenge2);
        assertEquals(2, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(1));

        testChallenge.addElaboratedMiniChallenge(challenge3);
        assertEquals(3, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().get(2));
    }

    @Test
    void testRemoveElaboratedMiniChallenge() {
        Challenge challenge1 = new Challenge("obtain", "buy the instant ramen");
        Challenge challenge2 = new Challenge("cook", "prepare the instant ramen for serving");
        Challenge challenge3 = new Challenge("consume", "eat the ramen");

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.removeElaboratedMiniChallenge(challenge1);
        assertEquals(0, testChallenge.getElaboratedMiniChallenges().size());

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.addElaboratedMiniChallenge(challenge2);
        testChallenge.removeElaboratedMiniChallenge(challenge2);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));

        testChallenge.addElaboratedMiniChallenge(challenge2);
        testChallenge.removeElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(0));

        testChallenge.addElaboratedMiniChallenge(challenge1);
        testChallenge.addElaboratedMiniChallenge(challenge3);
        testChallenge.removeElaboratedMiniChallenge(challenge3);
        assertEquals(2, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(1));

        testChallenge.removeElaboratedMiniChallenge(challenge1);
        assertEquals(1, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(0));

        testChallenge.removeElaboratedMiniChallenge(challenge2);
        assertEquals(0, testChallenge.getElaboratedMiniChallenges().size());
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
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().get(3));

        testChallenge.changePosition(0, 1);
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().get(3));

        testChallenge.changePosition(0, 2);
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().get(3));

        testChallenge.changePosition(3, 1);
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge4, testChallenge.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().get(2));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(3));
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

        assertEquals(3, testChallenge.getElaboratedMiniChallenges().size());
        assertEquals(challenge1, testChallenge.getElaboratedMiniChallenges().get(0));
        assertEquals(challenge2, testChallenge.getElaboratedMiniChallenges().get(1));
        assertEquals(challenge3, testChallenge.getElaboratedMiniChallenges().get(2));

    }


}