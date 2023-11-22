package com.google.firebase.perf.config;

/* loaded from: classes.dex */
abstract class ConfigurationFlag<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T getDefault();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDeviceCacheFlag() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getMetadataFlag() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRemoteConfigFlag() {
        return null;
    }
}
