package id.dana.domain.sendmoney.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b!\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\"\u0010\u0004R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%R\"\u0010\u0013\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010)"}, d2 = {"Lid/dana/domain/sendmoney/model/DigitalMoney;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Z", "instId", "eWalletPrefix", "bankName", "eWalletName", "identifier", "phoneNumber", "recentRecipient", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/sendmoney/model/DigitalMoney;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankName", "getEWalletName", "getEWalletPrefix", "getIdentifier", "getInstId", "getPhoneNumber", "setPhoneNumber", "(Ljava/lang/String;)V", "Z", "getRecentRecipient", "setRecentRecipient", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DigitalMoney {
    private final String bankName;
    private final String eWalletName;
    private final String eWalletPrefix;
    private final String identifier;
    private final String instId;
    private String phoneNumber;
    private boolean recentRecipient;

    public static /* synthetic */ DigitalMoney copy$default(DigitalMoney digitalMoney, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = digitalMoney.instId;
        }
        if ((i & 2) != 0) {
            str2 = digitalMoney.eWalletPrefix;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = digitalMoney.bankName;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = digitalMoney.eWalletName;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = digitalMoney.identifier;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = digitalMoney.phoneNumber;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            z = digitalMoney.recentRecipient;
        }
        return digitalMoney.copy(str, str7, str8, str9, str10, str11, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getEWalletPrefix() {
        return this.eWalletPrefix;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBankName() {
        return this.bankName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getEWalletName() {
        return this.eWalletName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component6  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getRecentRecipient() {
        return this.recentRecipient;
    }

    public final DigitalMoney copy(String instId, String eWalletPrefix, String bankName, String eWalletName, String identifier, String phoneNumber, boolean recentRecipient) {
        Intrinsics.checkNotNullParameter(instId, "");
        Intrinsics.checkNotNullParameter(eWalletPrefix, "");
        Intrinsics.checkNotNullParameter(bankName, "");
        Intrinsics.checkNotNullParameter(eWalletName, "");
        Intrinsics.checkNotNullParameter(identifier, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        return new DigitalMoney(instId, eWalletPrefix, bankName, eWalletName, identifier, phoneNumber, recentRecipient);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DigitalMoney) {
            DigitalMoney digitalMoney = (DigitalMoney) other;
            return Intrinsics.areEqual(this.instId, digitalMoney.instId) && Intrinsics.areEqual(this.eWalletPrefix, digitalMoney.eWalletPrefix) && Intrinsics.areEqual(this.bankName, digitalMoney.bankName) && Intrinsics.areEqual(this.eWalletName, digitalMoney.eWalletName) && Intrinsics.areEqual(this.identifier, digitalMoney.identifier) && Intrinsics.areEqual(this.phoneNumber, digitalMoney.phoneNumber) && this.recentRecipient == digitalMoney.recentRecipient;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.instId.hashCode();
        int hashCode2 = this.eWalletPrefix.hashCode();
        int hashCode3 = this.bankName.hashCode();
        int hashCode4 = this.eWalletName.hashCode();
        int hashCode5 = this.identifier.hashCode();
        int hashCode6 = this.phoneNumber.hashCode();
        boolean z = this.recentRecipient;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DigitalMoney(instId=");
        sb.append(this.instId);
        sb.append(", eWalletPrefix=");
        sb.append(this.eWalletPrefix);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", eWalletName=");
        sb.append(this.eWalletName);
        sb.append(", identifier=");
        sb.append(this.identifier);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", recentRecipient=");
        sb.append(this.recentRecipient);
        sb.append(')');
        return sb.toString();
    }

    public DigitalMoney(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.instId = str;
        this.eWalletPrefix = str2;
        this.bankName = str3;
        this.eWalletName = str4;
        this.identifier = str5;
        this.phoneNumber = str6;
        this.recentRecipient = z;
    }

    public /* synthetic */ DigitalMoney(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? false : z);
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getEWalletPrefix")
    public final String getEWalletPrefix() {
        return this.eWalletPrefix;
    }

    @JvmName(name = "getBankName")
    public final String getBankName() {
        return this.bankName;
    }

    @JvmName(name = "getEWalletName")
    public final String getEWalletName() {
        return this.eWalletName;
    }

    @JvmName(name = "getIdentifier")
    public final String getIdentifier() {
        return this.identifier;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.phoneNumber = str;
    }

    @JvmName(name = "getRecentRecipient")
    public final boolean getRecentRecipient() {
        return this.recentRecipient;
    }

    @JvmName(name = "setRecentRecipient")
    public final void setRecentRecipient(boolean z) {
        this.recentRecipient = z;
    }
}
