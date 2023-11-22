package id.dana.social.adapter.viewholder;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.extension.view.ViewExtKt;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.model.FeedHighlightModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.RegexUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/social/adapter/viewholder/FeedHighlightViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedHighlightModel;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedHighlightViewHolder extends BaseRecyclerViewHolder<FeedHighlightModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedHighlightModel feedHighlightModel) {
        SpannableString spannableString;
        FeedHighlightModel feedHighlightModel2 = feedHighlightModel;
        if (feedHighlightModel2 != null) {
            View view = this.itemView;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.UCropFragment);
            if (appCompatImageView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(appCompatImageView, feedHighlightModel2.PlaceComponentResult, R.drawable.avatar_placeholder);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.iv_unread_badge);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility((feedHighlightModel2.getScheduleImpl() ? view : null) != null ? ((Number) 8).intValue() : 0);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1);
            if (appCompatTextView != null) {
                if ((feedHighlightModel2.MyBillsEntityDataFactory.isEmpty() ^ true ? view : null) != null) {
                    RegexUtils.Companion companion = RegexUtils.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    Intrinsics.checkNotNullParameter(context, "");
                    String str = feedHighlightModel2.getAuthRequestContext;
                    String str2 = feedHighlightModel2.BuiltInFictitiousFunctionClassFactory;
                    HashMap<String, String> hashMap = feedHighlightModel2.MyBillsEntityDataFactory;
                    if (!(hashMap instanceof HashMap)) {
                        hashMap = null;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap<>();
                    }
                    Spannable PlaceComponentResult = RegexUtils.Companion.PlaceComponentResult(new FeedRegexData(str, str2, hashMap, null, context, feedHighlightModel2.KClassImpl$Data$declaredNonStaticMembers$2, 8, null), null, false, false, 14);
                    if (PlaceComponentResult != null) {
                        spannableString = PlaceComponentResult;
                        appCompatTextView.setText(spannableString);
                    }
                }
                spannableString = new SpannableString(feedHighlightModel2.BuiltInFictitiousFunctionClassFactory);
                appCompatTextView.setText(spannableString);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedHighlightViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1) {
        super(viewGroup.getContext(), R.layout.item_feed_highlight, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "");
        ViewExtKt.PlaceComponentResult(view, 6.0f);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FeedHighlightViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedHighlightViewHolder.MyBillsEntityDataFactory(Function1.this, this);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Function1 function1, FeedHighlightViewHolder feedHighlightViewHolder) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(feedHighlightViewHolder, "");
        function1.invoke(Integer.valueOf(feedHighlightViewHolder.getAbsoluteAdapterPosition()));
    }
}
