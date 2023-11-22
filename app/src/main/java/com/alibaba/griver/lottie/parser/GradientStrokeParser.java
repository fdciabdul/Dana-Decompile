package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableGradientColorValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableIntegerValue;
import com.alibaba.griver.lottie.model.animatable.AnimatablePointValue;
import com.alibaba.griver.lottie.model.content.GradientStroke;
import com.alibaba.griver.lottie.model.content.GradientType;
import com.alibaba.griver.lottie.model.content.ShapeStroke;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class GradientStrokeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "g", "o", SecurityConstants.KEY_TEXT, "s", e.PlaceComponentResult, "w", "lc", "lj", "ml", "hd", d.f7256a);
    private static final JsonReader.Options GRADIENT_NAMES = JsonReader.Options.of(BranchLinkConstant.PayloadKey.PROMO_CODE, "k");
    private static final JsonReader.Options DASH_PATTERN_NAMES = JsonReader.Options.of("n", SecurityConstants.KEY_VALUE);

    private GradientStrokeParser() {
    }

    public static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableGradientColorValue animatableGradientColorValue;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue2 = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        AnimatableFloatValue animatableFloatValue2 = null;
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
                        if (selectName != 0) {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            if (selectName == 1) {
                                animatableGradientColorValue2 = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, i);
                            } else {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            }
                        } else {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            i = jsonReader.nextInt();
                        }
                        animatableGradientColorValue2 = animatableGradientColorValue;
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
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 9:
                    f = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z = jsonReader.nextBoolean();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        AnimatableFloatValue animatableFloatValue3 = null;
                        String str2 = null;
                        while (jsonReader.hasNext()) {
                            int selectName2 = jsonReader.selectName(DASH_PATTERN_NAMES);
                            if (selectName2 != 0) {
                                AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                                if (selectName2 == 1) {
                                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                } else {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                }
                                animatableFloatValue2 = animatableFloatValue4;
                            } else {
                                str2 = jsonReader.nextString();
                            }
                        }
                        AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                        jsonReader.endObject();
                        String str3 = str2;
                        if (str3.equals("o")) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (str3.equals(d.f7256a) || str3.equals("g")) {
                                lottieComposition.setHasDashPattern(true);
                                arrayList.add(animatableFloatValue3);
                            }
                            animatableFloatValue2 = animatableFloatValue5;
                        }
                    }
                    AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue6;
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        return new GradientStroke(str, gradientType, animatableGradientColorValue2, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f, arrayList, animatableFloatValue2, z);
    }
}
