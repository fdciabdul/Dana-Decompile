package id.dana.bank.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import id.dana.bank.viewholder.BankListViewHolder;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemAllBankListBinding;
import id.dana.sendmoney.model.BankModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000e"}, d2 = {"Lid/dana/bank/adapter/BankListAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/sendmoney/model/BankModel;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "", "p2", "PlaceComponentResult", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lkotlin/Function2;", "", "Lkotlin/jvm/functions/Function2;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankListAdapter extends BaseRecyclerViewDiffUtilAdapter<BankModel, BaseViewBindingViewHolder<BankModel>> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Function2<? super BankModel, ? super Integer, Unit> BuiltInFictitiousFunctionClassFactory = new Function2<BankModel, Integer, Unit>() { // from class: id.dana.bank.adapter.BankListAdapter$onItemClicked$1
        public final void invoke(BankModel bankModel, int i) {
            Intrinsics.checkNotNullParameter(bankModel, "");
        }

        @Override // kotlin.jvm.functions.Function2
        public final /* synthetic */ Unit invoke(BankModel bankModel, Integer num) {
            invoke(bankModel, num.intValue());
            return Unit.INSTANCE;
        }
    };

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final BaseViewBindingViewHolder<BankModel> PlaceComponentResult(LayoutInflater p0, ViewGroup p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ItemAllBankListBinding MyBillsEntityDataFactory = ItemAllBankListBinding.MyBillsEntityDataFactory(LayoutInflater.from(p1.getContext()), p1);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return new BankListViewHolder(MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
    }
}
