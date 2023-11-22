package id.dana.domain.twilio;

import id.dana.domain.twilio.model.BindEnrollInfo;
import id.dana.domain.twilio.model.DerollInfo;
import id.dana.domain.twilio.model.EnrollInfo;
import id.dana.domain.twilio.model.RequestChallengeInfo;
import id.dana.domain.twilio.model.TwilioBindEnroll;
import id.dana.domain.twilio.model.TwilioChallenge;
import id.dana.domain.twilio.model.TwilioConsult;
import id.dana.domain.twilio.model.TwilioDeroll;
import id.dana.domain.twilio.model.TwilioEnroll;
import id.dana.domain.twilio.model.TwilioInfo;
import id.dana.domain.twilio.model.TwilioVerify;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00042\u0006\u0010!\u001a\u00020 H&¢\u0006\u0004\b#\u0010$ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/twilio/TwilioRepository;", "", "Lid/dana/domain/twilio/model/TwilioConsult;", "twilioConsult", "Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioInfo;", "consultEnrollmentStatus", "(Lid/dana/domain/twilio/model/TwilioConsult;)Lio/reactivex/Observable;", "", "", "getNonLogoutScenes", "()Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioChallenge;", "twilioChallenge", "Lid/dana/domain/twilio/model/RequestChallengeInfo;", "requestChallenge", "(Lid/dana/domain/twilio/model/TwilioChallenge;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioBindEnroll;", "twilioBindEnroll", "Lid/dana/domain/twilio/model/BindEnrollInfo;", "submitBindEnrollment", "(Lid/dana/domain/twilio/model/TwilioBindEnroll;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioDeroll;", "twilioDeroll", "Lid/dana/domain/twilio/model/DerollInfo;", "submitDerollment", "(Lid/dana/domain/twilio/model/TwilioDeroll;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioEnroll;", "twilioEnroll", "Lid/dana/domain/twilio/model/EnrollInfo;", "submitEnrollment", "(Lid/dana/domain/twilio/model/TwilioEnroll;)Lio/reactivex/Observable;", "Lid/dana/domain/twilio/model/TwilioVerify;", "twilioVerify", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "verifySecurityProduct", "(Lid/dana/domain/twilio/model/TwilioVerify;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TwilioRepository {
    Observable<TwilioInfo> consultEnrollmentStatus(TwilioConsult twilioConsult);

    Observable<List<String>> getNonLogoutScenes();

    Observable<RequestChallengeInfo> requestChallenge(TwilioChallenge twilioChallenge);

    Observable<BindEnrollInfo> submitBindEnrollment(TwilioBindEnroll twilioBindEnroll);

    Observable<DerollInfo> submitDerollment(TwilioDeroll twilioDeroll);

    Observable<EnrollInfo> submitEnrollment(TwilioEnroll twilioEnroll);

    Observable<VerifySecurityInfo> verifySecurityProduct(TwilioVerify twilioVerify);
}
