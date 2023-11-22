package id.dana.feeds.data.share.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004JZ\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\rJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\nR\u001a\u0010\u0013\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b%\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/share/source/network/request/PreviewActivityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "", "component4", "()Ljava/util/Map;", "", "component5", "()I", "component6", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "contentType", "contentCode", "extendInfo", "feedVersion", ShareToFeedBridge.REDIRECT_VALUE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Lid/dana/feeds/data/share/source/network/request/PreviewActivityRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getContentCode", "getContentType", "Ljava/util/Map;", "getExtendInfo", "I", "getFeedVersion", "getRedirectValue", "getShareFeedRequestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PreviewActivityRequest extends BaseRpcRequest {
    private final String contentCode;
    private final String contentType;
    private final Map<String, Object> extendInfo;
    private final int feedVersion;
    private final String redirectValue;
    private final String shareFeedRequestId;

    public static /* synthetic */ PreviewActivityRequest copy$default(PreviewActivityRequest previewActivityRequest, String str, String str2, String str3, Map map, int i, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = previewActivityRequest.shareFeedRequestId;
        }
        if ((i2 & 2) != 0) {
            str2 = previewActivityRequest.contentType;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            str3 = previewActivityRequest.contentCode;
        }
        String str6 = str3;
        Map<String, Object> map2 = map;
        if ((i2 & 8) != 0) {
            map2 = previewActivityRequest.extendInfo;
        }
        Map map3 = map2;
        if ((i2 & 16) != 0) {
            i = previewActivityRequest.feedVersion;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            str4 = previewActivityRequest.redirectValue;
        }
        return previewActivityRequest.copy(str, str5, str6, map3, i3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getShareFeedRequestId() {
        return this.shareFeedRequestId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getContentCode() {
        return this.contentCode;
    }

    public final Map<String, Object> component4() {
        return this.extendInfo;
    }

    /* renamed from: component5  reason: from getter */
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    public final PreviewActivityRequest copy(String shareFeedRequestId, String contentType, String contentCode, Map<String, ? extends Object> extendInfo, int feedVersion, String redirectValue) {
        Intrinsics.checkNotNullParameter(shareFeedRequestId, "");
        Intrinsics.checkNotNullParameter(contentType, "");
        Intrinsics.checkNotNullParameter(contentCode, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new PreviewActivityRequest(shareFeedRequestId, contentType, contentCode, extendInfo, feedVersion, redirectValue);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PreviewActivityRequest) {
            PreviewActivityRequest previewActivityRequest = (PreviewActivityRequest) other;
            return Intrinsics.areEqual(this.shareFeedRequestId, previewActivityRequest.shareFeedRequestId) && Intrinsics.areEqual(this.contentType, previewActivityRequest.contentType) && Intrinsics.areEqual(this.contentCode, previewActivityRequest.contentCode) && Intrinsics.areEqual(this.extendInfo, previewActivityRequest.extendInfo) && this.feedVersion == previewActivityRequest.feedVersion && Intrinsics.areEqual(this.redirectValue, previewActivityRequest.redirectValue);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.shareFeedRequestId.hashCode();
        int hashCode2 = this.contentType.hashCode();
        int hashCode3 = this.contentCode.hashCode();
        int hashCode4 = this.extendInfo.hashCode();
        int i = this.feedVersion;
        String str = this.redirectValue;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreviewActivityRequest(shareFeedRequestId=");
        sb.append(this.shareFeedRequestId);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", contentCode=");
        sb.append(this.contentCode);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", feedVersion=");
        sb.append(this.feedVersion);
        sb.append(", redirectValue=");
        sb.append(this.redirectValue);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PreviewActivityRequest(String str, String str2, String str3, Map map, int i, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, map, i, (i2 & 32) != 0 ? null : str4);
    }

    @JvmName(name = "getShareFeedRequestId")
    public final String getShareFeedRequestId() {
        return this.shareFeedRequestId;
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
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getFeedVersion")
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    @JvmName(name = "getRedirectValue")
    public final String getRedirectValue() {
        return this.redirectValue;
    }

    public PreviewActivityRequest(String str, String str2, String str3, Map<String, ? extends Object> map, int i, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.shareFeedRequestId = str;
        this.contentType = str2;
        this.contentCode = str3;
        this.extendInfo = map;
        this.feedVersion = i;
        this.redirectValue = str4;
    }
}
