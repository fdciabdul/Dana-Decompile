package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveFeedsSharingLastCheckedState_Factory implements Factory<SaveFeedsSharingLastCheckedState> {
    private final Provider<FeedsShareRepository> BuiltInFictitiousFunctionClassFactory;

    private SaveFeedsSharingLastCheckedState_Factory(Provider<FeedsShareRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SaveFeedsSharingLastCheckedState_Factory MyBillsEntityDataFactory(Provider<FeedsShareRepository> provider) {
        return new SaveFeedsSharingLastCheckedState_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveFeedsSharingLastCheckedState(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
