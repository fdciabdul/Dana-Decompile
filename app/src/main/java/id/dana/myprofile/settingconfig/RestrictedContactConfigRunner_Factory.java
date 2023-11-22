package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.feeds.domain.activation.FeedInitRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RestrictedContactConfigRunner_Factory implements Factory<RestrictedContactConfigRunner> {
    private final Provider<FeedInitRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> PlaceComponentResult;

    private RestrictedContactConfigRunner_Factory(Provider<FeedInitRepository> provider, Provider<Context> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static RestrictedContactConfigRunner_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedInitRepository> provider, Provider<Context> provider2) {
        return new RestrictedContactConfigRunner_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RestrictedContactConfigRunner(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
