package com.alfred.model;

/**
 * Created by phili on 05-12-2015.
 */
public class Beacon {
    private String id;
    private String distance;
    private String key;

    public Beacon(){
    }
    public Beacon(String id, String distance, String key) {
        this.id = id;
        this.distance = distance;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Beacon{" +
                "id='" + id + '\'' +
                ", distance='" + distance + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
