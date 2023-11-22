package id.dana.model;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.splitbill.SelectedPayerContract;

/* loaded from: classes5.dex */
public final class SelectedPayerModule_ProvideViewFactory implements Factory<SelectedPayerContract.View> {
    private final SelectedPayerModule MyBillsEntityDataFactory;

    private SelectedPayerModule_ProvideViewFactory(SelectedPayerModule selectedPayerModule) {
        this.MyBillsEntityDataFactory = selectedPayerModule;
    }

    public static SelectedPayerModule_ProvideViewFactory PlaceComponentResult(SelectedPayerModule selectedPayerModule) {
        return new SelectedPayerModule_ProvideViewFactory(selectedPayerModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SelectedPayerContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext());
    }
}
