package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewOrganizerSummaryX2bBodyBinding implements ViewBinding {
    public final Guideline BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final TextView GetContactSyncConfig;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda7;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewOrganizerSummaryX2bBodyBinding(ConstraintLayout constraintLayout, Guideline guideline, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = guideline;
        this.getAuthRequestContext = textView;
        this.MyBillsEntityDataFactory = textView2;
        this.PlaceComponentResult = textView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView4;
        this.scheduleImpl = textView5;
        this.moveToNextValue = textView6;
        this.lookAheadTest = textView7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView8;
        this.getErrorConfigVersion = textView9;
        this.GetContactSyncConfig = textView10;
        this.DatabaseTableConfigUtil = textView11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView12;
        this.initRecordTimeStamp = textView13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = view;
    }

    public static ViewOrganizerSummaryX2bBodyBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_organizer_summary_x2b_body, (ViewGroup) null, false);
        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.gCenter);
        int i = R.id.cl_card_dana_goal_balance;
        if (guideline != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvAmount);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_card_dana_goal_balance);
                if (textView2 != null) {
                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.getScrimAlpha);
                    if (textView3 != null) {
                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvHeaderTransactionDetail);
                        if (textView4 != null) {
                            TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.FriendListPresenter_Factory);
                            if (textView5 != null) {
                                TextView textView6 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvNoteTitle);
                                if (textView6 != null) {
                                    TextView textView7 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvReceiver);
                                    if (textView7 != null) {
                                        TextView textView8 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvReceiverTitle);
                                        if (textView8 != null) {
                                            TextView textView9 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSender);
                                            if (textView9 != null) {
                                                TextView textView10 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSenderTitle);
                                                if (textView10 != null) {
                                                    TextView textView11 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTotal);
                                                    if (textView11 != null) {
                                                        TextView textView12 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTotalTitle);
                                                        if (textView12 != null) {
                                                            TextView textView13 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTransferFee);
                                                            if (textView13 != null) {
                                                                TextView textView14 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTransferFeeTitle);
                                                                if (textView14 != null) {
                                                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewSeparator);
                                                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                                                        return new ViewOrganizerSummaryX2bBodyBinding((ConstraintLayout) inflate, guideline, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, BuiltInFictitiousFunctionClassFactory);
                                                                    }
                                                                    i = R.id.viewSeparator;
                                                                } else {
                                                                    i = R.id.tvTransferFeeTitle;
                                                                }
                                                            } else {
                                                                i = R.id.tvTransferFee;
                                                            }
                                                        } else {
                                                            i = R.id.tvTotalTitle;
                                                        }
                                                    } else {
                                                        i = R.id.tvTotal;
                                                    }
                                                } else {
                                                    i = R.id.tvSenderTitle;
                                                }
                                            } else {
                                                i = R.id.tvSender;
                                            }
                                        } else {
                                            i = R.id.tvReceiverTitle;
                                        }
                                    } else {
                                        i = R.id.tvReceiver;
                                    }
                                } else {
                                    i = R.id.tvNoteTitle;
                                }
                            } else {
                                i = R.id.FriendListPresenter_Factory;
                            }
                        } else {
                            i = R.id.tvHeaderTransactionDetail;
                        }
                    } else {
                        i = R.id.getScrimAlpha;
                    }
                }
            } else {
                i = R.id.tvAmount;
            }
        } else {
            i = R.id.gCenter;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
    }
}
