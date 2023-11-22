package id.dana.savings.mapper;

import id.dana.domain.saving.model.SavingUpdateInit;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.savings.model.SavingCategoryModel;
import id.dana.savings.model.SavingCategoryModelKt;
import id.dana.savings.model.SavingUpdateInitModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/saving/model/SavingUpdateInit;", "Lid/dana/savings/model/SavingUpdateInitModel;", "getAuthRequestContext", "(Lid/dana/domain/saving/model/SavingUpdateInit;)Lid/dana/savings/model/SavingUpdateInitModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingUpdateInitModelMapperKt {
    public static final SavingUpdateInitModel getAuthRequestContext(SavingUpdateInit savingUpdateInit) {
        Intrinsics.checkNotNullParameter(savingUpdateInit, "");
        List<String> categoryCodes = savingUpdateInit.getCategoryCodes();
        List<SavingCategoryModel> KClassImpl$Data$declaredNonStaticMembers$2 = SavingCategoryModelKt.KClassImpl$Data$declaredNonStaticMembers$2(savingUpdateInit.getSavingCategories());
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        return new SavingUpdateInitModel(categoryCodes, KClassImpl$Data$declaredNonStaticMembers$2, MoneyViewModel.Companion.PlaceComponentResult(savingUpdateInit.getMaxTargetAmount()), savingUpdateInit.getMaxSavingCountNonKyc(), savingUpdateInit.getMaxSavingAmountNonKyc(), savingUpdateInit.getMaxSavingAmountKyc(), SavingModelMapperKt.BuiltInFictitiousFunctionClassFactory(savingUpdateInit.getSavingGoalView()));
    }
}
