package id.dana.feeds.data.friend.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/feeds/data/friend/source/network/request/FriendListRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "getIsUserId", "()Z", "isUserId", "Z", "", "", "userIdentifierList", "Ljava/util/List;", "getUserIdentifierList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendListRequest extends BaseRpcRequest {
    private boolean isUserId;
    private final List<String> userIdentifierList;

    public /* synthetic */ FriendListRequest(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z);
    }

    @JvmName(name = "getUserIdentifierList")
    public final List<String> getUserIdentifierList() {
        return this.userIdentifierList;
    }

    public FriendListRequest(List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.userIdentifierList = list;
        this.isUserId = z;
    }

    public final boolean getIsUserId() {
        return this.isUserId;
    }
}
