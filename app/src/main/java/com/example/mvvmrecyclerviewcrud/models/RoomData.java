package com.example.mvvmrecyclerviewcrud.models;

public class RoomData {
    private String roomId;
    private String gender;
    private String checkInTime;
    private String foodPreference;
    private boolean hasWifi;
    private boolean hasBreakfast;
    private boolean hasLunch;

    public RoomData(String roomId, String gender, String checkInTime, String foodPreference,
                    boolean hasWifi, boolean hasBreakfast, boolean hasLunch) {
        this.roomId = roomId;
        this.gender = gender;
        this.checkInTime = checkInTime;
        this.foodPreference = foodPreference;
        this.hasWifi = hasWifi;
        this.hasBreakfast = hasBreakfast;
        this.hasLunch = hasLunch;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean hasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(boolean hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }

    public boolean hasLunch() {
        return hasLunch;
    }

    public void setHasLunch(boolean hasLunch) {
        this.hasLunch = hasLunch;
    }
}
