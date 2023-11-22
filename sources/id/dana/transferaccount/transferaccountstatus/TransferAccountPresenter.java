package id.dana.transferaccount.transferaccountstatus;

import id.dana.base.AbstractContractKt;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.transferaccount.StatusTransferAccount;
import id.dana.domain.transferaccount.TransferAccountStatus;
import id.dana.domain.transferaccount.interactor.GetTransferAccountStatus;
import id.dana.transferaccount.tracker.TransferAccountTrackerImpl;
import id.dana.transferaccount.transferaccountstatus.TransferAccountContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/transferaccount/transferaccountstatus/TransferAccountPresenter;", "Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "Lid/dana/domain/transferaccount/interactor/GetTransferAccountStatus;", "MyBillsEntityDataFactory", "Lid/dana/domain/transferaccount/interactor/GetTransferAccountStatus;", "PlaceComponentResult", "", "J", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/transferaccount/tracker/TransferAccountTrackerImpl;", "Lid/dana/transferaccount/tracker/TransferAccountTrackerImpl;", "Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$View;", "p0", "p1", "p2", "<init>", "(Lid/dana/domain/transferaccount/interactor/GetTransferAccountStatus;Lid/dana/transferaccount/tracker/TransferAccountTrackerImpl;Lid/dana/transferaccount/transferaccountstatus/TransferAccountContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferAccountPresenter implements TransferAccountContract.Presenter {
    private final TransferAccountContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetTransferAccountStatus PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final TransferAccountTrackerImpl getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private long KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[StatusTransferAccount.values().length];
            iArr[StatusTransferAccount.PENDING.ordinal()] = 1;
            iArr[StatusTransferAccount.SUCCESS.ordinal()] = 2;
            iArr[StatusTransferAccount.FAILED.ordinal()] = 3;
            getAuthRequestContext = iArr;
        }
    }

    @Inject
    public TransferAccountPresenter(GetTransferAccountStatus getTransferAccountStatus, TransferAccountTrackerImpl transferAccountTrackerImpl, TransferAccountContract.View view) {
        Intrinsics.checkNotNullParameter(getTransferAccountStatus, "");
        Intrinsics.checkNotNullParameter(transferAccountTrackerImpl, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = getTransferAccountStatus;
        this.getAuthRequestContext = transferAccountTrackerImpl;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Override // id.dana.transferaccount.transferaccountstatus.TransferAccountContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new TransferAccountPresenter$getTransferAccountStatus$1(this), new Function1<Throwable, Unit>() { // from class: id.dana.transferaccount.transferaccountstatus.TransferAccountPresenter$getTransferAccountStatus$2
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
                TransferAccountContract.View view;
                TransferAccountTrackerImpl transferAccountTrackerImpl;
                Intrinsics.checkNotNullParameter(th, "");
                view = TransferAccountPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
                transferAccountTrackerImpl = TransferAccountPresenter.this.getAuthRequestContext;
                int authRequestContext = (int) TransferAccountPresenter.getAuthRequestContext(TransferAccountPresenter.this);
                String message = th.getMessage();
                transferAccountTrackerImpl.BuiltInFictitiousFunctionClassFactory(false, authRequestContext, message != null ? message : "");
                TransferAccountPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ long getAuthRequestContext(TransferAccountPresenter transferAccountPresenter) {
        return (System.currentTimeMillis() - transferAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2) / 1000;
    }

    public static final /* synthetic */ void getAuthRequestContext(TransferAccountPresenter transferAccountPresenter, TransferAccountStatus transferAccountStatus) {
        StatusTransferAccount value = StatusTransferAccount.INSTANCE.getValue(transferAccountStatus.getStatus());
        int i = value == null ? -1 : WhenMappings.getAuthRequestContext[value.ordinal()];
        if (i == 1) {
            transferAccountPresenter.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
            return;
        }
        if (i == 2) {
            transferAccountPresenter.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(true, (int) ((System.currentTimeMillis() - transferAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2) / 1000), "");
            transferAccountPresenter.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            transferAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
        } else if (i == 3) {
            if (StatusTransferAccount.INSTANCE.getValue(transferAccountStatus.getDeleteUser()) == StatusTransferAccount.FAILED) {
                transferAccountPresenter.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            } else if (StatusTransferAccount.INSTANCE.getValue(transferAccountStatus.getBalanceTransfer()) == StatusTransferAccount.FAILED) {
                transferAccountPresenter.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
            } else {
                transferAccountPresenter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            TransferAccountTrackerImpl transferAccountTrackerImpl = transferAccountPresenter.getAuthRequestContext;
            int currentTimeMillis = (int) ((System.currentTimeMillis() - transferAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2) / 1000);
            String errorMessage = transferAccountStatus.getErrorMessage();
            transferAccountTrackerImpl.BuiltInFictitiousFunctionClassFactory(false, currentTimeMillis, errorMessage != null ? errorMessage : "");
            transferAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
        }
    }
}
