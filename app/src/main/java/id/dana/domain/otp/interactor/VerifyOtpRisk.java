package id.dana.domain.otp.interactor;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/otp/interactor/VerifyOtpRisk;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/otp/model/VerifyOtpRiskResponse;", "Lid/dana/domain/otp/interactor/VerifyOtpRisk$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/otp/interactor/VerifyOtpRisk$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "carrierIdentificationRepository", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "<init>", "(Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyOtpRisk extends BaseUseCase<VerifyOtpRiskResponse, Params> {
    private static final String RISK_TOKEN = "riskToken";
    private final CarrierIdentificationRepository carrierIdentificationRepository;

    @Inject
    public VerifyOtpRisk(CarrierIdentificationRepository carrierIdentificationRepository) {
        Intrinsics.checkNotNullParameter(carrierIdentificationRepository, "");
        this.carrierIdentificationRepository = carrierIdentificationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<VerifyOtpRiskResponse> buildUseCase(Params params) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(params, "");
        if (Intrinsics.areEqual(params.getSendOtpStrategy(), "MODIFY_PASSWORD")) {
            CarrierIdentificationRepository carrierIdentificationRepository = this.carrierIdentificationRepository;
            String otpValue = params.getOtpValue();
            String securityId = params.getSecurityId();
            String phoneNumber = params.getPhoneNumber();
            String verificationMethod = params.getVerificationMethod();
            String sendOtpStrategy = params.getSendOtpStrategy();
            String riskToken = params.getRiskToken();
            if (riskToken == null || riskToken.length() == 0) {
                mapOf = MapsKt.emptyMap();
            } else {
                mapOf = MapsKt.mapOf(TuplesKt.to(RISK_TOKEN, params.getRiskToken()));
            }
            return carrierIdentificationRepository.verifyOtpToRisk(otpValue, securityId, phoneNumber, verificationMethod, sendOtpStrategy, mapOf);
        }
        return CarrierIdentificationRepository.CC.verifyOtpToRisk$default(this.carrierIdentificationRepository, params.getOtpValue(), params.getSecurityId(), params.getPhoneNumber(), params.getVerificationMethod(), params.getSendOtpStrategy(), null, 32, null);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JN\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/domain/otp/interactor/VerifyOtpRisk$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "otpValue", BioUtilityBridge.SECURITY_ID, "phoneNumber", CashierKeyParams.VERIFICATION_METHOD, "sendOtpStrategy", VerifyOtpRisk.RISK_TOKEN, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/otp/interactor/VerifyOtpRisk$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getOtpValue", "getPhoneNumber", "getRiskToken", "getSecurityId", "getSendOtpStrategy", "getVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String otpValue;
        private final String phoneNumber;
        private final String riskToken;
        private final String securityId;
        private final String sendOtpStrategy;
        private final String verificationMethod;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.otpValue;
            }
            if ((i & 2) != 0) {
                str2 = params.securityId;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = params.phoneNumber;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = params.verificationMethod;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = params.sendOtpStrategy;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = params.riskToken;
            }
            return params.copy(str, str7, str8, str9, str10, str6);
        }

        /* renamed from: component1  reason: from getter */
        public final String getOtpValue() {
            return this.otpValue;
        }

        /* renamed from: component2  reason: from getter */
        public final String getSecurityId() {
            return this.securityId;
        }

        /* renamed from: component3  reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component4  reason: from getter */
        public final String getVerificationMethod() {
            return this.verificationMethod;
        }

        /* renamed from: component5  reason: from getter */
        public final String getSendOtpStrategy() {
            return this.sendOtpStrategy;
        }

        /* renamed from: component6  reason: from getter */
        public final String getRiskToken() {
            return this.riskToken;
        }

        public final Params copy(String otpValue, String securityId, String phoneNumber, String verificationMethod, String sendOtpStrategy, String riskToken) {
            Intrinsics.checkNotNullParameter(otpValue, "");
            Intrinsics.checkNotNullParameter(securityId, "");
            Intrinsics.checkNotNullParameter(phoneNumber, "");
            Intrinsics.checkNotNullParameter(verificationMethod, "");
            Intrinsics.checkNotNullParameter(sendOtpStrategy, "");
            return new Params(otpValue, securityId, phoneNumber, verificationMethod, sendOtpStrategy, riskToken);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.otpValue, params.otpValue) && Intrinsics.areEqual(this.securityId, params.securityId) && Intrinsics.areEqual(this.phoneNumber, params.phoneNumber) && Intrinsics.areEqual(this.verificationMethod, params.verificationMethod) && Intrinsics.areEqual(this.sendOtpStrategy, params.sendOtpStrategy) && Intrinsics.areEqual(this.riskToken, params.riskToken);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.otpValue.hashCode();
            int hashCode2 = this.securityId.hashCode();
            int hashCode3 = this.phoneNumber.hashCode();
            int hashCode4 = this.verificationMethod.hashCode();
            int hashCode5 = this.sendOtpStrategy.hashCode();
            String str = this.riskToken;
            return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(otpValue=");
            sb.append(this.otpValue);
            sb.append(", securityId=");
            sb.append(this.securityId);
            sb.append(", phoneNumber=");
            sb.append(this.phoneNumber);
            sb.append(", verificationMethod=");
            sb.append(this.verificationMethod);
            sb.append(", sendOtpStrategy=");
            sb.append(this.sendOtpStrategy);
            sb.append(", riskToken=");
            sb.append(this.riskToken);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.otpValue = str;
            this.securityId = str2;
            this.phoneNumber = str3;
            this.verificationMethod = str4;
            this.sendOtpStrategy = str5;
            this.riskToken = str6;
        }

        public /* synthetic */ Params(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, (i & 32) != 0 ? null : str6);
        }

        @JvmName(name = "getOtpValue")
        public final String getOtpValue() {
            return this.otpValue;
        }

        @JvmName(name = "getSecurityId")
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @JvmName(name = "getVerificationMethod")
        public final String getVerificationMethod() {
            return this.verificationMethod;
        }

        @JvmName(name = "getSendOtpStrategy")
        public final String getSendOtpStrategy() {
            return this.sendOtpStrategy;
        }

        @JvmName(name = "getRiskToken")
        public final String getRiskToken() {
            return this.riskToken;
        }
    }
}
