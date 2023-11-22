package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ActivityDanaVizPromptBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView GetContactSyncConfig;
    public final LottieAnimationView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Guideline MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatButton PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    private final ConstraintLayout initRecordTimeStamp;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatImageView moveToNextValue;
    public final LayoutToolbarBinding scheduleImpl;

    private ActivityDanaVizPromptBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, AppCompatButton appCompatButton, Guideline guideline, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LayoutToolbarBinding layoutToolbarBinding, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.initRecordTimeStamp = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.PlaceComponentResult = appCompatButton;
        this.MyBillsEntityDataFactory = guideline;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lottieAnimationView;
        this.getAuthRequestContext = appCompatImageView;
        this.moveToNextValue = appCompatImageView2;
        this.scheduleImpl = layoutToolbarBinding;
        this.getErrorConfigVersion = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView3;
        this.GetContactSyncConfig = appCompatTextView4;
    }

    public static ActivityDanaVizPromptBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_dana_viz_prompt, (ViewGroup) null, false);
        int i = R.id.btn_dana_viz;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_dana_viz);
        if (danaButtonSecondaryView != null) {
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_skip);
            if (appCompatButton != null) {
                Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.guideline_center);
                if (guideline != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_dana_viz);
                    if (lottieAnimationView != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_logo_bi);
                        if (appCompatImageView != null) {
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_logo_kominfo);
                            if (appCompatImageView2 != null) {
                                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbar);
                                if (BuiltInFictitiousFunctionClassFactory != null) {
                                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_desc);
                                    if (appCompatTextView != null) {
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_subtitle);
                                        if (appCompatTextView2 != null) {
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title);
                                            if (appCompatTextView3 != null) {
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.MissingMainCoroutineDispatcher);
                                                if (appCompatTextView4 != null) {
                                                    return new ActivityDanaVizPromptBinding((ConstraintLayout) inflate, danaButtonSecondaryView, appCompatButton, guideline, lottieAnimationView, appCompatImageView, appCompatImageView2, MyBillsEntityDataFactory, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                                }
                                                i = R.id.MissingMainCoroutineDispatcher;
                                            } else {
                                                i = R.id.tv_title;
                                            }
                                        } else {
                                            i = R.id.tv_subtitle;
                                        }
                                    } else {
                                        i = R.id.tv_desc;
                                    }
                                } else {
                                    i = R.id.toolbar;
                                }
                            } else {
                                i = R.id.iv_logo_kominfo;
                            }
                        } else {
                            i = R.id.iv_logo_bi;
                        }
                    } else {
                        i = R.id.iv_dana_viz;
                    }
                } else {
                    i = R.id.guideline_center;
                }
            } else {
                i = R.id.btn_skip;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.initRecordTimeStamp;
    }
}
