package id.dana.drawable.search;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/nearbyrevamp/search/ExploreSectionType;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "TRENDING_SEARCH", "EXPLORE"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ExploreSectionType {
    TRENDING_SEARCH(0),
    EXPLORE(1);

    private final int value;

    ExploreSectionType(int i) {
        this.value = i;
    }

    @JvmName(name = "getValue")
    public final int getValue() {
        return this.value;
    }
}
