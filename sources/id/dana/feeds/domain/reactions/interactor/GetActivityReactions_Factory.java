package id.dana.feeds.domain.reactions.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetActivityReactions_Factory implements Factory<GetActivityReactions> {
    private final Provider<MixpanelRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsReactionRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetActivityReactions(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
