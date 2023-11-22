package id.dana.domain.twilio.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.model.BindEnrollInfo;
import id.dana.domain.twilio.model.TwilioBindEnroll;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioBindEnrollment;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/twilio/model/BindEnrollInfo;", "Lid/dana/domain/twilio/interactor/TwilioBindEnrollment$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/twilio/interactor/TwilioBindEnrollment$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/TwilioRepository;", "twilioRepository", "Lid/dana/domain/twilio/TwilioRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/twilio/TwilioRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TwilioBindEnrollment extends UseCase<BindEnrollInfo, Params> {
    private final TwilioRepository twilioRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TwilioBindEnrollment(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TwilioRepository twilioRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(twilioRepository, "");
        this.twilioRepository = twilioRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<BindEnrollInfo> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.twilioRepository.submitBindEnrollment(params.getTwilioBindEnroll());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioBindEnrollment$Params;", "", "Lid/dana/domain/twilio/model/TwilioBindEnroll;", "twilioBindEnroll", "Lid/dana/domain/twilio/model/TwilioBindEnroll;", "getTwilioBindEnroll", "()Lid/dana/domain/twilio/model/TwilioBindEnroll;", "<init>", "(Lid/dana/domain/twilio/model/TwilioBindEnroll;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final TwilioBindEnroll twilioBindEnroll;

        public Params(TwilioBindEnroll twilioBindEnroll) {
            Intrinsics.checkNotNullParameter(twilioBindEnroll, "");
            this.twilioBindEnroll = twilioBindEnroll;
        }

        @JvmName(name = "getTwilioBindEnroll")
        public final TwilioBindEnroll getTwilioBindEnroll() {
            return this.twilioBindEnroll;
        }
    }
}
