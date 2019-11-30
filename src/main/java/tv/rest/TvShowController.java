package tv.rest;

import org.springframework.web.bind.annotation.*;
import tv.domain.TvShow;
import tv.domain.TvShowBuilder;
import tv.service.TvShowsManager;

import java.util.List;

@RestController
@RequestMapping("tvshows")
public class TvShowController {
    private final TvShowsManager tvShowsManager;

    public TvShowController(TvShowsManager tvShowsManager) {
        this.tvShowsManager = tvShowsManager;

        TvShow newShow = new TvShowBuilder()
                .byId(1).byTitle("Lost")
                .byNumberOfSeasons(6)
                .byDirectorsName("Director's Name")
                .byPlatform("TV")
                .build();

        TvShow newShow2 = new TvShowBuilder()
                .byId(2).byTitle("Narcos")
                .byNumberOfSeasons(4)
                .byDirectorsName("Jose Padilha")
                .byPlatform("Netflix")
                .build();

        tvShowsManager.create(newShow);
        tvShowsManager.create(newShow2);
    }

    @GetMapping("")
    public List<TvShow> getAllTvShows() {
        return tvShowsManager.listAllSeries();
    }

    @GetMapping("/{id}")
    public TvShow getTvShow(@PathVariable Integer id) {
        return tvShowsManager.read(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTvShow(@PathVariable Integer id) {
        tvShowsManager.delete(tvShowsManager.read(id));
    }
}
