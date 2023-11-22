package id.dana.data.pocket.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\b\b\u0003\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/pocket/model/PocketQueryListResult;", "T", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "hasMore", "Z", "getHasMore", "()Z", "", "pockets", "Ljava/util/List;", "getPockets", "()Ljava/util/List;", "", "totalCount", "I", "getTotalCount", "()I", "<init>", "(ZLjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PocketQueryListResult<T> extends BaseRpcResult {
    @SerializedName("hasMore")
    private final boolean hasMore;
    @SerializedName("pockets")
    private final List<T> pockets;
    @SerializedName("totalCount")
    private final int totalCount;

    public PocketQueryListResult() {
        this(false, null, 0, 7, null);
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public /* synthetic */ PocketQueryListResult(boolean z, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public PocketQueryListResult(@JSONField(name = "hasMore") boolean z, @JSONField(name = "pockets") List<? extends T> list, @JSONField(name = "totalCount") int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.pockets = list;
        this.totalCount = i;
    }
}
