package id.dana.data.sendmoney.model;

import id.dana.data.model.CurrencyAmountResult;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class PayChannelResult {
    public String disableReason;
    public boolean enableStatus;
    public Map<String, String> extendInfo;
    public String instId;
    public String instLocalName;
    public String instName;
    public CurrencyAmountResult maxAmount;
    public CurrencyAmountResult minAmount;
    public String payMethod;
    public String payOption;
    public List<String> supportCountries;
}
