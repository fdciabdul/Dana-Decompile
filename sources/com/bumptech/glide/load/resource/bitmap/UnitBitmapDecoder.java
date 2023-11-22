package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<Bitmap> BuiltInFictitiousFunctionClassFactory(Bitmap bitmap, int i, int i2, Options options) throws IOException {
        return new NonOwnedBitmapResource(bitmap);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap, Options options) throws IOException {
        return true;
    }

    /* loaded from: classes3.dex */
    static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap PlaceComponentResult;

        @Override // com.bumptech.glide.load.engine.Resource
        public final void lookAheadTest() {
        }

        NonOwnedBitmapResource(Bitmap bitmap) {
            this.PlaceComponentResult = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public final Class<Bitmap> KClassImpl$Data$declaredNonStaticMembers$2() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public final int MyBillsEntityDataFactory() {
            return Util.getAuthRequestContext(this.PlaceComponentResult);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public final /* bridge */ /* synthetic */ Bitmap getAuthRequestContext() {
            return this.PlaceComponentResult;
        }
    }
}
