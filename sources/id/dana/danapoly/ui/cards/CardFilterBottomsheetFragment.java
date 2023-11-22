package id.dana.danapoly.ui.cards;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.BottomSheetCardFilterBinding;
import id.dana.danapoly.ui.enums.CardFilterUiType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\"\u0012\u0019\u0010\u0012\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u000f¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bR)\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u000f¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\t0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011"}, d2 = {"Lid/dana/danapoly/ui/cards/CardFilterBottomsheetFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/danapoly/databinding/BottomSheetCardFilterBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Lkotlin/Function1;", "Lid/dana/danapoly/ui/enums/CardFilterUiType;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "p0", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardFilterBottomsheetFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetCardFilterBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super CardFilterUiType, Unit> MyBillsEntityDataFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetCardFilterBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetCardFilterBinding KClassImpl$Data$declaredNonStaticMembers$2 = BottomSheetCardFilterBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public CardFilterBottomsheetFragment(Function1<? super CardFilterUiType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.MyBillsEntityDataFactory = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetCardFilterBinding) vb).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardFilterBottomsheetFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CardFilterBottomsheetFragment.MyBillsEntityDataFactory(CardFilterBottomsheetFragment.this);
                }
            });
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((BottomSheetCardFilterBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardFilterBottomsheetFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CardFilterBottomsheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(CardFilterBottomsheetFragment.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
            BottomSheetBehavior<View> o_ = o_();
            if (o_ != null) {
                o_.setDraggable(false);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View view = getView();
            if (view != null) {
                view.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(view, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CardFilterBottomsheetFragment cardFilterBottomsheetFragment) {
        Intrinsics.checkNotNullParameter(cardFilterBottomsheetFragment, "");
        cardFilterBottomsheetFragment.dismiss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CardFilterBottomsheetFragment cardFilterBottomsheetFragment) {
        CardFilterUiType cardFilterUiType;
        Intrinsics.checkNotNullParameter(cardFilterBottomsheetFragment, "");
        VB vb = cardFilterBottomsheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            int checkedRadioButtonId = ((BottomSheetCardFilterBinding) vb).getErrorConfigVersion.getCheckedRadioButtonId();
            if (checkedRadioButtonId == R.id.WrappedDrawableState_res_0x7f0a101e) {
                cardFilterUiType = CardFilterUiType.IN_PROGRESS;
            } else {
                cardFilterUiType = checkedRadioButtonId == R.id.getRawPath_res_0x7f0a101c ? CardFilterUiType.DONE : CardFilterUiType.ALL;
            }
            cardFilterBottomsheetFragment.MyBillsEntityDataFactory.invoke(cardFilterUiType);
            cardFilterBottomsheetFragment.dismiss();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetCardFilterBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
