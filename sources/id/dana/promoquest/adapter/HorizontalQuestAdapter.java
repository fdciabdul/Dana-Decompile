package id.dana.promoquest.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.extension.view.ViewExtKt;
import id.dana.promoquest.model.QuestModel;
import io.reactivex.disposables.Disposable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0012\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/promoquest/adapter/HorizontalQuestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lid/dana/promoquest/model/QuestModel;", "PlaceComponentResult", "(Ljava/util/List;)V", "", "getAuthRequestContext", "Ljava/util/List;", "I", "Lio/reactivex/disposables/Disposable;", "MyBillsEntityDataFactory", "Lio/reactivex/disposables/Disposable;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "DividerViewHolder", "QuestViewHolder", "ViewType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HorizontalQuestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final View KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Disposable BuiltInFictitiousFunctionClassFactory;
    public int PlaceComponentResult;
    public final List<QuestModel> getAuthRequestContext;

    public HorizontalQuestAdapter(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.getAuthRequestContext = new ArrayList();
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/promoquest/adapter/HorizontalQuestAdapter$ViewType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes3.dex */
    @interface ViewType {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;
        public static final int DIVIDER = 1;
        public static final int QUEST_ITEM = 0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/promoquest/adapter/HorizontalQuestAdapter$ViewType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

            private Companion() {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void PlaceComponentResult(List<QuestModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.clear();
        Intrinsics.checkNotNullParameter(p0, "");
        if (!p0.isEmpty()) {
            int size = 5 - ((this.getAuthRequestContext.size() + 1) / 2);
            if (size > 0) {
                List take = CollectionsKt.take(p0, size);
                if (this.getAuthRequestContext.isEmpty()) {
                    this.getAuthRequestContext.add(take.get(0));
                }
                int size2 = take.size();
                for (int i = 1; i < size2; i++) {
                    this.getAuthRequestContext.add(null);
                    this.getAuthRequestContext.add(take.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return this.getAuthRequestContext.get(p0) == null ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        LayoutInflater from = LayoutInflater.from(p0.getContext());
        if (p1 == 0) {
            View inflate = from.inflate(R.layout.view_item_promo_quest_circle_wiggle, p0, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "");
            return new QuestViewHolder(inflate);
        }
        View inflate2 = from.inflate(R.layout.view_item_quest_horizontal_divider_sequential, p0, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "");
        return new DividerViewHolder(inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.getAuthRequestContext.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder p0, int p1) {
        Pair pair;
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof DividerViewHolder) {
            View view = p0.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "");
            ViewExtKt.MyBillsEntityDataFactory(view, Integer.valueOf((this.KClassImpl$Data$declaredNonStaticMembers$2.getWidth() - (((this.getAuthRequestContext.size() + 1) / 2) * ViewExtKt.PlaceComponentResult(24.0f))) / (this.getAuthRequestContext.size() / 2)), (Integer) null);
            if (this.PlaceComponentResult == 0) {
                p0.itemView.setVisibility(0);
                DividerViewHolder dividerViewHolder = (DividerViewHolder) p0;
                QuestModel questModel = this.getAuthRequestContext.get(p1 - 1);
                if (questModel != null) {
                    QuestModel questModel2 = (QuestModel) CollectionsKt.getOrNull(this.getAuthRequestContext, p1 + 1);
                    String[] strArr = {"FINISH", "COMPLETE"};
                    Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(dividerViewHolder.PlaceComponentResult.getContext(), (int) R.drawable.view_item_quest_horizontal_divider_sequential_background);
                    if (ArraysKt.contains(strArr, questModel.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        if (ArraysKt.contains(strArr, questModel2 != null ? questModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null) && PlaceComponentResult != null) {
                            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, ContextCompat.BuiltInFictitiousFunctionClassFactory(dividerViewHolder.PlaceComponentResult.getContext(), R.color.f23912131099976));
                        }
                    }
                    dividerViewHolder.PlaceComponentResult.setBackground(PlaceComponentResult);
                    return;
                }
                return;
            }
            p0.itemView.setVisibility(4);
            return;
        }
        QuestModel questModel3 = this.getAuthRequestContext.get(p1);
        if (questModel3 == null) {
            return;
        }
        ImageView imageView = (ImageView) p0.itemView;
        InstrumentInjector.Resources_setImageResource(imageView, questModel3.getAuthRequestContext());
        if (questModel3.KClassImpl$Data$declaredNonStaticMembers$2()) {
            Animation loadAnimation = AnimationUtils.loadAnimation(imageView.getContext(), R.anim.f4992130772046);
            loadAnimation.setAnimationListener(new HorizontalQuestAdapter$playAnimation$1(loadAnimation, this, imageView));
            Intrinsics.checkNotNullExpressionValue(loadAnimation, "");
            imageView.startAnimation(loadAnimation);
        }
        int width = p0.itemView.getWidth();
        if (getItemCount() == 1) {
            if (getItemCount() == 1) {
                int width2 = (this.KClassImpl$Data$declaredNonStaticMembers$2.getWidth() - width) / 2;
                pair = new Pair(Integer.valueOf(width2), Integer.valueOf(width2));
            } else {
                pair = new Pair(0, 0);
            }
            View view2 = p0.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "");
            ViewExtKt.MyBillsEntityDataFactory(view2, (Integer) pair.getFirst(), null, (Integer) pair.getSecond(), null, 10);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/promoquest/adapter/HorizontalQuestAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "getAuthRequestContext", "Landroid/view/View;", "PlaceComponentResult", "p0", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class DividerViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final View PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DividerViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "");
            View findViewById = view.findViewById(R.id.divider);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            this.PlaceComponentResult = findViewById;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/promoquest/adapter/HorizontalQuestAdapter$QuestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "p0", "<init>", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class QuestViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QuestViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "");
        }
    }
}
