package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.SettingMoreContract;
import id.dana.myprofile.SettingMorePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SubMenuModule_ProvidePresenterFactory implements Factory<SettingMoreContract.Presenter> {
    private final SubMenuModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SettingMorePresenter> PlaceComponentResult;

    public static SettingMoreContract.Presenter PlaceComponentResult(SubMenuModule subMenuModule, SettingMorePresenter settingMorePresenter) {
        return (SettingMoreContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(subMenuModule.BuiltInFictitiousFunctionClassFactory(settingMorePresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SettingMoreContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
