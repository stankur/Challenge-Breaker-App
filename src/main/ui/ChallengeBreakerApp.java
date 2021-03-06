// inspired by
// https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/master/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/ui/WorkRoomApp.java

package ui;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import model.Challenge;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// citation: inspired by the structure of TellerApp
// Challenge Breaker application
public class ChallengeBreakerApp {
    private static final String STORAGE = "./data/storage.json";

    private Challenge mainChallenge;
    private ArrayList<Challenge> visitedLayers;
    private Challenge currentChallenge;

    private Scanner input;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs Challenge Breaker application
    public ChallengeBreakerApp() {
        runChallengeBreaker();
    }

    // MODIFIES: this
    // EFFECTS: processes user's input
    private void runChallengeBreaker() {
        boolean running = true;

        init();

        System.out.println("Challenge Breaker is now running");
        displayHorizontalBreak();

        while (running) {
            onChallengeViewing(currentChallenge);

            String command = input.nextLine();
            if (command.equals("q")) {
                running = false;
            } else {
                processCommand(command);
            }
            displayHorizontalBreak();
        }

        System.out.println("before quiting, would you like to save challenge?\n\n");
        System.out.println("press y to save or any other key to exit\n");

        String command = input.nextLine();

        if (command.equals("y")) {
            save(this.mainChallenge);
        }

        System.out.println("thank you for using Challenge Breaker");
    }

    // MODIFIES: this
    // EFFECTS: initializes challenge app
    private void init() {
        mainChallenge = new Challenge(
                "template challenge",
                "template description"
        );
        visitedLayers = new ArrayList<>();
        currentChallenge = mainChallenge;
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(STORAGE);
        jsonReader = new JsonReader(STORAGE);
    }

    // EFFECTS: displays challenge information and user's options
    private void onChallengeViewing(Challenge challenge) {
        displayChallengeInfo(challenge);
        displayChallengeOptions();
    }

    // EFFECTS: displays challenge info
    private void displayChallengeInfo(Challenge challenge) {
        String name = challenge.getName();
        String description = challenge.getDescription();
        boolean isChecked = challenge.isChecked();
        System.out.println("challenge information \n");
        System.out.println("challenge name: " + name);
        System.out.println("challenge description: " + description);
        System.out.println("challenge completed? " + isChecked + "\n");
        System.out.println("elaboration: \n");
        displayMiniElaboratedChallenges(challenge);
        displayHorizontalBreak();
    }

    // EFFECTS: displays horizontal break
    private void displayHorizontalBreak() {
        System.out.println("------------------------------------------------------------------");
    }

    // EFFECTS: displays mini elaborated challenges of given challenge sequentially
    private void displayMiniElaboratedChallenges(Challenge challenge) {
        int counter = 1;

        for (Challenge miniElaboratedChallenge : challenge.getElaboratedMiniChallenges().getChallenges()) {
            System.out.println(counter);
            System.out.println("name: " + miniElaboratedChallenge.getName());
            System.out.println("description: " + miniElaboratedChallenge.getDescription());
            System.out.println("completed? " + miniElaboratedChallenge.isChecked() + "\n");

            counter++;
        }
    }

    // EFFECTS: displays challenge options
    private void displayChallengeOptions() {
        System.out.println("enter: \n");
        System.out.println("q to quit Challenge Breaker");
        System.out.println("s to save challenge");
        System.out.println("l to load last saved challenge\n");

        System.out.println("n to edit challenge name");
        System.out.println("d to edit challenge description");
        System.out.println("c to toggle completion\n");

        System.out.println("a to add an elaborated mini challenge");
        System.out.println("r to remove an elaborated mini challenge");
        System.out.println("m to rearrange elaborated mini challenges");
        System.out.println("i to step into an elaborated mini challenge\n");

        System.out.println("e to exit from current challenge\n");
        displayHorizontalBreak();
    }

    // MODIFIES: this
    // EFFECTS: processes user's command and give appropriate responses
    private void processCommand(String command) {
        if (command.equals("s")) {
            save(mainChallenge);
        } else if (command.equals("l")) {
            load();
        } else if (command.equals("n")) {
            onNameEditRequest(currentChallenge);
        } else if (command.equals("d")) {
            onDescriptionEditRequest(currentChallenge);
        } else if (command.equals("c")) {
            onToggleCheckRequest(currentChallenge);
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
            System.out.println("invalid command!");
        }
    }

