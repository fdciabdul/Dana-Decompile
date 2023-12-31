package com.alibaba.griver.core;

import com.alibaba.griver.api.common.GriverExtension;
import com.alibaba.griver.core.bridge.GriverBridgeManifest;
import com.alibaba.griver.core.point.GriverEventManifest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
class GriverExtensionDelegate {

    /* renamed from: a  reason: collision with root package name */
    private static GriverExtensionDelegate f6391a;
    private Map<Class<? extends GriverExtension>, GriverExtension> b;
    private List<GriverBridgeManifest> c;
    private List<GriverEventManifest> d;

    public List<GriverEventManifest> getEventManifests() {
        return this.d;
    }

    public void setEventManifests(List<GriverEventManifest> list) {
        this.d = list;
    }

    public void setExtensionMap(Map<Class<? extends GriverExtension>, GriverExtension> map) {
        this.b = map;
    }

    public Map<Class<? extends GriverExtension>, GriverExtension> getExtensionMap() {
        Map<Class<? extends GriverExtension>, GriverExtension> map = this.b;
        if (map == null || map.size() == 0) {
            this.b = new LinkedHashMap();
        }
        return this.b;
    }

    public List<GriverBridgeManifest> getBridgeManifests() {
        return this.c;
    }

    public void setBridgeManifests(List<GriverBridgeManifest> list) {
        this.c = list;
    }

    private GriverExtensionDelegate() {
    }

    public static GriverExtensionDelegate getInstance() {
        GriverExtensionDelegate griverExtensionDelegate;
        synchronized (GriverExtensionDelegate.class) {
            if (f6391a == null) {
                f6391a = new GriverExtensionDelegate();
            }
            griverExtensionDelegate = f6391a;
        }
        return griverExtensionDelegate;
    }
}
