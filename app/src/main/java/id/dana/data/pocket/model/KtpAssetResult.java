package id.dana.data.pocket.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0003\u0010\f\u001a\u00020\u0002\u0012\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0003\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\f\u001a\u00020\u00022\u000e\b\u0003\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u001cR(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010 R\"\u0010\u000e\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010$"}, d2 = {"Lid/dana/data/pocket/model/KtpAssetResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Z", "", "Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "component2", "()Ljava/util/List;", "", "component3", "()I", "hasMore", "pockets", "totalCount", "copy", "(ZLjava/util/List;I)Lid/dana/data/pocket/model/KtpAssetResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Z", "getHasMore", "setHasMore", "(Z)V", "Ljava/util/List;", "getPockets", "setPockets", "(Ljava/util/List;)V", "I", "getTotalCount", "setTotalCount", "(I)V", "<init>", "(ZLjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class KtpAssetResult extends BaseRpcResult {
    @SerializedName("hasMore")
    private boolean hasMore;
    @SerializedName("pockets")
    private List<KtpResult> pockets;
    @SerializedName("totalCount")
    private int totalCount;

    public KtpAssetResult() {
        this(false, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KtpAssetResult copy$default(KtpAssetResult ktpAssetResult, boolean z, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = ktpAssetResult.hasMore;
        }
        if ((i2 & 2) != 0) {
            list = ktpAssetResult.pockets;
        }
        if ((i2 & 4) != 0) {
            i = ktpAssetResult.totalCount;
        }
        return ktpAssetResult.copy(z, list, i);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<KtpResult> component2() {
        return this.pockets;
    }

    /* renamed from: component3  reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final KtpAssetResult copy(@JSONField(name = "hasMore") boolean hasMore, @JSONField(name = "pockets") List<KtpResult> pockets, @JSONField(name = "totalCount") int totalCount) {
        Intrinsics.checkNotNullParameter(pockets, "");
        return new KtpAssetResult(hasMore, pockets, totalCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KtpAssetResult) {
            KtpAssetResult ktpAssetResult = (KtpAssetResult) other;
            return this.hasMore == ktpAssetResult.hasMore && Intrinsics.areEqual(this.pockets, ktpAssetResult.pockets) && this.totalCount == ktpAssetResult.totalCount;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z = this.hasMore;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.pockets.hashCode()) * 31) + this.totalCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KtpAssetResult(hasMore=");
        sb.append(this.hasMore);
        sb.append(", pockets=");
        sb.append(this.pockets);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getHasMore")
    public final boolean getHasMore() {
        return this.hasMore;
    }

    @JvmName(name = "setHasMore")
    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public /* synthetic */ KtpAssetResult(boolean z, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getPockets")
    public final List<KtpResult> getPockets() {
        return this.pockets;
    }

    @JvmName(name = "setPockets")
    public final void setPockets(List<KtpResult> list) {
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

    public KtpAssetResult(@JSONField(name = "hasMore") boolean z, @JSONField(name = "pockets") List<KtpResult> list, @JSONField(name = "totalCount") int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.hasMore = z;
        this.pockets = list;
        this.totalCount = i;
    }
}
