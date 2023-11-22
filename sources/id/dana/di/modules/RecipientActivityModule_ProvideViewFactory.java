package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.RecipientContract;

/* loaded from: classes4.dex */
public final class RecipientActivityModule_ProvideViewFactory implements Factory<RecipientContract.View> {
    private final RecipientActivityModule KClassImpl$Data$declaredNonStaticMembers$2;

    private RecipientActivityModule_ProvideViewFactory(RecipientActivityModule recipientActivityModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipientActivityModule;
    }

    public static RecipientActivityModule_ProvideViewFactory getAuthRequestContext(RecipientActivityModule recipientActivityModule) {
        return new RecipientActivityModule_ProvideViewFactory(recipientActivityModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RecipientContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
    }
}
