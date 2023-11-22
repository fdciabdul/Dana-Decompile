package com.bumptech.glide.load.resource;

import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {
    final HardwareConfigState KClassImpl$Data$declaredNonStaticMembers$2 = HardwareConfigState.PlaceComponentResult();

    protected abstract Resource<T> BuiltInFictitiousFunctionClassFactory(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(ImageDecoder.Source source, Options options) throws IOException {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r13v2 */
    @Override // com.bumptech.glide.load.ResourceDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.bumptech.glide.load.engine.Resource<T> BuiltInFictitiousFunctionClassFactory(android.graphics.ImageDecoder.Source r10, final int r11, final int r12, com.bumptech.glide.load.Options r13) throws java.io.IOException {
        /*
            r9 = this;
            com.bumptech.glide.load.Option<com.bumptech.glide.load.DecodeFormat> r0 = com.bumptech.glide.load.resource.bitmap.Downsampler.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L11
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Object r0 = r1.get(r0)
            goto L13
        L11:
            T r0 = r0.PlaceComponentResult
        L13:
            r6 = r0
            com.bumptech.glide.load.DecodeFormat r6 = (com.bumptech.glide.load.DecodeFormat) r6
            com.bumptech.glide.load.Option<com.bumptech.glide.load.resource.bitmap.DownsampleStrategy> r0 = com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.scheduleImpl
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L27
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Object r0 = r1.get(r0)
            goto L29
        L27:
            T r0 = r0.PlaceComponentResult
        L29:
            r7 = r0
            com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r7 = (com.bumptech.glide.load.resource.bitmap.DownsampleStrategy) r7
            com.bumptech.glide.load.Option<java.lang.Boolean> r0 = com.bumptech.glide.load.resource.bitmap.Downsampler.MyBillsEntityDataFactory
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L3d
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Object r0 = r1.get(r0)
            goto L3f
        L3d:
            T r0 = r0.PlaceComponentResult
        L3f:
            if (r0 == 0) goto L5f
            com.bumptech.glide.load.Option<java.lang.Boolean> r0 = com.bumptech.glide.load.resource.bitmap.Downsampler.MyBillsEntityDataFactory
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L52
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Object r0 = r1.get(r0)
            goto L54
        L52:
            T r0 = r0.PlaceComponentResult
        L54:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L5f
            r0 = 1
            r5 = 1
            goto L61
        L5f:
            r0 = 0
            r5 = 0
        L61:
            com.bumptech.glide.load.Option<com.bumptech.glide.load.PreferredColorSpace> r0 = com.bumptech.glide.load.resource.bitmap.Downsampler.NetworkUserEntityData$$ExternalSyntheticLambda0
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r1 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r1 = r1.containsKey(r0)
            if (r1 == 0) goto L72
            androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> r13 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.Object r13 = r13.get(r0)
            goto L74
        L72:
            T r13 = r0.PlaceComponentResult
        L74:
            r8 = r13
            com.bumptech.glide.load.PreferredColorSpace r8 = (com.bumptech.glide.load.PreferredColorSpace) r8
            com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1 r13 = new com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1
            r1 = r13
            r2 = r9
            r3 = r11
            r4 = r12
            r1.<init>()
            com.bumptech.glide.load.engine.Resource r10 = r9.BuiltInFictitiousFunctionClassFactory(r10, r11, r12, r13)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.BuiltInFictitiousFunctionClassFactory(android.graphics.ImageDecoder$Source, int, int, com.bumptech.glide.load.Options):com.bumptech.glide.load.engine.Resource");
    }
}
