package id.dana.domain.usereducation.repository;

import id.dana.domain.usereducation.ShowDialogScenarios;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UserEducationRepository {
    Observable<Boolean> isNeedToShowBottomSheetOnBoarding(String str);

    Observable<Boolean> isNeedToShowDialog(@ShowDialogScenarios String str);

    Observable<Boolean> isNeedToShowToolTip(String str);

    Observable<Boolean> saveDisplayedBottomSheetOnBoarding(String str);

    Observable<Boolean> saveShowDialog(boolean z, String str);

    Observable<Boolean> saveShowToolTip(boolean z, String str);
}
