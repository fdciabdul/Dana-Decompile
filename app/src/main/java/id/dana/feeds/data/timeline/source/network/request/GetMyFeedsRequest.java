package id.dana.feeds.data.timeline.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJF\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007R\u0017\u0010\u0011\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b!\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/request/GetMyFeedsRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "", "component5", "()Z", SecurityConstants.KEY_PAGE_SIZE, "maxId", "minId", "inboxVersion", "globalNotification", "copy", "(ILjava/lang/String;Ljava/lang/String;IZ)Lid/dana/feeds/data/timeline/source/network/request/GetMyFeedsRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Z", "getGlobalNotification", "I", "getInboxVersion", "Ljava/lang/String;", "getMaxId", "getMinId", "getPageSize", "<init>", "(ILjava/lang/String;Ljava/lang/String;IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetMyFeedsRequest extends BaseRpcRequest {
    private final boolean globalNotification;
    private final int inboxVersion;
    private final String maxId;
    private final String minId;
    private final int pageSize;

    public static /* synthetic */ GetMyFeedsRequest copy$default(GetMyFeedsRequest getMyFeedsRequest, int i, String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = getMyFeedsRequest.pageSize;
        }
        if ((i3 & 2) != 0) {
            str = getMyFeedsRequest.maxId;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = getMyFeedsRequest.minId;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i2 = getMyFeedsRequest.inboxVersion;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            z = getMyFeedsRequest.globalNotification;
        }
        return getMyFeedsRequest.copy(i, str3, str4, i4, z);
    }

    /* renamed from: component1  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaxId() {
        return this.maxId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMinId() {
        return this.minId;
    }

    /* renamed from: component4  reason: from getter */
    public final int getInboxVersion() {
        return this.inboxVersion;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getGlobalNotification() {
        return this.globalNotification;
    }

    public final GetMyFeedsRequest copy(int pageSize, String maxId, String minId, int inboxVersion, boolean globalNotification) {
        return new GetMyFeedsRequest(pageSize, maxId, minId, inboxVersion, globalNotification);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GetMyFeedsRequest) {
            GetMyFeedsRequest getMyFeedsRequest = (GetMyFeedsRequest) other;
            return this.pageSize == getMyFeedsRequest.pageSize && Intrinsics.areEqual(this.maxId, getMyFeedsRequest.maxId) && Intrinsics.areEqual(this.minId, getMyFeedsRequest.minId) && this.inboxVersion == getMyFeedsRequest.inboxVersion && this.globalNotification == getMyFeedsRequest.globalNotification;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int i = this.pageSize;
        String str = this.maxId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.minId;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        int i2 = this.inboxVersion;
        boolean z = this.globalNotification;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return (((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + i2) * 31) + i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GetMyFeedsRequest(pageSize=");
        sb.append(this.pageSize);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", minId=");
        sb.append(this.minId);
        sb.append(", inboxVersion=");
        sb.append(this.inboxVersion);
        sb.append(", globalNotification=");
        sb.append(this.globalNotification);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getMinId")
    public final String getMinId() {
        return this.minId;
    }

    @JvmName(name = "getInboxVersion")
    public final int getInboxVersion() {
        return this.inboxVersion;
    }

    @JvmName(name = "getGlobalNotification")
    public final boolean getGlobalNotification() {
        return this.globalNotification;
    }

    public GetMyFeedsRequest(int i, String str, String str2, int i2, boolean z) {
        this.pageSize = i;
        this.maxId = str;
        this.minId = str2;
        this.inboxVersion = i2;
        this.globalNotification = z;
    }
}
