package com.alibaba.griver.lottie.parser;

import android.graphics.Path;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableColorValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableIntegerValue;
import com.alibaba.griver.lottie.model.content.ShapeFill;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ShapeFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "o", "fillEnabled", BranchLinkConstant.PayloadKey.REFERRAL, "hd");

    private ShapeFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z = jsonReader.nextBoolean();
            } else if (selectName == 4) {
                i = jsonReader.nextInt();
            } else if (selectName == 5) {
                z2 = jsonReader.nextBoolean();
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        return new ShapeFill(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue, z2);
    }
}
