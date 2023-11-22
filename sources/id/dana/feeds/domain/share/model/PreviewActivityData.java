package id.dana.feeds.domain.share.model;

import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012*\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J4\u0010\f\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0086\u0001\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052,\b\u0002\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010\u0007R\u0017\u0010\u0015\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u0007R\u001a\u0010\u0016\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b&\u0010\u0007R>\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\nj\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b)\u0010\u0007R\"\u0010\u0019\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010*\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b+\u0010,R\u001a\u0010\u0018\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010$\u001a\u0004\b-\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u0012"}, d2 = {"Lid/dana/feeds/domain/share/model/PreviewActivityData;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component5", "()Ljava/util/HashMap;", "component6", "component7", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "component8", "()Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "shareable", "iconUrl", "content", "contentType", "extendInfo", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "isSkip", ShareToFeedBridge.WIDGET, "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;ZLid/dana/feeds/domain/timeline/model/ActivityWidget;)Lid/dana/feeds/domain/share/model/PreviewActivityData;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContent", "getContentType", "Ljava/util/HashMap;", "getExtendInfo", "getIconUrl", "Z", "setSkip", "(Z)V", "getShareFeedRequestId", "getShareable", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "getWidget", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;ZLid/dana/feeds/domain/timeline/model/ActivityWidget;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PreviewActivityData {
    private final String content;
    private final String contentType;
    private final HashMap<String, String> extendInfo;
    private final String iconUrl;
    private boolean isSkip;
    private final String shareFeedRequestId;
    private final boolean shareable;
    private final ActivityWidget widget;

    /* renamed from: component1  reason: from getter */
    public final boolean getShareable() {
        return this.shareable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component3  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4  reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    public final HashMap<String, String> component5() {
        return this.extendInfo;
    }

    /* renamed from: component6  reason: from getter */
    public final String getShareFeedRequestId() {
        return this.shareFeedRequestId;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getIsSkip() {
        return this.isSkip;
    }

    /* renamed from: component8  reason: from getter */
    public final ActivityWidget getWidget() {
        return this.widget;
    }

    public final PreviewActivityData copy(boolean shareable, String iconUrl, String content, String contentType, HashMap<String, String> extendInfo, String shareFeedRequestId, boolean isSkip, ActivityWidget widget) {
        Intrinsics.checkNotNullParameter(iconUrl, "");
        Intrinsics.checkNotNullParameter(content, "");
        Intrinsics.checkNotNullParameter(contentType, "");
        Intrinsics.checkNotNullParameter(shareFeedRequestId, "");
        return new PreviewActivityData(shareable, iconUrl, content, contentType, extendInfo, shareFeedRequestId, isSkip, widget);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PreviewActivityData) {
            PreviewActivityData previewActivityData = (PreviewActivityData) other;
            return this.shareable == previewActivityData.shareable && Intrinsics.areEqual(this.iconUrl, previewActivityData.iconUrl) && Intrinsics.areEqual(this.content, previewActivityData.content) && Intrinsics.areEqual(this.contentType, previewActivityData.contentType) && Intrinsics.areEqual(this.extendInfo, previewActivityData.extendInfo) && Intrinsics.areEqual(this.shareFeedRequestId, previewActivityData.shareFeedRequestId) && this.isSkip == previewActivityData.isSkip && Intrinsics.areEqual(this.widget, previewActivityData.widget);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        boolean z = this.shareable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.iconUrl.hashCode();
        int hashCode2 = this.content.hashCode();
        int hashCode3 = this.contentType.hashCode();
        HashMap<String, String> hashMap = this.extendInfo;
        int hashCode4 = hashMap == null ? 0 : hashMap.hashCode();
        int hashCode5 = this.shareFeedRequestId.hashCode();
        boolean z2 = this.isSkip;
        int i = z2 ? 1 : z2 ? 1 : 0;
        ActivityWidget activityWidget = this.widget;
        return (((((((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i) * 31) + (activityWidget != null ? activityWidget.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreviewActivityData(shareable=");
        sb.append(this.shareable);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", shareFeedRequestId=");
        sb.append(this.shareFeedRequestId);
        sb.append(", isSkip=");
        sb.append(this.isSkip);
        sb.append(", widget=");
        sb.append(this.widget);
        sb.append(')');
        return sb.toString();
    }

    public PreviewActivityData(boolean z, String str, String str2, String str3, HashMap<String, String> hashMap, String str4, boolean z2, ActivityWidget activityWidget) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.shareable = z;
        this.iconUrl = str;
        this.content = str2;
        this.contentType = str3;
        this.extendInfo = hashMap;
        this.shareFeedRequestId = str4;
        this.isSkip = z2;
        this.widget = activityWidget;
    }

    public /* synthetic */ PreviewActivityData(boolean z, String str, String str2, String str3, HashMap hashMap, String str4, boolean z2, ActivityWidget activityWidget, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, str3, hashMap, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? null : activityWidget);
    }

    @JvmName(name = "getShareable")
    public final boolean getShareable() {
        return this.shareable;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "getExtendInfo")
    public final HashMap<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getShareFeedRequestId")
    public final String getShareFeedRequestId() {
        return this.shareFeedRequestId;
    }

    @JvmName(name = "isSkip")
    public final boolean isSkip() {
        return this.isSkip;
    }

    @JvmName(name = "setSkip")
    public final void setSkip(boolean z) {
        this.isSkip = z;
    }

    @JvmName(name = "getWidget")
    public final ActivityWidget getWidget() {
        return this.widget;
    }
}
