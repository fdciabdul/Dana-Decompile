package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.MyReviewContract;

/* loaded from: classes5.dex */
public final class MyReviewModule_ProvideMyReviewViewFactory implements Factory<MyReviewContract.View> {
    private final MyReviewModule KClassImpl$Data$declaredNonStaticMembers$2;

    private MyReviewModule_ProvideMyReviewViewFactory(MyReviewModule myReviewModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myReviewModule;
    }

    public static MyReviewModule_ProvideMyReviewViewFactory getAuthRequestContext(MyReviewModule myReviewModule) {
        return new MyReviewModule_ProvideMyReviewViewFactory(myReviewModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyReviewContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext());
    }
}
