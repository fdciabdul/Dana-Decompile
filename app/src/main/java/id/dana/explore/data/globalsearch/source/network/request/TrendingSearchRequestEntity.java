package id.dana.explore.data.globalsearch.source.network.request;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/explore/data/globalsearch/source/network/request/TrendingSearchRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "page", "Ljava/lang/Integer;", "getPage", "()Ljava/lang/Integer;", "setPage", "(Ljava/lang/Integer;)V", GriverMonitorConstants.KEY_SIZE, "getSize", "setSize", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrendingSearchRequestEntity extends BaseRpcRequest {
    private Integer page;
    private Integer size;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TrendingSearchRequestEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.data.globalsearch.source.network.request.TrendingSearchRequestEntity.<init>():void");
    }

    public /* synthetic */ TrendingSearchRequestEntity(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1 : num, (i & 2) != 0 ? 10 : num2);
    }

    @JvmName(name = "getPage")
    public final Integer getPage() {
        return this.page;
    }

    @JvmName(name = "setPage")
    public final void setPage(Integer num) {
        this.page = num;
    }

    @JvmName(name = "getSize")
    public final Integer getSize() {
        return this.size;
    }

    @JvmName(name = "setSize")
    public final void setSize(Integer num) {
        this.size = num;
    }

    public TrendingSearchRequestEntity(Integer num, Integer num2) {
        this.page = num;
        this.size = num2;
    }
}
