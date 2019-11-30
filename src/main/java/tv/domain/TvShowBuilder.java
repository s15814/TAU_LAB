package tv.domain;

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
        TvShow TvShow = new TvShow();
        TvShow.setId(id);
        TvShow.setTitle(title);
        TvShow.setNumberOfSeasons(numberOfSeasons);
        TvShow.setDirectorsName(directorsName);
        TvShow.setPlatform(platform);
        return TvShow;
    }


}
