package id.dana.data.statement.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0018"}, d2 = {"Lid/dana/data/statement/repository/source/network/request/StatementSummaryRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "timeValue", "timeUnit", "type", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/statement/repository/source/network/request/StatementSummaryRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getTimeUnit", "setTimeUnit", "(Ljava/lang/String;)V", "getTimeValue", "setTimeValue", "getType", "setType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class StatementSummaryRequest extends BaseRpcRequest {
    private String timeUnit;
    private String timeValue;
    private String type;

    public StatementSummaryRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StatementSummaryRequest copy$default(StatementSummaryRequest statementSummaryRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = statementSummaryRequest.timeValue;
        }
        if ((i & 2) != 0) {
            str2 = statementSummaryRequest.timeUnit;
        }
        if ((i & 4) != 0) {
            str3 = statementSummaryRequest.type;
        }
        return statementSummaryRequest.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTimeValue() {
        return this.timeValue;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTimeUnit() {
        return this.timeUnit;
    }

    /* renamed from: component3  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final StatementSummaryRequest copy(String timeValue, String timeUnit, String type) {
        Intrinsics.checkNotNullParameter(timeValue, "");
        Intrinsics.checkNotNullParameter(timeUnit, "");
        Intrinsics.checkNotNullParameter(type, "");
        return new StatementSummaryRequest(timeValue, timeUnit, type);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof StatementSummaryRequest) {
            StatementSummaryRequest statementSummaryRequest = (StatementSummaryRequest) other;
            return Intrinsics.areEqual(this.timeValue, statementSummaryRequest.timeValue) && Intrinsics.areEqual(this.timeUnit, statementSummaryRequest.timeUnit) && Intrinsics.areEqual(this.type, statementSummaryRequest.type);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.timeValue.hashCode() * 31) + this.timeUnit.hashCode()) * 31) + this.type.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatementSummaryRequest(timeValue=");
        sb.append(this.timeValue);
        sb.append(", timeUnit=");
        sb.append(this.timeUnit);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ StatementSummaryRequest(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getTimeValue")
    public final String getTimeValue() {
        return this.timeValue;
    }

    @JvmName(name = "setTimeValue")
    public final void setTimeValue(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.timeValue = str;
    }

    @JvmName(name = "getTimeUnit")
    public final String getTimeUnit() {
        return this.timeUnit;
    }

    @JvmName(name = "setTimeUnit")
    public final void setTimeUnit(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.timeUnit = str;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.type = str;
    }

    public StatementSummaryRequest(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.timeValue = str;
        this.timeUnit = str2;
        this.type = str3;
    }
}
