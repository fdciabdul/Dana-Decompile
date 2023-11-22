package id.dana.wallet_v3.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/wallet_v3/model/NewPocketQueryListModel;", "T", "", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "", "pockets", "Ljava/util/List;", "getPockets", "()Ljava/util/List;", "", "totalCount", "I", "getTotalCount", "()I", "setTotalCount", "(I)V", "<init>", "(ZLjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewPocketQueryListModel<T> {
    private boolean hasMore;
    private final List<T> pockets;
    private int totalCount;

    public NewPocketQueryListModel() {
        this(false, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewPocketQueryListModel(boolean z, List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.pockets = list;
        this.totalCount = i;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "setHasMore")
    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public /* synthetic */ NewPocketQueryListModel(boolean z, ArrayList arrayList, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? new ArrayList() : arrayList, (i2 & 4) != 0 ? -1 : i);
    }

    @JvmName(name = "getPockets")
    public final List<T> getPockets() {
        return this.pockets;
    }

    @JvmName(name = "getTotalCount")
    public final int getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "setTotalCount")
    public final void setTotalCount(int i) {
        this.totalCount = i;
    }
}
