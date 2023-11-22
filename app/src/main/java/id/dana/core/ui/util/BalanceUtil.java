package id.dana.core.ui.util;

import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/BalanceUtil;", "", "Lid/dana/core/ui/model/CurrencyAmountModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/core/ui/model/CurrencyAmountModel;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BalanceUtil {
    public static final BalanceUtil INSTANCE = new BalanceUtil();

    private BalanceUtil() {
    }

    public static String getAuthRequestContext(CurrencyAmountModel p0) {
        String MyBillsEntityDataFactory;
        if (p0.getAmount().length() > 0) {
            String amount = p0.getAmount();
            String currency = p0.getCurrency().length() > 0 ? p0.getCurrency() : "";
            if (Intrinsics.areEqual(GlobalNetworkConstants.IDR_CURRENCY, currency)) {
                currency = "Rp";
            }
            if (StringsKt.contains$default((CharSequence) amount, (CharSequence) ".", false, 2, (Object) null)) {
                StringBuilder sb = new StringBuilder();
                sb.append(currency);
                sb.append(amount);
                MyBillsEntityDataFactory = sb.toString();
            } else {
                MyBillsEntityDataFactory = NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), Integer.parseInt(amount), currency);
            }
            return MyBillsEntityDataFactory;
        }
        return null;
    }
}
