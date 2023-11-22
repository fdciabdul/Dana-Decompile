package id.dana.ocr;

import dagger.internal.Factory;
import id.dana.domain.loyalty.interactor.GetReceiptData;
import id.dana.domain.loyalty.interactor.RemoveReceiptData;
import id.dana.domain.loyalty.interactor.SaveReceiptData;
import id.dana.domain.loyalty.interactor.SubmitSnapReceipt;
import id.dana.ocr.UploadSnapReceiptContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class UploadSnapReceiptPresenter_Factory implements Factory<UploadSnapReceiptPresenter> {
    private final Provider<UploadSnapReceiptContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SubmitSnapReceipt> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetReceiptData> MyBillsEntityDataFactory;
    private final Provider<SaveReceiptData> PlaceComponentResult;
    private final Provider<RemoveReceiptData> getAuthRequestContext;

    private UploadSnapReceiptPresenter_Factory(Provider<UploadSnapReceiptContract.View> provider, Provider<SubmitSnapReceipt> provider2, Provider<SaveReceiptData> provider3, Provider<GetReceiptData> provider4, Provider<RemoveReceiptData> provider5) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.PlaceComponentResult = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static UploadSnapReceiptPresenter_Factory getAuthRequestContext(Provider<UploadSnapReceiptContract.View> provider, Provider<SubmitSnapReceipt> provider2, Provider<SaveReceiptData> provider3, Provider<GetReceiptData> provider4, Provider<RemoveReceiptData> provider5) {
        return new UploadSnapReceiptPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UploadSnapReceiptPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
