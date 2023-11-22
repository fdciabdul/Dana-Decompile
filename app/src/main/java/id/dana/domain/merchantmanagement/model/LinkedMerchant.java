package id.dana.domain.merchantmanagement.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004Jt\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004R\u0017\u0010\u0015\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b&\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b+\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b,\u0010\u0004"}, d2 = {"Lid/dana/domain/merchantmanagement/model/LinkedMerchant;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "component4", "()J", "component5", "component6", "component7", "component8", "component9", "merchantName", "merchantLogo", "merchantPCLogo", "merchantBoundDate", "merchantId", "divisionId", "clientId", "regId", "userBoundId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/merchantmanagement/model/LinkedMerchant;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "getDivisionId", "J", "getMerchantBoundDate", "getMerchantId", "getMerchantLogo", "getMerchantName", "getMerchantPCLogo", "getRegId", "getUserBoundId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LinkedMerchant {
    private final String clientId;
    private final String divisionId;
    private final long merchantBoundDate;
    private final String merchantId;
    private final String merchantLogo;
    private final String merchantName;
    private final String merchantPCLogo;
    private final String regId;
    private final String userBoundId;

    /* renamed from: component1  reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMerchantLogo() {
        return this.merchantLogo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMerchantPCLogo() {
        return this.merchantPCLogo;
    }

    /* renamed from: component4  reason: from getter */
    public final long getMerchantBoundDate() {
        return this.merchantBoundDate;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component6  reason: from getter */
    public final String getDivisionId() {
        return this.divisionId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getRegId() {
        return this.regId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getUserBoundId() {
        return this.userBoundId;
    }

    public final LinkedMerchant copy(String merchantName, String merchantLogo, String merchantPCLogo, long merchantBoundDate, String merchantId, String divisionId, String clientId, String regId, String userBoundId) {
        Intrinsics.checkNotNullParameter(merchantName, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        Intrinsics.checkNotNullParameter(clientId, "");
        return new LinkedMerchant(merchantName, merchantLogo, merchantPCLogo, merchantBoundDate, merchantId, divisionId, clientId, regId, userBoundId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LinkedMerchant) {
            LinkedMerchant linkedMerchant = (LinkedMerchant) other;
            return Intrinsics.areEqual(this.merchantName, linkedMerchant.merchantName) && Intrinsics.areEqual(this.merchantLogo, linkedMerchant.merchantLogo) && Intrinsics.areEqual(this.merchantPCLogo, linkedMerchant.merchantPCLogo) && this.merchantBoundDate == linkedMerchant.merchantBoundDate && Intrinsics.areEqual(this.merchantId, linkedMerchant.merchantId) && Intrinsics.areEqual(this.divisionId, linkedMerchant.divisionId) && Intrinsics.areEqual(this.clientId, linkedMerchant.clientId) && Intrinsics.areEqual(this.regId, linkedMerchant.regId) && Intrinsics.areEqual(this.userBoundId, linkedMerchant.userBoundId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.merchantName.hashCode();
        String str = this.merchantLogo;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.merchantPCLogo;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.merchantBoundDate);
        int hashCode4 = this.merchantId.hashCode();
        String str3 = this.divisionId;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        int hashCode6 = this.clientId.hashCode();
        String str4 = this.regId;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.userBoundId;
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + m) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedMerchant(merchantName=");
        sb.append(this.merchantName);
        sb.append(", merchantLogo=");
        sb.append(this.merchantLogo);
        sb.append(", merchantPCLogo=");
        sb.append(this.merchantPCLogo);
        sb.append(", merchantBoundDate=");
        sb.append(this.merchantBoundDate);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", divisionId=");
        sb.append(this.divisionId);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", regId=");
        sb.append(this.regId);
        sb.append(", userBoundId=");
        sb.append(this.userBoundId);
        sb.append(')');
        return sb.toString();
    }

    public LinkedMerchant(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.merchantName = str;
        this.merchantLogo = str2;
        this.merchantPCLogo = str3;
        this.merchantBoundDate = j;
        this.merchantId = str4;
        this.divisionId = str5;
        this.clientId = str6;
        this.regId = str7;
        this.userBoundId = str8;
    }

    public /* synthetic */ LinkedMerchant(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, str4, str5, str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8);
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "getMerchantLogo")
    public final String getMerchantLogo() {
        return this.merchantLogo;
    }

    @JvmName(name = "getMerchantPCLogo")
    public final String getMerchantPCLogo() {
        return this.merchantPCLogo;
    }

    @JvmName(name = "getMerchantBoundDate")
    public final long getMerchantBoundDate() {
        return this.merchantBoundDate;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "getDivisionId")
    public final String getDivisionId() {
        return this.divisionId;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getRegId")
    public final String getRegId() {
        return this.regId;
    }

    @JvmName(name = "getUserBoundId")
    public final String getUserBoundId() {
        return this.userBoundId;
    }
}
