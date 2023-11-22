package id.dana.data.recentrecipient.model;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004"}, d2 = {"Lid/dana/data/recentrecipient/model/BankCardConversionResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component2", WalletConstant.CARD_INDEX_NO, "formattedMaskedCardNo", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/recentrecipient/model/BankCardConversionResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCardIndexNo", "getFormattedMaskedCardNo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BankCardConversionResult extends BaseRpcResultAphome {
    @SerializedName(WalletConstant.CARD_INDEX_NO)
    private final String cardIndexNo;
    private final String formattedMaskedCardNo;

    public static /* synthetic */ BankCardConversionResult copy$default(BankCardConversionResult bankCardConversionResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bankCardConversionResult.cardIndexNo;
        }
        if ((i & 2) != 0) {
            str2 = bankCardConversionResult.formattedMaskedCardNo;
        }
        return bankCardConversionResult.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getFormattedMaskedCardNo() {
        return this.formattedMaskedCardNo;
    }

    public final BankCardConversionResult copy(String cardIndexNo, String formattedMaskedCardNo) {
        Intrinsics.checkNotNullParameter(cardIndexNo, "");
        Intrinsics.checkNotNullParameter(formattedMaskedCardNo, "");
        return new BankCardConversionResult(cardIndexNo, formattedMaskedCardNo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BankCardConversionResult) {
            BankCardConversionResult bankCardConversionResult = (BankCardConversionResult) other;
            return Intrinsics.areEqual(this.cardIndexNo, bankCardConversionResult.cardIndexNo) && Intrinsics.areEqual(this.formattedMaskedCardNo, bankCardConversionResult.formattedMaskedCardNo);
        }
        return false;
    }

    public final int hashCode() {
        return (this.cardIndexNo.hashCode() * 31) + this.formattedMaskedCardNo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BankCardConversionResult(cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", formattedMaskedCardNo=");
        sb.append(this.formattedMaskedCardNo);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getFormattedMaskedCardNo")
    public final String getFormattedMaskedCardNo() {
        return this.formattedMaskedCardNo;
    }

    public BankCardConversionResult(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.cardIndexNo = str;
        this.formattedMaskedCardNo = str2;
    }
}
