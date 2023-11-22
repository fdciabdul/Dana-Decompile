package id.dana.data.payasset.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.requestmoney.BundleKey;

/* loaded from: classes4.dex */
public class AmountRangeResult {
    @SerializedName(BundleKey.MAXIMUM_AMOUNT)
    public CurrencyAmountResult maxAmount;
    public CurrencyAmountResult minAmount;
}
