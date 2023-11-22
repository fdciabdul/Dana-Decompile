package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class LayerParser {
    private static final JsonReader.Options MyBillsEntityDataFactory = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("nm", "ind", "refId", "ty", "parent", "sw", "sh", RVParams.SAFEPAY_CONTEXT, "ks", RVParams.TRANSPARENT, "masksProperties", "shapes", SecurityConstants.KEY_TEXT, "ef", RVParams.SHOW_REPORT_BTN, RVParams.SHOW_TITLEBAR, "w", "h", SemanticAttributes.NetTransportValues.IP, "op", RVParams.TOOLBAR_MENU, "cl", "hd");
    private static final JsonReader.Options getAuthRequestContext = JsonReader.Options.BuiltInFictitiousFunctionClassFactory(d.f7256a, "a");
    private static final JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("ty", "nm");

    private LayerParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Layer BuiltInFictitiousFunctionClassFactory(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        String str;
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableFloatValue animatableFloatValue3;
        AnimatableFloatValue animatableFloatValue4;
        int i;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        boolean z = false;
        long j = 0;
        String str2 = "UNSET";
        Layer.MatteType matteType2 = matteType;
        long j2 = -1;
        String str3 = null;
        float f = 0.0f;
        Layer.LayerType layerType = null;
        String str4 = null;
        AnimatableTransform animatableTransform = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f2 = 1.0f;
        float f3 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        boolean z2 = false;
        BlurEffect blurEffect = null;
        DropShadowEffect dropShadowEffect = null;
        float f4 = 0.0f;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            int i7 = 1;
            switch (jsonReader.PlaceComponentResult(MyBillsEntityDataFactory)) {
                case 0:
                    str2 = jsonReader.moveToNextValue();
                    break;
                case 1:
                    j = jsonReader.scheduleImpl();
                    break;
                case 2:
                    str4 = jsonReader.moveToNextValue();
                    break;
                case 3:
                    int scheduleImpl = jsonReader.scheduleImpl();
                    if (scheduleImpl < Layer.LayerType.UNKNOWN.ordinal()) {
                        layerType = Layer.LayerType.values()[scheduleImpl];
                        break;
                    } else {
                        layerType = Layer.LayerType.UNKNOWN;
                        break;
                    }
                case 4:
                    j2 = jsonReader.scheduleImpl();
                    break;
                case 5:
                    i2 = (int) (jsonReader.scheduleImpl() * Utils.getAuthRequestContext());
                    break;
                case 6:
                    i3 = (int) (jsonReader.scheduleImpl() * Utils.getAuthRequestContext());
                    break;
                case 7:
                    i4 = Color.parseColor(jsonReader.moveToNextValue());
                    break;
                case 8:
                    animatableTransform = AnimatableTransformParser.getAuthRequestContext(jsonReader, lottieComposition);
                    break;
                case 9:
                    int scheduleImpl2 = jsonReader.scheduleImpl();
                    if (scheduleImpl2 >= Layer.MatteType.values().length) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported matte type: ");
                        sb.append(scheduleImpl2);
                        String obj = sb.toString();
                        Logger.getAuthRequestContext(obj);
                        lottieComposition.initRecordTimeStamp.add(obj);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[scheduleImpl2];
                        int i8 = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[matteType2.ordinal()];
                        if (i8 == 1) {
                            Logger.getAuthRequestContext("Unsupported matte type: Luma");
                            lottieComposition.initRecordTimeStamp.add("Unsupported matte type: Luma");
                        } else if (i8 == 2) {
                            Logger.getAuthRequestContext("Unsupported matte type: Luma Inverted");
                            lottieComposition.initRecordTimeStamp.add("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition.GetContactSyncConfig++;
                        break;
                    }
                case 10:
                    jsonReader.getAuthRequestContext();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        arrayList2.add(MaskParser.MyBillsEntityDataFactory(jsonReader, lottieComposition));
                    }
                    lottieComposition.GetContactSyncConfig += arrayList2.size();
                    jsonReader.MyBillsEntityDataFactory();
                    break;
                case 11:
                    jsonReader.getAuthRequestContext();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        ContentModel MyBillsEntityDataFactory2 = ContentModelParser.MyBillsEntityDataFactory(jsonReader, lottieComposition);
                        if (MyBillsEntityDataFactory2 != null) {
                            arrayList3.add(MyBillsEntityDataFactory2);
                        }
                    }
                    jsonReader.MyBillsEntityDataFactory();
                    break;
                case 12:
                    jsonReader.BuiltInFictitiousFunctionClassFactory();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        int PlaceComponentResult2 = jsonReader.PlaceComponentResult(getAuthRequestContext);
                        if (PlaceComponentResult2 == 0) {
                            animatableTextFrame = AnimatableValueParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, lottieComposition);
                        } else if (PlaceComponentResult2 == 1) {
                            jsonReader.getAuthRequestContext();
                            if (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.getAuthRequestContext(jsonReader, lottieComposition);
                            }
                            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                jsonReader.DatabaseTableConfigUtil();
                            }
                            jsonReader.MyBillsEntityDataFactory();
                        } else {
                            jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                            jsonReader.DatabaseTableConfigUtil();
                        }
                    }
                    jsonReader.PlaceComponentResult();
                    break;
                case 13:
                    jsonReader.getAuthRequestContext();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        jsonReader.BuiltInFictitiousFunctionClassFactory();
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            int PlaceComponentResult3 = jsonReader.PlaceComponentResult(PlaceComponentResult);
                            if (PlaceComponentResult3 == 0) {
                                int scheduleImpl3 = jsonReader.scheduleImpl();
                                if (scheduleImpl3 == 29) {
                                    blurEffect = BlurEffectParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, lottieComposition);
                                } else if (scheduleImpl3 == 25) {
                                    DropShadowEffectParser dropShadowEffectParser = new DropShadowEffectParser();
                                    while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                        if (jsonReader.PlaceComponentResult(DropShadowEffectParser.KClassImpl$Data$declaredNonStaticMembers$2) == 0) {
                                            jsonReader.getAuthRequestContext();
                                            while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                                jsonReader.BuiltInFictitiousFunctionClassFactory();
                                                String str5 = "";
                                                while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                                                    int PlaceComponentResult4 = jsonReader.PlaceComponentResult(DropShadowEffectParser.BuiltInFictitiousFunctionClassFactory);
                                                    if (PlaceComponentResult4 == 0) {
                                                        str5 = jsonReader.moveToNextValue();
                                                    } else if (PlaceComponentResult4 == i7) {
                                                        str5.hashCode();
                                                        switch (str5.hashCode()) {
                                                            case 353103893:
                                                                if (str5.equals("Distance")) {
                                                                    i = 0;
                                                                    break;
                                                                }
                                                                i = -1;
                                                                break;
                                                            case 397447147:
                                                                if (str5.equals("Opacity")) {
                                                                    i = 1;
                                                                    break;
                                                                }
                                                                i = -1;
                                                                break;
                                                            case 1041377119:
                                                                if (str5.equals("Direction")) {
                                                                    i = 2;
                                                                    break;
                                                                }
                                                                i = -1;
                                                                break;
                                                            case 1379387491:
                                                                if (str5.equals("Shadow Color")) {
                                                                    i = 3;
                                                                    break;
                                                                }
                                                                i = -1;
                                                                break;
                                                            case 1383710113:
                                                                if (str5.equals("Softness")) {
                                                                    i = 4;
                                                                    break;
                                                                }
                                                                i = -1;
                                                                break;
                                                            default:
                                                                i = -1;
                                                                break;
                                                        }
                                                        if (i == 0) {
                                                            dropShadowEffectParser.getAuthRequestContext = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                                                        } else if (i == i7) {
                                                            dropShadowEffectParser.lookAheadTest = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
                                                        } else if (i == 2) {
                                                            dropShadowEffectParser.MyBillsEntityDataFactory = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, false);
                                                        } else if (i == 3) {
                                                            dropShadowEffectParser.PlaceComponentResult = AnimatableValueParser.BuiltInFictitiousFunctionClassFactory(jsonReader, lottieComposition);
                                                        } else if (i == 4) {
                                                            dropShadowEffectParser.NetworkUserEntityData$$ExternalSyntheticLambda0 = AnimatableValueParser.PlaceComponentResult(jsonReader, lottieComposition);
                                                        } else {
                                                            jsonReader.DatabaseTableConfigUtil();
                                                        }
                                                    } else {
                                                        jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                                        jsonReader.DatabaseTableConfigUtil();
                                                    }
                                                    i7 = 1;
                                                }
                                                jsonReader.PlaceComponentResult();
                                                i7 = 1;
                                            }
                                            jsonReader.MyBillsEntityDataFactory();
                                            i7 = 1;
                                        } else {
                                            jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                            jsonReader.DatabaseTableConfigUtil();
                                        }
                                    }
                                    AnimatableColorValue animatableColorValue = dropShadowEffectParser.PlaceComponentResult;
                                    dropShadowEffect = (animatableColorValue == null || (animatableFloatValue = dropShadowEffectParser.lookAheadTest) == null || (animatableFloatValue2 = dropShadowEffectParser.MyBillsEntityDataFactory) == null || (animatableFloatValue3 = dropShadowEffectParser.getAuthRequestContext) == null || (animatableFloatValue4 = dropShadowEffectParser.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) ? null : new DropShadowEffect(animatableColorValue, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4);
                                }
                            } else if (PlaceComponentResult3 == i7) {
                                arrayList4.add(jsonReader.moveToNextValue());
                            } else {
                                jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                                jsonReader.DatabaseTableConfigUtil();
                            }
                            i7 = 1;
                        }
                        jsonReader.PlaceComponentResult();
                        i7 = 1;
                    }
                    jsonReader.MyBillsEntityDataFactory();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ");
                    sb2.append(arrayList4);
                    String obj2 = sb2.toString();
                    Logger.getAuthRequestContext(obj2);
                    lottieComposition.initRecordTimeStamp.add(obj2);
                    break;
                case 14:
                    f2 = (float) jsonReader.lookAheadTest();
                    continue;
                case 15:
                    f3 = (float) jsonReader.lookAheadTest();
                    continue;
                case 16:
                    i5 = (int) (jsonReader.scheduleImpl() * Utils.getAuthRequestContext());
                    continue;
                case 17:
                    i6 = (int) (jsonReader.scheduleImpl() * Utils.getAuthRequestContext());
                    continue;
                case 18:
                    f = (float) jsonReader.lookAheadTest();
                    continue;
                case 19:
                    f4 = (float) jsonReader.lookAheadTest();
                    continue;
                case 20:
                    animatableFloatValue5 = AnimatableValueParser.MyBillsEntityDataFactory(jsonReader, lottieComposition, z);
                    continue;
                case 21:
                    str3 = jsonReader.moveToNextValue();
                    continue;
                case 22:
                    z2 = jsonReader.getErrorConfigVersion();
                    continue;
                default:
                    jsonReader.NetworkUserEntityData$$ExternalSyntheticLambda2();
                    jsonReader.DatabaseTableConfigUtil();
                    break;
            }
            z = false;
        }
        jsonReader.PlaceComponentResult();
        ArrayList arrayList5 = new ArrayList();
        if (f > 0.0f) {
            arrayList = arrayList2;
            str = str3;
            arrayList5.add(new Keyframe(lottieComposition, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f)));
        } else {
            arrayList = arrayList2;
            str = str3;
        }
        if (f4 <= 0.0f) {
            f4 = lottieComposition.MyBillsEntityDataFactory;
        }
        arrayList5.add(new Keyframe(lottieComposition, valueOf, valueOf, (Interpolator) null, f, Float.valueOf(f4)));
        arrayList5.add(new Keyframe(lottieComposition, valueOf2, valueOf2, (Interpolator) null, f4, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str)) {
            Logger.getAuthRequestContext("Convert your Illustrator layers to shape layers.");
            lottieComposition.initRecordTimeStamp.add("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList3, lottieComposition, str2, j, layerType, j2, str4, arrayList, animatableTransform, i2, i3, i4, f2, f3, i5, i6, animatableTextFrame, animatableTextProperties, arrayList5, matteType2, animatableFloatValue5, z2, blurEffect, dropShadowEffect);
    }

    /* renamed from: com.airbnb.lottie.parser.LayerParser$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer PlaceComponentResult(LottieComposition lottieComposition) {
        Rect rect = lottieComposition.KClassImpl$Data$declaredNonStaticMembers$2;
        return new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }
}
