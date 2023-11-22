package id.dana.data.qrbarcode.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007R$\u0010\r\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/request/UserGenerateQrRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/lang/Integer;", "qris", "qrisBizType", "qrCount", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;)Lid/dana/data/qrbarcode/repository/source/network/request/UserGenerateQrRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/Integer;", "getQrCount", "setQrCount", "(Ljava/lang/Integer;)V", "Z", "getQris", "Ljava/lang/String;", "getQrisBizType", "setQrisBizType", "(Ljava/lang/String;)V", "<init>", "(ZLjava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserGenerateQrRequest extends BaseRpcRequest {
    private Integer qrCount;
    private final boolean qris;
    private String qrisBizType;

    public static /* synthetic */ UserGenerateQrRequest copy$default(UserGenerateQrRequest userGenerateQrRequest, boolean z, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            z = userGenerateQrRequest.qris;
        }
        if ((i & 2) != 0) {
            str = userGenerateQrRequest.qrisBizType;
        }
        if ((i & 4) != 0) {
            num = userGenerateQrRequest.qrCount;
        }
        return userGenerateQrRequest.copy(z, str, num);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getQris() {
        return this.qris;
    }

    /* renamed from: component2  reason: from getter */
    public final String getQrisBizType() {
        return this.qrisBizType;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getQrCount() {
        return this.qrCount;
    }

    public final UserGenerateQrRequest copy(boolean qris, String qrisBizType, Integer qrCount) {
        return new UserGenerateQrRequest(qris, qrisBizType, qrCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserGenerateQrRequest) {
            UserGenerateQrRequest userGenerateQrRequest = (UserGenerateQrRequest) other;
            return this.qris == userGenerateQrRequest.qris && Intrinsics.areEqual(this.qrisBizType, userGenerateQrRequest.qrisBizType) && Intrinsics.areEqual(this.qrCount, userGenerateQrRequest.qrCount);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.qris;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.qrisBizType;
        int hashCode = str == null ? 0 : str.hashCode();
        Integer num = this.qrCount;
        return (((r0 * 31) + hashCode) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserGenerateQrRequest(qris=");
        sb.append(this.qris);
        sb.append(", qrisBizType=");
        sb.append(this.qrisBizType);
        sb.append(", qrCount=");
        sb.append(this.qrCount);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserGenerateQrRequest(boolean z, String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num);
    }

    @JvmName(name = "getQris")
    public final boolean getQris() {
        return this.qris;
    }

    @JvmName(name = "getQrisBizType")
    public final String getQrisBizType() {
        return this.qrisBizType;
    }

    @JvmName(name = "setQrisBizType")
    public final void setQrisBizType(String str) {
        this.qrisBizType = str;
    }

    @JvmName(name = "getQrCount")
    public final Integer getQrCount() {
        return this.qrCount;
    }

    @JvmName(name = "setQrCount")
    public final void setQrCount(Integer num) {
        this.qrCount = num;
    }

    public UserGenerateQrRequest(boolean z, String str, Integer num) {
        this.qris = z;
        this.qrisBizType = str;
        this.qrCount = num;
    }
}
