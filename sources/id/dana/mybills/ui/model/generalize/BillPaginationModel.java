package id.dana.mybills.ui.model.generalize;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0013\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/mybills/ui/model/generalize/BillPaginationModel;", "", "", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "bills", "Ljava/util/List;", "getBills", "()Ljava/util/List;", "setBills", "(Ljava/util/List;)V", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", GriverMonitorConstants.KEY_IS_LOADING, "setLoading", "isShimmerFirstTimeShowed", "setShimmerFirstTimeShowed", "", "pageNum", "I", "getPageNum", "()I", "setPageNum", "(I)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BillPaginationModel {
    private boolean hasMore;
    private boolean isLoading;
    private List<BillPaymentStatusModel> bills = new ArrayList();
    private int pageNum = 1;
    private boolean isShimmerFirstTimeShowed = true;

    @JvmName(name = "getBills")
    public final List<BillPaymentStatusModel> getBills() {
        return this.bills;
    }

    @JvmName(name = "setBills")
    public final void setBills(List<BillPaymentStatusModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.bills = list;
    }

    @JvmName(name = GriverMonitorConstants.KEY_IS_LOADING)
    /* renamed from: isLoading  reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    @JvmName(name = "setLoading")
    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "setPageNum")
    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "setHasMore")
    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    @JvmName(name = "isShimmerFirstTimeShowed")
    /* renamed from: isShimmerFirstTimeShowed  reason: from getter */
    public final boolean getIsShimmerFirstTimeShowed() {
        return this.isShimmerFirstTimeShowed;
    }

    @JvmName(name = "setShimmerFirstTimeShowed")
    public final void setShimmerFirstTimeShowed(boolean z) {
        this.isShimmerFirstTimeShowed = z;
    }
}
