package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.pushverify.view.richview.PushVerifyChallengeInfoView;

/* loaded from: classes4.dex */
public final class LayoutPushVerifyChallengeBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    private final ConstraintLayout GetContactSyncConfig;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final PushVerifyChallengeInfoView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final ConstraintLayout PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final ShapeableImageView getErrorConfigVersion;
    public final PushVerifyChallengeInfoView initRecordTimeStamp;
    public final PushVerifyChallengeInfoView lookAheadTest;
    public final LinearLayout moveToNextValue;
    public final ShapeableImageView scheduleImpl;

    private LayoutPushVerifyChallengeBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, LinearLayout linearLayout, PushVerifyChallengeInfoView pushVerifyChallengeInfoView, PushVerifyChallengeInfoView pushVerifyChallengeInfoView2, PushVerifyChallengeInfoView pushVerifyChallengeInfoView3, TextView textView, TextView textView2, AppCompatTextView appCompatTextView) {
        this.GetContactSyncConfig = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.PlaceComponentResult = constraintLayout2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.scheduleImpl = shapeableImageView;
        this.getErrorConfigVersion = shapeableImageView2;
        this.moveToNextValue = linearLayout;
        this.lookAheadTest = pushVerifyChallengeInfoView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = pushVerifyChallengeInfoView2;
        this.initRecordTimeStamp = pushVerifyChallengeInfoView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView;
        this.DatabaseTableConfigUtil = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = appCompatTextView;
    }

    public static LayoutPushVerifyChallengeBinding PlaceComponentResult(View view) {
        int i = R.id.f3507btn_allow;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3507btn_allow);
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_reject);
            if (danaButtonSecondaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_bottom);
                if (constraintLayout != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_banner_agreement);
                    if (appCompatImageView != null) {
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_binding_dots);
                        if (appCompatImageView2 != null) {
                            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_dana_logo);
                            if (shapeableImageView != null) {
                                ShapeableImageView shapeableImageView2 = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3916iv_merchant_logo);
                                if (shapeableImageView2 != null) {
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ll_dana_protection);
                                    if (linearLayout != null) {
                                        PushVerifyChallengeInfoView pushVerifyChallengeInfoView = (PushVerifyChallengeInfoView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.push_verify_device_model);
                                        if (pushVerifyChallengeInfoView != null) {
                                            PushVerifyChallengeInfoView pushVerifyChallengeInfoView2 = (PushVerifyChallengeInfoView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.push_verify_expiry_time);
                                            if (pushVerifyChallengeInfoView2 != null) {
                                                PushVerifyChallengeInfoView pushVerifyChallengeInfoView3 = (PushVerifyChallengeInfoView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.push_verify_request_time);
                                                if (pushVerifyChallengeInfoView3 != null) {
                                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_dana_protection);
                                                    if (textView != null) {
                                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_push_verify_title);
                                                        if (textView2 != null) {
                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.MissingMainCoroutineDispatcher);
                                                            if (appCompatTextView != null) {
                                                                return new LayoutPushVerifyChallengeBinding((ConstraintLayout) view, danaButtonPrimaryView, danaButtonSecondaryView, constraintLayout, appCompatImageView, appCompatImageView2, shapeableImageView, shapeableImageView2, linearLayout, pushVerifyChallengeInfoView, pushVerifyChallengeInfoView2, pushVerifyChallengeInfoView3, textView, textView2, appCompatTextView);
                                                            }
                                                            i = R.id.MissingMainCoroutineDispatcher;
                                                        } else {
                                                            i = R.id.tv_push_verify_title;
                                                        }
                                                    } else {
                                                        i = R.id.tv_dana_protection;
                                                    }
                                                } else {
                                                    i = R.id.push_verify_request_time;
                                                }
                                            } else {
                                                i = R.id.push_verify_expiry_time;
                                            }
                                        } else {
                                            i = R.id.push_verify_device_model;
                                        }
                                    } else {
                                        i = R.id.ll_dana_protection;
                                    }
                                } else {
                                    i = R.id.f3916iv_merchant_logo;
                                }
                            } else {
                                i = R.id.iv_dana_logo;
                            }
                        } else {
                            i = R.id.iv_binding_dots;
                        }
                    } else {
                        i = R.id.iv_banner_agreement;
                    }
                } else {
                    i = R.id.cl_bottom;
                }
            } else {
                i = R.id.btn_reject;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}
