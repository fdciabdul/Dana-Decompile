package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AnimatablePathValueParser {
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("k", "x", "y");

    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue MyBillsEntityDataFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.getAuthRequestContext();
            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                arrayList.add(PathKeyframeParser.MyBillsEntityDataFactory(jsonReader, lottieComposition));
            }
            jsonReader.MyBillsEntityDataFactory();
            KeyframesParser.PlaceComponentResult(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, Utils.getAuthRequestContext())));
        }
        return new AnimatablePathValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableValue<PointF, PointF> getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        AnimatablePathValue animatablePathValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        boolean z = false;
        while (jsonReader.GetContactSyncConfig() != JsonReader.Token.END_OBJECT) {
            int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult == 0) {
                animatablePathValue = MyBillsEntityDataFactory(jsonReader, lottieComposition);
            } else if (PlaceComponentResult != 1) {
                if (PlaceComponentResult == 2) {
                    if (jsonReader.GetContactSyncConfig() == JsonReader.Token.STRING) {
                        jsonReader.DatabaseTableConfigUtil();
                        z = true;
                    } else {
                        animatableFloatValue2 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                    }
                } else {
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                }
            } else if (jsonReader.GetContactSyncConfig() == JsonReader.Token.STRING) {
                jsonReader.DatabaseTableConfigUtil();
                z = true;
            } else {
                animatableFloatValue = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
            }
        }
        jsonReader.PlaceComponentResult();
        if (z) {
            Logger.getAuthRequestContext("Lottie doesn't support expressions.");
            lottieComposition.initRecordTimeStamp.add("Lottie doesn't support expressions.");
        }
        return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
    }
}
