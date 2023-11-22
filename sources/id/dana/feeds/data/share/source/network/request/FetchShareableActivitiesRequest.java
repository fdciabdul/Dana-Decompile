package id.dana.feeds.data.share.source.network.request;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006"}, d2 = {"Lid/dana/feeds/data/share/source/network/request/FetchShareableActivitiesRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "feedVersion", "I", "getFeedVersion", "()I", "", "maxId", "Ljava/lang/String;", "getMaxId", "()Ljava/lang/String;", SecurityConstants.KEY_PAGE_SIZE, "getPageSize", "<init>", "(ILjava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchShareableActivitiesRequest extends BaseRpcRequest {
    private final int feedVersion;
    private final String maxId;
    private final int pageSize;

    public FetchShareableActivitiesRequest() {
        this(0, null, 0, 7, null);
    }

    public /* synthetic */ FetchShareableActivitiesRequest(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 8 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 4 : i2);
    }

    @JvmName(name = "getPageSize")
    public final int getPageSize() {
        return this.pageSize;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getFeedVersion")
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    public FetchShareableActivitiesRequest(int i, String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pageSize = i;
        this.maxId = str;
        this.feedVersion = i2;
    }
}
