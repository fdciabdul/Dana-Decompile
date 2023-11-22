package id.dana.data.toggle.traffictype;

import android.content.Context;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.tracker.MixpanelEntityRepository;
import id.dana.domain.feeds.model.FeedsSource;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.lib.toggle.ToggleClientConfig;
import id.dana.lib.toggle.ToggleManager;
import id.dana.lib.toggle.factory.AbstractToggleFactory;
import id.dana.lib.toggle.result.RawResult;
import io.split.android.client.SplitResult;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ,\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0006\b\u0000\u0010\u001e\u0018\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u0001H\u001eH\u0086\b¢\u0006\u0002\u0010!J\"\u0010\"\u001a\u0004\u0018\u0001H\u001e\"\u0006\b\u0000\u0010\u001e\u0018\u00012\b\u0010#\u001a\u0004\u0018\u00010\bH\u0086\b¢\u0006\u0002\u0010$J\"\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u0013J8\u0010(\u001a\u0002H\u001e\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u0002H\u001e2\u0006\u0010)\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u0013H\u0086\b¢\u0006\u0002\u0010*JH\u0010(\u001a\u0002H\u001e\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u0013H\u0087\b¢\u0006\u0002\u0010+J7\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u001e0-\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0-2\b\b\u0002\u0010'\u001a\u00020\u0013H\u0086\bJ6\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u001e0/\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u0002H\u001e2\b\b\u0002\u0010'\u001a\u00020\u0013H\u0086\b¢\u0006\u0002\u00100J6\u00101\u001a\b\u0012\u0004\u0012\u0002H\u001e0/\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u0002H\u001e2\b\b\u0002\u0010'\u001a\u00020\u0013H\u0086\b¢\u0006\u0002\u00100JF\u00101\u001a\b\u0012\u0004\u0012\u0002H\u001e0/\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010'\u001a\u00020\u0013H\u0087\b¢\u0006\u0002\u00102J\u000e\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\bJ3\u00105\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e06\"\u0006\b\u0000\u0010\u001e\u0018\u00012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010)\u001a\u00020\u0013H\u0086\bJK\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e060/\"\u0006\b\u0000\u0010\u001e\u0018\u00012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00132\b\b\u0002\u0010'\u001a\u00020\u0013H\u0087\bJB\u00109\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001H\u001e0:\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e062\b\u0010 \u001a\u0004\u0018\u0001H\u001eH\u0086\b¢\u0006\u0002\u0010<J\"\u0010=\u001a\u00020>2\u0006\u0010&\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020>2\b\b\u0002\u0010'\u001a\u00020\u0013JC\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e06\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e062\b\b\u0002\u0010'\u001a\u00020\u0013H\u0086\bJS\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e06\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e\u0018\u0001062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010'\u001a\u00020\u0013H\u0087\bJ(\u0010@\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\bJ\"\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b062\f\u00107\u001a\b\u0012\u0004\u0012\u00020\b0-J:\u0010C\u001a\b\u0012\u0004\u0012\u0002H\u001e0/\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\b\b\u0002\u0010D\u001a\u00020\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H\u001eH\u0086\b¢\u0006\u0002\u0010EJ:\u0010F\u001a\b\u0012\u0004\u0012\u0002H\u001e0/\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010&\u001a\u00020\b2\b\b\u0002\u0010D\u001a\u00020\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u0001H\u001eH\u0086\b¢\u0006\u0002\u0010EJ\u001a\u0010G\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\b2\b\b\u0002\u0010D\u001a\u00020\u0013Jj\u0010H\u001a\u00020I\"\u0006\b\u0000\u0010\u001e\u0018\u00012\u0006\u0010J\u001a\u00020K2\u0006\u0010'\u001a\u00020\u00132\u0014\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u0001H\u001e0M2\u0006\u0010N\u001a\u00020\b2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u001e062\b\u0010 \u001a\u0004\u0018\u0001H\u001e2\u0006\u0010)\u001a\u00020\u0013H\u0086\b¢\u0006\u0002\u0010OJ\u0006\u0010P\u001a\u00020IJ\u0006\u0010Q\u001a\u00020IJ\u0006\u0010\u001c\u001a\u00020IJ\u000e\u0010R\u001a\u00020I2\u0006\u0010S\u001a\u00020\bJ(\u0010T\u001a\u00020I2\b\b\u0002\u0010U\u001a\u00020\b2\u0006\u0010S\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010W\u001a\u00020XJ\b\u0010Y\u001a\u00020\bH&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lid/dana/data/toggle/traffictype/BaseTrafficType;", "Lid/dana/lib/toggle/factory/AbstractToggleFactory;", "Lid/dana/data/toggle/traffictype/ITrafficTypeFactory;", HummerConstants.CONTEXT, "Landroid/content/Context;", "config", "Lid/dana/lib/toggle/ToggleClientConfig;", "apikey", "", "mixpanelEntityRepository", "Lid/dana/data/tracker/MixpanelEntityRepository;", "(Landroid/content/Context;Lid/dana/lib/toggle/ToggleClientConfig;Ljava/lang/String;Lid/dana/data/tracker/MixpanelEntityRepository;)V", "getContext", "()Landroid/content/Context;", "firebasePerformanceTraceInstances", "Ljava/util/HashMap;", "Lcom/google/firebase/perf/metrics/Trace;", "Lkotlin/collections/HashMap;", "isAdded", "", "()Z", "matchingKeyFactory", "getMatchingKeyFactory", "()Ljava/lang/String;", "setMatchingKeyFactory", "(Ljava/lang/String;)V", "matchingKeyUser", "getMatchingKeyUser", "setMatchingKeyUser", "createDefaultValue", "T", "pathDefaultJsonValue", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "createObjectFromJsonPath", "jsonAssetsPath", "(Ljava/lang/String;)Ljava/lang/Object;", "getBooleanConfig", "splitName", "throwExceptionIfControl", "getConfig", "isNeedToDeserialized", "(Ljava/lang/String;Ljava/lang/Object;ZZ)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZZ)Ljava/lang/Object;", "getConfigArrayObject", "", "getConfigCachedOnceReady", "Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/Object;Z)Lio/reactivex/Observable;", "getConfigOnceReady", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)Lio/reactivex/Observable;", "getConfigSource", "treatment", "getConfigs", "", "splitNames", "getConfigsOnceReady", "getDefaultValue", "Lkotlin/Function1;", "defaultMapValue", "(Ljava/util/Map;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "getIntConfig", "", "getMapConfig", "getRawConfig", "jsonDefaultValue", "getRawConfigs", "getTreatmentWithConfigSdkReady", "isNeedToThrowWhenGotControl", "(Ljava/lang/String;ZLjava/lang/Object;)Lio/reactivex/Observable;", "getTreatmentWithConfigSdkReadyCached", "getTreatmentWithRawConfig", "mapResultConfigs", "", "value", "Lid/dana/lib/toggle/result/RawResult;", "map", "", "key", "(Lid/dana/lib/toggle/result/RawResult;ZLjava/util/Map;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Object;Z)V", "remove", "setMatchingKeyDevice", "startTrackingConfigRequestDuration", "configName", "stopTrackingConfigRequestDuration", "sourceKey", "configStatusKey", "configType", "Lid/dana/data/toggle/constant/ConfigType;", "trafficType", "Companion", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseTrafficType extends AbstractToggleFactory implements ITrafficTypeFactory {
    public static final Companion PlaceComponentResult = new Companion(null);
    public String BuiltInFictitiousFunctionClassFactory;
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;
    public String getAuthRequestContext;
    private final MixpanelEntityRepository getErrorConfigVersion;
    private HashMap<String, Trace> moveToNextValue;

    public abstract String BuiltInFictitiousFunctionClassFactory();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTrafficType(Context context, ToggleClientConfig toggleClientConfig, String str, MixpanelEntityRepository mixpanelEntityRepository) {
        super(context, toggleClientConfig, str);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(toggleClientConfig, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(mixpanelEntityRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.getErrorConfigVersion = mixpanelEntityRepository;
        this.moveToNextValue = new HashMap<>();
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.getAuthRequestContext = "DANAID";
    }

    @JvmName(name = "isAdded")
    public final boolean MyBillsEntityDataFactory() {
        Set<String> keySet;
        HashMap<String, AbstractToggleFactory> hashMap = ToggleManager.MyBillsEntityDataFactory().PlaceComponentResult;
        if (hashMap == null || (keySet = hashMap.keySet()) == null) {
            return false;
        }
        Set<String> set = keySet;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), BuiltInFictitiousFunctionClassFactory())) {
                return true;
            }
        }
        return false;
    }

    public final void MyBillsEntityDataFactory(String str, String str2, String str3, ConfigType configType) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(configType, "");
        Trace trace = this.moveToNextValue.get(str2);
        if (trace != null) {
            trace.putAttribute("configSource", str);
            trace.putAttribute("configName", str2);
            trace.putAttribute("configStatus", str3);
            trace.putAttribute("configType", configType.getValue());
            trace.putAttribute("configTrafficType", Intrinsics.areEqual(this.getAuthRequestContext, "DANAID") ? "DEVICE" : FeedsSource.USER);
            trace.stop();
        }
        this.moveToNextValue.remove(str2);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        HashMap<String, Trace> hashMap = this.moveToNextValue;
        Trace newTrace = FirebasePerformance.getInstance().newTrace(TrackerDataKey.Event.CONFIG_REQUEST_DURATION);
        newTrace.start();
        Intrinsics.checkNotNullExpressionValue(newTrace, "");
        hashMap.put(str, newTrace);
    }

    public final String getAuthRequestContext(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        KClassImpl$Data$declaredNonStaticMembers$2(str);
        RawResult MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory().MyBillsEntityDataFactory(str, BuiltInFictitiousFunctionClassFactory(), this.getAuthRequestContext);
        String str2 = MyBillsEntityDataFactory.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        String authRequestContext = getAuthRequestContext(str2);
        if (z && Intrinsics.areEqual(MyBillsEntityDataFactory.getAuthRequestContext, "control")) {
            MyBillsEntityDataFactory(authRequestContext, str, "Not Received", ConfigType.SYNC);
            throw new UnexpectedTreatment(str);
        }
        MyBillsEntityDataFactory(authRequestContext, str, "Received", ConfigType.SYNC);
        return MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static String getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Intrinsics.areEqual(str, "control") ? HeaderConstant.HEADER_KEY_CONTROL : Intrinsics.areEqual(str, "_wrapper_cache") ? "Wrapper Cache" : "SDK Cache";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        Object m3179constructorimpl;
        Intrinsics.checkNotNullParameter(str, "");
        try {
            Result.Companion companion = Result.INSTANCE;
            BaseTrafficType baseTrafficType = this;
            SplitResult BuiltInFictitiousFunctionClassFactory = ToggleManager.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str, BuiltInFictitiousFunctionClassFactory(), null);
            String config = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.config() : null;
            if (config == null) {
                config = JsonUtil.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, str2);
            }
            m3179constructorimpl = Result.m3179constructorimpl(config);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m3185isFailureimpl(m3179constructorimpl) ? null : m3179constructorimpl;
    }

    public static /* synthetic */ boolean getAuthRequestContext(BaseTrafficType baseTrafficType, String str, boolean z, int i) {
        if ((i & 4) != 0) {
            z = false;
        }
        return baseTrafficType.getAuthRequestContext(str, false, z);
    }

    public final boolean getAuthRequestContext(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        String authRequestContext = getAuthRequestContext(str, z2);
        if (authRequestContext != null) {
            String str2 = authRequestContext;
            StringBuilder sb = new StringBuilder();
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char charAt = str2.charAt(i);
                if ((!CharsKt.isWhitespace(charAt)) != false) {
                    sb.append(charAt);
                }
            }
            String obj = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return obj != null ? Boolean.parseBoolean(obj) : z;
        }
        return z;
    }

    public static /* synthetic */ int PlaceComponentResult(BaseTrafficType baseTrafficType, String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext(str, false);
        return authRequestContext != null ? NumberExtKt.toSafeInt(authRequestContext, i) : i;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/toggle/traffictype/BaseTrafficType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
