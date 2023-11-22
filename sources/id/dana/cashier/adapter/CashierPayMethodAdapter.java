package id.dana.cashier.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.viewholder.AddNewCardViewHolder;
import id.dana.cashier.viewholder.DanaPlusViewHolder;
import id.dana.cashier.viewholder.GeneralPayMethodViewHolder;
import id.dana.cashier.viewholder.PayLaterViewHolder;
import id.dana.cashier.viewholder.PaylaterCicilViewHolder;
import id.dana.cashier.viewholder.ShimmerPayMethodViewHolder;
import id.dana.cashier.viewholder.SmartPayViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/adapter/CashierPayMethodAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/base/BaseActivity;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/BaseActivity;", "Lid/dana/cashier/adapter/CashierPayMethodListener;", "getAuthRequestContext", "Lid/dana/cashier/adapter/CashierPayMethodListener;", "MyBillsEntityDataFactory", "p1", "<init>", "(Lid/dana/base/BaseActivity;Lid/dana/cashier/adapter/CashierPayMethodListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayMethodAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<CashierPayMethodModel>, CashierPayMethodModel> {
    private final BaseActivity BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CashierPayMethodListener MyBillsEntityDataFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AddNewCardViewHolder addNewCardViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            addNewCardViewHolder = new AddNewCardViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.cashier.adapter.CashierPayMethodAdapter$onCreateViewHolder$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    CashierPayMethodListener cashierPayMethodListener;
                    CashierPayMethodModel item = CashierPayMethodAdapter.this.getItem(i2);
                    if (item != null) {
                        cashierPayMethodListener = CashierPayMethodAdapter.this.MyBillsEntityDataFactory;
                        cashierPayMethodListener.KClassImpl$Data$declaredNonStaticMembers$2(item);
                    }
                }
            });
        } else if (i == 2) {
            addNewCardViewHolder = new SmartPayViewHolder(viewGroup, new Function0<Unit>() { // from class: id.dana.cashier.adapter.CashierPayMethodAdapter$onCreateViewHolder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CashierPayMethodListener cashierPayMethodListener;
                    cashierPayMethodListener = CashierPayMethodAdapter.this.MyBillsEntityDataFactory;
                    cashierPayMethodListener.getAuthRequestContext();
                }
            });
        } else if (i == 5) {
            addNewCardViewHolder = new PayLaterViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.cashier.adapter.CashierPayMethodAdapter$onCreateViewHolder$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    CashierPayMethodListener cashierPayMethodListener;
                    CashierPayMethodModel item = CashierPayMethodAdapter.this.getItem(i2);
                    if (item != null) {
                        cashierPayMethodListener = CashierPayMethodAdapter.this.MyBillsEntityDataFactory;
                        cashierPayMethodListener.KClassImpl$Data$declaredNonStaticMembers$2(item);
                    }
                }
            });
        } else if (i == 6) {
            addNewCardViewHolder = new PaylaterCicilViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.cashier.adapter.CashierPayMethodAdapter$onCreateViewHolder$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    CashierPayMethodListener cashierPayMethodListener;
                    CashierPayMethodModel item = CashierPayMethodAdapter.this.getItem(i2);
                    if (item != null) {
                        cashierPayMethodListener = CashierPayMethodAdapter.this.MyBillsEntityDataFactory;
                        cashierPayMethodListener.KClassImpl$Data$declaredNonStaticMembers$2(item);
                    }
                }
            });
        } else if (i == 7) {
            addNewCardViewHolder = new DanaPlusViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.cashier.adapter.CashierPayMethodAdapter$onCreateViewHolder$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    CashierPayMethodListener cashierPayMethodListener;
                    CashierPayMethodModel item = CashierPayMethodAdapter.this.getItem(i2);
                    if (item != null) {
                        cashierPayMethodListener = CashierPayMethodAdapter.this.MyBillsEntityDataFactory;
                        cashierPayMethodListener.KClassImpl$Data$declaredNonStaticMembers$2(item);
                    }
                }
            });
        } else if (i == 99) {
            addNewCardViewHolder = new ShimmerPayMethodViewHolder(viewGroup);
        } else {
            addNewCardViewHolder = new GeneralPayMethodViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.cashier.adapter.CashierPayMethodAdapter$onCreateViewHolder$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    CashierPayMethodListener cashierPayMethodListener;
                    CashierPayMethodModel item = CashierPayMethodAdapter.this.getItem(i2);
                    if (item != null) {
                        cashierPayMethodListener = CashierPayMethodAdapter.this.MyBillsEntityDataFactory;
                        cashierPayMethodListener.KClassImpl$Data$declaredNonStaticMembers$2(item);
                    }
                }
            }, new Function2<Boolean, Integer, Unit>() { // from class: id.dana.cashier.adapter.CashierPayMethodAdapter$onCreateViewHolder$7
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                    invoke(bool.booleanValue(), num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z, int i2) {
                    CashierPayMethodListener cashierPayMethodListener;
                    CashierPayMethodModel item = CashierPayMethodAdapter.this.getItem(i2);
                    if (item != null) {
                        cashierPayMethodListener = CashierPayMethodAdapter.this.MyBillsEntityDataFactory;
                        cashierPayMethodListener.getAuthRequestContext(z, item);
                    }
                }
            });
        }
        return addNewCardViewHolder;
    }

    public CashierPayMethodAdapter(BaseActivity baseActivity, CashierPayMethodListener cashierPayMethodListener) {
        Intrinsics.checkNotNullParameter(baseActivity, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodListener, "");
        this.BuiltInFictitiousFunctionClassFactory = baseActivity;
        this.MyBillsEntityDataFactory = cashierPayMethodListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).getScheduleImpl();
    }
}
