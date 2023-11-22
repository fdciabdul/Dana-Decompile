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

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class DanaCardViewHolder extends BaseRecyclerViewHolder<BoundCard> {
    private String PlaceComponentResult;
    @BindView(R.id.card_dana)
    DanaBalanceCardView clCardDana;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(BoundCard boundCard) {
        this.clCardDana.setEntryPoint(this.PlaceComponentResult);
        this.clCardDana.setData(boundCard);
    }

    public DanaCardViewHolder(Context context, ViewGroup viewGroup, String str, final BoundCardAdapter.OnBoundCardClickListener onBoundCardClickListener) {
        super(context, R.layout.card_dana, viewGroup);
        ButterKnife.BuiltInFictitiousFunctionClassFactory(this, this.itemView);
        this.PlaceComponentResult = str;
        this.clCardDana.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.boundcard.DanaCardViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaCardViewHolder danaCardViewHolder = DanaCardViewHolder.this;
                BoundCardAdapter.OnBoundCardClickListener onBoundCardClickListener2 = onBoundCardClickListener;
                if (onBoundCardClickListener2 != null) {
                    onBoundCardClickListener2.PlaceComponentResult(view, danaCardViewHolder.getAdapterPosition());
                }
            }
        });
    }
}
