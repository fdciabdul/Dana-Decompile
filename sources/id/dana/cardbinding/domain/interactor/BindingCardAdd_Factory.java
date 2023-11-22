package id.dana.cardbinding.domain.interactor;

import dagger.internal.Factory;
import id.dana.cardbinding.domain.CardBindingRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class BindingCardAdd_Factory implements Factory<BindingCardAdd> {
    private final Provider<CardBindingRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private BindingCardAdd_Factory(Provider<CardBindingRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static BindingCardAdd_Factory getAuthRequestContext(Provider<CardBindingRepository> provider) {
        return new BindingCardAdd_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new BindingCardAdd(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
