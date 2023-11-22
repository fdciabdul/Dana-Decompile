package id.dana.sendmoney.data.api.globalsend.transferSubmit.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/TransferSubmitRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "amount", "Ljava/lang/String;", "getAmount", "()Ljava/lang/String;", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/BeneficiaryRequest;", "beneficiary", "Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/BeneficiaryRequest;", "getBeneficiary", "()Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/BeneficiaryRequest;", "destinationAmount", "getDestinationAmount", UrlParam.REQUEST_ID, "getRequestId", "transferMethod", "getTransferMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/data/api/globalsend/transferSubmit/request/BeneficiaryRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferSubmitRequestEntity extends BaseRpcRequest {
    private final String amount;
    private final BeneficiaryRequest beneficiary;
    private final String destinationAmount;
    private final String requestId;
    private final String transferMethod;

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getDestinationAmount")
    public final String getDestinationAmount() {
        return this.destinationAmount;
    }

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getBeneficiary")
    public final BeneficiaryRequest getBeneficiary() {
        return this.beneficiary;
    }

    public TransferSubmitRequestEntity(String str, String str2, String str3, String str4, BeneficiaryRequest beneficiaryRequest) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(beneficiaryRequest, "");
        this.amount = str;
        this.destinationAmount = str2;
        this.transferMethod = str3;
        this.requestId = str4;
        this.beneficiary = beneficiaryRequest;
    }
}
