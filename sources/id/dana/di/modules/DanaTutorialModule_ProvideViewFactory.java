package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.tutorial.TutorialContract;

/* loaded from: classes8.dex */
public final class DanaTutorialModule_ProvideViewFactory implements Factory<TutorialContract.View> {
    private final DanaTutorialModule getAuthRequestContext;

    public static TutorialContract.View getAuthRequestContext(DanaTutorialModule danaTutorialModule) {
        return (TutorialContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(danaTutorialModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TutorialContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
