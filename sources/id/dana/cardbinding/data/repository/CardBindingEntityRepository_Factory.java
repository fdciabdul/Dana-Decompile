package id.dana.cardbinding.data.repository;

import dagger.internal.Factory;
import id.dana.cardbinding.data.repository.source.CardBindingEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CardBindingEntityRepository_Factory implements Factory<CardBindingEntityRepository> {
    private final Provider<CardBindingEntityDataFactory> getAuthRequestContext;

    private CardBindingEntityRepository_Factory(Provider<CardBindingEntityDataFactory> provider) {
        this.getAuthRequestContext = provider;
    }

    public static CardBindingEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<CardBindingEntityDataFactory> provider) {
        return new CardBindingEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CardBindingEntityRepository(this.getAuthRequestContext.get());
    }
}
