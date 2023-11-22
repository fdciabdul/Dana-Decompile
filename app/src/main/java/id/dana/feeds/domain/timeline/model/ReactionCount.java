package id.dana.feeds.domain.timeline.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/timeline/model/ReactionCount;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "kind", "count", "copy", "(Ljava/lang/String;I)Lid/dana/feeds/domain/timeline/model/ReactionCount;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getCount", "Ljava/lang/String;", "getKind", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ReactionCount {
    private final int count;
    private final String kind;

    public static /* synthetic */ ReactionCount copy$default(ReactionCount reactionCount, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = reactionCount.kind;
        }
        if ((i2 & 2) != 0) {
            i = reactionCount.count;
        }
        return reactionCount.copy(str, i);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    /* renamed from: component2  reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final ReactionCount copy(String kind, int count) {
        Intrinsics.checkNotNullParameter(kind, "");
        return new ReactionCount(kind, count);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ReactionCount) {
            ReactionCount reactionCount = (ReactionCount) other;
            return Intrinsics.areEqual(this.kind, reactionCount.kind) && this.count == reactionCount.count;
        }
        return false;
    }

    public final int hashCode() {
        return (this.kind.hashCode() * 31) + this.count;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReactionCount(kind=");
        sb.append(this.kind);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(')');
        return sb.toString();
    }

    public ReactionCount(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        this.kind = str;
        this.count = i;
    }

    @JvmName(name = "getKind")
    public final String getKind() {
        return this.kind;
    }

    @JvmName(name = "getCount")
    public final int getCount() {
        return this.count;
    }
}
