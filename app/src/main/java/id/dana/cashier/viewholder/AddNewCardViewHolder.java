package id.dana.cashier.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.databinding.ItemCashierAddNewCardBinding;
import id.dana.extension.view.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/viewholder/AddNewCardViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/databinding/ItemCashierAddNewCardBinding;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddNewCardViewHolder extends ViewBindingRecyclerViewHolder<CashierPayMethodModel, ItemCashierAddNewCardBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        Drawable PlaceComponentResult;
        CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
        if (cashierPayMethodModel != null) {
            ItemCashierAddNewCardBinding binding = getBinding();
            boolean z = false;
            boolean z2 = CashierPayMethodModelKt.GetContactSyncConfig(cashierPayMethodModel) && !cashierPayMethodModel.getBuiltInFictitiousFunctionClassFactory();
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setText(getContext().getString(R.string.debit_or_credit_card));
            binding.lookAheadTest.setText(getContext().getString(R.string.add_new_card));
            AppCompatImageView appCompatImageView = binding.BuiltInFictitiousFunctionClassFactory;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_chip_add_new_card);
            } else {
                appCompatImageView.setImageResource(R.drawable.ic_chip_add_new_card);
            }
            AppCompatImageView appCompatImageView2 = binding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            AppCompatImageView appCompatImageView3 = appCompatImageView2;
            if (z2) {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView3);
            } else {
                ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView3);
            }
            binding.MyBillsEntityDataFactory.setClickable((z2 || cashierPayMethodModel.getNetworkUserEntityData$$ExternalSyntheticLambda0()) ? false : true);
            RadioButton radioButton = binding.getAuthRequestContext;
            if (!z2 && !cashierPayMethodModel.getNetworkUserEntityData$$ExternalSyntheticLambda0()) {
                z = true;
            }
            radioButton.setClickable(z);
            boolean networkUserEntityData$$ExternalSyntheticLambda0 = cashierPayMethodModel.getNetworkUserEntityData$$ExternalSyntheticLambda0();
            if (z2) {
                PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_general_radio_disabled);
            } else if (!z2 && !networkUserEntityData$$ExternalSyntheticLambda0) {
                PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_button_radio_unselected);
            } else {
                PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_button_radio_active);
            }
            radioButton.setButtonDrawable(PlaceComponentResult);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemCashierAddNewCardBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemCashierAddNewCardBinding BuiltInFictitiousFunctionClassFactory = ItemCashierAddNewCardBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AddNewCardViewHolder(android.view.ViewGroup r3, final kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559066(0x7f0d029a, float:1.8743466E38)
            r2.<init>(r1, r0, r3)
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemCashierAddNewCardBinding r3 = (id.dana.databinding.ItemCashierAddNewCardBinding) r3
            androidx.constraintlayout.widget.ConstraintLayout r3 = r3.MyBillsEntityDataFactory
            id.dana.cashier.viewholder.AddNewCardViewHolder$$ExternalSyntheticLambda0 r0 = new id.dana.cashier.viewholder.AddNewCardViewHolder$$ExternalSyntheticLambda0
            r0.<init>()
            r3.setOnClickListener(r0)
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemCashierAddNewCardBinding r3 = (id.dana.databinding.ItemCashierAddNewCardBinding) r3
            android.widget.RadioButton r3 = r3.getAuthRequestContext
            id.dana.cashier.viewholder.AddNewCardViewHolder$$ExternalSyntheticLambda1 r0 = new id.dana.cashier.viewholder.AddNewCardViewHolder$$ExternalSyntheticLambda1
            r0.<init>()
            r3.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.AddNewCardViewHolder.<init>(android.view.ViewGroup, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Function1 function1, AddNewCardViewHolder addNewCardViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(addNewCardViewHolder, "");
        function1.invoke(Integer.valueOf(addNewCardViewHolder.getAbsoluteAdapterPosition()));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, AddNewCardViewHolder addNewCardViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(addNewCardViewHolder, "");
        function1.invoke(Integer.valueOf(addNewCardViewHolder.getAbsoluteAdapterPosition()));
    }
}
