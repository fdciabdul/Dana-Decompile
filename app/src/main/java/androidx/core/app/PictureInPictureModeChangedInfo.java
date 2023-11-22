package androidx.core.app;

import android.content.res.Configuration;

/* loaded from: classes.dex */
public final class PictureInPictureModeChangedInfo {
    private final Configuration MyBillsEntityDataFactory;
    private final boolean PlaceComponentResult;

    public PictureInPictureModeChangedInfo(boolean z) {
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = null;
    }

    public PictureInPictureModeChangedInfo(boolean z, Configuration configuration) {
        this.PlaceComponentResult = z;
        this.MyBillsEntityDataFactory = configuration;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }
}
