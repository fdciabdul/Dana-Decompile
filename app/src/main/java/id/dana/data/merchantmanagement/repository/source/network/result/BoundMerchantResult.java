package id.dana.data.merchantmanagement.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.merchantmanagement.model.MerchantInfoDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ6\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0014\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\f\u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\u001bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000b\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\u001b"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/data/merchantmanagement/model/MerchantInfoDTO;", "component1", "()Ljava/util/List;", "", "component2", "()I", "component3", "merchantInfoList", "totalPageNumber", "currentPage", "copy", "(Ljava/util/List;II)Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCurrentPage", "setCurrentPage", "(I)V", "Ljava/util/List;", "getMerchantInfoList", "setMerchantInfoList", "(Ljava/util/List;)V", "getTotalPageNumber", "setTotalPageNumber", "<init>", "(Ljava/util/List;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BoundMerchantResult extends BaseRpcResult {
    private int currentPage;
    private List<MerchantInfoDTO> merchantInfoList;
    private int totalPageNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BoundMerchantResult copy$default(BoundMerchantResult boundMerchantResult, List list, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = boundMerchantResult.merchantInfoList;
        }
        if ((i3 & 2) != 0) {
            i = boundMerchantResult.totalPageNumber;
        }
        if ((i3 & 4) != 0) {
            i2 = boundMerchantResult.currentPage;
        }
        return boundMerchantResult.copy(list, i, i2);
    }

    public final List<MerchantInfoDTO> component1() {
        return this.merchantInfoList;
    }

    /* renamed from: component2  reason: from getter */
    public final int getTotalPageNumber() {
        return this.totalPageNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final BoundMerchantResult copy(List<MerchantInfoDTO> merchantInfoList, int totalPageNumber, int currentPage) {
        return new BoundMerchantResult(merchantInfoList, totalPageNumber, currentPage);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BoundMerchantResult) {
            BoundMerchantResult boundMerchantResult = (BoundMerchantResult) other;
            return Intrinsics.areEqual(this.merchantInfoList, boundMerchantResult.merchantInfoList) && this.totalPageNumber == boundMerchantResult.totalPageNumber && this.currentPage == boundMerchantResult.currentPage;
        }
        return false;
    }

    public final int hashCode() {
        List<MerchantInfoDTO> list = this.merchantInfoList;
        return ((((list == null ? 0 : list.hashCode()) * 31) + this.totalPageNumber) * 31) + this.currentPage;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BoundMerchantResult(merchantInfoList=");
        sb.append(this.merchantInfoList);
        sb.append(", totalPageNumber=");
        sb.append(this.totalPageNumber);
        sb.append(", currentPage=");
        sb.append(this.currentPage);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMerchantInfoList")
    public final List<MerchantInfoDTO> getMerchantInfoList() {
        return this.merchantInfoList;
    }

    @JvmName(name = "setMerchantInfoList")
    public final void setMerchantInfoList(List<MerchantInfoDTO> list) {
        this.merchantInfoList = list;
    }

    @JvmName(name = "getTotalPageNumber")
    public final int getTotalPageNumber() {
        return this.totalPageNumber;
    }

    @JvmName(name = "setTotalPageNumber")
    public final void setTotalPageNumber(int i) {
        this.totalPageNumber = i;
    }

    @JvmName(name = "getCurrentPage")
    public final int getCurrentPage() {
        return this.currentPage;
    }

    @JvmName(name = "setCurrentPage")
    public final void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public BoundMerchantResult(List<MerchantInfoDTO> list, int i, int i2) {
        this.merchantInfoList = list;
        this.totalPageNumber = i;
        this.currentPage = i2;
    }
}
