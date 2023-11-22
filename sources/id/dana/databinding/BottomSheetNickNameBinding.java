package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetNickNameBinding implements ViewBinding {
    public final AppCompatButton BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final TextInputLayout PlaceComponentResult;
    public final TextInputEditText getAuthRequestContext;
    private final FrameLayout getErrorConfigVersion;

    private BottomSheetNickNameBinding(FrameLayout frameLayout, AppCompatButton appCompatButton, TextInputEditText textInputEditText, FrameLayout frameLayout2, TextInputLayout textInputLayout, AppCompatTextView appCompatTextView) {
        this.getErrorConfigVersion = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatButton;
        this.getAuthRequestContext = textInputEditText;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout2;
        this.PlaceComponentResult = textInputLayout;
        this.MyBillsEntityDataFactory = appCompatTextView;
    }

    public static BottomSheetNickNameBinding getAuthRequestContext(View view) {
        int i = R.id.btnPositive;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnPositive);
        if (appCompatButton != null) {
            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.etNickName);
            if (textInputEditText != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tilNickName);
                if (textInputLayout != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitle);
                    if (appCompatTextView != null) {
                        return new BottomSheetNickNameBinding(frameLayout, appCompatButton, textInputEditText, frameLayout, textInputLayout, appCompatTextView);
                    }
                    i = R.id.tvTitle;
                } else {
                    i = R.id.tilNickName;
                }
            } else {
                i = R.id.etNickName;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
