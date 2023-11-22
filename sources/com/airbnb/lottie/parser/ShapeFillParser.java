package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import id.dana.data.constant.BranchLinkConstant;
import java.io.IOException;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ShapeFillParser {
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "c", "o", "fillEnabled", BranchLinkConstant.PayloadKey.REFERRAL, "hd");

    private ShapeFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeFill KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue = null;
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult == 0) {
                str = jsonReader.moveToNextValue();
            } else if (PlaceComponentResult == 1) {
                animatableColorValue = AnimatableValueParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition);
            } else if (PlaceComponentResult == 2) {
                animatableIntegerValue = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition);
            } else if (PlaceComponentResult == 3) {
                z = jsonReader.getErrorConfigVersion();
            } else if (PlaceComponentResult == 4) {
                i = jsonReader.scheduleImpl();
            } else if (PlaceComponentResult == 5) {
                z2 = jsonReader.getErrorConfigVersion();
            } else {
                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                jsonReader.DatabaseTableConfigUtil();
            }
        }
        return new ShapeFill(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue == null ? new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100))) : animatableIntegerValue, z2);
    }
}
