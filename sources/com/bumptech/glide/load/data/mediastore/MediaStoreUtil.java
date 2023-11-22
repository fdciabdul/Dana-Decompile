package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.caverock.androidsvg.SVGParser;

/* loaded from: classes3.dex */
public final class MediaStoreUtil {
    public static boolean PlaceComponentResult(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    private MediaStoreUtil() {
    }

    public static boolean getAuthRequestContext(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && SVGParser.XML_STYLESHEET_ATTR_MEDIA.equals(uri.getAuthority());
    }

    private static boolean PlaceComponentResult(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
        return getAuthRequestContext(uri) && PlaceComponentResult(uri);
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return getAuthRequestContext(uri) && !PlaceComponentResult(uri);
    }
}
