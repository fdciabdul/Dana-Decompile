package id.dana.feeds.domain.reactions.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetReactions_Factory implements Factory<GetReactions> {
    private final Provider<FeedsReactionRepository> PlaceComponentResult;

    private GetReactions_Factory(Provider<FeedsReactionRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetReactions_Factory PlaceComponentResult(Provider<FeedsReactionRepository> provider) {
        return new GetReactions_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetReactions(this.PlaceComponentResult.get());
    }
}
