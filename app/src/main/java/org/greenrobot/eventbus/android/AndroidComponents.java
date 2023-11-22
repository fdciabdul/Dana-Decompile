package org.greenrobot.eventbus.android;

import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.MainThreadSupport;

/* loaded from: classes6.dex */
public abstract class AndroidComponents {
    private static final AndroidComponents implementation;
    public final MainThreadSupport defaultMainThreadSupport;
    public final Logger logger;

    static {
        implementation = AndroidDependenciesDetector.isAndroidSDKAvailable() ? AndroidDependenciesDetector.instantiateAndroidComponents() : null;
    }

    public static boolean areAvailable() {
        return implementation != null;
    }

    public static AndroidComponents get() {
        return implementation;
    }

    public AndroidComponents(Logger logger, MainThreadSupport mainThreadSupport) {
        this.logger = logger;
        this.defaultMainThreadSupport = mainThreadSupport;
    }
}
