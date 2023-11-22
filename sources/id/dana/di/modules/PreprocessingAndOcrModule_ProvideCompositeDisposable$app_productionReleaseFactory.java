package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.disposables.CompositeDisposable;

/* loaded from: classes8.dex */
public final class PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory implements Factory<CompositeDisposable> {
    private final PreprocessingAndOcrModule MyBillsEntityDataFactory;

    private PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory(PreprocessingAndOcrModule preprocessingAndOcrModule) {
        this.MyBillsEntityDataFactory = preprocessingAndOcrModule;
    }

    public static PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(PreprocessingAndOcrModule preprocessingAndOcrModule) {
        return new PreprocessingAndOcrModule_ProvideCompositeDisposable$app_productionReleaseFactory(preprocessingAndOcrModule);
    }

    public static CompositeDisposable MyBillsEntityDataFactory(PreprocessingAndOcrModule preprocessingAndOcrModule) {
        return (CompositeDisposable) Preconditions.BuiltInFictitiousFunctionClassFactory(preprocessingAndOcrModule.PlaceComponentResult());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CompositeDisposable) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult());
    }
}
