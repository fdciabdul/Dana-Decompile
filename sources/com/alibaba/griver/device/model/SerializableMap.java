package com.alibaba.griver.device.model;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes6.dex */
public class SerializableMap<T> implements Serializable {
    private Map<String, T> map;

    public SerializableMap(Map<String, T> map) {
        this.map = map;
    }

    public Map<String, T> getMap() {
        return this.map;
    }

    public void setMap(Map<String, T> map) {
        this.map = map;
    }
}
