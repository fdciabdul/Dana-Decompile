package id.dana.richview;

import dagger.MembersInjector;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.domain.featureconfig.StartupConfigEntityData;

/* loaded from: classes9.dex */
public final class SurveyView_MembersInjector implements MembersInjector<SurveyView> {
    public static void PlaceComponentResult(SurveyView surveyView, HomeInfoContract.Presenter presenter) {
        surveyView.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(SurveyView surveyView, StartupConfigEntityData startupConfigEntityData) {
        surveyView.sharedPrefStartupConfig = startupConfigEntityData;
    }
}
