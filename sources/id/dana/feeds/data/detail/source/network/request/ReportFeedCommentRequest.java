package id.dana.feeds.data.detail.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/detail/source/network/request/ReportFeedCommentRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "id", ZdocRecordService.REASON, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/detail/source/network/request/ReportFeedCommentRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getId", "getReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ReportFeedCommentRequest extends BaseRpcRequest {
    private final String id;
    private final String reason;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ReportFeedCommentRequest() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.detail.source.network.request.ReportFeedCommentRequest.<init>():void");
    }

    public static /* synthetic */ ReportFeedCommentRequest copy$default(ReportFeedCommentRequest reportFeedCommentRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reportFeedCommentRequest.id;
        }
        if ((i & 2) != 0) {
            str2 = reportFeedCommentRequest.reason;
        }
        return reportFeedCommentRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public final ReportFeedCommentRequest copy(String id2, String reason) {
        return new ReportFeedCommentRequest(id2, reason);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ReportFeedCommentRequest) {
            ReportFeedCommentRequest reportFeedCommentRequest = (ReportFeedCommentRequest) other;
            return Intrinsics.areEqual(this.id, reportFeedCommentRequest.id) && Intrinsics.areEqual(this.reason, reportFeedCommentRequest.reason);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.id;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.reason;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReportFeedCommentRequest(id=");
        sb.append(this.id);
        sb.append(", reason=");
        sb.append(this.reason);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ReportFeedCommentRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getReason")
    public final String getReason() {
        return this.reason;
    }

    public ReportFeedCommentRequest(String str, String str2) {
        this.id = str;
        this.reason = str2;
    }
}
