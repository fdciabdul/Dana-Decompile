package id.dana.richview.splitbill;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.CurrencyTextView;

/* loaded from: classes9.dex */
public class AmountDisplayView_ViewBinding implements Unbinder {
    private AmountDisplayView BuiltInFictitiousFunctionClassFactory;

    public AmountDisplayView_ViewBinding(AmountDisplayView amountDisplayView, View view) {
        this.BuiltInFictitiousFunctionClassFactory = amountDisplayView;
        amountDisplayView.ctvAmount = (CurrencyTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ctv_amount, "field 'ctvAmount'", CurrencyTextView.class);
        amountDisplayView.tvRemainingAmount = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_remaining_amount, "field 'tvRemainingAmount'", TextView.class);
        amountDisplayView.btnChange = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_change, "field 'btnChange'", Button.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        AmountDisplayView amountDisplayView = this.BuiltInFictitiousFunctionClassFactory;
        if (amountDisplayView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        amountDisplayView.ctvAmount = null;
        amountDisplayView.tvRemainingAmount = null;
        amountDisplayView.btnChange = null;
    }
}
