package models;

public class Player {
    private Cell currentCell;
    private User user;
    
    public Cell getCurrentCell() {
        return currentCell;
    }
    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
