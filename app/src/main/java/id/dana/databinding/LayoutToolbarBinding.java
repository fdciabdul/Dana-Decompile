package id.dana.databinding;

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
import id.dana.R;

/* loaded from: classes2.dex */
public final class LayoutToolbarBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout DatabaseTableConfigUtil;
    private final ConstraintLayout GetContactSyncConfig;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Toolbar NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final RelativeLayout lookAheadTest;
    public final ImageView moveToNextValue;
    public final RelativeLayout scheduleImpl;

    private LayoutToolbarBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ImageView imageView, TextView textView, RelativeLayout relativeLayout, TextView textView2, RelativeLayout relativeLayout2, Toolbar toolbar, ConstraintLayout constraintLayout2, TextView textView3) {
        this.GetContactSyncConfig = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.getAuthRequestContext = appCompatImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView3;
        this.PlaceComponentResult = appCompatImageView4;
        this.moveToNextValue = imageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.lookAheadTest = relativeLayout;
        this.getErrorConfigVersion = textView2;
        this.scheduleImpl = relativeLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = toolbar;
        this.DatabaseTableConfigUtil = constraintLayout2;
        this.initRecordTimeStamp = textView3;
    }

    public static LayoutToolbarBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.fl_notification;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fl_notification);
        if (frameLayout != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_image);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ic_image_fg);
                if (appCompatImageView2 != null) {
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_left_button);
                    if (appCompatImageView3 != null) {
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_setting);
                        if (appCompatImageView4 != null) {
                            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_title_image);
                            if (imageView != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.left_button);
                                if (textView != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.loader_wrapper);
                                    if (relativeLayout != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.right_button);
                                        if (textView2 != null) {
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rl_toolbar);
                                            if (relativeLayout2 != null) {
                                                Toolbar toolbar = (Toolbar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.toolbar);
                                                if (toolbar != null) {
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.toolbar_title);
                                                    if (textView3 != null) {
                                                        return new LayoutToolbarBinding(constraintLayout, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, imageView, textView, relativeLayout, textView2, relativeLayout2, toolbar, constraintLayout, textView3);
                                                    }
                                                    i = R.id.toolbar_title;
                                                } else {
                                                    i = R.id.toolbar;
                                                }
                                            } else {
                                                i = R.id.rl_toolbar;
                                            }
                                        } else {
                                            i = R.id.right_button;
                                        }
                                    } else {
                                        i = R.id.loader_wrapper;
                                    }
                                } else {
                                    i = R.id.left_button;
                                }
                            } else {
                                i = R.id.iv_title_image;
                            }
                        } else {
                            i = R.id.iv_setting;
                        }
                    } else {
                        i = R.id.iv_left_button;
                    }
                } else {
                    i = R.id.ic_image_fg;
                }
            } else {
                i = R.id.ic_image;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}
