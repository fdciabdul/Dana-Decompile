package id.dana.cashier.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.viewholder.CashierAddOnPriorityViewHolder;
import id.dana.cashier.viewholder.CashierAddOnViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001BM\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b\u0012*\u0010\u0012\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R&\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR8\u0010\u0010\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/cashier/adapter/CashierAddOnAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/cashier/model/CashierOrderGoodModel;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function2;", "", "", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function2;", "MyBillsEntityDataFactory", "Lkotlin/Function5;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function5;", "p1", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<CashierOrderGoodModel>, CashierOrderGoodModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function2<String, Boolean, Unit> MyBillsEntityDataFactory;
    private final Function5<String, String, String, Boolean, String, Unit> PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        CashierAddOnViewHolder cashierAddOnViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 2) {
            cashierAddOnViewHolder = new CashierAddOnPriorityViewHolder(this.MyBillsEntityDataFactory, this.PlaceComponentResult, viewGroup);
        } else {
            cashierAddOnViewHolder = new CashierAddOnViewHolder(this.MyBillsEntityDataFactory, this.PlaceComponentResult, viewGroup);
        }
        return cashierAddOnViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CashierAddOnAdapter(Function2<? super String, ? super Boolean, Unit> function2, Function5<? super String, ? super String, ? super String, ? super Boolean, ? super String, Unit> function5) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(function5, "");
        this.MyBillsEntityDataFactory = function2;
        this.PlaceComponentResult = function5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).newProxyInstance;
    }
}
