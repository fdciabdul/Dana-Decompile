package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.appshortcut.DanaAppShortcutContract;
import id.dana.appshortcut.DanaAppShortcutPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaAppShortcutModule_ProvidePresenter$app_productionReleaseFactory implements Factory<DanaAppShortcutContract.Presenter> {
    private final DanaAppShortcutModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DanaAppShortcutPresenter> PlaceComponentResult;

    private DanaAppShortcutModule_ProvidePresenter$app_productionReleaseFactory(DanaAppShortcutModule danaAppShortcutModule, Provider<DanaAppShortcutPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaAppShortcutModule;
        this.PlaceComponentResult = provider;
    }

    public static DanaAppShortcutModule_ProvidePresenter$app_productionReleaseFactory getAuthRequestContext(DanaAppShortcutModule danaAppShortcutModule, Provider<DanaAppShortcutPresenter> provider) {
        return new DanaAppShortcutModule_ProvidePresenter$app_productionReleaseFactory(danaAppShortcutModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaAppShortcutContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
