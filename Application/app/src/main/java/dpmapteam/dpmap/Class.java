package dpmapteam.dpmap;

public class Class{//class for classes
    //properties
    private char hall;
    private int room_number;
    //constuctor
    public Class(char hall, int room_number) {
        this.hall = hall;
        this.room_number = room_number;
    }

    public char getHall() {
        return hall;
    }

    public int getRoom_number() {
        return room_number;
    }
}
