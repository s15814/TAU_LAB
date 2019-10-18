package database;

import model.TvShow;

import java.util.List;

public interface ShowsDBInterface {
    void create (TvShow tvShow);
    TvShow read(Integer id);
    void update(TvShow tvShow);
    void delete(TvShow tvShow);
    List<TvShow> listAllSeries();

}
