package id.dana.danapoly.data.play.model.request;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/danapoly/data/play/model/request/PaginationRequest;", "", "", "page", "I", "getPage", "()I", GriverMonitorConstants.KEY_SIZE, "getSize", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaginationRequest {
    private final int page;
    private final int size;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PaginationRequest() {
        /*
            r3 = this;
            r0 = 0
            r1 = 3
            r2 = 0
            r3.<init>(r0, r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.data.play.model.request.PaginationRequest.<init>():void");
    }

    public PaginationRequest(int i, int i2) {
        this.page = i;
        this.size = i2;
    }

    public /* synthetic */ PaginationRequest(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 10 : i2);
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
