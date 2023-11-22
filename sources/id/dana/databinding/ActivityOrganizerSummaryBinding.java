package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.familyaccount.view.statusinformation.StatusInformationView;
import id.dana.familyaccount.view.summary.OrganizerSummaryX2BBodyView;
import id.dana.familyaccount.view.summary.OrganizerSummaryX2PBodyView;
import id.dana.familyaccount.view.summary.OrganizerSummaryX2XHeaderView;

/* loaded from: classes4.dex */
public final class ActivityOrganizerSummaryBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final ImageView DatabaseTableConfigUtil;
    private final ConstraintLayout FragmentBottomSheetPaymentSettingBinding;
    public final AppCompatImageView GetContactSyncConfig;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final LayoutToolbarBinding NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final OrganizerSummaryX2BBodyView NetworkUserEntityData$$ExternalSyntheticLambda4;
    public final OrganizerSummaryX2PBodyView NetworkUserEntityData$$ExternalSyntheticLambda5;
    public final StatusInformationView NetworkUserEntityData$$ExternalSyntheticLambda6;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda7;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final DanaButtonSecondaryView PlaceComponentResult;
    public final TextView PrepareContext;
    public final ConstraintLayout getAuthRequestContext;
    public final ConstraintLayout getErrorConfigVersion;
    public final MaterialCardView initRecordTimeStamp;
    public final OrganizerSummaryX2XHeaderView isLayoutRequested;
    public final ConstraintLayout lookAheadTest;
    public final MaterialCardView moveToNextValue;
    public final View newProxyInstance;
    public final ConstraintLayout scheduleImpl;

    private ActivityOrganizerSummaryBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, MaterialCardView materialCardView, MaterialCardView materialCardView2, View view, ImageView imageView, AppCompatImageView appCompatImageView, LayoutToolbarBinding layoutToolbarBinding, TextView textView, TextView textView2, TextView textView3, View view2, OrganizerSummaryX2XHeaderView organizerSummaryX2XHeaderView, StatusInformationView statusInformationView, OrganizerSummaryX2BBodyView organizerSummaryX2BBodyView, OrganizerSummaryX2PBodyView organizerSummaryX2PBodyView) {
        this.FragmentBottomSheetPaymentSettingBinding = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView;
        this.PlaceComponentResult = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.getAuthRequestContext = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintLayout5;
        this.scheduleImpl = constraintLayout6;
        this.lookAheadTest = constraintLayout7;
        this.getErrorConfigVersion = constraintLayout8;
        this.moveToNextValue = materialCardView;
        this.initRecordTimeStamp = materialCardView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view;
        this.DatabaseTableConfigUtil = imageView;
        this.GetContactSyncConfig = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = layoutToolbarBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = textView;
        this.PrepareContext = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = textView3;
        this.newProxyInstance = view2;
        this.isLayoutRequested = organizerSummaryX2XHeaderView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = statusInformationView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = organizerSummaryX2BBodyView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = organizerSummaryX2PBodyView;
    }

    public static ActivityOrganizerSummaryBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_organizer_summary, (ViewGroup) null, false);
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnApprove);
        int i = R.id.clX2XBody;
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnReject);
            if (danaButtonSecondaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clContainerPayLayout);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clErrorPayLayout);
                    if (constraintLayout2 != null) {
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clMainLayoutSummary);
                        if (constraintLayout3 != null) {
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clOrganizerSummary);
                            if (constraintLayout4 != null) {
                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clPayLayout);
                                if (constraintLayout5 != null) {
                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clScrollView);
                                    if (constraintLayout6 != null) {
                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clX2XBody);
                                        if (constraintLayout7 != null) {
                                            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cvOrganizerSummary);
                                            if (materialCardView != null) {
                                                MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cvPayLayout);
                                                if (materialCardView2 != null) {
                                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivBackground);
                                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                                        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivFamilyAccountPay);
                                                        if (imageView != null) {
                                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivWarningPayLayout);
                                                            if (appCompatImageView != null) {
                                                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                                                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                                                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorPayLayout);
                                                                    if (textView != null) {
                                                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvMoneyAmount);
                                                                        if (textView2 != null) {
                                                                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitleFamilyAccount);
                                                                            if (textView3 != null) {
                                                                                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSeparator);
                                                                                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                                                    OrganizerSummaryX2XHeaderView organizerSummaryX2XHeaderView = (OrganizerSummaryX2XHeaderView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSummaryHeader);
                                                                                    if (organizerSummaryX2XHeaderView != null) {
                                                                                        StatusInformationView statusInformationView = (StatusInformationView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSummaryStatusInformation);
                                                                                        if (statusInformationView != null) {
                                                                                            OrganizerSummaryX2BBodyView organizerSummaryX2BBodyView = (OrganizerSummaryX2BBodyView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewX2BBody);
                                                                                            if (organizerSummaryX2BBodyView != null) {
                                                                                                OrganizerSummaryX2PBodyView organizerSummaryX2PBodyView = (OrganizerSummaryX2PBodyView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewX2PBody);
                                                                                                if (organizerSummaryX2PBodyView != null) {
                                                                                                    return new ActivityOrganizerSummaryBinding((ConstraintLayout) inflate, danaButtonPrimaryView, danaButtonSecondaryView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, constraintLayout7, materialCardView, materialCardView2, BuiltInFictitiousFunctionClassFactory, imageView, appCompatImageView, MyBillsEntityDataFactory, textView, textView2, textView3, BuiltInFictitiousFunctionClassFactory3, organizerSummaryX2XHeaderView, statusInformationView, organizerSummaryX2BBodyView, organizerSummaryX2PBodyView);
                                                                                                }
                                                                                                i = R.id.viewX2PBody;
                                                                                            } else {
                                                                                                i = R.id.viewX2BBody;
                                                                                            }
                                                                                        } else {
                                                                                            i = R.id.viewSummaryStatusInformation;
                                                                                        }
                                                                                    } else {
                                                                                        i = R.id.viewSummaryHeader;
                                                                                    }
                                                                                } else {
                                                                                    i = R.id.viewSeparator;
                                                                                }
                                                                            } else {
                                                                                i = R.id.tvTitleFamilyAccount;
                                                                            }
                                                                        } else {
                                                                            i = R.id.tvMoneyAmount;
                                                                        }
                                                                    } else {
                                                                        i = R.id.tvErrorPayLayout;
                                                                    }
                                                                } else {
                                                                    i = R.id.layoutToolbar;
                                                                }
                                                            } else {
                                                                i = R.id.ivWarningPayLayout;
                                                            }
                                                        } else {
                                                            i = R.id.ivFamilyAccountPay;
                                                        }
                                                    } else {
                                                        i = R.id.ivBackground;
                                                    }
                                                } else {
                                                    i = R.id.cvPayLayout;
                                                }
                                            } else {
                                                i = R.id.cvOrganizerSummary;
                                            }
                                        }
                                    } else {
                                        i = R.id.clScrollView;
                                    }
                                } else {
                                    i = R.id.clPayLayout;
                                }
                            } else {
                                i = R.id.clOrganizerSummary;
                            }
                        } else {
                            i = R.id.clMainLayoutSummary;
                        }
                    } else {
                        i = R.id.clErrorPayLayout;
                    }
                } else {
                    i = R.id.clContainerPayLayout;
                }
            } else {
                i = R.id.btnReject;
            }
        } else {
            i = R.id.btnApprove;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }
}
