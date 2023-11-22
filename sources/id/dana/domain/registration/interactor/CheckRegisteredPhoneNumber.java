package id.dana.domain.registration.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.registration.RegistrationRepository;
import id.dana.domain.registration.model.CheckRegistrationRequest;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/registration/interactor/CheckRegisteredPhoneNumber;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "Lid/dana/domain/registration/model/CheckRegistrationRequest;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/registration/model/CheckRegistrationRequest;)Lio/reactivex/Observable;", "Lid/dana/domain/registration/RegistrationRepository;", "registrationRepository", "Lid/dana/domain/registration/RegistrationRepository;", "<init>", "(Lid/dana/domain/registration/RegistrationRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckRegisteredPhoneNumber extends BaseUseCase<CheckRegistrationResponse, CheckRegistrationRequest> {
    private final RegistrationRepository registrationRepository;

    @Inject
    public CheckRegisteredPhoneNumber(RegistrationRepository registrationRepository) {
        Intrinsics.checkNotNullParameter(registrationRepository, "");
        this.registrationRepository = registrationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CheckRegistrationResponse> buildUseCase(CheckRegistrationRequest params) {
        Intrinsics.checkNotNullParameter(params, "");
        RegistrationRepository registrationRepository = this.registrationRepository;
        String phoneNumber = params.getPhoneNumber();
        String otpChannel = params.getOtpChannel();
        String clientId = params.getClientId();
        String merchantId = params.getMerchantId();
        boolean isWhatsAppInstalled = params.isWhatsAppInstalled();
        Observable<CheckRegistrationResponse> checkRegistration = registrationRepository.checkRegistration(phoneNumber, otpChannel, clientId, merchantId, Boolean.valueOf(isWhatsAppInstalled), params.isNetworkEligible());
        Intrinsics.checkNotNullExpressionValue(checkRegistration, "");
        return checkRegistration;
    }
}
