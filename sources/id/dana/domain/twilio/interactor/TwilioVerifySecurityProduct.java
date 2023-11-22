package id.dana.domain.twilio.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.model.TwilioVerify;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/TwilioRepository;", "twilioRepository", "Lid/dana/domain/twilio/TwilioRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/twilio/TwilioRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioVerifySecurityProduct extends UseCase<VerifySecurityInfo, Param> {
    private final TwilioRepository twilioRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public TwilioVerifySecurityProduct(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, TwilioRepository twilioRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(twilioRepository, "");
        this.twilioRepository = twilioRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public final Observable<VerifySecurityInfo> buildUseCaseObservable(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.twilioRepository.verifySecurityProduct(params.getTwilioVerify());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;", "", "Lid/dana/domain/twilio/model/TwilioVerify;", "component1", "()Lid/dana/domain/twilio/model/TwilioVerify;", "twilioVerify", "copy", "(Lid/dana/domain/twilio/model/TwilioVerify;)Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/twilio/model/TwilioVerify;", "getTwilioVerify", "<init>", "(Lid/dana/domain/twilio/model/TwilioVerify;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Param {
        private final TwilioVerify twilioVerify;

        public static /* synthetic */ Param copy$default(Param param, TwilioVerify twilioVerify, int i, Object obj) {
            if ((i & 1) != 0) {
                twilioVerify = param.twilioVerify;
            }
            return param.copy(twilioVerify);
        }

        /* renamed from: component1  reason: from getter */
        public final TwilioVerify getTwilioVerify() {
            return this.twilioVerify;
        }

        public final Param copy(TwilioVerify twilioVerify) {
            Intrinsics.checkNotNullParameter(twilioVerify, "");
            return new Param(twilioVerify);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && Intrinsics.areEqual(this.twilioVerify, ((Param) other).twilioVerify);
        }

        public final int hashCode() {
            return this.twilioVerify.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(twilioVerify=");
            sb.append(this.twilioVerify);
            sb.append(')');
            return sb.toString();
        }

        public Param(TwilioVerify twilioVerify) {
            Intrinsics.checkNotNullParameter(twilioVerify, "");
            this.twilioVerify = twilioVerify;
        }

        @JvmName(name = "getTwilioVerify")
        public final TwilioVerify getTwilioVerify() {
            return this.twilioVerify;
        }
    }
}
