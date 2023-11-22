package id.dana.ocr;

import dagger.internal.Factory;
import id.dana.appcontainer.plugin.ocrreceipt.usecase.GetOcrSnapLimit;
import id.dana.danah5.ocrreceipt.usecase.GetOcrPreprocessingConfig;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.ocr.interactor.GetOcrFromReceipt;
import id.dana.ocr.PreprocessingAndOcrContract;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PreprocessingAndOcrPresenter_Factory implements Factory<PreprocessingAndOcrPresenter> {
    private final Provider<CompositeDisposable> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetOcrSnapLimit> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PostExecutionThread> MyBillsEntityDataFactory;
    private final Provider<GetOcrFromReceipt> PlaceComponentResult;
    private final Provider<GetOcrPreprocessingConfig> getAuthRequestContext;
    private final Provider<PreprocessingAndOcrContract.View> moveToNextValue;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PreprocessingAndOcrPresenter(this.moveToNextValue.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
