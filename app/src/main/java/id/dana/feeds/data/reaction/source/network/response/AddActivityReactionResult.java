package id.dana.feeds.data.reaction.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/response/AddActivityReactionResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "userId", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "kind", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/reaction/source/network/response/AddActivityReactionResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActivityId", "getKind", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AddActivityReactionResult extends BaseRpcResult {
    private final String activityId;
    private final String kind;
    private final String userId;

    public AddActivityReactionResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AddActivityReactionResult copy$default(AddActivityReactionResult addActivityReactionResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addActivityReactionResult.userId;
        }
        if ((i & 2) != 0) {
            str2 = addActivityReactionResult.activityId;
        }
        if ((i & 4) != 0) {
            str3 = addActivityReactionResult.kind;
        }
        return addActivityReactionResult.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    public final AddActivityReactionResult copy(String userId, String activityId, String kind) {
        return new AddActivityReactionResult(userId, activityId, kind);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AddActivityReactionResult) {
            AddActivityReactionResult addActivityReactionResult = (AddActivityReactionResult) other;
            return Intrinsics.areEqual(this.userId, addActivityReactionResult.userId) && Intrinsics.areEqual(this.activityId, addActivityReactionResult.activityId) && Intrinsics.areEqual(this.kind, addActivityReactionResult.kind);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.activityId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.kind;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AddActivityReactionResult(userId=");
        sb.append(this.userId);
        sb.append(", activityId=");
        sb.append(this.activityId);
        sb.append(", kind=");
        sb.append(this.kind);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ AddActivityReactionResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getKind")
    public final String getKind() {
        return this.kind;
    }

    public AddActivityReactionResult(String str, String str2, String str3) {
        this.userId = str;
        this.activityId = str2;
        this.kind = str3;
    }
}
