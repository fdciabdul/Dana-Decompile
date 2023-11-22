package id.dana.social.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.emoji.widget.EmojiAppCompatTextView;
import com.alibaba.griver.ui.ant.utils.IconfontConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewFeedReactionBinding;
import id.dana.extension.view.TextViewExtKt;
import id.dana.extension.view.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0016\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b%\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u0018R\u0014\u0010 \u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010!\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010#\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010$"}, d2 = {"Lid/dana/social/view/ReactionView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFeedReactionBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFeedReactionBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", IconfontConstants.KEY_ICON_UNICODE, "setEmoji", "(Ljava/lang/String;)V", "", "selected", "setReactionActive", "(Z)V", "reactionCount", "setReactionCount", "(Ljava/lang/Integer;)V", "feedRevamp", "setSaymojiStyle", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Z", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ReactionView extends ViewBindingRichView<ViewFeedReactionBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final int MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final int getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_feed_reaction;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = ViewExtKt.PlaceComponentResult(24.0f);
        this.getAuthRequestContext = ViewExtKt.PlaceComponentResult(4.0f);
        this.PlaceComponentResult = ViewExtKt.PlaceComponentResult(10.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = ViewExtKt.PlaceComponentResult(24.0f);
        this.getAuthRequestContext = ViewExtKt.PlaceComponentResult(4.0f);
        this.PlaceComponentResult = ViewExtKt.PlaceComponentResult(10.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public ViewFeedReactionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFeedReactionBinding PlaceComponentResult = ViewFeedReactionBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attrs) {
        String str;
        String str2;
        if (attrs == null || context == null) {
            return;
        }
        setStyledAttributes(context, attrs, R.styleable.indexOfAny);
        try {
            int dimensionPixelSize = getStyledAttributes().getDimensionPixelSize(8, this.MyBillsEntityDataFactory);
            int dimensionPixelSize2 = getStyledAttributes().getDimensionPixelSize(4, this.MyBillsEntityDataFactory);
            int dimensionPixelSize3 = getStyledAttributes().getDimensionPixelSize(3, this.getAuthRequestContext);
            int dimensionPixelSize4 = getStyledAttributes().getDimensionPixelSize(7, this.PlaceComponentResult);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.vg_feed_reaction_bubble);
            if (constraintLayout != null) {
                if (dimensionPixelSize != this.MyBillsEntityDataFactory) {
                    ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
                    layoutParams.height = dimensionPixelSize;
                    constraintLayout.setLayoutParams(layoutParams);
                }
                if (dimensionPixelSize3 != this.getAuthRequestContext) {
                    ViewExtKt.BuiltInFictitiousFunctionClassFactory(constraintLayout, Integer.valueOf(dimensionPixelSize3), null, Integer.valueOf(dimensionPixelSize3), null, 10);
                }
                if (dimensionPixelSize4 != this.PlaceComponentResult) {
                    ViewExtKt.MyBillsEntityDataFactory(constraintLayout, null, null, Integer.valueOf(dimensionPixelSize4), null, 11);
                }
            }
            EmojiAppCompatTextView emojiAppCompatTextView = (EmojiAppCompatTextView) _$_findCachedViewById(R.id.tv_feed_reaction_emoji);
            if (emojiAppCompatTextView != null && dimensionPixelSize != this.MyBillsEntityDataFactory) {
                ViewGroup.LayoutParams layoutParams2 = emojiAppCompatTextView.getLayoutParams();
                layoutParams2.height = dimensionPixelSize2;
                emojiAppCompatTextView.setLayoutParams(layoutParams2);
            }
            TypedArray styledAttributes = getStyledAttributes();
            if (styledAttributes == null || (str = styledAttributes.getString(1)) == null) {
                str = "1F600";
            }
            setEmoji(str);
            TypedArray styledAttributes2 = getStyledAttributes();
            if (styledAttributes2 == null || (str2 = styledAttributes2.getString(5)) == null) {
                str2 = "-";
            }
            getBinding().PlaceComponentResult.setText(str2);
            TypedArray styledAttributes3 = getStyledAttributes();
            if (styledAttributes3 != null) {
                boolean z = styledAttributes3.getBoolean(2, false);
                EmojiAppCompatTextView emojiAppCompatTextView2 = getBinding().getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(emojiAppCompatTextView2, "");
                boolean z2 = !z;
                emojiAppCompatTextView2.setVisibility(z2 ? 0 : 8);
                TextView textView = getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(z2 ? 0 : 8);
                AppCompatImageView appCompatImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(z ? 0 : 8);
            }
            TypedArray styledAttributes4 = getStyledAttributes();
            if (styledAttributes4 != null && styledAttributes4.getBoolean(6, false)) {
                getBinding().getAuthRequestContext.setVisibility(4);
                AppCompatImageView appCompatImageView2 = getBinding().MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                appCompatImageView2.setVisibility(0);
                getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.bg_rounded_corner_feed_reaction_grey));
                getBinding().getAuthRequestContext.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23982131099995));
                getBinding().PlaceComponentResult.setVisibility(8);
            }
        } finally {
            TypedArray styledAttributes5 = getStyledAttributes();
            if (styledAttributes5 != null) {
                styledAttributes5.recycle();
            }
        }
    }

    public final void setEmoji(String unicode) {
        EmojiAppCompatTextView emojiAppCompatTextView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(emojiAppCompatTextView, "");
        TextViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(emojiAppCompatTextView, unicode);
    }

    public final void setReactionCount(Integer reactionCount) {
        String valueOf;
        TextView textView = getBinding().PlaceComponentResult;
        if ((reactionCount != null ? reactionCount.intValue() : 0) <= 99) {
            valueOf = String.valueOf(reactionCount != null ? reactionCount.intValue() : 0);
        }
        textView.setText(valueOf);
    }

    public final void setReactionActive(boolean selected) {
        getBinding().BuiltInFictitiousFunctionClassFactory.setSelected(selected);
        if (this.BuiltInFictitiousFunctionClassFactory) {
            getBinding().PlaceComponentResult.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), selected ? R.color.f27072131100488 : R.color.f24002131099997));
        } else {
            getBinding().PlaceComponentResult.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), selected ? R.color.f22912131099753 : R.color.f23982131099995));
        }
    }

    public final void setSaymojiStyle(boolean feedRevamp) {
        this.BuiltInFictitiousFunctionClassFactory = feedRevamp;
        if (feedRevamp) {
            getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.bg_rounded_corner_feed_reaction_v2));
            getBinding().PlaceComponentResult.setTextSize(2, 14.0f);
            getBinding().PlaceComponentResult.setTypeface(Typeface.defaultFromStyle(1));
            return;
        }
        getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.bg_rounded_corner_feed_reaction));
        getBinding().PlaceComponentResult.setTextSize(2, 12.0f);
        getBinding().PlaceComponentResult.setTypeface(Typeface.defaultFromStyle(0));
    }
}
