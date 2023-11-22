package id.dana.core.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.core.ui.R;
import id.dana.core.ui.adapter.NumpadAdapter;
import id.dana.core.ui.databinding.ItemNumpadBinding;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B)\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/core/ui/adapter/NumpadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/core/ui/adapter/NumpadAdapter$NumpadViewHolder;", "", "getItemCount", "()I", "", "", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "NumpadViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NumpadAdapter extends RecyclerView.Adapter<NumpadViewHolder> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<String, Unit> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final List<String> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(NumpadViewHolder numpadViewHolder, int i) {
        final NumpadViewHolder numpadViewHolder2 = numpadViewHolder;
        Intrinsics.checkNotNullParameter(numpadViewHolder2, "");
        final String str = this.BuiltInFictitiousFunctionClassFactory.get(i);
        Intrinsics.checkNotNullParameter(str, "");
        ItemNumpadBinding itemNumpadBinding = numpadViewHolder2.PlaceComponentResult;
        AppCompatImageView appCompatImageView = itemNumpadBinding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(Intrinsics.areEqual(str, "delete") ? 0 : 8);
        itemNumpadBinding.KClassImpl$Data$declaredNonStaticMembers$2.setIncludeFontPadding(!Intrinsics.areEqual(str, "delete"));
        if (!Intrinsics.areEqual(str, "delete")) {
            itemNumpadBinding.KClassImpl$Data$declaredNonStaticMembers$2.setText(str);
            TextView textView = itemNumpadBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = numpadViewHolder2.itemView.getContext().getString(R.string.res_0x7f13032e_kclassimpl_data_declarednonstaticmembers_2);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setContentDescription(format);
        } else {
            itemNumpadBinding.BuiltInFictitiousFunctionClassFactory.setContentDescription(numpadViewHolder2.itemView.getContext().getString(R.string.btn_backspace));
        }
        numpadViewHolder2.PlaceComponentResult.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.adapter.NumpadAdapter$NumpadViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NumpadAdapter.NumpadViewHolder.getAuthRequestContext(NumpadAdapter.NumpadViewHolder.this, str);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ NumpadViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemNumpadBinding PlaceComponentResult = ItemNumpadBinding.PlaceComponentResult(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return new NumpadViewHolder(this, PlaceComponentResult, this.MyBillsEntityDataFactory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NumpadAdapter(List<String> list, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.MyBillsEntityDataFactory = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/core/ui/adapter/NumpadAdapter$NumpadViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/core/ui/databinding/ItemNumpadBinding;", "PlaceComponentResult", "Lid/dana/core/ui/databinding/ItemNumpadBinding;", "Lkotlin/Function1;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/core/ui/adapter/NumpadAdapter;Lid/dana/core/ui/databinding/ItemNumpadBinding;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final class NumpadViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final Function1<String, Unit> MyBillsEntityDataFactory;
        final /* synthetic */ NumpadAdapter MyBillsEntityDataFactory;
        final ItemNumpadBinding PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public NumpadViewHolder(NumpadAdapter numpadAdapter, ItemNumpadBinding itemNumpadBinding, Function1<? super String, Unit> function1) {
            super(itemNumpadBinding.getAuthRequestContext);
            Intrinsics.checkNotNullParameter(itemNumpadBinding, "");
            Intrinsics.checkNotNullParameter(function1, "");
            this.MyBillsEntityDataFactory = numpadAdapter;
            this.PlaceComponentResult = itemNumpadBinding;
            this.MyBillsEntityDataFactory = function1;
        }

        public static /* synthetic */ void getAuthRequestContext(NumpadViewHolder numpadViewHolder, String str) {
            Intrinsics.checkNotNullParameter(numpadViewHolder, "");
            Intrinsics.checkNotNullParameter(str, "");
            numpadViewHolder.MyBillsEntityDataFactory.invoke(str);
        }
    }
}
