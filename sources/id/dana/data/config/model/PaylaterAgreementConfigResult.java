package id.dana.data.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/config/model/PaylaterAgreementConfigResult;", "Ljava/io/Serializable;", "", "enable", "Ljava/lang/Boolean;", "getEnable", "()Ljava/lang/Boolean;", "", "", "spaceCodes", "Ljava/util/List;", "getSpaceCodes", "()Ljava/util/List;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaylaterAgreementConfigResult implements Serializable {
    private final Boolean enable;
    @SerializedName("space_code")
    private final List<String> spaceCodes;

    public PaylaterAgreementConfigResult(Boolean bool, @JSONField(name = "space_code") List<String> list) {
        this.enable = bool;
        this.spaceCodes = list;
    }

    @JvmName(name = "getEnable")
    public final Boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getSpaceCodes")
    public final List<String> getSpaceCodes() {
        return this.spaceCodes;
    }
}
