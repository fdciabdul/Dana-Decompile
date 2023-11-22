package id.dana.data.pocket.model;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006"}, d2 = {"Lid/dana/data/pocket/model/PocketQueryListRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "endTime", "Ljava/lang/String;", "getEndTime", "()Ljava/lang/String;", "order", "getOrder", "", "pageNum", "I", "getPageNum", "()I", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "queryKey", "getQueryKey", "startTime", "getStartTime", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PocketQueryListRequest extends BaseRpcRequest {
    private final String endTime;
    private final String order;
    private final int pageNum;
    private final int pageSize;
    private final String queryKey;
    private final String startTime;

    public PocketQueryListRequest() {
        this(null, 0, 0, null, null, null, 63, null);
    }

    public /* synthetic */ PocketQueryListRequest(String str, int i, int i2, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "[]" : str, (i3 & 2) != 0 ? 1 : i, (i3 & 4) != 0 ? 10 : i2, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? null : str4);
    }

    @JvmName(name = "getQueryKey")
    public final String getQueryKey() {
        return this.queryKey;
    }

    @JvmName(name = "getPageNum")
    public final int getPageNum() {
        return this.pageNum;
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getStartTime")
    public final String getStartTime() {
        return this.startTime;
    }

    @JvmName(name = "getEndTime")
    public final String getEndTime() {
        return this.endTime;
    }

    @JvmName(name = "getOrder")
    public final String getOrder() {
        return this.order;
    }

    public PocketQueryListRequest(String str, int i, int i2, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.queryKey = str;
        this.pageNum = i;
        this.pageSize = i2;
        this.startTime = str2;
        this.endTime = str3;
        this.order = str4;
    }
}
