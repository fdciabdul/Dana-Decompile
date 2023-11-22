package id.dana.feeds.data.reaction.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\b\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsUserResult;", "component2", "()Ljava/util/List;", "component3", "", "component4", "()Z", "kind", "users", "maxId", "hasNext", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)Lid/dana/feeds/data/reaction/source/network/response/ActivityReactionsResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHasNext", "Ljava/lang/String;", "getKind", "getMaxId", "Ljava/util/List;", "getUsers", "setUsers", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ActivityReactionsResult extends BaseRpcResult {
    private final boolean hasNext;
    private final String kind;
    private final String maxId;
    private List<ActivityReactionsUserResult> users;

    public ActivityReactionsResult() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActivityReactionsResult copy$default(ActivityReactionsResult activityReactionsResult, String str, List list, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activityReactionsResult.kind;
        }
        if ((i & 2) != 0) {
            list = activityReactionsResult.users;
        }
        if ((i & 4) != 0) {
            str2 = activityReactionsResult.maxId;
        }
        if ((i & 8) != 0) {
            z = activityReactionsResult.hasNext;
        }
        return activityReactionsResult.copy(str, list, str2, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    public final List<ActivityReactionsUserResult> component2() {
        return this.users;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMaxId() {
        return this.maxId;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final ActivityReactionsResult copy(String kind, List<ActivityReactionsUserResult> users, String maxId, boolean hasNext) {
        Intrinsics.checkNotNullParameter(kind, "");
        return new ActivityReactionsResult(kind, users, maxId, hasNext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ActivityReactionsResult) {
            ActivityReactionsResult activityReactionsResult = (ActivityReactionsResult) other;
            return Intrinsics.areEqual(this.kind, activityReactionsResult.kind) && Intrinsics.areEqual(this.users, activityReactionsResult.users) && Intrinsics.areEqual(this.maxId, activityReactionsResult.maxId) && this.hasNext == activityReactionsResult.hasNext;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.kind.hashCode();
        List<ActivityReactionsUserResult> list = this.users;
        int hashCode2 = list == null ? 0 : list.hashCode();
        String str = this.maxId;
        int hashCode3 = str != null ? str.hashCode() : 0;
        boolean z = this.hasNext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActivityReactionsResult(kind=");
        sb.append(this.kind);
        sb.append(", users=");
        sb.append(this.users);
        sb.append(", maxId=");
        sb.append(this.maxId);
        sb.append(", hasNext=");
        sb.append(this.hasNext);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getKind")
    public final String getKind() {
        return this.kind;
    }

    public /* synthetic */ ActivityReactionsResult(String str, List list, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? false : z);
    }

    @JvmName(name = "getUsers")
    public final List<ActivityReactionsUserResult> getUsers() {
        return this.users;
    }

    @JvmName(name = "setUsers")
    public final void setUsers(List<ActivityReactionsUserResult> list) {
        this.users = list;
    }

    @JvmName(name = "getMaxId")
    public final String getMaxId() {
        return this.maxId;
    }

    @JvmName(name = "getHasNext")
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public ActivityReactionsResult(String str, List<ActivityReactionsUserResult> list, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.kind = str;
        this.users = list;
        this.maxId = str2;
        this.hasNext = z;
    }
}
