package com.alibaba.griver.lottie.parser;

import android.graphics.Path;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableGradientColorValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableIntegerValue;
import com.alibaba.griver.lottie.model.animatable.AnimatablePointValue;
import com.alibaba.griver.lottie.model.content.GradientFill;
import com.alibaba.griver.lottie.model.content.GradientType;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;

/* loaded from: classes6.dex */
public class GradientFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "g", "o", SecurityConstants.KEY_TEXT, "s", e.PlaceComponentResult, BranchLinkConstant.PayloadKey.REFERRAL, "hd");
    private static final JsonReader.Options GRADIENT_NAMES = JsonReader.Options.of(BranchLinkConstant.PayloadKey.PROMO_CODE, "k");

    private GradientFillParser() {
    }

    public static GradientFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader.selectName(GRADIENT_NAMES);
                        if (selectName == 0) {
                            i = jsonReader.nextInt();
                        } else if (selectName == 1) {
                            animatableGradientColorValue = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, i);
                        } else {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case 3:
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    break;
                case 5:
                    animatablePointValue2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    break;
                case 6:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        return new GradientFill(str, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, null, null, z);
    }
}
