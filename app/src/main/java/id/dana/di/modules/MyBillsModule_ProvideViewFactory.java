package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.mybills.di.MyBillsContract;

/* loaded from: classes4.dex */
public final class MyBillsModule_ProvideViewFactory implements Factory<MyBillsContract.View> {
    private final MyBillsModule PlaceComponentResult;

    private MyBillsModule_ProvideViewFactory(MyBillsModule myBillsModule) {
        this.PlaceComponentResult = myBillsModule;
    }

    public static MyBillsModule_ProvideViewFactory MyBillsEntityDataFactory(MyBillsModule myBillsModule) {
        return new MyBillsModule_ProvideViewFactory(myBillsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyBillsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
