package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;

/* loaded from: classes4.dex */
public final class ActivityFamilyTncConsentBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout GetContactSyncConfig;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatCheckBox MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final LinearLayout PlaceComponentResult;
    public final NestedScrollView getAuthRequestContext;
    public final LinearLayout getErrorConfigVersion;
    public final StatusInformationView lookAheadTest;
    public final WebView moveToNextValue;
    public final TextView scheduleImpl;

    private ActivityFamilyTncConsentBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatCheckBox appCompatCheckBox, LayoutToolbarBinding layoutToolbarBinding, LinearLayout linearLayout, NestedScrollView nestedScrollView, TextView textView, StatusInformationView statusInformationView, View view, LinearLayout linearLayout2, WebView webView) {
        this.GetContactSyncConfig = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.MyBillsEntityDataFactory = appCompatCheckBox;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.PlaceComponentResult = linearLayout;
        this.getAuthRequestContext = nestedScrollView;
        this.scheduleImpl = textView;
        this.lookAheadTest = statusInformationView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.getErrorConfigVersion = linearLayout2;
        this.moveToNextValue = webView;
    }

    public static ActivityFamilyTncConsentBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_family_tnc_consent, (ViewGroup) null, false);
        int i = R.id.btnSendInvitation;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnSendInvitation);
        if (danaButtonPrimaryView != null) {
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cbFamilyTnc);
            if (appCompatCheckBox != null) {
                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llFamilyTncAgreement);
                    if (linearLayout != null) {
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.nestedViewTnc);
                        if (nestedScrollView != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvFamilyTncTitle);
                            if (textView != null) {
                                StatusInformationView statusInformationView = (StatusInformationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewErrorAgreement);
                                if (statusInformationView != null) {
                                    View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSkeleton);
                                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewTncContainer);
                                        if (linearLayout2 != null) {
                                            WebView webView = (WebView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.wvFamilyTnc);
                                            if (webView != null) {
                                                return new ActivityFamilyTncConsentBinding((ConstraintLayout) inflate, danaButtonPrimaryView, appCompatCheckBox, MyBillsEntityDataFactory, linearLayout, nestedScrollView, textView, statusInformationView, BuiltInFictitiousFunctionClassFactory2, linearLayout2, webView);
                                            }
                                            i = R.id.wvFamilyTnc;
                                        } else {
                                            i = R.id.viewTncContainer;
                                        }
                                    } else {
                                        i = R.id.viewSkeleton;
                                    }
                                } else {
                                    i = R.id.viewErrorAgreement;
                                }
                            } else {
                                i = R.id.tvFamilyTncTitle;
                            }
                        } else {
                            i = R.id.nestedViewTnc;
                        }
                    } else {
                        i = R.id.llFamilyTncAgreement;
                    }
                } else {
                    i = R.id.layoutToolbar;
                }
            } else {
                i = R.id.cbFamilyTnc;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.GetContactSyncConfig;
    }
}
