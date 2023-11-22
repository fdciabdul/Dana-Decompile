package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.edittextcomponent.DanaEditTextView;

/* loaded from: classes4.dex */
public final class ViewBottomSheetRenameBankAccountBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextInputLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final DanaEditTextView getAuthRequestContext;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;

    private ViewBottomSheetRenameBankAccountBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaEditTextView danaEditTextView, TextInputLayout textInputLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.getAuthRequestContext = danaEditTextView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textInputLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.moveToNextValue = textView;
        this.lookAheadTest = textView2;
    }

    public static ViewBottomSheetRenameBankAccountBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.btnRenameBankAccount;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnRenameBankAccount);
        if (danaButtonPrimaryView != null) {
            DanaEditTextView danaEditTextView = (DanaEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.detChangeName);
            if (danaEditTextView != null) {
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.detNormal);
                if (textInputLayout != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivCloseSheetRename);
                    if (appCompatImageView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDesc);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                            if (textView2 != null) {
                                return new ViewBottomSheetRenameBankAccountBinding((ConstraintLayout) view, danaButtonPrimaryView, danaEditTextView, textInputLayout, appCompatImageView, textView, textView2);
                            }
                            i = R.id.tvTitle;
                        } else {
                            i = R.id.tvDesc;
                        }
                    } else {
                        i = R.id.ivCloseSheetRename;
                    }
                } else {
                    i = R.id.detNormal;
                }
            } else {
                i = R.id.detChangeName;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
