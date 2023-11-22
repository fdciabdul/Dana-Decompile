package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.MyFeedsContract;

/* loaded from: classes5.dex */
public final class MyFeedsModule_ProvideMyFeedsViewFactory implements Factory<MyFeedsContract.View> {
    private final MyFeedsModule BuiltInFictitiousFunctionClassFactory;

    private MyFeedsModule_ProvideMyFeedsViewFactory(MyFeedsModule myFeedsModule) {
        this.BuiltInFictitiousFunctionClassFactory = myFeedsModule;
    }

    public static MyFeedsModule_ProvideMyFeedsViewFactory BuiltInFictitiousFunctionClassFactory(MyFeedsModule myFeedsModule) {
        return new MyFeedsModule_ProvideMyFeedsViewFactory(myFeedsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyFeedsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory());
    }
}
