package id.dana.animation.danaprotection;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.animation.danaprotection.DanaProtectionContract;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionInfo;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation;
import id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig;
import id.dana.domain.home.interactor.GetDanaProtectionHomeWidgetInfoWithConfigFromLocal;
import id.dana.domain.home.interactor.SaveDanaProtectionHomeWidgetInfoLocal;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DanaProtectionPresenter_Factory implements Factory<DanaProtectionPresenter> {
    private final Provider<GetDanaProtectionWidgetConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetDanaProtectionRecommendation> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetDanaProtectionInfo> MyBillsEntityDataFactory;
    private final Provider<GetDanaProtectionHomeWidgetInfoWithConfigFromLocal> PlaceComponentResult;
    private final Provider<SaveDanaProtectionHomeWidgetInfoLocal> getAuthRequestContext;
    private final Provider<DanaProtectionContract.View> moveToNextValue;

    private DanaProtectionPresenter_Factory(Provider<DanaProtectionContract.View> provider, Provider<GetDanaProtectionInfo> provider2, Provider<GetDanaProtectionRecommendation> provider3, Provider<GetDanaProtectionWidgetConfig> provider4, Provider<GetDanaProtectionHomeWidgetInfoWithConfigFromLocal> provider5, Provider<SaveDanaProtectionHomeWidgetInfoLocal> provider6) {
        this.moveToNextValue = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.PlaceComponentResult = provider5;
        this.getAuthRequestContext = provider6;
    }

    public static DanaProtectionPresenter_Factory MyBillsEntityDataFactory(Provider<DanaProtectionContract.View> provider, Provider<GetDanaProtectionInfo> provider2, Provider<GetDanaProtectionRecommendation> provider3, Provider<GetDanaProtectionWidgetConfig> provider4, Provider<GetDanaProtectionHomeWidgetInfoWithConfigFromLocal> provider5, Provider<SaveDanaProtectionHomeWidgetInfoLocal> provider6) {
        return new DanaProtectionPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionPresenter(this.moveToNextValue.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
