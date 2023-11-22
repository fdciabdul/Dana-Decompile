package id.dana.sendmoney.contact.all;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SendWithPhoneNumberViewHolder_ViewBinding implements Unbinder {
    private SendWithPhoneNumberViewHolder MyBillsEntityDataFactory;

    public SendWithPhoneNumberViewHolder_ViewBinding(SendWithPhoneNumberViewHolder sendWithPhoneNumberViewHolder, View view) {
        this.MyBillsEntityDataFactory = sendWithPhoneNumberViewHolder;
        sendWithPhoneNumberViewHolder.rlAdd = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rl_add, "field 'rlAdd'", RelativeLayout.class);
        sendWithPhoneNumberViewHolder.tvAddNew = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_add_new, "field 'tvAddNew'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SendWithPhoneNumberViewHolder sendWithPhoneNumberViewHolder = this.MyBillsEntityDataFactory;
        if (sendWithPhoneNumberViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        sendWithPhoneNumberViewHolder.rlAdd = null;
        sendWithPhoneNumberViewHolder.tvAddNew = null;
    }
}
