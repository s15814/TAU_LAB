package service;

import domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TvShowsManagerTest {

    @Mock
    private TimeService timeService;

    @InjectMocks
    private TvShowsManager tvShowsManager;
    private TvShowWithDates tvShowWithDates;
    private LocalDateTime currentTime;

    @Before
    public void setUp() {
        tvShowsManager = new TvShowsManagerImpl();

        tvShowWithDates = new TvShowBuilder().byId(1).byTitle("Narcos").byNumberOfSeasons(4).byDirectorsName("Jose Padilha").byPlatform("Netflix").build();

        currentTime = LocalDateTime.now();

        MockitoAnnotations.initMocks(this);

        when(timeService.getCurrentTime()).thenReturn(currentTime);
    }

    @Test
    public void CreateNewTvShow() {
        tvShowsManager.create(tvShowWithDates);

        assertEquals(1, tvShowsManager.listAllSeries().size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void ShowWithIdAlreadyExists() {
        TvShowWithDates newShow = new TvShowBuilder().byId(1).build();

        tvShowsManager.create(tvShowWithDates);
        tvShowsManager.create(newShow);
    }

    @Test (expected = NullPointerException.class)
    public void ShowNotFoundById() {
        tvShowsManager.read(53);
    }

    @Test
    public void ReadTheTvShow() {
        tvShowsManager.create(tvShowWithDates);
        TvShowWithDates createdShow = tvShowsManager.read(1);

        assertEquals(tvShowWithDates, createdShow);
    }

    @Test (expected = NullPointerException.class)
    public void DeleteTvShow() {
        tvShowsManager.create(tvShowWithDates);
        tvShowsManager.delete(tvShowWithDates);
        tvShowsManager.read(tvShowWithDates.getId());
    }

    @Test
    public void UpdateTvShow() {
        tvShowsManager.create(tvShowWithDates);
        TvShowWithDates newShow = new TvShowBuilder().byId(1).byTitle("Lost").byNumberOfSeasons(6).byDirectorsName("Director's Name").byPlatform("TV").build();
        tvShowsManager.update(newShow);
        assertEquals("Lost", tvShowsManager.read(1).getTitle());
    }

    @Test (expected = NullPointerException.class)
    public void UpdateNonExistentTvShow () {
        tvShowsManager.update(tvShowWithDates);
    }

    @Test
    public void ReadingTvShowChangesLastAccessDate() {
        tvShowsManager.create(tvShowWithDates);
        tvShowsManager.read(1);
        assertNotNull(tvShowWithDates.getLastAccessDate());
        assertEquals(currentTime, tvShowWithDates.getLastAccessDate());
    }





}
