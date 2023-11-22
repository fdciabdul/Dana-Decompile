package id.dana.riskChallenges.data.verifypassword.source.network;

import android.content.Context;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.login.source.network.result.RetryConfig;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.rpc.RpcConnector;
import id.dana.riskChallenges.data.verifypassword.source.VerifyPasswordEntityData;
import id.dana.riskChallenges.data.verifypassword.source.network.request.VerifyPasswordRequest;
import id.dana.riskChallenges.data.verifypassword.source.network.request.VerifySecurityPasswordRequest;
import id.dana.riskChallenges.data.verifypassword.source.network.result.VerifyPasswordResult;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.tracker.spm.SpmTagConstant;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@RiskChallengesScope
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001#B7\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u001d\u0012\u0006\u0010\t\u001a\u00020\u001e\u0012\u0006\u0010\n\u001a\u00020\u001f\u0012\u0006\u0010\u000b\u001a\u00020 \u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J=\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JE\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0013\u0010\u001c\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/riskChallenges/data/verifypassword/source/network/NetworkVerifyPasswordEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/riskChallenges/data/verifypassword/source/network/VerifyPasswordFacade;", "Lid/dana/riskChallenges/data/verifypassword/source/VerifyPasswordEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "p1", "p2", "p3", "", "p4", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "p5", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ldagger/Lazy;", "Lid/dana/data/storage/GeneralPreferencesDataFactory;", "Ldagger/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/login/source/network/result/RetryConfig;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkVerifyPasswordEntityData extends SecureBaseNetwork<VerifyPasswordFacade> implements VerifyPasswordEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final dagger.Lazy<GeneralPreferencesDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<VerifyPasswordFacade> getFacadeClass() {
        return VerifyPasswordFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkVerifyPasswordEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, dagger.Lazy<GeneralPreferencesDataFactory> lazy) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<RetryConfig>() { // from class: id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData$retryConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RetryConfig invoke() {
                dagger.Lazy lazy2;
                lazy2 = NetworkVerifyPasswordEntityData.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return ((GeneralPreferencesDataFactory) lazy2.get()).createData2("local").getLoginRegisterConfigResult().getRetryConfig();
            }
        });
    }

    @Override // id.dana.riskChallenges.data.verifypassword.source.VerifyPasswordEntityData
    public final Observable<VerifyPasswordResult> getAuthRequestContext(final String p0, final String p1, final String p2, final String p3, final boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable<VerifyPasswordResult> onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkVerifyPasswordEntityData.PlaceComponentResult(p1, p0, p2, p3, this, p4, (VerifyPasswordFacade) obj);
            }
        }, VerifyPasswordResult.class).onErrorResumeNext(new Function() { // from class: id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkVerifyPasswordEntityData.MyBillsEntityDataFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    @Override // id.dana.riskChallenges.data.verifypassword.source.VerifyPasswordEntityData
    public final Observable<VerifyPasswordResult> PlaceComponentResult(final String p0, final String p1, final String p2, final String p3, final String p4, String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkVerifyPasswordEntityData.MyBillsEntityDataFactory(p3, p2, p0, p4, p1, this, (VerifyPasswordFacade) obj);
            }
        }, VerifyPasswordResult.class).onErrorResumeNext(new Function() { // from class: id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkVerifyPasswordEntityData.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData$verifySecurityPassword$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.riskChallenges.data.verifypassword.source.network.NetworkVerifyPasswordEntityData$verifySecurityPassword$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, ((RetryConfig) this.MyBillsEntityDataFactory.getValue()).getMaxRetry(), ((RetryConfig) this.MyBillsEntityDataFactory.getValue()).getRetryDelay());
    }

    public static /* synthetic */ VerifyPasswordResult PlaceComponentResult(String str, String str2, String str3, String str4, NetworkVerifyPasswordEntityData networkVerifyPasswordEntityData, boolean z, VerifyPasswordFacade verifyPasswordFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(networkVerifyPasswordEntityData, "");
        String encrypt = RSAHelper.encrypt(str, str2);
        Intrinsics.checkNotNullExpressionValue(encrypt, "");
        VerifyPasswordRequest verifyPasswordRequest = new VerifyPasswordRequest(encrypt, "PASSWORD", str3, str4);
        MobileEnvInfo generateMobileEnvInfo = networkVerifyPasswordEntityData.generateMobileEnvInfo();
        Map<String, String> map = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("operationOrigin", "Native");
        Map<String, String> map2 = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        map2.put("isSupportWAOtp", String.valueOf(z));
        verifyPasswordRequest.envInfo = generateMobileEnvInfo;
        return verifyPasswordFacade.verifyPassword(verifyPasswordRequest);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    public static /* synthetic */ VerifyPasswordResult MyBillsEntityDataFactory(String str, String str2, String str3, String str4, String str5, NetworkVerifyPasswordEntityData networkVerifyPasswordEntityData, VerifyPasswordFacade verifyPasswordFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(networkVerifyPasswordEntityData, "");
        String encrypt = RSAHelper.encrypt(str, str2);
        Intrinsics.checkNotNullExpressionValue(encrypt, "");
        VerifySecurityPasswordRequest verifySecurityPasswordRequest = new VerifySecurityPasswordRequest(null, str3, "PASSWORD", encrypt, str4, str4, SpmTagConstant.REGISTRATION.TAG_PHONE_NUMBER, null, str5, 129, null);
        MobileEnvInfo generateMobileEnvInfo = networkVerifyPasswordEntityData.generateMobileEnvInfo();
        Map<String, String> map = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("operationOrigin", "Native");
        verifySecurityPasswordRequest.envInfo = generateMobileEnvInfo;
        return verifyPasswordFacade.verifySecurityPassword(verifySecurityPasswordRequest);
    }
}
