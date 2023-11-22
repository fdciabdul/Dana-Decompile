package id.dana.mybills.utils;

import id.dana.data.util.NumberUtils;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.LocaleUtil;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0004\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0006"}, d2 = {"Lid/dana/mybills/utils/MyBillsMoneyUtils;", "", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "p0", "MyBillsEntityDataFactory", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsMoneyUtils {
    public static final MyBillsMoneyUtils INSTANCE = new MyBillsMoneyUtils();

    private MyBillsMoneyUtils() {
    }

    public static MoneyViewModel MyBillsEntityDataFactory(MoneyViewModel moneyViewModel) {
        String format;
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
        String cleanAll = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(cleanAll);
        format = NumberFormat.getNumberInstance(authRequestContext).format(longOrNull != null ? longOrNull.longValue() : 0L);
        Intrinsics.checkNotNullExpressionValue(format, "");
        return new MoneyViewModel(format, moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2, null, 4, null);
    }

    public static MoneyViewModel MyBillsEntityDataFactory(MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2) {
        String format;
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        String cleanAll = NumberUtils.getCleanAll(moneyViewModel2.PlaceComponentResult);
        if (cleanAll == null) {
            cleanAll = "0";
        }
        Long longOrNull = StringsKt.toLongOrNull(cleanAll);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        String cleanAll2 = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
        Long longOrNull2 = StringsKt.toLongOrNull(cleanAll2 != null ? cleanAll2 : "0");
        format = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format(longValue - (longOrNull2 != null ? longOrNull2.longValue() : 0L));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return new MoneyViewModel(format, moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2, null, 4, null);
    }
}
