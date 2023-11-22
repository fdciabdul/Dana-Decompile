package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewProfileSettingChatbotBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final TextView lookAheadTest;

    private ViewProfileSettingChatbotBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout3;
        this.MyBillsEntityDataFactory = imageView;
        this.getAuthRequestContext = imageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView;
        this.lookAheadTest = textView2;
    }

    public static ViewProfileSettingChatbotBinding getAuthRequestContext(View view) {
        int i = R.id.cl_chatbot;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_chatbot);
        if (constraintLayout != null) {
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.CustomPopMenuExtension);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_chatbot);
                if (imageView2 != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_subtitle);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title);
                        if (textView2 != null) {
                            return new ViewProfileSettingChatbotBinding(constraintLayout2, constraintLayout, constraintLayout2, imageView, imageView2, textView, textView2);
                        }
                        i = R.id.tv_title;
                    } else {
                        i = R.id.tv_subtitle;
                    }
                } else {
                    i = R.id.iv_chatbot;
                }
            } else {
                i = R.id.CustomPopMenuExtension;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
