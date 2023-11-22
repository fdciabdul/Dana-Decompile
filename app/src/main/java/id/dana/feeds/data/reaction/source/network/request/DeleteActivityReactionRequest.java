package id.dana.feeds.data.reaction.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/request/DeleteActivityReactionRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", ExtendInfoUtilKt.EXTEND_INFO_REACTION_ID, ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/reaction/source/network/request/DeleteActivityReactionRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActivityId", "getReactionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeleteActivityReactionRequest extends BaseRpcRequest {
    private final String activityId;
    private final String reactionId;

    public static /* synthetic */ DeleteActivityReactionRequest copy$default(DeleteActivityReactionRequest deleteActivityReactionRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteActivityReactionRequest.reactionId;
        }
        if ((i & 2) != 0) {
            str2 = deleteActivityReactionRequest.activityId;
        }
        return deleteActivityReactionRequest.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getReactionId() {
        return this.reactionId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    public final DeleteActivityReactionRequest copy(String reactionId, String activityId) {
        Intrinsics.checkNotNullParameter(activityId, "");
        return new DeleteActivityReactionRequest(reactionId, activityId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DeleteActivityReactionRequest) {
            DeleteActivityReactionRequest deleteActivityReactionRequest = (DeleteActivityReactionRequest) other;
            return Intrinsics.areEqual(this.reactionId, deleteActivityReactionRequest.reactionId) && Intrinsics.areEqual(this.activityId, deleteActivityReactionRequest.activityId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.reactionId;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.activityId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeleteActivityReactionRequest(reactionId=");
        sb.append(this.reactionId);
        sb.append(", activityId=");
        sb.append(this.activityId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ DeleteActivityReactionRequest(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2);
    }

    @JvmName(name = "getReactionId")
    public final String getReactionId() {
        return this.reactionId;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    public DeleteActivityReactionRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "");
        this.reactionId = str;
        this.activityId = str2;
    }
}
