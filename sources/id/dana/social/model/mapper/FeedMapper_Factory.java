package id.dana.social.model.mapper;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedMapper_Factory implements Factory<FeedMapper> {
    private final Provider<Context> PlaceComponentResult;

    private FeedMapper_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static FeedMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider) {
        return new FeedMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedMapper(this.PlaceComponentResult.get());
    }
}
