package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableValue;
import com.alibaba.griver.lottie.model.content.PolystarShape;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.io.IOException;

/* loaded from: classes6.dex */
public class PolystarShapeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "sy", "pt", BranchLinkConstant.PayloadKey.PROMO_CODE, BranchLinkConstant.PayloadKey.REFERRAL, "or", H5GetLogInfoBridge.RESULT_OS, "ir", "is", "hd");

    private PolystarShapeParser() {
    }

    public static PolystarShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 3:
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 5:
                    animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue6 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 7:
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 8:
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 9:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, z);
    }
}
