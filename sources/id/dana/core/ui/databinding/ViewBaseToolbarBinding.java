package id.dana.core.ui.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.core.ui.R;

/* loaded from: classes4.dex */
public final class ViewBaseToolbarBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final Toolbar DatabaseTableConfigUtil;
    public final ConstraintLayout GetContactSyncConfig;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final RelativeLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatImageView getErrorConfigVersion;
    private final ConstraintLayout initRecordTimeStamp;
    public final ImageView lookAheadTest;
    public final TextView moveToNextValue;
    public final RelativeLayout scheduleImpl;

    private ViewBaseToolbarBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ImageView imageView, TextView textView, RelativeLayout relativeLayout, AppCompatImageView appCompatImageView5, RelativeLayout relativeLayout2, Toolbar toolbar, ConstraintLayout constraintLayout2, TextView textView2) {
        this.initRecordTimeStamp = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView3;
        this.getAuthRequestContext = appCompatImageView4;
        this.lookAheadTest = imageView;
        this.moveToNextValue = textView;
        this.scheduleImpl = relativeLayout;
        this.getErrorConfigVersion = appCompatImageView5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = relativeLayout2;
        this.DatabaseTableConfigUtil = toolbar;
        this.GetContactSyncConfig = constraintLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView2;
    }

    public static ViewBaseToolbarBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.lookAheadTest;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (frameLayout != null) {
            i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda1;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatImageView != null) {
                i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda2;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (appCompatImageView3 != null) {
                        i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda4;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (appCompatImageView4 != null) {
                            i = R.id.NetworkUserEntityData$$ExternalSyntheticLambda5;
                            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (imageView != null) {
                                i = R.id.SubSequence;
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                if (textView != null) {
                                    i = R.id.A;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                    if (relativeLayout != null) {
                                        i = R.id.I;
                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                        if (appCompatImageView5 != null) {
                                            i = R.id.H;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                            if (relativeLayout2 != null) {
                                                i = R.id.K;
                                                Toolbar toolbar = (Toolbar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                                if (toolbar != null) {
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                    i = R.id.getNameOrBuilderList;
                                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                                    if (textView2 != null) {
                                                        return new ViewBaseToolbarBinding(constraintLayout, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, imageView, textView, relativeLayout, appCompatImageView5, relativeLayout2, toolbar, constraintLayout, textView2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.initRecordTimeStamp;
    }
}
