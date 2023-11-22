package id.dana.data.globalnetwork.model;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\"\u0010\r\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\r\u0010\n\"\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/data/globalnetwork/model/PaymentResult;", "", "", "component1", "()Ljava/lang/String;", "Ljava/util/Date;", "component2", "()Ljava/util/Date;", "", "component3", "()Z", "code", "generateDate", "isExpired", "copy", "(Ljava/lang/String;Ljava/util/Date;Z)Lid/dana/data/globalnetwork/model/PaymentResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCode", "Ljava/util/Date;", "getGenerateDate", "Z", "setExpired", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/util/Date;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PaymentResult {
    private final String code;
    private final Date generateDate;
    private boolean isExpired;

    public static /* synthetic */ PaymentResult copy$default(PaymentResult paymentResult, String str, Date date, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentResult.code;
        }
        if ((i & 2) != 0) {
            date = paymentResult.generateDate;
        }
        if ((i & 4) != 0) {
            z = paymentResult.isExpired;
        }
        return paymentResult.copy(str, date, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2  reason: from getter */
    public final Date getGenerateDate() {
        return this.generateDate;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsExpired() {
        return this.isExpired;
    }

    public final PaymentResult copy(String code, Date generateDate, boolean isExpired) {
        Intrinsics.checkNotNullParameter(code, "");
        Intrinsics.checkNotNullParameter(generateDate, "");
        return new PaymentResult(code, generateDate, isExpired);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentResult(code=");
        sb.append(this.code);
        sb.append(", generateDate=");
        sb.append(this.generateDate);
        sb.append(", isExpired=");
        sb.append(this.isExpired);
        sb.append(')');
        return sb.toString();
    }

    public PaymentResult(String str, Date date, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(date, "");
        this.code = str;
        this.generateDate = date;
        this.isExpired = z;
    }

    public /* synthetic */ PaymentResult(String str, Date date, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, date, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getCode")
    public final String getCode() {
        return this.code;
    }

    @JvmName(name = "getGenerateDate")
    public final Date getGenerateDate() {
        return this.generateDate;
    }

    @JvmName(name = "isExpired")
    public final boolean isExpired() {
        return this.isExpired;
    }

    @JvmName(name = "setExpired")
    public final void setExpired(boolean z) {
        this.isExpired = z;
    }

    public final boolean equals(Object other) {
        return (other instanceof PaymentResult) && Intrinsics.areEqual(((PaymentResult) other).code, this.code);
    }

    public final int hashCode() {
        return this.code.hashCode();
    }
}
