package boardProject.demo.board;

import boardProject.demo.member.Position;

public class Post {
    private Long id;
    private Position position;
    private String title;
    private String content;

    public Post(Long id, Position position, String title, String content) {
        this.id = id;
        this.position = position;
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "Order{" +
                "memberId=" + id +
                ", position='" + position + '\'' +
                ", title=" + title +
                ", content=" + content +
                '}';
    }
}
