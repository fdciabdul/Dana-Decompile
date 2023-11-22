package id.dana.danapoly.ui.cards.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.danapoly.databinding.ViewholderCardItemBinding;
import id.dana.danapoly.ui.cards.adapter.CardListAdapter;
import id.dana.danapoly.ui.model.CardItemModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danapoly/ui/cards/adapter/CardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/danapoly/ui/cards/adapter/CardListAdapter$BaseDanapolyCardViewHolder;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "", "Lid/dana/danapoly/ui/model/CardItemModel;", "PlaceComponentResult", "Ljava/util/List;", "getAuthRequestContext", "Lid/dana/danapoly/ui/cards/adapter/CardListAdapter$Listener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/ui/cards/adapter/CardListAdapter$Listener;", "<init>", "()V", "BaseDanapolyCardViewHolder", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardListAdapter extends RecyclerView.Adapter<BaseDanapolyCardViewHolder> {
    public Listener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<CardItemModel> getAuthRequestContext = new ArrayList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/ui/cards/adapter/CardListAdapter$Listener;", "", "Lid/dana/danapoly/ui/model/CardItemModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/danapoly/ui/model/CardItemModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Listener {
        void MyBillsEntityDataFactory(CardItemModel p0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(BaseDanapolyCardViewHolder baseDanapolyCardViewHolder, int i) {
        BaseDanapolyCardViewHolder baseDanapolyCardViewHolder2 = baseDanapolyCardViewHolder;
        Intrinsics.checkNotNullParameter(baseDanapolyCardViewHolder2, "");
        if (i != -1) {
            baseDanapolyCardViewHolder2.getAuthRequestContext(this.getAuthRequestContext.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ BaseDanapolyCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ViewholderCardItemBinding MyBillsEntityDataFactory = ViewholderCardItemBinding.MyBillsEntityDataFactory(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return new CardItemViewHolder(MyBillsEntityDataFactory, new Function1<CardItemModel, Unit>() { // from class: id.dana.danapoly.ui.cards.adapter.CardListAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CardItemModel cardItemModel) {
                invoke2(cardItemModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CardItemModel cardItemModel) {
                Intrinsics.checkNotNullParameter(cardItemModel, "");
                CardListAdapter.Listener listener = CardListAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (listener != null) {
                    listener.MyBillsEntityDataFactory(cardItemModel);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.getAuthRequestContext.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return this.getAuthRequestContext.get(p0).getItemType();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/ui/cards/adapter/CardListAdapter$BaseDanapolyCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/danapoly/ui/model/CardItemModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/danapoly/ui/model/CardItemModel;)V", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static abstract class BaseDanapolyCardViewHolder extends RecyclerView.ViewHolder {
        public abstract void getAuthRequestContext(CardItemModel p0);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseDanapolyCardViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "");
        }
    }
}
