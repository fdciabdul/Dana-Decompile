package id.dana.domain.twilio.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/TwilioSdkRepository;", "twilioSdkRepository", "Lid/dana/domain/twilio/TwilioSdkRepository;", "<init>", "(Lid/dana/domain/twilio/TwilioSdkRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdateTwilioChallenge extends BaseUseCase<Boolean, Param> {
    private final TwilioSdkRepository twilioSdkRepository;

    @Inject
    public UpdateTwilioChallenge(TwilioSdkRepository twilioSdkRepository) {
        Intrinsics.checkNotNullParameter(twilioSdkRepository, "");
        this.twilioSdkRepository = twilioSdkRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Param params) {
        Observable<Boolean> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(params, "");
        Single<Boolean> updateChallenge = this.twilioSdkRepository.updateChallenge(params.getFactorSid(), params.getChallengeSid(), params.getNewStatus());
        if (updateChallenge instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) updateChallenge).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(updateChallenge));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", TwilioIdentityVerificationActivity.FACTOR_SID, TwilioIdentityVerificationActivity.CHALLENGE_SID, "newStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getChallengeSid", "getFactorSid", "getNewStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Param {
        private final String challengeSid;
        private final String factorSid;
        private final String newStatus;

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.factorSid;
            }
            if ((i & 2) != 0) {
                str2 = param.challengeSid;
            }
            if ((i & 4) != 0) {
                str3 = param.newStatus;
            }
            return param.copy(str, str2, str3);
        }

        /* renamed from: component1  reason: from getter */
        public final String getFactorSid() {
            return this.factorSid;
        }

        /* renamed from: component2  reason: from getter */
        public final String getChallengeSid() {
            return this.challengeSid;
        }

        /* renamed from: component3  reason: from getter */
        public final String getNewStatus() {
            return this.newStatus;
        }

        public final Param copy(String factorSid, String challengeSid, String newStatus) {
            Intrinsics.checkNotNullParameter(factorSid, "");
            Intrinsics.checkNotNullParameter(challengeSid, "");
            Intrinsics.checkNotNullParameter(newStatus, "");
            return new Param(factorSid, challengeSid, newStatus);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.factorSid, param.factorSid) && Intrinsics.areEqual(this.challengeSid, param.challengeSid) && Intrinsics.areEqual(this.newStatus, param.newStatus);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.factorSid.hashCode() * 31) + this.challengeSid.hashCode()) * 31) + this.newStatus.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(factorSid=");
            sb.append(this.factorSid);
            sb.append(", challengeSid=");
            sb.append(this.challengeSid);
            sb.append(", newStatus=");
            sb.append(this.newStatus);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.factorSid = str;
            this.challengeSid = str2;
            this.newStatus = str3;
        }

        @JvmName(name = "getChallengeSid")
        public final String getChallengeSid() {
            return this.challengeSid;
        }

        @JvmName(name = "getFactorSid")
        public final String getFactorSid() {
            return this.factorSid;
        }

        @JvmName(name = "getNewStatus")
        public final String getNewStatus() {
            return this.newStatus;
        }
    }
}
