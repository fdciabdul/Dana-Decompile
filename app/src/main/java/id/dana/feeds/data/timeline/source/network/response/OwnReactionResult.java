package id.dana.feeds.data.timeline.source.network.response;

import id.dana.feeds.domain.timeline.model.OwnReaction;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/timeline/source/network/response/OwnReactionResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "id", "kind", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/timeline/source/network/response/OwnReactionResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/feeds/domain/timeline/model/OwnReaction;", "toOwnReaction", "()Lid/dana/feeds/domain/timeline/model/OwnReaction;", "toString", "Ljava/lang/String;", "getId", "getKind", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OwnReactionResult {
    private final String id;
    private final String kind;

    public static /* synthetic */ OwnReactionResult copy$default(OwnReactionResult ownReactionResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ownReactionResult.id;
        }
        if ((i & 2) != 0) {
            str2 = ownReactionResult.kind;
        }
        return ownReactionResult.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    public final OwnReactionResult copy(String id2, String kind) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(kind, "");
        return new OwnReactionResult(id2, kind);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof OwnReactionResult) {
            OwnReactionResult ownReactionResult = (OwnReactionResult) other;
            return Intrinsics.areEqual(this.id, ownReactionResult.id) && Intrinsics.areEqual(this.kind, ownReactionResult.kind);
        }
        return false;
    }

    public final int hashCode() {
        return (this.id.hashCode() * 31) + this.kind.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OwnReactionResult(id=");
        sb.append(this.id);
        sb.append(", kind=");
        sb.append(this.kind);
        sb.append(')');
        return sb.toString();
    }

    public OwnReactionResult(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.id = str;
        this.kind = str2;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getKind")
    public final String getKind() {
        return this.kind;
    }

    public final OwnReaction toOwnReaction() {
        return new OwnReaction(this.id, this.kind);
    }
}
