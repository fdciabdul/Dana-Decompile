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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/twilio/interactor/CheckPendingChallenge;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/twilio/interactor/CheckPendingChallenge$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/twilio/interactor/CheckPendingChallenge$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/TwilioSdkRepository;", "twilioSdkRepository", "Lid/dana/domain/twilio/TwilioSdkRepository;", "<init>", "(Lid/dana/domain/twilio/TwilioSdkRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckPendingChallenge extends BaseUseCase<Map<String, ? extends String>, Params> {
    private final TwilioSdkRepository twilioSdkRepository;

    @Inject
    public CheckPendingChallenge(TwilioSdkRepository twilioSdkRepository) {
        Intrinsics.checkNotNullParameter(twilioSdkRepository, "");
        this.twilioSdkRepository = twilioSdkRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Map<String, String>> buildUseCase(Params params) {
        Observable<Map<String, String>> BuiltInFictitiousFunctionClassFactory;
        Observable<Map<String, String>> BuiltInFictitiousFunctionClassFactory2;
        Intrinsics.checkNotNullParameter(params, "");
        String factorSid = params.getFactorSid();
        if (factorSid != null) {
            Single<Map<String, String>> checkPendingChallenge = this.twilioSdkRepository.checkPendingChallenge(factorSid);
            if (checkPendingChallenge instanceof FuseToObservable) {
                BuiltInFictitiousFunctionClassFactory2 = ((FuseToObservable) checkPendingChallenge).getAuthRequestContext();
            } else {
                BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(checkPendingChallenge));
            }
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            return BuiltInFictitiousFunctionClassFactory2;
        }
        Single<Map<String, String>> checkPendingChallenge2 = this.twilioSdkRepository.checkPendingChallenge();
        if (checkPendingChallenge2 instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) checkPendingChallenge2).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(checkPendingChallenge2));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/twilio/interactor/CheckPendingChallenge$Params;", "", "", "component1", "()Ljava/lang/String;", TwilioIdentityVerificationActivity.FACTOR_SID, "copy", "(Ljava/lang/String;)Lid/dana/domain/twilio/interactor/CheckPendingChallenge$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getFactorSid", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String factorSid;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Params() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.twilio.interactor.CheckPendingChallenge.Params.<init>():void");
        }

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.factorSid;
            }
            return params.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getFactorSid() {
            return this.factorSid;
        }

        public final Params copy(String factorSid) {
            return new Params(factorSid);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.factorSid, ((Params) other).factorSid);
        }

        public final int hashCode() {
            String str = this.factorSid;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(factorSid=");
            sb.append(this.factorSid);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str) {
            this.factorSid = str;
        }

        public /* synthetic */ Params(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @JvmName(name = "getFactorSid")
        public final String getFactorSid() {
            return this.factorSid;
        }
    }
}
