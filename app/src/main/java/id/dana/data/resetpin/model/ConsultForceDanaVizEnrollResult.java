package id.dana.data.resetpin.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002\u0012\b\b\u0003\u0010\n\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\t\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\n\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\u001cR\"\u0010\u000b\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001c"}, d2 = {"Lid/dana/data/resetpin/model/ConsultForceDanaVizEnrollResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "isForced", "location", RequestConstants.SecVIKeyTntInstId, "copy", "(ZLjava/lang/String;Ljava/lang/String;)Lid/dana/data/resetpin/model/ConsultForceDanaVizEnrollResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "setForced", "(Z)V", "Ljava/lang/String;", "getLocation", "setLocation", "(Ljava/lang/String;)V", "getTntInstId", "setTntInstId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ConsultForceDanaVizEnrollResult extends BaseRpcResult {
    @SerializedName("isForced")
    private boolean isForced;
    @SerializedName("location")
    private String location;
    @SerializedName(RequestConstants.SecVIKeyTntInstId)
    private String tntInstId;

    public ConsultForceDanaVizEnrollResult() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ ConsultForceDanaVizEnrollResult copy$default(ConsultForceDanaVizEnrollResult consultForceDanaVizEnrollResult, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = consultForceDanaVizEnrollResult.isForced;
        }
        if ((i & 2) != 0) {
            str = consultForceDanaVizEnrollResult.location;
        }
        if ((i & 4) != 0) {
            str2 = consultForceDanaVizEnrollResult.tntInstId;
        }
        return consultForceDanaVizEnrollResult.copy(z, str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getIsForced() {
        return this.isForced;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTntInstId() {
        return this.tntInstId;
    }

    public final ConsultForceDanaVizEnrollResult copy(@JSONField(name = "isForced") boolean isForced, @JSONField(name = "location") String location, @JSONField(name = "tntInstId") String tntInstId) {
        Intrinsics.checkNotNullParameter(location, "");
        Intrinsics.checkNotNullParameter(tntInstId, "");
        return new ConsultForceDanaVizEnrollResult(isForced, location, tntInstId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ConsultForceDanaVizEnrollResult) {
            ConsultForceDanaVizEnrollResult consultForceDanaVizEnrollResult = (ConsultForceDanaVizEnrollResult) other;
            return this.isForced == consultForceDanaVizEnrollResult.isForced && Intrinsics.areEqual(this.location, consultForceDanaVizEnrollResult.location) && Intrinsics.areEqual(this.tntInstId, consultForceDanaVizEnrollResult.tntInstId);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.isForced;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.location.hashCode()) * 31) + this.tntInstId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ConsultForceDanaVizEnrollResult(isForced=");
        sb.append(this.isForced);
        sb.append(", location=");
        sb.append(this.location);
        sb.append(", tntInstId=");
        sb.append(this.tntInstId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ConsultForceDanaVizEnrollResult(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    @JvmName(name = "isForced")
    public final boolean isForced() {
        return this.isForced;
    }

    @JvmName(name = "setForced")
    public final void setForced(boolean z) {
        this.isForced = z;
    }

    @JvmName(name = "getLocation")
    public final String getLocation() {
        return this.location;
    }

    @JvmName(name = "setLocation")
    public final void setLocation(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.location = str;
    }

    @JvmName(name = "getTntInstId")
    public final String getTntInstId() {
        return this.tntInstId;
    }

    @JvmName(name = "setTntInstId")
    public final void setTntInstId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.tntInstId = str;
    }

    public ConsultForceDanaVizEnrollResult(@JSONField(name = "isForced") boolean z, @JSONField(name = "location") String str, @JSONField(name = "tntInstId") String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.isForced = z;
        this.location = str;
        this.tntInstId = str2;
    }
}
