package tv.service;

import tv.domain.TvShow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TvShowsManagerImpl implements TvShowsManager {
    private Map<Integer, TvShow> tvShowMap = new HashMap<>();
    private TimeService timeService = new TimeServiceImpl();

    private boolean creationTimeEnabled = true;
    private boolean lastAccessDateEnabled = true;
    private boolean updateDateEnabled = true;

    @Override
    public void create(TvShow tvShow) {
        if(tvShowMap.containsKey(tvShow.getId())) {
            throw new IllegalArgumentException("Tv Show with id: " + tvShow.getId() + " already exists.");
        } else if (creationTimeEnabled) {
            tvShow.setCreationDate(timeService.getCurrentTime());
            tvShowMap.put(tvShow.getId(), tvShow);
        } else
            tvShowMap.put(tvShow.getId(), tvShow);

    }

    @Override
    public TvShow read(Integer id) {
        if (tvShowMap.containsKey(id) && !lastAccessDateEnabled) {
            return tvShowMap.get(id);
        } else if (tvShowMap.containsKey(id) && lastAccessDateEnabled) {
            TvShow tvShow = tvShowMap.get(id);
            tvShow.setLastAccessDate(timeService.getCurrentTime());
            return tvShowMap.get(id);
        } else
            throw new NullPointerException("Tv Show with id: " + id + " doesn't exist.");
    }

    @Override
    public void update(TvShow tvShow) {
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
    public void delete(TvShow tvShow) {
        tvShowMap.remove(tvShow.getId());
    }

    @Override
    public List<TvShow> listAllSeries() {
        return new ArrayList<>(tvShowMap.values());
    }
    @Override
    public List<TvShow> findInTitle(String regex) {
        if (regex == null) {
            throw new IllegalArgumentException("Not looking for anything");
        }
        List<TvShow> result = new ArrayList<>();
        tvShowMap.values().stream()
                .filter(tvShow -> tvShow.getTitle().matches(regex))
                .forEach(tvShow -> result.add(tvShow));
        return result;
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
