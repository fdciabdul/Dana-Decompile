package id.dana.data.sendmoney.model;

import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class PayOptionResult {
    public String assetType;
    public String bindingId;
    public String cardBin;
    public String cardIndexNo;
    public int cardNoLength;
    public String cardScheme;
    public boolean defaultCard;
    public boolean enableStatus;
    public String expiryMonth;
    public String expiryYear;
    public Map<String, String> extendInfo;
    public Map<String, String> holderName;
    public String instId;
    public String instLocalName;
    public String instName;
    public String maskedCardNo;
    public String offlinePayIndex;
    public String payMethod;
    public String payOption;
    public List<String> payVerifyElements;
    public boolean payWithoutCVV;
}
