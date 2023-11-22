package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.oauth.InputNameContract;

/* loaded from: classes4.dex */
public final class InputNameModule_ProvideView$app_productionReleaseFactory implements Factory<InputNameContract.View> {
    private final InputNameModule MyBillsEntityDataFactory;

    public static InputNameContract.View PlaceComponentResult(InputNameModule inputNameModule) {
        return (InputNameContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(inputNameModule.getKClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (InputNameContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
