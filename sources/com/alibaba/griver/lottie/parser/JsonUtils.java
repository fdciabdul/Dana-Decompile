package com.alibaba.griver.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
class JsonUtils {
    private static final JsonReader.Options POINT_NAMES = JsonReader.Options.of("x", "y");

    private JsonUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int jsonToColor(JsonReader jsonReader) throws IOException {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> jsonToPoints(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(jsonToPoint(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.lottie.parser.JsonUtils$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$lottie$parser$moshi$JsonReader$Token;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            $SwitchMap$com$alibaba$griver$lottie$parser$moshi$JsonReader$Token = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF jsonToPoint(JsonReader jsonReader, float f) throws IOException {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$lottie$parser$moshi$JsonReader$Token[jsonReader.peek().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return jsonObjectToPoint(jsonReader, f);
                }
                JsonReader.Token peek = jsonReader.peek();
                StringBuilder sb = new StringBuilder("jsonToPoint lottie动画错误,peek=");
                sb.append(peek);
                sb.append(",path=");
                sb.append(jsonReader.getPath());
                if (peek == JsonReader.Token.STRING) {
                    sb.append(",nextStr=");
                    sb.append(jsonReader.nextString());
                }
                String obj = sb.toString();
                GriverLogger.e(com.iap.ac.android.common.json.JsonUtils.TAG, obj);
                throw new IllegalArgumentException(obj);
            }
            return jsonArrayToPoint(jsonReader, f);
        }
        return jsonNumbersToPoint(jsonReader, f);
    }

    private static PointF jsonNumbersToPoint(JsonReader jsonReader, float f) throws IOException {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    private static PointF jsonArrayToPoint(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonReader.Token.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    private static PointF jsonObjectToPoint(JsonReader jsonReader, float f) throws IOException {
        jsonReader.beginObject();
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(POINT_NAMES);
            if (selectName == 0) {
                f2 = valueFromObject(jsonReader);
            } else if (selectName == 1) {
                f3 = valueFromObject(jsonReader);
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return new PointF(f2 * f, f3 * f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float valueFromObject(JsonReader jsonReader) throws IOException {
        JsonReader.Token peek = jsonReader.peek();
        int i = AnonymousClass1.$SwitchMap$com$alibaba$griver$lottie$parser$moshi$JsonReader$Token[peek.ordinal()];
        if (i != 1) {
            if (i == 2) {
                jsonReader.beginArray();
                float nextDouble = (float) jsonReader.nextDouble();
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                jsonReader.endArray();
                return nextDouble;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown value for token of type ");
            sb.append(peek);
            throw new IllegalArgumentException(sb.toString());
        }
        return (float) jsonReader.nextDouble();
    }
}
