package id.dana.richview.moreforyou;

import android.content.Context;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.csatsurvey.interactor.DismissCsatSurvey;
import id.dana.domain.csatsurvey.interactor.GetCsatSurveyCreatedDate;
import id.dana.domain.csatsurvey.interactor.SaveCsatSurveyCreatedDate;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.home.interactor.GetMoreForYouDataFromPersistence;
import id.dana.domain.home.interactor.SaveMoreForYouDataIntoPersistence;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo;
import id.dana.domain.moreforyou.GetMoreForYou;
import id.dana.richview.moreforyou.MoreForYouContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MoreForYouPresenter_Factory implements Factory<MoreForYouPresenter> {
    private final Provider<Context> contextProvider;
    private final Provider<DismissCsatSurvey> dismissCsatSurveyProvider;
    private final Provider<GetCsatSurveyCreatedDate> getCsatSurveyCreatedDateProvider;
    private final Provider<GetHomeInfo> getHomeInfoProvider;
    private final Provider<GetMoreForYouDataFromPersistence> getMoreForYouDataFromPersistenceProvider;
    private final Provider<GetMoreForYou> getMoreForYouProvider;
    private final Provider<GetSurveyInfo> getSurveyInfoProvider;
    private final Provider<MoreForYouModelMapper> mapperProvider;
    private final Provider<SaveCsatSurveyCreatedDate> saveCsatSurveyCreatedDateProvider;
    private final Provider<SaveMoreForYouDataIntoPersistence> saveMoreForYouDataIntoPersistenceProvider;
    private final Provider<StartupConfigEntityData> sharedPrefStartupConfigProvider;
    private final Provider<MoreForYouContract.View> viewProvider;

    public MoreForYouPresenter_Factory(Provider<MoreForYouContract.View> provider, Provider<Context> provider2, Provider<GetMoreForYou> provider3, Provider<MoreForYouModelMapper> provider4, Provider<GetHomeInfo> provider5, Provider<SaveCsatSurveyCreatedDate> provider6, Provider<GetCsatSurveyCreatedDate> provider7, Provider<DismissCsatSurvey> provider8, Provider<StartupConfigEntityData> provider9, Provider<GetSurveyInfo> provider10, Provider<GetMoreForYouDataFromPersistence> provider11, Provider<SaveMoreForYouDataIntoPersistence> provider12) {
        this.viewProvider = provider;
        this.contextProvider = provider2;
        this.getMoreForYouProvider = provider3;
        this.mapperProvider = provider4;
        this.getHomeInfoProvider = provider5;
        this.saveCsatSurveyCreatedDateProvider = provider6;
        this.getCsatSurveyCreatedDateProvider = provider7;
        this.dismissCsatSurveyProvider = provider8;
        this.sharedPrefStartupConfigProvider = provider9;
        this.getSurveyInfoProvider = provider10;
        this.getMoreForYouDataFromPersistenceProvider = provider11;
        this.saveMoreForYouDataIntoPersistenceProvider = provider12;
    }

    @Override // javax.inject.Provider
    public final MoreForYouPresenter get() {
        return newInstance(this.viewProvider.get(), this.contextProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.getMoreForYouProvider), DoubleCheck.MyBillsEntityDataFactory(this.mapperProvider), DoubleCheck.MyBillsEntityDataFactory(this.getHomeInfoProvider), DoubleCheck.MyBillsEntityDataFactory(this.saveCsatSurveyCreatedDateProvider), DoubleCheck.MyBillsEntityDataFactory(this.getCsatSurveyCreatedDateProvider), DoubleCheck.MyBillsEntityDataFactory(this.dismissCsatSurveyProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefStartupConfigProvider), DoubleCheck.MyBillsEntityDataFactory(this.getSurveyInfoProvider), DoubleCheck.MyBillsEntityDataFactory(this.getMoreForYouDataFromPersistenceProvider), DoubleCheck.MyBillsEntityDataFactory(this.saveMoreForYouDataIntoPersistenceProvider));
    }

    public static MoreForYouPresenter_Factory create(Provider<MoreForYouContract.View> provider, Provider<Context> provider2, Provider<GetMoreForYou> provider3, Provider<MoreForYouModelMapper> provider4, Provider<GetHomeInfo> provider5, Provider<SaveCsatSurveyCreatedDate> provider6, Provider<GetCsatSurveyCreatedDate> provider7, Provider<DismissCsatSurvey> provider8, Provider<StartupConfigEntityData> provider9, Provider<GetSurveyInfo> provider10, Provider<GetMoreForYouDataFromPersistence> provider11, Provider<SaveMoreForYouDataIntoPersistence> provider12) {
        return new MoreForYouPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static MoreForYouPresenter newInstance(MoreForYouContract.View view, Context context, Lazy<GetMoreForYou> lazy, Lazy<MoreForYouModelMapper> lazy2, Lazy<GetHomeInfo> lazy3, Lazy<SaveCsatSurveyCreatedDate> lazy4, Lazy<GetCsatSurveyCreatedDate> lazy5, Lazy<DismissCsatSurvey> lazy6, Lazy<StartupConfigEntityData> lazy7, Lazy<GetSurveyInfo> lazy8, Lazy<GetMoreForYouDataFromPersistence> lazy9, Lazy<SaveMoreForYouDataIntoPersistence> lazy10) {
        return new MoreForYouPresenter(view, context, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8, lazy9, lazy10);
    }
}
