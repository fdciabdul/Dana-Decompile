package id.dana.explore.data.globalsearch.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR\"\u0010\r\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001fR(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/explore/data/globalsearch/model/PopularSearchCache;", "", "", "component1", "()J", "", "component2", "()I", "", "", "component3", "()Ljava/util/List;", "lastFetchDate", "lastIndex", "popularSearch", "copy", "(JILjava/util/List;)Lid/dana/explore/data/globalsearch/model/PopularSearchCache;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "J", "getLastFetchDate", "setLastFetchDate", "(J)V", "I", "getLastIndex", "setLastIndex", "(I)V", "Ljava/util/List;", "getPopularSearch", "setPopularSearch", "(Ljava/util/List;)V", "<init>", "(JILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PopularSearchCache {
    private long lastFetchDate;
    private int lastIndex;
    private List<String> popularSearch;

    public PopularSearchCache() {
        this(0L, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PopularSearchCache copy$default(PopularSearchCache popularSearchCache, long j, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = popularSearchCache.lastFetchDate;
        }
        if ((i2 & 2) != 0) {
            i = popularSearchCache.lastIndex;
        }
        if ((i2 & 4) != 0) {
            list = popularSearchCache.popularSearch;
        }
        return popularSearchCache.copy(j, i, list);
    }

    /* renamed from: component1  reason: from getter */
    public final long getLastFetchDate() {
        return this.lastFetchDate;
    }

    /* renamed from: component2  reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    public final List<String> component3() {
        return this.popularSearch;
    }

    public final PopularSearchCache copy(long lastFetchDate, int lastIndex, List<String> popularSearch) {
        Intrinsics.checkNotNullParameter(popularSearch, "");
        return new PopularSearchCache(lastFetchDate, lastIndex, popularSearch);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PopularSearchCache) {
            PopularSearchCache popularSearchCache = (PopularSearchCache) other;
            return this.lastFetchDate == popularSearchCache.lastFetchDate && this.lastIndex == popularSearchCache.lastIndex && Intrinsics.areEqual(this.popularSearch, popularSearchCache.popularSearch);
        }
        return false;
    }

    public final int hashCode() {
        return (((Cbor$Arg$$ExternalSyntheticBackport0.m(this.lastFetchDate) * 31) + this.lastIndex) * 31) + this.popularSearch.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PopularSearchCache(lastFetchDate=");
        sb.append(this.lastFetchDate);
        sb.append(", lastIndex=");
        sb.append(this.lastIndex);
        sb.append(", popularSearch=");
        sb.append(this.popularSearch);
        sb.append(')');
        return sb.toString();
    }

    public PopularSearchCache(long j, int i, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.lastFetchDate = j;
        this.lastIndex = i;
        this.popularSearch = list;
    }

    @JvmName(name = "getLastFetchDate")
    public final long getLastFetchDate() {
        return this.lastFetchDate;
    }

    @JvmName(name = "setLastFetchDate")
    public final void setLastFetchDate(long j) {
        this.lastFetchDate = j;
    }

    @JvmName(name = "getLastIndex")
    public final int getLastIndex() {
        return this.lastIndex;
    }

    @JvmName(name = "setLastIndex")
    public final void setLastIndex(int i) {
        this.lastIndex = i;
    }

    public /* synthetic */ PopularSearchCache(long j, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1L : j, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getPopularSearch")
    public final List<String> getPopularSearch() {
        return this.popularSearch;
    }

    @JvmName(name = "setPopularSearch")
    public final void setPopularSearch(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.popularSearch = list;
    }
}
