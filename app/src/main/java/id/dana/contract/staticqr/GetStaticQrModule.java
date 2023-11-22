package id.dana.contract.staticqr;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes2.dex */
public class GetStaticQrModule {
    private final GetStaticQrContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetStaticQrContract.Presenter getAuthRequestContext(GetStaticQrPresenter getStaticQrPresenter) {
        return getStaticQrPresenter;
    }

    public GetStaticQrModule(GetStaticQrContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetStaticQrContract.View PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
