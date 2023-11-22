package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.emoji.widget.EmojiAppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewFeedReactionBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final EmojiAppCompatTextView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ViewFeedReactionBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, EmojiAppCompatTextView emojiAppCompatTextView, ConstraintLayout constraintLayout2) {
        this.lookAheadTest = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.PlaceComponentResult = textView;
        this.getAuthRequestContext = emojiAppCompatTextView;
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout2;
    }

    public static ViewFeedReactionBinding PlaceComponentResult(View view) {
        int i = R.id.iv_feed_reaction_add_new;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_feed_reaction_add_new);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_feed_reaction_button_icon);
            if (appCompatImageView2 != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4403tv_feed_reaction_counter);
                if (textView != null) {
                    EmojiAppCompatTextView emojiAppCompatTextView = (EmojiAppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4404tv_feed_reaction_emoji);
                    if (emojiAppCompatTextView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new ViewFeedReactionBinding(constraintLayout, appCompatImageView, appCompatImageView2, textView, emojiAppCompatTextView, constraintLayout);
                    }
                    i = R.id.f4404tv_feed_reaction_emoji;
                } else {
                    i = R.id.f4403tv_feed_reaction_counter;
                }
            } else {
                i = R.id.iv_feed_reaction_button_icon;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
