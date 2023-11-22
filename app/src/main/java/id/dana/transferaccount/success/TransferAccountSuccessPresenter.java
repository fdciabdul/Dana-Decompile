package id.dana.transferaccount.success;

import id.dana.base.AbstractContractKt;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.transferaccount.interactor.ClearTransferAccountCache;
import id.dana.transferaccount.success.TransferAccountSuccessContract;
import id.dana.utils.session.SessionManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/transferaccount/success/TransferAccountSuccessPresenter;", "Lid/dana/transferaccount/success/TransferAccountSuccessContract$Presenter;", "", "PlaceComponentResult", "()V", "onDestroy", "Lid/dana/domain/transferaccount/interactor/ClearTransferAccountCache;", "getAuthRequestContext", "Lid/dana/domain/transferaccount/interactor/ClearTransferAccountCache;", "Lid/dana/utils/session/SessionManager;", "Lid/dana/utils/session/SessionManager;", "Lid/dana/transferaccount/success/TransferAccountSuccessContract$View;", "MyBillsEntityDataFactory", "Lid/dana/transferaccount/success/TransferAccountSuccessContract$View;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "<init>", "(Lid/dana/domain/transferaccount/interactor/ClearTransferAccountCache;Lid/dana/utils/session/SessionManager;Lid/dana/transferaccount/success/TransferAccountSuccessContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferAccountSuccessPresenter implements TransferAccountSuccessContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final TransferAccountSuccessContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SessionManager getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ClearTransferAccountCache PlaceComponentResult;

    @Inject
    public TransferAccountSuccessPresenter(ClearTransferAccountCache clearTransferAccountCache, SessionManager sessionManager, TransferAccountSuccessContract.View view) {
        Intrinsics.checkNotNullParameter(clearTransferAccountCache, "");
        Intrinsics.checkNotNullParameter(sessionManager, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = clearTransferAccountCache;
        this.getAuthRequestContext = sessionManager;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Override // id.dana.transferaccount.success.TransferAccountSuccessContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        BaseUseCase.execute$default(this.PlaceComponentResult, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.transferaccount.success.TransferAccountSuccessPresenter$clearTransferAccountCache$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                r1.getAuthRequestContext.getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.transferaccount.success.TransferAccountSuccessPresenter$forceLogout$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TransferAccountSuccessContract.View view;
                        TransferAccountSuccessContract.View view2;
                        view = TransferAccountSuccessPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view.dismissProgress();
                        view2 = TransferAccountSuccessPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view2.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.transferaccount.success.TransferAccountSuccessPresenter$forceLogout$2
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
                        TransferAccountSuccessContract.View view;
                        TransferAccountSuccessContract.View view2;
                        Intrinsics.checkNotNullParameter(th, "");
                        view = TransferAccountSuccessPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view.dismissProgress();
                        view2 = TransferAccountSuccessPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view2.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                });
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult.dispose();
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
    }
}
