package id.dana.feeds.data.share.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/feeds/data/share/source/network/response/FetchShareableActivitiesResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", "", "maxId", "Ljava/lang/String;", "getMaxId", "()Ljava/lang/String;", "", "Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;", "shareableActivities", "Ljava/util/List;", "getShareableActivities", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchShareableActivitiesResponse extends BaseRpcResult {
    private final Boolean hasMore;
    private final String maxId;
    private final List<ActivityPreviewResponse> shareableActivities;

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getHasMore")
    public final Boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "getShareableActivities")
    public final List<ActivityPreviewResponse> getShareableActivities() {
        return this.shareableActivities;
    }

    public FetchShareableActivitiesResponse(String str, Boolean bool, List<ActivityPreviewResponse> list) {
        this.maxId = str;
        this.hasMore = bool;
        this.shareableActivities = list;
    }
}
