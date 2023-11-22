package id.dana.data.holdlogin.v2.entity.source;

import android.content.Context;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.holdlogin.HoldLoginFailTrackerModel;
import id.dana.data.holdlogin.HoldLoginSuccessTrackerModel;
import id.dana.data.holdlogin.v2.ConstantsKt;
import id.dana.data.holdlogin.v2.entity.HoldLoginEntityData;
import id.dana.data.holdlogin.v2.entity.source.SharedHoldLoginNetwork;
import id.dana.data.holdlogin.v2.exception.HoldLoginExceptionParserSingle;
import id.dana.data.holdlogin.v2.exception.HoldLoginTimeoutException;
import id.dana.data.login.source.network.HoldLoginException;
import id.dana.data.login.source.network.LoginRpcFacade;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.data.login.source.network.model.LoginType;
import id.dana.data.login.source.network.request.LoginRpcRequest;
import id.dana.network.base.DeserializeExceptionParser;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.util.BaseNetworkUtils;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import id.dana.utils.extension.StringExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Processing;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import j$.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Singleton
@Metadata(bv = {}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u001e\u0012\u0006\u0010\t\u001a\u00020!\u0012\u0006\u00103\u001a\u00020#¢\u0006\u0004\b4\u00105J;\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00102\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0013J\u0014\u0010\u0015\u001a\u00020\u0012*\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0018J-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0018J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001cR\u0014\u0010\u000b\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\u000f\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010+R\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010\u001f\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u00102"}, d2 = {"Lid/dana/data/holdlogin/v2/entity/source/OldHoldLoginEntityNetwork;", "Lid/dana/data/holdlogin/v2/entity/HoldLoginEntityData;", "Lid/dana/data/holdlogin/v2/entity/source/SharedHoldLoginNetwork;", "", "p0", "p1", "p2", "Lkotlin/Function0;", "Lid/dana/network/response/login/LoginRpcResult;", "p3", "Lio/reactivex/Single;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Lio/reactivex/Single;", "", "()V", "BuiltInFictitiousFunctionClassFactory", "", "", "", "(Ljava/lang/Throwable;Ljava/util/List;)Z", "Lio/reactivex/disposables/Disposable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lio/reactivex/disposables/Disposable;)Z", "Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "MyBillsEntityDataFactory", "Lid/dana/utils/concurrent/ThreadExecutor;", "lookAheadTest", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/holdlogin/v2/entity/source/ImplSharedHoldLoginNetwork;", "Lid/dana/data/holdlogin/v2/entity/source/ImplSharedHoldLoginNetwork;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "scheduleImpl", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "PlaceComponentResult", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/Object;", "moveToNextValue", "Lid/dana/network/response/login/LoginRpcResult;", "Ljava/lang/Throwable;", "Lj$/util/Optional;", "", "getErrorConfigVersion", "Lj$/util/Optional;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "p4", "<init>", "(Landroid/content/Context;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/holdlogin/v2/entity/source/ImplSharedHoldLoginNetwork;Lid/dana/utils/holdlogin/v2/HoldLoginConfig;)V"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class OldHoldLoginEntityNetwork implements HoldLoginEntityData, SharedHoldLoginNetwork {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Throwable NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ApSecurityFacade MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final ImplSharedHoldLoginNetwork BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Object moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private LoginRpcResult scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private Optional<Long> getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final ThreadExecutor getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final AtomicInteger lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final HoldLoginConfig PlaceComponentResult;

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "");
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(disposable);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Throwable p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return ImplSharedHoldLoginNetwork.getAuthRequestContext(p0, p1);
    }

    @Inject
    public OldHoldLoginEntityNetwork(Context context, ApSecurityFacade apSecurityFacade, ThreadExecutor threadExecutor, ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork, HoldLoginConfig holdLoginConfig) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(implSharedHoldLoginNetwork, "");
        Intrinsics.checkNotNullParameter(holdLoginConfig, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = apSecurityFacade;
        this.getAuthRequestContext = threadExecutor;
        this.BuiltInFictitiousFunctionClassFactory = implSharedHoldLoginNetwork;
        this.PlaceComponentResult = holdLoginConfig;
        this.moveToNextValue = new Object();
        Optional<Long> MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        this.getErrorConfigVersion = MyBillsEntityDataFactory;
        this.lookAheadTest = new AtomicInteger(0);
    }

    @Override // id.dana.data.holdlogin.v2.entity.HoldLoginEntityData
    public final Observable<LoginRpcResult> getAuthRequestContext(final String p0, final String p1, String p2) {
        Observable<LoginRpcResult> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Single<LoginRpcResult> authRequestContext = getAuthRequestContext(p0, "alipayplus.mobilewallet.user.login", p2, new Function0<LoginRpcResult>() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$holdLogin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoginRpcResult invoke() {
                ApSecurityFacade apSecurityFacade;
                Context context;
                ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = OldHoldLoginEntityNetwork.this.BuiltInFictitiousFunctionClassFactory;
                Object interfaceProxy = RPCProxyHost.getInterfaceProxy(LoginRpcFacade.class);
                Intrinsics.checkNotNullExpressionValue(interfaceProxy, "");
                LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
                String str = p1;
                OldHoldLoginEntityNetwork oldHoldLoginEntityNetwork = OldHoldLoginEntityNetwork.this;
                String str2 = p0;
                loginRpcRequest.credentials = str;
                apSecurityFacade = oldHoldLoginEntityNetwork.MyBillsEntityDataFactory;
                context = oldHoldLoginEntityNetwork.KClassImpl$Data$declaredNonStaticMembers$2;
                loginRpcRequest.envInfo = BaseNetworkUtils.generateMobileEnvInfo(apSecurityFacade, context);
                loginRpcRequest.loginId = str2;
                loginRpcRequest.loginIdType = LoginIdType.MOBILE_NO;
                loginRpcRequest.loginType = LoginType.HOLD_LOGIN;
                return ((LoginRpcFacade) interfaceProxy).login(loginRpcRequest);
            }
        });
        if (authRequestContext instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) authRequestContext).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(authRequestContext));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.data.holdlogin.v2.entity.HoldLoginEntityData
    public final Observable<LoginRpcResult> BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, String p2) {
        Observable<LoginRpcResult> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Single<LoginRpcResult> authRequestContext = getAuthRequestContext(p0, "id.dana.userprod.user.hold.login", p2, new Function0<LoginRpcResult>() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$holdLoginNewAPI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoginRpcResult invoke() {
                ApSecurityFacade apSecurityFacade;
                Context context;
                ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = OldHoldLoginEntityNetwork.this.BuiltInFictitiousFunctionClassFactory;
                Object interfaceProxy = RPCProxyHost.getInterfaceProxy(LoginRpcFacade.class);
                Intrinsics.checkNotNullExpressionValue(interfaceProxy, "");
                LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
                String str = p1;
                String str2 = p0;
                OldHoldLoginEntityNetwork oldHoldLoginEntityNetwork = OldHoldLoginEntityNetwork.this;
                loginRpcRequest.credentials = str;
                loginRpcRequest.loginId = str2;
                loginRpcRequest.loginIdType = "ROLE";
                apSecurityFacade = oldHoldLoginEntityNetwork.MyBillsEntityDataFactory;
                context = oldHoldLoginEntityNetwork.KClassImpl$Data$declaredNonStaticMembers$2;
                loginRpcRequest.envInfo = BaseNetworkUtils.generateMobileEnvInfo(apSecurityFacade, context);
                return ((LoginRpcFacade) interfaceProxy).holdLogin(loginRpcRequest);
            }
        });
        if (authRequestContext instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) authRequestContext).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(authRequestContext));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    private final Single<LoginRpcResult> getAuthRequestContext(final String p0, final String p1, final String p2, final Function0<LoginRpcResult> p3) {
        HoldLoginTimeoutException holdLoginTimeoutException;
        Single<LoginRpcResult> authRequestContext;
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (this) {
            if (this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2()) {
                Object obj = this.getErrorConfigVersion.PlaceComponentResult;
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    if (((Number) obj).longValue() < System.currentTimeMillis()) {
                        BuiltInFictitiousFunctionClassFactory();
                    }
                } else {
                    throw new NoSuchElementException("No value present");
                }
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            final long currentTimeMillis = System.currentTimeMillis();
            final FeatureHoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$22 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            this.lookAheadTest.incrementAndGet();
            Long l = KClassImpl$Data$declaredNonStaticMembers$22.lookAheadTest;
            final List<String> BuiltInFictitiousFunctionClassFactory = CookieUtil.BuiltInFictitiousFunctionClassFactory("https://mgs-gw.m.dana.id/mgw.htm", "ALIPAYJSESSIONID");
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 instanceof HoldLoginException) {
                getAuthRequestContext();
                Single<LoginRpcResult> authRequestContext2 = Single.getAuthRequestContext(new Throwable(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
                Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
                return authRequestContext2;
            }
            if (this.scheduleImpl == null) {
                HoldLoginExceptionParserSingle holdLoginExceptionParserSingle = new HoldLoginExceptionParserSingle(KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult.getAuthRequestContext);
                holdLoginExceptionParserSingle.setContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
                holdLoginExceptionParserSingle.setOperationType(p1);
                Single PlaceComponentResult = Single.PlaceComponentResult(new Callable() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return OldHoldLoginEntityNetwork.getAuthRequestContext(Function0.this);
                    }
                });
                Scheduler BuiltInFictitiousFunctionClassFactory2 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
                ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, "scheduler is null");
                Single BuiltInFictitiousFunctionClassFactory3 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(PlaceComponentResult, BuiltInFictitiousFunctionClassFactory2));
                Scheduler BuiltInFictitiousFunctionClassFactory4 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
                ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory4, "scheduler is null");
                Single BuiltInFictitiousFunctionClassFactory5 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4));
                Function function = new Function() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj2) {
                        return OldHoldLoginEntityNetwork.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj2);
                    }
                };
                ObjectHelper.PlaceComponentResult(function, "resumeFunctionInCaseOfError is null");
                Single BuiltInFictitiousFunctionClassFactory6 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleResumeNext(BuiltInFictitiousFunctionClassFactory5, function));
                HoldLoginExceptionParserSingle holdLoginExceptionParserSingle2 = holdLoginExceptionParserSingle;
                ObjectHelper.PlaceComponentResult(holdLoginExceptionParserSingle2, "mapper is null");
                Single BuiltInFictitiousFunctionClassFactory7 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleFlatMap(BuiltInFictitiousFunctionClassFactory6, holdLoginExceptionParserSingle2));
                long j = KClassImpl$Data$declaredNonStaticMembers$22.moveToNextValue;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
                ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
                ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
                Single BuiltInFictitiousFunctionClassFactory8 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(BuiltInFictitiousFunctionClassFactory7, j, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory8, "");
                Disposable MyBillsEntityDataFactory = RxExtensionKt.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory8, new Function1<Throwable, Boolean>() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$executeV1$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        return Boolean.valueOf(OldHoldLoginEntityNetwork.this.BuiltInFictitiousFunctionClassFactory(th, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult.MyBillsEntityDataFactory));
                    }
                }, new Function1<Integer, Unit>() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$executeV1$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i) {
                        Ref.IntRef.this.element = i;
                    }
                }, KClassImpl$Data$declaredNonStaticMembers$22.scheduleImpl, KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$$ExternalSyntheticLambda2
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        OldHoldLoginEntityNetwork.getAuthRequestContext(OldHoldLoginEntityNetwork.this, p0, p1, p2, BuiltInFictitiousFunctionClassFactory, intRef, currentTimeMillis, (LoginRpcResult) obj2);
                    }
                }, new Consumer() { // from class: id.dana.data.holdlogin.v2.entity.source.OldHoldLoginEntityNetwork$$ExternalSyntheticLambda3
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj2) {
                        OldHoldLoginEntityNetwork.MyBillsEntityDataFactory(OldHoldLoginEntityNetwork.this, p0, p1, p2, intRef, currentTimeMillis, (Throwable) obj2);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                try {
                    synchronized (this.moveToNextValue) {
                        if (l != null) {
                            if (l.longValue() >= ConstantsKt.BuiltInFictitiousFunctionClassFactory()) {
                                this.moveToNextValue.wait(l.longValue());
                                Unit unit = Unit.INSTANCE;
                            }
                        }
                        this.moveToNextValue.wait(ConstantsKt.BuiltInFictitiousFunctionClassFactory());
                        Unit unit2 = Unit.INSTANCE;
                    }
                } catch (InterruptedException e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("HOLD_LOGIN_V2", e.toString());
                }
            }
            LoginRpcResult loginRpcResult = this.scheduleImpl;
            getAuthRequestContext();
            if (loginRpcResult != null) {
                authRequestContext = Single.MyBillsEntityDataFactory(loginRpcResult);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            } else {
                if (l != null && l.longValue() >= ConstantsKt.BuiltInFictitiousFunctionClassFactory()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Hold login timeout, more than ");
                    sb.append(l);
                    sb.append(" ms");
                    holdLoginTimeoutException = new HoldLoginTimeoutException(sb.toString());
                } else {
                    ?? r2 = 0;
                    holdLoginTimeoutException = new HoldLoginTimeoutException(r2, 1, r2);
                }
                HoldLoginTimeoutException holdLoginTimeoutException2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (holdLoginTimeoutException2 == null) {
                    holdLoginTimeoutException2 = holdLoginTimeoutException;
                }
                authRequestContext = Single.getAuthRequestContext(holdLoginTimeoutException2);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            }
            return authRequestContext;
        }
    }

    @Override // id.dana.data.holdlogin.v2.entity.HoldLoginEntityData
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.MyBillsEntityDataFactory();
    }

    private final void getAuthRequestContext() {
        if (this.lookAheadTest.decrementAndGet() > 0 || !this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        Object obj = this.getErrorConfigVersion.PlaceComponentResult;
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "");
            if (((Number) obj).longValue() < System.currentTimeMillis()) {
                BuiltInFictitiousFunctionClassFactory();
                return;
            }
            return;
        }
        throw new NoSuchElementException("No value present");
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        this.scheduleImpl = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        Optional<Long> MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        this.getErrorConfigVersion = MyBillsEntityDataFactory;
        this.lookAheadTest.set(0);
    }

    public static /* synthetic */ SingleSource KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new DeserializeExceptionParser(LoginRpcResult.class).apply(th);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(OldHoldLoginEntityNetwork oldHoldLoginEntityNetwork, String str, String str2, String str3, Ref.IntRef intRef, long j, Throwable th) {
        long currentTimeMillis;
        Intrinsics.checkNotNullParameter(oldHoldLoginEntityNetwork, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(intRef, "");
        if (!(th instanceof HoldLoginException)) {
            currentTimeMillis = System.currentTimeMillis();
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = oldHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory;
            currentTimeMillis = currentTimeMillis2 + SharedHoldLoginNetwork.CC.MyBillsEntityDataFactory();
        }
        Optional<Long> MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory(Long.valueOf(currentTimeMillis));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        oldHoldLoginEntityNetwork.getErrorConfigVersion = MyBillsEntityDataFactory;
        oldHoldLoginEntityNetwork.scheduleImpl = null;
        oldHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0 = th;
        Intrinsics.checkNotNullExpressionValue(th, "");
        HoldLoginV2Processing.BuiltInFictitiousFunctionClassFactory(th);
        int i = intRef.element;
        long currentTimeMillis3 = System.currentTimeMillis();
        HoldLoginFailTrackerModel holdLoginFailTrackerModel = new HoldLoginFailTrackerModel(str, TrackerDataKey.LoginType.HOLD_LOGIN, str2, str3, th, i, currentTimeMillis3 - j, true, oldHoldLoginEntityNetwork.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getKClassImpl$Data$declaredNonStaticMembers$2());
        Intrinsics.checkNotNullParameter(holdLoginFailTrackerModel, "");
        oldHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(holdLoginFailTrackerModel);
        synchronized (oldHoldLoginEntityNetwork.moveToNextValue) {
            oldHoldLoginEntityNetwork.moveToNextValue.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(OldHoldLoginEntityNetwork oldHoldLoginEntityNetwork, String str, String str2, String str3, List list, Ref.IntRef intRef, long j, LoginRpcResult loginRpcResult) {
        Intrinsics.checkNotNullParameter(oldHoldLoginEntityNetwork, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(intRef, "");
        String str4 = loginRpcResult.sessionId;
        if (str4 == null) {
            str4 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        ImplSharedHoldLoginNetwork implSharedHoldLoginNetwork = oldHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory;
        Optional<Long> MyBillsEntityDataFactory = Optional.MyBillsEntityDataFactory(Long.valueOf(currentTimeMillis + SharedHoldLoginNetwork.CC.MyBillsEntityDataFactory()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        oldHoldLoginEntityNetwork.getErrorConfigVersion = MyBillsEntityDataFactory;
        oldHoldLoginEntityNetwork.scheduleImpl = loginRpcResult;
        oldHoldLoginEntityNetwork.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        HoldLoginV2Processing.BuiltInFictitiousFunctionClassFactory(false);
        Intrinsics.checkNotNullExpressionValue(list, "");
        int i = intRef.element;
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.take(StringExtKt.PlaceComponentResult((String) it.next()), 20));
        }
        ArrayList arrayList2 = arrayList;
        String take = StringsKt.take(StringExtKt.PlaceComponentResult(str4), 20);
        List<String> BuiltInFictitiousFunctionClassFactory = CookieUtil.BuiltInFictitiousFunctionClassFactory("https://mgs-gw.m.dana.id/mgw.htm", "ALIPAYJSESSIONID");
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        List<String> list3 = BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (String str5 : list3) {
            Intrinsics.checkNotNullExpressionValue(str5, "");
            arrayList3.add(StringsKt.take(StringExtKt.PlaceComponentResult(str5), 20));
        }
        HoldLoginSuccessTrackerModel holdLoginSuccessTrackerModel = new HoldLoginSuccessTrackerModel(str, TrackerDataKey.LoginType.HOLD_LOGIN, 2, true, str2, str3, i, System.currentTimeMillis() - j, arrayList2, take, arrayList3, true, oldHoldLoginEntityNetwork.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getKClassImpl$Data$declaredNonStaticMembers$2());
        Intrinsics.checkNotNullParameter(holdLoginSuccessTrackerModel, "");
        oldHoldLoginEntityNetwork.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(holdLoginSuccessTrackerModel);
        synchronized (oldHoldLoginEntityNetwork.moveToNextValue) {
            oldHoldLoginEntityNetwork.moveToNextValue.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ LoginRpcResult getAuthRequestContext(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return (LoginRpcResult) function0.invoke();
    }
}
