package id.dana.sendmoney.contact.all;

import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.EmptyState;
import id.dana.sendmoney.model.RecipientViewModel;

/* loaded from: classes5.dex */
public class NoContactPermissionViewHolder extends BaseRecyclerViewHolder<RecipientViewModel> {
    @BindView(R.id.es_contact)
    EmptyState esContact;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* bridge */ /* synthetic */ void bindData(RecipientViewModel recipientViewModel) {
    }

    public NoContactPermissionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_contact_no_permission, viewGroup);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.esContact.onActionClick(new View.OnClickListener() { // from class: id.dana.sendmoney.contact.all.NoContactPermissionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onItemClickListener.onItemClick(NoContactPermissionViewHolder.this.getAdapterPosition());
            }
        });
    }
}
