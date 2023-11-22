package id.dana.animation.promocenter;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.animation.promocenter.NewPromoCenterContract;
import id.dana.domain.featureconfig.interactor.GetPromoCenterConfig;
import id.dana.domain.home.interactor.GetNewsWidgetActivitiesFromPersistence;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NewPromoCenterPresenter_Factory implements Factory<NewPromoCenterPresenter> {
    private final Provider<GetPromoCenterConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetPromoCenterVersion> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SaveNewsWidgetActivitiesIntoPersistence> MyBillsEntityDataFactory;
    private final Provider<GetNewsWidgetActivitiesFromPersistence> PlaceComponentResult;
    private final Provider<NewPromoCenterContract.View> getAuthRequestContext;

    private NewPromoCenterPresenter_Factory(Provider<NewPromoCenterContract.View> provider, Provider<GetPromoCenterConfig> provider2, Provider<GetPromoCenterVersion> provider3, Provider<GetNewsWidgetActivitiesFromPersistence> provider4, Provider<SaveNewsWidgetActivitiesIntoPersistence> provider5) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PlaceComponentResult = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static NewPromoCenterPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<NewPromoCenterContract.View> provider, Provider<GetPromoCenterConfig> provider2, Provider<GetPromoCenterVersion> provider3, Provider<GetNewsWidgetActivitiesFromPersistence> provider4, Provider<SaveNewsWidgetActivitiesIntoPersistence> provider5) {
        return new NewPromoCenterPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NewPromoCenterPresenter(this.getAuthRequestContext.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
