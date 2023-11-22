package id.dana.data.registration.source.network;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Lazy;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.config.model.OtpWhatsAppConfig;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.logger.rds.RDSConstant;
import id.dana.data.foundation.logger.rds.RDSTracker;
import id.dana.data.foundation.logger.rds.RdsType;
import id.dana.data.login.source.network.result.RetryConfig;
import id.dana.data.promocode.PromoAndReferralCodeUtilKt;
import id.dana.data.registration.source.RegistrationEntityData;
import id.dana.data.registration.source.network.request.CheckUserRegistrationStatusRequest;
import id.dana.data.registration.source.network.request.RegisterRpcRequest;
import id.dana.data.registration.source.network.result.CheckUserRegistrationStatusResult;
import id.dana.data.registration.source.network.result.RegisterRpcResult;
import id.dana.data.storage.GeneralPreferencesDataFactory;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.BotProtectionExceptionParser;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001;B?\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010+\u001a\u00020*\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u0004\b9\u0010:J[\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013Je\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010!\u001a\u00020 2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101"}, d2 = {"Lid/dana/data/registration/source/network/NetworkRegistrationEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/registration/source/network/RegistrationRpcFacade;", "Lid/dana/data/registration/source/RegistrationEntityData;", "", "phoneNumber", "otpChannel", "clientId", "merchantId", "", "skipSendOtp", "isWhatsAppInstalled", NetworkRegistrationEntityData.EXTEND_INFO_IS_NETWORK_ELIGIBLE, "Lio/reactivex/Observable;", "Lid/dana/data/registration/source/network/result/CheckUserRegistrationStatusResult;", "checkRegistrationAndSendOtp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "pin", "key", "nickname", AccountEntityRepository.UpdateType.AVATAR, "referralCode", "verifyMethod", "cityName", "Lid/dana/data/registration/source/network/result/RegisterRpcResult;", DanaLogConstants.BizType.REGISTER, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/registration/source/network/request/RegisterRpcRequest;", "request", "", "reportWhenNullPhoneNumber", "(Ljava/lang/String;Lid/dana/data/registration/source/network/request/RegisterRpcRequest;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Ldagger/Lazy;", "Lid/dana/data/storage/GeneralPreferencesDataFactory;", "generalPreferencesDataFactory", "Ldagger/Lazy;", "Lid/dana/data/foundation/logger/rds/RDSTracker;", "rdsTracker", "Lid/dana/data/foundation/logger/rds/RDSTracker;", "Lid/dana/data/login/source/network/result/RetryConfig;", "retryConfig$delegate", "Lkotlin/Lazy;", "getRetryConfig", "()Lid/dana/data/login/source/network/result/RetryConfig;", "retryConfig", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;Lid/dana/data/foundation/logger/rds/RDSTracker;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkRegistrationEntityData extends SecureBaseNetwork<RegistrationRpcFacade> implements RegistrationEntityData {
    private static final String EXTEND_INFO_IS_NETWORK_ELIGIBLE = "isNetworkEligible";
    private static final String EXTEND_INFO_IS_SUPPORT_WA_OTP = "isSupportWAOtp";
    private static final String MOBILE_NO = "MOBILE_NO";
    private final Context context;
    private final Lazy<GeneralPreferencesDataFactory> generalPreferencesDataFactory;
    private final RDSTracker rdsTracker;

    /* renamed from: retryConfig$delegate  reason: from kotlin metadata */
    private final kotlin.Lazy retryConfig;

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ void clearAll() {
        RegistrationEntityData.CC.$default$clearAll(this);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ void clearIsFreezeVerifyOtp(String str) {
        RegistrationEntityData.CC.$default$clearIsFreezeVerifyOtp(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ void clearLastOtpChannel(String str) {
        RegistrationEntityData.CC.$default$clearLastOtpChannel(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ void clearResendOtpTimelimit(String str) {
        RegistrationEntityData.CC.$default$clearResendOtpTimelimit(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable getChatBotTimestamp(String str) {
        return RegistrationEntityData.CC.$default$getChatBotTimestamp(this, str);
    }

    @Override // id.dana.network.base.BaseNetwork
    public final Class<RegistrationRpcFacade> getFacadeClass() {
        return RegistrationRpcFacade.class;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable getIsFreezeVerifyOtp(String str) {
        return RegistrationEntityData.CC.$default$getIsFreezeVerifyOtp(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable getLastOtpChannel(String str) {
        return RegistrationEntityData.CC.$default$getLastOtpChannel(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable getNumberOfRequestOtp(String str) {
        return RegistrationEntityData.CC.$default$getNumberOfRequestOtp(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable getResendOtpTimelimit(String str) {
        return RegistrationEntityData.CC.$default$getResendOtpTimelimit(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable removeNumberOfRequestOtp(String str) {
        return RegistrationEntityData.CC.$default$removeNumberOfRequestOtp(this, str);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable saveChatBotTimestamp(String str, long j) {
        return RegistrationEntityData.CC.$default$saveChatBotTimestamp(this, str, j);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable saveIsFreezeVerifyOtp(String str, boolean z) {
        return RegistrationEntityData.CC.$default$saveIsFreezeVerifyOtp(this, str, z);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ void saveLastOtpChannel(String str, String str2) {
        RegistrationEntityData.CC.$default$saveLastOtpChannel(this, str, str2);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable saveNumberOfRequestOtp(String str, int i, OtpWhatsAppConfig otpWhatsAppConfig) {
        return RegistrationEntityData.CC.$default$saveNumberOfRequestOtp(this, str, i, otpWhatsAppConfig);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable saveResendOtpTimelimit(String str, long j) {
        return RegistrationEntityData.CC.$default$saveResendOtpTimelimit(this, str, j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkRegistrationEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, RDSTracker rDSTracker, Lazy<GeneralPreferencesDataFactory> lazy) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rDSTracker, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.context = context;
        this.rdsTracker = rDSTracker;
        this.generalPreferencesDataFactory = lazy;
        this.retryConfig = LazyKt.lazy(new Function0<RetryConfig>() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$retryConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RetryConfig invoke() {
                Lazy lazy2;
                lazy2 = NetworkRegistrationEntityData.this.generalPreferencesDataFactory;
                return ((GeneralPreferencesDataFactory) lazy2.get()).createData2("local").getLoginRegisterConfigResult().getRetryConfig();
            }
        });
    }

    @JvmName(name = "getRetryConfig")
    private final RetryConfig getRetryConfig() {
        return (RetryConfig) this.retryConfig.getValue();
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<CheckUserRegistrationStatusResult> checkRegistrationAndSendOtp(final String phoneNumber, final String otpChannel, final String clientId, final String merchantId, final Boolean skipSendOtp, final Boolean isWhatsAppInstalled, final Boolean r18) {
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                CheckUserRegistrationStatusResult m1830checkRegistrationAndSendOtp$lambda2;
                m1830checkRegistrationAndSendOtp$lambda2 = NetworkRegistrationEntityData.m1830checkRegistrationAndSendOtp$lambda2(NetworkRegistrationEntityData.this, isWhatsAppInstalled, r18, otpChannel, phoneNumber, clientId, merchantId, skipSendOtp, (RegistrationRpcFacade) obj);
                return m1830checkRegistrationAndSendOtp$lambda2;
            }
        }, CheckUserRegistrationStatusResult.class).onErrorResumeNext(new Function() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1831checkRegistrationAndSendOtp$lambda3;
                m1831checkRegistrationAndSendOtp$lambda3 = NetworkRegistrationEntityData.m1831checkRegistrationAndSendOtp$lambda3(NetworkRegistrationEntityData.this, (Throwable) obj);
                return m1831checkRegistrationAndSendOtp$lambda3;
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1832checkRegistrationAndSendOtp$lambda4;
                m1832checkRegistrationAndSendOtp$lambda4 = NetworkRegistrationEntityData.m1832checkRegistrationAndSendOtp$lambda4((Throwable) obj);
                return m1832checkRegistrationAndSendOtp$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$checkRegistrationAndSendOtp$4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$checkRegistrationAndSendOtp$5
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: checkRegistrationAndSendOtp$lambda-2 */
    public static final CheckUserRegistrationStatusResult m1830checkRegistrationAndSendOtp$lambda2(NetworkRegistrationEntityData networkRegistrationEntityData, Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, Boolean bool3, RegistrationRpcFacade registrationRpcFacade) {
        Intrinsics.checkNotNullParameter(networkRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(registrationRpcFacade, "");
        CheckUserRegistrationStatusRequest checkUserRegistrationStatusRequest = new CheckUserRegistrationStatusRequest();
        MobileEnvInfo generateMobileEnvInfo = networkRegistrationEntityData.generateMobileEnvInfo();
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        Map<String, String> map = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put(EXTEND_INFO_IS_SUPPORT_WA_OTP, String.valueOf(bool));
        Map<String, String> map2 = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        map2.put(EXTEND_INFO_IS_NETWORK_ELIGIBLE, String.valueOf(bool2));
        if (str == null) {
            Map<String, String> map3 = generateMobileEnvInfo.extendInfo;
            Intrinsics.checkNotNullExpressionValue(map3, "");
            RDSTracker rDSTracker = networkRegistrationEntityData.rdsTracker;
            map3.put(RdsType.KEY_RDS, RDSTracker.BuiltInFictitiousFunctionClassFactory(str2));
            Map<String, String> map4 = generateMobileEnvInfo.extendInfo;
            Intrinsics.checkNotNullExpressionValue(map4, "");
            map4.put(RdsType.KEY_RDS_SCENE, RDSConstant.NEXT_CHECK_REGISTER);
        }
        checkUserRegistrationStatusRequest.envInfo = generateMobileEnvInfo;
        checkUserRegistrationStatusRequest.phoneNumber = str2;
        checkUserRegistrationStatusRequest.otpChannel = str;
        checkUserRegistrationStatusRequest.clientId = str3;
        checkUserRegistrationStatusRequest.subMerchantId = str4;
        checkUserRegistrationStatusRequest.skipSendOtp = bool3;
        return registrationRpcFacade.checkRegisteredUserAndSendOtp(checkUserRegistrationStatusRequest);
    }

    /* renamed from: checkRegistrationAndSendOtp$lambda-3 */
    public static final ObservableSource m1831checkRegistrationAndSendOtp$lambda3(NetworkRegistrationEntityData networkRegistrationEntityData, Throwable th) {
        Intrinsics.checkNotNullParameter(networkRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(th, "");
        return new BotProtectionExceptionParser(networkRegistrationEntityData.context, "alipayplus.mobilewallet.user.checkRegisteredUserAndSendOTP").apply(th);
    }

    /* renamed from: checkRegistrationAndSendOtp$lambda-4 */
    public static final ObservableSource m1832checkRegistrationAndSendOtp$lambda4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<RegisterRpcResult> register(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8) {
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RegisterRpcResult m1833register$lambda6;
                m1833register$lambda6 = NetworkRegistrationEntityData.m1833register$lambda6(NetworkRegistrationEntityData.this, str, str8, str2, str3, str4, str5, str6, str7, (RegistrationRpcFacade) obj);
                return m1833register$lambda6;
            }
        }, RegisterRpcResult.class).onErrorResumeNext(new Function() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1834register$lambda7;
                m1834register$lambda7 = NetworkRegistrationEntityData.m1834register$lambda7((Throwable) obj);
                return m1834register$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$register$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.registration.source.network.NetworkRegistrationEntityData$register$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, getRetryConfig().getMaxRetry(), getRetryConfig().getRetryDelay());
    }

    /* renamed from: register$lambda-6 */
    public static final RegisterRpcResult m1833register$lambda6(NetworkRegistrationEntityData networkRegistrationEntityData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, RegistrationRpcFacade registrationRpcFacade) {
        Intrinsics.checkNotNullParameter(networkRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(registrationRpcFacade, "");
        RegisterRpcRequest registerRpcRequest = new RegisterRpcRequest();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        RDSTracker rDSTracker = networkRegistrationEntityData.rdsTracker;
        String BuiltInFictitiousFunctionClassFactory = RDSTracker.BuiltInFictitiousFunctionClassFactory(str);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        linkedHashMap.put(RdsType.KEY_RDS, BuiltInFictitiousFunctionClassFactory);
        String str9 = str2;
        if (!(str9 == null || str9.length() == 0)) {
            PromoAndReferralCodeUtilKt.setUserCity(linkedHashMap, str2);
        }
        MobileEnvInfo generateMobileEnvInfo = networkRegistrationEntityData.generateMobileEnvInfo();
        Intrinsics.checkNotNullExpressionValue(generateMobileEnvInfo, "");
        generateMobileEnvInfo.extendInfo = linkedHashMap;
        registerRpcRequest.envInfo = generateMobileEnvInfo;
        registerRpcRequest.envInfo.clientKey = networkRegistrationEntityData.getClientKey();
        registerRpcRequest.phoneNumber = networkRegistrationEntityData.normalizePhoneNumber(str);
        registerRpcRequest.passcode = RSAHelper.encrypt(str3, str4);
        registerRpcRequest.nickname = str5;
        registerRpcRequest.avatarUrl = str6;
        registerRpcRequest.referralCode = str7;
        registerRpcRequest.verifyMethod = str8;
        networkRegistrationEntityData.reportWhenNullPhoneNumber(str, registerRpcRequest);
        return registrationRpcFacade.register(registerRpcRequest);
    }

    /* renamed from: register$lambda-7 */
    public static final ObservableSource m1834register$lambda7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return new ConnectionExceptionParser().apply(th);
    }

    private final void reportWhenNullPhoneNumber(String phoneNumber, RegisterRpcRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("register with params: [phoneNumber: ");
        sb.append(phoneNumber);
        sb.append(" ]\t\t[request: phoneNumber=");
        sb.append(request.phoneNumber);
        sb.append(", nickname=");
        sb.append(request.nickname);
        sb.append(']');
        DanaLog.KClassImpl$Data$declaredNonStaticMembers$2(DanaLogConstants.TAG.PHONE_NUMBER_EMPTY_TAG, sb.toString());
        if (TextUtils.isEmpty(request.phoneNumber)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("register with params: [phoneNumber: ");
            sb2.append(phoneNumber);
            sb2.append(" ]\t\t[request: phoneNumber=");
            sb2.append(request.phoneNumber);
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.REGISTER, DanaLogConstants.TAG.PHONE_NUMBER_EMPTY_TAG, sb2.toString());
        }
    }
}
