package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes3.dex */
public final class GifBitmapProvider implements GifDecoder.BitmapProvider {
    private final BitmapPool PlaceComponentResult;
    private final ArrayPool getAuthRequestContext;

    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.PlaceComponentResult = bitmapPool;
        this.getAuthRequestContext = arrayPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final Bitmap BuiltInFictitiousFunctionClassFactory(int i, int i2, Bitmap.Config config) {
        return this.PlaceComponentResult.MyBillsEntityDataFactory(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final void PlaceComponentResult(Bitmap bitmap) {
        this.PlaceComponentResult.PlaceComponentResult(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final byte[] getAuthRequestContext(int i) {
        ArrayPool arrayPool = this.getAuthRequestContext;
        if (arrayPool == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool.KClassImpl$Data$declaredNonStaticMembers$2(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        ArrayPool arrayPool = this.getAuthRequestContext;
        if (arrayPool == null) {
            return;
        }
        arrayPool.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final int[] MyBillsEntityDataFactory(int i) {
        ArrayPool arrayPool = this.getAuthRequestContext;
        if (arrayPool == null) {
            return new int[i];
        }
        return (int[]) arrayPool.KClassImpl$Data$declaredNonStaticMembers$2(i, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int[] iArr) {
        ArrayPool arrayPool = this.getAuthRequestContext;
        if (arrayPool == null) {
            return;
        }
        arrayPool.BuiltInFictitiousFunctionClassFactory((ArrayPool) iArr);
    }
}
