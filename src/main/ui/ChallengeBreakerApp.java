package ui;

import model.ChallengeNode;

import java.util.ArrayList;
import java.util.Scanner;

// Challenge Breaker application
public class ChallengeBreakerApp {
    private ArrayList<ChallengeNode> visitedLayers;
    private ChallengeNode currentChallenge;
    private Scanner input;

    // EFFECTS: runs Challenge Breaker application
    public ChallengeBreakerApp() {
        runChallengeBreaker();
    }

    // MODIFIES: this
    void runChallengeBreaker() {
        boolean running = true;

        init();

        System.out.println("Challenge Breaker is now running");
        System.out.println("to quit, enter \"q\"");
        displayHorizontalBreak();

        while (running) {
            onChallengeNodeViewing(currentChallenge);

            String command = input.nextLine();
            if (command.equals("q")) {
                running = false;
            } else {
                processCommand(command);
            }
            displayHorizontalBreak();
        }

        System.out.println("thank you for using Challenge Breaker");
    }

    // MODIFIES: this
    // EFFECTS: initializes Challenge
    void init() {
        ChallengeNode templateChallenge = new ChallengeNode(
                "template challenge",
                "template description"
        );
        visitedLayers = new ArrayList<>();
        currentChallenge = templateChallenge;
        input = new Scanner(System.in);
    }

    // EFFECTS: displays challenge information and user's options
    void onChallengeNodeViewing(ChallengeNode challenge) {
        displayChallengeNodeInfo(challenge);
        displayChallengeNodeOptions();
    }

    // EFFECTS: displays challenge node info
    void displayChallengeNodeInfo(ChallengeNode challenge) {
        String name = challenge.getName();
        String description = challenge.getDescription();
        System.out.println("challenge information \n");
        System.out.println("challenge name: " + name);
        System.out.println("challenge description: " + description + "\n");
        System.out.println("elaboration: \n");
        displayMiniElaboratedChallenges(challenge);
        displayHorizontalBreak();
    }

    // EFFECTS: displays horizontal break
    void displayHorizontalBreak() {
        System.out.println("------------------------------------------------------------------");
    }

    // EFFECTS: displays mini elaborated challenges of given challenge sequentially
    private void displayMiniElaboratedChallenges(ChallengeNode challenge) {
        int counter = 1;

        for (ChallengeNode miniElaboratedChallenge : challenge.getElaboratedMiniChallenges()) {
            System.out.println(counter);
            System.out.println("name: " + miniElaboratedChallenge.getName());
            System.out.println("description: " + miniElaboratedChallenge.getDescription() + "\n");

            counter++;
        }
    }

    // EFFECTS: displays challenge node options
    void displayChallengeNodeOptions() {
        System.out.println("enter: \n");
        System.out.println("n to edit challenge name");
        System.out.println("d to edit challenge description\n");
        System.out.println("a to add an elaborated mini challenge");
        System.out.println("r to remove an elaborated mini challenge");
        System.out.println("m to rearrange elaborated mini challenges");
        System.out.println("i to step into an elaborated mini challenge\n");
        System.out.println("e to exit from current challenge\n");
        displayHorizontalBreak();
    }

    // MODIFIES: this
    // EFFECTS: reads user's command and give appropriate responses
    void processCommand(String command) {
        if (command.equals("n")) {
            onNameEditRequest(currentChallenge);
        } else if (command.equals("d")) {
            onDescriptionEditRequest(currentChallenge);
        } else if (command.equals("a")) {
            onAddRequest(currentChallenge);
        } else if (command.equals("r")) {
            onRemoveRequest(currentChallenge);
        } else if (command.equals("m")) {
            onMoveRequest(currentChallenge);
        } else if (command.equals("i")) {
            onStepInRequest();
        } else if (command.equals("e")) {
            onExitRequest();
        } else {
            System.out.println("invalid comment! Naughty user >:(");
        }
    }

    // MODIFIES: challenge
    // EFFECTS: sets given challenge's name to input given by user
    void onNameEditRequest(ChallengeNode challenge) {
        System.out.println("current name: " + challenge.getName());
        System.out.println("please enter the new name.");
        String newName = input.nextLine();
        challenge.editName(newName);
        System.out.println("name changed to " + challenge.getName() + "\n");
    }

    // MODIFIES: challenge
    // EFFECTS: sets given challenge's description to input given by user
    void onDescriptionEditRequest(ChallengeNode challenge) {
        System.out.println("current description: " + challenge.getDescription());
        System.out.println("please enter the new description");
        String newDesc = input.nextLine();
        challenge.editDescription(newDesc);
        System.out.println("description changed to " + challenge.getDescription() + "\n");
    }

