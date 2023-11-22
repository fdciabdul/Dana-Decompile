package id.dana.danah5.httprequest;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.griver.api.appinfo.GriverAppTypeEnum;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.danah5.httprequest.HttpRequestExtension;
import id.dana.data.network.RpcProxy;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danah5/httprequest/HttpRequestExtension;", "Lcom/alibaba/griver/base/common/bridge/GriverHttpRequestAPIExtension;", "Lcom/alibaba/griver/base/common/bridge/GriverHttpRequestAPIExtension$RequestContext;", "requestContext", "Lcom/alibaba/griver/api/common/network/HttpRequest;", "request", "Lcom/alibaba/griver/api/common/network/HttpResponse;", "newPerformRequest", "(Lcom/alibaba/griver/base/common/bridge/GriverHttpRequestAPIExtension$RequestContext;Lcom/alibaba/griver/api/common/network/HttpRequest;)Lcom/alibaba/griver/api/common/network/HttpResponse;", "performRequest", "(Lcom/alibaba/griver/api/common/network/HttpRequest;)Lcom/alibaba/griver/api/common/network/HttpResponse;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "holdLoginConfig", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;", "holdLoginV2Interceptor", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;", "Lid/dana/data/network/RpcProxy;", "rpcProxy", "Lid/dana/data/network/RpcProxy;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/network/RpcProxy;Lid/dana/data/toggle/SplitFacade;Lid/dana/utils/holdlogin/v2/HoldLoginConfig;Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HttpRequestExtension implements GriverHttpRequestAPIExtension {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String USER_AGENT = "User-Agent";
    private final HoldLoginConfig holdLoginConfig;
    private final HoldLoginV2Interceptor holdLoginV2Interceptor;
    private final RpcProxy rpcProxy;
    private final SplitFacade splitFacade;

    @JvmStatic
    public static final List<String> getWhitelistedAppIds(SplitFacade splitFacade) {
        return INSTANCE.getWhitelistedAppIds(splitFacade);
    }

    @Inject
    public HttpRequestExtension(RpcProxy rpcProxy, SplitFacade splitFacade, HoldLoginConfig holdLoginConfig, HoldLoginV2Interceptor holdLoginV2Interceptor) {
        Intrinsics.checkNotNullParameter(rpcProxy, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(holdLoginConfig, "");
        Intrinsics.checkNotNullParameter(holdLoginV2Interceptor, "");
        this.rpcProxy = rpcProxy;
        this.splitFacade = splitFacade;
        this.holdLoginConfig = holdLoginConfig;
        this.holdLoginV2Interceptor = holdLoginV2Interceptor;
    }

    @Override // com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension
    @Deprecated(message = "Deprecated in Java")
    public final HttpResponse performRequest(final HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, "");
        Map<String, String> headers = request.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "");
        headers.put("User-Agent", UserAgentFactory.getUserAgent());
        if (this.holdLoginConfig.BuiltInFictitiousFunctionClassFactory() && this.holdLoginConfig.getAuthRequestContext()) {
            this.holdLoginV2Interceptor.BuiltInFictitiousFunctionClassFactory(request);
            HttpResponse KClassImpl$Data$declaredNonStaticMembers$2 = this.rpcProxy.KClassImpl$Data$declaredNonStaticMembers$2(request);
            Object PlaceComponentResult = this.holdLoginV2Interceptor.PlaceComponentResult(request, KClassImpl$Data$declaredNonStaticMembers$2, new Function0<Object>() { // from class: id.dana.danah5.httprequest.HttpRequestExtension$performRequest$newResponse$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    RpcProxy rpcProxy;
                    rpcProxy = HttpRequestExtension.this.rpcProxy;
                    return rpcProxy.KClassImpl$Data$declaredNonStaticMembers$2(request);
                }
            });
            return (PlaceComponentResult == null || !(PlaceComponentResult instanceof HttpResponse)) ? KClassImpl$Data$declaredNonStaticMembers$2 : (HttpResponse) PlaceComponentResult;
        }
        return this.rpcProxy.KClassImpl$Data$declaredNonStaticMembers$2(request);
    }

    @Override // com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension
    public final HttpResponse performRequest(final GriverHttpRequestAPIExtension.RequestContext requestContext, final HttpRequest request) {
        Intrinsics.checkNotNullParameter(requestContext, "");
        Intrinsics.checkNotNullParameter(request, "");
        Map<String, String> headers = request.getHeaders();
        Intrinsics.checkNotNullExpressionValue(headers, "");
        headers.put("User-Agent", UserAgentFactory.getUserAgent());
        if (this.holdLoginConfig.BuiltInFictitiousFunctionClassFactory() && this.holdLoginConfig.getAuthRequestContext()) {
            this.holdLoginV2Interceptor.BuiltInFictitiousFunctionClassFactory(request);
            HttpResponse newPerformRequest = newPerformRequest(requestContext, request);
            Object PlaceComponentResult = this.holdLoginV2Interceptor.PlaceComponentResult(request, newPerformRequest, new Function0<Object>() { // from class: id.dana.danah5.httprequest.HttpRequestExtension$performRequest$newResponse$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    HttpResponse newPerformRequest2;
                    newPerformRequest2 = HttpRequestExtension.this.newPerformRequest(requestContext, request);
                    return newPerformRequest2;
                }
            });
            return (PlaceComponentResult == null || !(PlaceComponentResult instanceof HttpResponse)) ? newPerformRequest : (HttpResponse) PlaceComponentResult;
        }
        return this.rpcProxy.KClassImpl$Data$declaredNonStaticMembers$2(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpResponse newPerformRequest(GriverHttpRequestAPIExtension.RequestContext requestContext, HttpRequest request) {
        if (requestContext.appType == GriverAppTypeEnum.MINI_PROGRAM && !INSTANCE.getWhitelistedAppIds(this.splitFacade).contains(requestContext.appId)) {
            HttpResponse request2 = GriverTransport.request(request);
            Intrinsics.checkNotNullExpressionValue(request2, "");
            return request2;
        }
        return this.rpcProxy.KClassImpl$Data$declaredNonStaticMembers$2(request);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0083T¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/danah5/httprequest/HttpRequestExtension$Companion;", "", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "", "", "getWhitelistedAppIds", "(Lid/dana/data/toggle/SplitFacade;)Ljava/util/List;", "USER_AGENT", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private static int $10 = 0;
        private static int $11 = 1;
        private static short[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
        private static int MyBillsEntityDataFactory = 1257195693;
        private static int getAuthRequestContext = -543330877;
        private static int lookAheadTest = 0;
        private static int scheduleImpl = 1;
        private static byte[] BuiltInFictitiousFunctionClassFactory = {125, -13, -110, -10, 103, 100, -3, -6, 102, -4, 99, -15, 110, -10, 110, 99, -12, 112, -7, -4, 70, -7, -102, -2, -115, -120, -41, -110, -114, -16, -23};
        private static int PlaceComponentResult = 35521975;

        public static /* synthetic */ List $r8$lambda$C4RyhiZ_3ea2wzeVlRRL3g2YzdI(String str) {
            int i = scheduleImpl + 63;
            lookAheadTest = i % 128;
            if (!(i % 2 == 0)) {
                int i2 = 58 / 0;
                return m659getWhitelistedAppIds$lambda2(str);
            }
            try {
                return m659getWhitelistedAppIds$lambda2(str);
            } catch (Exception e) {
                throw e;
            }
        }

        public static /* synthetic */ ObservableSource $r8$lambda$d10DO_dK2nu7eR4SABaRknys8Fg(BaseTrafficType baseTrafficType) {
            int i = lookAheadTest + 87;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            ObservableSource m657getWhitelistedAppIds$lambda0 = m657getWhitelistedAppIds$lambda0(baseTrafficType);
            int i3 = scheduleImpl + 113;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 14 : '1') != '1') {
                Object obj = null;
                obj.hashCode();
                return m657getWhitelistedAppIds$lambda0;
            }
            return m657getWhitelistedAppIds$lambda0;
        }

        /* renamed from: $r8$lambda$rJMEg-Ph8ZzGqKpckgG9xbQKr6I  reason: not valid java name */
        public static /* synthetic */ String m656$r8$lambda$rJMEgPh8ZzGqKpckgG9xbQKr6I() {
            try {
                int i = lookAheadTest + 73;
                scheduleImpl = i % 128;
                int i2 = i % 2;
                try {
                    String m658getWhitelistedAppIds$lambda1 = m658getWhitelistedAppIds$lambda1();
                    int i3 = lookAheadTest + 9;
                    scheduleImpl = i3 % 128;
                    if (!(i3 % 2 == 0)) {
                        return m658getWhitelistedAppIds$lambda1;
                    }
                    int i4 = 29 / 0;
                    return m658getWhitelistedAppIds$lambda1;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<String> getWhitelistedAppIds(SplitFacade splitFacade) {
            try {
                Intrinsics.checkNotNullParameter(splitFacade, "");
                Object blockingFirst = splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.danah5.httprequest.HttpRequestExtension$Companion$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return HttpRequestExtension.Companion.$r8$lambda$d10DO_dK2nu7eR4SABaRknys8Fg((BaseTrafficType) obj);
                    }
                }).onErrorResumeNext(Observable.fromCallable(new Callable() { // from class: id.dana.danah5.httprequest.HttpRequestExtension$Companion$$ExternalSyntheticLambda1
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return HttpRequestExtension.Companion.m656$r8$lambda$rJMEgPh8ZzGqKpckgG9xbQKr6I();
                    }
                })).map(new Function() { // from class: id.dana.danah5.httprequest.HttpRequestExtension$Companion$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return HttpRequestExtension.Companion.$r8$lambda$C4RyhiZ_3ea2wzeVlRRL3g2YzdI((String) obj);
                    }
                }).blockingFirst();
                Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
                List<String> list = (List) blockingFirst;
                int i = lookAheadTest + 47;
                scheduleImpl = i % 128;
                if (!(i % 2 != 0)) {
                    Object obj = null;
                    obj.hashCode();
                    return list;
                }
                return list;
            } catch (Exception e) {
                throw e;
            }
        }

        /* renamed from: getWhitelistedAppIds$lambda-1  reason: not valid java name */
        private static final String m658getWhitelistedAppIds$lambda1() {
            String str;
            int i = scheduleImpl + 109;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            ConfigCenter configCenter = ConfigCenter.getInstance();
            Object[] objArr = new Object[1];
            a((ViewConfiguration.getScrollBarSize() >> 8) - 1223773460, TextUtils.getCapsMode("", 0, 0) - 51, (short) ((-16777280) - Color.rgb(0, 0, 0)), 1787681521 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (byte) (42 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), objArr);
            JSONObject sectionConfig = configCenter.getSectionConfig(((String) objArr[0]).intern());
            if ((sectionConfig != null ? (char) 27 : 'R') != 'R') {
                Object[] objArr2 = new Object[1];
                a((-1223773480) - Color.alpha(0), (ViewConfiguration.getTapTimeout() >> 16) - 51, (short) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 81), 1787681549 - (ViewConfiguration.getWindowTouchSlop() >> 8), (byte) ((-79) - TextUtils.indexOf("", "")), objArr2);
                JSONArray jSONArray = sectionConfig.getJSONArray(((String) objArr2[0]).intern());
                if ((jSONArray != null ? (char) 23 : (char) 16) != 16) {
                    str = jSONArray.toString();
                    int i3 = scheduleImpl + 37;
                    lookAheadTest = i3 % 128;
                    int i4 = i3 % 2;
                    return str;
                }
            }
            str = null;
            int i32 = scheduleImpl + 37;
            lookAheadTest = i32 % 128;
            int i42 = i32 % 2;
            return str;
        }

        /* renamed from: getWhitelistedAppIds$lambda-2  reason: not valid java name */
        private static final List m659getWhitelistedAppIds$lambda2(String str) {
            try {
                int i = lookAheadTest + 31;
                scheduleImpl = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(str, "");
                List<String> KClassImpl$Data$declaredNonStaticMembers$22 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(str);
                int i3 = lookAheadTest + 53;
                scheduleImpl = i3 % 128;
                if ((i3 % 2 == 0 ? '^' : '+') != '+') {
                    int i4 = 36 / 0;
                    return KClassImpl$Data$declaredNonStaticMembers$22;
                }
                return KClassImpl$Data$declaredNonStaticMembers$22;
            } catch (Exception e) {
                throw e;
            }
        }

        /* renamed from: getWhitelistedAppIds$lambda-0  reason: not valid java name */
        private static final ObservableSource m657getWhitelistedAppIds$lambda0(final BaseTrafficType baseTrafficType) {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            final boolean z = true;
            Object[] objArr = new Object[1];
            a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1223773481, (-51) - (ViewConfiguration.getTapTimeout() >> 16), (short) (TextUtils.indexOf("", "", 0) + 81), 1787681549 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (byte) ((-79) - TextUtils.getOffsetAfter("", 0)), objArr);
            final String intern = ((String) objArr[0]).intern();
            final Object obj = null;
            Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.danah5.httprequest.HttpRequestExtension$Companion$getWhitelistedAppIds$lambda-0$$inlined$getConfigOnceReady$default$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                    Intrinsics.checkNotNullParameter(observableEmitter, "");
                    BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                    ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                    String str = intern;
                    String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                    Object obj2 = obj;
                    final boolean z2 = z;
                    final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                    final String str2 = intern;
                    MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(str, BuiltInFictitiousFunctionClassFactory2, String.class, obj2, new ToggleCallback<T>() { // from class: id.dana.danah5.httprequest.HttpRequestExtension$Companion$getWhitelistedAppIds$lambda-0$$inlined$getConfigOnceReady$default$1.1
                        @Override // id.dana.lib.toggle.ToggleCallback
                        public final void onComplete(String treatment, T value) {
                            Unit unit;
                            Intrinsics.checkNotNullParameter(treatment, "");
                            if (value != null) {
                                boolean z3 = z2;
                                BaseTrafficType baseTrafficType3 = baseTrafficType2;
                                String str3 = str2;
                                ObservableEmitter observableEmitter2 = observableEmitter;
                                if (z3 && Intrinsics.areEqual(treatment, "control")) {
                                    baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Not Received", ConfigType.ASYNC);
                                    observableEmitter2.onError(new UnexpectedTreatment(str3));
                                } else {
                                    baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str3, "Received", ConfigType.ASYNC);
                                    observableEmitter2.onNext(value);
                                    observableEmitter2.onComplete();
                                }
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            if (unit == null) {
                                BaseTrafficType baseTrafficType4 = baseTrafficType2;
                                String str4 = str2;
                                ObservableEmitter observableEmitter3 = observableEmitter;
                                baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter3.onError(new SplitNull(str4));
                            }
                        }

                        @Override // id.dana.lib.toggle.ToggleCallback
                        public final void onError() {
                            baseTrafficType2.MyBillsEntityDataFactory("", str2, "Not Received", ConfigType.ASYNC);
                            observableEmitter.onError(new SplitException("Error when get toggle config"));
                        }
                    }, BaseTrafficType.this.getAuthRequestContext);
                }
            });
            Intrinsics.checkNotNullExpressionValue(create, "");
            Observable observable = create;
            int i = lookAheadTest + 19;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            return observable;
        }

        /* JADX WARN: Code restructure failed: missing block: B:63:0x0140, code lost:
        
            if (r3 != false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x0146, code lost:
        
            if (r3 != false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x0148, code lost:
        
            r8 = id.dana.danah5.httprequest.HttpRequestExtension.Companion.BuiltInFictitiousFunctionClassFactory;
            r0.getAuthRequestContext = r0.getAuthRequestContext - 1;
            r0.MyBillsEntityDataFactory = (char) (r0.PlaceComponentResult + (((byte) (((byte) (r8[r9] ^ 3097486228508854431L)) + r15)) ^ r17));
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x0161, code lost:
        
            r8 = id.dana.danah5.httprequest.HttpRequestExtension.Companion.KClassImpl$Data$declaredNonStaticMembers$2;
            r0.getAuthRequestContext = r0.getAuthRequestContext - 1;
            r0.MyBillsEntityDataFactory = (char) (r0.PlaceComponentResult + (((short) (((short) (r8[r9] ^ 3097486228508854431L)) + r15)) ^ r17));
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
            /*
                Method dump skipped, instructions count: 419
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.httprequest.HttpRequestExtension.Companion.a(int, int, short, int, byte, java.lang.Object[]):void");
        }
    }
}
