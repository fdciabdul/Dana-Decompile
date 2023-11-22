package id.dana.feeds.domain.reactions.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class AddReactions_Factory implements Factory<AddReactions> {
    private final Provider<MixpanelRepository> MyBillsEntityDataFactory;
    private final Provider<FeedsReactionRepository> PlaceComponentResult;

    private AddReactions_Factory(Provider<FeedsReactionRepository> provider, Provider<MixpanelRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static AddReactions_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsReactionRepository> provider, Provider<MixpanelRepository> provider2) {
        return new AddReactions_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new AddReactions(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
    }
}
