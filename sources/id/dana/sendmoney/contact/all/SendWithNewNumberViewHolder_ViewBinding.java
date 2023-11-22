package id.dana.sendmoney.contact.all;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SendWithNewNumberViewHolder_ViewBinding implements Unbinder {
    private SendWithNewNumberViewHolder BuiltInFictitiousFunctionClassFactory;

    public SendWithNewNumberViewHolder_ViewBinding(SendWithNewNumberViewHolder sendWithNewNumberViewHolder, View view) {
        this.BuiltInFictitiousFunctionClassFactory = sendWithNewNumberViewHolder;
        sendWithNewNumberViewHolder.tvPhoneNumber = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_phone_number, "field 'tvPhoneNumber'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SendWithNewNumberViewHolder sendWithNewNumberViewHolder = this.BuiltInFictitiousFunctionClassFactory;
        if (sendWithNewNumberViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        sendWithNewNumberViewHolder.tvPhoneNumber = null;
    }
}
