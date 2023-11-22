package id.dana.globalsearch.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.ContextExtKt;
import id.dana.globalsearch.model.RecentAutoComplete;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000b\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/globalsearch/adapter/AutoCompleteAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/globalsearch/adapter/AutoCompleteAdapter$AutoCompleteViewHolder;", "Lid/dana/globalsearch/model/RecentAutoComplete;", "", "p0", "getItemViewType", "(I)I", "<init>", "()V", "Companion", "AutoCompleteViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutoCompleteAdapter extends BaseRecyclerViewAdapter<AutoCompleteViewHolder, RecentAutoComplete> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new AutoCompleteViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return p0 == getItems().size() - 1 ? 1 : 0;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/globalsearch/adapter/AutoCompleteAdapter$AutoCompleteViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/globalsearch/model/RecentAutoComplete;", "", "BuiltInFictitiousFunctionClassFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class AutoCompleteViewHolder extends BaseRecyclerViewHolder<RecentAutoComplete> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final int KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(RecentAutoComplete recentAutoComplete) {
            LinearLayout linearLayout;
            RecentAutoComplete recentAutoComplete2 = recentAutoComplete;
            if (recentAutoComplete2 != null) {
                TextView textView = (TextView) this.itemView.findViewById(R.id.tv_result_auto_complete);
                if (textView != null) {
                    textView.setText(recentAutoComplete2.BuiltInFictitiousFunctionClassFactory);
                }
                if (Intrinsics.areEqual(recentAutoComplete2.MyBillsEntityDataFactory, "RECENT")) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_search_auto_complete);
                    if (appCompatImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_recent_search);
                    } else {
                        appCompatImageView.setImageResource(R.drawable.ic_recent_search);
                    }
                } else {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.itemView.findViewById(R.id.iv_search_auto_complete);
                    if (appCompatImageView2 instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView2, R.drawable.ic_search);
                    } else {
                        appCompatImageView2.setImageResource(R.drawable.ic_search);
                    }
                }
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 1 || (linearLayout = (LinearLayout) this.itemView.findViewById(R.id.ll_item_auto_complete)) == null) {
                return;
            }
            Context context = linearLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            linearLayout.setBackground(ContextExtKt.PlaceComponentResult(context, (int) R.drawable.bg_bottom_rounded_4dp_white));
            LinearLayout linearLayout2 = linearLayout;
            linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), linearLayout.getContext().getResources().getDimensionPixelSize(R.dimen.f28032131165270));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AutoCompleteViewHolder(ViewGroup viewGroup, int i) {
            super(viewGroup.getContext(), R.layout.item_auto_complete, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }
}
