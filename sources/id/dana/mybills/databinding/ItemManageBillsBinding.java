package id.dana.mybills.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.mybills.R;

/* loaded from: classes5.dex */
public final class ItemManageBillsBinding implements ViewBinding {
    public final CardView BuiltInFictitiousFunctionClassFactory;
    public final View GetContactSyncConfig;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CircleImageView PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final MaterialCardView scheduleImpl;

    private ItemManageBillsBinding(MaterialCardView materialCardView, DanaButtonSecondaryView danaButtonSecondaryView, CircleImageView circleImageView, CircleImageView circleImageView2, ConstraintLayout constraintLayout, CardView cardView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.scheduleImpl = materialCardView;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.PlaceComponentResult = circleImageView;
        this.MyBillsEntityDataFactory = circleImageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = cardView;
        this.getErrorConfigVersion = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.moveToNextValue = textView3;
        this.lookAheadTest = textView4;
        this.initRecordTimeStamp = textView5;
        this.GetContactSyncConfig = view;
    }

    public static ItemManageBillsBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.item_manage_bills, viewGroup, false);
        int i = R.id.getCallingPid;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (danaButtonSecondaryView != null) {
            i = R.id.getOnBoardingScenario;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (circleImageView != null) {
                i = R.id.E;
                CircleImageView circleImageView2 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (circleImageView2 != null) {
                    i = R.id.K;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (constraintLayout != null) {
                        i = R.id.res_0x7f0a055c_summaryvoucherview_externalsyntheticlambda2;
                        CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (cardView != null) {
                            i = R.id.res_0x7f0a13be_arraytable_3;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView != null) {
                                i = R.id.ConcurrentKt;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView2 != null) {
                                    i = R.id.WithdrawSavedCardChannelView;
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (textView3 != null) {
                                        i = R.id.TrackerKey$GlobalSearchOpenProperties;
                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (textView4 != null) {
                                            i = R.id.getExceptionOrNull;
                                            TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                            if (textView5 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.access$getFeaturedBankListAdapter$p))) != null) {
                                                return new ItemManageBillsBinding((MaterialCardView) inflate, danaButtonSecondaryView, circleImageView, circleImageView2, constraintLayout, cardView, textView, textView2, textView3, textView4, textView5, BuiltInFictitiousFunctionClassFactory);
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
        return this.scheduleImpl;
    }
}
