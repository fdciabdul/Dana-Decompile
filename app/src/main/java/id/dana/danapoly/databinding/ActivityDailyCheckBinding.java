package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.databinding.ViewBaseToolbarBinding;
import id.dana.danapoly.R;
import id.dana.danapoly.ui.board.view.DanapolyPromptInfoView;

/* loaded from: classes4.dex */
public final class ActivityDailyCheckBinding implements ViewBinding {
    public final DanapolyPromptInfoView BuiltInFictitiousFunctionClassFactory;
    public final ViewBaseToolbarBinding DatabaseTableConfigUtil;
    public final TextView GetContactSyncConfig;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final Group NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final Barrier PlaceComponentResult;
    public final FrameLayout getAuthRequestContext;
    public final AppCompatImageView getErrorConfigVersion;
    public final AppCompatTextView initRecordTimeStamp;
    public final NestedScrollView lookAheadTest;
    public final RecyclerView moveToNextValue;
    private final ConstraintLayout newProxyInstance;
    public final AppCompatImageView scheduleImpl;

    private ActivityDailyCheckBinding(ConstraintLayout constraintLayout, Barrier barrier, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout2, DanapolyPromptInfoView danapolyPromptInfoView, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, NestedScrollView nestedScrollView, ViewBaseToolbarBinding viewBaseToolbarBinding, TextView textView, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView) {
        this.newProxyInstance = constraintLayout;
        this.PlaceComponentResult = barrier;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = danapolyPromptInfoView;
        this.getAuthRequestContext = frameLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = group;
        this.scheduleImpl = appCompatImageView;
        this.getErrorConfigVersion = appCompatImageView2;
        this.moveToNextValue = recyclerView;
        this.lookAheadTest = nestedScrollView;
        this.DatabaseTableConfigUtil = viewBaseToolbarBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView2;
        this.GetContactSyncConfig = textView3;
        this.initRecordTimeStamp = appCompatTextView;
    }

    public static ActivityDailyCheckBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.activity_daily_check, (ViewGroup) null, false);
        int i = R.id.MyBillsEntityDataFactory_res_0x7f0a00c7;
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (barrier != null) {
            i = R.id.btn_check_in;
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (danaButtonSecondaryView != null) {
                i = R.id.cl_total_point;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (constraintLayout != null) {
                    i = R.id.dailyCheckPrompt;
                    DanapolyPromptInfoView danapolyPromptInfoView = (DanapolyPromptInfoView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (danapolyPromptInfoView != null) {
                        i = R.id.fl_button;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (frameLayout != null) {
                            i = R.id.groupSuccessState;
                            Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (group != null) {
                                i = R.id.iv_background;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatImageView != null) {
                                    i = R.id.ivErrorIcon;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (appCompatImageView2 != null) {
                                        i = R.id.res_0x7f0a1149_securitysettingsactivity_createpinlauncher_2_1;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (recyclerView != null) {
                                            i = R.id.InvestmentWalletAdapter_res_0x7f0a12a7;
                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (nestedScrollView != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.toolbar_danapoly))) != null) {
                                                ViewBaseToolbarBinding MyBillsEntityDataFactory = ViewBaseToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                                                i = R.id.tv_description_total_point;
                                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                if (textView != null) {
                                                    i = R.id.createJavaMethod_res_0x7f0a1461;
                                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                    if (textView2 != null) {
                                                        i = R.id.checkParameterIsNotNull;
                                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_total_point;
                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                                            if (appCompatTextView != null) {
                                                                return new ActivityDailyCheckBinding((ConstraintLayout) inflate, barrier, danaButtonSecondaryView, constraintLayout, danapolyPromptInfoView, frameLayout, group, appCompatImageView, appCompatImageView2, recyclerView, nestedScrollView, MyBillsEntityDataFactory, textView, textView2, textView3, appCompatTextView);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.newProxyInstance;
    }
}
