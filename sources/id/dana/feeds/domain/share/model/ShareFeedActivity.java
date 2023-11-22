package id.dana.feeds.domain.share.model;

import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/feeds/domain/share/model/ShareFeedActivity;", "", "", "isShareFeedActivityValid", "()Z", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "previewActivityData", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "getPreviewActivityData", "()Lid/dana/feeds/domain/share/model/PreviewActivityData;", "", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "Ljava/lang/String;", "getShareFeedRequestId", "()Ljava/lang/String;", "<init>", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareFeedActivity {
    private final PreviewActivityData previewActivityData;
    private final String shareFeedRequestId;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String, id.dana.feeds.domain.share.model.PreviewActivityData] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ShareFeedActivity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.share.model.ShareFeedActivity.<init>():void");
    }

    public ShareFeedActivity(PreviewActivityData previewActivityData, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.previewActivityData = previewActivityData;
        this.shareFeedRequestId = str;
    }

    public /* synthetic */ ShareFeedActivity(PreviewActivityData previewActivityData, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : previewActivityData, (i & 2) != 0 ? "" : str);
    }

    @JvmName(name = "getPreviewActivityData")
    public final PreviewActivityData getPreviewActivityData() {
        return this.previewActivityData;
    }

    @JvmName(name = "getShareFeedRequestId")
    public final String getShareFeedRequestId() {
        return this.shareFeedRequestId;
    }

    public final boolean isShareFeedActivityValid() {
        if (this.previewActivityData != null) {
            return this.shareFeedRequestId.length() > 0;
        }
        return false;
    }
}
