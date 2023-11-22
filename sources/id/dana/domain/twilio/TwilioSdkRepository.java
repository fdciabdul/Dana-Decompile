package id.dana.domain.twilio;

import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00022\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\nJ5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0011\u0010\u0005J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\nJ1\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u00022\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\nJ#\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070 0\u00022\u0006\u0010\u001f\u001a\u00020\u0007H&¢\u0006\u0004\b!\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/twilio/TwilioSdkRepository;", "", "Lio/reactivex/Single;", "", "checkEnrollmentStatus", "()Lio/reactivex/Single;", "", "", "checkPendingChallenge", TwilioIdentityVerificationActivity.FACTOR_SID, "(Ljava/lang/String;)Lio/reactivex/Single;", "serviceSid", "identity", "pushToken", "accessToken", "createFactor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "deleteLocalFactor", TwilioIdentityVerificationActivity.CHALLENGE_SID, "getChallenge", "getChallengeDetails", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "getChallengeHiddenDetails", "Lio/reactivex/Observable;", "saveTwilioChallengeAttempt", "(Ljava/lang/String;)Lio/reactivex/Observable;", "newStatus", "updateChallenge", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "token", "updatePushToken", "sid", "", "verifyFactor"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TwilioSdkRepository {
    Single<Boolean> checkEnrollmentStatus();

    Single<Map<String, String>> checkPendingChallenge();

    Single<Map<String, String>> checkPendingChallenge(String factorSid);

    Single<String> createFactor(String serviceSid, String identity, String pushToken, String accessToken);

    Single<Boolean> deleteLocalFactor();

    Single<String> getChallenge(String challengeSid);

    Single<Map<String, String>> getChallengeDetails(String challengeSid, String factorSid);

    Single<Map<String, String>> getChallengeHiddenDetails(String challengeSid, String factorSid);

    Observable<Boolean> saveTwilioChallengeAttempt(String challengeSid);

    Single<Boolean> updateChallenge(String factorSid, String challengeSid, String newStatus);

    Single<Boolean> updatePushToken(String token);

    Single<List<String>> verifyFactor(String sid);
}
