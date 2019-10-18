package service;

import domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TvShowsManagerTest {
    private TvShowsManager tvShowsManager;
    private TvShow tvShow;

    @Before
    public void setUp() {
        tvShowsManager = new TvShowsManagerImpl();

        tvShow = new TvShowBuilder().byId(1).byTitle("Narcos").byNumberOfSeasons(4).byDirectorsName("Jose Padilha").byPlatform("Netflix").build();
    }

    @Test
    public void CreateNewTvShow() {
        tvShowsManager.create(tvShow);

        assertEquals(1, tvShowsManager.listAllSeries().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void ShowWithIdAlreadyExists() {
        TvShow newShow = new TvShowBuilder().byId(1).build();

        tvShowsManager.create(tvShow);
        tvShowsManager.create(newShow);
    }

    @Test (expected = NullPointerException.class)
    public void ShowNotFoundById() {
        tvShowsManager.read(53);
    }

    @Test
    public void ReadTheTvShow() {
        tvShowsManager.create(tvShow);
        TvShow createdShow = tvShowsManager.read(1);

        assertEquals(tvShow, createdShow);
    }

    @Test (expected = NullPointerException.class)
    public void DeleteTvShow() {
        tvShowsManager.create(tvShow);
        tvShowsManager.delete(tvShow);
        tvShowsManager.read(tvShow.getId());
    }

    @Test
    public void UpdateTvShow() {
        tvShowsManager.create(tvShow);
        TvShow newShow = new TvShowBuilder().byId(1).byTitle("Lost").byNumberOfSeasons(6).byDirectorsName("Director's Name").byPlatform("TV").build();
        tvShowsManager.update(newShow);
        assertEquals("Lost", tvShowsManager.read(1).getTitle());
    }

    @Test (expected = NullPointerException.class)
    public void UpdateNonExistentTvShow () {
        tvShowsManager.update(tvShow);
    }





}
