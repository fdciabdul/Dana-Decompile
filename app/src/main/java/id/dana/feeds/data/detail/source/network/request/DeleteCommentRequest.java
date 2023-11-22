package id.dana.feeds.data.detail.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/data/detail/source/network/request/DeleteCommentRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteCommentRequest extends BaseRpcRequest {
    private final String id;

    public DeleteCommentRequest(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.id = str;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }
}
