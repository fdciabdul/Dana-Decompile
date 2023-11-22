package id.dana.data.carrieridentification.source.network;

import android.content.Context;
import id.dana.data.carrieridentification.model.VerifySecurityProductRequest;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.carrieridentification.source.CarrierIdentificationEntityData;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.login.source.network.result.RetryConfig;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.response.login.VerifyOtpResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.tracker.spm.SpmTagConstant;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B7\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u001e\u0012\u0006\u0010\t\u001a\u00020\u001f\u0012\u0006\u0010\n\u001a\u00020 \u0012\u0006\u0010\u000b\u001a\u00020!\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006JY\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u0006\u0010\b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0012\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u001d"}, d2 = {"Lid/dana/data/carrieridentification/source/network/NetworkCarrierIdentificationEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/carrieridentification/source/network/CarrierIdentificationFacade;", "Lid/dana/data/carrieridentification/source/CarrierIdentificationEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "p1", "p2", "p3", "p4", "p5", "", "p6", "Lio/reactivex/Observable;", "Lid/dana/network/response/login/VerifyOtpResult;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;Ljava/lang/String;)Lio/reactivex/Observable;", "Ldagger/Lazy;", "Lid/dana/data/storage/GeneralPreferencesDataFactory;", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/data/login/source/network/result/RetryConfig;", "Lkotlin/Lazy;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkCarrierIdentificationEntityData extends SecureBaseNetwork<CarrierIdentificationFacade> implements CarrierIdentificationEntityData {
    private final Lazy PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final dagger.Lazy<GeneralPreferencesDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<CarrierIdentificationFacade> getFacadeClass() {
        return CarrierIdentificationFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCarrierIdentificationEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, dagger.Lazy<GeneralPreferencesDataFactory> lazy) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<RetryConfig>() { // from class: id.dana.data.carrieridentification.source.network.NetworkCarrierIdentificationEntityData$retryConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RetryConfig invoke() {
                dagger.Lazy lazy2;
                lazy2 = NetworkCarrierIdentificationEntityData.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return ((GeneralPreferencesDataFactory) lazy2.get()).createData2("local").getLoginRegisterConfigResult().getRetryConfig();
            }
        });
    }

    @Override // id.dana.data.carrieridentification.source.CarrierIdentificationEntityData
    public final Observable<VerifySecurityProductResult> KClassImpl$Data$declaredNonStaticMembers$2(final VerifySecurityProductRequest p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.carrieridentification.source.network.NetworkCarrierIdentificationEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkCarrierIdentificationEntityData.MyBillsEntityDataFactory(VerifySecurityProductRequest.this, p1, (CarrierIdentificationFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.carrieridentification.source.CarrierIdentificationEntityData
    public final Observable<VerifyOtpResult> PlaceComponentResult(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5, final Map<String, String> p6) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        Intrinsics.checkNotNullParameter(p6, "");
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.carrieridentification.source.network.NetworkCarrierIdentificationEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkCarrierIdentificationEntityData.getAuthRequestContext(p1, p4, p5, p3, p2, p0, this, p6, (CarrierIdentificationFacade) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.carrieridentification.source.network.NetworkCarrierIdentificationEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkCarrierIdentificationEntityData.MyBillsEntityDataFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.carrieridentification.source.network.NetworkCarrierIdentificationEntityData$verifyOtpToRisk$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.carrieridentification.source.network.NetworkCarrierIdentificationEntityData$verifyOtpToRisk$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, ((RetryConfig) this.PlaceComponentResult.getValue()).getMaxRetry(), ((RetryConfig) this.PlaceComponentResult.getValue()).getRetryDelay());
    }

    public static /* synthetic */ VerifySecurityProductResult MyBillsEntityDataFactory(VerifySecurityProductRequest verifySecurityProductRequest, String str, CarrierIdentificationFacade carrierIdentificationFacade) {
        Intrinsics.checkNotNullParameter(verifySecurityProductRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        Map<String, String> map = verifySecurityProductRequest.extParams;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("redirectUri", str);
        return carrierIdentificationFacade.verifySecurityProduct(verifySecurityProductRequest);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    public static /* synthetic */ VerifyOtpResult getAuthRequestContext(String str, String str2, String str3, String str4, String str5, String str6, NetworkCarrierIdentificationEntityData networkCarrierIdentificationEntityData, Map map, CarrierIdentificationFacade carrierIdentificationFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(networkCarrierIdentificationEntityData, "");
        Intrinsics.checkNotNullParameter(map, "");
        VerifySecurityProductRequest verifySecurityProductRequest = new VerifySecurityProductRequest(null, null, null, null, null, null, null, null, null, 511, null);
        verifySecurityProductRequest.setSecurityId(str);
        verifySecurityProductRequest.setVerificationMethod(str2);
        verifySecurityProductRequest.setUserIdType(SpmTagConstant.REGISTRATION.TAG_PHONE_NUMBER);
        verifySecurityProductRequest.setSendOtpStrategy(str3);
        verifySecurityProductRequest.setValidateData(str4);
        verifySecurityProductRequest.setCorrelationId(str5);
        verifySecurityProductRequest.setPhoneNumber(str6);
        verifySecurityProductRequest.envInfo = networkCarrierIdentificationEntityData.generateMobileEnvInfo();
        verifySecurityProductRequest.extParams = map;
        return carrierIdentificationFacade.defaultVerifySecurityProduct(verifySecurityProductRequest);
    }
}
