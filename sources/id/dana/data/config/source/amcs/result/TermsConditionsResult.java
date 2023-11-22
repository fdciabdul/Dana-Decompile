package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class TermsConditionsResult {
    private boolean enable = false;
    @SerializedName("space_code")
    @JSONField(name = "space_code")
    private Map<String, List<String>> spaceCode;

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public Map<String, List<String>> getSpaceCode() {
        return this.spaceCode;
    }

    public void setSpaceCode(Map<String, List<String>> map) {
        this.spaceCode = map;
    }
}
