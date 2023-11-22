package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.SocialProfileContract;

/* loaded from: classes5.dex */
public final class SocialProfileModule_ProvideSocialProfileViewFactory implements Factory<SocialProfileContract.View> {
    private final SocialProfileModule getAuthRequestContext;

    public static SocialProfileContract.View KClassImpl$Data$declaredNonStaticMembers$2(SocialProfileModule socialProfileModule) {
        return (SocialProfileContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(socialProfileModule.getBuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SocialProfileContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getBuiltInFictitiousFunctionClassFactory());
    }
}
