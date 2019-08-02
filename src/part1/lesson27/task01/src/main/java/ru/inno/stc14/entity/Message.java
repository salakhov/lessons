package ru.inno.stc14.entity;

public class Message {
    private String home;
    private String content;

    public Message() {
    }

    public Message(String home, String content) {
        this.home = home;
        this.content = content;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
