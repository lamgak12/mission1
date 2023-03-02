package history;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class historyDTO {
    int id;
    Double lat;
    Double lnt;
    String date;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLnt() {
        return lnt;
    }
    public void setLnt(Double lnt) {
        this.lnt = lnt;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}