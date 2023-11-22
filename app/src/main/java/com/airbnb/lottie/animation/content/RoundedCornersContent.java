package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    final BaseKeyframeAnimation<Float, Float> BuiltInFictitiousFunctionClassFactory;
    private final LottieDrawable KClassImpl$Data$declaredNonStaticMembers$2;
    private ShapeData PlaceComponentResult;
    private final String getAuthRequestContext;

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
    }

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lottieDrawable;
        this.getAuthRequestContext = roundedCorners.BuiltInFictitiousFunctionClassFactory;
        BaseKeyframeAnimation<Float, Float> MyBillsEntityDataFactory = roundedCorners.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
        baseLayer.MyBillsEntityDataFactory.add(MyBillsEntityDataFactory);
        MyBillsEntityDataFactory.MyBillsEntityDataFactory.add(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.invalidateSelf();
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i2 * i3 != i) {
            i3--;
        }
        return i - (i3 * i2);
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public final ShapeData BuiltInFictitiousFunctionClassFactory(ShapeData shapeData) {
        PointF pointF;
        List<CubicCurveData> list;
        ShapeData shapeData2;
        List<CubicCurveData> list2;
        boolean z;
        PointF pointF2;
        ShapeData shapeData3 = shapeData;
        List<CubicCurveData> list3 = shapeData3.MyBillsEntityDataFactory;
        if (list3.size() <= 2) {
            return shapeData3;
        }
        float floatValue = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().floatValue();
        if (floatValue == 0.0f) {
            return shapeData3;
        }
        List<CubicCurveData> list4 = shapeData3.MyBillsEntityDataFactory;
        boolean BuiltInFictitiousFunctionClassFactory = shapeData.BuiltInFictitiousFunctionClassFactory();
        int size = list4.size() - 1;
        int i = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = list4.get(size);
            CubicCurveData cubicCurveData2 = list4.get(KClassImpl$Data$declaredNonStaticMembers$2(size - 1, list4.size()));
            if (size == 0 && !BuiltInFictitiousFunctionClassFactory) {
                pointF2 = shapeData3.getAuthRequestContext;
            } else {
                pointF2 = cubicCurveData2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            i = (((size != 0 || BuiltInFictitiousFunctionClassFactory) ? cubicCurveData2.getAuthRequestContext : pointF2).equals(pointF2) && cubicCurveData.BuiltInFictitiousFunctionClassFactory.equals(pointF2) && !(!shapeData.BuiltInFictitiousFunctionClassFactory() && size == 0 && size == list4.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        ShapeData shapeData4 = this.PlaceComponentResult;
        if (shapeData4 == null || shapeData4.MyBillsEntityDataFactory.size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new CubicCurveData());
            }
            this.PlaceComponentResult = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.PlaceComponentResult.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        ShapeData shapeData5 = this.PlaceComponentResult;
        float f = shapeData3.getAuthRequestContext.x;
        float f2 = shapeData3.getAuthRequestContext.y;
        if (shapeData5.getAuthRequestContext == null) {
            shapeData5.getAuthRequestContext = new PointF();
        }
        shapeData5.getAuthRequestContext.set(f, f2);
        List<CubicCurveData> list5 = shapeData5.MyBillsEntityDataFactory;
        boolean BuiltInFictitiousFunctionClassFactory2 = shapeData.BuiltInFictitiousFunctionClassFactory();
        int i3 = 0;
        int i4 = 0;
        while (i3 < list3.size()) {
            CubicCurveData cubicCurveData3 = list3.get(i3);
            CubicCurveData cubicCurveData4 = list3.get(KClassImpl$Data$declaredNonStaticMembers$2(i3 - 1, list3.size()));
            CubicCurveData cubicCurveData5 = list3.get(KClassImpl$Data$declaredNonStaticMembers$2(i3 - 2, list3.size()));
            if (i3 == 0 && !BuiltInFictitiousFunctionClassFactory2) {
                pointF = shapeData3.getAuthRequestContext;
            } else {
                pointF = cubicCurveData4.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            PointF pointF3 = (i3 != 0 || BuiltInFictitiousFunctionClassFactory2) ? cubicCurveData4.getAuthRequestContext : pointF;
            PointF pointF4 = cubicCurveData3.BuiltInFictitiousFunctionClassFactory;
            PointF pointF5 = cubicCurveData5.KClassImpl$Data$declaredNonStaticMembers$2;
            PointF pointF6 = cubicCurveData3.KClassImpl$Data$declaredNonStaticMembers$2;
            boolean z2 = !shapeData.BuiltInFictitiousFunctionClassFactory() && i3 == 0 && i3 == list3.size() + (-1);
            if (pointF3.equals(pointF) && pointF4.equals(pointF) && !z2) {
                float f3 = pointF.x;
                float f4 = pointF5.x;
                float f5 = pointF.y;
                float f6 = pointF5.y;
                float f7 = pointF6.x;
                float f8 = pointF.x;
                list = list3;
                float f9 = pointF6.y;
                z = BuiltInFictitiousFunctionClassFactory2;
                float f10 = pointF.y;
                float f11 = f3 - f4;
                shapeData2 = shapeData5;
                List<CubicCurveData> list6 = list5;
                float hypot = (float) Math.hypot(f11, f5 - f6);
                float hypot2 = (float) Math.hypot(f7 - f8, f9 - f10);
                float min = Math.min(floatValue / hypot, 0.5f);
                float min2 = Math.min(floatValue / hypot2, 0.5f);
                float f12 = pointF.x + ((pointF5.x - pointF.x) * min);
                float f13 = pointF.y + ((pointF5.y - pointF.y) * min);
                float f14 = pointF.x + ((pointF6.x - pointF.x) * min2);
                float f15 = pointF.y + ((pointF6.y - pointF.y) * min2);
                float f16 = pointF.x;
                float f17 = pointF.y;
                float f18 = pointF.x;
                float f19 = pointF.y;
                list2 = list6;
                CubicCurveData cubicCurveData6 = list2.get(KClassImpl$Data$declaredNonStaticMembers$2(i4 - 1, list6.size()));
                CubicCurveData cubicCurveData7 = list2.get(i4);
                cubicCurveData6.getAuthRequestContext.set(f12, f13);
                cubicCurveData6.KClassImpl$Data$declaredNonStaticMembers$2.set(f12, f13);
                if (i3 == 0) {
                    if (shapeData2.getAuthRequestContext == null) {
                        shapeData2.getAuthRequestContext = new PointF();
                    }
                    shapeData2.getAuthRequestContext.set(f12, f13);
                }
                cubicCurveData7.BuiltInFictitiousFunctionClassFactory.set(f12 - ((f12 - f16) * 0.5519f), f13 - ((f13 - f17) * 0.5519f));
                int i5 = i4 + 1;
                CubicCurveData cubicCurveData8 = list2.get(i5);
                cubicCurveData7.getAuthRequestContext.set(f14 - ((f14 - f18) * 0.5519f), f15 - ((f15 - f19) * 0.5519f));
                cubicCurveData7.KClassImpl$Data$declaredNonStaticMembers$2.set(f14, f15);
                cubicCurveData8.BuiltInFictitiousFunctionClassFactory.set(f14, f15);
                i4 = i5 + 1;
            } else {
                list = list3;
                shapeData2 = shapeData5;
                list2 = list5;
                z = BuiltInFictitiousFunctionClassFactory2;
                CubicCurveData cubicCurveData9 = list2.get(KClassImpl$Data$declaredNonStaticMembers$2(i4 - 1, list2.size()));
                CubicCurveData cubicCurveData10 = list2.get(i4);
                cubicCurveData9.getAuthRequestContext.set(cubicCurveData4.KClassImpl$Data$declaredNonStaticMembers$2.x, cubicCurveData4.KClassImpl$Data$declaredNonStaticMembers$2.y);
                cubicCurveData9.KClassImpl$Data$declaredNonStaticMembers$2.set(cubicCurveData4.KClassImpl$Data$declaredNonStaticMembers$2.x, cubicCurveData4.KClassImpl$Data$declaredNonStaticMembers$2.y);
                cubicCurveData10.BuiltInFictitiousFunctionClassFactory.set(cubicCurveData3.KClassImpl$Data$declaredNonStaticMembers$2.x, cubicCurveData3.KClassImpl$Data$declaredNonStaticMembers$2.y);
                i4++;
            }
            i3++;
            shapeData3 = shapeData;
            shapeData5 = shapeData2;
            list5 = list2;
            list3 = list;
            BuiltInFictitiousFunctionClassFactory2 = z;
        }
        return shapeData5;
    }
}
