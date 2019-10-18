package database;

import model.TvShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowsDB implements ShowsDBInterface {
    private Map<Integer, TvShow> tvShowMap = new HashMap<>();

    @Override
    public void create(TvShow tvShow) {
        if(tvShowMap.containsKey(tvShow.getId())) {
            throw new IllegalArgumentException("Tv Show with id: " + tvShow.getId() + " already exists.");
        } else {
            tvShowMap.put(tvShow.getId(), tvShow);
        }

    }

    @Override
    public TvShow read(Integer id) {
        if (tvShowMap.containsKey(id)) {
            return tvShowMap.get(id);
        } else {
            throw new NullPointerException("Tv Show with id: " + id + " doesn't exist.");
        }
    }

    @Override
    public void update(TvShow tvShow) {
        if (tvShowMap.containsKey(tvShow.getId())) {
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
}
