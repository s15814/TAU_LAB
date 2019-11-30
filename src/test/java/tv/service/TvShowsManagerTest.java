package tv.service;

import tv.domain.*;
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
    private TvShowsManagerImpl tvShowsManager;
    private TvShow tvShow;
    private LocalDateTime currentTime;

    @Before
    public void setUp() {
        tvShowsManager = new TvShowsManagerImpl();

        tvShow = new TvShowBuilder().byId(1).byTitle("Narcos").byNumberOfSeasons(4).byDirectorsName("Jose Padilha").byPlatform("Netflix").build();

        currentTime = LocalDateTime.now();

        MockitoAnnotations.initMocks(this);

        when(timeService.getCurrentTime()).thenReturn(currentTime);
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

    @Test
    public void ReadingTvShowChangesLastAccessDateIfEnabled() {
        tvShowsManager.setLastAccessDateEnabled(true);
        tvShowsManager.create(tvShow);
        tvShowsManager.read(1);
        assertNotNull(tvShow.getLastAccessDate());
        assertEquals(currentTime, tvShow.getLastAccessDate());
    }

    @Test
    public void ReadingTvShowDoesNotChangeLastAccessDateIfDisabled() {
        tvShowsManager.setCreationTimeEnabled(false); //this is necessary to satisfy the test, without it the .getCurrentTime() method will be invoked by the create method
        tvShowsManager.setLastAccessDateEnabled(false);
        tvShowsManager.create(tvShow);
        TvShow createdShow = tvShowsManager.read(1);
        verify(timeService,never()).getCurrentTime();
        assertNull(createdShow.getLastAccessDate());
    }

    @Test
    public void CreatedTvShowHasCreationDateIfEnabled() {
        tvShowsManager.setCreationTimeEnabled(true);
        tvShowsManager.create(tvShow);
        assertNotNull(tvShow.getCreationDate());
        assertEquals(currentTime, tvShow.getCreationDate());
    }

    @Test
    public void CreatedTvShowHasNoCreationDateIfDisabled() {
        tvShowsManager.setCreationTimeEnabled(false);
        tvShowsManager.create(tvShow);
        TvShow createdShow = tvShowsManager.read(1);
        verify(timeService, only()).getCurrentTime();
        assertNull(createdShow.getCreationDate());
    }

    @Test
    public void UpdatedShowHasUpdateDateIfEnabled() {
        tvShowsManager.setUpdateDateEnabled(true);
        tvShowsManager.create(tvShow);
        TvShow newShow = new TvShowBuilder().byId(1).byTitle("Lost").byNumberOfSeasons(6).byDirectorsName("Director's Name").byPlatform("TV").build();
        tvShowsManager.update(newShow);
        TvShow createdShow = tvShowsManager.read(1);
        assertNotNull(createdShow.getUpdateDate());
        assertEquals(currentTime, createdShow.getUpdateDate());
    }

    @Test
    public void UpdatedShowHasNoUpdateDateIfDisabled() {
        tvShowsManager.setUpdateDateEnabled(false);
        tvShowsManager.create(tvShow);
        TvShow newShow = new TvShowBuilder().byId(1).byTitle("Lost").byNumberOfSeasons(6).byDirectorsName("Director's Name").byPlatform("TV").build();
        tvShowsManager.update(newShow);
        TvShow createdShow = tvShowsManager.read(1);
        verify(timeService, atMost(2)).getCurrentTime(); // at most twice, because it should be invoked once during creation, and then again during read, but not during update
        assertNull(createdShow.getUpdateDate());
    }





}
