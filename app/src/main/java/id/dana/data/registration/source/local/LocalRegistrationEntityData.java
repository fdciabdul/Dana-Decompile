package id.dana.data.registration.source.local;

import id.dana.data.config.model.OtpWhatsAppConfig;
import id.dana.data.registration.di.Registration;
import id.dana.data.registration.model.NumberOfRequestOtp;
import id.dana.data.registration.source.RegistrationEntityData;
import id.dana.data.storage.PreferenceFacade;
import id.dana.utils.extension.StringExtKt;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0013\b\u0007\u0012\b\b\u0001\u0010(\u001a\u00020'¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\rH\u0016¢\u0006\u0004\b&\u0010\u0019R\u0014\u0010(\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/data/registration/source/local/LocalRegistrationEntityData;", "Lid/dana/data/registration/source/RegistrationEntityData;", "", "clearAll", "()V", "", "phoneNumber", "clearIsFreezeVerifyOtp", "(Ljava/lang/String;)V", "clearLastOtpChannel", "clearResendOtpTimelimit", "chatBotEntry", "Lio/reactivex/Observable;", "", "getChatBotTimestamp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "getIsFreezeVerifyOtp", "getLastOtpChannel", "", "getNumberOfRequestOtp", "getResendOtpTimelimit", "removeNumberOfRequestOtp", "chatbotTimestamp", "saveChatBotTimestamp", "(Ljava/lang/String;J)Lio/reactivex/Observable;", LocalRegistrationEntityData.IS_FREEZE_VERIFY_OTP, "saveIsFreezeVerifyOtp", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "otpChannel", "saveLastOtpChannel", "(Ljava/lang/String;Ljava/lang/String;)V", "numberOfRequest", "Lid/dana/data/config/model/OtpWhatsAppConfig;", "otpWhatsAppConfig", "saveNumberOfRequestOtp", "(Ljava/lang/String;ILid/dana/data/config/model/OtpWhatsAppConfig;)Lio/reactivex/Observable;", "resendOtpTimeLimit", "saveResendOtpTimelimit", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalRegistrationEntityData implements RegistrationEntityData {
    private static final String CHATBOT_TIMESTAMP = "ChatBotTimestamp";
    private static final String IS_FREEZE_VERIFY_OTP = "isFreezeVerifyOtp";
    private static final String LAST_OTP_CHANNEL = "lastOtpChannel";
    private static final String RESEND_OTP_TIME_LIMIT = "ResendOtpTimeLimit";
    private final PreferenceFacade preferenceFacade;

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable checkRegistrationAndSendOtp(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Boolean bool3) {
        return RegistrationEntityData.CC.$default$checkRegistrationAndSendOtp(this, str, str2, str3, str4, bool, bool2, bool3);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final /* synthetic */ Observable register(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return RegistrationEntityData.CC.$default$register(this, str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Inject
    public LocalRegistrationEntityData(@Registration PreferenceFacade preferenceFacade) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        this.preferenceFacade = preferenceFacade;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Unit> saveNumberOfRequestOtp(final String phoneNumber, final int numberOfRequest, final OtpWhatsAppConfig otpWhatsAppConfig) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(otpWhatsAppConfig, "");
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.registration.source.local.LocalRegistrationEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m1827saveNumberOfRequestOtp$lambda0;
                m1827saveNumberOfRequestOtp$lambda0 = LocalRegistrationEntityData.m1827saveNumberOfRequestOtp$lambda0(LocalRegistrationEntityData.this, phoneNumber, numberOfRequest, otpWhatsAppConfig);
                return m1827saveNumberOfRequestOtp$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveNumberOfRequestOtp$lambda-0  reason: not valid java name */
    public static final Unit m1827saveNumberOfRequestOtp$lambda0(LocalRegistrationEntityData localRegistrationEntityData, String str, int i, OtpWhatsAppConfig otpWhatsAppConfig) {
        NumberOfRequestOtp numberOfRequestOtp;
        Intrinsics.checkNotNullParameter(localRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(otpWhatsAppConfig, "");
        NumberOfRequestOtp numberOfRequestOtp2 = (NumberOfRequestOtp) localRegistrationEntityData.preferenceFacade.getObject(StringExtKt.PlaceComponentResult(str), NumberOfRequestOtp.class);
        if (numberOfRequestOtp2 == null || (numberOfRequestOtp = NumberOfRequestOtp.copy$default(numberOfRequestOtp2, i, 0L, otpWhatsAppConfig.getFreezeThresholdInMillis(), 2, null)) == null) {
            numberOfRequestOtp = new NumberOfRequestOtp(i, System.currentTimeMillis(), otpWhatsAppConfig.getFreezeThresholdInMillis());
        }
        localRegistrationEntityData.preferenceFacade.saveData(StringExtKt.PlaceComponentResult(str), (String) numberOfRequestOtp);
        return Unit.INSTANCE;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Integer> getNumberOfRequestOtp(final String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Integer> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.registration.source.local.LocalRegistrationEntityData$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer m1824getNumberOfRequestOtp$lambda1;
                m1824getNumberOfRequestOtp$lambda1 = LocalRegistrationEntityData.m1824getNumberOfRequestOtp$lambda1(phoneNumber, this);
                return m1824getNumberOfRequestOtp$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getNumberOfRequestOtp$lambda-1  reason: not valid java name */
    public static final Integer m1824getNumberOfRequestOtp$lambda1(String str, LocalRegistrationEntityData localRegistrationEntityData) {
        int i;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(localRegistrationEntityData, "");
        String PlaceComponentResult = StringExtKt.PlaceComponentResult(str);
        NumberOfRequestOtp numberOfRequestOtp = (NumberOfRequestOtp) localRegistrationEntityData.preferenceFacade.getObject(PlaceComponentResult, NumberOfRequestOtp.class);
        if (numberOfRequestOtp != null) {
            if (numberOfRequestOtp.isExpired()) {
                localRegistrationEntityData.preferenceFacade.clearData(PlaceComponentResult);
            } else {
                i = numberOfRequestOtp.getNumberOfRequest();
                return Integer.valueOf(i);
            }
        }
        i = -1;
        return Integer.valueOf(i);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Unit> removeNumberOfRequestOtp(final String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.registration.source.local.LocalRegistrationEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m1826removeNumberOfRequestOtp$lambda2;
                m1826removeNumberOfRequestOtp$lambda2 = LocalRegistrationEntityData.m1826removeNumberOfRequestOtp$lambda2(LocalRegistrationEntityData.this, phoneNumber);
                return m1826removeNumberOfRequestOtp$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeNumberOfRequestOtp$lambda-2  reason: not valid java name */
    public static final Unit m1826removeNumberOfRequestOtp$lambda2(LocalRegistrationEntityData localRegistrationEntityData, String str) {
        Intrinsics.checkNotNullParameter(localRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        localRegistrationEntityData.preferenceFacade.clearData(StringExtKt.PlaceComponentResult(str));
        return Unit.INSTANCE;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final void saveLastOtpChannel(String phoneNumber, String otpChannel) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(otpChannel, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(phoneNumber));
        sb.append("_lastOtpChannel");
        preferenceFacade.saveData(sb.toString(), otpChannel);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<String> getLastOtpChannel(final String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<String> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.registration.source.local.LocalRegistrationEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String m1823getLastOtpChannel$lambda3;
                m1823getLastOtpChannel$lambda3 = LocalRegistrationEntityData.m1823getLastOtpChannel$lambda3(LocalRegistrationEntityData.this, phoneNumber);
                return m1823getLastOtpChannel$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLastOtpChannel$lambda-3  reason: not valid java name */
    public static final String m1823getLastOtpChannel$lambda3(LocalRegistrationEntityData localRegistrationEntityData, String str) {
        Intrinsics.checkNotNullParameter(localRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade = localRegistrationEntityData.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(str));
        sb.append("_lastOtpChannel");
        String string = preferenceFacade.getString(sb.toString());
        return string == null ? "" : string;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final void clearLastOtpChannel(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(phoneNumber));
        sb.append("_lastOtpChannel");
        preferenceFacade.clearData(sb.toString());
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Boolean> getIsFreezeVerifyOtp(final String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.registration.source.local.LocalRegistrationEntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean m1822getIsFreezeVerifyOtp$lambda4;
                m1822getIsFreezeVerifyOtp$lambda4 = LocalRegistrationEntityData.m1822getIsFreezeVerifyOtp$lambda4(LocalRegistrationEntityData.this, phoneNumber);
                return m1822getIsFreezeVerifyOtp$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getIsFreezeVerifyOtp$lambda-4  reason: not valid java name */
    public static final Boolean m1822getIsFreezeVerifyOtp$lambda4(LocalRegistrationEntityData localRegistrationEntityData, String str) {
        Intrinsics.checkNotNullParameter(localRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade = localRegistrationEntityData.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(str));
        sb.append("_isFreezeVerifyOtp");
        return preferenceFacade.getBoolean(sb.toString(), false);
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Unit> saveIsFreezeVerifyOtp(String phoneNumber, boolean isFreezeVerifyOtp) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(phoneNumber));
        sb.append("_isFreezeVerifyOtp");
        preferenceFacade.saveData(sb.toString(), Boolean.valueOf(isFreezeVerifyOtp));
        Observable<Unit> just = Observable.just(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final void clearIsFreezeVerifyOtp(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(phoneNumber));
        sb.append("_isFreezeVerifyOtp");
        preferenceFacade.clearData(sb.toString());
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Long> getResendOtpTimelimit(final String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Long> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.registration.source.local.LocalRegistrationEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Long m1825getResendOtpTimelimit$lambda5;
                m1825getResendOtpTimelimit$lambda5 = LocalRegistrationEntityData.m1825getResendOtpTimelimit$lambda5(LocalRegistrationEntityData.this, phoneNumber);
                return m1825getResendOtpTimelimit$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getResendOtpTimelimit$lambda-5  reason: not valid java name */
    public static final Long m1825getResendOtpTimelimit$lambda5(LocalRegistrationEntityData localRegistrationEntityData, String str) {
        Intrinsics.checkNotNullParameter(localRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade = localRegistrationEntityData.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(str));
        sb.append("_ResendOtpTimeLimit");
        return preferenceFacade.getLong(sb.toString());
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Unit> saveResendOtpTimelimit(String phoneNumber, long resendOtpTimeLimit) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(phoneNumber));
        sb.append("_ResendOtpTimeLimit");
        preferenceFacade.saveData(sb.toString(), Long.valueOf(resendOtpTimeLimit));
        Observable<Unit> just = Observable.just(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final void clearResendOtpTimelimit(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(StringExtKt.PlaceComponentResult(phoneNumber));
        sb.append("_ResendOtpTimeLimit");
        preferenceFacade.clearData(sb.toString());
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Long> getChatBotTimestamp(final String chatBotEntry) {
        Intrinsics.checkNotNullParameter(chatBotEntry, "");
        Observable<Long> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.registration.source.local.LocalRegistrationEntityData$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Long m1821getChatBotTimestamp$lambda6;
                m1821getChatBotTimestamp$lambda6 = LocalRegistrationEntityData.m1821getChatBotTimestamp$lambda6(LocalRegistrationEntityData.this, chatBotEntry);
                return m1821getChatBotTimestamp$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getChatBotTimestamp$lambda-6  reason: not valid java name */
    public static final Long m1821getChatBotTimestamp$lambda6(LocalRegistrationEntityData localRegistrationEntityData, String str) {
        Intrinsics.checkNotNullParameter(localRegistrationEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        PreferenceFacade preferenceFacade = localRegistrationEntityData.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_ChatBotTimestamp");
        return preferenceFacade.getLong(sb.toString());
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final Observable<Unit> saveChatBotTimestamp(String chatBotEntry, long chatbotTimestamp) {
        Intrinsics.checkNotNullParameter(chatBotEntry, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(chatBotEntry);
        sb.append("_ChatBotTimestamp");
        preferenceFacade.saveData(sb.toString(), Long.valueOf(chatbotTimestamp));
        Observable<Unit> just = Observable.just(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.registration.source.RegistrationEntityData
    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }
}
