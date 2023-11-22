package id.dana.social.model.mapper;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedNotificationMapper_Factory implements Factory<FeedNotificationMapper> {
    private final Provider<FeedModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;

    private FeedNotificationMapper_Factory(Provider<FeedModelMapper> provider, Provider<Context> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static FeedNotificationMapper_Factory getAuthRequestContext(Provider<FeedModelMapper> provider, Provider<Context> provider2) {
        return new FeedNotificationMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedNotificationMapper(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
