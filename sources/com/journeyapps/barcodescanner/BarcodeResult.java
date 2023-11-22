package com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class BarcodeResult {
    private final int BuiltInFictitiousFunctionClassFactory = 2;
    protected SourceData KClassImpl$Data$declaredNonStaticMembers$2;
    protected Result getAuthRequestContext;

    public BarcodeResult(Result result, SourceData sourceData) {
        this.getAuthRequestContext = result;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sourceData;
    }

    public final Bitmap MyBillsEntityDataFactory() {
        SourceData sourceData = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Rect rect = new Rect(0, 0, sourceData.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, sourceData.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
        YuvImage yuvImage = new YuvImage(sourceData.MyBillsEntityDataFactory.PlaceComponentResult(), sourceData.BuiltInFictitiousFunctionClassFactory, sourceData.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, sourceData.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (sourceData.getAuthRequestContext != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(sourceData.getAuthRequestContext);
            return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
        }
        return decodeByteArray;
    }

    public final String getAuthRequestContext() {
        return this.getAuthRequestContext.getText();
    }

    public final byte[] BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext.getRawBytes();
    }

    public final BarcodeFormat PlaceComponentResult() {
        return this.getAuthRequestContext.getBarcodeFormat();
    }

    public final Map<ResultMetadataType, Object> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.getResultMetadata();
    }

    public String toString() {
        return this.getAuthRequestContext.getText();
    }

    public static List<ResultPoint> KClassImpl$Data$declaredNonStaticMembers$2(List<ResultPoint> list, SourceData sourceData) {
        ArrayList arrayList = new ArrayList(list.size());
        for (ResultPoint resultPoint : list) {
            float x = (resultPoint.getX() * sourceData.moveToNextValue) + sourceData.PlaceComponentResult.left;
            float y = resultPoint.getY();
            float f = sourceData.moveToNextValue;
            float f2 = sourceData.PlaceComponentResult.top;
            if (sourceData.KClassImpl$Data$declaredNonStaticMembers$2) {
                x = sourceData.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 - x;
            }
            arrayList.add(new ResultPoint(x, (y * f) + f2));
        }
        return arrayList;
    }
}
