package id.dana.domain.resetpin;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.resetpin.model.ConsultDanaVizModel;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b\u000f\u0010\bJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H&¢\u0006\u0004\b\u0010\u0010\bJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b\u0011\u0010\bJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0012\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\u0015\u001a\u00020\u000bH&¢\u0006\u0004\b\u0016\u0010\u000eJ%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\tH&¢\u0006\u0004\b\u0018\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/resetpin/ResetPinRepository;", "", "", "clearDanaVizPromptCache", "()V", "Lio/reactivex/Observable;", "Lid/dana/domain/resetpin/model/ConsultDanaVizModel;", "consultForceDanaVizEnroll", "()Lio/reactivex/Observable;", "", "finishForceDanaVizEnroll", "", "phoneNumber", "getDanaVizPromptAfterResetPin", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getForceDanaVizPrompt", "getTempRegistrationPhoneNumber", "isDanaVizEnrollmentSkippable", "forceShow", "saveForceDanaVizPrompt", "(Z)Lio/reactivex/Observable;", BioUtilityBridge.SECURITY_ID, "selfUnfreeze", "danaVizPromptAfterResetPin", "setDanaVizPromptAfterResetPin", "(Ljava/lang/String;Z)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ResetPinRepository {
    void clearDanaVizPromptCache();

    Observable<ConsultDanaVizModel> consultForceDanaVizEnroll();

    Observable<Boolean> finishForceDanaVizEnroll();

    Observable<Boolean> getDanaVizPromptAfterResetPin(String phoneNumber);

    Observable<Boolean> getForceDanaVizPrompt();

    Observable<String> getTempRegistrationPhoneNumber();

    Observable<Boolean> isDanaVizEnrollmentSkippable();

    Observable<Unit> saveForceDanaVizPrompt(boolean forceShow);

    Observable<Boolean> selfUnfreeze(String securityId);

    Observable<Boolean> setDanaVizPromptAfterResetPin(String phoneNumber, boolean danaVizPromptAfterResetPin);
}
