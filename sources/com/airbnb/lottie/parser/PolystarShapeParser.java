package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.io.IOException;

/* loaded from: classes3.dex */
public class PolystarShapeParser {
    private static final JsonReader.Options MyBillsEntityDataFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "sy", "pt", BranchLinkConstant.PayloadKey.PROMO_CODE, BranchLinkConstant.PayloadKey.REFERRAL, "or", H5GetLogInfoBridge.RESULT_OS, "ir", "is", "hd", d.f7256a);

    private PolystarShapeParser() {
    }

    public static PolystarShape getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        boolean z2 = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            switch (jsonReader.PlaceComponentResult(MyBillsEntityDataFactory)) {
                case 0:
                    str = jsonReader.moveToNextValue();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.scheduleImpl());
                    break;
                case 2:
                    animatableFloatValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    animatableValue = AnimatablePathValueParser.getAuthRequestContext(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValue2 = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    animatableFloatValue4 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue6 = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    animatableFloatValue3 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                    break;
                case 8:
                    animatableFloatValue5 = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
                    break;
                case 9:
                    z2 = jsonReader.getErrorConfigVersion();
                    break;
                case 10:
                    if (jsonReader.scheduleImpl() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                default:
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                    break;
            }
        }
        return new PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, z2, z);
    }
}
