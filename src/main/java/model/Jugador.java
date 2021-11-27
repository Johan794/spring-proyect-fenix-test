package model;

public class Jugador {
    private String id;
    private String name;
    private String playNumber;


    public Jugador(String name, String playNumber) {
        this.name = name;
        this.playNumber = playNumber;
    }

    public Jugador(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(String playNumber) {
        this.playNumber = playNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
