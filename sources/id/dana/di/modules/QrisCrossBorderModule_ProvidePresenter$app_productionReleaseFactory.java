package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.qriscrossborder.QrisCrossBorderContract;
import id.dana.qriscrossborder.QrisCrossBorderPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class QrisCrossBorderModule_ProvidePresenter$app_productionReleaseFactory implements Factory<QrisCrossBorderContract.Presenter> {
    private final QrisCrossBorderModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<QrisCrossBorderPresenter> MyBillsEntityDataFactory;

    private QrisCrossBorderModule_ProvidePresenter$app_productionReleaseFactory(QrisCrossBorderModule qrisCrossBorderModule, Provider<QrisCrossBorderPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = qrisCrossBorderModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static QrisCrossBorderModule_ProvidePresenter$app_productionReleaseFactory MyBillsEntityDataFactory(QrisCrossBorderModule qrisCrossBorderModule, Provider<QrisCrossBorderPresenter> provider) {
        return new QrisCrossBorderModule_ProvidePresenter$app_productionReleaseFactory(qrisCrossBorderModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (QrisCrossBorderContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
