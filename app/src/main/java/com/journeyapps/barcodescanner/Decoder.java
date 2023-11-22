package com.journeyapps.barcodescanner;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Decoder implements ResultPointCallback {
    private Reader BuiltInFictitiousFunctionClassFactory;
    List<ResultPoint> MyBillsEntityDataFactory = new ArrayList();

    public Decoder(Reader reader) {
        this.BuiltInFictitiousFunctionClassFactory = reader;
    }

    public final Result KClassImpl$Data$declaredNonStaticMembers$2(LuminanceSource luminanceSource) {
        return getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(luminanceSource));
    }

    protected BinaryBitmap BuiltInFictitiousFunctionClassFactory(LuminanceSource luminanceSource) {
        return new BinaryBitmap(new HybridBinarizer(luminanceSource));
    }

    private Result getAuthRequestContext(BinaryBitmap binaryBitmap) {
        Result result;
        this.MyBillsEntityDataFactory.clear();
        try {
            Reader reader = this.BuiltInFictitiousFunctionClassFactory;
            if (reader instanceof MultiFormatReader) {
                result = ((MultiFormatReader) reader).decodeWithState(binaryBitmap);
            } else {
                result = reader.decode(binaryBitmap);
            }
        } catch (Exception unused) {
            result = null;
        } catch (Throwable th) {
            this.BuiltInFictitiousFunctionClassFactory.reset();
            throw th;
        }
        this.BuiltInFictitiousFunctionClassFactory.reset();
        return result;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.MyBillsEntityDataFactory.add(resultPoint);
    }
}
