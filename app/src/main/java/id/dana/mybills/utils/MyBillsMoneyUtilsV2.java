package id.dana.mybills.utils;

import id.dana.mybills.ui.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/utils/MyBillsMoneyUtilsV2;", "", "Lid/dana/mybills/ui/model/MoneyViewModel;", "p0", "getAuthRequestContext", "(Lid/dana/mybills/ui/model/MoneyViewModel;Lid/dana/mybills/ui/model/MoneyViewModel;)Lid/dana/mybills/ui/model/MoneyViewModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsMoneyUtilsV2 {
    public static final MyBillsMoneyUtilsV2 INSTANCE = new MyBillsMoneyUtilsV2();

    private MyBillsMoneyUtilsV2() {
    }

    public static MoneyViewModel getAuthRequestContext(MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2) {
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        long amountLong = moneyViewModel2.getAmountLong();
        long amountLong2 = moneyViewModel.getAmountLong();
        return new MoneyViewModel(String.valueOf(amountLong - amountLong2), moneyViewModel.getCurrency(), null, 4, null);
    }
}
