package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.lazada.LazadaGuideContract;
import id.dana.lazada.LazadaGuidePresenter;

@Module
/* loaded from: classes4.dex */
public class LazadaModule {
    private LazadaGuideContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public LazadaGuideContract.Presenter getAuthRequestContext(LazadaGuidePresenter lazadaGuidePresenter) {
        return lazadaGuidePresenter;
    }

    public LazadaModule(LazadaGuideContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public LazadaGuideContract.View MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
