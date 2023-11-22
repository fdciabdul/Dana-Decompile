package id.dana.mybills.ui.customview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import id.dana.mybills.databinding.ItemDropdownOptionBinding;
import id.dana.mybills.ui.customview.DropdownOptionAdapter;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\u001b\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u000e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013"}, d2 = {"Lid/dana/mybills/ui/customview/DropdownOptionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/mybills/ui/customview/DropdownOptionAdapter$OptionViewHolder;", "", "getItemCount", "()I", "Ljava/util/ArrayList;", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "Lkotlin/collections/ArrayList;", "MyBillsEntityDataFactory", "Ljava/util/ArrayList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "getAuthRequestContext", "", "Z", "p0", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "OptionViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DropdownOptionAdapter extends RecyclerView.Adapter<OptionViewHolder> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    DropdownOptionsModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final ArrayList<DropdownOptionsModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<DropdownOptionsModel, Unit> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(OptionViewHolder optionViewHolder, int i) {
        Integer icon;
        OptionViewHolder optionViewHolder2 = optionViewHolder;
        Intrinsics.checkNotNullParameter(optionViewHolder2, "");
        DropdownOptionsModel dropdownOptionsModel = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        Intrinsics.checkNotNullExpressionValue(dropdownOptionsModel, "");
        final DropdownOptionsModel dropdownOptionsModel2 = dropdownOptionsModel;
        Intrinsics.checkNotNullParameter(dropdownOptionsModel2, "");
        ItemDropdownOptionBinding itemDropdownOptionBinding = optionViewHolder2.PlaceComponentResult;
        final DropdownOptionAdapter dropdownOptionAdapter = optionViewHolder2.KClassImpl$Data$declaredNonStaticMembers$2;
        itemDropdownOptionBinding.KClassImpl$Data$declaredNonStaticMembers$2.setText(dropdownOptionsModel2.getName());
        itemDropdownOptionBinding.PlaceComponentResult.setText(dropdownOptionsModel2.getValue());
        TextView textView = itemDropdownOptionBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(dropdownOptionAdapter.PlaceComponentResult ? 0 : 8);
        ImageView imageView = itemDropdownOptionBinding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(Intrinsics.areEqual(dropdownOptionsModel2, dropdownOptionAdapter.getAuthRequestContext) ^ true ? 4 : 0);
        if (dropdownOptionsModel2.getIcon() != null && ((icon = dropdownOptionsModel2.getIcon()) == null || icon.intValue() != 0)) {
            ImageView imageView2 = itemDropdownOptionBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(imageView2, "");
            imageView2.setVisibility(0);
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(itemDropdownOptionBinding.MyBillsEntityDataFactory.getContext()).getAuthRequestContext(dropdownOptionsModel2.getIcon()).MyBillsEntityDataFactory(itemDropdownOptionBinding.BuiltInFictitiousFunctionClassFactory);
        }
        itemDropdownOptionBinding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.DropdownOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DropdownOptionAdapter.OptionViewHolder.MyBillsEntityDataFactory(DropdownOptionAdapter.this, dropdownOptionsModel2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ OptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemDropdownOptionBinding authRequestContext = ItemDropdownOptionBinding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return new OptionViewHolder(this, authRequestContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DropdownOptionAdapter(Function1<? super DropdownOptionsModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = function1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();
        this.PlaceComponentResult = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/customview/DropdownOptionAdapter$OptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/mybills/databinding/ItemDropdownOptionBinding;", "PlaceComponentResult", "Lid/dana/mybills/databinding/ItemDropdownOptionBinding;", "p0", "<init>", "(Lid/dana/mybills/ui/customview/DropdownOptionAdapter;Lid/dana/mybills/databinding/ItemDropdownOptionBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public final class OptionViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ DropdownOptionAdapter KClassImpl$Data$declaredNonStaticMembers$2;
        final ItemDropdownOptionBinding PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OptionViewHolder(DropdownOptionAdapter dropdownOptionAdapter, ItemDropdownOptionBinding itemDropdownOptionBinding) {
            super(itemDropdownOptionBinding.MyBillsEntityDataFactory);
            Intrinsics.checkNotNullParameter(itemDropdownOptionBinding, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dropdownOptionAdapter;
            this.PlaceComponentResult = itemDropdownOptionBinding;
        }

        public static /* synthetic */ void MyBillsEntityDataFactory(DropdownOptionAdapter dropdownOptionAdapter, DropdownOptionsModel dropdownOptionsModel) {
            Intrinsics.checkNotNullParameter(dropdownOptionAdapter, "");
            Intrinsics.checkNotNullParameter(dropdownOptionsModel, "");
            dropdownOptionAdapter.MyBillsEntityDataFactory.invoke(dropdownOptionsModel);
        }
    }
}
