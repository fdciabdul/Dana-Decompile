package id.dana.data.twilio.repository.source.network;

import android.content.Context;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import id.dana.data.carrieridentification.model.VerifySecurityProductRequest;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.login.source.network.result.RetryConfig;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.data.twilio.repository.source.TwilioEntityData;
import id.dana.data.twilio.repository.source.network.request.VerifyPushBindEnrollmentRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushConsultRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushDerollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushEnrollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushRequestChallengeRequest;
import id.dana.data.twilio.repository.source.network.result.VerifyPushBindEnrollmentResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushConsultResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushDerollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushEnrollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushRequestChallengeResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00010B7\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020'\u0012\u0006\u0010\u001e\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b.\u0010/J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0005\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\f\u0010\u0017J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0005\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\u0005\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u0013\u0010 \u001a\u00020%X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010&"}, d2 = {"Lid/dana/data/twilio/repository/source/network/NetworkTwilioEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/twilio/repository/source/network/VerifyPushFacade;", "Lid/dana/data/twilio/repository/source/TwilioEntityData;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushBindEnrollmentResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushConsultResult;", "PlaceComponentResult", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;", "getAuthRequestContext", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;)Lio/reactivex/Observable;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "", "p1", "Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "MyBillsEntityDataFactory", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;Ljava/lang/String;)Lio/reactivex/Observable;", "Ldagger/Lazy;", "Lid/dana/data/storage/GeneralPreferencesDataFactory;", "Ldagger/Lazy;", "Lid/dana/data/login/source/network/result/RetryConfig;", "Lkotlin/Lazy;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "p4", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkTwilioEntityData extends SecureBaseNetwork<VerifyPushFacade> implements TwilioEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final dagger.Lazy<GeneralPreferencesDataFactory> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<VerifyPushFacade> getFacadeClass() {
        return VerifyPushFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkTwilioEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, dagger.Lazy<GeneralPreferencesDataFactory> lazy) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<RetryConfig>() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$retryConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RetryConfig invoke() {
                dagger.Lazy lazy2;
                lazy2 = NetworkTwilioEntityData.this.BuiltInFictitiousFunctionClassFactory;
                return ((GeneralPreferencesDataFactory) lazy2.get()).createData2("local").getLoginRegisterConfigResult().getRetryConfig();
            }
        });
    }

    @Override // id.dana.data.twilio.repository.source.TwilioEntityData
    public final Observable<VerifyPushConsultResult> PlaceComponentResult(final VerifyPushConsultRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkTwilioEntityData.BuiltInFictitiousFunctionClassFactory(VerifyPushConsultRequest.this, this, (VerifyPushFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioEntityData
    public final Observable<VerifyPushEnrollResult> BuiltInFictitiousFunctionClassFactory(final VerifyPushEnrollRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<VerifyPushEnrollResult> timeout = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkTwilioEntityData.getAuthRequestContext(VerifyPushEnrollRequest.this, this, (VerifyPushFacade) obj);
            }
        }).timeout(3000L, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(timeout, "");
        return timeout;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioEntityData
    public final Observable<VerifyPushBindEnrollmentResult> KClassImpl$Data$declaredNonStaticMembers$2(final VerifyPushBindEnrollmentRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<VerifyPushBindEnrollmentResult> timeout = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkTwilioEntityData.BuiltInFictitiousFunctionClassFactory(VerifyPushBindEnrollmentRequest.this, this, (VerifyPushFacade) obj);
            }
        }).timeout(3000L, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(timeout, "");
        return timeout;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioEntityData
    public final Observable<VerifyPushDerollResult> PlaceComponentResult(final VerifyPushDerollRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkTwilioEntityData.PlaceComponentResult(VerifyPushDerollRequest.this, this, (VerifyPushFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioEntityData
    public final Observable<VerifyPushRequestChallengeResult> getAuthRequestContext(final VerifyPushRequestChallengeRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkTwilioEntityData.BuiltInFictitiousFunctionClassFactory(VerifyPushRequestChallengeRequest.this, this, (VerifyPushFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.twilio.repository.source.TwilioEntityData
    public final Observable<VerifySecurityProductResult> MyBillsEntityDataFactory(final VerifySecurityProductRequest p0, final String p1) {
        Observable wrapper;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (Intrinsics.areEqual(p0.getVerificationMethod(), "PASSWORD")) {
            wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda0
                @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                public final Object processFacade(Object obj) {
                    return NetworkTwilioEntityData.KClassImpl$Data$declaredNonStaticMembers$2(VerifySecurityProductRequest.this, p1, this, (VerifyPushFacade) obj);
                }
            });
        } else {
            wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda1
                @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
                public final Object processFacade(Object obj) {
                    return NetworkTwilioEntityData.MyBillsEntityDataFactory(VerifySecurityProductRequest.this, this, (VerifyPushFacade) obj);
                }
            });
        }
        Observable onErrorResumeNext = wrapper.onErrorResumeNext(new Function() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkTwilioEntityData.BuiltInFictitiousFunctionClassFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$verifySecurityProduct$4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.twilio.repository.source.network.NetworkTwilioEntityData$verifySecurityProduct$5
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, ((RetryConfig) this.MyBillsEntityDataFactory.getValue()).getMaxRetry(), ((RetryConfig) this.MyBillsEntityDataFactory.getValue()).getRetryDelay());
    }

    public static /* synthetic */ VerifyPushRequestChallengeResult BuiltInFictitiousFunctionClassFactory(VerifyPushRequestChallengeRequest verifyPushRequestChallengeRequest, NetworkTwilioEntityData networkTwilioEntityData, VerifyPushFacade verifyPushFacade) {
        Intrinsics.checkNotNullParameter(verifyPushRequestChallengeRequest, "");
        Intrinsics.checkNotNullParameter(networkTwilioEntityData, "");
        verifyPushRequestChallengeRequest.envInfo = networkTwilioEntityData.generateMobileEnvInfo();
        return verifyPushFacade.requestChallenge(verifyPushRequestChallengeRequest);
    }

    public static /* synthetic */ VerifySecurityProductResult KClassImpl$Data$declaredNonStaticMembers$2(VerifySecurityProductRequest verifySecurityProductRequest, String str, NetworkTwilioEntityData networkTwilioEntityData, VerifyPushFacade verifyPushFacade) {
        VerifySecurityProductRequest copy;
        Intrinsics.checkNotNullParameter(verifySecurityProductRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkTwilioEntityData, "");
        String encrypt = RSAHelper.encrypt(verifySecurityProductRequest.getValidateData(), str);
        Intrinsics.checkNotNullExpressionValue(encrypt, "");
        copy = verifySecurityProductRequest.copy((r20 & 1) != 0 ? verifySecurityProductRequest.token : null, (r20 & 2) != 0 ? verifySecurityProductRequest.securityId : null, (r20 & 4) != 0 ? verifySecurityProductRequest.verificationMethod : null, (r20 & 8) != 0 ? verifySecurityProductRequest.validateData : encrypt, (r20 & 16) != 0 ? verifySecurityProductRequest.sendStrategy : null, (r20 & 32) != 0 ? verifySecurityProductRequest.sendOtpStrategy : null, (r20 & 64) != 0 ? verifySecurityProductRequest.userIdType : null, (r20 & 128) != 0 ? verifySecurityProductRequest.correlationId : null, (r20 & 256) != 0 ? verifySecurityProductRequest.phoneNumber : null);
        copy.envInfo = networkTwilioEntityData.generateMobileEnvInfo();
        return verifyPushFacade.verifySecurityProduct(copy);
    }

    public static /* synthetic */ VerifyPushBindEnrollmentResult BuiltInFictitiousFunctionClassFactory(VerifyPushBindEnrollmentRequest verifyPushBindEnrollmentRequest, NetworkTwilioEntityData networkTwilioEntityData, VerifyPushFacade verifyPushFacade) {
        Intrinsics.checkNotNullParameter(verifyPushBindEnrollmentRequest, "");
        Intrinsics.checkNotNullParameter(networkTwilioEntityData, "");
        verifyPushBindEnrollmentRequest.envInfo = networkTwilioEntityData.generateMobileEnvInfo();
        return verifyPushFacade.bindEnrollment(verifyPushBindEnrollmentRequest);
    }

    public static /* synthetic */ VerifyPushDerollResult PlaceComponentResult(VerifyPushDerollRequest verifyPushDerollRequest, NetworkTwilioEntityData networkTwilioEntityData, VerifyPushFacade verifyPushFacade) {
        Intrinsics.checkNotNullParameter(verifyPushDerollRequest, "");
        Intrinsics.checkNotNullParameter(networkTwilioEntityData, "");
        verifyPushDerollRequest.envInfo = networkTwilioEntityData.generateMobileEnvInfo();
        return verifyPushFacade.unregister(verifyPushDerollRequest);
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    public static /* synthetic */ VerifySecurityProductResult MyBillsEntityDataFactory(VerifySecurityProductRequest verifySecurityProductRequest, NetworkTwilioEntityData networkTwilioEntityData, VerifyPushFacade verifyPushFacade) {
        Intrinsics.checkNotNullParameter(verifySecurityProductRequest, "");
        Intrinsics.checkNotNullParameter(networkTwilioEntityData, "");
        verifySecurityProductRequest.envInfo = networkTwilioEntityData.generateMobileEnvInfo();
        return verifyPushFacade.verifySecurityProduct(verifySecurityProductRequest);
    }

    public static /* synthetic */ VerifyPushEnrollResult getAuthRequestContext(VerifyPushEnrollRequest verifyPushEnrollRequest, NetworkTwilioEntityData networkTwilioEntityData, VerifyPushFacade verifyPushFacade) {
        Intrinsics.checkNotNullParameter(verifyPushEnrollRequest, "");
        Intrinsics.checkNotNullParameter(networkTwilioEntityData, "");
        verifyPushEnrollRequest.envInfo = networkTwilioEntityData.generateMobileEnvInfo();
        return verifyPushFacade.register(verifyPushEnrollRequest);
    }

    public static /* synthetic */ VerifyPushConsultResult BuiltInFictitiousFunctionClassFactory(VerifyPushConsultRequest verifyPushConsultRequest, NetworkTwilioEntityData networkTwilioEntityData, VerifyPushFacade verifyPushFacade) {
        Intrinsics.checkNotNullParameter(verifyPushConsultRequest, "");
        Intrinsics.checkNotNullParameter(networkTwilioEntityData, "");
        verifyPushConsultRequest.envInfo = networkTwilioEntityData.generateMobileEnvInfo();
        return verifyPushFacade.consult(verifyPushConsultRequest);
    }
}
