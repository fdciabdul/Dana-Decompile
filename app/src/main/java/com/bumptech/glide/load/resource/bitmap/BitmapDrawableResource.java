package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

/* loaded from: classes7.dex */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {
    private final BitmapPool MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<BitmapDrawable> KClassImpl$Data$declaredNonStaticMembers$2() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        return Util.getAuthRequestContext(((BitmapDrawable) this.BuiltInFictitiousFunctionClassFactory).getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
        this.MyBillsEntityDataFactory.PlaceComponentResult(((BitmapDrawable) this.BuiltInFictitiousFunctionClassFactory).getBitmap());
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public final void BuiltInFictitiousFunctionClassFactory() {
        ((BitmapDrawable) this.BuiltInFictitiousFunctionClassFactory).getBitmap().prepareToDraw();
    }
}
