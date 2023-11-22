package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007R\u0017\u0010\u0010\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001a\u0010\u0011\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\"\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b#\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b$\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b%\u0010\u0007"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "component7", "enable", "periodeEn", "periodeId", "contentTitleEn", "contentTitleId", "tncDescEn", "tncDescId", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContentTitleEn", "getContentTitleId", "Z", "getEnable", "getPeriodeEn", "getPeriodeId", "getTncDescEn", "getTncDescId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierAddOnModalContent {
    private final String contentTitleEn;
    private final String contentTitleId;
    private final boolean enable;
    private final String periodeEn;
    private final String periodeId;
    private final String tncDescEn;
    private final String tncDescId;

    public static /* synthetic */ CashierAddOnModalContent copy$default(CashierAddOnModalContent cashierAddOnModalContent, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = cashierAddOnModalContent.enable;
        }
        if ((i & 2) != 0) {
            str = cashierAddOnModalContent.periodeEn;
        }
        String str7 = str;
        if ((i & 4) != 0) {
            str2 = cashierAddOnModalContent.periodeId;
        }
        String str8 = str2;
        if ((i & 8) != 0) {
            str3 = cashierAddOnModalContent.contentTitleEn;
        }
        String str9 = str3;
        if ((i & 16) != 0) {
            str4 = cashierAddOnModalContent.contentTitleId;
        }
        String str10 = str4;
        if ((i & 32) != 0) {
            str5 = cashierAddOnModalContent.tncDescEn;
        }
        String str11 = str5;
        if ((i & 64) != 0) {
            str6 = cashierAddOnModalContent.tncDescId;
        }
        return cashierAddOnModalContent.copy(z, str7, str8, str9, str10, str11, str6);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPeriodeEn() {
        return this.periodeEn;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPeriodeId() {
        return this.periodeId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getContentTitleEn() {
        return this.contentTitleEn;
    }

    /* renamed from: component5  reason: from getter */
    public final String getContentTitleId() {
        return this.contentTitleId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getTncDescEn() {
        return this.tncDescEn;
    }

    /* renamed from: component7  reason: from getter */
    public final String getTncDescId() {
        return this.tncDescId;
    }

    public final CashierAddOnModalContent copy(boolean enable, String periodeEn, String periodeId, String contentTitleEn, String contentTitleId, String tncDescEn, String tncDescId) {
        Intrinsics.checkNotNullParameter(periodeEn, "");
        Intrinsics.checkNotNullParameter(periodeId, "");
        Intrinsics.checkNotNullParameter(contentTitleEn, "");
        Intrinsics.checkNotNullParameter(contentTitleId, "");
        Intrinsics.checkNotNullParameter(tncDescEn, "");
        Intrinsics.checkNotNullParameter(tncDescId, "");
        return new CashierAddOnModalContent(enable, periodeEn, periodeId, contentTitleEn, contentTitleId, tncDescEn, tncDescId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierAddOnModalContent) {
            CashierAddOnModalContent cashierAddOnModalContent = (CashierAddOnModalContent) other;
            return this.enable == cashierAddOnModalContent.enable && Intrinsics.areEqual(this.periodeEn, cashierAddOnModalContent.periodeEn) && Intrinsics.areEqual(this.periodeId, cashierAddOnModalContent.periodeId) && Intrinsics.areEqual(this.contentTitleEn, cashierAddOnModalContent.contentTitleEn) && Intrinsics.areEqual(this.contentTitleId, cashierAddOnModalContent.contentTitleId) && Intrinsics.areEqual(this.tncDescEn, cashierAddOnModalContent.tncDescEn) && Intrinsics.areEqual(this.tncDescId, cashierAddOnModalContent.tncDescId);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((((((((r0 * 31) + this.periodeEn.hashCode()) * 31) + this.periodeId.hashCode()) * 31) + this.contentTitleEn.hashCode()) * 31) + this.contentTitleId.hashCode()) * 31) + this.tncDescEn.hashCode()) * 31) + this.tncDescId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierAddOnModalContent(enable=");
        sb.append(this.enable);
        sb.append(", periodeEn=");
        sb.append(this.periodeEn);
        sb.append(", periodeId=");
        sb.append(this.periodeId);
        sb.append(", contentTitleEn=");
        sb.append(this.contentTitleEn);
        sb.append(", contentTitleId=");
        sb.append(this.contentTitleId);
        sb.append(", tncDescEn=");
        sb.append(this.tncDescEn);
        sb.append(", tncDescId=");
        sb.append(this.tncDescId);
        sb.append(')');
        return sb.toString();
    }

    public CashierAddOnModalContent(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.enable = z;
        this.periodeEn = str;
        this.periodeId = str2;
        this.contentTitleEn = str3;
        this.contentTitleId = str4;
        this.tncDescEn = str5;
        this.tncDescId = str6;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getPeriodeEn")
    public final String getPeriodeEn() {
        return this.periodeEn;
    }

    @JvmName(name = "getPeriodeId")
    public final String getPeriodeId() {
        return this.periodeId;
    }

    @JvmName(name = "getContentTitleEn")
    public final String getContentTitleEn() {
        return this.contentTitleEn;
    }

    @JvmName(name = "getContentTitleId")
    public final String getContentTitleId() {
        return this.contentTitleId;
    }

    @JvmName(name = "getTncDescEn")
    public final String getTncDescEn() {
        return this.tncDescEn;
    }

    @JvmName(name = "getTncDescId")
    public final String getTncDescId() {
        return this.tncDescId;
    }
}
