package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class StandardGifDecoder implements GifDecoder {
    private static final String BuiltInFictitiousFunctionClassFactory = "StandardGifDecoder";
    private byte[] DatabaseTableConfigUtil;
    private short[] GetContactSyncConfig;
    private Bitmap.Config KClassImpl$Data$declaredNonStaticMembers$2;
    private byte[] MyBillsEntityDataFactory;
    private GifHeader NetworkUserEntityData$$ExternalSyntheticLambda0;
    private byte[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final int[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    private byte[] NetworkUserEntityData$$ExternalSyntheticLambda4;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7;
    private ByteBuffer NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int[] PlaceComponentResult;
    private boolean PrepareContext;
    private final GifDecoder.BitmapProvider getAuthRequestContext;
    private int getErrorConfigVersion;
    private int[] initRecordTimeStamp;
    private int isLayoutRequested;
    private int lookAheadTest;
    private Boolean moveToNextValue;
    private Bitmap newProxyInstance;
    private int scheduleImpl;

    public StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        synchronized (this) {
            if (i <= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Sample size must be >=0, not: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            int highestOneBit = Integer.highestOneBit(i);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = gifHeader;
            this.getErrorConfigVersion = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.order(ByteOrder.LITTLE_ENDIAN);
            this.PrepareContext = false;
            Iterator<GifFrame> it = gifHeader.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().MyBillsEntityDataFactory == 3) {
                    this.PrepareContext = true;
                    break;
                }
            }
            this.isLayoutRequested = highestOneBit;
            this.lookAheadTest = gifHeader.initRecordTimeStamp / highestOneBit;
            this.scheduleImpl = gifHeader.scheduleImpl / highestOneBit;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.getAuthRequestContext.getAuthRequestContext(gifHeader.initRecordTimeStamp * gifHeader.scheduleImpl);
            this.initRecordTimeStamp = this.getAuthRequestContext.MyBillsEntityDataFactory(this.lookAheadTest * this.scheduleImpl);
        }
    }

    private StandardGifDecoder(GifDecoder.BitmapProvider bitmapProvider) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new int[256];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Bitmap.Config.ARGB_8888;
        this.getAuthRequestContext = bitmapProvider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new GifHeader();
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getErrorConfigVersion = (this.getErrorConfigVersion + 1) % this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final int lookAheadTest() {
        int i;
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult <= 0 || (i = this.getErrorConfigVersion) < 0) {
            return 0;
        }
        if (i < 0 || i >= this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult) {
            return -1;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.get(i).PlaceComponentResult;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final int moveToNextValue() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final int getAuthRequestContext() {
        return this.getErrorConfigVersion;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.getErrorConfigVersion = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final int MyBillsEntityDataFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8.limit() + this.NetworkUserEntityData$$ExternalSyntheticLambda1.length + (this.initRecordTimeStamp.length * 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00fd, code lost:
    
        if (r39.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext == r6.NetworkUserEntityData$$ExternalSyntheticLambda0) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011f  */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap getErrorConfigVersion() {
        /*
            Method dump skipped, instructions count: 1326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.StandardGifDecoder.getErrorConfigVersion():android.graphics.Bitmap");
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        byte[] bArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (bArr != null) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(bArr);
        }
        int[] iArr = this.initRecordTimeStamp;
        if (iArr != null) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(iArr);
        }
        Bitmap bitmap = this.newProxyInstance;
        if (bitmap != null) {
            this.getAuthRequestContext.PlaceComponentResult(bitmap);
        }
        this.newProxyInstance = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        this.moveToNextValue = null;
        byte[] bArr2 = this.MyBillsEntityDataFactory;
        if (bArr2 != null) {
            this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported format: ");
            sb.append(config);
            sb.append(", must be one of ");
            sb.append(Bitmap.Config.ARGB_8888);
            sb.append(" or ");
            sb.append(Bitmap.Config.RGB_565);
            throw new IllegalArgumentException(sb.toString());
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = config;
    }

    private Bitmap scheduleImpl() {
        Boolean bool = this.moveToNextValue;
        Bitmap BuiltInFictitiousFunctionClassFactory2 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, this.scheduleImpl, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.KClassImpl$Data$declaredNonStaticMembers$2);
        BuiltInFictitiousFunctionClassFactory2.setHasAlpha(true);
        return BuiltInFictitiousFunctionClassFactory2;
    }
}
