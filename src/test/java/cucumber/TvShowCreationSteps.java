package cucumber;

import tv.domain.TvShow;
import tv.domain.TvShowBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tv.service.TvShowsManager;
import tv.service.TvShowsManagerImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TvShowCreationSteps {
    private TvShowsManager tvShowsManager;
    private TvShowBuilder tvShowBuilder;
    private List<TvShow> tvShowList;
    private TvShow addedTvShow;

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
        TvShow createdShow = tvShowsManager.read(id);
        assertEquals(addedTvShow.getId(), createdShow.getId());
    }

    @Given("series from the first example are in the database")
    public void addTvShowsToDb() {
        tvShowsManager.create(new TvShowBuilder().byId(1).byTitle("Lost").byNumberOfSeasons(2).byDirectorsName("Director").byPlatform("TV").build());
        tvShowsManager.create(new TvShowBuilder().byId(2).byTitle("Game of Thrones").byNumberOfSeasons(6).byDirectorsName("OtherDirector").byPlatform("HBO").build());
        tvShowsManager.create(new TvShowBuilder().byId(3).byTitle("The Walking Dead").byNumberOfSeasons(3).byDirectorsName("SomeDirector").byPlatform("TV").build());
        tvShowsManager.create(new TvShowBuilder().byId(4).byTitle("The Witcher").byNumberOfSeasons(1).byDirectorsName("aDirector").byPlatform("Netflix").build());
        tvShowsManager.create(new TvShowBuilder().byId(5).byTitle("The Boys").byNumberOfSeasons(1).byDirectorsName("AnotherDirector").byPlatform("Prime").build());
    }

    @When("i want to find how many titles start with the word {string}")
    public void checkTvShowTitleForWords(String regex) {
        tvShowList = tvShowsManager.findInTitle(regex);
    }

    @Then("i found out that {int} shows have that word in their title")
    public void countWordAppearances (int number) {
        assertEquals(number, tvShowList.size());
    }
}
