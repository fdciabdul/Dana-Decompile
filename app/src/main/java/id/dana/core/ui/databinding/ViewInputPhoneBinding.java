package id.dana.core.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewInputPhoneBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final EditText getAuthRequestContext;
    public final TextView lookAheadTest;
    public final View moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private ViewInputPhoneBinding(ConstraintLayout constraintLayout, EditText editText, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, FrameLayout frameLayout, TextView textView, View view, AppCompatTextView appCompatTextView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.getAuthRequestContext = editText;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.PlaceComponentResult = linearLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.lookAheadTest = textView;
        this.moveToNextValue = view;
        this.scheduleImpl = appCompatTextView;
    }

    public static ViewInputPhoneBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.res_0x7f0d057d_networkuserentitydata_externalsyntheticlambda1, (ViewGroup) null, false);
        int i = R.id.DatabaseTableConfigUtil;
        EditText editText = (EditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (editText != null) {
            i = R.id.isLayoutRequested_res_0x7f0a0b28;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (appCompatImageView != null) {
                i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda6;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatImageView2 != null) {
                    i = R.id.ll_prefix;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (linearLayout != null) {
                        i = R.id.phone_wrapper;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (frameLayout != null) {
                            i = R.id.prefix;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.AppCompatEmojiTextHelper))) != null) {
                                i = R.id.tv_middle_number;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatTextView != null) {
                                    return new ViewInputPhoneBinding((ConstraintLayout) inflate, editText, appCompatImageView, appCompatImageView2, linearLayout, frameLayout, textView, BuiltInFictitiousFunctionClassFactory, appCompatTextView);
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
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
