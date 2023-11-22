package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.appshortcut.DanaAppShortcutContract;

/* loaded from: classes4.dex */
public final class DanaAppShortcutModule_ProvideView$app_productionReleaseFactory implements Factory<DanaAppShortcutContract.View> {
    private final DanaAppShortcutModule PlaceComponentResult;

    private DanaAppShortcutModule_ProvideView$app_productionReleaseFactory(DanaAppShortcutModule danaAppShortcutModule) {
        this.PlaceComponentResult = danaAppShortcutModule;
    }

    public static DanaAppShortcutModule_ProvideView$app_productionReleaseFactory getAuthRequestContext(DanaAppShortcutModule danaAppShortcutModule) {
        return new DanaAppShortcutModule_ProvideView$app_productionReleaseFactory(danaAppShortcutModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaAppShortcutContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
