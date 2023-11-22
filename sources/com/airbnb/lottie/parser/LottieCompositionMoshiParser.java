package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.contract.payasset.SceneType;
import id.dana.data.constant.BranchLinkConstant;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class LottieCompositionMoshiParser {
    private static final JsonReader.Options BuiltInFictitiousFunctionClassFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("w", "h", SemanticAttributes.NetTransportValues.IP, "op", "fr", SecurityConstants.KEY_VALUE, "layers", SceneType.ASSETS, "fonts", "chars", "markers");
    static JsonReader.Options KClassImpl$Data$declaredNonStaticMembers$2 = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("id", "layers", "w", "h", BranchLinkConstant.PayloadKey.PROMO_CODE, "u");
    private static final JsonReader.Options MyBillsEntityDataFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("list");
    private static final JsonReader.Options getAuthRequestContext = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("cm", RVParams.TOOLBAR_MENU, RVParams.DELAY_RENDER);

    public static LottieComposition KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader) throws IOException {
        ArrayList arrayList;
        int i;
        float f;
        float f2;
        int i2;
        int i3;
        int i4;
        float f3;
        float f4;
        float authRequestContext = Utils.getAuthRequestContext();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        float f5 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            float f8 = f5;
            switch (jsonReader.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory)) {
                case 0:
                    i5 = jsonReader.scheduleImpl();
                    f5 = f8;
                    break;
                case 1:
                    f4 = f7;
                    i6 = jsonReader.scheduleImpl();
                    f5 = f8;
                    f7 = f4;
                    break;
                case 2:
                    f4 = f7;
                    f6 = (float) jsonReader.lookAheadTest();
                    f5 = f8;
                    f7 = f4;
                    break;
                case 3:
                    f5 = f8;
                    f7 = ((float) jsonReader.lookAheadTest()) - 0.01f;
                    arrayList3 = arrayList3;
                    break;
                case 4:
                    f4 = f7;
                    f5 = (float) jsonReader.lookAheadTest();
                    f7 = f4;
                    break;
                case 5:
                    arrayList = arrayList3;
                    i = i6;
                    f = f6;
                    f2 = f7;
                    i2 = i5;
                    String[] split = jsonReader.moveToNextValue().split("\\.");
                    if (!Utils.getAuthRequestContext(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]))) {
                        Logger.getAuthRequestContext("Lottie only supports bodymovin >= 4.4.0");
                        lottieComposition.initRecordTimeStamp.add("Lottie only supports bodymovin >= 4.4.0");
                    }
                    i5 = i2;
                    f5 = f8;
                    f6 = f;
                    arrayList3 = arrayList;
                    f7 = f2;
                    i6 = i;
                    break;
                case 6:
                    arrayList = arrayList3;
                    i = i6;
                    f = f6;
                    f2 = f7;
                    i2 = i5;
                    jsonReader.getAuthRequestContext();
                    int i7 = 0;
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        Layer BuiltInFictitiousFunctionClassFactory2 = LayerParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition);
                        if (BuiltInFictitiousFunctionClassFactory2.lookAheadTest == Layer.LayerType.IMAGE) {
                            i7++;
                        }
                        arrayList2.add(BuiltInFictitiousFunctionClassFactory2);
                        longSparseArray.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2);
                        if (i7 > 4) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("You have ");
                            sb.append(i7);
                            sb.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                            Logger.getAuthRequestContext(sb.toString());
                        }
                    }
                    jsonReader.MyBillsEntityDataFactory();
                    i5 = i2;
                    f5 = f8;
                    f6 = f;
                    arrayList3 = arrayList;
                    f7 = f2;
                    i6 = i;
                    break;
                case 7:
                    f = f6;
                    f2 = f7;
                    jsonReader.getAuthRequestContext();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        ArrayList arrayList4 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        jsonReader.BuiltInFictitiousFunctionClassFactory();
                        String str = null;
                        String str2 = null;
                        String str3 = null;
                        int i8 = 0;
                        int i9 = 0;
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            int PlaceComponentResult = jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                            if (PlaceComponentResult != 0) {
                                ArrayList arrayList5 = arrayList3;
                                if (PlaceComponentResult != 1) {
                                    if (PlaceComponentResult == 2) {
                                        i8 = jsonReader.scheduleImpl();
                                    } else if (PlaceComponentResult == 3) {
                                        i9 = jsonReader.scheduleImpl();
                                    } else if (PlaceComponentResult == 4) {
                                        str2 = jsonReader.moveToNextValue();
                                    } else if (PlaceComponentResult == 5) {
                                        str3 = jsonReader.moveToNextValue();
                                    } else {
                                        jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                        jsonReader.DatabaseTableConfigUtil();
                                        i3 = i5;
                                        i4 = i6;
                                    }
                                    arrayList3 = arrayList5;
                                } else {
                                    jsonReader.getAuthRequestContext();
                                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                        Layer BuiltInFictitiousFunctionClassFactory3 = LayerParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition);
                                        longSparseArray2.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory3);
                                        arrayList4.add(BuiltInFictitiousFunctionClassFactory3);
                                        i5 = i5;
                                        i6 = i6;
                                    }
                                    i3 = i5;
                                    i4 = i6;
                                    jsonReader.MyBillsEntityDataFactory();
                                }
                                i5 = i3;
                                arrayList3 = arrayList5;
                                i6 = i4;
                            } else {
                                str = jsonReader.moveToNextValue();
                            }
                        }
                        ArrayList arrayList6 = arrayList3;
                        int i10 = i5;
                        int i11 = i6;
                        jsonReader.PlaceComponentResult();
                        if (str2 != null) {
                            LottieImageAsset lottieImageAsset = new LottieImageAsset(i8, i9, str, str2, str3);
                            hashMap2.put(lottieImageAsset.getAuthRequestContext, lottieImageAsset);
                        } else {
                            hashMap.put(str, arrayList4);
                        }
                        i5 = i10;
                        arrayList3 = arrayList6;
                        i6 = i11;
                    }
                    arrayList = arrayList3;
                    i2 = i5;
                    i = i6;
                    jsonReader.MyBillsEntityDataFactory();
                    i5 = i2;
                    f5 = f8;
                    f6 = f;
                    arrayList3 = arrayList;
                    f7 = f2;
                    i6 = i;
                    break;
                case 8:
                    f = f6;
                    f2 = f7;
                    jsonReader.BuiltInFictitiousFunctionClassFactory();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        if (jsonReader.PlaceComponentResult(MyBillsEntityDataFactory) == 0) {
                            jsonReader.getAuthRequestContext();
                            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                Font PlaceComponentResult2 = FontParser.PlaceComponentResult(jsonReader);
                                hashMap3.put(PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2);
                            }
                            jsonReader.MyBillsEntityDataFactory();
                        } else {
                            jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                            jsonReader.DatabaseTableConfigUtil();
                        }
                    }
                    jsonReader.PlaceComponentResult();
                    arrayList = arrayList3;
                    i2 = i5;
                    i = i6;
                    i5 = i2;
                    f5 = f8;
                    f6 = f;
                    arrayList3 = arrayList;
                    f7 = f2;
                    i6 = i;
                    break;
                case 9:
                    f = f6;
                    f2 = f7;
                    jsonReader.getAuthRequestContext();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        FontCharacter MyBillsEntityDataFactory2 = FontCharacterParser.MyBillsEntityDataFactory(jsonReader, lottieComposition);
                        sparseArrayCompat.PlaceComponentResult(MyBillsEntityDataFactory2.hashCode(), MyBillsEntityDataFactory2);
                    }
                    jsonReader.MyBillsEntityDataFactory();
                    arrayList = arrayList3;
                    i2 = i5;
                    i = i6;
                    i5 = i2;
                    f5 = f8;
                    f6 = f;
                    arrayList3 = arrayList;
                    f7 = f2;
                    i6 = i;
                    break;
                case 10:
                    jsonReader.getAuthRequestContext();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        jsonReader.BuiltInFictitiousFunctionClassFactory();
                        String str4 = null;
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            int PlaceComponentResult3 = jsonReader.PlaceComponentResult(getAuthRequestContext);
                            if (PlaceComponentResult3 != 0) {
                                float f11 = f7;
                                if (PlaceComponentResult3 == 1) {
                                    f3 = f6;
                                    f9 = (float) jsonReader.lookAheadTest();
                                } else if (PlaceComponentResult3 == 2) {
                                    f3 = f6;
                                    f10 = (float) jsonReader.lookAheadTest();
                                } else {
                                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                    jsonReader.DatabaseTableConfigUtil();
                                    f7 = f11;
                                }
                                f7 = f11;
                                f6 = f3;
                            } else {
                                str4 = jsonReader.moveToNextValue();
                            }
                        }
                        jsonReader.PlaceComponentResult();
                        arrayList3.add(new Marker(str4, f9, f10));
                        f6 = f6;
                        f7 = f7;
                    }
                    f = f6;
                    f2 = f7;
                    jsonReader.MyBillsEntityDataFactory();
                    arrayList = arrayList3;
                    i2 = i5;
                    i = i6;
                    i5 = i2;
                    f5 = f8;
                    f6 = f;
                    arrayList3 = arrayList;
                    f7 = f2;
                    i6 = i;
                    break;
                default:
                    arrayList = arrayList3;
                    i = i6;
                    f = f6;
                    f2 = f7;
                    i2 = i5;
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                    i5 = i2;
                    f5 = f8;
                    f6 = f;
                    arrayList3 = arrayList;
                    f7 = f2;
                    i6 = i;
                    break;
            }
        }
        lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2 = new Rect(0, 0, (int) (i5 * authRequestContext), (int) (i6 * authRequestContext));
        lottieComposition.DatabaseTableConfigUtil = f6;
        lottieComposition.MyBillsEntityDataFactory = f7;
        lottieComposition.PlaceComponentResult = f5;
        lottieComposition.getErrorConfigVersion = arrayList2;
        lottieComposition.lookAheadTest = longSparseArray;
        lottieComposition.NetworkUserEntityData$$ExternalSyntheticLambda2 = hashMap;
        lottieComposition.moveToNextValue = hashMap2;
        lottieComposition.getAuthRequestContext = sparseArrayCompat;
        lottieComposition.BuiltInFictitiousFunctionClassFactory = hashMap3;
        lottieComposition.scheduleImpl = arrayList3;
        return lottieComposition;
    }
}
