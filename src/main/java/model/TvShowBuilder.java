package model;

public class TvShowBuilder {
    private int id;
    private String title;
    private int numberOfSeasons;
    private String directorsName;
    private String platform;

    public TvShowBuilder byId (int id) {
        this.id = id;
        return this;
    }

    public TvShowBuilder byTitle (String title) {
        this.title = title;
        return this;
    }

    public TvShowBuilder byNumberOfSeasons (int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
        return this;
    }

    public TvShowBuilder byDirectorsName (String directorsName) {
        this.directorsName = directorsName;
        return this;
    }
    public TvShowBuilder byPlatform (String platform) {
        this.platform = platform;
        return this;
    }

    public TvShow build() {
        TvShow tvShow = new TvShow();
        tvShow.setId(id);
        tvShow.setTitle(title);
        tvShow.setNumberOfSeasons(numberOfSeasons);
        tvShow.setDirectorsName(directorsName);
        tvShow.setPlatform(platform);
        return tvShow;
    }
}
