package id.dana.domain.twilio.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.model.TwilioConsult;
import id.dana.domain.twilio.model.TwilioInfo;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioConsultEnrollment;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/twilio/model/TwilioInfo;", "Lid/dana/domain/twilio/interactor/TwilioConsultEnrollment$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/twilio/interactor/TwilioConsultEnrollment$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/TwilioRepository;", "twilioRepository", "Lid/dana/domain/twilio/TwilioRepository;", "<init>", "(Lid/dana/domain/twilio/TwilioRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TwilioConsultEnrollment extends BaseUseCase<TwilioInfo, Params> {
    private final TwilioRepository twilioRepository;

    @Inject
    public TwilioConsultEnrollment(TwilioRepository twilioRepository) {
        Intrinsics.checkNotNullParameter(twilioRepository, "");
        this.twilioRepository = twilioRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<TwilioInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.twilioRepository.consultEnrollmentStatus(params.getTwilioConsult());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioConsultEnrollment$Params;", "", "Lid/dana/domain/twilio/model/TwilioConsult;", "twilioConsult", "Lid/dana/domain/twilio/model/TwilioConsult;", "getTwilioConsult", "()Lid/dana/domain/twilio/model/TwilioConsult;", "<init>", "(Lid/dana/domain/twilio/model/TwilioConsult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final TwilioConsult twilioConsult;

        public Params(TwilioConsult twilioConsult) {
            Intrinsics.checkNotNullParameter(twilioConsult, "");
            this.twilioConsult = twilioConsult;
        }

        @JvmName(name = "getTwilioConsult")
        public final TwilioConsult getTwilioConsult() {
            return this.twilioConsult;
        }
    }
}
