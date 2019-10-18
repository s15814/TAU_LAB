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

    }

    @Override
    public TvShow read(Integer id) {
        return null;
    }

    @Override
    public void update(TvShow tvShow) {

    }

    @Override
    public void delete(TvShow tvShow) {

    }

    @Override
    public List<TvShow> listAllSeries() {
        return new ArrayList<>();
    }
}
