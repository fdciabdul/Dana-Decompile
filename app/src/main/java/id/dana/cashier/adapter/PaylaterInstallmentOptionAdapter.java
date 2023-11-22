package id.dana.cashier.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.cashier.model.RepaymentPlanModel;
import id.dana.cashier.viewholder.PaylaterInstallmentOptionViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/cashier/adapter/PaylaterInstallmentOptionAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/cashier/viewholder/PaylaterInstallmentOptionViewHolder;", "Lid/dana/cashier/model/RepaymentPlanModel;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/viewholder/PaylaterInstallmentOptionViewHolder;I)V", "", "getAuthRequestContext", "Z", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterInstallmentOptionAdapter extends BaseRecyclerViewAdapter<PaylaterInstallmentOptionViewHolder, RepaymentPlanModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Function1<? super RepaymentPlanModel, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory = true;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new PaylaterInstallmentOptionViewHolder(new Function1<RepaymentPlanModel, Unit>() { // from class: id.dana.cashier.adapter.PaylaterInstallmentOptionAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RepaymentPlanModel repaymentPlanModel) {
                invoke2(repaymentPlanModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RepaymentPlanModel repaymentPlanModel) {
                Intrinsics.checkNotNullParameter(repaymentPlanModel, "");
                Function1<? super RepaymentPlanModel, Unit> function1 = PaylaterInstallmentOptionAdapter.this.PlaceComponentResult;
                if (function1 != null) {
                    function1.invoke(repaymentPlanModel);
                }
            }
        }, viewGroup);
    }

    public PaylaterInstallmentOptionAdapter() {
        setItems(CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PaylaterInstallmentOptionViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onBindViewHolder((PaylaterInstallmentOptionAdapter) p0, p1);
        if (p1 == 0 && this.BuiltInFictitiousFunctionClassFactory) {
            p0.itemView.performClick();
            this.BuiltInFictitiousFunctionClassFactory = false;
        }
    }
}
