package androidx.media;

import android.os.Bundle;

/* loaded from: classes6.dex */
public class MediaBrowserCompatUtils {
    public static boolean getAuthRequestContext(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle2 == null ? bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }

    public static boolean MyBillsEntityDataFactory(Bundle bundle, Bundle bundle2) {
        int i;
        int i2;
        int i3;
        int i4 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i5 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE", -1);
        int i6 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int i7 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int i8 = Integer.MAX_VALUE;
        if (i4 == -1 || i6 == -1) {
            i = Integer.MAX_VALUE;
            i2 = 0;
        } else {
            i2 = i4 * i6;
            i = (i6 + i2) - 1;
        }
        if (i5 == -1 || i7 == -1) {
            i3 = 0;
        } else {
            i3 = i5 * i7;
            i8 = (i7 + i3) - 1;
        }
        return i >= i3 && i8 >= i2;
    }

    private MediaBrowserCompatUtils() {
    }
}
