package id.dana.data.usereducation.repository.source.local;

import id.dana.data.usereducation.repository.UserEducationEntityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes4.dex */
public class PreferenceUserEducationEntityData implements UserEducationEntityData {
    private final UserEducationPreference userEducationPreference;

    @Inject
    public PreferenceUserEducationEntityData(UserEducationPreference userEducationPreference) {
        this.userEducationPreference = userEducationPreference;
    }

    @Override // id.dana.data.usereducation.repository.UserEducationEntityData
    public Observable<Boolean> isNeedToShowToolTip(String str, String str2) {
        return Observable.just(Boolean.valueOf(!this.userEducationPreference.getToolTipShow(str, str2)));
    }

    @Override // id.dana.data.usereducation.repository.UserEducationEntityData
    public Observable<Boolean> saveShowToolTip(boolean z, String str, String str2) {
        return Observable.just(Boolean.valueOf(this.userEducationPreference.saveToolTipShow(z, str, str2)));
    }

    @Override // id.dana.data.usereducation.repository.UserEducationEntityData
    public Observable<Boolean> isNeedToShowBottomSheetOnBoarding(String str, String str2) {
        return Observable.just(Boolean.valueOf(this.userEducationPreference.getBottomSheetOnBoardingShow(str, str2)));
    }

    @Override // id.dana.data.usereducation.repository.UserEducationEntityData
    public Observable<Boolean> saveShowBottomSheetOnBoarding(String str, String str2) {
        return Observable.just(Boolean.valueOf(this.userEducationPreference.saveBottomSheetOnBoardingShow(str, str2)));
    }

    @Override // id.dana.data.usereducation.repository.UserEducationEntityData
    public Observable<Boolean> isNeedToShowDialog(String str) {
        return Observable.just(Boolean.valueOf(this.userEducationPreference.isShowDialog(str)));
    }

    @Override // id.dana.data.usereducation.repository.UserEducationEntityData
    public Observable<Boolean> saveNeedToShowDialog(boolean z, String str) {
        return Observable.just(Boolean.valueOf(this.userEducationPreference.saveShowDialog(z, str)));
    }
}
