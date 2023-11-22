package id.dana.data.saving.mapper;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.saving.repository.source.network.response.GoalTopUpInitResult;
import id.dana.domain.saving.model.SavingTopUpInit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;", "Lid/dana/domain/saving/model/SavingTopUpInit;", "toSavingTopUpInit", "(Lid/dana/data/saving/repository/source/network/response/GoalTopUpInitResult;)Lid/dana/domain/saving/model/SavingTopUpInit;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavingTopUpInitMapperKt {
    public static final SavingTopUpInit toSavingTopUpInit(GoalTopUpInitResult goalTopUpInitResult) {
        Intrinsics.checkNotNullParameter(goalTopUpInitResult, "");
        return new SavingTopUpInit(MoneyViewEntityMapperKt.toMoneyView(goalTopUpInitResult.getMaxAmount()), MoneyViewEntityMapperKt.toMoneyView(goalTopUpInitResult.getCurrentAmount()), MoneyViewEntityMapperKt.toMoneyView(goalTopUpInitResult.getTargetAmount()));
    }
}
