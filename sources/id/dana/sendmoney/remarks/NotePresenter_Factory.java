package id.dana.sendmoney.remarks;

import dagger.internal.Factory;
import id.dana.domain.sendmoney.interactor.GetNoteMaxChar;
import id.dana.sendmoney.remarks.NoteContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class NotePresenter_Factory implements Factory<NotePresenter> {
    private final Provider<GetNoteMaxChar> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<NoteContract.View> MyBillsEntityDataFactory;

    private NotePresenter_Factory(Provider<GetNoteMaxChar> provider, Provider<NoteContract.View> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static NotePresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetNoteMaxChar> provider, Provider<NoteContract.View> provider2) {
        return new NotePresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NotePresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
