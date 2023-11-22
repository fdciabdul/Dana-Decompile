package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatablePointValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableValue;
import com.alibaba.griver.lottie.model.content.RectangleShape;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;

/* loaded from: classes6.dex */
public class RectangleShapeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", BranchLinkConstant.PayloadKey.PROMO_CODE, "s", BranchLinkConstant.PayloadKey.REFERRAL, "hd");

    private RectangleShapeParser() {
    }

    public static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (selectName == 4) {
                z = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z);
    }
}