    // EFFECTS: saves challenge to STORAGE
    private void save(Challenge challenge) {
        try {
            jsonWriter.open();
            jsonWriter.write(challenge);
            jsonWriter.close();
            System.out.println("Saved challenge to " + STORAGE);
        } catch (FileNotFoundException e) {
            System.out.println(STORAGE + " not found");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads main challenge from file
    private void load() {
        try {
            this.mainChallenge = jsonReader.read();
            System.out.println("Loaded challenge from " + STORAGE);

            currentChallenge = this.mainChallenge;
            visitedLayers = new ArrayList<>();
        } catch (IOException e) {
            System.out.println(STORAGE + " not found");
        }
    }

    // MODIFIES: challenge
    // EFFECTS: toggles challenge's checked value
    private void onToggleCheckRequest(Challenge challenge) {
        System.out.println("before: completed?: " + challenge.isChecked());
        challenge.toggleCheck();
        System.out.println("now: completed?: " + challenge.isChecked());

    }

    // MODIFIES: challenge
    // EFFECTS: sets given challenge's name to input given by user
    private void onNameEditRequest(Challenge challenge) {
        System.out.println("current name: " + challenge.getName());
        System.out.println("please enter the new name.");
        String newName = input.nextLine();
        challenge.editName(newName);
        System.out.println("name changed to " + challenge.getName() + "\n");
    }

    // MODIFIES: challenge
    // EFFECTS: sets given challenge's description to input given by user
    private void onDescriptionEditRequest(Challenge challenge) {
        System.out.println("current description: " + challenge.getDescription());
        System.out.println("please enter the new description");
        String newDesc = input.nextLine();
        challenge.editDescription(newDesc);
        System.out.println("description changed to " + challenge.getDescription() + "\n");
    }

    // MODIFIES: challenge
    // EFFECTS: adds a new elaborated mini challenge with name and description provided by user to given challenge
    private void onAddRequest(Challenge challenge) {
        System.out.println("please enter the name of the challenge that you would like to add");
        String newChallengeName = input.nextLine();

        System.out.println("please enter the description of the challenge that you would like to add");
        String newChallengeDescription = input.nextLine();

        Challenge newChallenge = new Challenge(newChallengeName, newChallengeDescription);
        challenge.addElaboratedMiniChallenge(newChallenge);

        System.out.println("challenge added\n");
        System.out.println("new mini elaborated challenges: \n");
        displayMiniElaboratedChallenges(challenge);
    }

    // EFFECTS: checks if index is out of range
    private boolean isIndexInvalid(int index, int maxIndex) {
        return (index > maxIndex) || (index < 0);
    }

    // MODIFIES: challenge
    // EFFECTS: removes an elaborated mini challenge of index specified by user from given challenge if exists
    // otherwise displays out of range message
    private void onRemoveRequest(Challenge challenge) {
        System.out.println("current mini elaborated challenges: \n");
        displayMiniElaboratedChallenges(challenge);
        System.out.println("\nplease enter the number of the challenge to be removed");

        int toBeRemoved = Integer.parseInt(input.nextLine());
        int toBeRemovedIndex = toBeRemoved - 1;

        int maxIndex = challenge.getElaboratedMiniChallenges().getChallenges().size() - 1;

        if (isIndexInvalid(toBeRemovedIndex, maxIndex)) {
            System.out.println("number entered is out of range");
        } else {
            Challenge challengeToBeRemoved = challenge.getElaboratedMiniChallenges()
                    .getChallenges().get(toBeRemovedIndex);
            challenge.removeElaboratedMiniChallenge(challengeToBeRemoved);

            System.out.println("challenge removed\n");
            System.out.println("new mini elaborated challenges: \n");
            displayMiniElaboratedChallenges(challenge);
        }
    }

    // MODIFIES: challenge
    // EFFECTS: moves an elaborated mini challenge from a position specified by user to a position specified by user
    // if valid otherwise displays out of range message
    private void onMoveRequest(Challenge challenge) {
        System.out.println("current mini elaborated challenges: \n");
        displayMiniElaboratedChallenges(challenge);

        System.out.println("\nplease enter the number of the challenge to be moved");
        int oldPosition = Integer.parseInt(input.nextLine());
        int oldIndex = oldPosition - 1;

        System.out.println("please enter the number for the challenge to be moved to");
        int newPosition = Integer.parseInt(input.nextLine());
        int newIndex = newPosition - 1;

        int maxIndex = challenge.getElaboratedMiniChallenges().getChallenges().size() - 1;

        if (isIndexInvalid(oldIndex, maxIndex) && isIndexInvalid(newIndex, maxIndex)) {
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
    private void onStepInRequest() {
        System.out.println("current mini elaborated : \n");
        displayMiniElaboratedChallenges(this.currentChallenge);
        System.out.println("\nplease enter the number of the challenge to step into");

        int selectedPosition = Integer.parseInt(input.nextLine());
        int selectedIndex = selectedPosition - 1;
        int maxIndex = this.currentChallenge.getElaboratedMiniChallenges().getChallenges().size() - 1;

        if (isIndexInvalid(selectedIndex, maxIndex)) {
            System.out.println("\nnumber entered is out of range");
        } else {
            this.visitedLayers.add(this.currentChallenge);
            this.currentChallenge = this.currentChallenge.getElaboratedMiniChallenges()
                    .getChallenges().get(selectedIndex);

            System.out.println("\ncurrent challenge: " + this.currentChallenge.getName());
        }
    }

    // MODIFIES: this
    // EFFECTS: sets currentLayer to direct outer layer of current challenge and removes last element of
    // visited layers if exists otherwise displays could not exit further message
    private void onExitRequest() {
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
