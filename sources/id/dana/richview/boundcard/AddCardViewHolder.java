package id.dana.richview.boundcard;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.boundcard.model.BoundCard;

/* loaded from: classes9.dex */
public class AddCardViewHolder extends BaseRecyclerViewHolder<BoundCard> {
    @BindView(R.id.card_add)
    ConstraintLayout addCardContainer;
    @BindView(R.id.dana_card)
    ImageView cardView;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(BoundCard boundCard) {
        this.cardView.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), boundCard.BuiltInFictitiousFunctionClassFactory() ? R.drawable.img_add_card_with_expresspay : R.drawable.img_add_card));
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.addCardContainer.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.boundcard.AddCardViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onItemClickListener.onItemClick(AddCardViewHolder.this.getAdapterPosition());
            }
        });
    }
}
