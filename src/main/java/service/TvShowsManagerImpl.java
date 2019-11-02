package service;

import domain.TvShowWithDates;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TvShowsManagerImpl implements TvShowsManager {
    private Map<Integer, TvShowWithDates> tvShowMap = new HashMap<>();
    private TimeService timeService = new TimeServiceImpl();

    private boolean creationTimeEnabled = true;
    private boolean lastAccessDateEnabled = true;
    private boolean updateDateEnabled = true;

    @Override
    public void create(TvShowWithDates tvShow) {
        if(tvShowMap.containsKey(tvShow.getId())) {
            throw new IllegalArgumentException("Tv Show with id: " + tvShow.getId() + " already exists.");
        } else if (creationTimeEnabled) {
            tvShow.setCreationDate(timeService.getCurrentTime());
            tvShowMap.put(tvShow.getId(), tvShow);
        } else
            tvShowMap.put(tvShow.getId(), tvShow);

    }

    @Override
    public TvShowWithDates read(Integer id) {
        if (tvShowMap.containsKey(id) && !lastAccessDateEnabled) {
            return tvShowMap.get(id);
        } else if (tvShowMap.containsKey(id) && lastAccessDateEnabled) {
            TvShowWithDates tvShowWithDates = tvShowMap.get(id);
            tvShowWithDates.setLastAccessDate(timeService.getCurrentTime());
            return tvShowMap.get(id);
        } else
            throw new NullPointerException("Tv Show with id: " + id + " doesn't exist.");
    }

    @Override
    public void update(TvShowWithDates tvShow) {
        if (tvShowMap.containsKey(tvShow.getId()) && updateDateEnabled) {
            tvShow.setUpdateDate(timeService.getCurrentTime());
            tvShowMap.replace(tvShow.getId(), tvShow);
        } else if (tvShowMap.containsKey(tvShow.getId()) && !updateDateEnabled) {
            tvShowMap.replace(tvShow.getId(), tvShow);
        } else {
            throw new NullPointerException("Tv Show: " + tvShow + " doesn't exist.");
        }

    }

    @Override
    public void delete(TvShowWithDates tvShow) {
        tvShowMap.remove(tvShow.getId());
    }

    @Override
    public List<TvShowWithDates> listAllSeries() {
        return new ArrayList<>(tvShowMap.values());
    }

    public void setCreationTimeEnabled(boolean creationTimeEnabled) {
        this.creationTimeEnabled = creationTimeEnabled;
    }

    public void setLastAccessDateEnabled(boolean lastAccessDateEnabled) {
        this.lastAccessDateEnabled = lastAccessDateEnabled;
    }

    public void setUpdateDateEnabled(boolean updateDateEnabled) {
        this.updateDateEnabled = updateDateEnabled;
    }
}
