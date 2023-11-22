package id.dana.domain.saving.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b3\u00104J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jb\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b#\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u0005R\"\u0010\u0018\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010&\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010)R\"\u0010\u0017\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010&\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010)R\"\u0010\u0016\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010&\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010)R\u001a\u0010\u0015\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u0010\u000bR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b0\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0012"}, d2 = {"Lid/dana/domain/saving/model/SavingUpdateInit;", "", "", "", "component1", "()Ljava/util/List;", "", "Lid/dana/domain/saving/model/SavingCategory;", "component2", "Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component4", "()Ljava/lang/String;", "component5", "component6", "Lid/dana/domain/saving/model/SavingGoalView;", "component7", "()Lid/dana/domain/saving/model/SavingGoalView;", "categoryCodes", "savingCategories", "maxTargetAmount", "maxSavingCountNonKyc", "maxSavingAmountNonKyc", "maxSavingAmountKyc", "savingGoalView", "copy", "(Ljava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/saving/model/SavingGoalView;)Lid/dana/domain/saving/model/SavingUpdateInit;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/List;", "getCategoryCodes", "Ljava/lang/String;", "getMaxSavingAmountKyc", "setMaxSavingAmountKyc", "(Ljava/lang/String;)V", "getMaxSavingAmountNonKyc", "setMaxSavingAmountNonKyc", "getMaxSavingCountNonKyc", "setMaxSavingCountNonKyc", "Lid/dana/domain/nearbyme/model/MoneyView;", "getMaxTargetAmount", "getSavingCategories", "Lid/dana/domain/saving/model/SavingGoalView;", "getSavingGoalView", "<init>", "(Ljava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/saving/model/SavingGoalView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingUpdateInit {
    private final List<String> categoryCodes;
    private String maxSavingAmountKyc;
    private String maxSavingAmountNonKyc;
    private String maxSavingCountNonKyc;
    private final MoneyView maxTargetAmount;
    private final List<SavingCategory> savingCategories;
    private final SavingGoalView savingGoalView;

    public static /* synthetic */ SavingUpdateInit copy$default(SavingUpdateInit savingUpdateInit, List list, List list2, MoneyView moneyView, String str, String str2, String str3, SavingGoalView savingGoalView, int i, Object obj) {
        List<String> list3 = list;
        if ((i & 1) != 0) {
            list3 = savingUpdateInit.categoryCodes;
        }
        List<SavingCategory> list4 = list2;
        if ((i & 2) != 0) {
            list4 = savingUpdateInit.savingCategories;
        }
        List list5 = list4;
        if ((i & 4) != 0) {
            moneyView = savingUpdateInit.maxTargetAmount;
        }
        MoneyView moneyView2 = moneyView;
        if ((i & 8) != 0) {
            str = savingUpdateInit.maxSavingCountNonKyc;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = savingUpdateInit.maxSavingAmountNonKyc;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = savingUpdateInit.maxSavingAmountKyc;
        }
        String str6 = str3;
        if ((i & 64) != 0) {
            savingGoalView = savingUpdateInit.savingGoalView;
        }
        return savingUpdateInit.copy(list3, list5, moneyView2, str4, str5, str6, savingGoalView);
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

    /* renamed from: component7  reason: from getter */
    public final SavingGoalView getSavingGoalView() {
        return this.savingGoalView;
    }

    public final SavingUpdateInit copy(List<String> categoryCodes, List<SavingCategory> savingCategories, MoneyView maxTargetAmount, String maxSavingCountNonKyc, String maxSavingAmountNonKyc, String maxSavingAmountKyc, SavingGoalView savingGoalView) {
        Intrinsics.checkNotNullParameter(categoryCodes, "");
        Intrinsics.checkNotNullParameter(savingCategories, "");
        Intrinsics.checkNotNullParameter(maxTargetAmount, "");
        Intrinsics.checkNotNullParameter(maxSavingCountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountNonKyc, "");
        Intrinsics.checkNotNullParameter(maxSavingAmountKyc, "");
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        return new SavingUpdateInit(categoryCodes, savingCategories, maxTargetAmount, maxSavingCountNonKyc, maxSavingAmountNonKyc, maxSavingAmountKyc, savingGoalView);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingUpdateInit) {
            SavingUpdateInit savingUpdateInit = (SavingUpdateInit) other;
            return Intrinsics.areEqual(this.categoryCodes, savingUpdateInit.categoryCodes) && Intrinsics.areEqual(this.savingCategories, savingUpdateInit.savingCategories) && Intrinsics.areEqual(this.maxTargetAmount, savingUpdateInit.maxTargetAmount) && Intrinsics.areEqual(this.maxSavingCountNonKyc, savingUpdateInit.maxSavingCountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountNonKyc, savingUpdateInit.maxSavingAmountNonKyc) && Intrinsics.areEqual(this.maxSavingAmountKyc, savingUpdateInit.maxSavingAmountKyc) && Intrinsics.areEqual(this.savingGoalView, savingUpdateInit.savingGoalView);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.categoryCodes.hashCode() * 31) + this.savingCategories.hashCode()) * 31) + this.maxTargetAmount.hashCode()) * 31) + this.maxSavingCountNonKyc.hashCode()) * 31) + this.maxSavingAmountNonKyc.hashCode()) * 31) + this.maxSavingAmountKyc.hashCode()) * 31) + this.savingGoalView.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingUpdateInit(categoryCodes=");
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
        sb.append(", savingGoalView=");
        sb.append(this.savingGoalView);
        sb.append(')');
        return sb.toString();
    }

    public SavingUpdateInit(List<String> list, List<SavingCategory> list2, MoneyView moneyView, String str, String str2, String str3, SavingGoalView savingGoalView) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        this.categoryCodes = list;
        this.savingCategories = list2;
        this.maxTargetAmount = moneyView;
        this.maxSavingCountNonKyc = str;
        this.maxSavingAmountNonKyc = str2;
        this.maxSavingAmountKyc = str3;
        this.savingGoalView = savingGoalView;
    }

    @JvmName(name = "getCategoryCodes")
    public final List<String> getCategoryCodes() {
        return this.categoryCodes;
    }

    public /* synthetic */ SavingUpdateInit(List list, List list2, MoneyView moneyView, String str, String str2, String str3, SavingGoalView savingGoalView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new ArrayList() : list2, moneyView, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? "" : str2, (i & 32) != 0 ? "" : str3, savingGoalView);
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

    @JvmName(name = "getSavingGoalView")
    public final SavingGoalView getSavingGoalView() {
        return this.savingGoalView;
    }
}
