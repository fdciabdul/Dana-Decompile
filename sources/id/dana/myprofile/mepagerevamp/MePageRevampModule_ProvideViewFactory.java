package id.dana.myprofile.mepagerevamp;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;

/* loaded from: classes5.dex */
public final class MePageRevampModule_ProvideViewFactory implements Factory<MePageRevampContract.View> {
    private final MePageRevampModule MyBillsEntityDataFactory;

    private MePageRevampModule_ProvideViewFactory(MePageRevampModule mePageRevampModule) {
        this.MyBillsEntityDataFactory = mePageRevampModule;
    }

    public static MePageRevampModule_ProvideViewFactory getAuthRequestContext(MePageRevampModule mePageRevampModule) {
        return new MePageRevampModule_ProvideViewFactory(mePageRevampModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MePageRevampContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
