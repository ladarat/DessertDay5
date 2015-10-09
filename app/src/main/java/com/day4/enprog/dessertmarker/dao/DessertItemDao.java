package com.day4.enprog.dessertmarker.dao;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by Ladarat on 8/10/2558.
 */
public class DessertItemDao {

    @SerializedName("menu_id")          private int menuId;
    @SerializedName("name")             private String name;
    @SerializedName("description")      private String description;
    @SerializedName("image_url")        private String imageURL;
    @SerializedName("prep_time")        private int prepTime;
    @SerializedName("ready_in_time")    private int readyInTime;
    @SerializedName("timestamp")        private Date timeStamp;
    @SerializedName("ingredients")      private List<String> ingredients;
    @SerializedName("directions")       private List<String> directions;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getReadyInTime() {
        return readyInTime;
    }

    public void setReadyInTime(int readyInTime) {
        this.readyInTime = readyInTime;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }
}
