package id.dana.sendmoney.ui.globalsend.form.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.sendmoney.databinding.ItemFundSourceBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.amount.FundSourceViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/adapter/FundSourceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemFundSourceBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "", "getItemCount", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "getAuthRequestContext", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class FundSourceAdapter extends RecyclerView.Adapter<BaseGlobalSendFormViewHolder<ItemFundSourceBinding, GlobalSendFormOptionModel>> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final List<GlobalSendFormOptionModel> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseGlobalSendFormViewHolder<ItemFundSourceBinding, GlobalSendFormOptionModel> baseGlobalSendFormViewHolder, int i) {
        BaseGlobalSendFormViewHolder<ItemFundSourceBinding, GlobalSendFormOptionModel> baseGlobalSendFormViewHolder2 = baseGlobalSendFormViewHolder;
        Intrinsics.checkNotNullParameter(baseGlobalSendFormViewHolder2, "");
        baseGlobalSendFormViewHolder2.getAuthRequestContext(this.getAuthRequestContext.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseGlobalSendFormViewHolder<ItemFundSourceBinding, GlobalSendFormOptionModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        FundSourceViewHolder.Companion companion = FundSourceViewHolder.INSTANCE;
        return new FundSourceViewHolder(FundSourceViewHolder.Companion.getAuthRequestContext(viewGroup), new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.FundSourceAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GlobalSendFormOptionModel globalSendFormOptionModel) {
                invoke2(globalSendFormOptionModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GlobalSendFormOptionModel globalSendFormOptionModel) {
                List list;
                List list2;
                Object obj;
                Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                list = FundSourceAdapter.this.getAuthRequestContext;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((GlobalSendFormOptionModel) it.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
                }
                list2 = FundSourceAdapter.this.getAuthRequestContext;
                Iterator it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (Intrinsics.areEqual((GlobalSendFormOptionModel) obj, globalSendFormOptionModel)) {
                        break;
                    }
                }
                GlobalSendFormOptionModel globalSendFormOptionModel2 = (GlobalSendFormOptionModel) obj;
                if (globalSendFormOptionModel2 != null) {
                    globalSendFormOptionModel2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
                FundSourceAdapter.this.notifyDataSetChanged();
            }
        });
    }

    public FundSourceAdapter(List<GlobalSendFormOptionModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.getAuthRequestContext.size();
    }
}
