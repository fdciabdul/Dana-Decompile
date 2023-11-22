package id.dana.richview.boundcard;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.boundcard.model.BoundCard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes9.dex */
public class BoundCardAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<BoundCard>, BoundCard> {
    String MyBillsEntityDataFactory;
    private final OnBoundCardClickListener PlaceComponentResult;

    /* loaded from: classes9.dex */
    public interface OnBoundCardClickListener {
        void PlaceComponentResult(View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewType {
        public static final int ADD_CARD = 0;
        public static final int DANA_CARD = 1;
        public static final int DEBIT_CARD = 2;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BoundCardAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundCardAdapter(OnBoundCardClickListener onBoundCardClickListener) {
        this.PlaceComponentResult = onBoundCardClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        BoundCard item = getItem(i);
        if (item.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return 1;
        }
        return ((item.PlaceComponentResult() || item.getAuthRequestContext()) && !item.MyBillsEntityDataFactory()) ? 2 : 0;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void onBindViewHolder(BaseRecyclerViewHolder<BoundCard> baseRecyclerViewHolder, int i) {
        baseRecyclerViewHolder.setIsRecyclable(false);
        super.onBindViewHolder((BoundCardAdapter) baseRecyclerViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new DanaCardViewHolder(viewGroup.getContext(), viewGroup, this.MyBillsEntityDataFactory, this.PlaceComponentResult);
        }
        if (i == 2) {
            return new DebitCardViewHolder(viewGroup.getContext(), viewGroup, this.PlaceComponentResult);
        }
        return new AddCardTextViewHolder(viewGroup.getContext(), viewGroup, this.PlaceComponentResult);
    }
}
