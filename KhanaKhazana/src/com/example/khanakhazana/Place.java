package com.example.khanakhazana;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
//import java.util.ArrayList;

public class Place {
    private String id;
    private String icon;
    private String name;
    private String vicinity;
    private Double latitude;
    private Double longitude;
    private Double phonenum;
   // private Integer review;
    private boolean open_now;
    public static Place[] a = new Place[50];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
       
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
    
   public boolean getopen(){
    	return open_now;
    }
    
    public void setopen(boolean open_now){
    	this.open_now=open_now;
    }

    public Double getphone(){
    	return phonenum;
    }
    
    public void setphone(Double phonenum){
    	this.phonenum=phonenum;
    }

    static Place jsonToPontoReferencia(JSONObject pontoReferencia) {
        try {
            Place result = new Place();
            JSONObject geometry = (JSONObject) pontoReferencia.get("geometry");
            JSONObject location = (JSONObject) geometry.get("location");
          //  JSONObject opening_hours = (JSONObject) pontoReferencia.get("opening_hours");
           // result.setopen((boolean) opening_hours.getBoolean("open_now"));
            
            result.setLatitude((Double) location.get("lat"));
            result.setLongitude((Double) location.get("lng"));
           // result.setphone(pontoReferencia.getDouble("price_level"));
            result.setIcon(pontoReferencia.getString("icon"));
            result.setName(pontoReferencia.getString("name"));
            result.setVicinity(pontoReferencia.getString("vicinity"));
            result.setId(pontoReferencia.getString("id"));
           a[Info.i]=result;
           Info.i++;
            return result;
        } catch (JSONException ex) {
            Logger.getLogger(Place.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", icon=" + icon + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude +  '}';
    }

}

