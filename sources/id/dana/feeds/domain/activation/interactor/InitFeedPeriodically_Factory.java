package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes8.dex */
public final class InitFeedPeriodically_Factory implements Factory<InitFeedPeriodically> {
    private final Provider<FeedInitRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CoroutineDispatcher> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CoroutineDispatcher> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InitFeedPeriodically(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
