package id.dana.domain.otp.interactor;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.otp.OtpRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/otp/interactor/VerifyOtpOneKlik;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/otp/interactor/VerifyOtpOneKlik$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/otp/interactor/VerifyOtpOneKlik$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/otp/OtpRepository;", "otpRepository", "Lid/dana/domain/otp/OtpRepository;", "<init>", "(Lid/dana/domain/otp/OtpRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyOtpOneKlik extends BaseUseCase<Boolean, Params> {
    private final OtpRepository otpRepository;

    @Inject
    public VerifyOtpOneKlik(OtpRepository otpRepository) {
        Intrinsics.checkNotNullParameter(otpRepository, "");
        this.otpRepository = otpRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> verifyOtpOneKlik = this.otpRepository.verifyOtpOneKlik(params.getCashierOrderId(), params.getValidateData(), params.getDeviceId());
        Intrinsics.checkNotNullExpressionValue(verifyOtpOneKlik, "");
        return verifyOtpOneKlik;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/otp/interactor/VerifyOtpOneKlik$Params;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "Ljava/lang/String;", "getCashierOrderId", "()Ljava/lang/String;", "deviceId", "getDeviceId", "validateData", "getValidateData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String cashierOrderId;
        private final String deviceId;
        private final String validateData;

        public Params(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.cashierOrderId = str;
            this.validateData = str2;
            this.deviceId = str3;
        }

        @JvmName(name = "getCashierOrderId")
        public final String getCashierOrderId() {
            return this.cashierOrderId;
        }

        @JvmName(name = "getValidateData")
        public final String getValidateData() {
            return this.validateData;
        }

        @JvmName(name = "getDeviceId")
        public final String getDeviceId() {
            return this.deviceId;
        }
    }
}
