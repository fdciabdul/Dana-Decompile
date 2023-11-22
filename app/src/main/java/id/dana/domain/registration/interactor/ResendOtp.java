package id.dana.domain.registration.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.registration.RegistrationRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/registration/interactor/ResendOtp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "Lid/dana/domain/registration/interactor/ResendOtp$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/registration/interactor/ResendOtp$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/registration/RegistrationRepository;", "registrationRepository", "Lid/dana/domain/registration/RegistrationRepository;", "<init>", "(Lid/dana/domain/registration/RegistrationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResendOtp extends BaseUseCase<CheckRegistrationResponse, Params> {
    private final RegistrationRepository registrationRepository;

    @Inject
    public ResendOtp(RegistrationRepository registrationRepository) {
        Intrinsics.checkNotNullParameter(registrationRepository, "");
        this.registrationRepository = registrationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CheckRegistrationResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (params.isRegister()) {
            Observable<CheckRegistrationResponse> resendOtpRegister = this.registrationRepository.resendOtpRegister(params.getOtpChannel());
            Intrinsics.checkNotNullExpressionValue(resendOtpRegister, "");
            return resendOtpRegister;
        }
        Observable<CheckRegistrationResponse> resendOtp = this.registrationRepository.resendOtp(params.getOtpChannel());
        Intrinsics.checkNotNullExpressionValue(resendOtp, "");
        return resendOtp;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/domain/registration/interactor/ResendOtp$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "otpChannel", "isRegister", "copy", "(Ljava/lang/String;Z)Lid/dana/domain/registration/interactor/ResendOtp$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "Ljava/lang/String;", "getOtpChannel", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final boolean isRegister;
        private final String otpChannel;

        public static /* synthetic */ Params copy$default(Params params, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.otpChannel;
            }
            if ((i & 2) != 0) {
                z = params.isRegister;
            }
            return params.copy(str, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getOtpChannel() {
            return this.otpChannel;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getIsRegister() {
            return this.isRegister;
        }

        public final Params copy(String otpChannel, boolean isRegister) {
            Intrinsics.checkNotNullParameter(otpChannel, "");
            return new Params(otpChannel, isRegister);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.otpChannel, params.otpChannel) && this.isRegister == params.isRegister;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.otpChannel.hashCode();
            boolean z = this.isRegister;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (hashCode * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(otpChannel=");
            sb.append(this.otpChannel);
            sb.append(", isRegister=");
            sb.append(this.isRegister);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            this.otpChannel = str;
            this.isRegister = z;
        }

        @JvmName(name = "getOtpChannel")
        public final String getOtpChannel() {
            return this.otpChannel;
        }

        @JvmName(name = "isRegister")
        public final boolean isRegister() {
            return this.isRegister;
        }
    }
}
