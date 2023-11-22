package id.dana.domain.qrbarcode.interactor;

import dagger.Module;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qrbarcode.QrUserBankResult;
import id.dana.domain.splitbill.model.TransferBankGenerateQr;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\b*\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/qrbarcode/QrUserBankResult;", "Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/splitbill/model/TransferBankGenerateQr;", "toTransferBankGenerateQr", "(Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr$Params;)Lid/dana/domain/splitbill/model/TransferBankGenerateQr;", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "repository", "Lid/dana/domain/qrbarcode/QrBarcodeRepository;", "<init>", "(Lid/dana/domain/qrbarcode/QrBarcodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class GetBankTransferQr extends BaseUseCase<QrUserBankResult, Params> {
    private final QrBarcodeRepository repository;

    @Inject
    public GetBankTransferQr(QrBarcodeRepository qrBarcodeRepository) {
        Intrinsics.checkNotNullParameter(qrBarcodeRepository, "");
        this.repository = qrBarcodeRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QrUserBankResult> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<QrUserBankResult> transferBankQr = this.repository.getTransferBankQr(toTransferBankGenerateQr(params));
        Intrinsics.checkNotNullExpressionValue(transferBankQr, "");
        return transferBankQr;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jj\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b$\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b)\u0010\u0004"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "amount", "remarks", "bankAccountIndexNo", "bankAccountHolderName", "bankAccountFormattedMaskedNo", "withdrawInstId", "withdrawPayMethod", "withdrawPayOption", "withdrawInstLocalName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/qrbarcode/interactor/GetBankTransferQr$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getBankAccountFormattedMaskedNo", "getBankAccountHolderName", "getBankAccountIndexNo", "getRemarks", "getWithdrawInstId", "getWithdrawInstLocalName", "getWithdrawPayMethod", "getWithdrawPayOption", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
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

        public final Params copy(String amount, String remarks, String bankAccountIndexNo, String bankAccountHolderName, String bankAccountFormattedMaskedNo, String withdrawInstId, String withdrawPayMethod, String withdrawPayOption, String withdrawInstLocalName) {
            Intrinsics.checkNotNullParameter(amount, "");
            Intrinsics.checkNotNullParameter(remarks, "");
            Intrinsics.checkNotNullParameter(bankAccountIndexNo, "");
            Intrinsics.checkNotNullParameter(bankAccountHolderName, "");
            Intrinsics.checkNotNullParameter(bankAccountFormattedMaskedNo, "");
            Intrinsics.checkNotNullParameter(withdrawInstId, "");
            Intrinsics.checkNotNullParameter(withdrawPayMethod, "");
            Intrinsics.checkNotNullParameter(withdrawPayOption, "");
            Intrinsics.checkNotNullParameter(withdrawInstLocalName, "");
            return new Params(amount, remarks, bankAccountIndexNo, bankAccountHolderName, bankAccountFormattedMaskedNo, withdrawInstId, withdrawPayMethod, withdrawPayOption, withdrawInstLocalName);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.amount, params.amount) && Intrinsics.areEqual(this.remarks, params.remarks) && Intrinsics.areEqual(this.bankAccountIndexNo, params.bankAccountIndexNo) && Intrinsics.areEqual(this.bankAccountHolderName, params.bankAccountHolderName) && Intrinsics.areEqual(this.bankAccountFormattedMaskedNo, params.bankAccountFormattedMaskedNo) && Intrinsics.areEqual(this.withdrawInstId, params.withdrawInstId) && Intrinsics.areEqual(this.withdrawPayMethod, params.withdrawPayMethod) && Intrinsics.areEqual(this.withdrawPayOption, params.withdrawPayOption) && Intrinsics.areEqual(this.withdrawInstLocalName, params.withdrawInstLocalName);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((((((((this.amount.hashCode() * 31) + this.remarks.hashCode()) * 31) + this.bankAccountIndexNo.hashCode()) * 31) + this.bankAccountHolderName.hashCode()) * 31) + this.bankAccountFormattedMaskedNo.hashCode()) * 31) + this.withdrawInstId.hashCode()) * 31) + this.withdrawPayMethod.hashCode()) * 31) + this.withdrawPayOption.hashCode()) * 31) + this.withdrawInstLocalName.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(amount=");
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

        public Params(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
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
    }

    private final TransferBankGenerateQr toTransferBankGenerateQr(Params params) {
        return new TransferBankGenerateQr(params.getAmount(), params.getRemarks(), params.getBankAccountIndexNo(), params.getBankAccountHolderName(), params.getBankAccountFormattedMaskedNo(), params.getWithdrawInstId(), params.getWithdrawPayMethod(), params.getWithdrawPayOption(), params.getWithdrawInstLocalName());
    }
}
