package id.dana.explore.data.sku.repository.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ:\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0018\u0010\tR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001d\u0010\t"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Ljava/io/Serializable;", "", "Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryInfo;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "digitalDestinationInquiryInfos", "displayProvider", "aggregatorGoodsId", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "Ljava/util/List;", "getDigitalDestinationInquiryInfos", "getDisplayProvider", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizDestinationInquiryResult extends BaseRpcResult implements Serializable {
    private final String aggregatorGoodsId;
    @SerializedName("digitalDestinationInquiryInfos")
    private final List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos;
    @SerializedName("displayProvider")
    private final String displayProvider;

    public BizDestinationInquiryResult() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizDestinationInquiryResult copy$default(BizDestinationInquiryResult bizDestinationInquiryResult, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bizDestinationInquiryResult.digitalDestinationInquiryInfos;
        }
        if ((i & 2) != 0) {
            str = bizDestinationInquiryResult.displayProvider;
        }
        if ((i & 4) != 0) {
            str2 = bizDestinationInquiryResult.aggregatorGoodsId;
        }
        return bizDestinationInquiryResult.copy(list, str, str2);
    }

    public final List<BizDestinationInquiryInfo> component1() {
        return this.digitalDestinationInquiryInfos;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDisplayProvider() {
        return this.displayProvider;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    public final BizDestinationInquiryResult copy(List<BizDestinationInquiryInfo> digitalDestinationInquiryInfos, String displayProvider, String aggregatorGoodsId) {
        return new BizDestinationInquiryResult(digitalDestinationInquiryInfos, displayProvider, aggregatorGoodsId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizDestinationInquiryResult) {
            BizDestinationInquiryResult bizDestinationInquiryResult = (BizDestinationInquiryResult) other;
            return Intrinsics.areEqual(this.digitalDestinationInquiryInfos, bizDestinationInquiryResult.digitalDestinationInquiryInfos) && Intrinsics.areEqual(this.displayProvider, bizDestinationInquiryResult.displayProvider) && Intrinsics.areEqual(this.aggregatorGoodsId, bizDestinationInquiryResult.aggregatorGoodsId);
        }
        return false;
    }

    public final int hashCode() {
        List<BizDestinationInquiryInfo> list = this.digitalDestinationInquiryInfos;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.displayProvider;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.aggregatorGoodsId;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizDestinationInquiryResult(digitalDestinationInquiryInfos=");
        sb.append(this.digitalDestinationInquiryInfos);
        sb.append(", displayProvider=");
        sb.append(this.displayProvider);
        sb.append(", aggregatorGoodsId=");
        sb.append(this.aggregatorGoodsId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ BizDestinationInquiryResult(List list, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    @JvmName(name = "getDigitalDestinationInquiryInfos")
    public final List<BizDestinationInquiryInfo> getDigitalDestinationInquiryInfos() {
        return this.digitalDestinationInquiryInfos;
    }

    @JvmName(name = "getDisplayProvider")
    public final String getDisplayProvider() {
        return this.displayProvider;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    public BizDestinationInquiryResult(List<BizDestinationInquiryInfo> list, String str, String str2) {
        this.digitalDestinationInquiryInfos = list;
        this.displayProvider = str;
        this.aggregatorGoodsId = str2;
    }
}
