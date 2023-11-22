package id.dana.data.sendmoney.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.UrlParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b<\u0010=J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J¤\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\b\u0002\u0010!\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u0004R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b/\u0010\u0004R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00100\u001a\u0004\b1\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b5\u0010\u0010R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010,\u001a\u0004\b7\u0010\u0004R\u001a\u0010!\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b:\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b;\u0010\u0004"}, d2 = {"Lid/dana/data/sendmoney/repository/source/network/request/BizTransferOrderCreateRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component10", "", "component11", "()Ljava/util/List;", "", "component12", "()Z", "component2", "component3", "Lid/dana/data/sendmoney/repository/source/network/request/TransferParticipantDTO;", "component4", "()Lid/dana/data/sendmoney/repository/source/network/request/TransferParticipantDTO;", "component5", "component6", "component7", "component8", "component9", "amount", "fundType", "transferMethod", "payeeInfo", UrlParam.REQUEST_ID, "remarks", "acceptTimeoutValue", "acceptTimeoutUnit", "instId", "transferScenario", "couponIds", "shareActivity", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/sendmoney/repository/source/network/request/TransferParticipantDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)Lid/dana/data/sendmoney/repository/source/network/request/BizTransferOrderCreateRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAcceptTimeoutUnit", "getAcceptTimeoutValue", "getAmount", "Ljava/util/List;", "getCouponIds", "getFundType", "getInstId", "Lid/dana/data/sendmoney/repository/source/network/request/TransferParticipantDTO;", "getPayeeInfo", "getRemarks", "getRequestId", "Z", "getShareActivity", "getTransferMethod", "getTransferScenario", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/sendmoney/repository/source/network/request/TransferParticipantDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BizTransferOrderCreateRequest extends BaseRpcRequest {
    private final String acceptTimeoutUnit;
    private final String acceptTimeoutValue;
    private final String amount;
    private final List<String> couponIds;
    private final String fundType;
    private final String instId;
    private final TransferParticipantDTO payeeInfo;
    private final String remarks;
    private final String requestId;
    private final boolean shareActivity;
    private final String transferMethod;
    private final String transferScenario;

    /* renamed from: component1  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component10  reason: from getter */
    public final String getTransferScenario() {
        return this.transferScenario;
    }

    public final List<String> component11() {
        return this.couponIds;
    }

    /* renamed from: component12  reason: from getter */
    public final boolean getShareActivity() {
        return this.shareActivity;
    }

    /* renamed from: component2  reason: from getter */
    public final String getFundType() {
        return this.fundType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final TransferParticipantDTO getPayeeInfo() {
        return this.payeeInfo;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    /* renamed from: component7  reason: from getter */
    public final String getAcceptTimeoutValue() {
        return this.acceptTimeoutValue;
    }

    /* renamed from: component8  reason: from getter */
    public final String getAcceptTimeoutUnit() {
        return this.acceptTimeoutUnit;
    }

    /* renamed from: component9  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    public final BizTransferOrderCreateRequest copy(String amount, String fundType, String transferMethod, TransferParticipantDTO payeeInfo, String requestId, String remarks, String acceptTimeoutValue, String acceptTimeoutUnit, String instId, String transferScenario, List<String> couponIds, boolean shareActivity) {
        return new BizTransferOrderCreateRequest(amount, fundType, transferMethod, payeeInfo, requestId, remarks, acceptTimeoutValue, acceptTimeoutUnit, instId, transferScenario, couponIds, shareActivity);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizTransferOrderCreateRequest) {
            BizTransferOrderCreateRequest bizTransferOrderCreateRequest = (BizTransferOrderCreateRequest) other;
            return Intrinsics.areEqual(this.amount, bizTransferOrderCreateRequest.amount) && Intrinsics.areEqual(this.fundType, bizTransferOrderCreateRequest.fundType) && Intrinsics.areEqual(this.transferMethod, bizTransferOrderCreateRequest.transferMethod) && Intrinsics.areEqual(this.payeeInfo, bizTransferOrderCreateRequest.payeeInfo) && Intrinsics.areEqual(this.requestId, bizTransferOrderCreateRequest.requestId) && Intrinsics.areEqual(this.remarks, bizTransferOrderCreateRequest.remarks) && Intrinsics.areEqual(this.acceptTimeoutValue, bizTransferOrderCreateRequest.acceptTimeoutValue) && Intrinsics.areEqual(this.acceptTimeoutUnit, bizTransferOrderCreateRequest.acceptTimeoutUnit) && Intrinsics.areEqual(this.instId, bizTransferOrderCreateRequest.instId) && Intrinsics.areEqual(this.transferScenario, bizTransferOrderCreateRequest.transferScenario) && Intrinsics.areEqual(this.couponIds, bizTransferOrderCreateRequest.couponIds) && this.shareActivity == bizTransferOrderCreateRequest.shareActivity;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.amount;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.fundType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.transferMethod;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        TransferParticipantDTO transferParticipantDTO = this.payeeInfo;
        int hashCode4 = transferParticipantDTO == null ? 0 : transferParticipantDTO.hashCode();
        String str4 = this.requestId;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.remarks;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.acceptTimeoutValue;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.acceptTimeoutUnit;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.instId;
        int hashCode9 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.transferScenario;
        int hashCode10 = str9 == null ? 0 : str9.hashCode();
        List<String> list = this.couponIds;
        int hashCode11 = list != null ? list.hashCode() : 0;
        boolean z = this.shareActivity;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizTransferOrderCreateRequest(amount=");
        sb.append(this.amount);
        sb.append(", fundType=");
        sb.append(this.fundType);
        sb.append(", transferMethod=");
        sb.append(this.transferMethod);
        sb.append(", payeeInfo=");
        sb.append(this.payeeInfo);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", remarks=");
        sb.append(this.remarks);
        sb.append(", acceptTimeoutValue=");
        sb.append(this.acceptTimeoutValue);
        sb.append(", acceptTimeoutUnit=");
        sb.append(this.acceptTimeoutUnit);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", transferScenario=");
        sb.append(this.transferScenario);
        sb.append(", couponIds=");
        sb.append(this.couponIds);
        sb.append(", shareActivity=");
        sb.append(this.shareActivity);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getFundType")
    public final String getFundType() {
        return this.fundType;
    }

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    @JvmName(name = "getPayeeInfo")
    public final TransferParticipantDTO getPayeeInfo() {
        return this.payeeInfo;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getRemarks")
    public final String getRemarks() {
        return this.remarks;
    }

    @JvmName(name = "getAcceptTimeoutValue")
    public final String getAcceptTimeoutValue() {
        return this.acceptTimeoutValue;
    }

    @JvmName(name = "getAcceptTimeoutUnit")
    public final String getAcceptTimeoutUnit() {
        return this.acceptTimeoutUnit;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getTransferScenario")
    public final String getTransferScenario() {
        return this.transferScenario;
    }

    @JvmName(name = "getCouponIds")
    public final List<String> getCouponIds() {
        return this.couponIds;
    }

    @JvmName(name = "getShareActivity")
    public final boolean getShareActivity() {
        return this.shareActivity;
    }

    public BizTransferOrderCreateRequest(String str, String str2, String str3, TransferParticipantDTO transferParticipantDTO, String str4, String str5, String str6, String str7, String str8, String str9, List<String> list, boolean z) {
        this.amount = str;
        this.fundType = str2;
        this.transferMethod = str3;
        this.payeeInfo = transferParticipantDTO;
        this.requestId = str4;
        this.remarks = str5;
        this.acceptTimeoutValue = str6;
        this.acceptTimeoutUnit = str7;
        this.instId = str8;
        this.transferScenario = str9;
        this.couponIds = list;
        this.shareActivity = z;
    }
}
