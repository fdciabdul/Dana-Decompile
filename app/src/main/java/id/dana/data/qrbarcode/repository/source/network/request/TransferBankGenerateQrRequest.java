package id.dana.data.qrbarcode.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/BO\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b.\u00100J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0010\u0010\f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0005Jj\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\u0005R\u0017\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0005R\u001a\u0010\u0012\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b$\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b%\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b&\u0010\u0005R\u001a\u0010\u000f\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b'\u0010\u0005R\u001a\u0010\u0013\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b(\u0010\u0005R\u001a\u0010\u0016\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b)\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b*\u0010\u0005R\u001a\u0010\u0015\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b+\u0010\u0005"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/request/TransferBankGenerateQrRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "amount", "remarks", "bankAccountIndexNo", "bankAccountHolderName", "bankAccountFormattedMaskedNo", "withdrawInstId", "withdrawPayMethod", "withdrawPayOption", "withdrawInstLocalName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/qrbarcode/repository/source/network/request/TransferBankGenerateQrRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getBankAccountFormattedMaskedNo", "getBankAccountHolderName", "getBankAccountIndexNo", "getRemarks", "getWithdrawInstId", "getWithdrawInstLocalName", "getWithdrawPayMethod", "getWithdrawPayOption", "Lid/dana/data/qrbarcode/repository/source/network/request/TransferBankGenerateQrEntity;", "transferBankGenerateQrEntity", "<init>", "(Lid/dana/data/qrbarcode/repository/source/network/request/TransferBankGenerateQrEntity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TransferBankGenerateQrRequest extends BaseRpcRequest implements Serializable {
    private final String amount;
    private final String bankAccountFormattedMaskedNo;
    private final String bankAccountHolderName;
    private final String bankAccountIndexNo;
    private final String remarks;
    private final String withdrawInstId;
    private final String withdrawInstLocalName;
    private final String withdrawPayMethod;
    private final String withdrawPayOption;

    /* renamed from: component1  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBankAccountIndexNo() {
        return this.bankAccountIndexNo;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBankAccountHolderName() {
        return this.bankAccountHolderName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBankAccountFormattedMaskedNo() {
        return this.bankAccountFormattedMaskedNo;
    }

    /* renamed from: component6  reason: from getter */
    public final String getWithdrawInstId() {
        return this.withdrawInstId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getWithdrawPayMethod() {
        return this.withdrawPayMethod;
    }

    /* renamed from: component8  reason: from getter */
    public final String getWithdrawPayOption() {
        return this.withdrawPayOption;
    }

    /* renamed from: component9  reason: from getter */
    public final String getWithdrawInstLocalName() {
        return this.withdrawInstLocalName;
    }

    public final TransferBankGenerateQrRequest copy(String amount, String remarks, String bankAccountIndexNo, String bankAccountHolderName, String bankAccountFormattedMaskedNo, String withdrawInstId, String withdrawPayMethod, String withdrawPayOption, String withdrawInstLocalName) {
        Intrinsics.checkNotNullParameter(amount, "");
        Intrinsics.checkNotNullParameter(remarks, "");
        Intrinsics.checkNotNullParameter(bankAccountIndexNo, "");
        Intrinsics.checkNotNullParameter(bankAccountHolderName, "");
        Intrinsics.checkNotNullParameter(bankAccountFormattedMaskedNo, "");
        Intrinsics.checkNotNullParameter(withdrawInstId, "");
        Intrinsics.checkNotNullParameter(withdrawPayMethod, "");
        Intrinsics.checkNotNullParameter(withdrawPayOption, "");
        Intrinsics.checkNotNullParameter(withdrawInstLocalName, "");
        return new TransferBankGenerateQrRequest(amount, remarks, bankAccountIndexNo, bankAccountHolderName, bankAccountFormattedMaskedNo, withdrawInstId, withdrawPayMethod, withdrawPayOption, withdrawInstLocalName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TransferBankGenerateQrRequest) {
            TransferBankGenerateQrRequest transferBankGenerateQrRequest = (TransferBankGenerateQrRequest) other;
            return Intrinsics.areEqual(this.amount, transferBankGenerateQrRequest.amount) && Intrinsics.areEqual(this.remarks, transferBankGenerateQrRequest.remarks) && Intrinsics.areEqual(this.bankAccountIndexNo, transferBankGenerateQrRequest.bankAccountIndexNo) && Intrinsics.areEqual(this.bankAccountHolderName, transferBankGenerateQrRequest.bankAccountHolderName) && Intrinsics.areEqual(this.bankAccountFormattedMaskedNo, transferBankGenerateQrRequest.bankAccountFormattedMaskedNo) && Intrinsics.areEqual(this.withdrawInstId, transferBankGenerateQrRequest.withdrawInstId) && Intrinsics.areEqual(this.withdrawPayMethod, transferBankGenerateQrRequest.withdrawPayMethod) && Intrinsics.areEqual(this.withdrawPayOption, transferBankGenerateQrRequest.withdrawPayOption) && Intrinsics.areEqual(this.withdrawInstLocalName, transferBankGenerateQrRequest.withdrawInstLocalName);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((this.amount.hashCode() * 31) + this.remarks.hashCode()) * 31) + this.bankAccountIndexNo.hashCode()) * 31) + this.bankAccountHolderName.hashCode()) * 31) + this.bankAccountFormattedMaskedNo.hashCode()) * 31) + this.withdrawInstId.hashCode()) * 31) + this.withdrawPayMethod.hashCode()) * 31) + this.withdrawPayOption.hashCode()) * 31) + this.withdrawInstLocalName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferBankGenerateQrRequest(amount=");
        sb.append(this.amount);
        sb.append(", remarks=");
        sb.append(this.remarks);
        sb.append(", bankAccountIndexNo=");
        sb.append(this.bankAccountIndexNo);
        sb.append(", bankAccountHolderName=");
        sb.append(this.bankAccountHolderName);
        sb.append(", bankAccountFormattedMaskedNo=");
        sb.append(this.bankAccountFormattedMaskedNo);
        sb.append(", withdrawInstId=");
        sb.append(this.withdrawInstId);
        sb.append(", withdrawPayMethod=");
        sb.append(this.withdrawPayMethod);
        sb.append(", withdrawPayOption=");
        sb.append(this.withdrawPayOption);
        sb.append(", withdrawInstLocalName=");
        sb.append(this.withdrawInstLocalName);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getRemarks")
    public final String getRemarks() {
        return this.remarks;
    }

    @JvmName(name = "getBankAccountIndexNo")
    public final String getBankAccountIndexNo() {
        return this.bankAccountIndexNo;
    }

    @JvmName(name = "getBankAccountHolderName")
    public final String getBankAccountHolderName() {
        return this.bankAccountHolderName;
    }

    @JvmName(name = "getBankAccountFormattedMaskedNo")
    public final String getBankAccountFormattedMaskedNo() {
        return this.bankAccountFormattedMaskedNo;
    }

    @JvmName(name = "getWithdrawInstId")
    public final String getWithdrawInstId() {
        return this.withdrawInstId;
    }

    @JvmName(name = "getWithdrawPayMethod")
    public final String getWithdrawPayMethod() {
        return this.withdrawPayMethod;
    }

    @JvmName(name = "getWithdrawPayOption")
    public final String getWithdrawPayOption() {
        return this.withdrawPayOption;
    }

    @JvmName(name = "getWithdrawInstLocalName")
    public final String getWithdrawInstLocalName() {
        return this.withdrawInstLocalName;
    }

    public TransferBankGenerateQrRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        this.amount = str;
        this.remarks = str2;
        this.bankAccountIndexNo = str3;
        this.bankAccountHolderName = str4;
        this.bankAccountFormattedMaskedNo = str5;
        this.withdrawInstId = str6;
        this.withdrawPayMethod = str7;
        this.withdrawPayOption = str8;
        this.withdrawInstLocalName = str9;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransferBankGenerateQrRequest(TransferBankGenerateQrEntity transferBankGenerateQrEntity) {
        this(transferBankGenerateQrEntity.getAmount(), transferBankGenerateQrEntity.getRemarks(), transferBankGenerateQrEntity.getBankAccountIndexNo(), transferBankGenerateQrEntity.getBankAccountHolderName(), transferBankGenerateQrEntity.getBankAccountFormattedMaskedNo(), transferBankGenerateQrEntity.getWithdrawInstId(), transferBankGenerateQrEntity.getWithdrawPayMethod(), transferBankGenerateQrEntity.getWithdrawPayOption(), transferBankGenerateQrEntity.getWithdrawInstLocalName());
        Intrinsics.checkNotNullParameter(transferBankGenerateQrEntity, "");
    }
}
