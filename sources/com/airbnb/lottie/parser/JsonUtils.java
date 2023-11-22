package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class JsonUtils {
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("x", "y");

    private JsonUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAuthRequestContext(JsonReader jsonReader) throws IOException {
        jsonReader.getAuthRequestContext();
        int lookAheadTest = (int) (jsonReader.lookAheadTest() * 255.0d);
        int lookAheadTest2 = (int) (jsonReader.lookAheadTest() * 255.0d);
        int lookAheadTest3 = (int) (jsonReader.lookAheadTest() * 255.0d);
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            jsonReader.DatabaseTableConfigUtil();
        }
        jsonReader.MyBillsEntityDataFactory();
        return Color.argb(255, lookAheadTest, lookAheadTest2, lookAheadTest3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> PlaceComponentResult(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.getAuthRequestContext();
        while (jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.getAuthRequestContext();
            arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f));
            jsonReader.MyBillsEntityDataFactory();
        }
        jsonReader.MyBillsEntityDataFactory();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader, float f) throws IOException {
        int i = AnonymousClass1.MyBillsEntityDataFactory[jsonReader.GetContactSyncConfig().ordinal()];
        if (i == 1) {
            float lookAheadTest = (float) jsonReader.lookAheadTest();
            float lookAheadTest2 = (float) jsonReader.lookAheadTest();
            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                jsonReader.DatabaseTableConfigUtil();
            }
            return new PointF(lookAheadTest * f, lookAheadTest2 * f);
        } else if (i == 2) {
            jsonReader.getAuthRequestContext();
            float lookAheadTest3 = (float) jsonReader.lookAheadTest();
            float lookAheadTest4 = (float) jsonReader.lookAheadTest();
            while (jsonReader.GetContactSyncConfig() != JsonReader.Token.END_ARRAY) {
                jsonReader.DatabaseTableConfigUtil();
            }
            jsonReader.MyBillsEntityDataFactory();
            return new PointF(lookAheadTest3 * f, lookAheadTest4 * f);
        } else if (i != 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown point starts with ");
            sb.append(jsonReader.GetContactSyncConfig());
            throw new IllegalArgumentException(sb.toString());
        } else {
            jsonReader.BuiltInFictitiousFunctionClassFactory();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                int PlaceComponentResult = jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                if (PlaceComponentResult == 0) {
                    f2 = BuiltInFictitiousFunctionClassFactory(jsonReader);
                } else if (PlaceComponentResult == 1) {
                    f3 = BuiltInFictitiousFunctionClassFactory(jsonReader);
                } else {
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                }
            }
            jsonReader.PlaceComponentResult();
            return new PointF(f2 * f, f3 * f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float BuiltInFictitiousFunctionClassFactory(JsonReader jsonReader) throws IOException {
        JsonReader.Token GetContactSyncConfig = jsonReader.GetContactSyncConfig();
        int i = AnonymousClass1.MyBillsEntityDataFactory[GetContactSyncConfig.ordinal()];
        if (i != 1) {
            if (i == 2) {
                jsonReader.getAuthRequestContext();
                float lookAheadTest = (float) jsonReader.lookAheadTest();
                while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    jsonReader.DatabaseTableConfigUtil();
                }
                jsonReader.MyBillsEntityDataFactory();
                return lookAheadTest;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown value for token of type ");
            sb.append(GetContactSyncConfig);
            throw new IllegalArgumentException(sb.toString());
        }
        return (float) jsonReader.lookAheadTest();
    }
}
