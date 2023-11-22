package id.dana.data.holdlogin.v2.interceptor;

import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import com.google.gson.Gson;
import id.dana.data.holdlogin.v2.ConstantsKt;
import id.dana.data.holdlogin.v2.engine.HoldLoginV2Engine;
import id.dana.data.holdlogin.v2.entity.HoldLoginResult;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Processing;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Starting;
import id.dana.utils.rpc.response.BaseNetworkRpcResponse;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Response;

@Singleton
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020$\u0012\u0006\u0010\u0004\u001a\u00020(\u0012\u0006\u0010\u0006\u001a\u000202\u0012\u0006\u00108\u001a\u00020.¢\u0006\u0004\b9\u0010:J1\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\n2\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00142\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110\u0015H\u0000¢\u0006\u0004\b\u0007\u0010\u0017J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000b\u0010\u0018J\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0004\b\u000b\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u0007\u0010\u001cJ\u0019\u0010\u000f\u001a\u00020\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0004\b\u000f\u0010\u001dJ\u0019\u0010\u0012\u001a\u00020\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0004\b\u0012\u0010\u001fJ\u0013\u0010\u0012\u001a\u00020\u001b*\u00020 H\u0002¢\u0006\u0004\b\u0012\u0010!R\u0014\u0010\u000f\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0014\u0010\u0012\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010%R\u0011\u0010\u0007\u001a\u00020&X\u0000¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0014\u0010\u000b\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00103R\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020605X\u0080\u0002¢\u0006\u0006\n\u0004\b-\u00107"}, d2 = {"Lid/dana/data/holdlogin/v2/interceptor/HoldLoginV2InterceptorImpl;", "Lid/dana/utils/holdlogin/v2/interceptor/HoldLoginV2Interceptor;", "", "p0", "p1", "Lkotlin/Function0;", "p2", "PlaceComponentResult", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lokhttp3/Request;", "Lokhttp3/Response;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lokhttp3/Request;Lokhttp3/Response;Lkotlin/jvm/functions/Function0;)Lokhttp3/Response;", "Lcom/alipay/imobile/network/quake/Request;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "getAuthRequestContext", "(Lcom/alipay/imobile/network/quake/Request;Lcom/alipay/imobile/network/quake/NetworkResponse;)Lcom/alipay/imobile/network/quake/NetworkResponse;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Object;)V", "", "Lkotlin/Function1;", "Lid/dana/data/holdlogin/v2/entity/HoldLoginResult;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Lcom/alipay/imobile/network/quake/Request;)Ljava/lang/String;", "(Ljava/lang/String;)Ljava/lang/String;", "", "", "(I)Z", "(Ljava/lang/String;)Z", "Lid/dana/utils/rpc/response/BaseNetworkRpcResponse;", "(Lid/dana/utils/rpc/response/BaseNetworkRpcResponse;)Z", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;)Z", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/google/gson/Gson;", "Lcom/google/gson/Gson;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lid/dana/data/holdlogin/v2/engine/HoldLoginV2Engine;", "Lid/dana/data/holdlogin/v2/engine/HoldLoginV2Engine;", "Ljava/util/concurrent/locks/ReentrantLock;", "moveToNextValue", "Ljava/util/concurrent/locks/ReentrantLock;", "MyBillsEntityDataFactory", "Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor;", "scheduleImpl", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/utils/concurrent/ThreadExecutor;", "getErrorConfigVersion", "", "Ljava/net/URI;", "[Ljava/net/URI;", "p3", "<init>", "(Lcom/google/gson/Gson;Lid/dana/data/holdlogin/v2/engine/HoldLoginV2Engine;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/holdlogin/v2/interceptor/SetCookieInterceptor;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HoldLoginV2InterceptorImpl implements HoldLoginV2Interceptor {
    private final Gson BuiltInFictitiousFunctionClassFactory;
    private final HoldLoginV2Engine KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public URI[] moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final SetCookieInterceptor scheduleImpl;
    public final AtomicBoolean PlaceComponentResult;
    private final CompositeDisposable getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ReentrantLock MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ThreadExecutor getErrorConfigVersion;

    private static boolean PlaceComponentResult(int p0) {
        return p0 == 401;
    }

    @Inject
    public HoldLoginV2InterceptorImpl(Gson gson, HoldLoginV2Engine holdLoginV2Engine, ThreadExecutor threadExecutor, SetCookieInterceptor setCookieInterceptor) {
        Intrinsics.checkNotNullParameter(gson, "");
        Intrinsics.checkNotNullParameter(holdLoginV2Engine, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(setCookieInterceptor, "");
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV2Engine;
        this.getErrorConfigVersion = threadExecutor;
        this.scheduleImpl = setCookieInterceptor;
        this.getAuthRequestContext = new CompositeDisposable();
        this.PlaceComponentResult = new AtomicBoolean(false);
        this.MyBillsEntityDataFactory = new ReentrantLock();
        HoldLoginV2Starting.getAuthRequestContext().subscribeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion)).observeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion)).subscribe(new Consumer() { // from class: id.dana.data.holdlogin.v2.interceptor.HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HoldLoginV2InterceptorImpl.PlaceComponentResult(HoldLoginV2InterceptorImpl.this, (String) obj);
            }
        }, new Consumer() { // from class: id.dana.data.holdlogin.v2.interceptor.HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("HOLD_LOGIN_V2", r1.getMessage(), (Throwable) obj);
            }
        });
        this.moveToNextValue = new URI[]{new URI("https://m.dana.id"), new URI("https://m.dana.id"), new URI("https://mgs-gw.m.dana.id/mgw.htm")};
    }

    @Override // id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor
    public final void BuiltInFictitiousFunctionClassFactory(Object p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) p0;
        } else if (!(p0 instanceof Request)) {
            if (p0 instanceof okhttp3.Request) {
                okhttp3.Request request = (okhttp3.Request) p0;
            }
        } else {
            Request request2 = (Request) p0;
            String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(request2);
            List<String> MyBillsEntityDataFactory = ConstantsKt.MyBillsEntityDataFactory();
            boolean z = false;
            if (!(MyBillsEntityDataFactory instanceof Collection) || !MyBillsEntityDataFactory.isEmpty()) {
                Iterator<T> it = MyBillsEntityDataFactory.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (Intrinsics.areEqual((String) it.next(), KClassImpl$Data$declaredNonStaticMembers$2)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                request2.addExternalInfo(MapsKt.mapOf(TuplesKt.to("Hold-Login-Version", "2")));
            }
        }
    }

    @Override // id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Interceptor
    public final Object PlaceComponentResult(Object p0, Object p1, Function0<? extends Object> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if ((p0 instanceof HttpRequest) && (p1 instanceof HttpResponse)) {
            HttpRequest httpRequest = (HttpRequest) p0;
            HttpResponse httpResponse = (HttpResponse) p1;
            String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(httpRequest.getUrl());
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                KClassImpl$Data$declaredNonStaticMembers$2 = "";
            }
            if (getAuthRequestContext(httpRequest.getUrl()) && PlaceComponentResult(httpResponse.getStatusCode())) {
                SetCookieInterceptor.getAuthRequestContext(this.scheduleImpl);
                Object r_ = Single.MyBillsEntityDataFactory((SingleOnSubscribe) new HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda0(this, KClassImpl$Data$declaredNonStaticMembers$2, p2, httpResponse)).r_();
                Intrinsics.checkNotNullExpressionValue(r_, "");
                return (HttpResponse) r_;
            }
            return httpResponse;
        } else if ((p0 instanceof Request) && (p1 instanceof NetworkResponse)) {
            return getAuthRequestContext((Request) p0, (NetworkResponse) p1);
        } else {
            if ((p0 instanceof okhttp3.Request) && (p1 instanceof Response)) {
                return KClassImpl$Data$declaredNonStaticMembers$2((okhttp3.Request) p0, (Response) p1, p2);
            }
            return null;
        }
    }

    private final Response KClassImpl$Data$declaredNonStaticMembers$2(okhttp3.Request p0, Response p1, Function0<? extends Object> p2) {
        Object m3179constructorimpl;
        String obj = p0.url().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(obj);
        try {
            try {
                Result.Companion companion = Result.INSTANCE;
                HoldLoginV2InterceptorImpl holdLoginV2InterceptorImpl = this;
                m3179constructorimpl = Result.m3179constructorimpl((BaseNetworkRpcResponse) this.BuiltInFictitiousFunctionClassFactory.fromJson(p1.peekBody(2048L).string(), BaseNetworkRpcResponse.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
            if (getAuthRequestContext(obj)) {
                if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                    m3179constructorimpl = null;
                }
                if (BuiltInFictitiousFunctionClassFactory((BaseNetworkRpcResponse) m3179constructorimpl) || PlaceComponentResult(p1.code())) {
                    SetCookieInterceptor.getAuthRequestContext(this.scheduleImpl);
                    if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                        KClassImpl$Data$declaredNonStaticMembers$2 = "";
                    }
                    Object r_ = Single.MyBillsEntityDataFactory((SingleOnSubscribe) new HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda0(this, KClassImpl$Data$declaredNonStaticMembers$2, p2, p1)).r_();
                    Intrinsics.checkNotNullExpressionValue(r_, "");
                    return (Response) r_;
                }
                return p1;
            }
            return p1;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("afterReceiveResponseOkhttp3. Failed to ");
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory("HOLD_LOGIN_V2", sb.toString(), e);
            return p1;
        }
    }

    private final NetworkResponse getAuthRequestContext(Request p0, NetworkResponse p1) {
        String str = "";
        try {
            byte[] bArr = p1.data;
            Intrinsics.checkNotNullExpressionValue(bArr, "");
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(charset, "");
            BaseNetworkRpcResponse baseNetworkRpcResponse = (BaseNetworkRpcResponse) this.BuiltInFictitiousFunctionClassFactory.fromJson(new String(bArr, charset), BaseNetworkRpcResponse.class);
            String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                str = KClassImpl$Data$declaredNonStaticMembers$2;
            }
            boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(baseNetworkRpcResponse);
            boolean z = true;
            if (getAuthRequestContext(p0.getUrl()) && BuiltInFictitiousFunctionClassFactory(baseNetworkRpcResponse)) {
                SetCookieInterceptor.getAuthRequestContext(this.scheduleImpl);
                PlaceComponentResult(str, HoldLoginV2InterceptorImpl$doHoldLogin$1.INSTANCE);
            }
            List<String> MyBillsEntityDataFactory = ConstantsKt.MyBillsEntityDataFactory();
            if (!(MyBillsEntityDataFactory instanceof Collection) || !MyBillsEntityDataFactory.isEmpty()) {
                Iterator<T> it = MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual((String) it.next(), str)) {
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                this.scheduleImpl.MyBillsEntityDataFactory(p1.extData.get("Set-Cookie"));
            }
            if ((z && !this.PlaceComponentResult.get()) || (BuiltInFictitiousFunctionClassFactory && !this.PlaceComponentResult.get())) {
                this.getAuthRequestContext.MyBillsEntityDataFactory();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("afterReceiveResponseRpc, Failed to ");
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory("HOLD_LOGIN_V2", sb.toString(), e);
        }
        return p1;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(BaseNetworkRpcResponse p0) {
        Integer num;
        return (p0 == null || p0.PlaceComponentResult() || (num = p0.KClassImpl$Data$declaredNonStaticMembers$2) == null || num.intValue() != 2000) ? false : true;
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        try {
            return new URI(p0).getPath();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getOperationType, Failed to ");
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory("HOLD_LOGIN_V2", sb.toString(), e);
            return null;
        }
    }

    private boolean getAuthRequestContext(String p0) {
        try {
            for (URI uri : this.moveToNextValue) {
                String host = uri.getHost();
                Intrinsics.checkNotNullExpressionValue(host, "");
                String lowerCase = host.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                String host2 = new URI(p0).getHost();
                Intrinsics.checkNotNullExpressionValue(host2, "");
                String lowerCase2 = host2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("isIncludeWhitelist, Failed to ");
            sb.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory("HOLD_LOGIN_V2", sb.toString(), e);
            return false;
        }
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(Request p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String obj = p0.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) obj, new String[]{"#"}, false, 0, 6, (Object) null), 1);
    }

    private void PlaceComponentResult(String p0, final Function1<? super HoldLoginResult, Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult.set(true);
        HoldLoginV2Processing.BuiltInFictitiousFunctionClassFactory(true);
        this.MyBillsEntityDataFactory.lock();
        Disposable subscribe = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(p0).subscribeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion)).subscribe(new Consumer() { // from class: id.dana.data.holdlogin.v2.interceptor.HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HoldLoginV2InterceptorImpl.getAuthRequestContext(HoldLoginV2InterceptorImpl.this, p1, (HoldLoginResult) obj);
            }
        }, new Consumer() { // from class: id.dana.data.holdlogin.v2.interceptor.HoldLoginV2InterceptorImpl$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HoldLoginV2InterceptorImpl.PlaceComponentResult(HoldLoginV2InterceptorImpl.this, p1, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        BuiltInFictitiousFunctionClassFactory(subscribe);
        this.MyBillsEntityDataFactory.unlock();
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(Disposable disposable) {
        return this.getAuthRequestContext.getAuthRequestContext(disposable);
    }

    public static /* synthetic */ void PlaceComponentResult(HoldLoginV2InterceptorImpl holdLoginV2InterceptorImpl, String str) {
        Intrinsics.checkNotNullParameter(holdLoginV2InterceptorImpl, "");
        SetCookieInterceptor.getAuthRequestContext(holdLoginV2InterceptorImpl.scheduleImpl);
        Intrinsics.checkNotNullExpressionValue(str, "");
        holdLoginV2InterceptorImpl.PlaceComponentResult(str, HoldLoginV2InterceptorImpl$doHoldLogin$1.INSTANCE);
    }

    public static /* synthetic */ void getAuthRequestContext(HoldLoginV2InterceptorImpl holdLoginV2InterceptorImpl, Function1 function1, HoldLoginResult holdLoginResult) {
        Intrinsics.checkNotNullParameter(holdLoginV2InterceptorImpl, "");
        Intrinsics.checkNotNullParameter(function1, "");
        holdLoginV2InterceptorImpl.PlaceComponentResult.set(false);
        if (holdLoginResult instanceof HoldLoginResult.Success) {
            HoldLoginV2Processing.BuiltInFictitiousFunctionClassFactory(false);
        } else if (holdLoginResult instanceof HoldLoginResult.Error) {
            HoldLoginV2Processing.BuiltInFictitiousFunctionClassFactory(((HoldLoginResult.Error) holdLoginResult).MyBillsEntityDataFactory);
        }
        Intrinsics.checkNotNullExpressionValue(holdLoginResult, "");
        function1.invoke(holdLoginResult);
    }

    public static /* synthetic */ void PlaceComponentResult(HoldLoginV2InterceptorImpl holdLoginV2InterceptorImpl, Function1 function1, Throwable th) {
        Intrinsics.checkNotNullParameter(holdLoginV2InterceptorImpl, "");
        Intrinsics.checkNotNullParameter(function1, "");
        holdLoginV2InterceptorImpl.PlaceComponentResult.set(false);
        Intrinsics.checkNotNullExpressionValue(th, "");
        HoldLoginV2Processing.BuiltInFictitiousFunctionClassFactory(th);
        function1.invoke(new HoldLoginResult.Error(th));
    }

    public static /* synthetic */ void getAuthRequestContext(HoldLoginV2InterceptorImpl holdLoginV2InterceptorImpl, String str, final Function0 function0, final Object obj, final SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(holdLoginV2InterceptorImpl, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(obj, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        holdLoginV2InterceptorImpl.PlaceComponentResult(str, new Function1<HoldLoginResult, Unit>() { // from class: id.dana.data.holdlogin.v2.interceptor.HoldLoginV2InterceptorImpl$doHoldLoginAndRetry$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(HoldLoginResult holdLoginResult) {
                invoke2(holdLoginResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HoldLoginResult holdLoginResult) {
                Intrinsics.checkNotNullParameter(holdLoginResult, "");
                if (holdLoginResult instanceof HoldLoginResult.Success) {
                    Object invoke = function0.invoke();
                    if (invoke == null) {
                        invoke = null;
                    }
                    SingleEmitter<T> singleEmitter2 = singleEmitter;
                    if (invoke == null) {
                        invoke = obj;
                    }
                    singleEmitter2.onSuccess(invoke);
                    return;
                }
                singleEmitter.onSuccess(obj);
            }
        });
    }
}
