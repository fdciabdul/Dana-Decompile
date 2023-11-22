package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.push.e;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
class KeyframeParser {
    private static SparseArrayCompat<WeakReference<Interpolator>> getAuthRequestContext;
    private static final Interpolator BuiltInFictitiousFunctionClassFactory = new LinearInterpolator();
    static JsonReader.Options PlaceComponentResult = JsonReader.Options.BuiltInFictitiousFunctionClassFactory(SecurityConstants.KEY_TEXT, "s", e.PlaceComponentResult, "o", i.MyBillsEntityDataFactory, "h", LoginTrackingConstants.LoginParam.TO, RVParams.TITLE_IMAGE);
    static JsonReader.Options KClassImpl$Data$declaredNonStaticMembers$2 = JsonReader.Options.BuiltInFictitiousFunctionClassFactory("x", "y");

    KeyframeParser() {
    }

    private static WeakReference<Interpolator> KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        WeakReference<Interpolator> BuiltInFictitiousFunctionClassFactory2;
        synchronized (KeyframeParser.class) {
            if (getAuthRequestContext == null) {
                getAuthRequestContext = new SparseArrayCompat<>();
            }
            BuiltInFictitiousFunctionClassFactory2 = getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i);
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    private static void getAuthRequestContext(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            getAuthRequestContext.PlaceComponentResult(i, weakReference);
        }
    }

    private static Interpolator BuiltInFictitiousFunctionClassFactory(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = MiscUtils.MyBillsEntityDataFactory(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.MyBillsEntityDataFactory(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.MyBillsEntityDataFactory(pointF2.x, -1.0f, 1.0f);
        pointF2.y = MiscUtils.MyBillsEntityDataFactory(pointF2.y, -100.0f, 100.0f);
        int authRequestContext = Utils.getAuthRequestContext(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        Interpolator interpolator = KClassImpl$Data$declaredNonStaticMembers$22 != null ? KClassImpl$Data$declaredNonStaticMembers$22.get() : null;
        if (KClassImpl$Data$declaredNonStaticMembers$22 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.KClassImpl$Data$declaredNonStaticMembers$2(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.KClassImpl$Data$declaredNonStaticMembers$2(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                getAuthRequestContext(authRequestContext, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Keyframe<T> BuiltInFictitiousFunctionClassFactory(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z, boolean z2) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t;
        Interpolator interpolator3;
        T t2;
        Interpolator interpolator4;
        Interpolator interpolator5;
        T t3;
        PointF pointF;
        Keyframe<T> keyframe;
        PointF pointF2;
        PointF pointF3;
        if (!z || !z2) {
            if (z) {
                jsonReader.BuiltInFictitiousFunctionClassFactory();
                PointF pointF4 = null;
                PointF pointF5 = null;
                PointF pointF6 = null;
                PointF pointF7 = null;
                boolean z3 = false;
                T t4 = null;
                float f2 = 0.0f;
                T t5 = null;
                while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    switch (jsonReader.PlaceComponentResult(PlaceComponentResult)) {
                        case 0:
                            f2 = (float) jsonReader.lookAheadTest();
                            break;
                        case 1:
                            t4 = valueParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                            break;
                        case 2:
                            t5 = valueParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                            break;
                        case 3:
                            pointF7 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, 1.0f);
                            break;
                        case 4:
                            pointF4 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, 1.0f);
                            break;
                        case 5:
                            if (jsonReader.scheduleImpl() != 1) {
                                z3 = false;
                                break;
                            } else {
                                z3 = true;
                                break;
                            }
                        case 6:
                            pointF5 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                            break;
                        case 7:
                            pointF6 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                            break;
                        default:
                            jsonReader.DatabaseTableConfigUtil();
                            break;
                    }
                }
                jsonReader.PlaceComponentResult();
                if (z3) {
                    interpolator2 = BuiltInFictitiousFunctionClassFactory;
                    t = t4;
                } else {
                    if (pointF7 != null && pointF4 != null) {
                        interpolator = BuiltInFictitiousFunctionClassFactory(pointF7, pointF4);
                    } else {
                        interpolator = BuiltInFictitiousFunctionClassFactory;
                    }
                    interpolator2 = interpolator;
                    t = t5;
                }
                Keyframe<T> keyframe2 = new Keyframe<>(lottieComposition, t4, t, interpolator2, f2, (Float) null);
                keyframe2.getErrorConfigVersion = pointF5;
                keyframe2.scheduleImpl = pointF6;
                return keyframe2;
            }
            return new Keyframe<>(valueParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f));
        }
        jsonReader.BuiltInFictitiousFunctionClassFactory();
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        boolean z4 = false;
        PointF pointF11 = null;
        PointF pointF12 = null;
        PointF pointF13 = null;
        T t6 = null;
        PointF pointF14 = null;
        T t7 = null;
        PointF pointF15 = null;
        float f3 = 0.0f;
        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
            switch (jsonReader.PlaceComponentResult(PlaceComponentResult)) {
                case 0:
                    pointF2 = pointF9;
                    f3 = (float) jsonReader.lookAheadTest();
                    break;
                case 1:
                    t6 = valueParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                    continue;
                case 2:
                    t7 = valueParser.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                    continue;
                case 3:
                    pointF2 = pointF9;
                    PointF pointF16 = pointF10;
                    T t8 = t7;
                    if (jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.BuiltInFictitiousFunctionClassFactory();
                        float f4 = 0.0f;
                        float f5 = 0.0f;
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            int PlaceComponentResult2 = jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                            if (PlaceComponentResult2 != 0) {
                                if (PlaceComponentResult2 == 1) {
                                    if (jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER) {
                                        f7 = (float) jsonReader.lookAheadTest();
                                        f5 = f7;
                                    } else {
                                        jsonReader.getAuthRequestContext();
                                        f5 = (float) jsonReader.lookAheadTest();
                                        f7 = jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER ? (float) jsonReader.lookAheadTest() : f5;
                                        jsonReader.MyBillsEntityDataFactory();
                                    }
                                } else {
                                    jsonReader.DatabaseTableConfigUtil();
                                }
                            } else if (jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER) {
                                f6 = (float) jsonReader.lookAheadTest();
                                f4 = f6;
                            } else {
                                jsonReader.getAuthRequestContext();
                                f4 = (float) jsonReader.lookAheadTest();
                                f6 = jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER ? (float) jsonReader.lookAheadTest() : f4;
                                jsonReader.MyBillsEntityDataFactory();
                            }
                        }
                        PointF pointF17 = new PointF(f4, f5);
                        PointF pointF18 = new PointF(f6, f7);
                        jsonReader.PlaceComponentResult();
                        t7 = t8;
                        pointF10 = pointF16;
                        pointF13 = pointF17;
                        pointF9 = pointF2;
                        pointF14 = pointF18;
                        continue;
                    } else {
                        pointF11 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                        t7 = t8;
                        pointF10 = pointF16;
                        break;
                    }
                case 4:
                    T t9 = t7;
                    if (jsonReader.GetContactSyncConfig() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.BuiltInFictitiousFunctionClassFactory();
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        while (jsonReader.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            PointF pointF19 = pointF9;
                            int PlaceComponentResult3 = jsonReader.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                            if (PlaceComponentResult3 != 0) {
                                pointF3 = pointF10;
                                if (PlaceComponentResult3 == 1) {
                                    if (jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER) {
                                        f11 = (float) jsonReader.lookAheadTest();
                                        pointF10 = pointF3;
                                        f9 = f11;
                                        pointF9 = pointF19;
                                    } else {
                                        jsonReader.getAuthRequestContext();
                                        f9 = (float) jsonReader.lookAheadTest();
                                        f11 = jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER ? (float) jsonReader.lookAheadTest() : f9;
                                        jsonReader.MyBillsEntityDataFactory();
                                    }
                                } else {
                                    jsonReader.DatabaseTableConfigUtil();
                                }
                                pointF10 = pointF3;
                                pointF9 = pointF19;
                            } else {
                                pointF3 = pointF10;
                                if (jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER) {
                                    f10 = (float) jsonReader.lookAheadTest();
                                    pointF10 = pointF3;
                                    f8 = f10;
                                    pointF9 = pointF19;
                                } else {
                                    jsonReader.getAuthRequestContext();
                                    f8 = (float) jsonReader.lookAheadTest();
                                    f10 = jsonReader.GetContactSyncConfig() == JsonReader.Token.NUMBER ? (float) jsonReader.lookAheadTest() : f8;
                                    jsonReader.MyBillsEntityDataFactory();
                                    pointF10 = pointF3;
                                    pointF9 = pointF19;
                                }
                            }
                        }
                        pointF2 = pointF9;
                        PointF pointF20 = new PointF(f8, f9);
                        pointF8 = new PointF(f10, f11);
                        jsonReader.PlaceComponentResult();
                        t7 = t9;
                        pointF15 = pointF20;
                        break;
                    } else {
                        pointF12 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                        t7 = t9;
                        continue;
                    }
                case 5:
                    if (jsonReader.scheduleImpl() == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                        continue;
                    }
                case 6:
                    pointF10 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                    continue;
                case 7:
                    pointF9 = JsonUtils.KClassImpl$Data$declaredNonStaticMembers$2(jsonReader, f);
                    continue;
                default:
                    jsonReader.DatabaseTableConfigUtil();
                    continue;
            }
            pointF9 = pointF2;
        }
        PointF pointF21 = pointF9;
        PointF pointF22 = pointF10;
        T t10 = t7;
        jsonReader.PlaceComponentResult();
        if (z4) {
            interpolator3 = BuiltInFictitiousFunctionClassFactory;
            t3 = t6;
        } else {
            if (pointF11 != null && pointF12 != null) {
                interpolator3 = BuiltInFictitiousFunctionClassFactory(pointF11, pointF12);
            } else if (pointF13 != null && pointF14 != null && pointF15 != null && pointF8 != null) {
                Interpolator BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(pointF13, pointF15);
                Interpolator BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(pointF14, pointF8);
                t2 = t10;
                interpolator4 = BuiltInFictitiousFunctionClassFactory2;
                interpolator5 = BuiltInFictitiousFunctionClassFactory3;
                interpolator3 = null;
                if (interpolator4 == null && interpolator5 != null) {
                    keyframe = new Keyframe<>(lottieComposition, t6, t2, interpolator4, interpolator5, f3);
                    pointF = pointF22;
                } else {
                    pointF = pointF22;
                    keyframe = new Keyframe<>(lottieComposition, t6, t2, interpolator3, f3, (Float) null);
                }
                keyframe.getErrorConfigVersion = pointF;
                keyframe.scheduleImpl = pointF21;
                return keyframe;
            } else {
                interpolator3 = BuiltInFictitiousFunctionClassFactory;
            }
            t3 = t10;
        }
        t2 = t3;
        interpolator4 = null;
        interpolator5 = null;
        if (interpolator4 == null) {
        }
        pointF = pointF22;
        keyframe = new Keyframe<>(lottieComposition, t6, t2, interpolator3, f3, (Float) null);
        keyframe.getErrorConfigVersion = pointF;
        keyframe.scheduleImpl = pointF21;
        return keyframe;
    }
}
