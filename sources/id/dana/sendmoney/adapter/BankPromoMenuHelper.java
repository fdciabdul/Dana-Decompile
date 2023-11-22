package id.dana.sendmoney.adapter;

import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.SendMoneyScenarioModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0004\u001a\u0016\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u000b\u001a\u0016\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0004\u0012\u00020\u00030\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/adapter/BankPromoMenuHelper;", "Lid/dana/sendmoney/adapter/IBankPromoMenuHelper;", "", "Lid/dana/model/SendMoneyScenarioModel;", "p0", "", "getAuthRequestContext", "(Ljava/util/List;)I", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/base/BaseRecyclerViewAdapter;", "<init>", "(Lid/dana/base/BaseRecyclerViewAdapter;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankPromoMenuHelper implements IBankPromoMenuHelper {
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final BaseRecyclerViewAdapter<? extends BaseRecyclerViewHolder<SendMoneyScenarioModel>, SendMoneyScenarioModel> PlaceComponentResult;

    public BankPromoMenuHelper(BaseRecyclerViewAdapter<? extends BaseRecyclerViewHolder<SendMoneyScenarioModel>, SendMoneyScenarioModel> baseRecyclerViewAdapter) {
        Intrinsics.checkNotNullParameter(baseRecyclerViewAdapter, "");
        this.PlaceComponentResult = baseRecyclerViewAdapter;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public static int getAuthRequestContext(List<SendMoneyScenarioModel> p0) {
        List<SendMoneyScenarioModel> list = p0;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = p0.size();
        for (int i = 0; i < size; i++) {
            if (p0.get(i).MyBillsEntityDataFactory()) {
                return i;
            }
        }
        return -1;
    }
}
