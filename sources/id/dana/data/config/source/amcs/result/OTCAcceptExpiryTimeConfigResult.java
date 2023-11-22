package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.JSONObject;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class OTCAcceptExpiryTimeConfigResult {
    private String unit;
    private String value;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface JsonKey {
        public static final String UNIT = "unit";
        public static final String VALUE = "value";
    }

    /* loaded from: classes8.dex */
    class OTCAcceptExpiryTimeDefault {
    }

    public OTCAcceptExpiryTimeConfigResult(JSONObject jSONObject) {
        this.unit = hasUnitObject(jSONObject) ? jSONObject.getString(JsonKey.UNIT) : SummaryActivity.HOURS;
        this.value = hasValueObject(jSONObject) ? jSONObject.getString("value") : "12";
    }

    public static OTCAcceptExpiryTimeConfigResult createDefaultConfig() {
        return new OTCAcceptExpiryTimeConfigResult(null);
    }

    private boolean hasUnitObject(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.containsKey(JsonKey.UNIT);
    }

    private boolean hasValueObject(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.containsKey("value");
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
