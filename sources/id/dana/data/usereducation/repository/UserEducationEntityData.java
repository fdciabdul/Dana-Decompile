package id.dana.data.usereducation.repository;

import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface UserEducationEntityData {
    Observable<Boolean> isNeedToShowBottomSheetOnBoarding(String str, String str2);

    Observable<Boolean> isNeedToShowDialog(String str);

    Observable<Boolean> isNeedToShowToolTip(String str, String str2);

    Observable<Boolean> saveNeedToShowDialog(boolean z, String str);

    Observable<Boolean> saveShowBottomSheetOnBoarding(String str, String str2);

    Observable<Boolean> saveShowToolTip(boolean z, String str, String str2);
}
