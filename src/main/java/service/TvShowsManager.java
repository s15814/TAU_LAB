package service;

import domain.TvShowWithDates;

import java.util.List;

public interface TvShowsManager {
    void create (TvShowWithDates tvShowWithDates);
    TvShowWithDates read(Integer id);
    void update(TvShowWithDates tvShowWithDates);
    void delete(TvShowWithDates tvShowWithDates);
    List<TvShowWithDates> listAllSeries();
    List<TvShowWithDates> findInTitle(String regex);

}
