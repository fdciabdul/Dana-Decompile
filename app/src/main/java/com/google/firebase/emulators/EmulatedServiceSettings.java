package com.google.firebase.emulators;

/* loaded from: classes7.dex */
public final class EmulatedServiceSettings {
    private final String host;
    private final int port;

    public EmulatedServiceSettings(String str, int i) {
        this.host = str;
        this.port = i;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }
}
