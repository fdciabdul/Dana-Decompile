package id.dana.data.saving.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/data/saving/repository/source/network/request/GoalUpdateSubmitRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "savingId", "categoryCode", "title", "targetAmount", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/saving/repository/source/network/request/GoalUpdateSubmitRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategoryCode", "getSavingId", "getTargetAmount", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GoalUpdateSubmitRequest extends BaseRpcRequest {
    private final String categoryCode;
    private final String savingId;
    private final String targetAmount;
    private final String title;

    public static /* synthetic */ GoalUpdateSubmitRequest copy$default(GoalUpdateSubmitRequest goalUpdateSubmitRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = goalUpdateSubmitRequest.savingId;
        }
        if ((i & 2) != 0) {
            str2 = goalUpdateSubmitRequest.categoryCode;
        }
        if ((i & 4) != 0) {
            str3 = goalUpdateSubmitRequest.title;
        }
        if ((i & 8) != 0) {
            str4 = goalUpdateSubmitRequest.targetAmount;
        }
        return goalUpdateSubmitRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4  reason: from getter */
    public final String getTargetAmount() {
        return this.targetAmount;
    }

    public final GoalUpdateSubmitRequest copy(String savingId, String categoryCode, String title, String targetAmount) {
        Intrinsics.checkNotNullParameter(savingId, "");
        Intrinsics.checkNotNullParameter(categoryCode, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(targetAmount, "");
        return new GoalUpdateSubmitRequest(savingId, categoryCode, title, targetAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GoalUpdateSubmitRequest) {
            GoalUpdateSubmitRequest goalUpdateSubmitRequest = (GoalUpdateSubmitRequest) other;
            return Intrinsics.areEqual(this.savingId, goalUpdateSubmitRequest.savingId) && Intrinsics.areEqual(this.categoryCode, goalUpdateSubmitRequest.categoryCode) && Intrinsics.areEqual(this.title, goalUpdateSubmitRequest.title) && Intrinsics.areEqual(this.targetAmount, goalUpdateSubmitRequest.targetAmount);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.savingId.hashCode() * 31) + this.categoryCode.hashCode()) * 31) + this.title.hashCode()) * 31) + this.targetAmount.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GoalUpdateSubmitRequest(savingId=");
        sb.append(this.savingId);
        sb.append(", categoryCode=");
        sb.append(this.categoryCode);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", targetAmount=");
        sb.append(this.targetAmount);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSavingId")
    public final String getSavingId() {
        return this.savingId;
    }

    @JvmName(name = "getCategoryCode")
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getTargetAmount")
    public final String getTargetAmount() {
        return this.targetAmount;
    }

    public GoalUpdateSubmitRequest(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.savingId = str;
        this.categoryCode = str2;
        this.title = str3;
        this.targetAmount = str4;
    }
}
