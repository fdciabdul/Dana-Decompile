package id.dana.feeds.domain.activation.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes5.dex */
public final class SetDeviceFeedFeatureSwitch_Factory implements Factory<SetDeviceFeedFeatureSwitch> {
    private final Provider<CoroutineDispatcher> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedInitRepository> MyBillsEntityDataFactory;
    private final Provider<CoroutineDispatcher> getAuthRequestContext;

    private SetDeviceFeedFeatureSwitch_Factory(Provider<CoroutineDispatcher> provider, Provider<CoroutineDispatcher> provider2, Provider<FeedInitRepository> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static SetDeviceFeedFeatureSwitch_Factory BuiltInFictitiousFunctionClassFactory(Provider<CoroutineDispatcher> provider, Provider<CoroutineDispatcher> provider2, Provider<FeedInitRepository> provider3) {
        return new SetDeviceFeedFeatureSwitch_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SetDeviceFeedFeatureSwitch(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
