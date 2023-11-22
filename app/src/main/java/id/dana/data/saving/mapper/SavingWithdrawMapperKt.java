package id.dana.data.saving.mapper;

import id.dana.data.saving.model.SavingViewKt;
import id.dana.data.saving.model.WithdrawMethodView;
import id.dana.data.saving.model.WithdrawMethodViewKt;
import id.dana.data.saving.repository.source.network.response.SavingWithdrawInitEntityResult;
import id.dana.domain.saving.model.SavingWithdrawInitResult;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;", "Lid/dana/domain/saving/model/SavingWithdrawInitResult;", "toSavingWithdrawInitResult", "(Lid/dana/data/saving/repository/source/network/response/SavingWithdrawInitEntityResult;)Lid/dana/domain/saving/model/SavingWithdrawInitResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavingWithdrawMapperKt {
    public static final SavingWithdrawInitResult toSavingWithdrawInitResult(SavingWithdrawInitEntityResult savingWithdrawInitEntityResult) {
        Intrinsics.checkNotNullParameter(savingWithdrawInitEntityResult, "");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = savingWithdrawInitEntityResult.getWithdrawMethodViews().iterator();
        while (it.hasNext()) {
            arrayList.add(WithdrawMethodViewKt.toSavingGoalWithdrawMethodView((WithdrawMethodView) it.next()));
        }
        return new SavingWithdrawInitResult(SavingViewKt.toSavingGoalView(savingWithdrawInitEntityResult.getSavingView()), arrayList);
    }
}
