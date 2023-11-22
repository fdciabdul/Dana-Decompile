package id.dana.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.HelpListView;

/* loaded from: classes4.dex */
public final class ViewHelpBottomSheetBinding implements ViewBinding {
    public final Button BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final HelpListView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final ImageView lookAheadTest;
    public final TextView scheduleImpl;

    private ViewHelpBottomSheetBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, HelpListView helpListView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = button;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout3;
        this.MyBillsEntityDataFactory = helpListView;
        this.getAuthRequestContext = imageView;
        this.lookAheadTest = imageView2;
        this.scheduleImpl = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
    }

    public static ViewHelpBottomSheetBinding PlaceComponentResult(View view) {
        int i = R.id.btnFinishHelp;
        Button button = (Button) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnFinishHelp);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3606clHeaderContent);
            if (constraintLayout2 != null) {
                HelpListView helpListView = (HelpListView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.enableMergePathsForKitKatAndAbove);
                if (helpListView != null) {
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivInfo);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rectGrey);
                        if (imageView2 != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDescriptionInfo);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.handleScrollChange);
                                if (textView2 != null) {
                                    return new ViewHelpBottomSheetBinding(constraintLayout, button, constraintLayout, constraintLayout2, helpListView, imageView, imageView2, textView, textView2);
                                }
                                i = R.id.handleScrollChange;
                            } else {
                                i = R.id.tvDescriptionInfo;
                            }
                        } else {
                            i = R.id.rectGrey;
                        }
                    } else {
                        i = R.id.ivInfo;
                    }
                } else {
                    i = R.id.enableMergePathsForKitKatAndAbove;
                }
            } else {
                i = R.id.f3606clHeaderContent;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
