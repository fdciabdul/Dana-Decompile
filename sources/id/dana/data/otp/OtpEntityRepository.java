package id.dana.data.otp;

import android.os.Bundle;
import android.text.TextUtils;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.login.VerifyChallengeManager;
import id.dana.data.nearbyme.repository.NearbyMeEntityRepository$$ExternalSyntheticLambda1;
import id.dana.data.otp.mapper.OtpBankMapper;
import id.dana.data.otp.mapper.OtpMapper;
import id.dana.data.otp.repository.source.OtpEntityData;
import id.dana.data.otp.repository.source.OtpEntityDataFactory;
import id.dana.data.otp.repository.source.network.request.SendBankOtpEntityRequest;
import id.dana.data.otp.repository.source.network.request.SendCashierOneKlikOtpRequest;
import id.dana.data.otp.repository.source.network.result.SendCashierOneKlikOtpResult;
import id.dana.data.otp.repository.source.network.result.SendOtpResult;
import id.dana.data.registration.RegistrationProcessManager;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.model.SendBankOtpRequest;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.domain.otp.model.SendStrategy;
import id.dana.domain.otp.model.VerifyOtpResponse;
import id.dana.network.response.login.VerifyOtpResult;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Objects;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class OtpEntityRepository implements OtpRepository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final VerifyChallengeManager challengeManager;
    private final OtpBankMapper otpBankMapper;
    private final OtpEntityDataFactory otpEntityDataFactory;
    private final OtpMapper otpMapper;
    private final OtpRetryManager otpRetryManager;
    private final RegistrationProcessManager processManager;
    private final SecurityEntityDataFactory securityEntityDataFactory;

    @Inject
    public OtpEntityRepository(OtpEntityDataFactory otpEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, RegistrationProcessManager registrationProcessManager, VerifyChallengeManager verifyChallengeManager, OtpRetryManager otpRetryManager, OtpMapper otpMapper, OtpBankMapper otpBankMapper, SecurityEntityDataFactory securityEntityDataFactory) {
        this.otpEntityDataFactory = otpEntityDataFactory;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.processManager = registrationProcessManager;
        this.challengeManager = verifyChallengeManager;
        this.otpRetryManager = otpRetryManager;
        this.otpMapper = otpMapper;
        this.otpBankMapper = otpBankMapper;
        this.securityEntityDataFactory = securityEntityDataFactory;
    }

    private OtpEntityData createNetworkOtpData() {
        return this.otpEntityDataFactory.createData2("network");
    }

    private OtpEntityData createOtpReceiverData() {
        return this.otpEntityDataFactory.createData2("local");
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<VerifyOtpResponse> verifyOtp(String str) {
        Observable<VerifyOtpResult> verifyOtp = createNetworkOtpData().verifyOtp(this.processManager.getPhoneNumber(), str);
        final OtpMapper otpMapper = this.otpMapper;
        Objects.requireNonNull(otpMapper);
        return verifyOtp.map(new Function() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return OtpMapper.this.transform((VerifyOtpResult) obj);
            }
        });
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<SendOtpResponse> sendOtp(String str, String str2, String str3, Boolean bool, String str4, final String str5, String str6) {
        if (isLoginRetryScenario(str) || isBindingRetryScenario(str)) {
            Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return OtpEntityRepository.this.m1555lambda$sendOtp$0$iddanadataotpOtpEntityRepository();
                }
            });
            OtpMapper otpMapper = this.otpMapper;
            Objects.requireNonNull(otpMapper);
            return fromCallable.map(new OtpEntityRepository$$ExternalSyntheticLambda2(otpMapper));
        }
        final String sendStrategy = getSendStrategy(str);
        Observable<SendOtpResult> doOnNext = createNetworkOtpData().sendOtp(sendPhoneNumber(sendStrategy, str5), sendStrategy, str2, str3, bool, str6, str4).doOnNext(new Consumer() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OtpEntityRepository.this.m1556lambda$sendOtp$1$iddanadataotpOtpEntityRepository(sendStrategy, str5, (SendOtpResult) obj);
            }
        });
        OtpMapper otpMapper2 = this.otpMapper;
        Objects.requireNonNull(otpMapper2);
        return doOnNext.map(new OtpEntityRepository$$ExternalSyntheticLambda2(otpMapper2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendOtp$0$id-dana-data-otp-OtpEntityRepository  reason: not valid java name */
    public /* synthetic */ SendOtpResult m1555lambda$sendOtp$0$iddanadataotpOtpEntityRepository() throws Exception {
        SendOtpResult sendOtpResult = this.otpRetryManager.getSendOtpResult();
        if (sendOtpResult != null) {
            return sendOtpResult;
        }
        throw new CallableReturnNullError("OtpEntityRepository#sendOtp");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendOtp$1$id-dana-data-otp-OtpEntityRepository  reason: not valid java name */
    public /* synthetic */ void m1556lambda$sendOtp$1$iddanadataotpOtpEntityRepository(String str, String str2, SendOtpResult sendOtpResult) throws Exception {
        if (str.equals("AP_PAYMENT")) {
            return;
        }
        this.otpRetryManager.setPhoneNumber(sendPhoneNumber(str, str2));
        this.otpRetryManager.setSendOtpResult(sendOtpResult);
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<SendOtpResponse> sendOtpWithoutCache(String str, String str2, String str3, Boolean bool, String str4, String str5, String str6) {
        String sendStrategy = getSendStrategy(str);
        Observable<SendOtpResult> sendOtp = createNetworkOtpData().sendOtp(sendPhoneNumber(sendStrategy, str5), sendStrategy, str2, str3, bool, str6, str4);
        OtpMapper otpMapper = this.otpMapper;
        Objects.requireNonNull(otpMapper);
        return sendOtp.map(new OtpEntityRepository$$ExternalSyntheticLambda2(otpMapper));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$sendBankOtp$2$id-dana-data-otp-OtpEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1554lambda$sendBankOtp$2$iddanadataotpOtpEntityRepository(SendBankOtpRequest sendBankOtpRequest, String str) throws Exception {
        Observable<SendOtpResult> sendBankOtp = sendBankOtp(sendBankOtpRequest, str);
        OtpMapper otpMapper = this.otpMapper;
        Objects.requireNonNull(otpMapper);
        return sendBankOtp.map(new OtpEntityRepository$$ExternalSyntheticLambda2(otpMapper));
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<SendOtpResponse> sendBankOtp(final SendBankOtpRequest sendBankOtpRequest) {
        return getCardCredentialKey().flatMap(new Function() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return OtpEntityRepository.this.m1554lambda$sendBankOtp$2$iddanadataotpOtpEntityRepository(sendBankOtpRequest, (String) obj);
            }
        });
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<String> receiveOtp() {
        return createOtpReceiverData().receiveOtp();
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<Bundle> receiveSms() {
        return createOtpReceiverData().receiveSms();
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<Boolean> verifyOtpOneKlik(String str, String str2, String str3) {
        return createNetworkOtpData().verifyCashierOneklikOtp(new SendCashierOneKlikOtpRequest(str, str2, str3)).map(new Function() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(((SendCashierOneKlikOtpResult) obj).success);
                return valueOf;
            }
        });
    }

    @Override // id.dana.domain.otp.OtpRepository
    public Observable<Boolean> clearOtpRetryManager() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return OtpEntityRepository.this.m1551xe9839db2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$clearOtpRetryManager$4$id-dana-data-otp-OtpEntityRepository  reason: not valid java name */
    public /* synthetic */ Boolean m1551xe9839db2() throws Exception {
        this.otpRetryManager.clear();
        return Boolean.TRUE;
    }

    private Observable<String> getCardCredentialKey() {
        return createAccountData().getCardCredentialPublicKey().onErrorReturnItem("").flatMap(new Function() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return OtpEntityRepository.this.m1553x2e48b611((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCardCredentialKey$6$id-dana-data-otp-OtpEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1553x2e48b611(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return createSecurityData().cardCredentialKey().flatMap(new Function() { // from class: id.dana.data.otp.OtpEntityRepository$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return OtpEntityRepository.this.m1552xccf61972((String) obj);
                }
            });
        }
        return Observable.just(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCardCredentialKey$5$id-dana-data-otp-OtpEntityRepository  reason: not valid java name */
    public /* synthetic */ ObservableSource m1552xccf61972(String str) throws Exception {
        return createAccountData().setCardCredentialPublicKey(str);
    }

    private boolean isLoginRetryScenario(String str) {
        return !TextUtils.isEmpty(this.challengeManager.getPhoneNumber()) && this.challengeManager.getPhoneNumber().equals(this.otpRetryManager.getPhoneNumber()) && this.otpRetryManager.isNotOverRetry() && !str.equals("AP_PAYMENT");
    }

    private boolean isBindingRetryScenario(String str) {
        return this.otpRetryManager.isNotOverRetry() && str.equals(SendStrategy.AUTH_AGREEMENT);
    }

    private String sendPhoneNumber(String str, String str2) {
        if ("AP_LOGIN".equals(str)) {
            return this.challengeManager.getPhoneNumber();
        }
        return (str.equals("MODIFY_PASSWORD") || str.equals("AP_RESET_SIMPLE_PWD")) ? str2 : getAccountPhoneNumber();
    }

    private String getSendStrategy(String str) {
        return SendStrategy.AUTH_AGREEMENT.equals(str) ? "AP_LOGIN" : str;
    }

    private Observable<SendOtpResult> sendBankOtp(SendBankOtpRequest sendBankOtpRequest, String str) {
        SendBankOtpEntityRequest transform = this.otpBankMapper.transform(sendBankOtpRequest, str);
        if (sendBankOtpRequest.isForVerifyBankPhone()) {
            return createNetworkOtpData().verifyBankPhoneOtp(transform);
        }
        return createNetworkOtpData().sendBankOtp(transform);
    }

    private String getAccountPhoneNumber() {
        return (String) createAccountEntityData().getAccount().map(new NearbyMeEntityRepository$$ExternalSyntheticLambda1()).blockingFirst();
    }

    String getOtpPhoneNumber(SendBankOtpRequest sendBankOtpRequest) {
        if (sendBankOtpRequest.getEktp() == null || sendBankOtpRequest.getCardNo() == null) {
            return getAccountPhoneNumber();
        }
        return sendBankOtpRequest.getBankPhoneNo();
    }

    private AccountEntityData createAccountEntityData() {
        return this.accountEntityDataFactory.createData2("local");
    }

    protected AccountEntityData createAccountData() {
        return this.accountEntityDataFactory.createData2("local");
    }

    private SecurityEntityData createSecurityData() {
        return this.securityEntityDataFactory.createData2("network");
    }
}
