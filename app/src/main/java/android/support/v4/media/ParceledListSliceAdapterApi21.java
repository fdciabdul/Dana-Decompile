package android.support.v4.media;

import java.lang.reflect.Constructor;
import java.util.List;

/* loaded from: classes6.dex */
class ParceledListSliceAdapterApi21 {
    private static Constructor getAuthRequestContext;

    static {
        try {
            getAuthRequestContext = Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        }
    }

    private ParceledListSliceAdapterApi21() {
    }
}
