package id.dana.sendmoney.contact.all;

import android.view.View;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;

/* loaded from: classes5.dex */
public final /* synthetic */ class InviteDisableContactViewHolder$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ InviteDisableContactViewHolder MyBillsEntityDataFactory;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InviteDisableContactViewHolder inviteDisableContactViewHolder = this.MyBillsEntityDataFactory;
        RecipientModel selectedRecipient = inviteDisableContactViewHolder.contactRichView.getSelectedRecipient();
        selectedRecipient.SubSequence = RecipientSource.ALL_CONTACTS;
        inviteDisableContactViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.onRecipientSelected(selectedRecipient);
    }
}
