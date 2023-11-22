package id.dana.mybills.ui.viewholder;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.mybills.databinding.ItemAddNewBillsOnboardingBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/viewholder/AddNewBillsOnBoardingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/mybills/databinding/ItemAddNewBillsOnboardingBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/databinding/ItemAddNewBillsOnboardingBinding;", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Lid/dana/mybills/databinding/ItemAddNewBillsOnboardingBinding;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AddNewBillsOnBoardingViewHolder extends RecyclerView.ViewHolder {
    public final ItemAddNewBillsOnboardingBinding BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddNewBillsOnBoardingViewHolder(ItemAddNewBillsOnboardingBinding itemAddNewBillsOnboardingBinding, final Function1<? super Integer, Unit> function1) {
        super(itemAddNewBillsOnboardingBinding.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullParameter(itemAddNewBillsOnboardingBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = itemAddNewBillsOnboardingBinding;
        AppCompatImageView appCompatImageView = itemAddNewBillsOnboardingBinding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.mybills.ui.viewholder.AddNewBillsOnBoardingViewHolder$special$$inlined$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.removeOnLayoutChangeListener(this);
                Function1.this.invoke(Integer.valueOf(this.getAbsoluteAdapterPosition()));
            }
        });
    }
}
