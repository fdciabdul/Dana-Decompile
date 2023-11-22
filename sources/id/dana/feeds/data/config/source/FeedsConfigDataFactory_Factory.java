package id.dana.feeds.data.config.source;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsConfigDataFactory_Factory implements Factory<FeedsConfigDataFactory> {
    private final Provider<SplitFacade> KClassImpl$Data$declaredNonStaticMembers$2;

    private FeedsConfigDataFactory_Factory(Provider<SplitFacade> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static FeedsConfigDataFactory_Factory getAuthRequestContext(Provider<SplitFacade> provider) {
        return new FeedsConfigDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsConfigDataFactory(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
