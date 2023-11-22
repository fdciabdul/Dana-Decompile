package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\"\u0010\u001e\u001a\u00020\u001d8\u0001@\u0001X\u0080.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0019R\"\u0010&\u001a\u00020%8\u0001@\u0001X\u0081.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;", "Lcom/afollestad/materialdialogs/internal/main/BaseSubLayout;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "onFinishInflate", "()V", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "shouldNotBeVisible", "()Z", "frameMarginHorizontal", "I", "frameMarginVertical", "iconMargin", "iconSize", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/ImageView;", "getIconView$core", "()Landroid/widget/ImageView;", "setIconView$core", "(Landroid/widget/ImageView;)V", "titleMarginBottom", "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "getTitleView$core", "()Landroid/widget/TextView;", "setTitleView$core", "(Landroid/widget/TextView;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogTitleLayout extends BaseSubLayout {
    private final int frameMarginHorizontal;
    private final int frameMarginVertical;
    private final int iconMargin;
    private final int iconSize;
    public ImageView iconView;
    private final int titleMarginBottom;
    public TextView titleView;

    public /* synthetic */ DialogTitleLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogTitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "");
        this.frameMarginVertical = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_frame_margin_vertical);
        this.titleMarginBottom = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_title_layout_margin_bottom);
        this.frameMarginHorizontal = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_frame_margin_horizontal);
        this.iconMargin = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_icon_margin);
        this.iconSize = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_icon_size);
    }

    @JvmName(name = "getIconView$core")
    public final ImageView getIconView$core() {
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return imageView;
    }

    @JvmName(name = "setIconView$core")
    public final void setIconView$core(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "");
        this.iconView = imageView;
    }

    @JvmName(name = "getTitleView$core")
    public final TextView getTitleView$core() {
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return textView;
    }

    @JvmName(name = "setTitleView$core")
    public final void setTitleView$core(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "");
        this.titleView = textView;
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_icon_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "");
        this.iconView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.md_text_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "");
        this.titleView = (TextView) findViewById2;
    }

    public final boolean shouldNotBeVisible() {
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (ViewsKt.isNotVisible(imageView)) {
            TextView textView = this.titleView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (ViewsKt.isNotVisible(textView)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = 0;
        if (shouldNotBeVisible()) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int i2 = size - (this.frameMarginHorizontal * 2);
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (ViewsKt.isVisible(imageView)) {
            ImageView imageView2 = this.iconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            imageView2.measure(View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824), View.MeasureSpec.makeMeasureSpec(this.iconSize, 1073741824));
            ImageView imageView3 = this.iconView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            i2 -= imageView3.getMeasuredWidth() + this.iconMargin;
        }
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        textView.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        ImageView imageView4 = this.iconView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (ViewsKt.isVisible(imageView4)) {
            ImageView imageView5 = this.iconView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            i = imageView5.getMeasuredHeight();
        }
        TextView textView2 = this.titleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        setMeasuredDimension(size, RangesKt.coerceAtLeast(i, textView2.getMeasuredHeight()) + this.frameMarginVertical + this.titleMarginBottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        int measuredWidth;
        int i2;
        int i3;
        if (shouldNotBeVisible()) {
            return;
        }
        int i4 = this.frameMarginVertical;
        int measuredHeight = getMeasuredHeight() - this.titleMarginBottom;
        int i5 = measuredHeight - ((measuredHeight - i4) / 2);
        TextView textView = this.titleView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        int measuredHeight2 = textView.getMeasuredHeight() / 2;
        MDUtil mDUtil = MDUtil.INSTANCE;
        TextView textView2 = this.titleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        int additionalPaddingForFont = mDUtil.additionalPaddingForFont(textView2);
        if (ViewsKt.isRtl(this)) {
            measuredWidth = getMeasuredWidth() - this.frameMarginHorizontal;
            TextView textView3 = this.titleView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            i = measuredWidth - textView3.getMeasuredWidth();
        } else {
            i = this.frameMarginHorizontal;
            TextView textView4 = this.titleView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            measuredWidth = textView4.getMeasuredWidth() + i;
        }
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (ViewsKt.isVisible(imageView)) {
            ImageView imageView2 = this.iconView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            int measuredHeight3 = imageView2.getMeasuredHeight() / 2;
            if (ViewsKt.isRtl(this)) {
                ImageView imageView3 = this.iconView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                i = measuredWidth - imageView3.getMeasuredWidth();
                i3 = i - this.iconMargin;
                TextView textView5 = this.titleView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                i2 = i3 - textView5.getMeasuredWidth();
            } else {
                ImageView imageView4 = this.iconView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                measuredWidth = imageView4.getMeasuredWidth() + i;
                int i6 = this.iconMargin + measuredWidth;
                TextView textView6 = this.titleView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                int measuredWidth2 = textView6.getMeasuredWidth() + i6;
                i2 = i6;
                i3 = measuredWidth2;
            }
            ImageView imageView5 = this.iconView;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            imageView5.layout(i, i5 - measuredHeight3, measuredWidth, measuredHeight3 + i5);
            measuredWidth = i3;
            i = i2;
        }
        TextView textView7 = this.titleView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        textView7.layout(i, i5 - measuredHeight2, measuredWidth, measuredHeight2 + i5 + additionalPaddingForFont);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "");
        super.onDraw(canvas);
        if (getDrawDivider()) {
            canvas.drawLine(0.0f, getMeasuredHeight() - getDividerHeight(), getMeasuredWidth(), getMeasuredHeight(), dividerPaint());
        }
    }
}
