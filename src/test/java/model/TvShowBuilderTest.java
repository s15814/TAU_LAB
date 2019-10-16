package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TvShowBuilderTest {
    private TvShowBuilder tvShowBuilder;

    @Before
    public void setUp() {tvShowBuilder = new TvShowBuilder();}

    @Test
    public void BuildNewTvShow() {
        TvShow tvShow;

        tvShow = tvShowBuilder.build();

        assertNotNull(tvShow);
    }

    @Test
    public void TvShowHasId() {
        TvShow tvShow;

        tvShow = tvShowBuilder.byId(1).build();

        assertEquals(1, tvShow.getId());
    }

    @Test
    public void TvShowHasTitle() {
        TvShow tvShow;

        tvShow = tvShowBuilder.byTitle("Narcos").build();

        assertEquals("Narcos", tvShow.getTitle());
    }

    @Test
    public void TvShowHasNumberOfSeasons() {
        TvShow tvShow;

        tvShow = tvShowBuilder.byNumberOfSeasons(4).build();

        assertEquals(4, tvShow.getNumberOfSeasons());
    }

    @Test
    public void TvShowHasDirector() {
        TvShow tvShow;

        tvShow = tvShowBuilder.byDirectorsName("Jose Padilha").build();

        assertEquals("Jose Padilha", tvShow.getDirectorsName());
    }

    @Test
    public void TvShowHasPlatform() {
        TvShow tvShow;

        tvShow = tvShowBuilder.byPlatform("Netflix").build();

        assertEquals("Netflix", tvShow.getPlatform());
    }
}
