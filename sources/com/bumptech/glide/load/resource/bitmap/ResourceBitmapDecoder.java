package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool KClassImpl$Data$declaredNonStaticMembers$2;
    private final ResourceDrawableDecoder PlaceComponentResult;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<Bitmap> BuiltInFictitiousFunctionClassFactory(Uri uri, int i, int i2, Options options) throws IOException {
        Uri uri2 = uri;
        ResourceDrawableDecoder resourceDrawableDecoder = this.PlaceComponentResult;
        Context PlaceComponentResult = resourceDrawableDecoder.PlaceComponentResult(uri2, uri2.getAuthority());
        Resource<Drawable> authRequestContext = NonOwnedDrawableResource.getAuthRequestContext(DrawableDecoderCompat.BuiltInFictitiousFunctionClassFactory(resourceDrawableDecoder.PlaceComponentResult, PlaceComponentResult, ResourceDrawableDecoder.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, uri2)));
        if (authRequestContext == null) {
            return null;
        }
        return DrawableToBitmapConverter.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.getAuthRequestContext(), i, i2);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, Options options) throws IOException {
        return BuiltInFictitiousFunctionClassFactory(uri);
    }

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.PlaceComponentResult = resourceDrawableDecoder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bitmapPool;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return "android.resource".equals(uri.getScheme());
    }
}
