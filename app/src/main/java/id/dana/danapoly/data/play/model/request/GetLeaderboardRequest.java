package id.dana.danapoly.data.play.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/data/play/model/request/GetLeaderboardRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "eventId", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "Lid/dana/danapoly/data/play/model/request/PaginationRequest;", "pagination", "Lid/dana/danapoly/data/play/model/request/PaginationRequest;", "getPagination", "()Lid/dana/danapoly/data/play/model/request/PaginationRequest;", "<init>", "(Ljava/lang/String;Lid/dana/danapoly/data/play/model/request/PaginationRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetLeaderboardRequest extends BaseRpcRequest {
    private final String eventId;
    private final PaginationRequest pagination;

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "getPagination")
    public final PaginationRequest getPagination() {
        return this.pagination;
    }

    public GetLeaderboardRequest(String str, PaginationRequest paginationRequest) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(paginationRequest, "");
        this.eventId = str;
        this.pagination = paginationRequest;
    }
}
