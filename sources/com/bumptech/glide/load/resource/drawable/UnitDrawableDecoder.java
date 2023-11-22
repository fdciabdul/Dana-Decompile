package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* loaded from: classes3.dex */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<Drawable> BuiltInFictitiousFunctionClassFactory(Drawable drawable, int i, int i2, Options options) throws IOException {
        return NonOwnedDrawableResource.getAuthRequestContext(drawable);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable, Options options) throws IOException {
        return true;
    }
}
