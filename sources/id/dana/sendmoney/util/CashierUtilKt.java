package id.dana.sendmoney.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CashierUtilKt {
    public static /* synthetic */ void getAuthRequestContext(Context context, String str, String str2, CurrencyRateModel currencyRateModel, int i) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            currencyRateModel = null;
        }
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intent className = new Intent("android.intent.action.VIEW").setClassName(context.getPackageName(), "id.dana.pay.PayActivity");
        Intrinsics.checkNotNullExpressionValue(className, "");
        Bundle bundle = new Bundle();
        bundle.putString("bizNo", str);
        bundle.putBoolean("open_cashier", true);
        bundle.putString("redirect_url", null);
        bundle.putParcelable(CashierKeyParams.EXCHANGE_RATE, currencyRateModel);
        className.putExtra("source", str2);
        className.putExtra("data", bundle);
        context.startActivity(className);
    }
}
