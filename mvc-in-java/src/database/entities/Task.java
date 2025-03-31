package database.entities;

public class Task {
    private int id;
    private String title;
    private boolean finished;

    public Task(int id, String title, boolean finished) {
        this.id = id;
        this.title = title;
        this.finished = finished;
    }

    public Task(String title, boolean finished) {
        this.title = title;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
