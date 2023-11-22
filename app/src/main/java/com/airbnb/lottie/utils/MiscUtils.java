package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* loaded from: classes3.dex */
public class MiscUtils {
    private static final PointF KClassImpl$Data$declaredNonStaticMembers$2 = new PointF();

    public static int MyBillsEntityDataFactory(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static float PlaceComponentResult(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static boolean getAuthRequestContext(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static PointF PlaceComponentResult(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void MyBillsEntityDataFactory(ShapeData shapeData, Path path) {
        path.reset();
        PointF pointF = shapeData.getAuthRequestContext;
        path.moveTo(pointF.x, pointF.y);
        KClassImpl$Data$declaredNonStaticMembers$2.set(pointF.x, pointF.y);
        for (int i = 0; i < shapeData.MyBillsEntityDataFactory.size(); i++) {
            CubicCurveData cubicCurveData = shapeData.MyBillsEntityDataFactory.get(i);
            PointF pointF2 = cubicCurveData.BuiltInFictitiousFunctionClassFactory;
            PointF pointF3 = cubicCurveData.getAuthRequestContext;
            PointF pointF4 = cubicCurveData.KClassImpl$Data$declaredNonStaticMembers$2;
            PointF pointF5 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (pointF2.equals(pointF5) && pointF3.equals(pointF4)) {
                path.lineTo(pointF4.x, pointF4.y);
            } else {
                path.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y);
            }
            pointF5.set(pointF4.x, pointF4.y);
        }
        if (shapeData.BuiltInFictitiousFunctionClassFactory()) {
            path.close();
        }
    }

    public static int getAuthRequestContext(int i) {
        return Math.max(0, Math.min(255, i));
    }

    public static float MyBillsEntityDataFactory(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static void MyBillsEntityDataFactory(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.PlaceComponentResult(keyPathElementContent.getAuthRequestContext(), i)) {
            String authRequestContext = keyPathElementContent.getAuthRequestContext();
            KeyPath keyPath3 = new KeyPath(keyPath2);
            keyPath3.KClassImpl$Data$declaredNonStaticMembers$2.add(authRequestContext);
            KeyPath keyPath4 = new KeyPath(keyPath3);
            keyPath4.BuiltInFictitiousFunctionClassFactory = keyPathElementContent;
            list.add(keyPath4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int MyBillsEntityDataFactory(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = i / i2;
        if (!((i ^ i2) >= 0) && i % i2 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }
}
