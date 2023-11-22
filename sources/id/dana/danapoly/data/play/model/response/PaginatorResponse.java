package id.dana.danapoly.data.play.model.response;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/danapoly/data/play/model/response/PaginatorResponse;", "", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "", "page", "Ljava/lang/Integer;", "getPage", "()Ljava/lang/Integer;", GriverMonitorConstants.KEY_SIZE, "getSize", "totalItems", "getTotalItems", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaginatorResponse {
    @SerializedName("hasMore")
    private final Boolean hasMore;
    @SerializedName("page")
    private final Integer page;
    @SerializedName(GriverMonitorConstants.KEY_SIZE)
    private final Integer size;
    @SerializedName("totalItems")
    private final Integer totalItems;

    public PaginatorResponse() {
        this(null, null, null, null, 15, null);
    }

    public PaginatorResponse(Integer num, Integer num2, Integer num3, Boolean bool) {
        this.page = num;
        this.size = num2;
        this.totalItems = num3;
        this.hasMore = bool;
    }

    public /* synthetic */ PaginatorResponse(Integer num, Integer num2, Integer num3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? 0 : num3, (i & 8) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getPage")
    public final Integer getPage() {
        return this.page;
    }

    @JvmName(name = "getSize")
    public final Integer getSize() {
        return this.size;
    }

    @JvmName(name = "getTotalItems")
    public final Integer getTotalItems() {
        return this.totalItems;
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }
}
