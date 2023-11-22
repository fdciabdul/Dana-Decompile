package id.dana.sendmoney.ui.globalsend.form.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.SimpleFormOptionViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\tR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendFormOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/SimpleFormOptionViewHolder;", "", "getItemCount", "()I", "", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "getAuthRequestContext", "Ljava/util/List;", "PlaceComponentResult", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendFormOptionAdapter extends RecyclerView.Adapter<SimpleFormOptionViewHolder> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<GlobalSendFormOptionModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<GlobalSendFormOptionModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<GlobalSendFormOptionModel> PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(SimpleFormOptionViewHolder simpleFormOptionViewHolder, int i) {
        SimpleFormOptionViewHolder simpleFormOptionViewHolder2 = simpleFormOptionViewHolder;
        Intrinsics.checkNotNullParameter(simpleFormOptionViewHolder2, "");
        simpleFormOptionViewHolder2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ SimpleFormOptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        SimpleFormOptionViewHolder.Companion companion = SimpleFormOptionViewHolder.INSTANCE;
        return new SimpleFormOptionViewHolder(SimpleFormOptionViewHolder.Companion.KClassImpl$Data$declaredNonStaticMembers$2(viewGroup), new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendFormOptionAdapter$onCreateViewHolder$1
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
                Function1 function1;
                Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                list = GlobalSendFormOptionAdapter.this.BuiltInFictitiousFunctionClassFactory;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((GlobalSendFormOptionModel) it.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
                }
                list2 = GlobalSendFormOptionAdapter.this.BuiltInFictitiousFunctionClassFactory;
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
                function1 = GlobalSendFormOptionAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                function1.invoke(globalSendFormOptionModel);
                GlobalSendFormOptionAdapter.this.notifyDataSetChanged();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalSendFormOptionAdapter(List<GlobalSendFormOptionModel> list, Function1<? super GlobalSendFormOptionModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.PlaceComponentResult = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.size();
    }
}
