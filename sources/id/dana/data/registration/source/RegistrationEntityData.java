package id.dana.data.registration.source;

import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.config.model.OtpWhatsAppConfig;
import id.dana.data.registration.source.network.result.CheckUserRegistrationStatusResult;
import id.dana.data.registration.source.network.result.RegisterRpcResult;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JY\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J^\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0015H\u0016J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000bH\u0016J\u0018\u0010*\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0016J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0015H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Lid/dana/data/registration/source/RegistrationEntityData;", "", "checkRegistrationAndSendOtp", "Lio/reactivex/Observable;", "Lid/dana/data/registration/source/network/result/CheckUserRegistrationStatusResult;", "phoneNumber", "", "otpChannel", "clientId", "merchantId", "skipSendOtp", "", "isWhatsAppInstalled", "isNetworkEligible", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "clearAll", "", "clearIsFreezeVerifyOtp", "clearLastOtpChannel", "clearResendOtpTimelimit", "getChatBotTimestamp", "", "chatBotEntry", "getIsFreezeVerifyOtp", "getLastOtpChannel", "getNumberOfRequestOtp", "", "getResendOtpTimelimit", DanaLogConstants.BizType.REGISTER, "Lid/dana/data/registration/source/network/result/RegisterRpcResult;", "pin", "key", "nickname", AccountEntityRepository.UpdateType.AVATAR, "referralCode", "verifyMethod", "cityName", "removeNumberOfRequestOtp", "saveChatBotTimestamp", "chatbotTimestamp", "saveIsFreezeVerifyOtp", "isFreezeVerifyOtp", "saveLastOtpChannel", "saveNumberOfRequestOtp", "numberOfRequest", "otpWhatsAppConfig", "Lid/dana/data/config/model/OtpWhatsAppConfig;", "saveResendOtpTimelimit", "resendOtpTimeLimit", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RegistrationEntityData {
    Observable<CheckUserRegistrationStatusResult> checkRegistrationAndSendOtp(String phoneNumber, String otpChannel, String clientId, String merchantId, Boolean skipSendOtp, Boolean isWhatsAppInstalled, Boolean isNetworkEligible);

    void clearAll();

    void clearIsFreezeVerifyOtp(String phoneNumber);

    void clearLastOtpChannel(String phoneNumber);

    void clearResendOtpTimelimit(String phoneNumber);

    Observable<Long> getChatBotTimestamp(String chatBotEntry);

    Observable<Boolean> getIsFreezeVerifyOtp(String phoneNumber);

    Observable<String> getLastOtpChannel(String phoneNumber);

    Observable<Integer> getNumberOfRequestOtp(String phoneNumber);

    Observable<Long> getResendOtpTimelimit(String phoneNumber);

    Observable<RegisterRpcResult> register(String phoneNumber, String pin, String key, String nickname, String avatarUrl, String referralCode, String verifyMethod, String cityName);

    Observable<Unit> removeNumberOfRequestOtp(String phoneNumber);

    Observable<Unit> saveChatBotTimestamp(String chatBotEntry, long chatbotTimestamp);

    Observable<Unit> saveIsFreezeVerifyOtp(String phoneNumber, boolean isFreezeVerifyOtp);

    void saveLastOtpChannel(String phoneNumber, String otpChannel);

    Observable<Unit> saveNumberOfRequestOtp(String phoneNumber, int numberOfRequest, OtpWhatsAppConfig otpWhatsAppConfig);

    Observable<Unit> saveResendOtpTimelimit(String phoneNumber, long resendOtpTimeLimit);

    /* renamed from: id.dana.data.registration.source.RegistrationEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$checkRegistrationAndSendOtp(RegistrationEntityData registrationEntityData, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Boolean bool3) {
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$register(RegistrationEntityData registrationEntityData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$saveNumberOfRequestOtp(RegistrationEntityData registrationEntityData, String str, int i, OtpWhatsAppConfig otpWhatsAppConfig) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(otpWhatsAppConfig, "");
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$getNumberOfRequestOtp(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$removeNumberOfRequestOtp(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void $default$saveLastOtpChannel(RegistrationEntityData registrationEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$getLastOtpChannel(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void $default$clearLastOtpChannel(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$getIsFreezeVerifyOtp(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$saveIsFreezeVerifyOtp(RegistrationEntityData registrationEntityData, String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void $default$clearIsFreezeVerifyOtp(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$getResendOtpTimelimit(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$saveResendOtpTimelimit(RegistrationEntityData registrationEntityData, String str, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void $default$clearResendOtpTimelimit(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$getChatBotTimestamp(RegistrationEntityData registrationEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r2 = 0;
            throw new NotImplementedError(r2, 1, r2);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static Observable $default$saveChatBotTimestamp(RegistrationEntityData registrationEntityData, String str, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            ?? r1 = 0;
            throw new NotImplementedError(r1, 1, r1);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static void $default$clearAll(RegistrationEntityData registrationEntityData) {
            ?? r0 = 0;
            throw new NotImplementedError(r0, 1, r0);
        }
    }
}
