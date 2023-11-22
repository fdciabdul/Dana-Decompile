package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    public final Context PlaceComponentResult;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<Drawable> BuiltInFictitiousFunctionClassFactory(Uri uri, int i, int i2, Options options) throws IOException {
        Uri uri2 = uri;
        Context PlaceComponentResult = PlaceComponentResult(uri2, uri2.getAuthority());
        return NonOwnedDrawableResource.getAuthRequestContext(DrawableDecoderCompat.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, PlaceComponentResult, BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, uri2)));
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, Options options) throws IOException {
        return getAuthRequestContext(uri);
    }

    public ResourceDrawableDecoder(Context context) {
        this.PlaceComponentResult = context.getApplicationContext();
    }

    private static boolean getAuthRequestContext(Uri uri) {
        return uri.getScheme().equals("android.resource");
    }

    public final Context PlaceComponentResult(Uri uri, String str) {
        if (str.equals(this.PlaceComponentResult.getPackageName())) {
            return this.PlaceComponentResult;
        }
        try {
            return this.PlaceComponentResult.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            if (str.contains(this.PlaceComponentResult.getPackageName())) {
                return this.PlaceComponentResult;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to obtain context or unrecognized Uri format for: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public static int BuiltInFictitiousFunctionClassFactory(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() != 2) {
            if (pathSegments.size() == 1) {
                return BuiltInFictitiousFunctionClassFactory(uri);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized Uri format: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString());
        }
        List<String> pathSegments2 = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments2.get(0);
        String str2 = pathSegments2.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to find resource id for: ");
        sb2.append(uri);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static int BuiltInFictitiousFunctionClassFactory(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized Uri format: ");
            sb.append(uri);
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }
}
