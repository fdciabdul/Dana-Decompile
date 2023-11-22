package id.dana.data.paylater.repository.source.network.result;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/LoanInfoResult;", "Ljava/io/Serializable;", "", "billDueDate", "Ljava/lang/Long;", "getBillDueDate", "()Ljava/lang/Long;", "setBillDueDate", "(Ljava/lang/Long;)V", "", "registered", "Ljava/lang/Boolean;", "getRegistered", "()Ljava/lang/Boolean;", "setRegistered", "(Ljava/lang/Boolean;)V", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "whitelist", "getWhitelist", "setWhitelist", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanInfoResult implements Serializable {
    private Long billDueDate;
    private Boolean registered;
    private String type;
    private Boolean whitelist;

    public LoanInfoResult() {
        this(null, null, null, null, 15, null);
    }

    public LoanInfoResult(Boolean bool, String str, Boolean bool2, Long l) {
        this.whitelist = bool;
        this.type = str;
        this.registered = bool2;
        this.billDueDate = l;
    }

    public /* synthetic */ LoanInfoResult(Boolean bool, String str, Boolean bool2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : l);
    }

    @JvmName(name = "getWhitelist")
    public final Boolean getWhitelist() {
        return this.whitelist;
    }

    @JvmName(name = "setWhitelist")
    public final void setWhitelist(Boolean bool) {
        this.whitelist = bool;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(String str) {
        this.type = str;
    }

    @JvmName(name = "getRegistered")
    public final Boolean getRegistered() {
        return this.registered;
    }

    @JvmName(name = "setRegistered")
    public final void setRegistered(Boolean bool) {
        this.registered = bool;
    }

    @JvmName(name = "getBillDueDate")
    public final Long getBillDueDate() {
        return this.billDueDate;
    }

    @JvmName(name = "setBillDueDate")
    public final void setBillDueDate(Long l) {
        this.billDueDate = l;
    }
}
