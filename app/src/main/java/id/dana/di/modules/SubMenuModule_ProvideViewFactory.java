package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.SettingMoreContract;

/* loaded from: classes4.dex */
public final class SubMenuModule_ProvideViewFactory implements Factory<SettingMoreContract.View> {
    private final SubMenuModule getAuthRequestContext;

    public static SettingMoreContract.View KClassImpl$Data$declaredNonStaticMembers$2(SubMenuModule subMenuModule) {
        return (SettingMoreContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(subMenuModule.getAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SettingMoreContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext());
    }
}
