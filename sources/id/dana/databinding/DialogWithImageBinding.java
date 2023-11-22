package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class DialogWithImageBinding implements ViewBinding {
    public final Button BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final Button MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    private final FrameLayout moveToNextValue;

    private DialogWithImageBinding(FrameLayout frameLayout, Button button, Button button2, FrameLayout frameLayout2, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        this.moveToNextValue = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = button;
        this.MyBillsEntityDataFactory = button2;
        this.getAuthRequestContext = frameLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.getErrorConfigVersion = textView2;
    }

    public static DialogWithImageBinding PlaceComponentResult(View view) {
        int i = R.id.btn_negative;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_negative);
        if (button != null) {
            Button button2 = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_positive);
            if (button2 != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.constrainLayout);
                if (constraintLayout != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.secondaryHash_res_0x7f0a08d3);
                    if (appCompatImageView != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_description);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                            if (textView2 != null) {
                                return new DialogWithImageBinding(frameLayout, button, button2, frameLayout, constraintLayout, appCompatImageView, textView, textView2);
                            }
                            i = R.id.tv_title;
                        } else {
                            i = R.id.tv_description;
                        }
                    } else {
                        i = R.id.secondaryHash_res_0x7f0a08d3;
                    }
                } else {
                    i = R.id.constrainLayout;
                }
            } else {
                i = R.id.btn_positive;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
