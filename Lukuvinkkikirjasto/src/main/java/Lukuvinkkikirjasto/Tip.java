package Lukuvinkkikirjasto;

public class Tip {
    private String header;
    private String creator;
    private String url;
    private String type;
    private String descpription;
    private String tags;
    private String comment;
    private String courses;

    public Tip(String header, String description, String creator, String url, String type, String tags, String comment,
            String courses) {
        this.header = header;
        this.creator = creator;
        this.url = url;
        this.type = type;
        this.descpription = description;
        this.tags = tags;
        this.comment = tags;
        this.courses = courses;
    }

}