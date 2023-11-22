package id.dana.data.saving.model;

import id.dana.domain.saving.model.SavingGoalWithdrawMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/saving/model/WithdrawMethodView;", "Lid/dana/domain/saving/model/SavingGoalWithdrawMethod;", "toSavingGoalWithdrawMethodView", "(Lid/dana/data/saving/model/WithdrawMethodView;)Lid/dana/domain/saving/model/SavingGoalWithdrawMethod;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WithdrawMethodViewKt {
    public static final SavingGoalWithdrawMethod toSavingGoalWithdrawMethodView(WithdrawMethodView withdrawMethodView) {
        Intrinsics.checkNotNullParameter(withdrawMethodView, "");
        String withdrawMethod = withdrawMethodView.getWithdrawMethod();
        boolean enableWithdrawSaveAccount = withdrawMethodView.getEnableWithdrawSaveAccount();
        boolean success = withdrawMethodView.getSuccess();
        String errorCode = withdrawMethodView.getErrorCode();
        String str = errorCode == null ? "" : errorCode;
        String errorMsg = withdrawMethodView.getErrorMsg();
        return new SavingGoalWithdrawMethod(withdrawMethod, enableWithdrawSaveAccount, success, str, errorMsg == null ? "" : errorMsg);
    }
}
