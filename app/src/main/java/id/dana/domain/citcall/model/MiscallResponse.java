package id.dana.domain.citcall.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJL\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b#\u0010\u0007"}, d2 = {"Lid/dana/domain/citcall/model/MiscallResponse;", "Lid/dana/utils/rpc/response/BaseRpcResponse;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "Ljava/util/Date;", "component5", "()Ljava/util/Date;", "prefix", "currentAttempts", "remainingAttempts", "timeUntilNextAttempt", "lastRequestTime", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;)Lid/dana/domain/citcall/model/MiscallResponse;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/Integer;", "getCurrentAttempts", "Ljava/util/Date;", "getLastRequestTime", "Ljava/lang/String;", "getPrefix", "getRemainingAttempts", "getTimeUntilNextAttempt", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Date;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MiscallResponse extends BaseRpcResponse {
    private final Integer currentAttempts;
    private final Date lastRequestTime;
    private final String prefix;
    private final Integer remainingAttempts;
    private final Integer timeUntilNextAttempt;

    public MiscallResponse() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ MiscallResponse copy$default(MiscallResponse miscallResponse, String str, Integer num, Integer num2, Integer num3, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = miscallResponse.prefix;
        }
        if ((i & 2) != 0) {
            num = miscallResponse.currentAttempts;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = miscallResponse.remainingAttempts;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = miscallResponse.timeUntilNextAttempt;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            date = miscallResponse.lastRequestTime;
        }
        return miscallResponse.copy(str, num4, num5, num6, date);
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

    public final MiscallResponse copy(String prefix, Integer currentAttempts, Integer remainingAttempts, Integer timeUntilNextAttempt, Date lastRequestTime) {
        return new MiscallResponse(prefix, currentAttempts, remainingAttempts, timeUntilNextAttempt, lastRequestTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MiscallResponse) {
            MiscallResponse miscallResponse = (MiscallResponse) other;
            return Intrinsics.areEqual(this.prefix, miscallResponse.prefix) && Intrinsics.areEqual(this.currentAttempts, miscallResponse.currentAttempts) && Intrinsics.areEqual(this.remainingAttempts, miscallResponse.remainingAttempts) && Intrinsics.areEqual(this.timeUntilNextAttempt, miscallResponse.timeUntilNextAttempt) && Intrinsics.areEqual(this.lastRequestTime, miscallResponse.lastRequestTime);
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
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (date != null ? date.hashCode() : 0);
    }

    @Override // id.dana.utils.rpc.response.BaseRpcResponse
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MiscallResponse(prefix=");
        sb.append(this.prefix);
        sb.append(", currentAttempts=");
        sb.append(this.currentAttempts);
        sb.append(", remainingAttempts=");
        sb.append(this.remainingAttempts);
        sb.append(", timeUntilNextAttempt=");
        sb.append(this.timeUntilNextAttempt);
        sb.append(", lastRequestTime=");
        sb.append(this.lastRequestTime);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getPrefix")
    public final String getPrefix() {
        return this.prefix;
    }

    public /* synthetic */ MiscallResponse(String str, Integer num, Integer num2, Integer num3, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? 0 : num3, (i & 16) != 0 ? null : date);
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

    public MiscallResponse(String str, Integer num, Integer num2, Integer num3, Date date) {
        this.prefix = str;
        this.currentAttempts = num;
        this.remainingAttempts = num2;
        this.timeUntilNextAttempt = num3;
        this.lastRequestTime = date;
    }
}
