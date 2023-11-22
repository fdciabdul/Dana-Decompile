package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* loaded from: classes6.dex */
class MediaDescriptionCompatApi23 {
    public static Uri getAuthRequestContext(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    /* loaded from: classes6.dex */
    static class Builder {
        public static void PlaceComponentResult(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }

        private Builder() {
        }
    }

    private MediaDescriptionCompatApi23() {
    }
}
