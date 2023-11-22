package id.dana.data.bank.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004Jd\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b$\u0010\u0004"}, d2 = {"Lid/dana/data/bank/model/UserConfigBankQrContent;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "bankAccountIndexNo", "bankAccountHolderName", "bankAccountFormattedMaskedNo", "withdrawInstId", "withdrawPayMethod", "withdrawPayOption", "withdrawInstLocalName", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/bank/model/UserConfigBankQrContent;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankAccountFormattedMaskedNo", "getBankAccountHolderName", "getBankAccountIndexNo", "getWithdrawInstId", "getWithdrawInstLocalName", "getWithdrawPayMethod", "getWithdrawPayOption", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserConfigBankQrContent implements Serializable {
    private final String bankAccountFormattedMaskedNo;
    private final String bankAccountHolderName;
    private final String bankAccountIndexNo;
    private final String withdrawInstId;
    private final String withdrawInstLocalName;
    private final String withdrawPayMethod;
    private final String withdrawPayOption;

    public static /* synthetic */ UserConfigBankQrContent copy$default(UserConfigBankQrContent userConfigBankQrContent, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userConfigBankQrContent.bankAccountIndexNo;
        }
        if ((i & 2) != 0) {
            str2 = userConfigBankQrContent.bankAccountHolderName;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = userConfigBankQrContent.bankAccountFormattedMaskedNo;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = userConfigBankQrContent.withdrawInstId;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = userConfigBankQrContent.withdrawPayMethod;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = userConfigBankQrContent.withdrawPayOption;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = userConfigBankQrContent.withdrawInstLocalName;
        }
        return userConfigBankQrContent.copy(str, str8, str9, str10, str11, str12, str7);
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

    public final UserConfigBankQrContent copy(String bankAccountIndexNo, String bankAccountHolderName, String bankAccountFormattedMaskedNo, String withdrawInstId, String withdrawPayMethod, String withdrawPayOption, String withdrawInstLocalName) {
        return new UserConfigBankQrContent(bankAccountIndexNo, bankAccountHolderName, bankAccountFormattedMaskedNo, withdrawInstId, withdrawPayMethod, withdrawPayOption, withdrawInstLocalName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserConfigBankQrContent) {
            UserConfigBankQrContent userConfigBankQrContent = (UserConfigBankQrContent) other;
            return Intrinsics.areEqual(this.bankAccountIndexNo, userConfigBankQrContent.bankAccountIndexNo) && Intrinsics.areEqual(this.bankAccountHolderName, userConfigBankQrContent.bankAccountHolderName) && Intrinsics.areEqual(this.bankAccountFormattedMaskedNo, userConfigBankQrContent.bankAccountFormattedMaskedNo) && Intrinsics.areEqual(this.withdrawInstId, userConfigBankQrContent.withdrawInstId) && Intrinsics.areEqual(this.withdrawPayMethod, userConfigBankQrContent.withdrawPayMethod) && Intrinsics.areEqual(this.withdrawPayOption, userConfigBankQrContent.withdrawPayOption) && Intrinsics.areEqual(this.withdrawInstLocalName, userConfigBankQrContent.withdrawInstLocalName);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bankAccountIndexNo;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bankAccountHolderName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.bankAccountFormattedMaskedNo;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.withdrawInstId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.withdrawPayMethod;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.withdrawPayOption;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.withdrawInstLocalName;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str7 != null ? str7.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserConfigBankQrContent(bankAccountIndexNo=");
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

    public UserConfigBankQrContent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
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
}
