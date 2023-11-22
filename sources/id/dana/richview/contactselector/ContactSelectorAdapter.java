package id.dana.richview.contactselector;

import android.view.ViewGroup;
import androidx.paging.AsyncPagedListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BasePagedListAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.contact.all.ContactViewHolder;
import id.dana.sendmoney.contact.all.InviteEnableContactViewHolder;
import id.dana.sendmoney.contact.all.NoContactFoundViewHolder;
import id.dana.sendmoney.contact.all.NoContactPermissionViewHolder;
import id.dana.sendmoney.contact.all.SendWithNewNumberViewHolder;
import id.dana.sendmoney.contact.all.SendWithPhoneNumberViewHolder;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.SectionViewHolder;
import id.dana.sendmoney.view.BaseRecipientListener;
import io.reactivex.subjects.PublishSubject;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.List;

/* loaded from: classes5.dex */
public class ContactSelectorAdapter extends BasePagedListAdapter<BaseRecyclerViewHolder<RecipientViewModel>, RecipientViewModel> {
    List<String> BuiltInFictitiousFunctionClassFactory;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    BaseRecipientListener getAuthRequestContext;
    List<String> lookAheadTest;
    PublishSubject<List<String>> scheduleImpl;

    public ContactSelectorAdapter(DiffUtil.ItemCallback<RecipientViewModel> itemCallback) {
        super(itemCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        AsyncPagedListDiffer<T> asyncPagedListDiffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        AbstractCollection abstractCollection = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (abstractCollection == null) {
            abstractCollection = asyncPagedListDiffer.moveToNextValue;
        }
        if (abstractCollection != null) {
            AsyncPagedListDiffer<T> asyncPagedListDiffer2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            AbstractCollection abstractCollection2 = asyncPagedListDiffer2.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (abstractCollection2 == null) {
                abstractCollection2 = asyncPagedListDiffer2.moveToNextValue;
            }
            if (abstractCollection2.isEmpty()) {
                return -1;
            }
            if (i < 0) {
                i = 0;
            }
            AsyncPagedListDiffer<T> asyncPagedListDiffer3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            AbstractList abstractList = asyncPagedListDiffer3.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (abstractList == null) {
                abstractList = asyncPagedListDiffer3.moveToNextValue;
            }
            return ((RecipientViewModel) abstractList.get(i)).PrepareContext;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            if (i == 3) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return new ContactViewHolder(viewGroup, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl, this.lookAheadTest).getAuthRequestContext("split_bill");
                }
                InviteEnableContactViewHolder inviteEnableContactViewHolder = new InviteEnableContactViewHolder(viewGroup, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.scheduleImpl, this.lookAheadTest);
                inviteEnableContactViewHolder.PlaceComponentResult = "split_bill";
                return inviteEnableContactViewHolder;
            } else if (i == 5) {
                return new NoContactPermissionViewHolder(viewGroup);
            } else {
                if (i == 11) {
                    return new SendWithPhoneNumberViewHolder(viewGroup, "split_bill");
                }
                if (i != 15 && i != 7) {
                    if (i == 8) {
                        return new SendWithNewNumberViewHolder(viewGroup, this.getAuthRequestContext);
                    }
                    return new NoContactFoundViewHolder(viewGroup);
                }
            }
        }
        return new SectionViewHolder(viewGroup);
    }
}
