package id.dana.sendmoney.contact.all;

import android.view.ViewGroup;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import java.util.List;

/* loaded from: classes5.dex */
public class InviteDisableContactViewHolder extends ContactViewHolder {
    @Override // id.dana.sendmoney.contact.all.ContactViewHolder, id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        this.contactRichView.init(recipientViewModel, getAuthRequestContext());
        this.contactRichView.setOnClickListener(new InviteDisableContactViewHolder$$ExternalSyntheticLambda0(this));
    }

    public InviteDisableContactViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener, List<String> list) {
        super(viewGroup, baseRecipientListener, list);
    }

    @Override // id.dana.sendmoney.contact.all.ContactViewHolder
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public final void bindData(RecipientViewModel recipientViewModel) {
        this.contactRichView.init(recipientViewModel, getAuthRequestContext());
        this.contactRichView.setOnClickListener(new InviteDisableContactViewHolder$$ExternalSyntheticLambda0(this));
    }
}
