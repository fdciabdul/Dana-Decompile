package id.dana.domain.electronicmoney.model.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\\\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b#\u0010\u0004R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\rR\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b'\u0010\u0004"}, d2 = {"Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "Lid/dana/domain/electronicmoney/model/request/BrizziHistoryInfo;", "component7", "()Ljava/util/List;", "reversalData", "reffNumber", "cardNumber", "lastTrxDate", "balance", "errorCode", "listBrizziHistoryInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBalance", "getCardNumber", "getErrorCode", "getLastTrxDate", "Ljava/util/List;", "getListBrizziHistoryInfo", "getReffNumber", "getReversalData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class BrizziReversalInfo {
    private final String balance;
    private final String cardNumber;
    private final String errorCode;
    private final String lastTrxDate;
    private final List<BrizziHistoryInfo> listBrizziHistoryInfo;
    private final String reffNumber;
    private final String reversalData;

    public static /* synthetic */ BrizziReversalInfo copy$default(BrizziReversalInfo brizziReversalInfo, String str, String str2, String str3, String str4, String str5, String str6, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = brizziReversalInfo.reversalData;
        }
        if ((i & 2) != 0) {
            str2 = brizziReversalInfo.reffNumber;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = brizziReversalInfo.cardNumber;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = brizziReversalInfo.lastTrxDate;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = brizziReversalInfo.balance;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = brizziReversalInfo.errorCode;
        }
        String str11 = str6;
        List<BrizziHistoryInfo> list2 = list;
        if ((i & 64) != 0) {
            list2 = brizziReversalInfo.listBrizziHistoryInfo;
        }
        return brizziReversalInfo.copy(str, str7, str8, str9, str10, str11, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getReversalData() {
        return this.reversalData;
    }

    /* renamed from: component2  reason: from getter */
    public final String getReffNumber() {
        return this.reffNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLastTrxDate() {
        return this.lastTrxDate;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component6  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    public final List<BrizziHistoryInfo> component7() {
        return this.listBrizziHistoryInfo;
    }

    public final BrizziReversalInfo copy(String reversalData, String reffNumber, String cardNumber, String lastTrxDate, String balance, String errorCode, List<BrizziHistoryInfo> listBrizziHistoryInfo) {
        Intrinsics.checkNotNullParameter(reversalData, "");
        Intrinsics.checkNotNullParameter(reffNumber, "");
        Intrinsics.checkNotNullParameter(cardNumber, "");
        Intrinsics.checkNotNullParameter(lastTrxDate, "");
        Intrinsics.checkNotNullParameter(balance, "");
        Intrinsics.checkNotNullParameter(errorCode, "");
        Intrinsics.checkNotNullParameter(listBrizziHistoryInfo, "");
        return new BrizziReversalInfo(reversalData, reffNumber, cardNumber, lastTrxDate, balance, errorCode, listBrizziHistoryInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BrizziReversalInfo) {
            BrizziReversalInfo brizziReversalInfo = (BrizziReversalInfo) other;
            return Intrinsics.areEqual(this.reversalData, brizziReversalInfo.reversalData) && Intrinsics.areEqual(this.reffNumber, brizziReversalInfo.reffNumber) && Intrinsics.areEqual(this.cardNumber, brizziReversalInfo.cardNumber) && Intrinsics.areEqual(this.lastTrxDate, brizziReversalInfo.lastTrxDate) && Intrinsics.areEqual(this.balance, brizziReversalInfo.balance) && Intrinsics.areEqual(this.errorCode, brizziReversalInfo.errorCode) && Intrinsics.areEqual(this.listBrizziHistoryInfo, brizziReversalInfo.listBrizziHistoryInfo);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.reversalData.hashCode() * 31) + this.reffNumber.hashCode()) * 31) + this.cardNumber.hashCode()) * 31) + this.lastTrxDate.hashCode()) * 31) + this.balance.hashCode()) * 31) + this.errorCode.hashCode()) * 31) + this.listBrizziHistoryInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BrizziReversalInfo(reversalData=");
        sb.append(this.reversalData);
        sb.append(", reffNumber=");
        sb.append(this.reffNumber);
        sb.append(", cardNumber=");
        sb.append(this.cardNumber);
        sb.append(", lastTrxDate=");
        sb.append(this.lastTrxDate);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", listBrizziHistoryInfo=");
        sb.append(this.listBrizziHistoryInfo);
        sb.append(')');
        return sb.toString();
    }

    public BrizziReversalInfo(String str, String str2, String str3, String str4, String str5, String str6, List<BrizziHistoryInfo> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.reversalData = str;
        this.reffNumber = str2;
        this.cardNumber = str3;
        this.lastTrxDate = str4;
        this.balance = str5;
        this.errorCode = str6;
        this.listBrizziHistoryInfo = list;
    }

    @JvmName(name = "getReversalData")
    public final String getReversalData() {
        return this.reversalData;
    }

    @JvmName(name = "getReffNumber")
    public final String getReffNumber() {
        return this.reffNumber;
    }

    @JvmName(name = "getCardNumber")
    public final String getCardNumber() {
        return this.cardNumber;
    }

    @JvmName(name = "getLastTrxDate")
    public final String getLastTrxDate() {
        return this.lastTrxDate;
    }

    @JvmName(name = "getBalance")
    public final String getBalance() {
        return this.balance;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    public /* synthetic */ BrizziReversalInfo(String str, String str2, String str3, String str4, String str5, String str6, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getListBrizziHistoryInfo")
    public final List<BrizziHistoryInfo> getListBrizziHistoryInfo() {
        return this.listBrizziHistoryInfo;
    }
}
