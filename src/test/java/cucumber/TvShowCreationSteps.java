package cucumber;

import cucumber.api.java.en.And;
import domain.TvShowBuilder;
import domain.TvShowWithDates;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import service.TvShowsManager;
import service.TvShowsManagerImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TvShowCreationSteps {
    private TvShowsManager tvShowsManager;
    private TvShowBuilder tvShowBuilder;
    private List<TvShowWithDates> tvShowList;
    private TvShowWithDates addedTvShow;

    public TvShowCreationSteps(){
        tvShowBuilder = new TvShowBuilder();
        tvShowsManager = new TvShowsManagerImpl();
    }

    @Given("tvSeries number {int} and title {string}")
    public void tvShowWithTitleIsCreated (Integer id, String title) {
        tvShowBuilder = new TvShowBuilder();
        tvShowBuilder.byId(id).byTitle(title);
    }
    @Given("with set number of seasons {int}")
    public void tvShowHasNumberOfSeasons (int numberOfSeasons) {
        tvShowBuilder.byNumberOfSeasons(numberOfSeasons);
    }

    @Given("with a director {string}")
    public void tvShowHasDirector(String directorsName) {
        tvShowBuilder.byDirectorsName(directorsName);
    }

    @Given("aired on a platform {string}")
    public void tvShowHasPlatform(String platform) {
        tvShowBuilder.byPlatform(platform);
    }

    @When("the tvShow is added")
    public void tvShowAdded() {
        addedTvShow = tvShowBuilder.build();
        tvShowsManager.create(addedTvShow);
    }

    @Then("it will exist with a given id {int} in the database")
    public void tvShowAddedCorrectly(Integer id){
        TvShowWithDates createdShow = tvShowsManager.read(id);
        assertEquals(addedTvShow.getId(), createdShow.getId());
    }
}
