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
public final class ViewOrganizerSummaryX2pBodyBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout DatabaseTableConfigUtil;
    public final TextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView PlaceComponentResult;
    public final Guideline getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final TextView scheduleImpl;

    private ViewOrganizerSummaryX2pBodyBinding(ConstraintLayout constraintLayout, Guideline guideline, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.DatabaseTableConfigUtil = constraintLayout;
        this.getAuthRequestContext = guideline;
        this.MyBillsEntityDataFactory = textView;
        this.PlaceComponentResult = textView2;
        this.BuiltInFictitiousFunctionClassFactory = textView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = textView4;
        this.lookAheadTest = textView5;
        this.getErrorConfigVersion = textView6;
        this.moveToNextValue = textView7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView8;
        this.scheduleImpl = textView9;
    }

    public static ViewOrganizerSummaryX2pBodyBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_organizer_summary_x2p_body, (ViewGroup) null, false);
        int i = R.id.gCenter;
        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.gCenter);
        if (guideline != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvAmount);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_card_dana_goal_balance);
                if (textView2 != null) {
                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvHeaderTransactionDetail);
                    if (textView3 != null) {
                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.FriendListPresenter_Factory);
                        if (textView4 != null) {
                            TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvNoteTitle);
                            if (textView5 != null) {
                                TextView textView6 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvReceiver);
                                if (textView6 != null) {
                                    TextView textView7 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvReceiverTitle);
                                    if (textView7 != null) {
                                        TextView textView8 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSender);
                                        if (textView8 != null) {
                                            TextView textView9 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSenderTitle);
                                            if (textView9 != null) {
                                                return new ViewOrganizerSummaryX2pBodyBinding((ConstraintLayout) inflate, guideline, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
                                            }
                                            i = R.id.tvSenderTitle;
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
                    i = R.id.cl_card_dana_goal_balance;
                }
            } else {
                i = R.id.tvAmount;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
