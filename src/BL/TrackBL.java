
package BL;

import java.util.List;


public class TrackBL {
    
    int idTrack;
    List<String> lanes;
    int distance;

    public int getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(int idTrack) {
        this.idTrack = idTrack;
    }

    public List<String> getLanes() {
        return lanes;
    }

    public void setLanes(List<String> lanes) {
        this.lanes = lanes;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    
    
}
