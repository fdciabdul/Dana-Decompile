package id.dana.domain.saving.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b-\u0010.J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJX\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0005R\"\u0010\u0015\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010%R\"\u0010\u0014\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\"\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010%R\"\u0010\u0013\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010%R\u001a\u0010\u0012\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b+\u0010\u000bR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b,\u0010\u0005"}, d2 = {"Lid/dana/domain/saving/model/SavingCreateInit;", "", "", "", "component1", "()Ljava/util/List;", "", "Lid/dana/domain/saving/model/SavingCategory;", "component2", "Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component4", "()Ljava/lang/String;", "component5", "component6", "categoryCodes", "savingCategories", "maxTargetAmount", "maxSavingCountNonKyc", "maxSavingAmountNonKyc", "maxSavingAmountKyc", "copy", "(Ljava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/saving/model/SavingCreateInit;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getCategoryCodes", "Ljava/lang/String;", "getMaxSavingAmountKyc", "setMaxSavingAmountKyc", "(Ljava/lang/String;)V", "getMaxSavingAmountNonKyc", "setMaxSavingAmountNonKyc", "getMaxSavingCountNonKyc", "setMaxSavingCountNonKyc", "Lid/dana/domain/nearbyme/model/MoneyView;", "getMaxTargetAmount", "getSavingCategories", "<init>", "(Ljava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingCreateInit {
    private final List<String> categoryCodes;
    private String maxSavingAmountKyc;
    private String maxSavingAmountNonKyc;
    private String maxSavingCountNonKyc;
    private final MoneyView maxTargetAmount;
    private final List<SavingCategory> savingCategories;

    public static /* synthetic */ SavingCreateInit copy$default(SavingCreateInit savingCreateInit, List list, List list2, MoneyView moneyView, String str, String str2, String str3, int i, Object obj) {
        List<String> list3 = list;
        if ((i & 1) != 0) {
            list3 = savingCreateInit.categoryCodes;
        }
        List<SavingCategory> list4 = list2;
        if ((i & 2) != 0) {
            list4 = savingCreateInit.savingCategories;
        }
        List list5 = list4;
        if ((i & 4) != 0) {
            moneyView = savingCreateInit.maxTargetAmount;
        }
        MoneyView moneyView2 = moneyView;
        if ((i & 8) != 0) {
            str = savingCreateInit.maxSavingCountNonKyc;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = savingCreateInit.maxSavingAmountNonKyc;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = savingCreateInit.maxSavingAmountKyc;
        }
        return savingCreateInit.copy(list3, list5, moneyView2, str4, str5, str3);
    }

    public final List<String> component1() {
        return this.categoryCodes;
    }

    public final List<SavingCategory> component2() {
        return this.savingCategories;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getMaxTargetAmount() {
        return this.maxTargetAmount;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMaxSavingCountNonKyc() {
        return this.maxSavingCountNonKyc;
    }

    /* renamed from: component5  reason: from getter */
    public final String getMaxSavingAmountNonKyc() {
        return this.maxSavingAmountNonKyc;
    }

    /* renamed from: component6  reason: from getter */
    public final String getMaxSavingAmountKyc() {
        return this.maxSavingAmountKyc;
    }

    public final SavingCreateInit copy(List<String> categoryCodes, List<SavingCategory> savingCategories, MoneyView maxTargetAmount, String maxSavingCountNonKyc, String maxSavingAmountNonKyc, String maxSavingAmountKyc) {
        Intrinsics.checkNotNullParameter(categoryCodes, "");
        Intrinsics.checkNotNullParameter(savingCategories, "");
        Intrinsics.checkNotNullParameter(maxTargetAmount, "");
        Intrinsics.checkNotNullParameter(maxSavingCountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountKyc, "");
        return new SavingCreateInit(categoryCodes, savingCategories, maxTargetAmount, maxSavingCountNonKyc, maxSavingAmountNonKyc, maxSavingAmountKyc);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingCreateInit) {
            SavingCreateInit savingCreateInit = (SavingCreateInit) other;
            return Intrinsics.areEqual(this.categoryCodes, savingCreateInit.categoryCodes) && Intrinsics.areEqual(this.savingCategories, savingCreateInit.savingCategories) && Intrinsics.areEqual(this.maxTargetAmount, savingCreateInit.maxTargetAmount) && Intrinsics.areEqual(this.maxSavingCountNonKyc, savingCreateInit.maxSavingCountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountNonKyc, savingCreateInit.maxSavingAmountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountKyc, savingCreateInit.maxSavingAmountKyc);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.categoryCodes.hashCode() * 31) + this.savingCategories.hashCode()) * 31) + this.maxTargetAmount.hashCode()) * 31) + this.maxSavingCountNonKyc.hashCode()) * 31) + this.maxSavingAmountNonKyc.hashCode()) * 31) + this.maxSavingAmountKyc.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingCreateInit(categoryCodes=");
        sb.append(this.categoryCodes);
        sb.append(", savingCategories=");
        sb.append(this.savingCategories);
        sb.append(", maxTargetAmount=");
        sb.append(this.maxTargetAmount);
        sb.append(", maxSavingCountNonKyc=");
        sb.append(this.maxSavingCountNonKyc);
        sb.append(", maxSavingAmountNonKyc=");
        sb.append(this.maxSavingAmountNonKyc);
        sb.append(", maxSavingAmountKyc=");
        sb.append(this.maxSavingAmountKyc);
        sb.append(')');
        return sb.toString();
    }

    public SavingCreateInit(List<String> list, List<SavingCategory> list2, MoneyView moneyView, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.categoryCodes = list;
        this.savingCategories = list2;
        this.maxTargetAmount = moneyView;
        this.maxSavingCountNonKyc = str;
        this.maxSavingAmountNonKyc = str2;
        this.maxSavingAmountKyc = str3;
    }

    public /* synthetic */ SavingCreateInit(List list, List list2, MoneyView moneyView, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, moneyView, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3);
    }

    @JvmName(name = "getCategoryCodes")
    public final List<String> getCategoryCodes() {
        return this.categoryCodes;
    }

    @JvmName(name = "getSavingCategories")
    public final List<SavingCategory> getSavingCategories() {
        return this.savingCategories;
    }

    @JvmName(name = "getMaxTargetAmount")
    public final MoneyView getMaxTargetAmount() {
        return this.maxTargetAmount;
    }

    @JvmName(name = "getMaxSavingCountNonKyc")
    public final String getMaxSavingCountNonKyc() {
        return this.maxSavingCountNonKyc;
    }

    @JvmName(name = "setMaxSavingCountNonKyc")
    public final void setMaxSavingCountNonKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingCountNonKyc = str;
    }

    @JvmName(name = "getMaxSavingAmountNonKyc")
    public final String getMaxSavingAmountNonKyc() {
        return this.maxSavingAmountNonKyc;
    }

    @JvmName(name = "setMaxSavingAmountNonKyc")
    public final void setMaxSavingAmountNonKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingAmountNonKyc = str;
    }

    @JvmName(name = "getMaxSavingAmountKyc")
    public final String getMaxSavingAmountKyc() {
        return this.maxSavingAmountKyc;
    }

    @JvmName(name = "setMaxSavingAmountKyc")
    public final void setMaxSavingAmountKyc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.maxSavingAmountKyc = str;
    }
}
