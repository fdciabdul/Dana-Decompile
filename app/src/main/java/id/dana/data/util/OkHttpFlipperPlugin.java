package id.dana.data.util;

import com.facebook.flipper.plugins.network.NetworkFlipperPlugin;

/* loaded from: classes2.dex */
public class OkHttpFlipperPlugin {
    private static OkHttpFlipperPlugin instance;
    private static final Object sLock = new Object();
    private final NetworkFlipperPlugin networkFlipperPlugin = new NetworkFlipperPlugin();

    private OkHttpFlipperPlugin() {
    }

    public static OkHttpFlipperPlugin getInstance() {
        OkHttpFlipperPlugin okHttpFlipperPlugin;
        synchronized (sLock) {
            if (instance == null) {
                instance = new OkHttpFlipperPlugin();
            }
            okHttpFlipperPlugin = instance;
        }
        return okHttpFlipperPlugin;
    }

    public NetworkFlipperPlugin getNetworkFlipperPlugin() {
        return this.networkFlipperPlugin;
    }
}
