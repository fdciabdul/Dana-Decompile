package id.dana.challenge.pin;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.core.ui.richview.PinEntryEditText;

/* loaded from: classes8.dex */
public class PinChallengeFragment_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private PinChallengeFragment MyBillsEntityDataFactory;
    private View getAuthRequestContext;

    public PinChallengeFragment_ViewBinding(final PinChallengeFragment pinChallengeFragment, View view) {
        this.MyBillsEntityDataFactory = pinChallengeFragment;
        pinChallengeFragment.bottomMesageBlock = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ll_bottom_message_block, "field 'bottomMesageBlock'", LinearLayout.class);
        pinChallengeFragment.bottomMessage = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.bottom_message, "field 'bottomMessage'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.bottom_try_again, "field 'bottomTryAgain' and method 'onTryAgain'");
        pinChallengeFragment.bottomTryAgain = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.bottom_try_again, "field 'bottomTryAgain'", TextView.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.challenge.pin.PinChallengeFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                pinChallengeFragment.onTryAgain(view2);
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0, "field 'btnShowHidePin' and method 'showHidePin'");
        pinChallengeFragment.btnShowHidePin = (AppCompatTextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.res_0x7f0a0208_networkuserentitydata_externalsyntheticlambda0, "field 'btnShowHidePin'", AppCompatTextView.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.challenge.pin.PinChallengeFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                pinChallengeFragment.showHidePin();
            }
        });
        View BuiltInFictitiousFunctionClassFactory3 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.other_action, "field 'forgotPin' and method 'onForgotPin'");
        pinChallengeFragment.forgotPin = (TextView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3, R.id.other_action, "field 'forgotPin'", TextView.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory3;
        BuiltInFictitiousFunctionClassFactory3.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.challenge.pin.PinChallengeFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                pinChallengeFragment.onForgotPin(view2);
            }
        });
        pinChallengeFragment.icImageFg = (ImageView) Utils.PlaceComponentResult(view, R.id.ic_image_fg, "field 'icImageFg'", ImageView.class);
        pinChallengeFragment.inputPin = (PinEntryEditText) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.res_0x7f0a0905_networkuserentitydata_externalsyntheticlambda8, "field 'inputPin'", PinEntryEditText.class);
        pinChallengeFragment.progressBar = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ic_progress, "field 'progressBar'", RelativeLayout.class);
        pinChallengeFragment.relativeWarningIcon = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rl_warning, "field 'relativeWarningIcon'", RelativeLayout.class);
        pinChallengeFragment.successIcon = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ic_success, "field 'successIcon'", ImageView.class);
        pinChallengeFragment.successPin = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pin_success, "field 'successPin'", TextView.class);
        pinChallengeFragment.txtInputPinMessage = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.res_0x7f0a0907_networkuserentitydata_externalsyntheticlambda7, "field 'txtInputPinMessage'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PinChallengeFragment pinChallengeFragment = this.MyBillsEntityDataFactory;
        if (pinChallengeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        pinChallengeFragment.bottomMesageBlock = null;
        pinChallengeFragment.bottomMessage = null;
        pinChallengeFragment.bottomTryAgain = null;
        pinChallengeFragment.btnShowHidePin = null;
        pinChallengeFragment.forgotPin = null;
        pinChallengeFragment.icImageFg = null;
        pinChallengeFragment.inputPin = null;
        pinChallengeFragment.progressBar = null;
        pinChallengeFragment.relativeWarningIcon = null;
        pinChallengeFragment.successIcon = null;
        pinChallengeFragment.successPin = null;
        pinChallengeFragment.txtInputPinMessage = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
