package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ItemGeneralPayMethodBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView DatabaseTableConfigUtil;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatCheckBox getAuthRequestContext;
    public final AppCompatImageView getErrorConfigVersion;
    public final AppCompatTextView initRecordTimeStamp;
    public final ConstraintLayout lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final RadioButton scheduleImpl;

    private ItemGeneralPayMethodBinding(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, View view, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, RadioButton radioButton, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        this.lookAheadTest = constraintLayout;
        this.getAuthRequestContext = appCompatCheckBox;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.PlaceComponentResult = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView2;
        this.getErrorConfigVersion = appCompatImageView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = linearLayout;
        this.scheduleImpl = radioButton;
        this.moveToNextValue = appCompatTextView;
        this.initRecordTimeStamp = appCompatTextView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = appCompatTextView3;
        this.DatabaseTableConfigUtil = appCompatTextView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = appCompatTextView5;
    }

    public static ItemGeneralPayMethodBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.cbBalanceMixPay;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cbBalanceMixPay);
        if (appCompatCheckBox != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIconAsset);
                if (appCompatImageView != null) {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivIconExpressPay);
                    if (appCompatImageView2 != null) {
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.NavGraphBuilder);
                        if (appCompatImageView3 != null) {
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llPayMethodContent);
                            if (linearLayout != null) {
                                RadioButton radioButton = (RadioButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rgPaymentMethod);
                                if (radioButton != null) {
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAccountNumber);
                                    if (appCompatTextView != null) {
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAccountSource);
                                        if (appCompatTextView2 != null) {
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDescDisable);
                                            if (appCompatTextView3 != null) {
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNew);
                                                if (appCompatTextView4 != null) {
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ObservableRefCount);
                                                    if (appCompatTextView5 != null) {
                                                        return new ItemGeneralPayMethodBinding(constraintLayout, appCompatCheckBox, BuiltInFictitiousFunctionClassFactory, constraintLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayout, radioButton, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5);
                                                    }
                                                    i = R.id.ObservableRefCount;
                                                } else {
                                                    i = R.id.tvNew;
                                                }
                                            } else {
                                                i = R.id.tvDescDisable;
                                            }
                                        } else {
                                            i = R.id.tvAccountSource;
                                        }
                                    } else {
                                        i = R.id.tvAccountNumber;
                                    }
                                } else {
                                    i = R.id.rgPaymentMethod;
                                }
                            } else {
                                i = R.id.llPayMethodContent;
                            }
                        } else {
                            i = R.id.NavGraphBuilder;
                        }
                    } else {
                        i = R.id.ivIconExpressPay;
                    }
                } else {
                    i = R.id.ivIconAsset;
                }
            } else {
                i = R.id.divider;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
