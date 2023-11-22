package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatablePointValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableValue;
import com.alibaba.griver.lottie.model.content.CircleShape;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;

/* loaded from: classes6.dex */
public class CircleShapeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", BranchLinkConstant.PayloadKey.PROMO_CODE, "s", "hd", d.f7256a);

    private CircleShapeParser() {
    }

    public static CircleShape parse(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z2 = jsonReader.nextBoolean();
            } else if (selectName == 4) {
                z = jsonReader.nextInt() == 3;
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z, z2);
    }
}
