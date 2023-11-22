package id.dana.domain.wallet_v3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserPocketAssetListModel;", "T", "", "", "hasMore", "Z", "getHasMore", "()Z", "", "pockets", "Ljava/util/List;", "getPockets", "()Ljava/util/List;", "", "totalCount", "I", "getTotalCount", "()I", "<init>", "(ZLjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserPocketAssetListModel<T> {
    private final boolean hasMore;
    private final List<T> pockets;
    private final int totalCount;

    public UserPocketAssetListModel() {
        this(false, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserPocketAssetListModel(boolean z, List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.pockets = list;
        this.totalCount = i;
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public /* synthetic */ UserPocketAssetListModel(boolean z, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getPockets")
    public final List<T> getPockets() {
        return this.pockets;
    }

    @JvmName(name = "getTotalCount")
    public final int getTotalCount() {
        return this.totalCount;
    }
}
