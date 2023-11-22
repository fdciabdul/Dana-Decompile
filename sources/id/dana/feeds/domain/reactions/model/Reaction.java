package id.dana.feeds.domain.reactions.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/reactions/model/Reaction;", "", "", "component1", "()Ljava/lang/String;", "component2", "kind", "name", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/domain/reactions/model/Reaction;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getKind", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Reaction {
    private final String kind;
    private final String name;

    public static /* synthetic */ Reaction copy$default(Reaction reaction, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reaction.kind;
        }
        if ((i & 2) != 0) {
            str2 = reaction.name;
        }
        return reaction.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKind() {
        return this.kind;
    }

    /* renamed from: component2  reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Reaction copy(String kind, String name) {
        Intrinsics.checkNotNullParameter(kind, "");
        Intrinsics.checkNotNullParameter(name, "");
        return new Reaction(kind, name);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Reaction) {
            Reaction reaction = (Reaction) other;
            return Intrinsics.areEqual(this.kind, reaction.kind) && Intrinsics.areEqual(this.name, reaction.name);
        }
        return false;
    }

    public final int hashCode() {
        return (this.kind.hashCode() * 31) + this.name.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reaction(kind=");
        sb.append(this.kind);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(')');
        return sb.toString();
    }

    public Reaction(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.kind = str;
        this.name = str2;
    }

    @JvmName(name = "getKind")
    public final String getKind() {
        return this.kind;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }
}
