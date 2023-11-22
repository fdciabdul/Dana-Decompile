package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.splitbill.SplitBillShareQRContract;
import id.dana.splitbill.SplitBillShareQRPresenter;

@Module
/* loaded from: classes4.dex */
public class SplitBillShareQRModule {
    private final SplitBillShareQRContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SplitBillShareQRContract.Presenter MyBillsEntityDataFactory(SplitBillShareQRPresenter splitBillShareQRPresenter) {
        return splitBillShareQRPresenter;
    }

    public SplitBillShareQRModule(SplitBillShareQRContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SplitBillShareQRContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }
}
