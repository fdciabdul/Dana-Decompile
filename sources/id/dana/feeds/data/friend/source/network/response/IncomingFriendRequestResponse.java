package id.dana.feeds.data.friend.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/feeds/data/friend/source/network/response/IncomingFriendRequestResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/feeds/data/friend/source/network/response/FriendResponse;", "friendList", "Ljava/util/List;", "getFriendList", "()Ljava/util/List;", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "", "minId", "Ljava/lang/String;", "getMinId", "()Ljava/lang/String;", "", "totalCount", "Ljava/lang/Integer;", "getTotalCount", "()Ljava/lang/Integer;", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IncomingFriendRequestResponse extends BaseRpcResult {
    private final List<FriendResponse> friendList;
    private final Boolean hasMore;
    private final String minId;
    private final Integer totalCount;

    public IncomingFriendRequestResponse() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ IncomingFriendRequestResponse(List list, Integer num, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getFriendList")
    public final List<FriendResponse> getFriendList() {
        return this.friendList;
    }

    @JvmName(name = "getTotalCount")
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "getMinId")
    public final String getMinId() {
        return this.minId;
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public IncomingFriendRequestResponse(List<FriendResponse> list, Integer num, String str, Boolean bool) {
        this.friendList = list;
        this.totalCount = num;
        this.minId = str;
        this.hasMore = bool;
    }
}
