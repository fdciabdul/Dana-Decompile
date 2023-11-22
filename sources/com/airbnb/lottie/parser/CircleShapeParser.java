package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;

/* loaded from: classes3.dex */
public class CircleShapeParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", BranchLinkConstant.PayloadKey.PROMO_CODE, "s", "hd", d.f7256a);

    private CircleShapeParser() {
    }

    public static CircleShape MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        boolean z2 = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult2 = jsonReader.PlaceComponentResult(PlaceComponentResult);
            if (PlaceComponentResult2 == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult2 == 1) {
                animatableValue = AnimatablePathValueParser.getAuthRequestContext(jsonReader, lottieComposition);
            } else if (PlaceComponentResult2 == 2) {
                animatablePointValue = AnimatableValueParser.getAuthRequestContext(jsonReader, lottieComposition);
            } else if (PlaceComponentResult2 == 3) {
                z2 = jsonReader.getErrorConfigVersion();
            } else if (PlaceComponentResult2 == 4) {
                z = jsonReader.scheduleImpl() == 3;
            } else {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z, z2);
    }
}
