package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class GradientStrokeParser {
    private static final JsonReader.Options MyBillsEntityDataFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "g", "o", SecurityConstants.KEY_TEXT, "s", e.PlaceComponentResult, "w", "lc", "lj", "ml", "hd", d.f7256a);
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory(BranchLinkConstant.PayloadKey.PROMO_CODE, "k");
    private static final JsonReader.Options KClassImpl$Data$declaredNonStaticMembers$2 = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("n", SecurityConstants.KEY_VALUE);

    private GradientStrokeParser() {
    }

    public static GradientStroke PlaceComponentResult(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableGradientColorValue animatableGradientColorValue;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue2 = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        AnimatableIntegerValue animatableIntegerValue = null;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            switch (jsonReader.PlaceComponentResult(MyBillsEntityDataFactory)) {
                case 0:
                    str = jsonReader.moveToNextValue();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.BuiltInFictitiousFunctionClassFactory();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                        if (PlaceComponentResult != 0) {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            if (PlaceComponentResult == 1) {
                                animatableGradientColorValue2 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition, i);
                            } else {
                                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                jsonReader.DatabaseTableConfigUtil();
                            }
                        } else {
                            animatableGradientColorValue = animatableGradientColorValue2;
                            i = jsonReader.scheduleImpl();
                        }
                        animatableGradientColorValue2 = animatableGradientColorValue;
                    }
                    jsonReader.PlaceComponentResult();
                    break;
                case 2:
                    animatableIntegerValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition);
                    break;
                case 3:
                    gradientType = jsonReader.scheduleImpl() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    animatablePointValue = AnimatableValueParser.getAuthRequestContext(jsonReader, lottieComposition);
                    break;
                case 5:
                    animatablePointValue2 = AnimatableValueParser.getAuthRequestContext(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.scheduleImpl() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.scheduleImpl() - 1];
                    break;
                case 9:
                    f = (float) jsonReader.lookAheadTest();
                    break;
                case 10:
                    z = jsonReader.getErrorConfigVersion();
                    break;
                case 11:
                    jsonReader.getAuthRequestContext();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        jsonReader.BuiltInFictitiousFunctionClassFactory();
                        AnimatableFloatValue animatableFloatValue3 = null;
                        String str2 = null;
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            int PlaceComponentResult2 = jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                            if (PlaceComponentResult2 != 0) {
                                AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                                if (PlaceComponentResult2 == 1) {
                                    animatableFloatValue3 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                                } else {
                                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                    jsonReader.DatabaseTableConfigUtil();
                                }
                                animatableFloatValue2 = animatableFloatValue4;
                            } else {
                                str2 = jsonReader.moveToNextValue();
                            }
                        }
                        AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                        jsonReader.PlaceComponentResult();
                        String str3 = str2;
                        if (str3.equals("o")) {
                            animatableFloatValue2 = animatableFloatValue3;
                        } else {
                            if (str3.equals(d.f7256a) || str3.equals("g")) {
                                lottieComposition.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                                arrayList.add(animatableFloatValue3);
                            }
                            animatableFloatValue2 = animatableFloatValue5;
                        }
                    }
                    AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                    jsonReader.MyBillsEntityDataFactory();
                    if (arrayList.size() == 1) {
                        arrayList.add((AnimatableFloatValue) arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue6;
                    break;
                default:
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                    break;
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        return new GradientStroke(str, gradientType, animatableGradientColorValue2, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f, arrayList, animatableFloatValue2, z);
    }
}
