package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

/* loaded from: classes3.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    public static final Option<Integer> MyBillsEntityDataFactory = Option.PlaceComponentResult("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Option<Bitmap.CompressFormat> getAuthRequestContext = Option.MyBillsEntityDataFactory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final ArrayPool KClassImpl$Data$declaredNonStaticMembers$2;

    public BitmapEncoder(ArrayPool arrayPool) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayPool;
    }

    @Deprecated
    public BitmapEncoder() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0084, code lost:
    
        if (r6 != null) goto L60;
     */
    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r9, java.io.File r10, com.bumptech.glide.load.Options r11) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.KClassImpl$Data$declaredNonStaticMembers$2(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public final EncodeStrategy KClassImpl$Data$declaredNonStaticMembers$2(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }
}
