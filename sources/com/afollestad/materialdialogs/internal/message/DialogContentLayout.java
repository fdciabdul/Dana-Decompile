package com.afollestad.materialdialogs.internal.message;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.internal.main.DialogScrollView;
import com.afollestad.materialdialogs.message.DialogMessageSettings;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010V\u001a\u00020U\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010W¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001cJ7\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007H\u0014¢\u0006\u0004\b%\u0010\u001cJN\u0010.\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(2\u0019\u0010-\u001a\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0004\u0018\u00010*¢\u0006\u0002\b,¢\u0006\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u0010:\u001a\u00020\u00078CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010H\u001a\u0004\u0018\u00010E8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010M\u001a\u0004\u0018\u00010L8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010T"}, d2 = {"Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;", "Landroid/widget/FrameLayout;", "", "noVerticalPadding", "", "addContentScrollView", "(Z)V", "", "res", "Landroid/view/View;", "view", "scrollable", "horizontalPadding", "addCustomView", "(Ljava/lang/Integer;Landroid/view/View;ZZZ)Landroid/view/View;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "addRecyclerView", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroidx/recyclerview/widget/RecyclerView$Adapter;Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "haveMoreThanOneChild", "()Z", "top", "bottom", "modifyFirstAndLastPadding", "(II)V", "modifyScrollViewPadding", "changed", "left", "right", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "text", "Landroid/graphics/Typeface;", "typeface", "Lkotlin/Function1;", "Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "Lkotlin/ExtensionFunctionType;", "applySettings", "setMessage", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/lang/Integer;Ljava/lang/CharSequence;Landroid/graphics/Typeface;Lkotlin/jvm/functions/Function1;)V", "customView", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "frameHorizontalMargin$delegate", "Lkotlin/Lazy;", "getFrameHorizontalMargin", "()I", "frameHorizontalMargin", "Landroid/widget/TextView;", "messageTextView", "Landroid/widget/TextView;", "Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;", "recyclerView", "Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;", "getRecyclerView", "()Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;", "setRecyclerView", "(Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;)V", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getRootLayout", "()Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "rootLayout", "Landroid/view/ViewGroup;", "scrollFrame", "Landroid/view/ViewGroup;", "Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;", "scrollView", "Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;", "getScrollView", "()Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;", "setScrollView", "(Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;)V", "useHorizontalPadding", "Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogContentLayout extends FrameLayout {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DialogContentLayout.class), "frameHorizontalMargin", "getFrameHorizontalMargin()I"))};
    private View customView;

    /* renamed from: frameHorizontalMargin$delegate  reason: from kotlin metadata */
    private final Lazy frameHorizontalMargin;
    private TextView messageTextView;
    private DialogRecyclerView recyclerView;
    private ViewGroup scrollFrame;
    private DialogScrollView scrollView;
    private boolean useHorizontalPadding;

    @JvmName(name = "getFrameHorizontalMargin")
    private final int getFrameHorizontalMargin() {
        Lazy lazy = this.frameHorizontalMargin;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
    }

    public /* synthetic */ DialogContentLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "");
        this.frameHorizontalMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.afollestad.materialdialogs.internal.message.DialogContentLayout$frameHorizontalMargin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return DialogContentLayout.this.getResources().getDimensionPixelSize(R.dimen.md_dialog_frame_margin_horizontal);
            }
        });
    }

    @JvmName(name = "getRootLayout")
    private final DialogLayout getRootLayout() {
        ViewParent parent = getParent();
        if (parent != null) {
            return (DialogLayout) parent;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.afollestad.materialdialogs.internal.main.DialogLayout");
    }

    @JvmName(name = "getScrollView")
    public final DialogScrollView getScrollView() {
        return this.scrollView;
    }

    @JvmName(name = "setScrollView")
    public final void setScrollView(DialogScrollView dialogScrollView) {
        this.scrollView = dialogScrollView;
    }

    @JvmName(name = "getRecyclerView")
    public final DialogRecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @JvmName(name = "setRecyclerView")
    public final void setRecyclerView(DialogRecyclerView dialogRecyclerView) {
        this.recyclerView = dialogRecyclerView;
    }

    @JvmName(name = "getCustomView")
    public final View getCustomView() {
        return this.customView;
    }

    @JvmName(name = "setCustomView")
    public final void setCustomView(View view) {
        this.customView = view;
    }

    public final void setMessage(MaterialDialog dialog, Integer res, CharSequence text, Typeface typeface, Function1<? super DialogMessageSettings, Unit> applySettings) {
        Intrinsics.checkParameterIsNotNull(dialog, "");
        addContentScrollView(false);
        if (this.messageTextView == null) {
            int i = R.layout.md_dialog_stub_message;
            ViewGroup viewGroup = this.scrollFrame;
            if (viewGroup == null) {
                Intrinsics.throwNpe();
            }
            TextView textView = (TextView) ViewsKt.inflate(this, i, viewGroup);
            ViewGroup viewGroup2 = this.scrollFrame;
            if (viewGroup2 == null) {
                Intrinsics.throwNpe();
            }
            viewGroup2.addView(textView);
            this.messageTextView = textView;
        }
        TextView textView2 = this.messageTextView;
        if (textView2 == null) {
            Intrinsics.throwNpe();
        }
        DialogMessageSettings dialogMessageSettings = new DialogMessageSettings(dialog, textView2);
        if (applySettings != null) {
            applySettings.invoke(dialogMessageSettings);
        }
        TextView textView3 = this.messageTextView;
        if (textView3 != null) {
            if (typeface != null) {
                textView3.setTypeface(typeface);
            }
            MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, textView3, dialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
            dialogMessageSettings.setText$core(res, text);
        }
    }

    public final void addRecyclerView(MaterialDialog dialog, RecyclerView.Adapter<?> adapter, RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkParameterIsNotNull(dialog, "");
        Intrinsics.checkParameterIsNotNull(adapter, "");
        if (this.recyclerView == null) {
            DialogRecyclerView dialogRecyclerView = (DialogRecyclerView) ViewsKt.inflate$default(this, R.layout.md_dialog_stub_recyclerview, (ViewGroup) null, 2, (Object) null);
            dialogRecyclerView.attach(dialog);
            if (layoutManager == null) {
                layoutManager = new LinearLayoutManager(dialog.getWindowContext());
            }
            dialogRecyclerView.setLayoutManager(layoutManager);
            this.recyclerView = dialogRecyclerView;
            addView(dialogRecyclerView);
        }
        DialogRecyclerView dialogRecyclerView2 = this.recyclerView;
        if (dialogRecyclerView2 != null) {
            dialogRecyclerView2.setAdapter(adapter);
        }
    }

    public final View addCustomView(Integer res, View view, boolean scrollable, boolean noVerticalPadding, boolean horizontalPadding) {
        if (!(this.customView == null)) {
            throw new IllegalStateException("Custom view already set.".toString());
        }
        View view2 = null;
        if (view != null && view.getParent() != null) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        if (scrollable) {
            this.useHorizontalPadding = false;
            addContentScrollView(noVerticalPadding);
            if (view == null) {
                if (res == null) {
                    Intrinsics.throwNpe();
                }
                view = (View) ViewsKt.inflate(this, res.intValue(), this.scrollFrame);
            }
            this.customView = view;
            ViewGroup viewGroup2 = this.scrollFrame;
            if (viewGroup2 == null) {
                Intrinsics.throwNpe();
            }
            View view3 = this.customView;
            if (view3 != null) {
                if (horizontalPadding) {
                    MDUtil.updatePadding$default(MDUtil.INSTANCE, view3, getFrameHorizontalMargin(), 0, getFrameHorizontalMargin(), 0, 10, null);
                }
                view2 = view3;
            }
            viewGroup2.addView(view2);
        } else {
            this.useHorizontalPadding = horizontalPadding;
            if (view == null) {
                if (res == null) {
                    Intrinsics.throwNpe();
                }
                view = (View) ViewsKt.inflate$default(this, res.intValue(), (ViewGroup) null, 2, (Object) null);
            }
            this.customView = view;
            addView(view);
        }
        View view4 = this.customView;
        if (view4 == null) {
            Intrinsics.throwNpe();
        }
        return view4;
    }

    public final boolean haveMoreThanOneChild() {
        return getChildCount() > 1;
    }

    public static /* synthetic */ void modifyFirstAndLastPadding$default(DialogContentLayout dialogContentLayout, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = -1;
        }
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        dialogContentLayout.modifyFirstAndLastPadding(i, i2);
    }

    public final void modifyFirstAndLastPadding(int top, int bottom) {
        if (top != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, getChildAt(0), 0, top, 0, 0, 13, null);
        }
        if (bottom != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, getChildAt(getChildCount() - 1), 0, 0, 0, bottom, 7, null);
        }
    }

    public static /* synthetic */ void modifyScrollViewPadding$default(DialogContentLayout dialogContentLayout, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = -1;
        }
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        dialogContentLayout.modifyScrollViewPadding(i, i2);
    }

    public final void modifyScrollViewPadding(int top, int bottom) {
        ViewGroup viewGroup = this.scrollView;
        if (viewGroup == null) {
            viewGroup = this.recyclerView;
        }
        ViewGroup viewGroup2 = viewGroup;
        if (top != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, viewGroup2, 0, top, 0, 0, 13, null);
        }
        if (bottom != -1) {
            MDUtil.updatePadding$default(MDUtil.INSTANCE, viewGroup2, 0, 0, 0, bottom, 7, null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int makeMeasureSpec;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        DialogScrollView dialogScrollView = this.scrollView;
        if (dialogScrollView != null) {
            dialogScrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }
        DialogScrollView dialogScrollView2 = this.scrollView;
        int measuredHeight = dialogScrollView2 != null ? dialogScrollView2.getMeasuredHeight() : 0;
        int childCount = this.scrollView != null ? getChildCount() - 1 : getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(size, measuredHeight);
            return;
        }
        int i = (size2 - measuredHeight) / childCount;
        int childCount2 = getChildCount();
        for (int i2 = 0; i2 < childCount2; i2++) {
            View childAt = getChildAt(i2);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "");
            int id2 = childAt.getId();
            DialogScrollView dialogScrollView3 = this.scrollView;
            if (dialogScrollView3 == null || id2 != dialogScrollView3.getId()) {
                if (Intrinsics.areEqual(childAt, this.customView) && this.useHorizontalPadding) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - (getFrameHorizontalMargin() * 2), 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                }
                childAt.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE));
                measuredHeight += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, measuredHeight);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredWidth;
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "");
            int measuredHeight = childAt.getMeasuredHeight() + i3;
            if (Intrinsics.areEqual(childAt, this.customView) && this.useHorizontalPadding) {
                i = getFrameHorizontalMargin();
                measuredWidth = getMeasuredWidth() - getFrameHorizontalMargin();
            } else {
                measuredWidth = getMeasuredWidth();
                i = 0;
            }
            childAt.layout(i, i3, measuredWidth, measuredHeight);
            i2++;
            i3 = measuredHeight;
        }
    }

    private final void addContentScrollView(boolean noVerticalPadding) {
        if (this.scrollView == null) {
            DialogScrollView dialogScrollView = (DialogScrollView) ViewsKt.inflate$default(this, R.layout.md_dialog_stub_scrollview, (ViewGroup) null, 2, (Object) null);
            dialogScrollView.setRootView(getRootLayout());
            View childAt = dialogScrollView.getChildAt(0);
            if (childAt != null) {
                this.scrollFrame = (ViewGroup) childAt;
                if (!noVerticalPadding) {
                    DialogScrollView dialogScrollView2 = dialogScrollView;
                    MDUtil.updatePadding$default(MDUtil.INSTANCE, dialogScrollView2, 0, 0, 0, MDUtil.INSTANCE.dimenPx(dialogScrollView2, R.dimen.md_dialog_frame_margin_vertical), 7, null);
                }
                this.scrollView = dialogScrollView;
                addView(dialogScrollView);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }
}
