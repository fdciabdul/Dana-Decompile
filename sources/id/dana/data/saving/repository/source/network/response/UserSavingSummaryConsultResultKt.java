package id.dana.data.saving.repository.source.network.response;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.saving.model.SavingView;
import id.dana.data.saving.model.SavingViewKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.domain.saving.model.SavingSummary;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;", "Lid/dana/domain/saving/model/SavingSummary;", "toSavingSummary", "(Lid/dana/data/saving/repository/source/network/response/UserSavingSummaryConsultResult;)Lid/dana/domain/saving/model/SavingSummary;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserSavingSummaryConsultResultKt {
    public static final SavingSummary toSavingSummary(UserSavingSummaryConsultResult userSavingSummaryConsultResult) {
        List<SavingGoalView> emptyList;
        Intrinsics.checkNotNullParameter(userSavingSummaryConsultResult, "");
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(userSavingSummaryConsultResult.getSavingBalanceAmount());
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(userSavingSummaryConsultResult.getMaxSavingAmount());
        long maxSavingCount = userSavingSummaryConsultResult.getMaxSavingCount();
        MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(userSavingSummaryConsultResult.getRemainingAmount());
        long remainingCount = userSavingSummaryConsultResult.getRemainingCount();
        List<SavingView> savingViews = userSavingSummaryConsultResult.getSavingViews();
        if (savingViews == null || (emptyList = SavingViewKt.toSortedSavingViews(savingViews)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        return new SavingSummary(moneyView, moneyView2, maxSavingCount, null, null, null, moneyView3, remainingCount, emptyList, userSavingSummaryConsultResult.getHasNext(), 56, null);
    }
}
