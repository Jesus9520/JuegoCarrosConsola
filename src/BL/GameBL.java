
package BL;

import java.util.List;


public class GameBL {
    
    int idGame;
    List<DriverBL> driversGamers;
    List<CarBL> carsGamers;
    List<TrackBL> tracksGamers;
    PodiumBL podium;

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public List<DriverBL> getDriversGamers() {
        return driversGamers;
    }

    public void setDriversGamers(List<DriverBL> driversGamers) {
        this.driversGamers = driversGamers;
    }

    public List<CarBL> getCarsGamers() {
        return carsGamers;
    }

    public void setCarsGamers(List<CarBL> carsGamers) {
        this.carsGamers = carsGamers;
    }

    public List<TrackBL> getTracksGamers() {
        return tracksGamers;
    }

    public void setTracksGamers(List<TrackBL> tracksGamers) {
        this.tracksGamers = tracksGamers;
    }

    public PodiumBL getPodium() {
        return podium;
    }

    public void setPodium(PodiumBL podium) {
        this.podium = podium;
    }
    
    
    
}
