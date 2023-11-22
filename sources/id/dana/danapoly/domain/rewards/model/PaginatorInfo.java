package id.dana.danapoly.domain.rewards.model;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/danapoly/domain/rewards/model/PaginatorInfo;", "", "", "hasMore", "Z", "getHasMore", "()Z", "", "page", "I", "getPage", "()I", GriverMonitorConstants.KEY_SIZE, "getSize", "<init>", "(IIZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaginatorInfo {
    private final boolean hasMore;
    private final int page;
    private final int size;

    public PaginatorInfo() {
        this(0, 0, false, 7, null);
    }

    public PaginatorInfo(int i, int i2, boolean z) {
        this.page = i;
        this.size = i2;
        this.hasMore = z;
    }

    public /* synthetic */ PaginatorInfo(int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z);
    }

    @JvmName(name = "getPage")
    public final int getPage() {
        return this.page;
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }
}
