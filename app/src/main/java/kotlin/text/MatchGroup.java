package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lkotlin/text/MatchGroup;", "", "", "component1", "()Ljava/lang/String;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", "value", "range", "copy", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Lkotlin/text/MatchGroup;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lkotlin/ranges/IntRange;", "getRange", "Ljava/lang/String;", "getValue", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MatchGroup {
    private final IntRange range;
    private final String value;

    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.value;
        }
        if ((i & 2) != 0) {
            intRange = matchGroup.range;
        }
        return matchGroup.copy(str, intRange);
    }

    /* renamed from: component1  reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component2  reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final MatchGroup copy(String value, IntRange range) {
        Intrinsics.checkNotNullParameter(value, "");
        Intrinsics.checkNotNullParameter(range, "");
        return new MatchGroup(value, range);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MatchGroup) {
            MatchGroup matchGroup = (MatchGroup) other;
            return Intrinsics.areEqual(this.value, matchGroup.value) && Intrinsics.areEqual(this.range, matchGroup.range);
        }
        return false;
    }

    public final int hashCode() {
        return (this.value.hashCode() * 31) + this.range.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MatchGroup(value=");
        sb.append(this.value);
        sb.append(", range=");
        sb.append(this.range);
        sb.append(')');
        return sb.toString();
    }

    public MatchGroup(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        this.value = str;
        this.range = intRange;
    }

    @JvmName(name = "getRange")
    public final IntRange getRange() {
        return this.range;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }
}
