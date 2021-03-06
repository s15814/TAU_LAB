package tv.service;

import tv.domain.TvShow;

import java.util.List;

public interface TvShowsManager {
    void create (TvShow tvShow);
    TvShow read(Integer id);
    void update(TvShow tvShow);
    void delete(TvShow tvShow);
    List<TvShow> listAllSeries();
    List<TvShow> findInTitle(String regex);

}
