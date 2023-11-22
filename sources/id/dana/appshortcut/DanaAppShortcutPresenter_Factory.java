package id.dana.appshortcut;

import dagger.internal.Factory;
import id.dana.appshortcut.DanaAppShortcutContract;
import id.dana.domain.appshortcut.interactor.GetAppShortcutConfig;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaAppShortcutPresenter_Factory implements Factory<DanaAppShortcutPresenter> {
    private final Provider<GetAppShortcutConfig> MyBillsEntityDataFactory;
    private final Provider<DanaAppShortcutContract.View> PlaceComponentResult;

    private DanaAppShortcutPresenter_Factory(Provider<DanaAppShortcutContract.View> provider, Provider<GetAppShortcutConfig> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static DanaAppShortcutPresenter_Factory MyBillsEntityDataFactory(Provider<DanaAppShortcutContract.View> provider, Provider<GetAppShortcutConfig> provider2) {
        return new DanaAppShortcutPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaAppShortcutPresenter(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
