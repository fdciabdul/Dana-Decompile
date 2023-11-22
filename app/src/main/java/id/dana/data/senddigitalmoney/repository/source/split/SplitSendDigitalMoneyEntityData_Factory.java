package id.dana.data.senddigitalmoney.repository.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitSendDigitalMoneyEntityData_Factory implements Factory<SplitSendDigitalMoneyEntityData> {
    private final Provider<SplitFacade> PlaceComponentResult;

    private SplitSendDigitalMoneyEntityData_Factory(Provider<SplitFacade> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SplitSendDigitalMoneyEntityData_Factory getAuthRequestContext(Provider<SplitFacade> provider) {
        return new SplitSendDigitalMoneyEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitSendDigitalMoneyEntityData(this.PlaceComponentResult.get());
    }
}
