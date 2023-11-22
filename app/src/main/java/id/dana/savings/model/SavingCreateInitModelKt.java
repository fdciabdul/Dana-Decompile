package id.dana.savings.model;

import id.dana.domain.saving.model.SavingCreateInit;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/domain/saving/model/SavingCreateInit;", "", "p0", "Lid/dana/savings/model/SavingCreateInitModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/saving/model/SavingCreateInit;Ljava/lang/String;)Lid/dana/savings/model/SavingCreateInitModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingCreateInitModelKt {
    public static final SavingCreateInitModel KClassImpl$Data$declaredNonStaticMembers$2(SavingCreateInit savingCreateInit, String str) {
        Intrinsics.checkNotNullParameter(savingCreateInit, "");
        Intrinsics.checkNotNullParameter(str, "");
        List<String> categoryCodes = savingCreateInit.getCategoryCodes();
        List<SavingCategoryModel> KClassImpl$Data$declaredNonStaticMembers$2 = SavingCategoryModelKt.KClassImpl$Data$declaredNonStaticMembers$2(savingCreateInit.getSavingCategories());
        MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
        return new SavingCreateInitModel(categoryCodes, KClassImpl$Data$declaredNonStaticMembers$2, MoneyViewModel.Companion.PlaceComponentResult(savingCreateInit.getMaxTargetAmount()), savingCreateInit.getMaxSavingCountNonKyc(), savingCreateInit.getMaxSavingAmountNonKyc(), savingCreateInit.getMaxSavingAmountKyc(), str);
    }
}
