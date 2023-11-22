package id.dana.data.promocenter.repository.source.network.request;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/data/promocenter/repository/source/network/request/PromoCenterAdsQueryRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()I", "component2", "component3", "radius", "page", GriverMonitorConstants.KEY_SIZE, "copy", "(III)Lid/dana/data/promocenter/repository/source/network/request/PromoCenterAdsQueryRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getPage", "getRadius", "getSize", "<init>", "(III)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoCenterAdsQueryRequest extends BaseRpcRequest {
    private final int page;
    private final int radius;
    private final int size;

    public static /* synthetic */ PromoCenterAdsQueryRequest copy$default(PromoCenterAdsQueryRequest promoCenterAdsQueryRequest, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = promoCenterAdsQueryRequest.radius;
        }
        if ((i4 & 2) != 0) {
            i2 = promoCenterAdsQueryRequest.page;
        }
        if ((i4 & 4) != 0) {
            i3 = promoCenterAdsQueryRequest.size;
        }
        return promoCenterAdsQueryRequest.copy(i, i2, i3);
    }

    /* renamed from: component1  reason: from getter */
    public final int getRadius() {
        return this.radius;
    }

    /* renamed from: component2  reason: from getter */
    public final int getPage() {
        return this.page;
    }

    /* renamed from: component3  reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final PromoCenterAdsQueryRequest copy(int radius, int page, int size) {
        return new PromoCenterAdsQueryRequest(radius, page, size);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoCenterAdsQueryRequest) {
            PromoCenterAdsQueryRequest promoCenterAdsQueryRequest = (PromoCenterAdsQueryRequest) other;
            return this.radius == promoCenterAdsQueryRequest.radius && this.page == promoCenterAdsQueryRequest.page && this.size == promoCenterAdsQueryRequest.size;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.radius * 31) + this.page) * 31) + this.size;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoCenterAdsQueryRequest(radius=");
        sb.append(this.radius);
        sb.append(", page=");
        sb.append(this.page);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getRadius")
    public final int getRadius() {
        return this.radius;
    }

    @JvmName(name = "getPage")
    public final int getPage() {
        return this.page;
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }

    public PromoCenterAdsQueryRequest(int i, int i2, int i3) {
        this.radius = i;
        this.page = i2;
        this.size = i3;
    }
}
