package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes9.dex */
public final class ViewCustomEditTextMyBillsBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final EditText MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final ConstraintLayout lookAheadTest;
    public final AppCompatImageView scheduleImpl;

    private ViewCustomEditTextMyBillsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, EditText editText, ImageView imageView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, TextView textView, TextView textView2) {
        this.lookAheadTest = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.MyBillsEntityDataFactory = editText;
        this.PlaceComponentResult = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.scheduleImpl = appCompatImageView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.getErrorConfigVersion = textView2;
    }

    public static ViewCustomEditTextMyBillsBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_custom_edit_text_my_bills, (ViewGroup) null, false);
        int i = R.id.clCustomText;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.etCustomText;
            EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (editText != null) {
                i = R.id.ivClearText;
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (imageView != null) {
                    i = R.id.ivLeftImage;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.ivRightImage;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.ivSubtitleIcon;
                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (appCompatImageView3 != null) {
                                i = R.id.checkMarmotConfig_res_0x7f0a14a7;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView != null) {
                                    i = R.id.res_0x7f0a14a9_typetoken_typeset;
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView2 != null) {
                                        return new ViewCustomEditTextMyBillsBinding((ConstraintLayout) inflate, constraintLayout, editText, imageView, appCompatImageView, appCompatImageView2, appCompatImageView3, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
