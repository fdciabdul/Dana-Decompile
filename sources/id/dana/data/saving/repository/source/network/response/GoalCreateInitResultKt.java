package id.dana.data.saving.repository.source.network.response;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.saving.model.SavingCreateInit;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;", "Lid/dana/domain/saving/model/SavingCreateInit;", "toSavingCreateInit", "(Lid/dana/data/saving/repository/source/network/response/GoalCreateInitResult;)Lid/dana/domain/saving/model/SavingCreateInit;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GoalCreateInitResultKt {
    public static final SavingCreateInit toSavingCreateInit(GoalCreateInitResult goalCreateInitResult) {
        Intrinsics.checkNotNullParameter(goalCreateInitResult, "");
        if (goalCreateInitResult.getCategoryCodes() == null) {
            throw new Exception(goalCreateInitResult.errorCode);
        }
        return new SavingCreateInit(goalCreateInitResult.getCategoryCodes(), new ArrayList(), MoneyViewEntityMapperKt.toMoneyView(goalCreateInitResult.getMaxTargetAmount()), null, null, null, 56, null);
    }
}
