package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class ShapeStrokeParser {
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "c", "w", "o", "lc", "lj", "ml", "hd", d.f7256a);
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("n", SecurityConstants.KEY_VALUE);

    private ShapeStrokeParser() {
    }

    public static ShapeStroke getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        char c;
        ArrayList arrayList = new ArrayList();
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f = 0.0f;
        boolean z = false;
        AnimatableIntegerValue animatableIntegerValue = null;
        while (true) {
            int i = 100;
            if (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                switch (jsonReader.PlaceComponentResult(PlaceComponentResult)) {
                    case 0:
                        str = jsonReader.moveToNextValue();
                        break;
                    case 1:
                        animatableColorValue = AnimatableValueParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition);
                        break;
                    case 2:
                        animatableFloatValue2 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                        break;
                    case 3:
                        animatableIntegerValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition);
                        break;
                    case 4:
                        lineCapType = ShapeStroke.LineCapType.values()[jsonReader.scheduleImpl() - 1];
                        break;
                    case 5:
                        lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.scheduleImpl() - 1];
                        break;
                    case 6:
                        f = (float) jsonReader.lookAheadTest();
                        break;
                    case 7:
                        z = jsonReader.getErrorConfigVersion();
                        break;
                    case 8:
                        jsonReader.getAuthRequestContext();
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            jsonReader.BuiltInFictitiousFunctionClassFactory();
                            AnimatableFloatValue animatableFloatValue3 = null;
                            String str2 = null;
                            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                int PlaceComponentResult2 = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                                if (PlaceComponentResult2 == 0) {
                                    str2 = jsonReader.moveToNextValue();
                                } else if (PlaceComponentResult2 == 1) {
                                    animatableFloatValue3 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                                } else {
                                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                    jsonReader.DatabaseTableConfigUtil();
                                }
                            }
                            jsonReader.PlaceComponentResult();
                            str2.hashCode();
                            int hashCode = str2.hashCode();
                            if (hashCode == i) {
                                if (str2.equals(d.f7256a)) {
                                    c = 0;
                                }
                                c = 65535;
                            } else if (hashCode != 103) {
                                if (hashCode == 111 && str2.equals("o")) {
                                    c = 2;
                                }
                                c = 65535;
                            } else {
                                if (str2.equals("g")) {
                                    c = 1;
                                }
                                c = 65535;
                            }
                            if (c == 0 || c == 1) {
                                lottieComposition.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                                arrayList.add(animatableFloatValue3);
                            } else if (c == 2) {
                                animatableFloatValue = animatableFloatValue3;
                            }
                            i = 100;
                        }
                        jsonReader.MyBillsEntityDataFactory();
                        if (arrayList.size() != 1) {
                            break;
                        } else {
                            arrayList.add((AnimatableFloatValue) arrayList.get(0));
                            break;
                        }
                    default:
                        jsonReader.DatabaseTableConfigUtil();
                        break;
                }
            } else {
                if (animatableIntegerValue == null) {
                    animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
                }
                return new ShapeStroke(str, animatableFloatValue, arrayList, animatableColorValue, animatableIntegerValue, animatableFloatValue2, lineCapType, lineJoinType, f, z);
            }
        }
    }
}
