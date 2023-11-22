package id.dana.richview.widgetcard.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.extension.view.ViewExtKt;
import id.dana.richview.widgetcard.WidgetItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/richview/widgetcard/adapter/WidgetAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/richview/widgetcard/WidgetItem;", "<init>", "()V", "CardSize", "WidgetViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WidgetAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<WidgetItem>, WidgetItem> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new WidgetViewHolder(viewGroup, getPlaceComponentResult() > 1 ? 0 : 1);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/richview/widgetcard/adapter/WidgetAdapter$CardSize;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    public @interface CardSize {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.PlaceComponentResult;
        public static final int LARGE = 1;
        public static final int SMALL = 0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/richview/widgetcard/adapter/WidgetAdapter$CardSize$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion PlaceComponentResult = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0005"}, d2 = {"Lid/dana/richview/widgetcard/adapter/WidgetAdapter$WidgetViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/richview/widgetcard/WidgetItem;", "", "BuiltInFictitiousFunctionClassFactory", "I", "PlaceComponentResult", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "getAuthRequestContext", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class WidgetViewHolder extends BaseRecyclerViewHolder<WidgetItem> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final ViewGroup BuiltInFictitiousFunctionClassFactory;
        public int getAuthRequestContext;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(WidgetItem widgetItem) {
            WidgetItem widgetItem2 = widgetItem;
            if (widgetItem2 != null) {
                int i = this.PlaceComponentResult;
                this.getAuthRequestContext = i;
                if (i == 0) {
                    CardView cardView = (CardView) this.itemView.findViewById(R.id.cv_widget_item);
                    Intrinsics.checkNotNullExpressionValue(cardView, "");
                    ViewExtKt.MyBillsEntityDataFactory(cardView, Integer.valueOf(this.itemView.getResources().getDimensionPixelSize(R.dimen.f33792131166073)), (Integer) null);
                }
                String str = widgetItem2.KClassImpl$Data$declaredNonStaticMembers$2;
                Context context = getContext();
                if (context != null) {
                    GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).PlaceComponentResult((int) R.drawable.bg_donation_placeholder).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.iv_widget_background));
                }
                String str2 = widgetItem2.MyBillsEntityDataFactory;
                if (str2 != null) {
                    ((TextView) this.itemView.findViewById(R.id.tv_widget_title)).setText(str2);
                    ((TextView) this.itemView.findViewById(R.id.tv_widget_title)).setVisibility(0);
                }
                String str3 = widgetItem2.PlaceComponentResult;
                Boolean bool = widgetItem2.getAuthRequestContext;
                if (str3 != null) {
                    ((TextView) this.itemView.findViewById(R.id.tv_widget_owner)).setText(str3);
                    if (bool != null ? bool.equals(Boolean.TRUE) : false) {
                        ((TextView) this.itemView.findViewById(R.id.tv_widget_owner)).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_verify_blue), (Drawable) null);
                    }
                    ((TextView) this.itemView.findViewById(R.id.tv_widget_owner)).setVisibility(0);
                }
                ((CardView) this.itemView.findViewById(R.id.cv_widget_item)).setVisibility(0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WidgetViewHolder(ViewGroup viewGroup, int i) {
            super(viewGroup.getContext(), R.layout.view_item_widget, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.BuiltInFictitiousFunctionClassFactory = viewGroup;
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = 1;
        }
    }
}
