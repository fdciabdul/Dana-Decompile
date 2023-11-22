package id.dana.savings;

import android.content.Context;
import id.dana.R;
import id.dana.core.ui.model.UiTextModel;
import id.dana.di.PerActivity;
import id.dana.domain.saving.interactor.GetWithdrawOption;
import id.dana.domain.saving.interactor.InitSavingWithdraw;
import id.dana.domain.saving.model.SavingGoalWithdrawMethod;
import id.dana.domain.saving.model.SavingWithdrawInitResult;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.savings.contract.WithdrawSavingContract;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0014\u0010\n\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013"}, d2 = {"Lid/dana/savings/WithdrawSavingPresenter;", "Lid/dana/savings/contract/WithdrawSavingContract$Presenter;", "", "onDestroy", "()V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "MyBillsEntityDataFactory", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "getAuthRequestContext", "Lid/dana/domain/saving/interactor/GetWithdrawOption;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/saving/interactor/GetWithdrawOption;", "Lid/dana/domain/saving/interactor/InitSavingWithdraw;", "Lid/dana/domain/saving/interactor/InitSavingWithdraw;", "Lid/dana/savings/contract/WithdrawSavingContract$View;", "Lid/dana/savings/contract/WithdrawSavingContract$View;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/savings/contract/WithdrawSavingContract$View;Landroid/content/Context;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;Lid/dana/domain/saving/interactor/GetWithdrawOption;Lid/dana/domain/saving/interactor/InitSavingWithdraw;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class WithdrawSavingPresenter implements WithdrawSavingContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final InitSavingWithdraw PlaceComponentResult;
    public final GetWithdrawOption KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetUserInfoWithKyc getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final WithdrawSavingContract.View MyBillsEntityDataFactory;

    @Inject
    public WithdrawSavingPresenter(WithdrawSavingContract.View view, Context context, GetUserInfoWithKyc getUserInfoWithKyc, GetWithdrawOption getWithdrawOption, InitSavingWithdraw initSavingWithdraw) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        Intrinsics.checkNotNullParameter(getWithdrawOption, "");
        Intrinsics.checkNotNullParameter(initSavingWithdraw, "");
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = getUserInfoWithKyc;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getWithdrawOption;
        this.PlaceComponentResult = initSavingWithdraw;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ SavingGoalWithdrawMethod BuiltInFictitiousFunctionClassFactory(SavingWithdrawInitResult savingWithdrawInitResult, String str) {
        Object obj;
        Iterator<T> it = savingWithdrawInitResult.getSavingGoalWithdrawMethods().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((SavingGoalWithdrawMethod) obj).getWithdrawMethod(), str)) {
                break;
            }
        }
        SavingGoalWithdrawMethod savingGoalWithdrawMethod = (SavingGoalWithdrawMethod) obj;
        return savingGoalWithdrawMethod == null ? new SavingGoalWithdrawMethod("", false, false, "", "") : savingGoalWithdrawMethod;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Object[]] */
    public static final /* synthetic */ UiTextModel KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        if (th instanceof NoInternetConnectionException) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            return new UiTextModel.DynamicString(message);
        }
        ?? r2 = 0;
        return new UiTextModel.StringResource(R.string.saving_unable_to_withdraw_error_message, r2, 2, r2);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WithdrawSavingPresenter withdrawSavingPresenter, UiTextModel uiTextModel, Throwable th) {
        withdrawSavingPresenter.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(th, "dana.saving.withdraw.init", uiTextModel, "Goals Withdraw Init");
        withdrawSavingPresenter.MyBillsEntityDataFactory.MyBillsEntityDataFactory(uiTextModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void getAuthRequestContext(WithdrawSavingPresenter withdrawSavingPresenter, UiTextModel uiTextModel) {
        withdrawSavingPresenter.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(null, "dana.saving.withdraw.init", uiTextModel, "Goals Withdraw Init");
        withdrawSavingPresenter.MyBillsEntityDataFactory.MyBillsEntityDataFactory(uiTextModel);
    }
}
