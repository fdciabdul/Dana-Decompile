package id.dana.feeds.data.synccontact.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.feeds.data.synccontact.source.network.response.FeedsUserContact;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005"}, d2 = {"Lid/dana/feeds/data/synccontact/source/network/request/FeedsSyncRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsUserContact;", "component1", "()Ljava/util/List;", "userContactList", "copy", "(Ljava/util/List;)Lid/dana/feeds/data/synccontact/source/network/request/FeedsSyncRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getUserContactList", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedsSyncRequest extends BaseRpcRequest {
    private final List<FeedsUserContact> userContactList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedsSyncRequest copy$default(FeedsSyncRequest feedsSyncRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = feedsSyncRequest.userContactList;
        }
        return feedsSyncRequest.copy(list);
    }

    public final List<FeedsUserContact> component1() {
        return this.userContactList;
    }

    public final FeedsSyncRequest copy(List<FeedsUserContact> userContactList) {
        Intrinsics.checkNotNullParameter(userContactList, "");
        return new FeedsSyncRequest(userContactList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeedsSyncRequest) && Intrinsics.areEqual(this.userContactList, ((FeedsSyncRequest) other).userContactList);
    }

    public final int hashCode() {
        return this.userContactList.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedsSyncRequest(userContactList=");
        sb.append(this.userContactList);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getUserContactList")
    public final List<FeedsUserContact> getUserContactList() {
        return this.userContactList;
    }

    public FeedsSyncRequest(List<FeedsUserContact> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.userContactList = list;
    }
}
