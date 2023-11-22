package id.dana.feeds.data.share.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012,\b\u0002\u0010\r\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R>\u0010\r\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bj\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "caption", "Ljava/lang/String;", "getCaption", "()Ljava/lang/String;", "contentCode", "getContentCode", "contentType", "getContentType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extendInfo", "Ljava/util/HashMap;", "getExtendInfo", "()Ljava/util/HashMap;", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "getShareFeedRequestId", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", ShareToFeedBridge.WIDGET, "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "getWidget", "()Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lid/dana/feeds/domain/timeline/model/ActivityWidget;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateActivityRequest extends BaseRpcRequest {
    private final String caption;
    private final String contentCode;
    private final String contentType;
    private final HashMap<String, String> extendInfo;
    private final String shareFeedRequestId;
    private final ActivityWidget widget;

    public /* synthetic */ CreateActivityRequest(String str, String str2, String str3, String str4, HashMap hashMap, ActivityWidget activityWidget, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : hashMap, (i & 32) != 0 ? null : activityWidget);
    }

    @JvmName(name = "getShareFeedRequestId")
    public final String getShareFeedRequestId() {
        return this.shareFeedRequestId;
    }

    @JvmName(name = "getCaption")
    public final String getCaption() {
        return this.caption;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "getContentCode")
    public final String getContentCode() {
        return this.contentCode;
    }

    @JvmName(name = "getExtendInfo")
    public final HashMap<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getWidget")
    public final ActivityWidget getWidget() {
        return this.widget;
    }

    public CreateActivityRequest(String str, String str2, String str3, String str4, HashMap<String, String> hashMap, ActivityWidget activityWidget) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.shareFeedRequestId = str;
        this.caption = str2;
        this.contentType = str3;
        this.contentCode = str4;
        this.extendInfo = hashMap;
        this.widget = activityWidget;
    }
}
