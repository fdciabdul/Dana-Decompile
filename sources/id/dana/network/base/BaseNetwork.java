package id.dana.network.base;

import android.content.Context;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.network.rpc.RpcConnector;
import id.dana.network.util.BaseNetworkUtils;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.holdlogin.v2.interceptor.HoldLoginV2Processing;
import id.dana.utils.retry.RetryHelper;
import id.dana.utils.rpc.quake.ReflectHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class BaseNetwork<T> {
    private final RpcConnector rpcConnector;
    protected final ThreadExecutor threadExecutor;

    /* loaded from: classes5.dex */
    public interface FacadeProcessor<F, S> {
        S processFacade(F f);
    }

    protected abstract Class<T> getFacadeClass();

    public abstract Context passContext();

    public BaseNetwork(RpcConnector rpcConnector, ThreadExecutor threadExecutor) {
        this.rpcConnector = rpcConnector;
        this.threadExecutor = threadExecutor;
    }

    public <S extends BaseRpcResult> Observable<S> wrapper(FacadeProcessor<T, S> facadeProcessor) {
        return wrapper(facadeProcessor, new ExceptionParser<>(), null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <S extends BaseRpcResult> Observable<S> wrapper(FacadeProcessor<T, S> facadeProcessor, Class<S> cls) {
        return wrapper(facadeProcessor, new ExceptionParser<>(), cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <S extends BaseRpcResult> Observable<S> wrapper(FacadeProcessor<T, S> facadeProcessor, ExceptionParser<S> exceptionParser) {
        return wrapper(facadeProcessor, exceptionParser, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <S extends BaseRpcResult> Observable<S> wrapper(FacadeProcessor<T, S> facadeProcessor, ExceptionParser<S> exceptionParser, Class<S> cls) {
        String PlaceComponentResult = ReflectHelper.PlaceComponentResult(getFacadeClass());
        exceptionParser.setContext(passContext());
        exceptionParser.setOperationType(PlaceComponentResult);
        return processRpc(PlaceComponentResult, facadeProcessor, exceptionParser, cls);
    }

    private <S extends BaseRpcResult> Observable<S> processRpc(final String str, final FacadeProcessor<T, S> facadeProcessor, Function<S, Observable<S>> function, final Class<S> cls) {
        return (Observable<S>) RetryHelper.KClassImpl$Data$declaredNonStaticMembers$2(str, new Function0() { // from class: id.dana.network.base.BaseNetwork$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseNetwork.this.m2750lambda$processRpc$0$iddananetworkbaseBaseNetwork(facadeProcessor);
            }
        }, new Function0() { // from class: id.dana.network.base.BaseNetwork$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Observable authRequestContext;
                authRequestContext = HoldLoginV2Processing.getAuthRequestContext(str);
                return authRequestContext;
            }
        }, new Function1() { // from class: id.dana.network.base.BaseNetwork$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNetwork.this.m2751lambda$processRpc$2$iddananetworkbaseBaseNetwork((Throwable) obj);
            }
        }, this.rpcConnector.getHoldLoginConfig().lookAheadTest, new Function4() { // from class: id.dana.network.base.BaseNetwork$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BaseNetwork.lambda$processRpc$3((String) obj, (String) obj2, (String) obj3, (Throwable) obj4);
            }
        }).subscribeOn(Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor)).onErrorResumeNext(new Function() { // from class: id.dana.network.base.BaseNetwork$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BaseNetwork.lambda$processRpc$4(cls, (Throwable) obj);
            }
        }).flatMap(function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$processRpc$0$id-dana-network-base-BaseNetwork  reason: not valid java name */
    public /* synthetic */ BaseRpcResult m2750lambda$processRpc$0$iddananetworkbaseBaseNetwork(FacadeProcessor facadeProcessor) {
        return (BaseRpcResult) facadeProcessor.processFacade(getCastedFacade());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$processRpc$2$id-dana-network-base-BaseNetwork  reason: not valid java name */
    public /* synthetic */ Boolean m2751lambda$processRpc$2$iddananetworkbaseBaseNetwork(Throwable th) {
        return Boolean.valueOf(this.rpcConnector.isHoldLoginV2Enable() && (th instanceof RpcException) && ((RpcException) th).getCode() == 2000 && this.rpcConnector.hasSession());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$processRpc$3(String str, String str2, String str3, Throwable th) {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter(str, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(str);
        Intrinsics.checkNotNullParameter(str2, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(str2);
        Intrinsics.checkNotNullParameter(str3, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(str3);
        Intrinsics.checkNotNullParameter(th, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(th);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$processRpc$4(Class cls, Throwable th) throws Exception {
        try {
            return Observable.just(BaseNetworkUtils.onDeserializeFailure(cls, th));
        } catch (Throwable th2) {
            return Observable.error(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <S extends BaseRpcResult> S wrapperMainThread(FacadeProcessor<T, S> facadeProcessor) {
        return facadeProcessor.processFacade(getCastedFacade());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T getCastedFacade() {
        return (T) this.rpcConnector.getFacade(getFacadeClass());
    }
}
