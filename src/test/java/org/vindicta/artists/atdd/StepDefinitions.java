package org.vindicta.artists.atdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class StepDefinitions {
    private final static Logger LOGGER = Logger.getLogger(StepDefinitions.class.getName());

    private static final String BASE_URL = "http://localhost:8080";

    private Response response;


    private Response makeGetRequest() {
        return RestAssured.when().get(BASE_URL + "/artists");
    }

    private Response makeGetRequest(int id) {
        return RestAssured.when().get(BASE_URL + "/artists/" + id);
    }

    @When("I request a list of all the artists")
    public void iRequestAListOfAllTheArtists() {
        response = makeGetRequest();
    }


    @Then("I get back a list of artists")
    public void iGetBackAListOfArtists() {
        LOGGER.info("Response " + response.asString());
    }

    @When("I request an artist using their ID {int}")
    public void iRequestAnArtistUsingTheirID(int id) {
        response = makeGetRequest(id);
    }

    @Then("I get back that artists details")
    public void iGetBackThatArtistsDetails() {
        LOGGER.info("Response " + response.asString());
        response.then().statusCode(200);
    }

    @And("that artists details contains a list of skills")
    public void thatArtistsDetailsContainsAListOfSkills() {
        LOGGER.info(response.asString());
        String json = response.asString();
        assertThat(json, containsStringIgnoringCase("skills"));
    }

    @Given("an artist ID {int} exists")
    public void anArtistIDExists(int id) {
        makeGetRequest(id).
                then().
                assertThat().
                statusCode(200);
    }

    @When("I submit a new artist {string}")
    public void iSubmitANewArtist(String name) throws JSONException {
        RestAssured.baseURI = BASE_URL ;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", name);

        request.body(requestParams.toString());
        response = request.post("/artists");
    }

    @Then("the response code is {int}")
    public void theResponseCodeIs(int code) {
        LOGGER.info(response.asString());
        response.then().assertThat().statusCode(200);
    }

    @Then("the new artist {string} is listed")
    public void theNewArtistIsListed(String name) {
        response.then().assertThat().body("name", hasItem(name));
    }
}
