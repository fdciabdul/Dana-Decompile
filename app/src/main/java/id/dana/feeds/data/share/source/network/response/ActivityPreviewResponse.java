package id.dana.feeds.data.share.source.network.response;

import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.data.timeline.source.network.response.ActivityWidgetResult;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012*\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\t\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJz\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022,\b\u0002\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b!\u0010\u0004R>\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010\u000e"}, d2 = {"Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component4", "()Ljava/util/HashMap;", "component5", "Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;", "component6", "()Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;", "iconUrl", "content", "contentType", "extendInfo", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, ShareToFeedBridge.WIDGET, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;)Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContent", "getContentType", "Ljava/util/HashMap;", "getExtendInfo", "getIconUrl", "getShareFeedRequestId", "Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;", "getWidget", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Lid/dana/feeds/data/timeline/source/network/response/ActivityWidgetResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActivityPreviewResponse {
    private final String content;
    private final String contentType;
    private final HashMap<String, String> extendInfo;
    private final String iconUrl;
    private final String shareFeedRequestId;
    private final ActivityWidgetResult widget;

    public static /* synthetic */ ActivityPreviewResponse copy$default(ActivityPreviewResponse activityPreviewResponse, String str, String str2, String str3, HashMap hashMap, String str4, ActivityWidgetResult activityWidgetResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityPreviewResponse.iconUrl;
        }
        if ((i & 2) != 0) {
            str2 = activityPreviewResponse.content;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = activityPreviewResponse.contentType;
        }
        String str6 = str3;
        HashMap<String, String> hashMap2 = hashMap;
        if ((i & 8) != 0) {
            hashMap2 = activityPreviewResponse.extendInfo;
        }
        HashMap hashMap3 = hashMap2;
        if ((i & 16) != 0) {
            str4 = activityPreviewResponse.shareFeedRequestId;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            activityWidgetResult = activityPreviewResponse.widget;
        }
        return activityPreviewResponse.copy(str, str5, str6, hashMap3, str7, activityWidgetResult);
    }

    /* renamed from: component1  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3  reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    public final HashMap<String, String> component4() {
        return this.extendInfo;
    }

    /* renamed from: component5  reason: from getter */
    public final String getShareFeedRequestId() {
        return this.shareFeedRequestId;
    }

    /* renamed from: component6  reason: from getter */
    public final ActivityWidgetResult getWidget() {
        return this.widget;
    }

    public final ActivityPreviewResponse copy(String iconUrl, String content, String contentType, HashMap<String, String> extendInfo, String shareFeedRequestId, ActivityWidgetResult widget) {
        return new ActivityPreviewResponse(iconUrl, content, contentType, extendInfo, shareFeedRequestId, widget);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ActivityPreviewResponse) {
            ActivityPreviewResponse activityPreviewResponse = (ActivityPreviewResponse) other;
            return Intrinsics.areEqual(this.iconUrl, activityPreviewResponse.iconUrl) && Intrinsics.areEqual(this.content, activityPreviewResponse.content) && Intrinsics.areEqual(this.contentType, activityPreviewResponse.contentType) && Intrinsics.areEqual(this.extendInfo, activityPreviewResponse.extendInfo) && Intrinsics.areEqual(this.shareFeedRequestId, activityPreviewResponse.shareFeedRequestId) && Intrinsics.areEqual(this.widget, activityPreviewResponse.widget);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.iconUrl;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.content;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.contentType;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        HashMap<String, String> hashMap = this.extendInfo;
        int hashCode4 = hashMap == null ? 0 : hashMap.hashCode();
        String str4 = this.shareFeedRequestId;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        ActivityWidgetResult activityWidgetResult = this.widget;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (activityWidgetResult != null ? activityWidgetResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityPreviewResponse(iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", shareFeedRequestId=");
        sb.append(this.shareFeedRequestId);
        sb.append(", widget=");
        sb.append(this.widget);
        sb.append(')');
        return sb.toString();
    }

    public ActivityPreviewResponse(String str, String str2, String str3, HashMap<String, String> hashMap, String str4, ActivityWidgetResult activityWidgetResult) {
        this.iconUrl = str;
        this.content = str2;
        this.contentType = str3;
        this.extendInfo = hashMap;
        this.shareFeedRequestId = str4;
        this.widget = activityWidgetResult;
    }

    public /* synthetic */ ActivityPreviewResponse(String str, String str2, String str3, HashMap hashMap, String str4, ActivityWidgetResult activityWidgetResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, hashMap, str4, (i & 32) != 0 ? null : activityWidgetResult);
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

    @JvmName(name = "getWidget")
    public final ActivityWidgetResult getWidget() {
        return this.widget;
    }
}
