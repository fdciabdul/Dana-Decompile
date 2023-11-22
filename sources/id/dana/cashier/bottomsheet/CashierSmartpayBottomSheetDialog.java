package id.dana.cashier.bottomsheet;

import android.app.Dialog;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.BottomSheetCashierSmartpayBinding;
import id.dana.usereducation.adapter.HelpListAdapter;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.utils.NoUnderlineClickableSpan;
import id.dana.utils.UrlUtil;
import id.dana.webview.WebViewActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B#\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000e"}, d2 = {"Lid/dana/cashier/bottomsheet/CashierSmartpayBottomSheetDialog;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BottomSheetCashierSmartpayBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "p0", "p1", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierSmartpayBottomSheetDialog extends BaseViewBindingBottomSheetDialogFragment<BottomSheetCashierSmartpayBinding> {
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function0<Unit> getAuthRequestContext;
    public Map<Integer, View> PlaceComponentResult;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.clear();
    }

    public CashierSmartpayBottomSheetDialog(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        this.PlaceComponentResult = new LinkedHashMap();
        this.getAuthRequestContext = function0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function02;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetCashierSmartpayBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetCashierSmartpayBinding BuiltInFictitiousFunctionClassFactory = BottomSheetCashierSmartpayBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            TextView textView = ((BottomSheetCashierSmartpayBinding) vb).lookAheadTest;
            String string = getString(R.string.smartpay_tnc);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = getString(R.string.smartpay_tnc_highlighted);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String str = string;
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
            int length = string2.length() + indexOf$default;
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new NoUnderlineClickableSpan(requireContext(), WebViewActivity.ContentBuilder(requireContext(), getString(R.string.tnc), UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION))), indexOf$default, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.f22912131099753)), indexOf$default, length, 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            String string3 = getString(R.string.smartpay_info_title_1);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            String string4 = getString(R.string.smartpay_info_desc_1);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            String string5 = getString(R.string.smartpay_info_title_2);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            String string6 = getString(R.string.smartpay_info_desc_2);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            String string7 = getString(R.string.smartpay_info_title_3);
            Intrinsics.checkNotNullExpressionValue(string7, "");
            String string8 = getString(R.string.smartpay_info_desc_3);
            Intrinsics.checkNotNullExpressionValue(string8, "");
            HelpListAdapter helpListAdapter = new HelpListAdapter(CollectionsKt.mutableListOf(new ContentOnBoardingModel((int) R.drawable.ic_autorouting_general_choose_method, string3, string4), new ContentOnBoardingModel((int) R.drawable.ic_autorouting_change_pay_method, string5, string6), new ContentOnBoardingModel((int) R.drawable.ic_autorouting_dana_protection, string7, string8)));
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((BottomSheetCashierSmartpayBinding) vb2).BuiltInFictitiousFunctionClassFactory.setAdapter(helpListAdapter);
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ((BottomSheetCashierSmartpayBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.bottomsheet.CashierSmartpayBottomSheetDialog$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CashierSmartpayBottomSheetDialog.PlaceComponentResult(CashierSmartpayBottomSheetDialog.this);
                        }
                    });
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        ((BottomSheetCashierSmartpayBinding) vb4).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.bottomsheet.CashierSmartpayBottomSheetDialog$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CashierSmartpayBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(CashierSmartpayBottomSheetDialog.this);
                            }
                        });
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
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
        }
    }

    public static /* synthetic */ void PlaceComponentResult(CashierSmartpayBottomSheetDialog cashierSmartpayBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(cashierSmartpayBottomSheetDialog, "");
        cashierSmartpayBottomSheetDialog.getAuthRequestContext.invoke();
        cashierSmartpayBottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierSmartpayBottomSheetDialog cashierSmartpayBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(cashierSmartpayBottomSheetDialog, "");
        cashierSmartpayBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
        cashierSmartpayBottomSheetDialog.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetCashierSmartpayBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
