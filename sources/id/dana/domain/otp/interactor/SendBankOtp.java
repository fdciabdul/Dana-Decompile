package id.dana.domain.otp.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.otp.model.SendBankOtpRequest;
import id.dana.domain.otp.model.SendOtpResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/otp/interactor/SendBankOtp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/otp/model/SendOtpResponse;", "Lid/dana/domain/otp/interactor/SendBankOtp$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/otp/interactor/SendBankOtp$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/otp/OtpRepository;", "otpRepository", "Lid/dana/domain/otp/OtpRepository;", "<init>", "(Lid/dana/domain/otp/OtpRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SendBankOtp extends BaseUseCase<SendOtpResponse, Params> {
    private final OtpRepository otpRepository;

    @Inject
    public SendBankOtp(OtpRepository otpRepository) {
        Intrinsics.checkNotNullParameter(otpRepository, "");
        this.otpRepository = otpRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SendOtpResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<SendOtpResponse> sendBankOtp = this.otpRepository.sendBankOtp(params.getSendBankOtpRequest());
        Intrinsics.checkNotNullExpressionValue(sendBankOtp, "");
        return sendBankOtp;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/otp/interactor/SendBankOtp$Params;", "", "Lid/dana/domain/otp/model/SendBankOtpRequest;", "sendBankOtpRequest", "Lid/dana/domain/otp/model/SendBankOtpRequest;", "getSendBankOtpRequest", "()Lid/dana/domain/otp/model/SendBankOtpRequest;", "<init>", "(Lid/dana/domain/otp/model/SendBankOtpRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final SendBankOtpRequest sendBankOtpRequest;

        public Params(SendBankOtpRequest sendBankOtpRequest) {
            Intrinsics.checkNotNullParameter(sendBankOtpRequest, "");
            this.sendBankOtpRequest = sendBankOtpRequest;
        }

        @JvmName(name = "getSendBankOtpRequest")
        public final SendBankOtpRequest getSendBankOtpRequest() {
            return this.sendBankOtpRequest;
        }
    }
}
