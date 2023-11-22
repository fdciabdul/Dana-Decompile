package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    public List<ShapeModifierContent> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ShapeData NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Path moveToNextValue;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ShapeData();
        this.moveToNextValue = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* synthetic */ Path MyBillsEntityDataFactory(Keyframe<ShapeData> keyframe, float f) {
        ShapeData shapeData = keyframe.moveToNextValue;
        ShapeData shapeData2 = keyframe.KClassImpl$Data$declaredNonStaticMembers$2;
        ShapeData shapeData3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (shapeData3.getAuthRequestContext == null) {
            shapeData3.getAuthRequestContext = new PointF();
        }
        shapeData3.PlaceComponentResult = shapeData.BuiltInFictitiousFunctionClassFactory() || shapeData2.BuiltInFictitiousFunctionClassFactory();
        if (shapeData.MyBillsEntityDataFactory.size() != shapeData2.MyBillsEntityDataFactory.size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Curves must have the same number of control points. Shape 1: ");
            sb.append(shapeData.MyBillsEntityDataFactory.size());
            sb.append("\tShape 2: ");
            sb.append(shapeData2.MyBillsEntityDataFactory.size());
            Logger.getAuthRequestContext(sb.toString());
        }
        int min = Math.min(shapeData.MyBillsEntityDataFactory.size(), shapeData2.MyBillsEntityDataFactory.size());
        if (shapeData3.MyBillsEntityDataFactory.size() < min) {
            for (int size = shapeData3.MyBillsEntityDataFactory.size(); size < min; size++) {
                shapeData3.MyBillsEntityDataFactory.add(new CubicCurveData());
            }
        } else if (shapeData3.MyBillsEntityDataFactory.size() > min) {
            for (int size2 = shapeData3.MyBillsEntityDataFactory.size() - 1; size2 >= min; size2--) {
                List<CubicCurveData> list = shapeData3.MyBillsEntityDataFactory;
                list.remove(list.size() - 1);
            }
        }
        PointF pointF = shapeData.getAuthRequestContext;
        PointF pointF2 = shapeData2.getAuthRequestContext;
        float PlaceComponentResult = MiscUtils.PlaceComponentResult(pointF.x, pointF2.x, f);
        float PlaceComponentResult2 = MiscUtils.PlaceComponentResult(pointF.y, pointF2.y, f);
        if (shapeData3.getAuthRequestContext == null) {
            shapeData3.getAuthRequestContext = new PointF();
        }
        shapeData3.getAuthRequestContext.set(PlaceComponentResult, PlaceComponentResult2);
        for (int size3 = shapeData3.MyBillsEntityDataFactory.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.MyBillsEntityDataFactory.get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.MyBillsEntityDataFactory.get(size3);
            PointF pointF3 = cubicCurveData.BuiltInFictitiousFunctionClassFactory;
            PointF pointF4 = cubicCurveData.getAuthRequestContext;
            PointF pointF5 = cubicCurveData.KClassImpl$Data$declaredNonStaticMembers$2;
            PointF pointF6 = cubicCurveData2.BuiltInFictitiousFunctionClassFactory;
            PointF pointF7 = cubicCurveData2.getAuthRequestContext;
            PointF pointF8 = cubicCurveData2.KClassImpl$Data$declaredNonStaticMembers$2;
            shapeData3.MyBillsEntityDataFactory.get(size3).BuiltInFictitiousFunctionClassFactory.set(MiscUtils.PlaceComponentResult(pointF3.x, pointF6.x, f), MiscUtils.PlaceComponentResult(pointF3.y, pointF6.y, f));
            shapeData3.MyBillsEntityDataFactory.get(size3).getAuthRequestContext.set(MiscUtils.PlaceComponentResult(pointF4.x, pointF7.x, f), MiscUtils.PlaceComponentResult(pointF4.y, pointF7.y, f));
            shapeData3.MyBillsEntityDataFactory.get(size3).KClassImpl$Data$declaredNonStaticMembers$2.set(MiscUtils.PlaceComponentResult(pointF5.x, pointF8.x, f), MiscUtils.PlaceComponentResult(pointF5.y, pointF8.y, f));
        }
        ShapeData shapeData4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        List<ShapeModifierContent> list2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (list2 != null) {
            for (int size4 = list2.size() - 1; size4 >= 0; size4--) {
                shapeData4 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size4).BuiltInFictitiousFunctionClassFactory(shapeData4);
            }
        }
        MiscUtils.MyBillsEntityDataFactory(shapeData4, this.moveToNextValue);
        return this.moveToNextValue;
    }
}
