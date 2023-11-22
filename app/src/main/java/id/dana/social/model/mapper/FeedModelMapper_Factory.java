package id.dana.social.model.mapper;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedModelMapper_Factory implements Factory<FeedModelMapper> {
    private final Provider<ReactionCountModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;

    private FeedModelMapper_Factory(Provider<Context> provider, Provider<ReactionCountModelMapper> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static FeedModelMapper_Factory PlaceComponentResult(Provider<Context> provider, Provider<ReactionCountModelMapper> provider2) {
        return new FeedModelMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedModelMapper(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
