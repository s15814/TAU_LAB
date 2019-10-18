package database;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShowsDBTest {
    private ShowsDBInterface showsDBInterface;
    private TvShow tvShow;

    @Before
    public void setUp() {
        showsDBInterface = new ShowsDB();

        tvShow = new TvShowBuilder().byId(1).byTitle("Narcos").byNumberOfSeasons(4).byDirectorsName("Jose Padilha").byPlatform("Netflix").build();
    }

    @Test
    public void CreateNewTvShow() {
        showsDBInterface.create(tvShow);

        assertEquals(1, showsDBInterface.listAllSeries().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void ShowWithIdAlreadyExists() {
        TvShow newShow = new TvShowBuilder().byId(1).build();

        showsDBInterface.create(tvShow);
        showsDBInterface.create(newShow);
    }

    @Test (expected = NullPointerException.class)
    public void ShowNotFoundById() {
        showsDBInterface.read(53);
    }

    @Test
    public void ReadTheTvShow() {
        showsDBInterface.create(tvShow);
        TvShow createdShow = showsDBInterface.read(1);

        assertEquals(tvShow, createdShow);
    }

    @Test (expected = NullPointerException.class)
    public void DeleteTvShow() {
        showsDBInterface.create(tvShow);
        showsDBInterface.delete(tvShow);
        showsDBInterface.read(tvShow.getId());
    }

    @Test
    public void UpdateTvShow() {
        showsDBInterface.create(tvShow);
        TvShow newShow = new TvShowBuilder().byId(1).byTitle("Lost").byNumberOfSeasons(6).byDirectorsName("Director's Name").byPlatform("TV").build();
        showsDBInterface.update(newShow);
        assertEquals("Lost", showsDBInterface.read(1).getTitle());
    }




}
