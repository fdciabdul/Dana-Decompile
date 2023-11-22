package id.dana.domain.twilio.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.model.EnrollInfo;
import id.dana.domain.twilio.model.TwilioEnroll;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioEnrollment;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/twilio/model/EnrollInfo;", "Lid/dana/domain/twilio/interactor/TwilioEnrollment$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/twilio/interactor/TwilioEnrollment$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/TwilioRepository;", "twilioRepository", "Lid/dana/domain/twilio/TwilioRepository;", "<init>", "(Lid/dana/domain/twilio/TwilioRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TwilioEnrollment extends BaseUseCase<EnrollInfo, Params> {
    private final TwilioRepository twilioRepository;

    @Inject
    public TwilioEnrollment(TwilioRepository twilioRepository) {
        Intrinsics.checkNotNullParameter(twilioRepository, "");
        this.twilioRepository = twilioRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<EnrollInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.twilioRepository.submitEnrollment(params.getTwilioEnroll());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioEnrollment$Params;", "", "Lid/dana/domain/twilio/model/TwilioEnroll;", "twilioEnroll", "Lid/dana/domain/twilio/model/TwilioEnroll;", "getTwilioEnroll", "()Lid/dana/domain/twilio/model/TwilioEnroll;", "<init>", "(Lid/dana/domain/twilio/model/TwilioEnroll;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final TwilioEnroll twilioEnroll;

        public Params(TwilioEnroll twilioEnroll) {
            Intrinsics.checkNotNullParameter(twilioEnroll, "");
            this.twilioEnroll = twilioEnroll;
        }

        @JvmName(name = "getTwilioEnroll")
        public final TwilioEnroll getTwilioEnroll() {
            return this.twilioEnroll;
        }
    }
}
