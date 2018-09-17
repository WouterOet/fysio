package oet.wouter.fysio;

public class Answer {

    private int id;
    private String content;
    private int next;

    public Answer() {
    }

    public Answer(int id, String content, int next) {
        this.id = id;
        this.content = content;
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
