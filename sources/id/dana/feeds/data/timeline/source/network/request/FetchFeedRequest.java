package id.dana.feeds.data.timeline.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJd\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b(\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/request/FetchFeedRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/util/List;", "targetUserId", SecurityConstants.KEY_PAGE_SIZE, "minId", "maxId", "feedType", "feedVersion", "activityIds", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)Lid/dana/feeds/data/timeline/source/network/request/FetchFeedRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/util/List;", "getActivityIds", "Ljava/lang/String;", "getFeedType", "I", "getFeedVersion", "getMaxId", "getMinId", "getPageSize", "getTargetUserId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FetchFeedRequest extends BaseRpcRequest {
    private final List<String> activityIds;
    private final String feedType;
    private final int feedVersion;
    private final String maxId;
    private final String minId;
    private final int pageSize;
    private final String targetUserId;

    public static /* synthetic */ FetchFeedRequest copy$default(FetchFeedRequest fetchFeedRequest, String str, int i, String str2, String str3, String str4, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fetchFeedRequest.targetUserId;
        }
        if ((i3 & 2) != 0) {
            i = fetchFeedRequest.pageSize;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str2 = fetchFeedRequest.minId;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            str3 = fetchFeedRequest.maxId;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = fetchFeedRequest.feedType;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            i2 = fetchFeedRequest.feedVersion;
        }
        int i5 = i2;
        List<String> list2 = list;
        if ((i3 & 64) != 0) {
            list2 = fetchFeedRequest.activityIds;
        }
        return fetchFeedRequest.copy(str, i4, str5, str6, str7, i5, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTargetUserId() {
        return this.targetUserId;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMinId() {
        return this.minId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMaxId() {
        return this.maxId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getFeedType() {
        return this.feedType;
    }

    /* renamed from: component6  reason: from getter */
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    public final List<String> component7() {
        return this.activityIds;
    }

    public final FetchFeedRequest copy(String targetUserId, int pageSize, String minId, String maxId, String feedType, int feedVersion, List<String> activityIds) {
        Intrinsics.checkNotNullParameter(activityIds, "");
        return new FetchFeedRequest(targetUserId, pageSize, minId, maxId, feedType, feedVersion, activityIds);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FetchFeedRequest) {
            FetchFeedRequest fetchFeedRequest = (FetchFeedRequest) other;
            return Intrinsics.areEqual(this.targetUserId, fetchFeedRequest.targetUserId) && this.pageSize == fetchFeedRequest.pageSize && Intrinsics.areEqual(this.minId, fetchFeedRequest.minId) && Intrinsics.areEqual(this.maxId, fetchFeedRequest.maxId) && Intrinsics.areEqual(this.feedType, fetchFeedRequest.feedType) && this.feedVersion == fetchFeedRequest.feedVersion && Intrinsics.areEqual(this.activityIds, fetchFeedRequest.activityIds);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.targetUserId;
        int hashCode = str == null ? 0 : str.hashCode();
        int i = this.pageSize;
        String str2 = this.minId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.maxId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.feedType;
        return (((((((((((hashCode * 31) + i) * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0)) * 31) + this.feedVersion) * 31) + this.activityIds.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FetchFeedRequest(targetUserId=");
        sb.append(this.targetUserId);
        sb.append(", pageSize=");
        sb.append(this.pageSize);
        sb.append(", minId=");
        sb.append(this.minId);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", feedType=");
        sb.append(this.feedType);
        sb.append(", feedVersion=");
        sb.append(this.feedVersion);
        sb.append(", activityIds=");
        sb.append(this.activityIds);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getMinId")
    public final String getMinId() {
        return this.minId;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getTargetUserId")
    public final String getTargetUserId() {
        return this.targetUserId;
    }

    public /* synthetic */ FetchFeedRequest(String str, int i, String str2, String str3, String str4, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, str3, str4, (i3 & 32) != 0 ? 5 : i2, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getActivityIds")
    public final List<String> getActivityIds() {
        return this.activityIds;
    }

    @JvmName(name = "getFeedType")
    public final String getFeedType() {
        return this.feedType;
    }

    @JvmName(name = "getFeedVersion")
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    public FetchFeedRequest(String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.targetUserId = str;
        this.pageSize = i;
        this.minId = str2;
        this.maxId = str3;
        this.feedType = str4;
        this.feedVersion = i2;
        this.activityIds = list;
    }
}
