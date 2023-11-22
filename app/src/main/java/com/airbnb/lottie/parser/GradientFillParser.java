package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;
import java.util.Collections;

/* loaded from: classes3.dex */
public class GradientFillParser {
    private static final JsonReader.Options KClassImpl$Data$declaredNonStaticMembers$2 = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "g", "o", SecurityConstants.KEY_TEXT, "s", e.PlaceComponentResult, BranchLinkConstant.PayloadKey.REFERRAL, "hd");
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory(BranchLinkConstant.PayloadKey.PROMO_CODE, "k");

    private GradientFillParser() {
    }

    public static GradientFill getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean z = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            switch (jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2)) {
                case 0:
                    str = jsonReader.moveToNextValue();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.BuiltInFictitiousFunctionClassFactory();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        int PlaceComponentResult2 = jsonReader.PlaceComponentResult(PlaceComponentResult);
                        if (PlaceComponentResult2 == 0) {
                            i = jsonReader.scheduleImpl();
                        } else if (PlaceComponentResult2 == 1) {
                            animatableGradientColorValue = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition, i);
                        } else {
                            jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                            jsonReader.DatabaseTableConfigUtil();
                        }
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
                    fillType = jsonReader.scheduleImpl() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.getErrorConfigVersion();
                    break;
                default:
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                    break;
            }
        }
        return new GradientFill(str, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue == null ? new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100))) : animatableIntegerValue, animatablePointValue, animatablePointValue2, z);
    }
}
