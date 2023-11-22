package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.afollestad.materialdialogs.LayoutMode;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout;
import com.afollestad.materialdialogs.internal.button.DialogActionButtonLayoutKt;
import com.afollestad.materialdialogs.internal.message.DialogContentLayout;
import com.afollestad.materialdialogs.utils.DimensKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.socialshare.ShareAppKey;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010t\u001a\u00020s\u0012\b\u0010v\u001a\u0004\u0018\u00010u¢\u0006\u0004\bw\u0010xJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0016\u0010\u000eJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0017\u0010\u0015J7\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\"\u0010#J!\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b(\u0010)JE\u0010*\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010$\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020%H\u0002¢\u0006\u0004\b*\u0010+J/\u0010.\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010$\u001a\u00020\u00192\b\b\u0002\u0010,\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%H\u0002¢\u0006\u0004\b.\u0010/JC\u00100\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010$\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020%2\b\b\u0002\u0010\u001b\u001a\u00020%2\b\b\u0002\u0010\u001d\u001a\u00020%H\u0002¢\u0006\u0004\b0\u00101J-\u00103\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010,\u001a\u00020%2\b\b\u0002\u00102\u001a\u00020%H\u0002¢\u0006\u0004\b3\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u0006R\"\u00109\u001a\u0002088\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R*\u0010A\u001a\u00020?2\u0006\u0010@\u001a\u00020?8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bK\u0010LR*\u0010M\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010\b\u001a\u00020\u00078\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\b\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010\nR\u001a\u0010Y\u001a\u00020\u00198\u0001X\u0081\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020\u00198\u0001X\u0081\u0004¢\u0006\f\n\u0004\b]\u0010Z\u001a\u0004\b^\u0010\\R\u0016\u0010_\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b_\u0010NR\"\u0010a\u001a\u00020`8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010g\u001a\u00020\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010Z\u001a\u0004\bh\u0010\\\"\u0004\bi\u0010jR\"\u0010l\u001a\u00020k8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\br\u0010Z"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "Landroid/widget/FrameLayout;", "Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "buttonsLayout", "", "attachButtonsLayout", "(Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;)V", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "attachDialog", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "showTop", "showBottom", "invalidateDividers", "(ZZ)V", "onAttachedToWindow", "()V", "onDraw", "onFinishInflate", "changed", "", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "color", "", "alpha", "Landroid/graphics/Paint;", "paint", "(IF)Landroid/graphics/Paint;", "box", "(Landroid/graphics/Canvas;IFFFFF)V", "start", ZebraData.ATTR_HEIGHT, "horizontalLine", "(Landroid/graphics/Canvas;IFF)V", ShareAppKey.LINE, "(Landroid/graphics/Canvas;IFFFF)V", ZebraData.ATTR_WIDTH, "verticalLine", "Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "getButtonsLayout", "()Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "setButtonsLayout", "Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;", "contentLayout", "Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;", "getContentLayout", "()Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;", "setContentLayout", "(Lcom/afollestad/materialdialogs/internal/message/DialogContentLayout;)V", "", "value", "cornerRadii", "[F", "getCornerRadii", "()[F", "setCornerRadii", "([F)V", "Landroid/graphics/Path;", "cornerRadiusPath", "Landroid/graphics/Path;", "Landroid/graphics/RectF;", "cornerRadiusRect", "Landroid/graphics/RectF;", "debugMode", "Z", "getDebugMode", "()Z", "setDebugMode", "(Z)V", "debugPaint", "Landroid/graphics/Paint;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getDialog", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "setDialog", "frameMarginVertical", "I", "getFrameMarginVertical$core", "()I", "frameMarginVerticalLess", "getFrameMarginVerticalLess$core", "isButtonsLayoutAChild", "Lcom/afollestad/materialdialogs/LayoutMode;", "layoutMode", "Lcom/afollestad/materialdialogs/LayoutMode;", "getLayoutMode", "()Lcom/afollestad/materialdialogs/LayoutMode;", "setLayoutMode", "(Lcom/afollestad/materialdialogs/LayoutMode;)V", "maxHeight", "getMaxHeight", "setMaxHeight", "(I)V", "Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;", "titleLayout", "Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;", "getTitleLayout", "()Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;", "setTitleLayout", "(Lcom/afollestad/materialdialogs/internal/main/DialogTitleLayout;)V", "windowHeight", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogLayout extends FrameLayout implements FSDispatchDraw {
    private DialogActionButtonLayout buttonsLayout;
    public DialogContentLayout contentLayout;
    private float[] cornerRadii;
    private final Path cornerRadiusPath;
    private final RectF cornerRadiusRect;
    private boolean debugMode;
    private Paint debugPaint;
    public MaterialDialog dialog;
    private final int frameMarginVertical;
    private final int frameMarginVerticalLess;
    private boolean isButtonsLayoutAChild;
    private LayoutMode layoutMode;
    private int maxHeight;
    public DialogTitleLayout titleLayout;
    private int windowHeight;

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return fsSuperDrawChild_14f36dc124b01edc0bb6deb1585fec35(canvas, view, j);
    }

    public final void fsSuperDispatchDraw_14f36dc124b01edc0bb6deb1585fec35(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public final boolean fsSuperDrawChild_14f36dc124b01edc0bb6deb1585fec35(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "");
        this.cornerRadii = new float[0];
        this.frameMarginVertical = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_frame_margin_vertical);
        this.frameMarginVerticalLess = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_dialog_frame_margin_vertical_less);
        this.layoutMode = LayoutMode.WRAP_CONTENT;
        this.isButtonsLayoutAChild = true;
        this.windowHeight = -1;
        this.cornerRadiusPath = new Path();
        this.cornerRadiusRect = new RectF();
    }

    @JvmName(name = "getMaxHeight")
    public final int getMaxHeight() {
        return this.maxHeight;
    }

    @JvmName(name = "setMaxHeight")
    public final void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    @JvmName(name = "getDebugMode")
    public final boolean getDebugMode() {
        return this.debugMode;
    }

    @JvmName(name = "setDebugMode")
    public final void setDebugMode(boolean z) {
        this.debugMode = z;
        setWillNotDraw(!z);
    }

    @JvmName(name = "getCornerRadii")
    public final float[] getCornerRadii() {
        return this.cornerRadii;
    }

    @JvmName(name = "setCornerRadii")
    public final void setCornerRadii(float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "");
        this.cornerRadii = fArr;
        if (!this.cornerRadiusPath.isEmpty()) {
            this.cornerRadiusPath.reset();
        }
        invalidate();
    }

    @JvmName(name = "getFrameMarginVertical$core")
    /* renamed from: getFrameMarginVertical$core  reason: from getter */
    public final int getFrameMarginVertical() {
        return this.frameMarginVertical;
    }

    @JvmName(name = "getFrameMarginVerticalLess$core")
    /* renamed from: getFrameMarginVerticalLess$core  reason: from getter */
    public final int getFrameMarginVerticalLess() {
        return this.frameMarginVerticalLess;
    }

    @JvmName(name = "getDialog")
    public final MaterialDialog getDialog() {
        MaterialDialog materialDialog = this.dialog;
        if (materialDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return materialDialog;
    }

    @JvmName(name = "setDialog")
    public final void setDialog(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        this.dialog = materialDialog;
    }

    @JvmName(name = "getTitleLayout")
    public final DialogTitleLayout getTitleLayout() {
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return dialogTitleLayout;
    }

    @JvmName(name = "setTitleLayout")
    public final void setTitleLayout(DialogTitleLayout dialogTitleLayout) {
        Intrinsics.checkParameterIsNotNull(dialogTitleLayout, "");
        this.titleLayout = dialogTitleLayout;
    }

    @JvmName(name = "getContentLayout")
    public final DialogContentLayout getContentLayout() {
        DialogContentLayout dialogContentLayout = this.contentLayout;
        if (dialogContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return dialogContentLayout;
    }

    @JvmName(name = "setContentLayout")
    public final void setContentLayout(DialogContentLayout dialogContentLayout) {
        Intrinsics.checkParameterIsNotNull(dialogContentLayout, "");
        this.contentLayout = dialogContentLayout;
    }

    @JvmName(name = "getButtonsLayout")
    public final DialogActionButtonLayout getButtonsLayout() {
        return this.buttonsLayout;
    }

    @JvmName(name = "setButtonsLayout")
    public final void setButtonsLayout(DialogActionButtonLayout dialogActionButtonLayout) {
        this.buttonsLayout = dialogActionButtonLayout;
    }

    @Override // android.view.ViewGroup
    @JvmName(name = "getLayoutMode")
    public final LayoutMode getLayoutMode() {
        return this.layoutMode;
    }

    @JvmName(name = "setLayoutMode")
    public final void setLayoutMode(LayoutMode layoutMode) {
        Intrinsics.checkParameterIsNotNull(layoutMode, "");
        this.layoutMode = layoutMode;
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "");
        this.titleLayout = (DialogTitleLayout) findViewById;
        View findViewById2 = findViewById(R.id.md_content_layout);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "");
        this.contentLayout = (DialogContentLayout) findViewById2;
        this.buttonsLayout = (DialogActionButtonLayout) findViewById(R.id.md_button_layout);
    }

    public final void attachDialog(MaterialDialog dialog) {
        Intrinsics.checkParameterIsNotNull(dialog, "");
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        dialogTitleLayout.setDialog(dialog);
        DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
        if (dialogActionButtonLayout != null) {
            dialogActionButtonLayout.setDialog(dialog);
        }
    }

    public final void attachButtonsLayout(DialogActionButtonLayout buttonsLayout) {
        Intrinsics.checkParameterIsNotNull(buttonsLayout, "");
        this.buttonsLayout = buttonsLayout;
        this.isButtonsLayoutAChild = false;
    }

    public final void invalidateDividers(boolean showTop, boolean showBottom) {
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        dialogTitleLayout.setDrawDivider(showTop);
        DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
        if (dialogActionButtonLayout != null) {
            dialogActionButtonLayout.setDrawDivider(showBottom);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object systemService = getContext().getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.windowHeight = MDUtil.INSTANCE.getWidthAndHeight((WindowManager) systemService).component2().intValue();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int i = this.maxHeight;
        if (i > 0 && size2 > i) {
            size2 = i;
        }
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        dialogTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
            DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
            if (dialogActionButtonLayout == null) {
                Intrinsics.throwNpe();
            }
            dialogActionButtonLayout.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        DialogTitleLayout dialogTitleLayout2 = this.titleLayout;
        if (dialogTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        int measuredHeight = dialogTitleLayout2.getMeasuredHeight();
        DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
        int measuredHeight2 = dialogActionButtonLayout2 != null ? dialogActionButtonLayout2.getMeasuredHeight() : 0;
        DialogContentLayout dialogContentLayout = this.contentLayout;
        if (dialogContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        dialogContentLayout.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2 - (measuredHeight + measuredHeight2), Integer.MIN_VALUE));
        if (this.layoutMode == LayoutMode.WRAP_CONTENT) {
            DialogTitleLayout dialogTitleLayout3 = this.titleLayout;
            if (dialogTitleLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            int measuredHeight3 = dialogTitleLayout3.getMeasuredHeight();
            DialogContentLayout dialogContentLayout2 = this.contentLayout;
            if (dialogContentLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            int measuredHeight4 = dialogContentLayout2.getMeasuredHeight();
            DialogActionButtonLayout dialogActionButtonLayout3 = this.buttonsLayout;
            setMeasuredDimension(size, measuredHeight3 + measuredHeight4 + (dialogActionButtonLayout3 != null ? dialogActionButtonLayout3.getMeasuredHeight() : 0));
        } else {
            setMeasuredDimension(size, this.windowHeight);
        }
        if ((!(this.cornerRadii.length == 0)) == true) {
            RectF rectF = this.cornerRadiusRect;
            rectF.left = 0.0f;
            rectF.top = 0.0f;
            rectF.right = getMeasuredWidth();
            rectF.bottom = getMeasuredHeight();
            this.cornerRadiusPath.addRoundRect(this.cornerRadiusRect, this.cornerRadii, Path.Direction.CW);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredHeight;
        int measuredWidth = getMeasuredWidth();
        DialogTitleLayout dialogTitleLayout = this.titleLayout;
        if (dialogTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        int measuredHeight2 = dialogTitleLayout.getMeasuredHeight();
        DialogTitleLayout dialogTitleLayout2 = this.titleLayout;
        if (dialogTitleLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        dialogTitleLayout2.layout(0, 0, measuredWidth, measuredHeight2);
        if (this.isButtonsLayoutAChild) {
            int measuredHeight3 = getMeasuredHeight();
            DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
            measuredHeight = measuredHeight3 - (dialogActionButtonLayout != null ? dialogActionButtonLayout.getMeasuredHeight() : 0);
            if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
                int measuredWidth2 = getMeasuredWidth();
                int measuredHeight4 = getMeasuredHeight();
                DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
                if (dialogActionButtonLayout2 == null) {
                    Intrinsics.throwNpe();
                }
                dialogActionButtonLayout2.layout(0, measuredHeight, measuredWidth2, measuredHeight4);
            }
        } else {
            measuredHeight = getMeasuredHeight();
        }
        int measuredWidth3 = getMeasuredWidth();
        DialogContentLayout dialogContentLayout = this.contentLayout;
        if (dialogContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        dialogContentLayout.layout(0, measuredHeight2, measuredWidth3, measuredHeight);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        float measuredWidth;
        Intrinsics.checkParameterIsNotNull(canvas, "");
        super.onDraw(canvas);
        if (this.debugMode) {
            verticalLine$default(this, canvas, -16776961, DimensKt.dp(this, 24), 0.0f, 4, null);
            horizontalLine$default(this, canvas, -16776961, DimensKt.dp(this, 24), 0.0f, 4, null);
            verticalLine$default(this, canvas, -16776961, getMeasuredWidth() - DimensKt.dp(this, 24), 0.0f, 4, null);
            DialogTitleLayout dialogTitleLayout = this.titleLayout;
            if (dialogTitleLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (ViewsKt.isVisible(dialogTitleLayout)) {
                if (this.titleLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                horizontalLine$default(this, canvas, -65536, r0.getBottom(), 0.0f, 4, null);
            }
            DialogContentLayout dialogContentLayout = this.contentLayout;
            if (dialogContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (ViewsKt.isVisible(dialogContentLayout)) {
                if (this.contentLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                horizontalLine$default(this, canvas, -256, r0.getTop(), 0.0f, 4, null);
            }
            if (DialogActionButtonLayoutKt.shouldBeVisible(this.buttonsLayout)) {
                if (ViewsKt.isRtl(this)) {
                    measuredWidth = DimensKt.dp(this, 8);
                } else {
                    measuredWidth = getMeasuredWidth() - DimensKt.dp(this, 8);
                }
                verticalLine$default(this, canvas, -16711681, measuredWidth, 0.0f, 4, null);
                DialogActionButtonLayout dialogActionButtonLayout = this.buttonsLayout;
                if (dialogActionButtonLayout != null && dialogActionButtonLayout.getStackButtons()) {
                    DialogActionButtonLayout dialogActionButtonLayout2 = this.buttonsLayout;
                    if (dialogActionButtonLayout2 == null) {
                        Intrinsics.throwNpe();
                    }
                    float top = dialogActionButtonLayout2.getTop();
                    float dp = DimensKt.dp(this, 8);
                    DialogActionButtonLayout dialogActionButtonLayout3 = this.buttonsLayout;
                    if (dialogActionButtonLayout3 == null) {
                        Intrinsics.throwNpe();
                    }
                    float f = top + dp;
                    for (DialogActionButton dialogActionButton : dialogActionButtonLayout3.getVisibleButtons()) {
                        float dp2 = f + DimensKt.dp(this, 36);
                        box(canvas, -16711681, 0.4f, dialogActionButton.getLeft(), getMeasuredWidth() - DimensKt.dp(this, 8), f, dp2);
                        f = dp2 + DimensKt.dp(this, 16);
                    }
                    if (this.buttonsLayout == null) {
                        Intrinsics.throwNpe();
                    }
                    horizontalLine$default(this, canvas, -16776961, r0.getTop(), 0.0f, 4, null);
                    DialogActionButtonLayout dialogActionButtonLayout4 = this.buttonsLayout;
                    if (dialogActionButtonLayout4 == null) {
                        Intrinsics.throwNpe();
                    }
                    float top2 = dialogActionButtonLayout4.getTop();
                    float dp3 = DimensKt.dp(this, 8);
                    float measuredHeight = getMeasuredHeight();
                    float dp4 = DimensKt.dp(this, 8);
                    horizontalLine$default(this, canvas, -65536, top2 + dp3, 0.0f, 4, null);
                    horizontalLine$default(this, canvas, -65536, measuredHeight - dp4, 0.0f, 4, null);
                    return;
                }
                DialogActionButtonLayout dialogActionButtonLayout5 = this.buttonsLayout;
                if (dialogActionButtonLayout5 != null) {
                    if (dialogActionButtonLayout5 == null) {
                        Intrinsics.throwNpe();
                    }
                    for (DialogActionButton dialogActionButton2 : dialogActionButtonLayout5.getVisibleButtons()) {
                        DialogActionButtonLayout dialogActionButtonLayout6 = this.buttonsLayout;
                        if (dialogActionButtonLayout6 == null) {
                            Intrinsics.throwNpe();
                        }
                        float top3 = dialogActionButtonLayout6.getTop();
                        float top4 = dialogActionButton2.getTop();
                        float dp5 = DimensKt.dp(this, 8);
                        DialogActionButtonLayout dialogActionButtonLayout7 = this.buttonsLayout;
                        if (dialogActionButtonLayout7 == null) {
                            Intrinsics.throwNpe();
                        }
                        box(canvas, -16711681, 0.4f, dialogActionButton2.getLeft() + DimensKt.dp(this, 4), dialogActionButton2.getRight() - DimensKt.dp(this, 4), top3 + top4 + dp5, dialogActionButtonLayout7.getBottom() - DimensKt.dp(this, 8));
                    }
                    if (this.buttonsLayout == null) {
                        Intrinsics.throwNpe();
                    }
                    horizontalLine$default(this, canvas, -65281, r0.getTop(), 0.0f, 4, null);
                    float measuredHeight2 = getMeasuredHeight() - (DimensKt.dp(this, 52) - DimensKt.dp(this, 8));
                    float measuredHeight3 = getMeasuredHeight();
                    float dp6 = DimensKt.dp(this, 8);
                    horizontalLine$default(this, canvas, -65536, measuredHeight2, 0.0f, 4, null);
                    horizontalLine$default(this, canvas, -65536, measuredHeight3 - dp6, 0.0f, 4, null);
                    horizontalLine$default(this, canvas, -16776961, measuredHeight2 - DimensKt.dp(this, 8), 0.0f, 4, null);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "");
        if ((!(this.cornerRadii.length == 0)) != false) {
            canvas.clipPath(this.cornerRadiusPath);
        }
        fsSuperDispatchDraw_14f36dc124b01edc0bb6deb1585fec35(canvas);
    }

    static /* synthetic */ Paint paint$default(DialogLayout dialogLayout, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        return dialogLayout.paint(i, f);
    }

    private final Paint paint(int color, float alpha) {
        if (this.debugPaint == null) {
            Paint paint = new Paint();
            paint.setStrokeWidth(DimensKt.dp(this, 1));
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            this.debugPaint = paint;
        }
        Paint paint2 = this.debugPaint;
        if (paint2 == null) {
            Intrinsics.throwNpe();
        }
        paint2.setColor(color);
        setAlpha(alpha);
        return paint2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void box(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5) {
        canvas.drawRect(f2, f4, f3, f5, paint(i, f));
    }

    static /* synthetic */ void line$default(DialogLayout dialogLayout, Canvas canvas, int i, float f, float f2, float f3, float f4, int i2, Object obj) {
        float f5 = (i2 & 2) != 0 ? 0.0f : f;
        float f6 = (i2 & 4) != 0 ? f5 : f2;
        float f7 = (i2 & 8) != 0 ? 0.0f : f3;
        dialogLayout.line(canvas, i, f5, f6, f7, (i2 & 16) != 0 ? f7 : f4);
    }

    private final void line(Canvas canvas, int i, float f, float f2, float f3, float f4) {
        canvas.drawLine(f, f3, f2, f4, paint$default(this, i, 0.0f, 2, null));
    }

    static /* synthetic */ void verticalLine$default(DialogLayout dialogLayout, Canvas canvas, int i, float f, float f2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f2 = f;
        }
        dialogLayout.verticalLine(canvas, i, f, f2);
    }

    private final void verticalLine(Canvas canvas, int i, float f, float f2) {
        line(canvas, i, f, f2, 0.0f, getMeasuredHeight());
    }

    static /* synthetic */ void horizontalLine$default(DialogLayout dialogLayout, Canvas canvas, int i, float f, float f2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = dialogLayout.getMeasuredHeight();
        }
        if ((i2 & 4) != 0) {
            f2 = f;
        }
        dialogLayout.horizontalLine(canvas, i, f, f2);
    }

    private final void horizontalLine(Canvas canvas, int i, float f, float f2) {
        line(canvas, i, 0.0f, getMeasuredWidth(), f, f2);
    }
}
