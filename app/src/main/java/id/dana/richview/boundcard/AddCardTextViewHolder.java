package id.dana.richview.boundcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.boundcard.BoundCardAdapter;
import id.dana.richview.boundcard.model.BoundCard;

/* loaded from: classes9.dex */
public class AddCardTextViewHolder extends BaseRecyclerViewHolder<BoundCard> {
    @BindView(R.id.ll_card_add)
    LinearLayout llCardAdd;
    @BindView(R.id.tv_add_card)
    TextView tvAddCard;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(BoundCard boundCard) {
        if (getAdapterPosition() == 0) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.llCardAdd.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.llCardAdd.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AddCardTextViewHolder(Context context, ViewGroup viewGroup, final BoundCardAdapter.OnBoundCardClickListener onBoundCardClickListener) {
        super(context, R.layout.card_add_text, viewGroup);
        ButterKnife.BuiltInFictitiousFunctionClassFactory(this, this.itemView);
        this.tvAddCard.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.boundcard.AddCardTextViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCardTextViewHolder addCardTextViewHolder = AddCardTextViewHolder.this;
                BoundCardAdapter.OnBoundCardClickListener onBoundCardClickListener2 = onBoundCardClickListener;
                if (onBoundCardClickListener2 != null) {
                    onBoundCardClickListener2.PlaceComponentResult(view, addCardTextViewHolder.getAdapterPosition());
                }
            }
        });
    }
}
