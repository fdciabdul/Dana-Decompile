package id.dana.domain.twilio.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/TwilioSdkRepository;", "twilioSdkRepository", "Lid/dana/domain/twilio/TwilioSdkRepository;", "<init>", "(Lid/dana/domain/twilio/TwilioSdkRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetTwilioChallengeDetails extends BaseUseCase<Map<String, ? extends String>, Param> {
    private final TwilioSdkRepository twilioSdkRepository;

    @Inject
    public GetTwilioChallengeDetails(TwilioSdkRepository twilioSdkRepository) {
        Intrinsics.checkNotNullParameter(twilioSdkRepository, "");
        this.twilioSdkRepository = twilioSdkRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Map<String, String>> buildUseCase(Param params) {
        Observable<Map<String, String>> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(params, "");
        Single<Map<String, String>> challengeDetails = this.twilioSdkRepository.getChallengeDetails(params.getChallengeSid(), params.getFactorSid());
        if (challengeDetails instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) challengeDetails).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(challengeDetails));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails$Param;", "", "", "component1", "()Ljava/lang/String;", "component2", TwilioIdentityVerificationActivity.CHALLENGE_SID, TwilioIdentityVerificationActivity.FACTOR_SID, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getChallengeSid", "getFactorSid", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final String challengeSid;
        private final String factorSid;

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.challengeSid;
            }
            if ((i & 2) != 0) {
                str2 = param.factorSid;
            }
            return param.copy(str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getChallengeSid() {
            return this.challengeSid;
        }

        /* renamed from: component2  reason: from getter */
        public final String getFactorSid() {
            return this.factorSid;
        }

        public final Param copy(String challengeSid, String factorSid) {
            Intrinsics.checkNotNullParameter(challengeSid, "");
            Intrinsics.checkNotNullParameter(factorSid, "");
            return new Param(challengeSid, factorSid);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.challengeSid, param.challengeSid) && Intrinsics.areEqual(this.factorSid, param.factorSid);
            }
            return false;
        }

        public final int hashCode() {
            return (this.challengeSid.hashCode() * 31) + this.factorSid.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(challengeSid=");
            sb.append(this.challengeSid);
            sb.append(", factorSid=");
            sb.append(this.factorSid);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.challengeSid = str;
            this.factorSid = str2;
        }

        @JvmName(name = "getChallengeSid")
        public final String getChallengeSid() {
            return this.challengeSid;
        }

        @JvmName(name = "getFactorSid")
        public final String getFactorSid() {
            return this.factorSid;
        }
    }
}