    // MODIFIES: challenge
    // EFFECTS: adds a new elaborated mini challenge with name and description provided by user to given challenge
    void onAddRequest(ChallengeNode challenge) {
        System.out.println("please enter the name of the challenge that you would like to add");
        String newChallengeName = input.nextLine();

        System.out.println("please enter the description of the challenge that you would like to add");
        String newChallengeDescription = input.nextLine();

        ChallengeNode newChallenge = new ChallengeNode(newChallengeName, newChallengeDescription);
        challenge.addElaboratedMiniChallenge(newChallenge);

        System.out.println("challenge added\n");
        System.out.println("new mini elaborated challenges: \n");
        displayMiniElaboratedChallenges(challenge);
    }

    // MODIFIES: challenge
    // EFFECTS: removes an elaborated mini challenge of index specified by user from given challenge if exists
    // otherwise displays out of range message
    void onRemoveRequest(ChallengeNode challenge) {
        System.out.println("current mini elaborated challenges: \n");
        displayMiniElaboratedChallenges(challenge);
        System.out.println("\nplease enter the number of the challenge to be removed");

        int toBeRemoved = Integer.parseInt(input.nextLine());
        int toBeRemovedIndex = toBeRemoved - 1;

        int maxIndex = challenge.getElaboratedMiniChallenges().size() - 1;

        if (toBeRemovedIndex > maxIndex || toBeRemovedIndex < 0) {
            System.out.println("number entered is out of range");
        } else {
            ChallengeNode challengeToBeRemoved = challenge.getElaboratedMiniChallenges().get(toBeRemovedIndex);
            challenge.removeElaboratedMiniChallenge(challengeToBeRemoved);

            System.out.println("challenge removed\n");
            System.out.println("new mini elaborated challenges: \n");
            displayMiniElaboratedChallenges(challenge);
        }
    }

    // MODIFIES: challenge
    // EFFECTS: moves an elaborated mini challenge from a position specified by user to a position specified by user
    // or displays out of range message
    void onMoveRequest(ChallengeNode challenge) {
        System.out.println("current mini elaborated challenges: \n");
        displayMiniElaboratedChallenges(challenge);

        System.out.println("\nplease enter the number of the challenge to be moved");
        int oldPosition = Integer.parseInt(input.nextLine());
        int oldIndex = oldPosition - 1;

        System.out.println("please enter the number for the challenge to be moved to");
        int newPosition = Integer.parseInt(input.nextLine());
        int newIndex = newPosition - 1;

        int maxIndex = challenge.getElaboratedMiniChallenges().size() - 1;

        if (oldIndex > maxIndex || newIndex > maxIndex
                || oldIndex < 0 || newIndex < 0) {
            System.out.println("at least on of the numbers entered is out of range");
        } else {
            challenge.changePosition(oldIndex, newIndex);

            System.out.println("challenge moved\n");
            System.out.println("new mini elaborated challenges: \n");
            displayMiniElaboratedChallenges(challenge);
        }
    }

    // MODIFIES: this
    // EFFECTS: adds current challenge to visited layer and make the challenge specified by user to be current challenge
    void onStepInRequest() {
        System.out.println("current mini elaborated : \n");
        displayMiniElaboratedChallenges(this.currentChallenge);
        System.out.println("\nplease enter the number of the challenge to step into");

        int selectedPosition = Integer.parseInt(input.nextLine());
        int selectedIndex = selectedPosition - 1;
        int maxIndex = this.currentChallenge.getElaboratedMiniChallenges().size() - 1;

        if (selectedIndex > maxIndex || selectedIndex < 0) {
            System.out.println("\nnumber entered is out of range");
        } else {
            this.visitedLayers.add(this.currentChallenge);
            this.currentChallenge = this.currentChallenge.getElaboratedMiniChallenges().get(selectedIndex);

            System.out.println("\ncurrent challenge: " + this.currentChallenge.getName());
        }
    }

    // MODIFIES: this
    // EFFECTS: sets currentLayer to direct outer layer of current challenge and removes last element of
    // visited layers if exists otherwise displays could not exit further message
    void onExitRequest() {
        int lastIndex = this.visitedLayers.size() - 1;

        if (lastIndex < 0) {
            System.out.println("this is the outermost branch; could not exit further");
        } else {
            lastIndex = this.visitedLayers.size() - 1;
            this.currentChallenge = this.visitedLayers.get(lastIndex);
            this.visitedLayers.remove(lastIndex);
        }
    }

}
