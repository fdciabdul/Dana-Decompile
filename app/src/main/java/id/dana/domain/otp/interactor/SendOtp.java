package id.dana.domain.otp.interactor;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/otp/interactor/SendOtp;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/otp/model/SendOtpResponse;", "Lid/dana/domain/otp/interactor/SendOtp$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/otp/interactor/SendOtp$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/otp/OtpRepository;", "otpRepository", "Lid/dana/domain/otp/OtpRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/otp/OtpRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SendOtp extends UseCase<SendOtpResponse, Params> {
    private final OtpRepository otpRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public SendOtp(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OtpRepository otpRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(otpRepository, "");
        this.otpRepository = otpRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<SendOtpResponse> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        OtpRepository otpRepository = this.otpRepository;
        String sendStrategy = params.getSendStrategy();
        String serviceCode = params.getServiceCode();
        String merchantId = params.getMerchantId();
        boolean isSendMoney = params.getIsSendMoney();
        Observable<SendOtpResponse> sendOtp = otpRepository.sendOtp(sendStrategy, serviceCode, merchantId, Boolean.valueOf(isSendMoney), params.getSecurityId(), params.getPhoneNumber(), params.getOtpChannel());
        Intrinsics.checkNotNullExpressionValue(sendOtp, "");
        return sendOtp;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017BA\b\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0007\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0013\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n"}, d2 = {"Lid/dana/domain/otp/interactor/SendOtp$Params;", "", "", "isSendMoney", "Z", "()Z", "", "merchantId", "Ljava/lang/String;", "getMerchantId", "()Ljava/lang/String;", "otpChannel", "getOtpChannel", "phoneNumber", "getPhoneNumber", BioUtilityBridge.SECURITY_ID, "getSecurityId", "sendStrategy", "getSendStrategy", "serviceCode", "getServiceCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isSendMoney;
        private final String merchantId;
        private final String otpChannel;
        private final String phoneNumber;
        private final String securityId;
        private final String sendStrategy;
        private final String serviceCode;

        public /* synthetic */ Params(String str, String str2, String str3, boolean z, String str4, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, str4, str5, str6);
        }

        @JvmStatic
        public static final Params forSendOtp(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
            return INSTANCE.forSendOtp(str, str2, str3, z, str4, str5, str6);
        }

        private Params(String str, String str2, String str3, boolean z, String str4, String str5, String str6) {
            this.sendStrategy = str;
            this.serviceCode = str2;
            this.merchantId = str3;
            this.isSendMoney = z;
            this.securityId = str4;
            this.phoneNumber = str5;
            this.otpChannel = str6;
        }

        @JvmName(name = "getSendStrategy")
        public final String getSendStrategy() {
            return this.sendStrategy;
        }

        @JvmName(name = "getServiceCode")
        public final String getServiceCode() {
            return this.serviceCode;
        }

        @JvmName(name = "getMerchantId")
        public final String getMerchantId() {
            return this.merchantId;
        }

        @JvmName(name = "isSendMoney")
        /* renamed from: isSendMoney  reason: from getter */
        public final boolean getIsSendMoney() {
            return this.isSendMoney;
        }

        @JvmName(name = "getSecurityId")
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @JvmName(name = "getOtpChannel")
        public final String getOtpChannel() {
            return this.otpChannel;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ]\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/otp/interactor/SendOtp$Params$Companion;", "", "", "sendStrategy", "serviceCode", "merchantId", "", "isSendMoney", BioUtilityBridge.SECURITY_ID, "phoneNumber", "otpChannel", "Lid/dana/domain/otp/interactor/SendOtp$Params;", "forSendOtp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/otp/interactor/SendOtp$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Params forSendOtp$default(Companion companion, String str, String str2, String str3, boolean z, String str4, String str5, String str6, int i, Object obj) {
                return companion.forSendOtp(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
            }

            @JvmStatic
            public final Params forSendOtp(String sendStrategy, String serviceCode, String merchantId, boolean isSendMoney, String securityId, String phoneNumber, String otpChannel) {
                return new Params(sendStrategy == null ? "" : sendStrategy, serviceCode == null ? "" : serviceCode, merchantId == null ? "" : merchantId, isSendMoney, securityId == null ? "" : securityId, phoneNumber == null ? "" : phoneNumber, otpChannel == null ? "" : otpChannel, null);
            }
        }
    }
}
