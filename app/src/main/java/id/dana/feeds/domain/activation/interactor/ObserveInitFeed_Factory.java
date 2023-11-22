package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes2.dex */
public final class ObserveInitFeed_Factory implements Factory<ObserveInitFeed> {
    private final Provider<CoroutineDispatcher> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PostExecutionThread> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedInitRepository> MyBillsEntityDataFactory;
    private final Provider<ThreadExecutor> PlaceComponentResult;
    private final Provider<CoroutineDispatcher> getAuthRequestContext;

    private ObserveInitFeed_Factory(Provider<CoroutineDispatcher> provider, Provider<CoroutineDispatcher> provider2, Provider<ThreadExecutor> provider3, Provider<PostExecutionThread> provider4, Provider<FeedInitRepository> provider5) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.PlaceComponentResult = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static ObserveInitFeed_Factory BuiltInFictitiousFunctionClassFactory(Provider<CoroutineDispatcher> provider, Provider<CoroutineDispatcher> provider2, Provider<ThreadExecutor> provider3, Provider<PostExecutionThread> provider4, Provider<FeedInitRepository> provider5) {
        return new ObserveInitFeed_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ObserveInitFeed(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
