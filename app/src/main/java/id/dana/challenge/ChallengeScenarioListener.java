package id.dana.challenge;

import id.dana.domain.model.rpc.response.LoginResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\"\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lid/dana/challenge/ChallengeScenarioListener;", "", "closeChallengeSession", "", "hideClose", "onDismiss", "onNext", ChallengePinWithFaceActivity.CHALLENGE_METHOD_LIST, "", "", "otpPurpose", "onNextCarrierIdentificationFirst", ChallengePinWithFaceActivity.LOGIN_RESPONSE, "Lid/dana/domain/model/rpc/response/LoginResponse;", "showClose", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ChallengeScenarioListener {

    /* renamed from: id.dana.challenge.ChallengeScenarioListener$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static void BuiltInFictitiousFunctionClassFactory(LoginResponse loginResponse) {
            Intrinsics.checkNotNullParameter(loginResponse, "");
        }

        public static void getAuthRequestContext() {
        }
    }

    void closeChallengeSession();

    void hideClose();

    void onNext(List<String> challengeMethod, String otpPurpose);

    void showClose();
}
