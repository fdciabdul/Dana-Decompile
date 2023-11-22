package id.dana.sendmoney.contact.all;

import android.view.View;
import android.view.ViewGroup;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import io.reactivex.subjects.PublishSubject;
import java.util.List;

/* loaded from: classes5.dex */
public class InviteEnableContactViewHolder extends ContactViewHolder {
    public String PlaceComponentResult;

    @Override // id.dana.sendmoney.contact.all.ContactViewHolder, id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
        bindData(recipientViewModel);
    }

    public InviteEnableContactViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener, List<String> list) {
        super(viewGroup, baseRecipientListener, list);
    }

    public InviteEnableContactViewHolder(ViewGroup viewGroup, BaseRecipientListener baseRecipientListener, List<String> list, PublishSubject<List<String>> publishSubject, List<String> list2) {
        super(viewGroup, baseRecipientListener, list, publishSubject, list2);
    }

    @Override // id.dana.sendmoney.contact.all.ContactViewHolder
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public final void bindData(RecipientViewModel recipientViewModel) {
        this.contactRichView.enableInvite();
        this.contactRichView.init(recipientViewModel, getAuthRequestContext());
        this.contactRichView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.contact.all.InviteEnableContactViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteEnableContactViewHolder inviteEnableContactViewHolder = InviteEnableContactViewHolder.this;
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(inviteEnableContactViewHolder.getContext());
                builder.MyBillsEntityDataFactory = TrackerKey.Event.REFERRER_INVITE_ATTEMPT;
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(TrackerKey.Property.INVITE_TYPE, TrackerKey.InviteType.USER_CONTACT);
                MyBillsEntityDataFactory.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
                RecipientModel selectedRecipient = inviteEnableContactViewHolder.contactRichView.getSelectedRecipient();
                selectedRecipient.SubSequence = RecipientSource.ALL_CONTACTS;
                inviteEnableContactViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.onRecipientSelected(selectedRecipient);
            }
        });
    }

    @Override // id.dana.sendmoney.contact.all.ContactViewHolder
    public final ContactViewHolder getAuthRequestContext(String str) {
        this.PlaceComponentResult = str;
        return this;
    }
}
