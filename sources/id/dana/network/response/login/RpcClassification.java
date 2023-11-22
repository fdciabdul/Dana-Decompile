package id.dana.network.response.login;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/network/response/login/RpcClassification;", "Ljava/io/Serializable;", "", "classificationName", "Ljava/lang/String;", "getClassificationName", "()Ljava/lang/String;", "setClassificationName", "(Ljava/lang/String;)V", "classificationValue", "getClassificationValue", "setClassificationValue", "", "", "extInfo", "Ljava/util/Map;", "getExtInfo", "()Ljava/util/Map;", "setExtInfo", "(Ljava/util/Map;)V", "Ljava/util/Date;", "modifyDate", "Ljava/util/Date;", "getModifyDate", "()Ljava/util/Date;", "setModifyDate", "(Ljava/util/Date;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class RpcClassification implements Serializable {
    private String classificationName;
    private String classificationValue;
    private Map<String, ? extends Object> extInfo;
    private Date modifyDate;

    @JvmName(name = "getClassificationName")
    public final String getClassificationName() {
        return this.classificationName;
    }

    @JvmName(name = "setClassificationName")
    public final void setClassificationName(String str) {
        this.classificationName = str;
    }

    @JvmName(name = "getClassificationValue")
    public final String getClassificationValue() {
        return this.classificationValue;
    }

    @JvmName(name = "setClassificationValue")
    public final void setClassificationValue(String str) {
        this.classificationValue = str;
    }

    @JvmName(name = "getExtInfo")
    public final Map<String, Object> getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "setExtInfo")
    public final void setExtInfo(Map<String, ? extends Object> map) {
        this.extInfo = map;
    }

    @JvmName(name = "getModifyDate")
    public final Date getModifyDate() {
        return this.modifyDate;
    }

    @JvmName(name = "setModifyDate")
    public final void setModifyDate(Date date) {
        this.modifyDate = date;
    }
}
