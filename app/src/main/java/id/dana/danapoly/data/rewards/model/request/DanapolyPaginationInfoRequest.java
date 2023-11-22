package id.dana.danapoly.data.rewards.model.request;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/danapoly/data/rewards/model/request/DanapolyPaginationInfoRequest;", "", "", "page", "I", "getPage", "()I", GriverMonitorConstants.KEY_SIZE, "getSize", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyPaginationInfoRequest {
    private final int page;
    private final int size;

    public DanapolyPaginationInfoRequest(int i, int i2) {
        this.page = i;
        this.size = i2;
    }

    @JvmName(name = "getPage")
    public final int getPage() {
        return this.page;
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }
}
