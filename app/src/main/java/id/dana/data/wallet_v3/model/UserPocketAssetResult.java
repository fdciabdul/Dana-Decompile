package id.dana.data.wallet_v3.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/data/wallet_v3/model/UserPocketAssetResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "", "Lid/dana/data/wallet_v3/model/UserPocketAssetEntity;", "pockets", "Ljava/util/List;", "getPockets", "()Ljava/util/List;", "setPockets", "(Ljava/util/List;)V", "", "totalCount", "I", "getTotalCount", "()I", "setTotalCount", "(I)V", "<init>", "(ZLjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserPocketAssetResult extends BaseRpcResult {
    @SerializedName("hasMore")
    private boolean hasMore;
    @SerializedName("pockets")
    private List<UserPocketAssetEntity> pockets;
    @SerializedName("totalCount")
    private int totalCount;

    public UserPocketAssetResult() {
        this(false, null, 0, 7, null);
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "setHasMore")
    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public /* synthetic */ UserPocketAssetResult(boolean z, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getPockets")
    public final List<UserPocketAssetEntity> getPockets() {
        return this.pockets;
    }

    @JvmName(name = "setPockets")
    public final void setPockets(List<UserPocketAssetEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.pockets = list;
    }

    @JvmName(name = "getTotalCount")
    public final int getTotalCount() {
        return this.totalCount;
    }

    @JvmName(name = "setTotalCount")
    public final void setTotalCount(int i) {
        this.totalCount = i;
    }

    public UserPocketAssetResult(@JSONField(name = "hasMore") boolean z, @JSONField(name = "pockets") List<UserPocketAssetEntity> list, @JSONField(name = "totalCount") int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.pockets = list;
        this.totalCount = i;
    }
}
