package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ViewDanapolyLapCountBinding implements ViewBinding {
    public final Guideline BuiltInFictitiousFunctionClassFactory;
    private final MotionLayout GetContactSyncConfig;
    public final Guideline KClassImpl$Data$declaredNonStaticMembers$2;
    public final Guideline MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Guideline PlaceComponentResult;
    public final Guideline getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final MotionLayout moveToNextValue;
    public final Guideline scheduleImpl;

    private ViewDanapolyLapCountBinding(MotionLayout motionLayout, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, AppCompatImageView appCompatImageView, MotionLayout motionLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.GetContactSyncConfig = motionLayout;
        this.getAuthRequestContext = guideline;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = guideline2;
        this.MyBillsEntityDataFactory = guideline3;
        this.BuiltInFictitiousFunctionClassFactory = guideline4;
        this.PlaceComponentResult = guideline5;
        this.scheduleImpl = guideline6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView;
        this.moveToNextValue = motionLayout2;
        this.getErrorConfigVersion = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
    }

    public static ViewDanapolyLapCountBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_danapoly_lap_count, (ViewGroup) null, false);
        int i = R.id.QrExpiredActivity_res_0x7f0a0818;
        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (guideline != null) {
            i = R.id.guideBottomLaps;
            Guideline guideline2 = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (guideline2 != null) {
                i = R.id.guideEnd;
                Guideline guideline3 = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (guideline3 != null) {
                    i = R.id.guideStart;
                    Guideline guideline4 = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (guideline4 != null) {
                        i = R.id.TypeProjectionImpl_res_0x7f0a081c;
                        Guideline guideline5 = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (guideline5 != null) {
                            i = R.id.guideTopLaps;
                            Guideline guideline6 = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (guideline6 != null) {
                                i = R.id.TypefaceCompatApi26Impl_res_0x7f0a09e5;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (appCompatImageView != null) {
                                    MotionLayout motionLayout = (MotionLayout) inflate;
                                    i = R.id.isTmpDetached_res_0x7f0a14af;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (appCompatTextView != null) {
                                        i = R.id.storeUserConfig_res_0x7f0a14b0;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (appCompatTextView2 != null) {
                                            return new ViewDanapolyLapCountBinding(motionLayout, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, appCompatImageView, motionLayout, appCompatTextView, appCompatTextView2);
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
        return this.GetContactSyncConfig;
    }
}
