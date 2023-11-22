package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.socialshare.SocialShareContract;

/* loaded from: classes4.dex */
public final class SocialShareModule_GetViewFactory implements Factory<SocialShareContract.View> {
    private final SocialShareModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static SocialShareContract.View getAuthRequestContext(SocialShareModule socialShareModule) {
        return (SocialShareContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(socialShareModule.PlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SocialShareContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}
