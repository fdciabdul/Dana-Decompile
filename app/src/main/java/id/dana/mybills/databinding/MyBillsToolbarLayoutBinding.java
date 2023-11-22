package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.mybills.R;

/* loaded from: classes2.dex */
public final class MyBillsToolbarLayoutBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout DatabaseTableConfigUtil;
    private final ConstraintLayout GetContactSyncConfig;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final RelativeLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final TextView lookAheadTest;
    public final RelativeLayout moveToNextValue;
    public final Toolbar scheduleImpl;

    private MyBillsToolbarLayoutBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, TextView textView, RelativeLayout relativeLayout, TextView textView2, RelativeLayout relativeLayout2, Toolbar toolbar, ConstraintLayout constraintLayout2, TextView textView3) {
        this.GetContactSyncConfig = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.getAuthRequestContext = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.MyBillsEntityDataFactory = appCompatImageView3;
        this.PlaceComponentResult = appCompatImageView4;
        this.lookAheadTest = textView;
        this.moveToNextValue = relativeLayout;
        this.getErrorConfigVersion = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = relativeLayout2;
        this.scheduleImpl = toolbar;
        this.DatabaseTableConfigUtil = constraintLayout2;
        this.initRecordTimeStamp = textView3;
    }

    public static MyBillsToolbarLayoutBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.FillAnimation;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
        if (frameLayout != null) {
            i = R.id.m;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
            if (appCompatImageView != null) {
                i = R.id.access$throwIllegalArgumentType;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.setNetAuthId;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                    if (appCompatImageView3 != null) {
                        i = R.id.getCardNumberOCR;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                        if (appCompatImageView4 != null) {
                            i = R.id.FlowableCreate$BufferAsyncEmitter;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                            if (textView != null) {
                                i = R.id.getIndexName;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                if (relativeLayout != null) {
                                    i = R.id.access$setShowcaseShowing$p;
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                    if (textView2 != null) {
                                        i = R.id.CYFMonitor$ChallengeActionCallback;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                        if (relativeLayout2 != null) {
                                            i = R.id.isInfoWindowShown;
                                            Toolbar toolbar = (Toolbar) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                            if (toolbar != null) {
                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                i = R.id.SecuritySettingsActivity$createPinLauncher$2$1;
                                                TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, i);
                                                if (textView3 != null) {
                                                    return new MyBillsToolbarLayoutBinding(constraintLayout, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, textView, relativeLayout, textView2, relativeLayout2, toolbar, constraintLayout, textView3);
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

    public static MyBillsToolbarLayoutBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        return KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater.inflate(R.layout.res_0x7f0d03ff_networkuserentitydata_externalsyntheticlambda8, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}
