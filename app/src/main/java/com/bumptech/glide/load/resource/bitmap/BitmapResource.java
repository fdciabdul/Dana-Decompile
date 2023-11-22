package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {
    private final Bitmap BuiltInFictitiousFunctionClassFactory;
    private final BitmapPool MyBillsEntityDataFactory;

    public static BitmapResource MyBillsEntityDataFactory(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.BuiltInFictitiousFunctionClassFactory = (Bitmap) Preconditions.BuiltInFictitiousFunctionClassFactory(bitmap, "Bitmap must not be null");
        this.MyBillsEntityDataFactory = (BitmapPool) Preconditions.BuiltInFictitiousFunctionClassFactory(bitmapPool, "BitmapPool must not be null");
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<Bitmap> KClassImpl$Data$declaredNonStaticMembers$2() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        return Util.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
        this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final /* bridge */ /* synthetic */ Bitmap getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
