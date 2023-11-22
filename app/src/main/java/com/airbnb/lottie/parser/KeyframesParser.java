package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class KeyframesParser {
    static JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("k");

    private KeyframesParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<Keyframe<T>> getAuthRequestContext(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.GetContactSyncConfig() != JsonReader.Token.STRING) {
            jsonReader.BuiltInFictitiousFunctionClassFactory();
            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (jsonReader.PlaceComponentResult(PlaceComponentResult) == 0) {
                    if (jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_ARRAY) {
                        jsonReader.getAuthRequestContext();
                        if (jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER) {
                            arrayList.add(KeyframeParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition, f, valueParser, false, z));
                        } else {
                            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                arrayList.add(KeyframeParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition, f, valueParser, true, z));
                            }
                        }
                        jsonReader.MyBillsEntityDataFactory();
                    } else {
                        arrayList.add(KeyframeParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition, f, valueParser, false, z));
                    }
                } else {
                    jsonReader.DatabaseTableConfigUtil();
                }
            }
            jsonReader.PlaceComponentResult();
            PlaceComponentResult(arrayList);
            return arrayList;
        }
        Logger.getAuthRequestContext("Lottie doesn't support expressions.");
        lottieComposition.initRecordTimeStamp.add("Lottie doesn't support expressions.");
        return arrayList;
    }

    public static <T> void PlaceComponentResult(List<? extends Keyframe<T>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Keyframe<T> keyframe = list.get(i2);
            i2++;
            Keyframe<T> keyframe2 = list.get(i2);
            keyframe.MyBillsEntityDataFactory = Float.valueOf(keyframe2.lookAheadTest);
            if (keyframe.KClassImpl$Data$declaredNonStaticMembers$2 == null && keyframe2.moveToNextValue != null) {
                keyframe.KClassImpl$Data$declaredNonStaticMembers$2 = keyframe2.moveToNextValue;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).PlaceComponentResult();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i);
        if ((keyframe3.moveToNextValue == null || keyframe3.KClassImpl$Data$declaredNonStaticMembers$2 == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
