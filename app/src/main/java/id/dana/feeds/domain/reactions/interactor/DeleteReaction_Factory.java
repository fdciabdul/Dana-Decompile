package id.dana.feeds.domain.reactions.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeleteReaction_Factory implements Factory<DeleteReaction> {
    private final Provider<FeedsReactionRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<MixpanelRepository> PlaceComponentResult;

    private DeleteReaction_Factory(Provider<FeedsReactionRepository> provider, Provider<MixpanelRepository> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static DeleteReaction_Factory MyBillsEntityDataFactory(Provider<FeedsReactionRepository> provider, Provider<MixpanelRepository> provider2) {
        return new DeleteReaction_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteReaction(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
