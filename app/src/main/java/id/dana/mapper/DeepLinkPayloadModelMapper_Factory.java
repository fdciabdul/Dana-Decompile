package id.dana.mapper;

import dagger.internal.Factory;
import id.dana.oauth.mapper.OauthParamsModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeepLinkPayloadModelMapper_Factory implements Factory<DeepLinkPayloadModelMapper> {
    private final Provider<OauthParamsModelMapper> PlaceComponentResult;

    private DeepLinkPayloadModelMapper_Factory(Provider<OauthParamsModelMapper> provider) {
        this.PlaceComponentResult = provider;
    }

    public static DeepLinkPayloadModelMapper_Factory BuiltInFictitiousFunctionClassFactory(Provider<OauthParamsModelMapper> provider) {
        return new DeepLinkPayloadModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeepLinkPayloadModelMapper(this.PlaceComponentResult.get());
    }
}
