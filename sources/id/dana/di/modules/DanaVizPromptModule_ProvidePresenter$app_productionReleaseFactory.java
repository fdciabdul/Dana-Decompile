package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.danaviz.DanaVizPromptContract;
import id.dana.danaviz.DanaVizPromptPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaVizPromptModule_ProvidePresenter$app_productionReleaseFactory implements Factory<DanaVizPromptContract.Presenter> {
    private final Provider<DanaVizPromptPresenter> BuiltInFictitiousFunctionClassFactory;
    private final DanaVizPromptModule MyBillsEntityDataFactory;

    public static DanaVizPromptContract.Presenter BuiltInFictitiousFunctionClassFactory(DanaVizPromptModule danaVizPromptModule, DanaVizPromptPresenter danaVizPromptPresenter) {
        return (DanaVizPromptContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(danaVizPromptModule.MyBillsEntityDataFactory(danaVizPromptPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaVizPromptContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
