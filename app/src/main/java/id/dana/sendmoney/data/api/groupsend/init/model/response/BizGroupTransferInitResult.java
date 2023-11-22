package id.dana.sendmoney.data.api.groupsend.init.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.sendmoney.data.api.groupsend.init.model.PayeeUserInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\"\u0010#J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJF\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001e\u0010\bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010\u0005R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b!\u0010\b"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/sendmoney/data/api/groupsend/init/model/PayeeUserInfoEntity;", "component1", "()Ljava/util/List;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "component2", "()Lid/dana/core/ui/model/CurrencyAmountModel;", "component3", "component4", "payeeUserInfos", "payeeMinLimit", "payeeMaxLimit", "totalLimit", "copy", "(Ljava/util/List;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;)Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "getPayeeMaxLimit", "getPayeeMinLimit", "Ljava/util/List;", "getPayeeUserInfos", "getTotalLimit", "<init>", "(Ljava/util/List;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupTransferInitResult extends BaseRpcResult {
    private final CurrencyAmountModel payeeMaxLimit;
    private final CurrencyAmountModel payeeMinLimit;
    private final List<PayeeUserInfoEntity> payeeUserInfos;
    private final CurrencyAmountModel totalLimit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BizGroupTransferInitResult copy$default(BizGroupTransferInitResult bizGroupTransferInitResult, List list, CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, CurrencyAmountModel currencyAmountModel3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = bizGroupTransferInitResult.payeeUserInfos;
        }
        if ((i & 2) != 0) {
            currencyAmountModel = bizGroupTransferInitResult.payeeMinLimit;
        }
        if ((i & 4) != 0) {
            currencyAmountModel2 = bizGroupTransferInitResult.payeeMaxLimit;
        }
        if ((i & 8) != 0) {
            currencyAmountModel3 = bizGroupTransferInitResult.totalLimit;
        }
        return bizGroupTransferInitResult.copy(list, currencyAmountModel, currencyAmountModel2, currencyAmountModel3);
    }

    public final List<PayeeUserInfoEntity> component1() {
        return this.payeeUserInfos;
    }

    /* renamed from: component2  reason: from getter */
    public final CurrencyAmountModel getPayeeMinLimit() {
        return this.payeeMinLimit;
    }

    /* renamed from: component3  reason: from getter */
    public final CurrencyAmountModel getPayeeMaxLimit() {
        return this.payeeMaxLimit;
    }

    /* renamed from: component4  reason: from getter */
    public final CurrencyAmountModel getTotalLimit() {
        return this.totalLimit;
    }

    public final BizGroupTransferInitResult copy(List<PayeeUserInfoEntity> payeeUserInfos, CurrencyAmountModel payeeMinLimit, CurrencyAmountModel payeeMaxLimit, CurrencyAmountModel totalLimit) {
        return new BizGroupTransferInitResult(payeeUserInfos, payeeMinLimit, payeeMaxLimit, totalLimit);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizGroupTransferInitResult) {
            BizGroupTransferInitResult bizGroupTransferInitResult = (BizGroupTransferInitResult) other;
            return Intrinsics.areEqual(this.payeeUserInfos, bizGroupTransferInitResult.payeeUserInfos) && Intrinsics.areEqual(this.payeeMinLimit, bizGroupTransferInitResult.payeeMinLimit) && Intrinsics.areEqual(this.payeeMaxLimit, bizGroupTransferInitResult.payeeMaxLimit) && Intrinsics.areEqual(this.totalLimit, bizGroupTransferInitResult.totalLimit);
        }
        return false;
    }

    public final int hashCode() {
        List<PayeeUserInfoEntity> list = this.payeeUserInfos;
        int hashCode = list == null ? 0 : list.hashCode();
        CurrencyAmountModel currencyAmountModel = this.payeeMinLimit;
        int hashCode2 = currencyAmountModel == null ? 0 : currencyAmountModel.hashCode();
        CurrencyAmountModel currencyAmountModel2 = this.payeeMaxLimit;
        int hashCode3 = currencyAmountModel2 == null ? 0 : currencyAmountModel2.hashCode();
        CurrencyAmountModel currencyAmountModel3 = this.totalLimit;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (currencyAmountModel3 != null ? currencyAmountModel3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupTransferInitResult(payeeUserInfos=");
        sb.append(this.payeeUserInfos);
        sb.append(", payeeMinLimit=");
        sb.append(this.payeeMinLimit);
        sb.append(", payeeMaxLimit=");
        sb.append(this.payeeMaxLimit);
        sb.append(", totalLimit=");
        sb.append(this.totalLimit);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getPayeeUserInfos")
    public final List<PayeeUserInfoEntity> getPayeeUserInfos() {
        return this.payeeUserInfos;
    }

    @JvmName(name = "getPayeeMinLimit")
    public final CurrencyAmountModel getPayeeMinLimit() {
        return this.payeeMinLimit;
    }

    @JvmName(name = "getPayeeMaxLimit")
    public final CurrencyAmountModel getPayeeMaxLimit() {
        return this.payeeMaxLimit;
    }

    @JvmName(name = "getTotalLimit")
    public final CurrencyAmountModel getTotalLimit() {
        return this.totalLimit;
    }

    public BizGroupTransferInitResult(List<PayeeUserInfoEntity> list, CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, CurrencyAmountModel currencyAmountModel3) {
        this.payeeUserInfos = list;
        this.payeeMinLimit = currencyAmountModel;
        this.payeeMaxLimit = currencyAmountModel2;
        this.totalLimit = currencyAmountModel3;
    }
}
