package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.MyProfileContract;

/* loaded from: classes4.dex */
public final class MyProfileModule_ProvideViewFactory implements Factory<MyProfileContract.View> {
    private final MyProfileModule PlaceComponentResult;

    private MyProfileModule_ProvideViewFactory(MyProfileModule myProfileModule) {
        this.PlaceComponentResult = myProfileModule;
    }

    public static MyProfileModule_ProvideViewFactory KClassImpl$Data$declaredNonStaticMembers$2(MyProfileModule myProfileModule) {
        return new MyProfileModule_ProvideViewFactory(myProfileModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyProfileContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
    }
}
