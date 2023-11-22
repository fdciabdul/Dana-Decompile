package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes6.dex */
class MediaDescriptionCompatApi21 {
    public static String BuiltInFictitiousFunctionClassFactory(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence getErrorConfigVersion(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence lookAheadTest(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static Bitmap PlaceComponentResult(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri MyBillsEntityDataFactory(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle getAuthRequestContext(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void getAuthRequestContext(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object BuiltInFictitiousFunctionClassFactory(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    /* loaded from: classes6.dex */
    static class Builder {
        public static Object PlaceComponentResult() {
            return new MediaDescription.Builder();
        }

        public static void BuiltInFictitiousFunctionClassFactory(Object obj, String str) {
            ((MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void MyBillsEntityDataFactory(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setTitle(charSequence);
        }

        public static void BuiltInFictitiousFunctionClassFactory(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void PlaceComponentResult(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void getAuthRequestContext(Object obj, Bitmap bitmap) {
            ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void getAuthRequestContext(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setIconUri(uri);
        }

        private Builder() {
        }
    }

    private MediaDescriptionCompatApi21() {
    }
}
