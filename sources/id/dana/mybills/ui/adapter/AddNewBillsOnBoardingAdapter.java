package id.dana.mybills.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import id.dana.mybills.databinding.ItemAddNewBillsOnboardingBinding;
import id.dana.mybills.ui.model.MyBillsOnboardingContent;
import id.dana.mybills.ui.viewholder.AddNewBillsOnBoardingViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/mybills/ui/adapter/AddNewBillsOnBoardingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/mybills/ui/viewholder/AddNewBillsOnBoardingViewHolder;", "", "getItemCount", "()I", "", "Lid/dana/mybills/ui/model/MyBillsOnboardingContent;", "PlaceComponentResult", "Ljava/util/List;", "getAuthRequestContext", "Lkotlin/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "p0", "p1", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AddNewBillsOnBoardingAdapter extends RecyclerView.Adapter<AddNewBillsOnBoardingViewHolder> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<Integer, Unit> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private List<MyBillsOnboardingContent> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(AddNewBillsOnBoardingViewHolder addNewBillsOnBoardingViewHolder, int i) {
        AddNewBillsOnBoardingViewHolder addNewBillsOnBoardingViewHolder2 = addNewBillsOnBoardingViewHolder;
        Intrinsics.checkNotNullParameter(addNewBillsOnBoardingViewHolder2, "");
        MyBillsOnboardingContent myBillsOnboardingContent = this.getAuthRequestContext.get(i);
        if (myBillsOnboardingContent != null) {
            ItemAddNewBillsOnboardingBinding itemAddNewBillsOnboardingBinding = addNewBillsOnBoardingViewHolder2.BuiltInFictitiousFunctionClassFactory;
            itemAddNewBillsOnboardingBinding.KClassImpl$Data$declaredNonStaticMembers$2.setText(myBillsOnboardingContent.getSubTitle());
            itemAddNewBillsOnboardingBinding.PlaceComponentResult.setText(myBillsOnboardingContent.getDescription());
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(addNewBillsOnBoardingViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext()).getAuthRequestContext(Integer.valueOf(myBillsOnboardingContent.getImageRes())).MyBillsEntityDataFactory((ImageView) itemAddNewBillsOnboardingBinding.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ AddNewBillsOnBoardingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemAddNewBillsOnboardingBinding PlaceComponentResult = ItemAddNewBillsOnboardingBinding.PlaceComponentResult(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return new AddNewBillsOnBoardingViewHolder(PlaceComponentResult, new Function1<Integer, Unit>() { // from class: id.dana.mybills.ui.adapter.AddNewBillsOnBoardingAdapter$onCreateViewHolder$1
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
                Function1 function1;
                function1 = AddNewBillsOnBoardingAdapter.this.PlaceComponentResult;
                function1.invoke(Integer.valueOf(AddNewBillsOnBoardingAdapter.PlaceComponentResult(AddNewBillsOnBoardingAdapter.this, i2)));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AddNewBillsOnBoardingAdapter(List<MyBillsOnboardingContent> list, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = list;
        this.PlaceComponentResult = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.getAuthRequestContext.size();
    }

    public static final /* synthetic */ int PlaceComponentResult(AddNewBillsOnBoardingAdapter addNewBillsOnBoardingAdapter, int i) {
        return (i + 1) % addNewBillsOnBoardingAdapter.getAuthRequestContext.size();
    }
}
