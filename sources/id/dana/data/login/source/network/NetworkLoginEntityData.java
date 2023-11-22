package id.dana.data.login.source.network;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Lazy;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$$ExternalSyntheticLambda2;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.logger.rds.RDSTracker;
import id.dana.data.foundation.logger.rds.RdsType;
import id.dana.data.login.source.HoldLoginEntityDataFactory;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.login.source.network.model.LoginType;
import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.data.login.source.network.request.LoginRpcRequest;
import id.dana.data.login.source.network.request.LogoutRpcRequest;
import id.dana.data.login.source.network.request.VerifyPasswordRpcRequest;
import id.dana.data.login.source.network.result.CheckSessionResult;
import id.dana.data.login.source.network.result.LogoutRpcResult;
import id.dana.data.login.source.network.result.RetryConfig;
import id.dana.data.registration.source.network.request.Trust2RiskLoginRequest;
import id.dana.data.registration.source.network.result.Trust2RiskLoginResult;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.domain.foundation.logger.LoginScenarioConstant;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.BotProtectionExceptionParser;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.response.login.LoginRpcResult;
import id.dana.network.response.login.VerifyPasswordRpcResult;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Singleton
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001aBM\b\u0007\u0012\u0006\u0010Z\u001a\u00020Y\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010H\u001a\u00020G\u0012\u0006\u0010Q\u001a\u00020P\u0012\f\u0010O\u001a\b\u0012\u0004\u0012\u00020N0J\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020K0J¢\u0006\u0004\b_\u0010`J!\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b!\u0010\"J/\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0017¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b)\u0010*JQ\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010+\u001a\u0004\u0018\u00010\u00132\b\u0010,\u001a\u0004\u0018\u00010\u00132\b\u0010-\u001a\u0004\u0018\u00010\u00132\b\u0010.\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\b\u0012\u0004\u0012\u0002010\u000fH\u0016¢\u0006\u0004\b2\u0010\u001dJW\u00106\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010\u00132\b\u00103\u001a\u0004\u0018\u00010\u00132\b\u00104\u001a\u0004\u0018\u00010\u00132\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b6\u00107J!\u0010;\u001a\u00020(2\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b;\u0010<J?\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b>\u0010?J-\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u000f2\u0006\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u0013H\u0016¢\u0006\u0004\bD\u0010'JK\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u00010\u00132\b\u00104\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020K0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020N0J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010MR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020S8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W"}, d2 = {"Lid/dana/data/login/source/network/NetworkLoginEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/login/source/network/LoginRpcFacade;", "Lid/dana/data/login/source/LoginEntityData;", "Lio/reactivex/functions/Function;", "", "Lio/reactivex/ObservableSource;", "Lid/dana/network/response/login/LoginRpcResult;", "checkExceptionType", "()Lio/reactivex/functions/Function;", "Lio/reactivex/functions/Consumer;", "checkHoldLoginResult", "()Lio/reactivex/functions/Consumer;", "", "isNewCheckSessionApi", "Lio/reactivex/Observable;", "Lid/dana/data/login/source/network/result/CheckSessionResult;", "checkSession", "(Ljava/lang/Boolean;)Lio/reactivex/Observable;", "", "phoneNumber", "isWhatsAppInstalled", "isPasskeysSupported", "credentialId", "Lid/dana/data/registration/source/network/result/Trust2RiskLoginResult;", "consultTrust2RiskLogin", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", BridgeName.GET_ENV_INFO, "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "getMobileEnvInfo", "(Ljava/lang/String;)Lcom/alipayplus/mobile/component/common/facade/base/MobileEnvInfo;", "userId", "clientKey", "operationType", "holdLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "holdLoginFail", "()V", "pin", "key", BioUtilityBridge.SECURITY_ID, "scenario", "login", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "Lid/dana/data/login/source/network/result/LogoutRpcResult;", "logout", "verifyAnswer", "loginType", "verifyMethod", LoginScenarioConstant.OTPLOGIN, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/login/source/network/request/LoginRpcRequest;", "request", "source", "reportWhenNullPhoneNumber", "(Lid/dana/data/login/source/network/request/LoginRpcRequest;Ljava/lang/String;)V", "loginTokenId", "trust2RiskLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "password", "scene", "loginOperationId", "Lid/dana/network/response/login/VerifyPasswordRpcResult;", "verifyPasswordTrustRiskV2", "verifyPushLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Ldagger/Lazy;", "Lid/dana/data/storage/GeneralPreferencesDataFactory;", "generalPreferencesDataFactory", "Ldagger/Lazy;", "Lid/dana/data/login/source/HoldLoginEntityDataFactory;", "holdLoginEntityDataFactory", "Lid/dana/data/foundation/logger/rds/RDSTracker;", "rdsTracker", "Lid/dana/data/foundation/logger/rds/RDSTracker;", "Lid/dana/data/login/source/network/result/RetryConfig;", "retryConfig$delegate", "Lkotlin/Lazy;", "getRetryConfig", "()Lid/dana/data/login/source/network/result/RetryConfig;", "retryConfig", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/data/foundation/logger/rds/RDSTracker;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkLoginEntityData extends SecureBaseNetwork<LoginRpcFacade> implements LoginEntityData {
    private static final String EXTEND_INFO_IS_SUPPORT_WA_OTP = "isSupportWAOtp";
    private static final String MOBILE_NO = "MOBILE_NO";
    private final Context context;
    private final Lazy<GeneralPreferencesDataFactory> generalPreferencesDataFactory;
    private final Lazy<HoldLoginEntityDataFactory> holdLoginEntityDataFactory;
    private final RDSTracker rdsTracker;

    /* renamed from: retryConfig$delegate  reason: from kotlin metadata */
    private final kotlin.Lazy retryConfig;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<LoginRpcFacade> getFacadeClass() {
        return LoginRpcFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkLoginEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, RDSTracker rDSTracker, Lazy<HoldLoginEntityDataFactory> lazy, Lazy<GeneralPreferencesDataFactory> lazy2) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rDSTracker, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.context = context;
        this.rdsTracker = rDSTracker;
        this.holdLoginEntityDataFactory = lazy;
        this.generalPreferencesDataFactory = lazy2;
        this.retryConfig = LazyKt.lazy(new Function0<RetryConfig>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$retryConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RetryConfig invoke() {
                Lazy lazy3;
                lazy3 = NetworkLoginEntityData.this.generalPreferencesDataFactory;
                return ((GeneralPreferencesDataFactory) lazy3.get()).createData2("local").getLoginRegisterConfigResult().getRetryConfig();
            }
        });
    }

    @JvmName(name = "getRetryConfig")
    private final RetryConfig getRetryConfig() {
        return (RetryConfig) this.retryConfig.getValue();
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<LoginRpcResult> trust2RiskLogin(final String phoneNumber, final String r11, final String loginTokenId, final String isPasskeysSupported, final String credentialId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(r11, "");
        Intrinsics.checkNotNullParameter(loginTokenId, "");
        Intrinsics.checkNotNullParameter(isPasskeysSupported, "");
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda7
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LoginRpcResult m1450trust2RiskLogin$lambda1;
                m1450trust2RiskLogin$lambda1 = NetworkLoginEntityData.m1450trust2RiskLogin$lambda1(phoneNumber, r11, loginTokenId, this, isPasskeysSupported, credentialId, (LoginRpcFacade) obj);
                return m1450trust2RiskLogin$lambda1;
            }
        }, LoginRpcResult.class).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$trust2RiskLogin$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$trust2RiskLogin$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: trust2RiskLogin$lambda-1 */
    public static final LoginRpcResult m1450trust2RiskLogin$lambda1(String str, String str2, String str3, NetworkLoginEntityData networkLoginEntityData, String str4, String str5, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        Trust2RiskLoginRequest trust2RiskLoginRequest = new Trust2RiskLoginRequest(str, "MOBILE_NO", "", str2, "", str3);
        trust2RiskLoginRequest.envInfo = networkLoginEntityData.generateMobileEnvInfo();
        Map<String, String> map = trust2RiskLoginRequest.envInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("isPasskeysSupported", str4);
        if (str5 != null) {
            Map<String, String> map2 = trust2RiskLoginRequest.envInfo.extendInfo;
            Intrinsics.checkNotNullExpressionValue(map2, "");
            map2.put("credentialId", str5);
        }
        return loginRpcFacade.trust2RiskLogin(trust2RiskLoginRequest);
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<Trust2RiskLoginResult> consultTrust2RiskLogin(final String phoneNumber, final Boolean isWhatsAppInstalled, final String isPasskeysSupported, final String credentialId) {
        Intrinsics.checkNotNullParameter(isPasskeysSupported, "");
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                Trust2RiskLoginResult m1445consultTrust2RiskLogin$lambda3;
                m1445consultTrust2RiskLogin$lambda3 = NetworkLoginEntityData.m1445consultTrust2RiskLogin$lambda3(phoneNumber, this, isWhatsAppInstalled, isPasskeysSupported, credentialId, (LoginRpcFacade) obj);
                return m1445consultTrust2RiskLogin$lambda3;
            }
        }, Trust2RiskLoginResult.class).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$consultTrust2RiskLogin$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$consultTrust2RiskLogin$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: consultTrust2RiskLogin$lambda-3 */
    public static final Trust2RiskLoginResult m1445consultTrust2RiskLogin$lambda3(String str, NetworkLoginEntityData networkLoginEntityData, Boolean bool, String str2, String str3, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        Trust2RiskLoginRequest trust2RiskLoginRequest = new Trust2RiskLoginRequest(str, "MOBILE_NO", "", "", "", "");
        MobileEnvInfo generateMobileEnvInfo = networkLoginEntityData.generateMobileEnvInfo();
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        if (bool != null) {
            Map<String, String> map = generateMobileEnvInfo.extendInfo;
            Intrinsics.checkNotNullExpressionValue(map, "");
            map.put(EXTEND_INFO_IS_SUPPORT_WA_OTP, bool.toString());
        }
        trust2RiskLoginRequest.envInfo = generateMobileEnvInfo;
        Map<String, String> map2 = trust2RiskLoginRequest.envInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        map2.put("isPasskeysSupported", str2);
        if (str3 != null) {
            Map<String, String> map3 = trust2RiskLoginRequest.envInfo.extendInfo;
            Intrinsics.checkNotNullExpressionValue(map3, "");
            map3.put("credentialId", str3);
        }
        return loginRpcFacade.consultTrust2RiskLogin(trust2RiskLoginRequest);
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<LoginRpcResult> login(final String phoneNumber, final String pin, final String key, final String r13, final String scenario, final Boolean isWhatsAppInstalled) {
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LoginRpcResult m1447login$lambda5;
                m1447login$lambda5 = NetworkLoginEntityData.m1447login$lambda5(NetworkLoginEntityData.this, scenario, pin, key, phoneNumber, isWhatsAppInstalled, r13, (LoginRpcFacade) obj);
                return m1447login$lambda5;
            }
        }, LoginRpcResult.class).onErrorResumeNext(checkExceptionType()).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$login$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$login$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: login$lambda-5 */
    public static final LoginRpcResult m1447login$lambda5(NetworkLoginEntityData networkLoginEntityData, String str, String str2, String str3, String str4, Boolean bool, String str5, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
        loginRpcRequest.credentials = RSAHelper.encrypt(str2, str3);
        loginRpcRequest.loginId = str4;
        loginRpcRequest.loginIdType = "MOBILE_NO";
        MobileEnvInfo mobileEnvInfo = networkLoginEntityData.getMobileEnvInfo(str4);
        if (bool != null) {
            Map<String, String> map = mobileEnvInfo.extendInfo;
            Intrinsics.checkNotNullExpressionValue(map, "");
            map.put(EXTEND_INFO_IS_SUPPORT_WA_OTP, bool.toString());
        }
        loginRpcRequest.envInfo = mobileEnvInfo;
        if (Intrinsics.areEqual(LoginScenarioConstant.TRUSTRISKLOGIN, str)) {
            loginRpcRequest.loginType = LoginType.TRUST_RISK_LOGIN;
            loginRpcRequest.securityId = str5;
            loginRpcRequest.verifyAnswer = loginRpcRequest.credentials;
            loginRpcRequest.verifyMethod = "PASSWORD";
        } else {
            loginRpcRequest.loginType = LoginType.NORMAL_LOGIN;
        }
        networkLoginEntityData.reportWhenNullPhoneNumber(loginRpcRequest, str);
        return loginRpcFacade.login(loginRpcRequest);
    }

    private final Function<Throwable, ObservableSource<LoginRpcResult>> checkExceptionType() {
        return new Function() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1441checkExceptionType$lambda6;
                m1441checkExceptionType$lambda6 = NetworkLoginEntityData.m1441checkExceptionType$lambda6(NetworkLoginEntityData.this, (Throwable) obj);
                return m1441checkExceptionType$lambda6;
            }
        };
    }

    /* renamed from: checkExceptionType$lambda-6 */
    public static final ObservableSource m1441checkExceptionType$lambda6(NetworkLoginEntityData networkLoginEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return new BotProtectionExceptionParser(networkLoginEntityData.context, "alipayplus.mobilewallet.user.login").apply(th);
    }

    @Override // id.dana.data.login.source.LoginEntityData
    @Deprecated(message = "")
    public final Observable<LoginRpcResult> holdLogin(String userId, String clientKey, String operationType) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(clientKey, "");
        Observable<LoginRpcResult> doOnError = this.holdLoginEntityDataFactory.get().createData2("network").holdLogin(userId, clientKey, operationType).doOnError(checkHoldLoginResult());
        Intrinsics.checkNotNullExpressionValue(doOnError, "");
        return doOnError;
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<LoginRpcResult> otpLogin(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LoginRpcResult m1449otpLogin$lambda8;
                m1449otpLogin$lambda8 = NetworkLoginEntityData.m1449otpLogin$lambda8(str2, str3, this, str, str4, str7, str5, str6, (LoginRpcFacade) obj);
                return m1449otpLogin$lambda8;
            }
        }, LoginRpcResult.class).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$otpLogin$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$otpLogin$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: otpLogin$lambda-8 */
    public static final LoginRpcResult m1449otpLogin$lambda8(String str, String str2, NetworkLoginEntityData networkLoginEntityData, String str3, String str4, String str5, String str6, String str7, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
        loginRpcRequest.credentials = RSAHelper.encrypt(str, str2);
        loginRpcRequest.envInfo = networkLoginEntityData.getMobileEnvInfo(str3);
        loginRpcRequest.loginId = str3;
        loginRpcRequest.loginIdType = "MOBILE_NO";
        loginRpcRequest.securityId = str4;
        loginRpcRequest.verifyMethod = str5;
        loginRpcRequest.verifyAnswer = str6;
        if (StringsKt.equals(LoginType.TRUST_RISK_LOGIN, str7, true)) {
            loginRpcRequest.loginType = LoginType.TRUST_RISK_LOGIN;
        } else {
            loginRpcRequest.loginType = LoginType.NORMAL_LOGIN;
        }
        networkLoginEntityData.reportWhenNullPhoneNumber(loginRpcRequest, LoginScenarioConstant.OTPLOGIN);
        return loginRpcFacade.login(loginRpcRequest);
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<LoginRpcResult> verifyPushLogin(final String phoneNumber, final String pin, final String key, final String r14, final String verifyAnswer, final String loginType) {
        Intrinsics.checkNotNullParameter(pin, "");
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(r14, "");
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LoginRpcResult m1452verifyPushLogin$lambda10;
                m1452verifyPushLogin$lambda10 = NetworkLoginEntityData.m1452verifyPushLogin$lambda10(NetworkLoginEntityData.this, pin, key, phoneNumber, r14, verifyAnswer, loginType, (LoginRpcFacade) obj);
                return m1452verifyPushLogin$lambda10;
            }
        }, LoginRpcResult.class).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$verifyPushLogin$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$verifyPushLogin$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: verifyPushLogin$lambda-10 */
    public static final LoginRpcResult m1452verifyPushLogin$lambda10(NetworkLoginEntityData networkLoginEntityData, String str, String str2, String str3, String str4, String str5, String str6, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        LoginRpcRequest loginRpcRequest = new LoginRpcRequest();
        loginRpcRequest.credentials = RSAHelper.encrypt(str, str2);
        loginRpcRequest.envInfo = networkLoginEntityData.getMobileEnvInfo(str3);
        loginRpcRequest.loginId = str3;
        loginRpcRequest.loginIdType = "MOBILE_NO";
        loginRpcRequest.securityId = str4;
        loginRpcRequest.verifyMethod = VerifyMethod.PUSH_VERIFY;
        loginRpcRequest.verifyAnswer = str5;
        if (StringsKt.equals(LoginType.TRUST_RISK_LOGIN, str6, true)) {
            loginRpcRequest.loginType = LoginType.TRUST_RISK_LOGIN;
        } else {
            loginRpcRequest.loginType = LoginType.NORMAL_LOGIN;
        }
        networkLoginEntityData.reportWhenNullPhoneNumber(loginRpcRequest, LoginScenarioConstant.OTPLOGIN);
        return loginRpcFacade.login(loginRpcRequest);
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<LogoutRpcResult> logout() {
        final LogoutRpcRequest logoutRpcRequest = new LogoutRpcRequest();
        logoutRpcRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda11
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                LogoutRpcResult m1448logout$lambda11;
                m1448logout$lambda11 = NetworkLoginEntityData.m1448logout$lambda11(LogoutRpcRequest.this, (LoginRpcFacade) obj);
                return m1448logout$lambda11;
            }
        }, LogoutRpcResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: logout$lambda-11 */
    public static final LogoutRpcResult m1448logout$lambda11(LogoutRpcRequest logoutRpcRequest, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(logoutRpcRequest, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        return loginRpcFacade.logout(logoutRpcRequest);
    }

    /* renamed from: getEnvInfo$lambda-12 */
    public static final MobileEnvInfo m1446getEnvInfo$lambda12(NetworkLoginEntityData networkLoginEntityData) {
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        return networkLoginEntityData.generateMobileEnvInfo();
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<MobileEnvInfo> getEnvInfo() {
        Observable<MobileEnvInfo> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                MobileEnvInfo m1446getEnvInfo$lambda12;
                m1446getEnvInfo$lambda12 = NetworkLoginEntityData.m1446getEnvInfo$lambda12(NetworkLoginEntityData.this);
                return m1446getEnvInfo$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<VerifyPasswordRpcResult> verifyPasswordTrustRiskV2(final String password, final String scene, final String loginOperationId) {
        Intrinsics.checkNotNullParameter(password, "");
        Intrinsics.checkNotNullParameter(scene, "");
        Intrinsics.checkNotNullParameter(loginOperationId, "");
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                VerifyPasswordRpcResult m1451verifyPasswordTrustRiskV2$lambda13;
                m1451verifyPasswordTrustRiskV2$lambda13 = NetworkLoginEntityData.m1451verifyPasswordTrustRiskV2$lambda13(password, scene, loginOperationId, this, (LoginRpcFacade) obj);
                return m1451verifyPasswordTrustRiskV2$lambda13;
            }
        }, VerifyPasswordRpcResult.class).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$verifyPasswordTrustRiskV2$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$verifyPasswordTrustRiskV2$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: verifyPasswordTrustRiskV2$lambda-13 */
    public static final VerifyPasswordRpcResult m1451verifyPasswordTrustRiskV2$lambda13(String str, String str2, String str3, NetworkLoginEntityData networkLoginEntityData, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        VerifyPasswordRpcRequest verifyPasswordRpcRequest = new VerifyPasswordRpcRequest(str, str2, str3);
        verifyPasswordRpcRequest.envInfo = networkLoginEntityData.generateMobileEnvInfo();
        return loginRpcFacade.verifyPasswordTrustRiskV2(verifyPasswordRpcRequest);
    }

    @Override // id.dana.data.login.source.LoginEntityData
    public final Observable<CheckSessionResult> checkSession(final Boolean isNewCheckSessionApi) {
        Observable<CheckSessionResult> onErrorReturn = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda9
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                CheckSessionResult m1443checkSession$lambda14;
                m1443checkSession$lambda14 = NetworkLoginEntityData.m1443checkSession$lambda14(NetworkLoginEntityData.this, isNewCheckSessionApi, (LoginRpcFacade) obj);
                return m1443checkSession$lambda14;
            }
        }, CheckSessionResult.class).onErrorReturn(new Function() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CheckSessionResult m1444checkSession$lambda15;
                m1444checkSession$lambda15 = NetworkLoginEntityData.m1444checkSession$lambda15((Throwable) obj);
                return m1444checkSession$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* renamed from: checkSession$lambda-14 */
    public static final CheckSessionResult m1443checkSession$lambda14(NetworkLoginEntityData networkLoginEntityData, Boolean bool, LoginRpcFacade loginRpcFacade) {
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        Intrinsics.checkNotNullParameter(loginRpcFacade, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkLoginEntityData.generateMobileEnvInfo();
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return loginRpcFacade.newCheckSession(baseRpcRequest);
        }
        return loginRpcFacade.checkSession(baseRpcRequest);
    }

    /* renamed from: checkSession$lambda-15 */
    public static final CheckSessionResult m1444checkSession$lambda15(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new CheckSessionResult(false);
    }

    private final MobileEnvInfo getMobileEnvInfo(String phoneNumber) {
        MobileEnvInfo generateMobileEnvInfo = generateMobileEnvInfo();
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        Map<String, String> map = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put(RdsType.KEY_RDS, RDSTracker.BuiltInFictitiousFunctionClassFactory(phoneNumber));
        return generateMobileEnvInfo;
    }

    private final Consumer<Throwable> checkHoldLoginResult() {
        return new Consumer() { // from class: id.dana.data.login.source.network.NetworkLoginEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NetworkLoginEntityData.m1442checkHoldLoginResult$lambda16(NetworkLoginEntityData.this, (Throwable) obj);
            }
        };
    }

    /* renamed from: checkHoldLoginResult$lambda-16 */
    public static final void m1442checkHoldLoginResult$lambda16(NetworkLoginEntityData networkLoginEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkLoginEntityData, "");
        if (th instanceof HoldLoginException) {
            networkLoginEntityData.holdLoginFail();
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.HOLDLOGIN_PREFIX, DanaLogConstants.ExceptionType.HOLDLOGIN_EXCEPTION, ((HoldLoginException) th).getMessage());
        } else if (th != null) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.HOLDLOGIN_PREFIX, DanaLogConstants.ExceptionType.HOLDLOGIN_EXCEPTION, th.toString());
        }
    }

    private final void holdLoginFail() {
        Intent intent = new Intent();
        intent.setAction("id.dana.splash");
        LocalBroadcastManager.getInstance(this.context).sendBroadcast(intent);
    }

    private final void reportWhenNullPhoneNumber(LoginRpcRequest request, String source) {
        StringBuilder sb = new StringBuilder();
        sb.append(source);
        sb.append(" with params: [request: phoneNumber=");
        sb.append(request.loginId);
        sb.append(']');
        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(DanaLogConstants.TAG.PHONE_NUMBER_EMPTY_TAG, sb.toString());
        if (TextUtils.isEmpty(request.loginId)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(source);
            sb2.append(" with params: [phoneNumber: ");
            sb2.append(request.loginId);
            sb2.append(" ]");
            DanaLog.BuiltInFictitiousFunctionClassFactory("login", DanaLogConstants.TAG.PHONE_NUMBER_EMPTY_TAG, sb2.toString());
        }
    }
}
