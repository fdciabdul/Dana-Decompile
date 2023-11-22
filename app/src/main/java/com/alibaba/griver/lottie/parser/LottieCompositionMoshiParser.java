package com.alibaba.griver.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.LottieImageAsset;
import com.alibaba.griver.lottie.model.Font;
import com.alibaba.griver.lottie.model.FontCharacter;
import com.alibaba.griver.lottie.model.Marker;
import com.alibaba.griver.lottie.model.ParagraphStyle;
import com.alibaba.griver.lottie.model.layer.Layer;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.lottie.utils.Logger;
import com.alibaba.griver.lottie.utils.Utils;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.contract.payasset.SceneType;
import id.dana.data.constant.BranchLinkConstant;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LottieCompositionMoshiParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("w", "h", SemanticAttributes.NetTransportValues.IP, "op", "fr", SecurityConstants.KEY_VALUE, "layers", SceneType.ASSETS, "fonts", "chars", "markers", LottieConstants.RENDER_TYPE_ANTMATIONS);
    static JsonReader.Options ASSETS_NAMES = JsonReader.Options.of("id", "layers", "w", "h", BranchLinkConstant.PayloadKey.PROMO_CODE, "u");
    private static final JsonReader.Options FONT_NAMES = JsonReader.Options.of("list");
    private static final JsonReader.Options MARKER_NAMES = JsonReader.Options.of("cm", RVParams.TOOLBAR_MENU, RVParams.DELAY_RENDER);

    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        ArrayList arrayList;
        HashMap hashMap;
        JsonReader jsonReader2 = jsonReader;
        float dpScale = Utils.dpScale();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(NAMES)) {
                case 0:
                    i = (int) jsonReader.nextDouble();
                    continue;
                    jsonReader2 = jsonReader;
                case 1:
                    arrayList = arrayList3;
                    hashMap5 = hashMap5;
                    i2 = (int) jsonReader.nextDouble();
                    break;
                case 2:
                    f = (float) jsonReader.nextDouble();
                    continue;
                    jsonReader2 = jsonReader;
                case 3:
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    f2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    hashMap5 = hashMap;
                    break;
                case 4:
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    f3 = (float) jsonReader.nextDouble();
                    hashMap5 = hashMap;
                    break;
                case 5:
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    hashMap5 = hashMap;
                    break;
                case 6:
                    parseLayers(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    hashMap5 = hashMap;
                    break;
                case 7:
                    parseAssets(jsonReader2, lottieComposition, hashMap2, hashMap3);
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    hashMap5 = hashMap;
                    break;
                case 8:
                    parseFonts(jsonReader2, hashMap4);
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    hashMap5 = hashMap;
                    break;
                case 9:
                    parseChars(jsonReader2, lottieComposition, sparseArrayCompat);
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    hashMap5 = hashMap;
                    break;
                case 10:
                    parseMarkers(jsonReader2, lottieComposition, arrayList3);
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    hashMap5 = hashMap;
                    break;
                case 11:
                    parseParagraphStyle(jsonReader2, hashMap5);
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    hashMap5 = hashMap;
                    break;
                default:
                    hashMap = hashMap5;
                    arrayList = arrayList3;
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    hashMap5 = hashMap;
                    break;
            }
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        lottieComposition.init(new Rect(0, 0, (int) (i * dpScale), (int) (i2 * dpScale)), f, f2, f3, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, hashMap5, arrayList3);
        return lottieComposition;
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer parse = LayerParser.parse(jsonReader, lottieComposition);
            if (parse.getLayerType() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(parse);
            longSparseArray.getAuthRequestContext(parse.getId(), parse);
            if (i > 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("You have ");
                sb.append(i);
                sb.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                Logger.warning(sb.toString());
            }
        }
        jsonReader.endArray();
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(ASSETS_NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        Layer parse = LayerParser.parse(jsonReader, lottieComposition);
                        longSparseArray.getAuthRequestContext(parse.getId(), parse);
                        arrayList.add(parse);
                    }
                    jsonReader.endArray();
                } else if (selectName == 2) {
                    i = (int) jsonReader.nextDouble();
                } else if (selectName == 3) {
                    i2 = (int) jsonReader.nextDouble();
                } else if (selectName == 4) {
                    str2 = jsonReader.nextString();
                } else if (selectName == 5) {
                    str3 = jsonReader.nextString();
                } else {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(i, i2, str, str2, str3);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(FONT_NAMES) == 0) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font parse = FontParser.parse(jsonReader);
                    map.put(parse.getName(), parse);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void parseParagraphStyle(JsonReader jsonReader, Map<String, ParagraphStyle> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(JsonReader.Options.of("paragraphStyle")) == 0) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    ParagraphStyle parse = ParagraphStyleParser.parse(jsonReader);
                    map.put(parse.getText(), parse);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipName();
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter parse = FontCharacterParser.parse(jsonReader, lottieComposition);
            sparseArrayCompat.PlaceComponentResult(parse.hashCode(), parse);
        }
        jsonReader.endArray();
    }

    private static void parseMarkers(JsonReader jsonReader, LottieComposition lottieComposition, List<Marker> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String str = null;
            jsonReader.beginObject();
            float f = 0.0f;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(MARKER_NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    f = (float) jsonReader.nextDouble();
                } else if (selectName == 2) {
                    f2 = (float) jsonReader.nextDouble();
                } else {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            list.add(new Marker(str, f, f2));
        }
        jsonReader.endArray();
    }
}
