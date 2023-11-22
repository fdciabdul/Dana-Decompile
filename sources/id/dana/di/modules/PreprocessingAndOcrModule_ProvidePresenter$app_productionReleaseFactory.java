package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.ocr.PreprocessingAndOcrContract;
import id.dana.ocr.PreprocessingAndOcrPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class PreprocessingAndOcrModule_ProvidePresenter$app_productionReleaseFactory implements Factory<PreprocessingAndOcrContract.Presenter> {
    private final PreprocessingAndOcrModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PreprocessingAndOcrPresenter> MyBillsEntityDataFactory;

    public static PreprocessingAndOcrContract.Presenter PlaceComponentResult(PreprocessingAndOcrModule preprocessingAndOcrModule, PreprocessingAndOcrPresenter preprocessingAndOcrPresenter) {
        return (PreprocessingAndOcrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(preprocessingAndOcrModule.MyBillsEntityDataFactory(preprocessingAndOcrPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreprocessingAndOcrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
