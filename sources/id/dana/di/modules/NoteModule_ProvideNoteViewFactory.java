package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.remarks.NoteContract;

/* loaded from: classes4.dex */
public final class NoteModule_ProvideNoteViewFactory implements Factory<NoteContract.View> {
    private final NoteModule PlaceComponentResult;

    private NoteModule_ProvideNoteViewFactory(NoteModule noteModule) {
        this.PlaceComponentResult = noteModule;
    }

    public static NoteModule_ProvideNoteViewFactory PlaceComponentResult(NoteModule noteModule) {
        return new NoteModule_ProvideNoteViewFactory(noteModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NoteContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
