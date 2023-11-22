package com.fullstory;

/* loaded from: classes.dex */
public final class FSSessionData {
    private final String sessionUrl;

    public FSSessionData(String str) {
        this.sessionUrl = str;
    }

    public final String getCurrentSessionURL() {
        return this.sessionUrl;
    }
}
