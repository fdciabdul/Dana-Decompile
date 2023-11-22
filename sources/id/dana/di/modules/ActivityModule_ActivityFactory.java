package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.base.BaseActivity;

/* loaded from: classes8.dex */
public final class ActivityModule_ActivityFactory implements Factory<BaseActivity> {
    private final ActivityModule PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BaseActivity) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
