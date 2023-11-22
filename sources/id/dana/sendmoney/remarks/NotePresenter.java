package id.dana.sendmoney.remarks;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.interactor.GetNoteMaxChar;
import id.dana.sendmoney.remarks.NoteContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/remarks/NotePresenter;", "Lid/dana/sendmoney/remarks/NoteContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "Lid/dana/domain/sendmoney/interactor/GetNoteMaxChar;", "Lid/dana/domain/sendmoney/interactor/GetNoteMaxChar;", "PlaceComponentResult", "Lid/dana/sendmoney/remarks/NoteContract$View;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/remarks/NoteContract$View;", "p0", "p1", "<init>", "(Lid/dana/domain/sendmoney/interactor/GetNoteMaxChar;Lid/dana/sendmoney/remarks/NoteContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotePresenter implements NoteContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final NoteContract.View getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetNoteMaxChar PlaceComponentResult;

    @Inject
    public NotePresenter(GetNoteMaxChar getNoteMaxChar, NoteContract.View view) {
        Intrinsics.checkNotNullParameter(getNoteMaxChar, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = getNoteMaxChar;
        this.getAuthRequestContext = view;
    }

    @Override // id.dana.sendmoney.remarks.NoteContract.Presenter
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.remarks.NotePresenter$getNoteMaxChar$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                NoteContract.View view;
                view = NotePresenter.this.getAuthRequestContext;
                view.BuiltInFictitiousFunctionClassFactory(i);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.remarks.NotePresenter$getNoteMaxChar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                NoteContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = NotePresenter.this.getAuthRequestContext;
                view.BuiltInFictitiousFunctionClassFactory(50);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }
}
