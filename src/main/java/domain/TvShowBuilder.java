package domain;

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

    public TvShowWithDates build() {
        TvShowWithDates tvShowWithDates = new TvShowWithDates();
        tvShowWithDates.setId(id);
        tvShowWithDates.setTitle(title);
        tvShowWithDates.setNumberOfSeasons(numberOfSeasons);
        tvShowWithDates.setDirectorsName(directorsName);
        tvShowWithDates.setPlatform(platform);
        return tvShowWithDates;
    }


}
