package id.dana.data.saving.model;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J|\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u0004R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0018\u0010%\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010%\u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b)\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b+\u0010\nR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b-\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b/\u0010\nR\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b0\u0010\u0004"}, d2 = {"Lid/dana/data/saving/model/SavingView;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component4", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component5", "component6", "component7", "component8", "component9", "savingId", "title", "categoryCode", "currentAmount", "targetAmount", "orderStatus", "orderSubStatus", "createdTime", "achievedTime", "completedTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/saving/model/SavingView;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAchievedTime", "getCategoryCode", "getCompletedTime", "getCreatedTime", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getCurrentAmount", "getOrderStatus", "getOrderSubStatus", "getSavingId", "getTargetAmount", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SavingView extends BaseRpcResult {
    private final String achievedTime;
    private final String categoryCode;
    private final String completedTime;
    private final String createdTime;
    private final MoneyViewEntity currentAmount;
    private final String orderStatus;
    private final String orderSubStatus;
    private final String savingId;
    private final MoneyViewEntity targetAmount;
    private final String title;

    /* renamed from: component1  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getCompletedTime() {
        return this.completedTime;
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
    public final MoneyViewEntity getCurrentAmount() {
        return this.currentAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyViewEntity getTargetAmount() {
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

    public final SavingView copy(String savingId, String title, String categoryCode, MoneyViewEntity currentAmount, MoneyViewEntity targetAmount, String orderStatus, String orderSubStatus, String createdTime, String achievedTime, String completedTime) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(currentAmount, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        Intrinsics.checkNotNullParameter(orderStatus, "");
        return new SavingView(savingId, title, categoryCode, currentAmount, targetAmount, orderStatus, orderSubStatus, createdTime, achievedTime, completedTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SavingView) {
            SavingView savingView = (SavingView) other;
            return Intrinsics.areEqual(this.savingId, savingView.savingId) && Intrinsics.areEqual(this.title, savingView.title) && Intrinsics.areEqual(this.categoryCode, savingView.categoryCode) && Intrinsics.areEqual(this.currentAmount, savingView.currentAmount) && Intrinsics.areEqual(this.targetAmount, savingView.targetAmount) && Intrinsics.areEqual(this.orderStatus, savingView.orderStatus) && Intrinsics.areEqual(this.orderSubStatus, savingView.orderSubStatus) && Intrinsics.areEqual(this.createdTime, savingView.createdTime) && Intrinsics.areEqual(this.achievedTime, savingView.achievedTime) && Intrinsics.areEqual(this.completedTime, savingView.completedTime);
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
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SavingView(savingId=");
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
        sb.append(')');
        return sb.toString();
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
    public final MoneyViewEntity getCurrentAmount() {
        return this.currentAmount;
    }

    @JvmName(name = "getTargetAmount")
    public final MoneyViewEntity getTargetAmount() {
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

    public SavingView(String str, String str2, String str3, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        Intrinsics.checkNotNullParameter(moneyViewEntity2, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.savingId = str;
        this.title = str2;
        this.categoryCode = str3;
        this.currentAmount = moneyViewEntity;
        this.targetAmount = moneyViewEntity2;
        this.orderStatus = str4;
        this.orderSubStatus = str5;
        this.createdTime = str6;
        this.achievedTime = str7;
        this.completedTime = str8;
    }
}
