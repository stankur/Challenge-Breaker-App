// inspired by:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/blob/master/src/main/persistence/JsonReader.java

package persistence;

import model.Challenge;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


import model.ChallengesGroup;
import org.json.*;

// Represents a reader that reads challenge from JSON data stored in file
public class JsonReader {
    String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads challenge from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Challenge read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseChallengeRoot(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // REQUIRES: challenge must be root
    // EFFECTS: returns parsed challenge from a given JSONObject
    private Challenge parseChallengeRoot(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String description = jsonObject.getString("description");

        Challenge challenge = new Challenge(name, description);

        try {
            JSONArray jsonArray = jsonObject.getJSONArray("elaboratedMiniChallenges");
            addChallenges(challenge, jsonArray);
        } catch (JSONException e) {
            if (jsonObject.getBoolean("checked")) {
                challenge.toggleCheck();
            }
        }

        return challenge;

    }

    // REQUIRES: challenge must be part of a challenge group (not root of tree)
    // EFFECTS: returns parsed challenge from a given JSONObject
    private Challenge parseChallenge(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String description = jsonObject.getString("description");

        Challenge challenge = new Challenge(name, description);

        try {
            JSONArray jsonArray = jsonObject.getJSONArray("elaboratedMiniChallenges");
            addChallenges(challenge, jsonArray);
        } catch (JSONException e) {
            // challenge doesn't have elaborated mini challenges so does nothing
        }

        return challenge;
    }

    // REQUIRES: jsonArray given must consist of jsonObjects representing challenges
    // MODIFIES: challenge
    // EFFECTS: adds challenges parsed from jsonArray to given challenge
    private void addChallenges(Challenge challenge, JSONArray jsonArray) {
        for (Object jsonObject : jsonArray) {
            challenge.addElaboratedMiniChallenge(parseChallenge((JSONObject) jsonObject));
        }


        int elaboratedMiniChallengesLength = challenge.getElaboratedMiniChallenges().getChallenges().size();
        for (int i = 0; i < elaboratedMiniChallengesLength; i++) {
            boolean checked = ((JSONObject) jsonArray.get(i)).getBoolean("checked");

            if (checked) {
                if (!challenge.getElaboratedMiniChallenges().getChallenges().get(i).isChecked()) {
                    challenge.getElaboratedMiniChallenges().getChallenges().get(i).toggleCheck();
                }
            }
        }

    }


}
