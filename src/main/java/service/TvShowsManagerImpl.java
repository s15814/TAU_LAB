package service;

import domain.TvShowWithDates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TvShowsManagerImpl implements TvShowsManager {
    private Map<Integer, TvShowWithDates> tvShowMap = new HashMap<>();

    @Override
    public void create(TvShowWithDates tvShow) {
        if(tvShowMap.containsKey(tvShow.getId())) {
            throw new IllegalArgumentException("Tv Show with id: " + tvShow.getId() + " already exists.");
        } else {
            tvShowMap.put(tvShow.getId(), tvShow);
        }

    }

    @Override
    public TvShowWithDates read(Integer id) {
        if (tvShowMap.containsKey(id)) {
            return tvShowMap.get(id);
        } else {
            throw new NullPointerException("Tv Show with id: " + id + " doesn't exist.");
        }
    }

    @Override
    public void update(TvShowWithDates tvShow) {
        if (tvShowMap.containsKey(tvShow.getId())) {
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
}
