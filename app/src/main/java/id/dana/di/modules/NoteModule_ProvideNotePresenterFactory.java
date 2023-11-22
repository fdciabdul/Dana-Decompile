package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.remarks.NoteContract;
import id.dana.sendmoney.remarks.NotePresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class NoteModule_ProvideNotePresenterFactory implements Factory<NoteContract.Presenter> {
    private final NoteModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<NotePresenter> KClassImpl$Data$declaredNonStaticMembers$2;

    private NoteModule_ProvideNotePresenterFactory(NoteModule noteModule, Provider<NotePresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = noteModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static NoteModule_ProvideNotePresenterFactory getAuthRequestContext(NoteModule noteModule, Provider<NotePresenter> provider) {
        return new NoteModule_ProvideNotePresenterFactory(noteModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NoteContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
