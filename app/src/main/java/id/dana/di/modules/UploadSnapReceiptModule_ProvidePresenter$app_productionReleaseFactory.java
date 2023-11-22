package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.UploadSnapReceiptContract;
import id.dana.ocr.UploadSnapReceiptPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UploadSnapReceiptModule_ProvidePresenter$app_productionReleaseFactory implements Factory<UploadSnapReceiptContract.Presenter> {
    private final Provider<UploadSnapReceiptPresenter> BuiltInFictitiousFunctionClassFactory;
    private final UploadSnapReceiptModule getAuthRequestContext;

    private UploadSnapReceiptModule_ProvidePresenter$app_productionReleaseFactory(UploadSnapReceiptModule uploadSnapReceiptModule, Provider<UploadSnapReceiptPresenter> provider) {
        this.getAuthRequestContext = uploadSnapReceiptModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static UploadSnapReceiptModule_ProvidePresenter$app_productionReleaseFactory getAuthRequestContext(UploadSnapReceiptModule uploadSnapReceiptModule, Provider<UploadSnapReceiptPresenter> provider) {
        return new UploadSnapReceiptModule_ProvidePresenter$app_productionReleaseFactory(uploadSnapReceiptModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UploadSnapReceiptContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
