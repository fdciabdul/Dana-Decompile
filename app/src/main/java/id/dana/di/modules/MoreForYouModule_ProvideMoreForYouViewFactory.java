package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.moreforyou.MoreForYouContract;

/* loaded from: classes4.dex */
public final class MoreForYouModule_ProvideMoreForYouViewFactory implements Factory<MoreForYouContract.View> {
    private final MoreForYouModule KClassImpl$Data$declaredNonStaticMembers$2;

    private MoreForYouModule_ProvideMoreForYouViewFactory(MoreForYouModule moreForYouModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moreForYouModule;
    }

    public static MoreForYouModule_ProvideMoreForYouViewFactory BuiltInFictitiousFunctionClassFactory(MoreForYouModule moreForYouModule) {
        return new MoreForYouModule_ProvideMoreForYouViewFactory(moreForYouModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MoreForYouContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
