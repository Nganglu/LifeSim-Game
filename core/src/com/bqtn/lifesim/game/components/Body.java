package com.bqtn.lifesim.game.components;

import com.bqtn.lifesim.game.enums.BodyPart;

import java.util.Map;

public class Body implements Component {
    Map<BodyPart,Health> bodyMap;

    public Map<BodyPart, Health> getBodyMap() {
        return bodyMap;
    }

    public void setBodyMap(Map<BodyPart, Health> bodyMap) {
        this.bodyMap = bodyMap;
    }
}
