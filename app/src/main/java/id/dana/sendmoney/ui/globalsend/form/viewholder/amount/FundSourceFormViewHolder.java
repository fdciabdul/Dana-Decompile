package id.dana.sendmoney.ui.globalsend.form.viewholder.amount;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.sendmoney.databinding.ItemFundSourceFormBinding;
import id.dana.sendmoney.ui.globalsend.form.adapter.FundSourceAdapter;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.amount.FundSourceFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/amount/FundSourceFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemFundSourceFormBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "<init>", "(Lid/dana/sendmoney/databinding/ItemFundSourceFormBinding;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class FundSourceFormViewHolder extends BaseGlobalSendFormViewHolder<ItemFundSourceFormBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        GlobalSendFormModel globalSendFormModel2 = globalSendFormModel;
        Intrinsics.checkNotNullParameter(globalSendFormModel2, "");
        FundSourceFormModel fundSourceFormModel = globalSendFormModel2 instanceof FundSourceFormModel ? (FundSourceFormModel) globalSendFormModel2 : null;
        if (fundSourceFormModel != null) {
            RecyclerView recyclerView = ((ItemFundSourceFormBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory;
            recyclerView.setAdapter(new FundSourceAdapter(fundSourceFormModel.getAuthRequestContext));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FundSourceFormViewHolder(ItemFundSourceFormBinding itemFundSourceFormBinding) {
        super(itemFundSourceFormBinding);
        Intrinsics.checkNotNullParameter(itemFundSourceFormBinding, "");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/amount/FundSourceFormViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemFundSourceFormBinding;", "PlaceComponentResult", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemFundSourceFormBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemFundSourceFormBinding PlaceComponentResult(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemFundSourceFormBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemFundSourceFormBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
