package id.dana.feeds.data.friend.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/feeds/data/friend/source/network/request/IncomingFriendRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "minId", "Ljava/lang/String;", "getMinId", "()Ljava/lang/String;", "", SecurityConstants.KEY_PAGE_SIZE, "I", "getPageSize", "()I", "<init>", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IncomingFriendRequest extends BaseRpcRequest {
    private final String minId;
    private final int pageSize;

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getMinId")
    public final String getMinId() {
        return this.minId;
    }

    public IncomingFriendRequest(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pageSize = i;
        this.minId = str;
    }
}
