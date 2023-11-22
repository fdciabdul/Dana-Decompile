package id.dana.data.model.cashier;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class PayMethodRiskResult {
    public String maskPhoneNumber;
    @SerializedName("result")
    public String result;
    public String riskInfo;
    public String verificationMethod;
    public int verificationPriority;
}
