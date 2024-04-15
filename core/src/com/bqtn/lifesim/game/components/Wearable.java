package com.bqtn.lifesim.game.components;

import com.bqtn.lifesim.game.enums.BodyPart;

import java.util.List;

public class Wearable implements Component{
    List<BodyPart> wearableSlotList;
    String wearerId;

    public List<BodyPart> getWearableSlotList() {
        return wearableSlotList;
    }

    public void setWearableSlotList(List<BodyPart> wearableSlotsList) {
        this.wearableSlotList = wearableSlotsList;
    }

    public String getWearerId() {
        return wearerId;
    }

    public void setWearerId(String wearerId) {
        this.wearerId = wearerId;
    }
}
