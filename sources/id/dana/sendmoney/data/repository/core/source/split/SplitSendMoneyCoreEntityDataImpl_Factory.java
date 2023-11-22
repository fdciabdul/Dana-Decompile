package id.dana.sendmoney.data.repository.core.source.split;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitSendMoneyCoreEntityDataImpl_Factory implements Factory<SplitSendMoneyCoreEntityDataImpl> {
    private final Provider<SplitFacade> PlaceComponentResult;

    private SplitSendMoneyCoreEntityDataImpl_Factory(Provider<SplitFacade> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SplitSendMoneyCoreEntityDataImpl_Factory MyBillsEntityDataFactory(Provider<SplitFacade> provider) {
        return new SplitSendMoneyCoreEntityDataImpl_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitSendMoneyCoreEntityDataImpl(this.PlaceComponentResult.get());
    }
}
