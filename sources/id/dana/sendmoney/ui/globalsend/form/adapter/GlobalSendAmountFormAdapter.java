package id.dana.sendmoney.ui.globalsend.form.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.amount.TransactionPurposeFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.DropdownFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.EmptyFormViewHolder;
import id.dana.sendmoney.ui.globalsend.form.viewholder.amount.FundSourceFormViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendAmountFormAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "Landroidx/fragment/app/FragmentManager;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/FragmentManager;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "Ljava/util/List;", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class GlobalSendAmountFormAdapter extends RecyclerView.Adapter<BaseGlobalSendFormViewHolder<?, GlobalSendFormModel>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FragmentManager KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<GlobalSendFormModel> PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseGlobalSendFormViewHolder<?, GlobalSendFormModel> baseGlobalSendFormViewHolder, int i) {
        BaseGlobalSendFormViewHolder<?, GlobalSendFormModel> baseGlobalSendFormViewHolder2 = baseGlobalSendFormViewHolder;
        Intrinsics.checkNotNullParameter(baseGlobalSendFormViewHolder2, "");
        baseGlobalSendFormViewHolder2.getAuthRequestContext(this.PlaceComponentResult.get(i));
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder<?, id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel>] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseGlobalSendFormViewHolder<?, GlobalSendFormModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            FundSourceFormViewHolder.Companion companion = FundSourceFormViewHolder.INSTANCE;
            viewHolder = (BaseGlobalSendFormViewHolder) new FundSourceFormViewHolder(FundSourceFormViewHolder.Companion.PlaceComponentResult(viewGroup));
        } else if (i == 1) {
            DropdownFormViewHolder.Companion companion2 = DropdownFormViewHolder.INSTANCE;
            viewHolder = (BaseGlobalSendFormViewHolder) new DropdownFormViewHolder(DropdownFormViewHolder.Companion.PlaceComponentResult(viewGroup), 1, this.KClassImpl$Data$declaredNonStaticMembers$2, new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendAmountFormAdapter$onCreateViewHolder$1
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
                    Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                    GlobalSendAmountFormAdapter.PlaceComponentResult(GlobalSendAmountFormAdapter.this, globalSendFormOptionModel);
                    GlobalSendAmountFormAdapter.this.notifyDataSetChanged();
                }
            });
        } else {
            EmptyFormViewHolder.Companion companion3 = EmptyFormViewHolder.INSTANCE;
            viewHolder = (BaseGlobalSendFormViewHolder) new EmptyFormViewHolder(EmptyFormViewHolder.Companion.PlaceComponentResult(viewGroup));
        }
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.PlaceComponentResult.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return this.PlaceComponentResult.get(p0).PlaceComponentResult;
    }

    public static final /* synthetic */ void PlaceComponentResult(GlobalSendAmountFormAdapter globalSendAmountFormAdapter, GlobalSendFormOptionModel globalSendFormOptionModel) {
        Object obj;
        Object obj2;
        Iterator<T> it = globalSendAmountFormAdapter.PlaceComponentResult.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((GlobalSendFormModel) obj2) instanceof TransactionPurposeFormModel) {
                break;
            }
        }
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.ui.globalsend.form.model.form.amount.TransactionPurposeFormModel");
        }
        List<GlobalSendFormOptionModel> list = ((TransactionPurposeFormModel) obj2).KClassImpl$Data$declaredNonStaticMembers$2;
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            ((GlobalSendFormOptionModel) it2.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next = it3.next();
            if (Intrinsics.areEqual((GlobalSendFormOptionModel) next, globalSendFormOptionModel)) {
                obj = next;
                break;
            }
        }
        GlobalSendFormOptionModel globalSendFormOptionModel2 = (GlobalSendFormOptionModel) obj;
        if (globalSendFormOptionModel2 != null) {
            globalSendFormOptionModel2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
    }
}
