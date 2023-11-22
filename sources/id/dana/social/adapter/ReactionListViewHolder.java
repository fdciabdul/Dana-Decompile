package id.dana.social.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.emoji.widget.EmojiAppCompatTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.view.TextViewExtKt;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B*\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0019\u0010\r\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u000e\u0010\u000fR'\u0010\b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/adapter/ReactionListViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/reaction/model/ReactionModel;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionListViewHolder extends BaseRecyclerViewHolder<ReactionModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<ReactionModel, Unit> MyBillsEntityDataFactory;
    public final ViewGroup getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ReactionModel reactionModel) {
        final ReactionModel reactionModel2 = reactionModel;
        if (reactionModel2 != null) {
            EmojiAppCompatTextView emojiAppCompatTextView = (EmojiAppCompatTextView) this.itemView.findViewById(R.id.res_0x7f0a16d3_typeutilskt_requirestypealiasexpansion_1);
            if (emojiAppCompatTextView != null) {
                Intrinsics.checkNotNullExpressionValue(emojiAppCompatTextView, "");
                TextViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(emojiAppCompatTextView, reactionModel2.BuiltInFictitiousFunctionClassFactory);
            }
            EmojiAppCompatTextView emojiAppCompatTextView2 = (EmojiAppCompatTextView) this.itemView.findViewById(R.id.res_0x7f0a16d3_typeutilskt_requirestypealiasexpansion_1);
            if (emojiAppCompatTextView2 != null) {
                emojiAppCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.ReactionListViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReactionListViewHolder.getAuthRequestContext(ReactionListViewHolder.this, reactionModel2);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReactionListViewHolder(ViewGroup viewGroup, Function1<? super ReactionModel, Unit> function1) {
        super(viewGroup.getContext(), R.layout.viewholder_reaction_emoji, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = viewGroup;
        this.MyBillsEntityDataFactory = function1;
    }

    public static /* synthetic */ void getAuthRequestContext(ReactionListViewHolder reactionListViewHolder, ReactionModel reactionModel) {
        Intrinsics.checkNotNullParameter(reactionListViewHolder, "");
        Intrinsics.checkNotNullParameter(reactionModel, "");
        reactionListViewHolder.MyBillsEntityDataFactory.invoke(reactionModel);
    }
}
