package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "Lid/dana/data/familyaccount/model/result/FamilyAccountMemberInfoEntity;", "component3", "()Ljava/util/List;", "status", "balance", "sharedAccountMemberInfoList", "copy", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;)Lid/dana/data/familyaccount/model/result/DashboardFamilyAccountEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getBalance", "Ljava/util/List;", "getSharedAccountMemberInfoList", "Ljava/lang/String;", "getStatus", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DashboardFamilyAccountEntity extends BaseRpcResult {
    private final MoneyViewEntity balance;
    private final List<FamilyAccountMemberInfoEntity> sharedAccountMemberInfoList;
    private final String status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DashboardFamilyAccountEntity copy$default(DashboardFamilyAccountEntity dashboardFamilyAccountEntity, String str, MoneyViewEntity moneyViewEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dashboardFamilyAccountEntity.status;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = dashboardFamilyAccountEntity.balance;
        }
        if ((i & 4) != 0) {
            list = dashboardFamilyAccountEntity.sharedAccountMemberInfoList;
        }
        return dashboardFamilyAccountEntity.copy(str, moneyViewEntity, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getBalance() {
        return this.balance;
    }

    public final List<FamilyAccountMemberInfoEntity> component3() {
        return this.sharedAccountMemberInfoList;
    }

    public final DashboardFamilyAccountEntity copy(String status, MoneyViewEntity balance, List<FamilyAccountMemberInfoEntity> sharedAccountMemberInfoList) {
        return new DashboardFamilyAccountEntity(status, balance, sharedAccountMemberInfoList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DashboardFamilyAccountEntity) {
            DashboardFamilyAccountEntity dashboardFamilyAccountEntity = (DashboardFamilyAccountEntity) other;
            return Intrinsics.areEqual(this.status, dashboardFamilyAccountEntity.status) && Intrinsics.areEqual(this.balance, dashboardFamilyAccountEntity.balance) && Intrinsics.areEqual(this.sharedAccountMemberInfoList, dashboardFamilyAccountEntity.sharedAccountMemberInfoList);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.status;
        int hashCode = str == null ? 0 : str.hashCode();
        MoneyViewEntity moneyViewEntity = this.balance;
        int hashCode2 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        List<FamilyAccountMemberInfoEntity> list = this.sharedAccountMemberInfoList;
        return (((hashCode * 31) + hashCode2) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DashboardFamilyAccountEntity(status=");
        sb.append(this.status);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", sharedAccountMemberInfoList=");
        sb.append(this.sharedAccountMemberInfoList);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getBalance")
    public final MoneyViewEntity getBalance() {
        return this.balance;
    }

    @JvmName(name = "getSharedAccountMemberInfoList")
    public final List<FamilyAccountMemberInfoEntity> getSharedAccountMemberInfoList() {
        return this.sharedAccountMemberInfoList;
    }

    public DashboardFamilyAccountEntity(String str, MoneyViewEntity moneyViewEntity, List<FamilyAccountMemberInfoEntity> list) {
        this.status = str;
        this.balance = moneyViewEntity;
        this.sharedAccountMemberInfoList = list;
    }
}
