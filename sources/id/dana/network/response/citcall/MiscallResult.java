package id.dana.network.response.citcall;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004JX\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b&\u0010\u0007"}, d2 = {"Lid/dana/network/response/citcall/MiscallResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "Ljava/util/Date;", "component5", "()Ljava/util/Date;", "component6", "prefix", "currentAttempts", "remainingAttempts", "timeUntilNextAttempt", "lastRequestTime", "errorMsg", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;Ljava/lang/String;)Lid/dana/network/response/citcall/MiscallResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/Integer;", "getCurrentAttempts", "Ljava/lang/String;", "getErrorMsg", "Ljava/util/Date;", "getLastRequestTime", "getPrefix", "getRemainingAttempts", "getTimeUntilNextAttempt", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MiscallResult extends BaseRpcResult {
    private final Integer currentAttempts;
    private final String errorMsg;
    private final Date lastRequestTime;
    private final String prefix;
    private final Integer remainingAttempts;
    private final Integer timeUntilNextAttempt;

    public MiscallResult() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MiscallResult copy$default(MiscallResult miscallResult, String str, Integer num, Integer num2, Integer num3, Date date, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = miscallResult.prefix;
        }
        if ((i & 2) != 0) {
            num = miscallResult.currentAttempts;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = miscallResult.remainingAttempts;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = miscallResult.timeUntilNextAttempt;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            date = miscallResult.lastRequestTime;
        }
        Date date2 = date;
        if ((i & 32) != 0) {
            str2 = miscallResult.errorMsg;
        }
        return miscallResult.copy(str, num4, num5, num6, date2, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getCurrentAttempts() {
        return this.currentAttempts;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getRemainingAttempts() {
        return this.remainingAttempts;
    }

    /* renamed from: component4  reason: from getter */
    public final Integer getTimeUntilNextAttempt() {
        return this.timeUntilNextAttempt;
    }

    /* renamed from: component5  reason: from getter */
    public final Date getLastRequestTime() {
        return this.lastRequestTime;
    }

    /* renamed from: component6  reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final MiscallResult copy(String prefix, Integer currentAttempts, Integer remainingAttempts, Integer timeUntilNextAttempt, Date lastRequestTime, String errorMsg) {
        return new MiscallResult(prefix, currentAttempts, remainingAttempts, timeUntilNextAttempt, lastRequestTime, errorMsg);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MiscallResult) {
            MiscallResult miscallResult = (MiscallResult) other;
            return Intrinsics.areEqual(this.prefix, miscallResult.prefix) && Intrinsics.areEqual(this.currentAttempts, miscallResult.currentAttempts) && Intrinsics.areEqual(this.remainingAttempts, miscallResult.remainingAttempts) && Intrinsics.areEqual(this.timeUntilNextAttempt, miscallResult.timeUntilNextAttempt) && Intrinsics.areEqual(this.lastRequestTime, miscallResult.lastRequestTime) && Intrinsics.areEqual(this.errorMsg, miscallResult.errorMsg);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.prefix;
        int hashCode = str == null ? 0 : str.hashCode();
        Integer num = this.currentAttempts;
        int hashCode2 = num == null ? 0 : num.hashCode();
        Integer num2 = this.remainingAttempts;
        int hashCode3 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.timeUntilNextAttempt;
        int hashCode4 = num3 == null ? 0 : num3.hashCode();
        Date date = this.lastRequestTime;
        int hashCode5 = date == null ? 0 : date.hashCode();
        String str2 = this.errorMsg;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MiscallResult(prefix=");
        sb.append(this.prefix);
        sb.append(", currentAttempts=");
        sb.append(this.currentAttempts);
        sb.append(", remainingAttempts=");
        sb.append(this.remainingAttempts);
        sb.append(", timeUntilNextAttempt=");
        sb.append(this.timeUntilNextAttempt);
        sb.append(", lastRequestTime=");
        sb.append(this.lastRequestTime);
        sb.append(", errorMsg=");
        sb.append(this.errorMsg);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getPrefix")
    public final String getPrefix() {
        return this.prefix;
    }

    public /* synthetic */ MiscallResult(String str, Integer num, Integer num2, Integer num3, Date date, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? 0 : num3, (i & 16) != 0 ? null : date, (i & 32) != 0 ? null : str2);
    }

    @JvmName(name = "getCurrentAttempts")
    public final Integer getCurrentAttempts() {
        return this.currentAttempts;
    }

    @JvmName(name = "getRemainingAttempts")
    public final Integer getRemainingAttempts() {
        return this.remainingAttempts;
    }

    @JvmName(name = "getTimeUntilNextAttempt")
    public final Integer getTimeUntilNextAttempt() {
        return this.timeUntilNextAttempt;
    }

    @JvmName(name = "getLastRequestTime")
    public final Date getLastRequestTime() {
        return this.lastRequestTime;
    }

    @JvmName(name = "getErrorMsg")
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public MiscallResult(String str, Integer num, Integer num2, Integer num3, Date date, String str2) {
        this.prefix = str;
        this.currentAttempts = num;
        this.remainingAttempts = num2;
        this.timeUntilNextAttempt = num3;
        this.lastRequestTime = date;
        this.errorMsg = str2;
    }
}
