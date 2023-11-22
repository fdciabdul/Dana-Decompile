package com.bumptech.glide.gifdecoder;

import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class GifHeaderParser {
    public GifHeader KClassImpl$Data$declaredNonStaticMembers$2;
    public ByteBuffer MyBillsEntityDataFactory;
    public final byte[] getAuthRequestContext = new byte[256];
    public int BuiltInFictitiousFunctionClassFactory = 0;

    public final int[] MyBillsEntityDataFactory(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.MyBillsEntityDataFactory.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                iArr[i3] = ((bArr[i2] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i2 = i5 + 1;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                InstrumentInjector.log_d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = 1;
        }
        return iArr;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        int PlaceComponentResult;
        do {
            PlaceComponentResult = PlaceComponentResult();
            this.MyBillsEntityDataFactory.position(Math.min(this.MyBillsEntityDataFactory.position() + PlaceComponentResult, this.MyBillsEntityDataFactory.limit()));
        } while (PlaceComponentResult > 0);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int PlaceComponentResult = PlaceComponentResult();
        this.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
        if (PlaceComponentResult <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i = this.BuiltInFictitiousFunctionClassFactory;
                if (i2 >= i) {
                    return;
                }
                i -= i2;
                this.MyBillsEntityDataFactory.get(this.getAuthRequestContext, i2, i);
                i2 += i;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error Reading Block n: ");
                    sb.append(i2);
                    sb.append(" count: ");
                    sb.append(i);
                    sb.append(" blockSize: ");
                    sb.append(this.BuiltInFictitiousFunctionClassFactory);
                    InstrumentInjector.log_d("GifHeaderParser", sb.toString(), e);
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = 1;
                return;
            }
        }
    }

    public final int PlaceComponentResult() {
        try {
            return this.MyBillsEntityDataFactory.get() & 255;
        } catch (Exception unused) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil = 1;
            return 0;
        }
    }

    public final boolean getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.DatabaseTableConfigUtil != 0;
    }
}
