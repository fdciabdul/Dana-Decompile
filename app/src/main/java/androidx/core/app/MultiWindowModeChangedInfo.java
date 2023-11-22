package androidx.core.app;

import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class MultiWindowModeChangedInfo {
    private final Configuration PlaceComponentResult;
    private final boolean getAuthRequestContext;

    public MultiWindowModeChangedInfo(boolean z) {
        this.getAuthRequestContext = z;
        this.PlaceComponentResult = null;
    }

    public MultiWindowModeChangedInfo(boolean z, Configuration configuration) {
        this.getAuthRequestContext = z;
        this.PlaceComponentResult = configuration;
    }

    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
