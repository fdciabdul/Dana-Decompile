package id.dana.danapoly.data.rewards.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014"}, d2 = {"Lid/dana/danapoly/data/rewards/model/request/GetRewardsRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "eventId", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "Lid/dana/danapoly/data/rewards/model/request/DanapolyPaginationInfoRequest;", "listPagination", "Lid/dana/danapoly/data/rewards/model/request/DanapolyPaginationInfoRequest;", "getListPagination", "()Lid/dana/danapoly/data/rewards/model/request/DanapolyPaginationInfoRequest;", "sort", "getSort", "stackPagination", "getStackPagination", "", "statuses", "Ljava/util/List;", "getStatuses", "()Ljava/util/List;", "types", "getTypes", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lid/dana/danapoly/data/rewards/model/request/DanapolyPaginationInfoRequest;Lid/dana/danapoly/data/rewards/model/request/DanapolyPaginationInfoRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetRewardsRequest extends BaseRpcRequest {
    private final String eventId;
    private final DanapolyPaginationInfoRequest listPagination;
    private final String sort;
    private final DanapolyPaginationInfoRequest stackPagination;
    private final List<String> statuses;
    private final List<String> types;

    public /* synthetic */ GetRewardsRequest(String str, List list, List list2, String str2, DanapolyPaginationInfoRequest danapolyPaginationInfoRequest, DanapolyPaginationInfoRequest danapolyPaginationInfoRequest2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : danapolyPaginationInfoRequest, (i & 32) == 0 ? danapolyPaginationInfoRequest2 : null);
    }

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "getTypes")
    public final List<String> getTypes() {
        return this.types;
    }

    @JvmName(name = "getStatuses")
    public final List<String> getStatuses() {
        return this.statuses;
    }

    @JvmName(name = "getSort")
    public final String getSort() {
        return this.sort;
    }

    @JvmName(name = "getListPagination")
    public final DanapolyPaginationInfoRequest getListPagination() {
        return this.listPagination;
    }

    @JvmName(name = "getStackPagination")
    public final DanapolyPaginationInfoRequest getStackPagination() {
        return this.stackPagination;
    }

    public GetRewardsRequest(String str, List<String> list, List<String> list2, String str2, DanapolyPaginationInfoRequest danapolyPaginationInfoRequest, DanapolyPaginationInfoRequest danapolyPaginationInfoRequest2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.eventId = str;
        this.types = list;
        this.statuses = list2;
        this.sort = str2;
        this.listPagination = danapolyPaginationInfoRequest;
        this.stackPagination = danapolyPaginationInfoRequest2;
    }
}
