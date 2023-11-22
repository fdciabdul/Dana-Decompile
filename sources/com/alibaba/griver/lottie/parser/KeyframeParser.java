package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.lottie.utils.MiscUtils;
import com.alibaba.griver.lottie.utils.Utils;
import com.alibaba.griver.lottie.value.Keyframe;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.push.e;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
class KeyframeParser {
    private static final float MAX_CP_VALUE = 100.0f;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static JsonReader.Options NAMES = JsonReader.Options.of(SecurityConstants.KEY_TEXT, "s", e.PlaceComponentResult, "o", i.MyBillsEntityDataFactory, "h", LoginTrackingConstants.LoginParam.TO, RVParams.TITLE_IMAGE);

    KeyframeParser() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int i) {
        WeakReference<Interpolator> BuiltInFictitiousFunctionClassFactory;
        synchronized (KeyframeParser.class) {
            BuiltInFictitiousFunctionClassFactory = pathInterpolatorCache().BuiltInFictitiousFunctionClassFactory(i);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.PlaceComponentResult(i, weakReference);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        jsonReader.beginObject();
        PointF pointF = null;
        PointF pointF2 = null;
        T t = null;
        T t2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    t2 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointF = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 4:
                    pointF2 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 7:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = LINEAR_INTERPOLATOR;
            t2 = t;
        } else if (pointF != null && pointF2 != null) {
            float f3 = -f;
            pointF.x = MiscUtils.clamp(pointF.x, f3, f);
            pointF.y = MiscUtils.clamp(pointF.y, -100.0f, (float) MAX_CP_VALUE);
            pointF2.x = MiscUtils.clamp(pointF2.x, f3, f);
            pointF2.y = MiscUtils.clamp(pointF2.y, -100.0f, (float) MAX_CP_VALUE);
            int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, pointF2.y);
            WeakReference<Interpolator> interpolator2 = getInterpolator(hashFor);
            Interpolator interpolator3 = interpolator2 != null ? interpolator2.get() : null;
            if (interpolator2 == null || interpolator3 == null) {
                interpolator3 = PathInterpolatorCompat.KClassImpl$Data$declaredNonStaticMembers$2(pointF.x / f, pointF.y / f, pointF2.x / f, pointF2.y / f);
                try {
                    putInterpolator(hashFor, new WeakReference(interpolator3));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
            interpolator = interpolator3;
        } else {
            interpolator = LINEAR_INTERPOLATOR;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t, t2, interpolator, f2, null);
        keyframe.pathCp1 = pointF3;
        keyframe.pathCp2 = pointF4;
        return keyframe;
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f));
    }
}
