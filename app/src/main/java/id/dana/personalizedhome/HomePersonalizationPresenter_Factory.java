package id.dana.personalizedhome;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.geocode.interactor.GetIndoProvinceLandmark;
import id.dana.domain.personalizedhome.GetHomeLandmarkUrl;
import id.dana.domain.personalizedhome.GetPersonalizedHomeConfig;
import id.dana.personalizedhome.HomePersonalizationContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class HomePersonalizationPresenter_Factory implements Factory<HomePersonalizationPresenter> {
    private final Provider<GetHomeLandmarkUrl> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HomePersonalizationContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPersonalizedHomeConfig> MyBillsEntityDataFactory;
    private final Provider<GetIndoProvinceLandmark> getAuthRequestContext;

    private HomePersonalizationPresenter_Factory(Provider<HomePersonalizationContract.View> provider, Provider<GetPersonalizedHomeConfig> provider2, Provider<GetHomeLandmarkUrl> provider3, Provider<GetIndoProvinceLandmark> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static HomePersonalizationPresenter_Factory MyBillsEntityDataFactory(Provider<HomePersonalizationContract.View> provider, Provider<GetPersonalizedHomeConfig> provider2, Provider<GetHomeLandmarkUrl> provider3, Provider<GetIndoProvinceLandmark> provider4) {
        return new HomePersonalizationPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomePersonalizationPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
