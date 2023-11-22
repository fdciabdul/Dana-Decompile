package id.dana.domain.saving.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u009e\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b+\u0010\u0004R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001e\u0010,\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b0\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u0010R&\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b4\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010,\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010,\u001a\u0004\b6\u0010\u0004R$\u0010 \u001a\u0004\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00107\u001a\u0004\b8\u0010\b\"\u0004\b9\u0010:R\u001a\u0010\u0016\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b;\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00101\u001a\u0004\b<\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b=\u0010\u0004"}, d2 = {"Lid/dana/domain/saving/model/SavingGoalView;", "", "", "component1", "()Ljava/lang/String;", "component10", "Lid/dana/domain/saving/model/SavingCategory;", "component11", "()Lid/dana/domain/saving/model/SavingCategory;", "", "component12", "()Ljava/util/Map;", "component2", "component3", "Lid/dana/domain/nearbyme/model/MoneyView;", "component4", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component5", "component6", "component7", "component8", "component9", "savingId", "title", "categoryCode", "currentAmount", "targetAmount", "orderStatus", "orderSubStatus", "createdTime", "achievedTime", "completedTime", "savingCategory", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/saving/model/SavingCategory;Ljava/util/Map;)Lid/dana/domain/saving/model/SavingGoalView;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAchievedTime", "getCategoryCode", "getCompletedTime", "getCreatedTime", "Lid/dana/domain/nearbyme/model/MoneyView;", "getCurrentAmount", "Ljava/util/Map;", "getExtendInfo", "getOrderStatus", "getOrderSubStatus", "Lid/dana/domain/saving/model/SavingCategory;", "getSavingCategory", "setSavingCategory", "(Lid/dana/domain/saving/model/SavingCategory;)V", "getSavingId", "getTargetAmount", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/saving/model/SavingCategory;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingGoalView {
    private final String achievedTime;
    private final String categoryCode;
    private final String completedTime;
    private final String createdTime;
    private final MoneyView currentAmount;
    private final Map<String, String> extendInfo;
    private final String orderStatus;
    private final String orderSubStatus;
    private SavingCategory savingCategory;
    private final String savingId;
    private final MoneyView targetAmount;
    private final String title;

    /* renamed from: component1  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getCompletedTime() {
        return this.completedTime;
    }

    /* renamed from: component11  reason: from getter */
    public final SavingCategory getSavingCategory() {
        return this.savingCategory;
    }

    public final Map<String, String> component12() {
        return this.extendInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyView getCurrentAmount() {
        return this.currentAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getTargetAmount() {
        return this.targetAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    /* renamed from: component7  reason: from getter */
    public final String getOrderSubStatus() {
        return this.orderSubStatus;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component9  reason: from getter */
    public final String getAchievedTime() {
        return this.achievedTime;
    }

    public final SavingGoalView copy(String savingId, String title, String categoryCode, MoneyView currentAmount, MoneyView targetAmount, String orderStatus, String orderSubStatus, String createdTime, String achievedTime, String completedTime, SavingCategory savingCategory, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(currentAmount, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        Intrinsics.checkNotNullParameter(orderStatus, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new SavingGoalView(savingId, title, categoryCode, currentAmount, targetAmount, orderStatus, orderSubStatus, createdTime, achievedTime, completedTime, savingCategory, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingGoalView) {
            SavingGoalView savingGoalView = (SavingGoalView) other;
            return Intrinsics.areEqual(this.savingId, savingGoalView.savingId) && Intrinsics.areEqual(this.title, savingGoalView.title) && Intrinsics.areEqual(this.categoryCode, savingGoalView.categoryCode) && Intrinsics.areEqual(this.currentAmount, savingGoalView.currentAmount) && Intrinsics.areEqual(this.targetAmount, savingGoalView.targetAmount) && Intrinsics.areEqual(this.orderStatus, savingGoalView.orderStatus) && Intrinsics.areEqual(this.orderSubStatus, savingGoalView.orderSubStatus) && Intrinsics.areEqual(this.createdTime, savingGoalView.createdTime) && Intrinsics.areEqual(this.achievedTime, savingGoalView.achievedTime) && Intrinsics.areEqual(this.completedTime, savingGoalView.completedTime) && Intrinsics.areEqual(this.savingCategory, savingGoalView.savingCategory) && Intrinsics.areEqual(this.extendInfo, savingGoalView.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.savingId.hashCode();
        int hashCode2 = this.title.hashCode();
        int hashCode3 = this.categoryCode.hashCode();
        int hashCode4 = this.currentAmount.hashCode();
        int hashCode5 = this.targetAmount.hashCode();
        int hashCode6 = this.orderStatus.hashCode();
        String str = this.orderSubStatus;
        int hashCode7 = str == null ? 0 : str.hashCode();
        String str2 = this.createdTime;
        int hashCode8 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.achievedTime;
        int hashCode9 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.completedTime;
        int hashCode10 = str4 == null ? 0 : str4.hashCode();
        SavingCategory savingCategory = this.savingCategory;
        return (((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + (savingCategory != null ? savingCategory.hashCode() : 0)) * 31) + this.extendInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingGoalView(savingId=");
        sb.append(this.savingId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", categoryCode=");
        sb.append(this.categoryCode);
        sb.append(", currentAmount=");
        sb.append(this.currentAmount);
        sb.append(", targetAmount=");
        sb.append(this.targetAmount);
        sb.append(", orderStatus=");
        sb.append(this.orderStatus);
        sb.append(", orderSubStatus=");
        sb.append(this.orderSubStatus);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", achievedTime=");
        sb.append(this.achievedTime);
        sb.append(", completedTime=");
        sb.append(this.completedTime);
        sb.append(", savingCategory=");
        sb.append(this.savingCategory);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public SavingGoalView(String str, String str2, String str3, MoneyView moneyView, MoneyView moneyView2, String str4, String str5, String str6, String str7, String str8, SavingCategory savingCategory, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.savingId = str;
        this.title = str2;
        this.categoryCode = str3;
        this.currentAmount = moneyView;
        this.targetAmount = moneyView2;
        this.orderStatus = str4;
        this.orderSubStatus = str5;
        this.createdTime = str6;
        this.achievedTime = str7;
        this.completedTime = str8;
        this.savingCategory = savingCategory;
        this.extendInfo = map;
    }

    @JvmName(name = "getSavingId")
    public final String getSavingId() {
        return this.savingId;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getCategoryCode")
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    @JvmName(name = "getCurrentAmount")
    public final MoneyView getCurrentAmount() {
        return this.currentAmount;
    }

    @JvmName(name = "getTargetAmount")
    public final MoneyView getTargetAmount() {
        return this.targetAmount;
    }

    @JvmName(name = "getOrderStatus")
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    @JvmName(name = "getOrderSubStatus")
    public final String getOrderSubStatus() {
        return this.orderSubStatus;
    }

    @JvmName(name = "getCreatedTime")
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getAchievedTime")
    public final String getAchievedTime() {
        return this.achievedTime;
    }

    @JvmName(name = "getCompletedTime")
    public final String getCompletedTime() {
        return this.completedTime;
    }

    @JvmName(name = "getSavingCategory")
    public final SavingCategory getSavingCategory() {
        return this.savingCategory;
    }

    @JvmName(name = "setSavingCategory")
    public final void setSavingCategory(SavingCategory savingCategory) {
        this.savingCategory = savingCategory;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
