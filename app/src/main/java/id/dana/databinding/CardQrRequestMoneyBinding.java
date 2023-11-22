package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.richview.QRView;
import id.dana.richview.socialshare.SocialShareView;

/* loaded from: classes4.dex */
public final class CardQrRequestMoneyBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final SocialShareView GetContactSyncConfig;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final FloatingActionButton MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda7;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final Group PlaceComponentResult;
    private final MaterialCardView PrepareContext;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final AppCompatImageView getErrorConfigVersion;
    public final QRView initRecordTimeStamp;
    public final TextView isLayoutRequested;
    public final AppCompatImageView lookAheadTest;
    public final AppCompatImageView moveToNextValue;
    public final TextView newProxyInstance;
    public final AppCompatImageView scheduleImpl;

    private CardQrRequestMoneyBinding(MaterialCardView materialCardView, FloatingActionButton floatingActionButton, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, QRView qRView, SocialShareView socialShareView, TextView textView, AppCompatTextView appCompatTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, AppCompatTextView appCompatTextView2) {
        this.PrepareContext = materialCardView;
        this.MyBillsEntityDataFactory = floatingActionButton;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.PlaceComponentResult = group;
        this.lookAheadTest = appCompatImageView;
        this.getErrorConfigVersion = appCompatImageView2;
        this.scheduleImpl = appCompatImageView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView4;
        this.moveToNextValue = appCompatImageView5;
        this.initRecordTimeStamp = qRView;
        this.GetContactSyncConfig = socialShareView;
        this.DatabaseTableConfigUtil = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = appCompatTextView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView2;
        this.newProxyInstance = textView3;
        this.isLayoutRequested = textView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = textView5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = appCompatTextView2;
    }

    public static CardQrRequestMoneyBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.card_qr_request_money, viewGroup, false);
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnDelete);
        int i = R.id.ivAmountBg;
        if (floatingActionButton != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnRefreshQr);
            if (danaButtonPrimaryView != null) {
                DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnSetAmount);
                if (danaButtonSecondaryView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clAmountRemarks);
                    if (constraintLayout != null) {
                        Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.groupAmountRemarks);
                        if (group != null) {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivAmountBg);
                            if (appCompatImageView != null) {
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivBg);
                                if (appCompatImageView2 != null) {
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.addOnSelectionChangedListener);
                                    if (appCompatImageView3 != null) {
                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.requiresTunnel);
                                        if (appCompatImageView4 != null) {
                                            AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_qris_supported);
                                            if (appCompatImageView5 != null) {
                                                QRView qRView = (QRView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.qrView);
                                                if (qRView != null) {
                                                    SocialShareView socialShareView = (SocialShareView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ssvRequestMoney);
                                                    if (socialShareView != null) {
                                                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvAmount);
                                                        if (textView != null) {
                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.res_0x7f0a13c0_fontscontractcompat_fontrequestcallback);
                                                            if (appCompatTextView != null) {
                                                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvCardName);
                                                                if (textView2 != null) {
                                                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4246tvCardNumber);
                                                                    if (textView3 != null) {
                                                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvExpiryMessage);
                                                                        if (textView4 != null) {
                                                                            TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvRemarks);
                                                                            if (textView5 != null) {
                                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvShareLinkRequestMoney);
                                                                                if (appCompatTextView2 != null) {
                                                                                    return new CardQrRequestMoneyBinding((MaterialCardView) inflate, floatingActionButton, danaButtonPrimaryView, danaButtonSecondaryView, constraintLayout, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, qRView, socialShareView, textView, appCompatTextView, textView2, textView3, textView4, textView5, appCompatTextView2);
                                                                                }
                                                                                i = R.id.tvShareLinkRequestMoney;
                                                                            } else {
                                                                                i = R.id.tvRemarks;
                                                                            }
                                                                        } else {
                                                                            i = R.id.tvExpiryMessage;
                                                                        }
                                                                    } else {
                                                                        i = R.id.f4246tvCardNumber;
                                                                    }
                                                                } else {
                                                                    i = R.id.tvCardName;
                                                                }
                                                            } else {
                                                                i = R.id.res_0x7f0a13c0_fontscontractcompat_fontrequestcallback;
                                                            }
                                                        } else {
                                                            i = R.id.tvAmount;
                                                        }
                                                    } else {
                                                        i = R.id.ssvRequestMoney;
                                                    }
                                                } else {
                                                    i = R.id.qrView;
                                                }
                                            } else {
                                                i = R.id.iv_qris_supported;
                                            }
                                        } else {
                                            i = R.id.requiresTunnel;
                                        }
                                    } else {
                                        i = R.id.addOnSelectionChangedListener;
                                    }
                                } else {
                                    i = R.id.ivBg;
                                }
                            }
                        } else {
                            i = R.id.groupAmountRemarks;
                        }
                    } else {
                        i = R.id.clAmountRemarks;
                    }
                } else {
                    i = R.id.btnSetAmount;
                }
            } else {
                i = R.id.btnRefreshQr;
            }
        } else {
            i = R.id.btnDelete;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PrepareContext;
    }
}
