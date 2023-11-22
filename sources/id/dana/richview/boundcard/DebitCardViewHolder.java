package id.dana.richview.boundcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.boundcard.BoundCardAdapter;
import id.dana.richview.boundcard.model.BoundCard;

/* loaded from: classes9.dex */
public class DebitCardViewHolder extends BaseRecyclerViewHolder<BoundCard> {
    @BindView(R.id.debit_card)
    DebitCardView debitCard;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(BoundCard boundCard) {
        this.debitCard.setData(boundCard);
    }

    public DebitCardViewHolder(Context context, ViewGroup viewGroup, final BoundCardAdapter.OnBoundCardClickListener onBoundCardClickListener) {
        super(context, R.layout.card_debit, viewGroup);
        ButterKnife.BuiltInFictitiousFunctionClassFactory(this, this.itemView);
        this.debitCard.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.boundcard.DebitCardViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebitCardViewHolder debitCardViewHolder = DebitCardViewHolder.this;
                BoundCardAdapter.OnBoundCardClickListener onBoundCardClickListener2 = onBoundCardClickListener;
                if (onBoundCardClickListener2 != null) {
                    onBoundCardClickListener2.PlaceComponentResult(view, debitCardViewHolder.getAdapterPosition());
                }
            }
        });
    }
}
