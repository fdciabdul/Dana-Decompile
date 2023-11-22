package id.dana.data.qrbarcode.repository.source.network.request;

import id.dana.domain.splitbill.model.UserBankGenerateQr;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B?\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JV\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b \u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b#\u0010\u0004"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/request/UserBankGenerateQrEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "bankAccountIndexNo", "bankAccountHolderName", "bankAccountFormattedMaskedNo", "withdrawInstId", "withdrawPayMethod", "withdrawPayOption", "withdrawInstLocalName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/qrbarcode/repository/source/network/request/UserBankGenerateQrEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankAccountFormattedMaskedNo", "getBankAccountHolderName", "getBankAccountIndexNo", "getWithdrawInstId", "getWithdrawInstLocalName", "getWithdrawPayMethod", "getWithdrawPayOption", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserBankGenerateQrEntity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bankAccountFormattedMaskedNo;
    private final String bankAccountHolderName;
    private final String bankAccountIndexNo;
    private final String withdrawInstId;
    private final String withdrawInstLocalName;
    private final String withdrawPayMethod;
    private final String withdrawPayOption;

    public static /* synthetic */ UserBankGenerateQrEntity copy$default(UserBankGenerateQrEntity userBankGenerateQrEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userBankGenerateQrEntity.bankAccountIndexNo;
        }
        if ((i & 2) != 0) {
            str2 = userBankGenerateQrEntity.bankAccountHolderName;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = userBankGenerateQrEntity.bankAccountFormattedMaskedNo;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = userBankGenerateQrEntity.withdrawInstId;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = userBankGenerateQrEntity.withdrawPayMethod;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = userBankGenerateQrEntity.withdrawPayOption;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = userBankGenerateQrEntity.withdrawInstLocalName;
        }
        return userBankGenerateQrEntity.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @JvmStatic
    public static final UserBankGenerateQrEntity fromUserBankGenerateQr(UserBankGenerateQr userBankGenerateQr) {
        return INSTANCE.fromUserBankGenerateQr(userBankGenerateQr);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBankAccountIndexNo() {
        return this.bankAccountIndexNo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBankAccountHolderName() {
        return this.bankAccountHolderName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBankAccountFormattedMaskedNo() {
        return this.bankAccountFormattedMaskedNo;
    }

    /* renamed from: component4  reason: from getter */
    public final String getWithdrawInstId() {
        return this.withdrawInstId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getWithdrawPayMethod() {
        return this.withdrawPayMethod;
    }

    /* renamed from: component6  reason: from getter */
    public final String getWithdrawPayOption() {
        return this.withdrawPayOption;
    }

    /* renamed from: component7  reason: from getter */
    public final String getWithdrawInstLocalName() {
        return this.withdrawInstLocalName;
    }

    public final UserBankGenerateQrEntity copy(String bankAccountIndexNo, String bankAccountHolderName, String bankAccountFormattedMaskedNo, String withdrawInstId, String withdrawPayMethod, String withdrawPayOption, String withdrawInstLocalName) {
        Intrinsics.checkNotNullParameter(bankAccountIndexNo, "");
        Intrinsics.checkNotNullParameter(bankAccountHolderName, "");
        Intrinsics.checkNotNullParameter(bankAccountFormattedMaskedNo, "");
        Intrinsics.checkNotNullParameter(withdrawInstId, "");
        Intrinsics.checkNotNullParameter(withdrawPayMethod, "");
        Intrinsics.checkNotNullParameter(withdrawPayOption, "");
        Intrinsics.checkNotNullParameter(withdrawInstLocalName, "");
        return new UserBankGenerateQrEntity(bankAccountIndexNo, bankAccountHolderName, bankAccountFormattedMaskedNo, withdrawInstId, withdrawPayMethod, withdrawPayOption, withdrawInstLocalName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserBankGenerateQrEntity) {
            UserBankGenerateQrEntity userBankGenerateQrEntity = (UserBankGenerateQrEntity) other;
            return Intrinsics.areEqual(this.bankAccountIndexNo, userBankGenerateQrEntity.bankAccountIndexNo) && Intrinsics.areEqual(this.bankAccountHolderName, userBankGenerateQrEntity.bankAccountHolderName) && Intrinsics.areEqual(this.bankAccountFormattedMaskedNo, userBankGenerateQrEntity.bankAccountFormattedMaskedNo) && Intrinsics.areEqual(this.withdrawInstId, userBankGenerateQrEntity.withdrawInstId) && Intrinsics.areEqual(this.withdrawPayMethod, userBankGenerateQrEntity.withdrawPayMethod) && Intrinsics.areEqual(this.withdrawPayOption, userBankGenerateQrEntity.withdrawPayOption) && Intrinsics.areEqual(this.withdrawInstLocalName, userBankGenerateQrEntity.withdrawInstLocalName);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.bankAccountIndexNo.hashCode() * 31) + this.bankAccountHolderName.hashCode()) * 31) + this.bankAccountFormattedMaskedNo.hashCode()) * 31) + this.withdrawInstId.hashCode()) * 31) + this.withdrawPayMethod.hashCode()) * 31) + this.withdrawPayOption.hashCode()) * 31) + this.withdrawInstLocalName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserBankGenerateQrEntity(bankAccountIndexNo=");
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

    public UserBankGenerateQrEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.bankAccountIndexNo = str;
        this.bankAccountHolderName = str2;
        this.bankAccountFormattedMaskedNo = str3;
        this.withdrawInstId = str4;
        this.withdrawPayMethod = str5;
        this.withdrawPayOption = str6;
        this.withdrawInstLocalName = str7;
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/request/UserBankGenerateQrEntity$Companion;", "", "Lid/dana/domain/splitbill/model/UserBankGenerateQr;", "userBankGenerateQr", "Lid/dana/data/qrbarcode/repository/source/network/request/UserBankGenerateQrEntity;", "fromUserBankGenerateQr", "(Lid/dana/domain/splitbill/model/UserBankGenerateQr;)Lid/dana/data/qrbarcode/repository/source/network/request/UserBankGenerateQrEntity;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UserBankGenerateQrEntity fromUserBankGenerateQr(UserBankGenerateQr userBankGenerateQr) {
            Intrinsics.checkNotNullParameter(userBankGenerateQr, "");
            return new UserBankGenerateQrEntity(userBankGenerateQr.getBankAccountIndexNo(), userBankGenerateQr.getBankAccountHolderName(), userBankGenerateQr.getBankAccountFormattedMaskedNo(), userBankGenerateQr.getWithdrawInstId(), userBankGenerateQr.getWithdrawPayMethod(), userBankGenerateQr.getWithdrawPayOption(), userBankGenerateQr.getWithdrawInstLocalName());
        }
    }
}
