package id.dana.savings.mapper;

import id.dana.domain.saving.model.SavingTopUpInit;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.savings.model.SavingTopUpInitModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/saving/model/SavingTopUpInit;", "Lid/dana/savings/model/SavingTopUpInitModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/saving/model/SavingTopUpInit;)Lid/dana/savings/model/SavingTopUpInitModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingTopUpInitMapperKt {
    public static final SavingTopUpInitModel KClassImpl$Data$declaredNonStaticMembers$2(SavingTopUpInit savingTopUpInit) {
        Intrinsics.checkNotNullParameter(savingTopUpInit, "");
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult = MoneyViewModel.Companion.PlaceComponentResult(savingTopUpInit.getMaxAmount());
        MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
        MoneyViewModel PlaceComponentResult2 = MoneyViewModel.Companion.PlaceComponentResult(savingTopUpInit.getCurrentAmount());
        MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
        return new SavingTopUpInitModel(PlaceComponentResult, PlaceComponentResult2, MoneyViewModel.Companion.PlaceComponentResult(savingTopUpInit.getTargetAmount()));
    }
}
