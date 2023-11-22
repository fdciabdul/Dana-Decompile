package id.dana.feeds.data.share.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/share/source/network/response/PreviewActivityResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/Boolean;", "Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;", "component2", "()Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;", "shareable", "activityPreview", "copy", "(Ljava/lang/Boolean;Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;)Lid/dana/feeds/data/share/source/network/response/PreviewActivityResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;", "getActivityPreview", "Ljava/lang/Boolean;", "getShareable", "<init>", "(Ljava/lang/Boolean;Lid/dana/feeds/data/share/source/network/response/ActivityPreviewResponse;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PreviewActivityResult extends BaseRpcResult {
    private final ActivityPreviewResponse activityPreview;
    private final Boolean shareable;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.feeds.data.share.source.network.response.ActivityPreviewResponse, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PreviewActivityResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.share.source.network.response.PreviewActivityResult.<init>():void");
    }

    public static /* synthetic */ PreviewActivityResult copy$default(PreviewActivityResult previewActivityResult, Boolean bool, ActivityPreviewResponse activityPreviewResponse, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = previewActivityResult.shareable;
        }
        if ((i & 2) != 0) {
            activityPreviewResponse = previewActivityResult.activityPreview;
        }
        return previewActivityResult.copy(bool, activityPreviewResponse);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getShareable() {
        return this.shareable;
    }

    /* renamed from: component2  reason: from getter */
    public final ActivityPreviewResponse getActivityPreview() {
        return this.activityPreview;
    }

    public final PreviewActivityResult copy(Boolean shareable, ActivityPreviewResponse activityPreview) {
        return new PreviewActivityResult(shareable, activityPreview);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PreviewActivityResult) {
            PreviewActivityResult previewActivityResult = (PreviewActivityResult) other;
            return Intrinsics.areEqual(this.shareable, previewActivityResult.shareable) && Intrinsics.areEqual(this.activityPreview, previewActivityResult.activityPreview);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.shareable;
        int hashCode = bool == null ? 0 : bool.hashCode();
        ActivityPreviewResponse activityPreviewResponse = this.activityPreview;
        return (hashCode * 31) + (activityPreviewResponse != null ? activityPreviewResponse.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreviewActivityResult(shareable=");
        sb.append(this.shareable);
        sb.append(", activityPreview=");
        sb.append(this.activityPreview);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PreviewActivityResult(Boolean bool, ActivityPreviewResponse activityPreviewResponse, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Boolean.FALSE : bool, (i & 2) != 0 ? null : activityPreviewResponse);
    }

    @JvmName(name = "getShareable")
    public final Boolean getShareable() {
        return this.shareable;
    }

    @JvmName(name = "getActivityPreview")
    public final ActivityPreviewResponse getActivityPreview() {
        return this.activityPreview;
    }

    public PreviewActivityResult(Boolean bool, ActivityPreviewResponse activityPreviewResponse) {
        this.shareable = bool;
        this.activityPreview = activityPreviewResponse;
    }
}
