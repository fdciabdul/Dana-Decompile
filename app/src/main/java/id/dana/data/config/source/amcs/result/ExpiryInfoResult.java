package id.dana.data.config.source.amcs.result;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class ExpiryInfoResult {
    @SerializedName("expiry_default")
    private boolean expiryDefault;
    @SerializedName("expiry_number")
    private int expiryNumber;
    @SerializedName("expiry_unit")
    private String expiryUnit;

    public int getExpiryNumber() {
        return this.expiryNumber;
    }

    public void setExpiryNumber(int i) {
        this.expiryNumber = i;
    }

    public String getExpiryUnit() {
        return this.expiryUnit;
    }

    public void setExpiryUnit(String str) {
        this.expiryUnit = str;
    }

    public boolean isExpiryDefault() {
        return this.expiryDefault;
    }

    public void setExpiryDefault(boolean z) {
        this.expiryDefault = z;
    }
}
