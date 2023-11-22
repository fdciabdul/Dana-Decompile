package id.dana.explore.data.sku.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.explore.data.sku.repository.source.network.response.QueryLastSuccessfulTransactionResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/request/BizDestinationInquiryRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "Lid/dana/explore/data/sku/repository/source/network/request/BizDestination;", "component2", "()Lid/dana/explore/data/sku/repository/source/network/request/BizDestination;", "goodsId", "destinationParams", "copy", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/BizDestination;)Lid/dana/explore/data/sku/repository/source/network/request/BizDestinationInquiryRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/explore/data/sku/repository/source/network/request/BizDestination;", "getDestinationParams", "Ljava/lang/String;", "getGoodsId", "<init>", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/request/BizDestination;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizDestinationInquiryRequest extends BaseRpcRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BizDestination destinationParams;
    @SerializedName("goodsId")
    private final String goodsId;

    public static /* synthetic */ BizDestinationInquiryRequest copy$default(BizDestinationInquiryRequest bizDestinationInquiryRequest, String str, BizDestination bizDestination, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bizDestinationInquiryRequest.goodsId;
        }
        if ((i & 2) != 0) {
            bizDestination = bizDestinationInquiryRequest.destinationParams;
        }
        return bizDestinationInquiryRequest.copy(str, bizDestination);
    }

    /* renamed from: component1  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component2  reason: from getter */
    public final BizDestination getDestinationParams() {
        return this.destinationParams;
    }

    public final BizDestinationInquiryRequest copy(String goodsId, BizDestination destinationParams) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(destinationParams, "");
        return new BizDestinationInquiryRequest(goodsId, destinationParams);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizDestinationInquiryRequest) {
            BizDestinationInquiryRequest bizDestinationInquiryRequest = (BizDestinationInquiryRequest) other;
            return Intrinsics.areEqual(this.goodsId, bizDestinationInquiryRequest.goodsId) && Intrinsics.areEqual(this.destinationParams, bizDestinationInquiryRequest.destinationParams);
        }
        return false;
    }

    public final int hashCode() {
        return (this.goodsId.hashCode() * 31) + this.destinationParams.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizDestinationInquiryRequest(goodsId=");
        sb.append(this.goodsId);
        sb.append(", destinationParams=");
        sb.append(this.destinationParams);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getDestinationParams")
    public final BizDestination getDestinationParams() {
        return this.destinationParams;
    }

    public BizDestinationInquiryRequest(String str, BizDestination bizDestination) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bizDestination, "");
        this.goodsId = str;
        this.destinationParams = bizDestination;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/request/BizDestinationInquiryRequest$Companion;", "", "Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;", "result", "Lid/dana/explore/data/sku/repository/source/network/request/BizDestinationInquiryRequest;", "fromLastSuccessfulTransaction", "(Lid/dana/explore/data/sku/repository/source/network/response/QueryLastSuccessfulTransactionResponse;)Lid/dana/explore/data/sku/repository/source/network/request/BizDestinationInquiryRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public final BizDestinationInquiryRequest fromLastSuccessfulTransaction(QueryLastSuccessfulTransactionResponse result) {
            BizIds bizIds;
            BizIds bizIds2;
            Intrinsics.checkNotNullParameter(result, "");
            List<BizIds> bizIds3 = result.getBizIds();
            ?? r2 = 0;
            String goodsId = (bizIds3 == null || (bizIds2 = (BizIds) CollectionsKt.firstOrNull((List) bizIds3)) == null) ? null : bizIds2.getGoodsId();
            if (goodsId == null) {
                goodsId = "";
            }
            List<BizIds> bizIds4 = result.getBizIds();
            String bizId = (bizIds4 == null || (bizIds = (BizIds) CollectionsKt.firstOrNull((List) bizIds4)) == null) ? null : bizIds.getBizId();
            return new BizDestinationInquiryRequest(goodsId, new BizDestination(bizId != null ? bizId : "", r2, 2, r2));
        }
    }
}
