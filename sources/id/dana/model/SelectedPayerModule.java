package id.dana.model;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.richview.splitbill.SelectedPayerContract;
import id.dana.richview.splitbill.SelectedPayerPresenter;

@Module
/* loaded from: classes5.dex */
public class SelectedPayerModule {
    private final SelectedPayerContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SelectedPayerContract.Presenter getAuthRequestContext(SelectedPayerPresenter selectedPayerPresenter) {
        return selectedPayerPresenter;
    }

    public SelectedPayerModule(SelectedPayerContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SelectedPayerContract.View getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
