package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.formcomponent.DanaRadioButtonView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView;

/* loaded from: classes5.dex */
public final class ItemEnabledTransferToDebitBinding implements ViewBinding {
    public final CardView BuiltInFictitiousFunctionClassFactory;
    public final DanaRadioButtonView DatabaseTableConfigUtil;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final CircleImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ConstraintLayout PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final EditTextFormView moveToNextValue;
    public final CardView scheduleImpl;

    private ItemEnabledTransferToDebitBinding(CardView cardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, CardView cardView2, AppCompatImageView appCompatImageView, CircleImageView circleImageView, TextView textView, TextView textView2, EditTextFormView editTextFormView, DanaRadioButtonView danaRadioButtonView) {
        this.scheduleImpl = cardView;
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.getAuthRequestContext = constraintLayout3;
        this.BuiltInFictitiousFunctionClassFactory = cardView2;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = circleImageView;
        this.getErrorConfigVersion = textView;
        this.lookAheadTest = textView2;
        this.moveToNextValue = editTextFormView;
        this.DatabaseTableConfigUtil = danaRadioButtonView;
    }

    public static ItemEnabledTransferToDebitBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.item_enabled_transfer_to_debit, viewGroup, false);
        int i = R.id.clEnabledItem;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (constraintLayout != null) {
            i = R.id.AppCompatEmojiTextHelper_res_0x7f0a0378;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (constraintLayout2 != null) {
                i = R.id.res_0x7f0a03e7_summaryvoucherview_externalsyntheticlambda2;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (constraintLayout3 != null) {
                    CardView cardView = (CardView) inflate;
                    i = R.id.encodingStream;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatImageView != null) {
                        i = R.id.WithdrawSavedCardChannelView_res_0x7f0a0a59;
                        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (circleImageView != null) {
                            i = R.id.VerifyPasswordFacade;
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                            if (textView != null) {
                                i = R.id.tvTitleTransferDestination;
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                if (textView2 != null) {
                                    i = R.id.getMaxAppJavaHeapMemoryKb_res_0x7f0a1a94;
                                    EditTextFormView editTextFormView = (EditTextFormView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                    if (editTextFormView != null) {
                                        i = R.id.setPluginState;
                                        DanaRadioButtonView danaRadioButtonView = (DanaRadioButtonView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                                        if (danaRadioButtonView != null) {
                                            return new ItemEnabledTransferToDebitBinding(cardView, constraintLayout, constraintLayout2, constraintLayout3, cardView, appCompatImageView, circleImageView, textView, textView2, editTextFormView, danaRadioButtonView);
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
