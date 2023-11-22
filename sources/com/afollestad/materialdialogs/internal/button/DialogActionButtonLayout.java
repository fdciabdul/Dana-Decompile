package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.internal.main.BaseSubLayout;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u0001:\u0001;B\u001b\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ7\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\"\u0010%\u001a\u00020$8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b+\u0010!R\u0014\u0010,\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b,\u0010!R\"\u0010-\u001a\u00020\t8\u0001@\u0001X\u0081\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188G¢\u0006\u0006\u001a\u0004\b3\u0010\u001d"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButtonLayout;", "Lcom/afollestad/materialdialogs/internal/main/BaseSubLayout;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "onFinishInflate", "()V", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "requiredHeightForButtons", "()I", "", "Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "actionButtons", "[Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "getActionButtons", "()[Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "setActionButtons", "([Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;)V", "buttonFramePadding", "I", "buttonFramePaddingNeutral", "buttonFrameSpecHeight", "Landroidx/appcompat/widget/AppCompatCheckBox;", "checkBoxPrompt", "Landroidx/appcompat/widget/AppCompatCheckBox;", "getCheckBoxPrompt", "()Landroidx/appcompat/widget/AppCompatCheckBox;", "setCheckBoxPrompt", "(Landroidx/appcompat/widget/AppCompatCheckBox;)V", "checkBoxPromptMarginHorizontal", "checkBoxPromptMarginVertical", "stackButtons", "Z", "getStackButtons$core", "()Z", "setStackButtons$core", "(Z)V", "getVisibleButtons", "visibleButtons", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogActionButtonLayout extends BaseSubLayout {
    public static final int INDEX_NEGATIVE = 1;
    public static final int INDEX_NEUTRAL = 2;
    public static final int INDEX_POSITIVE = 0;
    public DialogActionButton[] actionButtons;
    private final int buttonFramePadding;
    private final int buttonFramePaddingNeutral;
    private final int buttonFrameSpecHeight;
    public AppCompatCheckBox checkBoxPrompt;
    private final int checkBoxPromptMarginHorizontal;
    private final int checkBoxPromptMarginVertical;
    private boolean stackButtons;

    public /* synthetic */ DialogActionButtonLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogActionButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "");
        this.buttonFramePadding = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_action_button_frame_padding) - MDUtil.INSTANCE.dimenPx(this, R.dimen.md_action_button_inset_horizontal);
        this.buttonFramePaddingNeutral = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_action_button_frame_padding_neutral);
        this.buttonFrameSpecHeight = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_action_button_frame_spec_height);
        this.checkBoxPromptMarginVertical = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_checkbox_prompt_margin_vertical);
        this.checkBoxPromptMarginHorizontal = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_checkbox_prompt_margin_horizontal);
    }

    @JvmName(name = "getStackButtons$core")
    /* renamed from: getStackButtons$core  reason: from getter */
    public final boolean getStackButtons() {
        return this.stackButtons;
    }

    @JvmName(name = "setStackButtons$core")
    public final void setStackButtons$core(boolean z) {
        this.stackButtons = z;
    }

    @JvmName(name = "getActionButtons")
    public final DialogActionButton[] getActionButtons() {
        DialogActionButton[] dialogActionButtonArr = this.actionButtons;
        if (dialogActionButtonArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return dialogActionButtonArr;
    }

    @JvmName(name = "setActionButtons")
    public final void setActionButtons(DialogActionButton[] dialogActionButtonArr) {
        Intrinsics.checkParameterIsNotNull(dialogActionButtonArr, "");
        this.actionButtons = dialogActionButtonArr;
    }

    @JvmName(name = "getCheckBoxPrompt")
    public final AppCompatCheckBox getCheckBoxPrompt() {
        AppCompatCheckBox appCompatCheckBox = this.checkBoxPrompt;
        if (appCompatCheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return appCompatCheckBox;
    }

    @JvmName(name = "setCheckBoxPrompt")
    public final void setCheckBoxPrompt(AppCompatCheckBox appCompatCheckBox) {
        Intrinsics.checkParameterIsNotNull(appCompatCheckBox, "");
        this.checkBoxPrompt = appCompatCheckBox;
    }

    @JvmName(name = "getVisibleButtons")
    public final DialogActionButton[] getVisibleButtons() {
        DialogActionButton[] dialogActionButtonArr = this.actionButtons;
        if (dialogActionButtonArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        ArrayList arrayList = new ArrayList();
        for (DialogActionButton dialogActionButton : dialogActionButtonArr) {
            if (ViewsKt.isVisible(dialogActionButton)) {
                arrayList.add(dialogActionButton);
            }
        }
        Object[] array = arrayList.toArray(new DialogActionButton[0]);
        if (array != null) {
            return (DialogActionButton[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.md_button_positive);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "");
        View findViewById2 = findViewById(R.id.md_button_negative);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "");
        View findViewById3 = findViewById(R.id.md_button_neutral);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "");
        this.actionButtons = new DialogActionButton[]{(DialogActionButton) findViewById, (DialogActionButton) findViewById2, (DialogActionButton) findViewById3};
        View findViewById4 = findViewById(R.id.md_checkbox_prompt);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "");
        this.checkBoxPrompt = (AppCompatCheckBox) findViewById4;
        DialogActionButton[] dialogActionButtonArr = this.actionButtons;
        if (dialogActionButtonArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        int length = dialogActionButtonArr.length;
        for (int i = 0; i < length; i++) {
            DialogActionButton dialogActionButton = dialogActionButtonArr[i];
            final WhichButton fromIndex = WhichButton.INSTANCE.fromIndex(i);
            dialogActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.afollestad.materialdialogs.internal.button.DialogActionButtonLayout$onFinishInflate$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogActionButtonLayout.this.getDialog().onActionButtonClicked$core(fromIndex);
                }
            });
        }
    }

    @Override // android.view.View
    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!DialogActionButtonLayoutKt.shouldBeVisible(this)) {
            setMeasuredDimension(0, 0);
            return;
        }
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        AppCompatCheckBox appCompatCheckBox = this.checkBoxPrompt;
        if (appCompatCheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (ViewsKt.isVisible(appCompatCheckBox)) {
            int i = this.checkBoxPromptMarginHorizontal;
            AppCompatCheckBox appCompatCheckBox2 = this.checkBoxPrompt;
            if (appCompatCheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            appCompatCheckBox2.measure(View.MeasureSpec.makeMeasureSpec(size - (i * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        Context context = getDialog().getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        Context windowContext = getDialog().getWindowContext();
        for (DialogActionButton dialogActionButton : getVisibleButtons()) {
            dialogActionButton.update$core(context, windowContext, this.stackButtons);
            if (this.stackButtons) {
                dialogActionButton.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.buttonFrameSpecHeight, 1073741824));
            } else {
                dialogActionButton.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(this.buttonFrameSpecHeight, 1073741824));
            }
        }
        if ((!(getVisibleButtons().length == 0)) != false && !this.stackButtons) {
            int i2 = 0;
            for (DialogActionButton dialogActionButton2 : getVisibleButtons()) {
                i2 += dialogActionButton2.getMeasuredWidth();
            }
            if (i2 >= size && !this.stackButtons) {
                this.stackButtons = true;
                for (DialogActionButton dialogActionButton3 : getVisibleButtons()) {
                    dialogActionButton3.update$core(context, windowContext, true);
                    dialogActionButton3.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(this.buttonFrameSpecHeight, 1073741824));
                }
            }
        }
        int requiredHeightForButtons = requiredHeightForButtons();
        AppCompatCheckBox appCompatCheckBox3 = this.checkBoxPrompt;
        if (appCompatCheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (ViewsKt.isVisible(appCompatCheckBox3)) {
            AppCompatCheckBox appCompatCheckBox4 = this.checkBoxPrompt;
            if (appCompatCheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            requiredHeightForButtons += appCompatCheckBox4.getMeasuredHeight() + (this.checkBoxPromptMarginVertical * 2);
        }
        setMeasuredDimension(size, requiredHeightForButtons);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        int i2;
        int measuredWidth;
        int measuredHeight;
        if (DialogActionButtonLayoutKt.shouldBeVisible(this)) {
            AppCompatCheckBox appCompatCheckBox = this.checkBoxPrompt;
            if (appCompatCheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (ViewsKt.isVisible(appCompatCheckBox)) {
                if (ViewsKt.isRtl(this)) {
                    measuredWidth = getMeasuredWidth() - this.checkBoxPromptMarginHorizontal;
                    i2 = this.checkBoxPromptMarginVertical;
                    AppCompatCheckBox appCompatCheckBox2 = this.checkBoxPrompt;
                    if (appCompatCheckBox2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    i = measuredWidth - appCompatCheckBox2.getMeasuredWidth();
                    AppCompatCheckBox appCompatCheckBox3 = this.checkBoxPrompt;
                    if (appCompatCheckBox3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    measuredHeight = appCompatCheckBox3.getMeasuredHeight();
                } else {
                    i = this.checkBoxPromptMarginHorizontal;
                    i2 = this.checkBoxPromptMarginVertical;
                    AppCompatCheckBox appCompatCheckBox4 = this.checkBoxPrompt;
                    if (appCompatCheckBox4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    measuredWidth = appCompatCheckBox4.getMeasuredWidth() + i;
                    AppCompatCheckBox appCompatCheckBox5 = this.checkBoxPrompt;
                    if (appCompatCheckBox5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    measuredHeight = appCompatCheckBox5.getMeasuredHeight();
                }
                AppCompatCheckBox appCompatCheckBox6 = this.checkBoxPrompt;
                if (appCompatCheckBox6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                appCompatCheckBox6.layout(i, i2, measuredWidth, measuredHeight + i2);
            }
            if (this.stackButtons) {
                int i3 = this.buttonFramePadding;
                int measuredWidth2 = getMeasuredWidth();
                int i4 = this.buttonFramePadding;
                int measuredHeight2 = getMeasuredHeight();
                for (DialogActionButton dialogActionButton : ArraysKt.reversed(getVisibleButtons())) {
                    int i5 = measuredHeight2 - this.buttonFrameSpecHeight;
                    dialogActionButton.layout(i3, i5, measuredWidth2 - i4, measuredHeight2);
                    measuredHeight2 = i5;
                }
                return;
            }
            int measuredHeight3 = getMeasuredHeight() - this.buttonFrameSpecHeight;
            int measuredHeight4 = getMeasuredHeight();
            if (ViewsKt.isRtl(this)) {
                DialogActionButton[] dialogActionButtonArr = this.actionButtons;
                if (dialogActionButtonArr == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                if (ViewsKt.isVisible(dialogActionButtonArr[2])) {
                    DialogActionButton[] dialogActionButtonArr2 = this.actionButtons;
                    if (dialogActionButtonArr2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    DialogActionButton dialogActionButton2 = dialogActionButtonArr2[2];
                    int measuredWidth3 = getMeasuredWidth() - this.buttonFramePaddingNeutral;
                    dialogActionButton2.layout(measuredWidth3 - dialogActionButton2.getMeasuredWidth(), measuredHeight3, measuredWidth3, measuredHeight4);
                }
                int i6 = this.buttonFramePadding;
                DialogActionButton[] dialogActionButtonArr3 = this.actionButtons;
                if (dialogActionButtonArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                if (ViewsKt.isVisible(dialogActionButtonArr3[0])) {
                    DialogActionButton[] dialogActionButtonArr4 = this.actionButtons;
                    if (dialogActionButtonArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    DialogActionButton dialogActionButton3 = dialogActionButtonArr4[0];
                    int measuredWidth4 = dialogActionButton3.getMeasuredWidth() + i6;
                    dialogActionButton3.layout(i6, measuredHeight3, measuredWidth4, measuredHeight4);
                    i6 = measuredWidth4;
                }
                DialogActionButton[] dialogActionButtonArr5 = this.actionButtons;
                if (dialogActionButtonArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                if (ViewsKt.isVisible(dialogActionButtonArr5[1])) {
                    DialogActionButton[] dialogActionButtonArr6 = this.actionButtons;
                    if (dialogActionButtonArr6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    DialogActionButton dialogActionButton4 = dialogActionButtonArr6[1];
                    dialogActionButton4.layout(i6, measuredHeight3, dialogActionButton4.getMeasuredWidth() + i6, measuredHeight4);
                    return;
                }
                return;
            }
            DialogActionButton[] dialogActionButtonArr7 = this.actionButtons;
            if (dialogActionButtonArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (ViewsKt.isVisible(dialogActionButtonArr7[2])) {
                DialogActionButton[] dialogActionButtonArr8 = this.actionButtons;
                if (dialogActionButtonArr8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                DialogActionButton dialogActionButton5 = dialogActionButtonArr8[2];
                int i7 = this.buttonFramePaddingNeutral;
                dialogActionButton5.layout(i7, measuredHeight3, dialogActionButton5.getMeasuredWidth() + i7, measuredHeight4);
            }
            int measuredWidth5 = getMeasuredWidth() - this.buttonFramePadding;
            DialogActionButton[] dialogActionButtonArr9 = this.actionButtons;
            if (dialogActionButtonArr9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (ViewsKt.isVisible(dialogActionButtonArr9[0])) {
                DialogActionButton[] dialogActionButtonArr10 = this.actionButtons;
                if (dialogActionButtonArr10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                DialogActionButton dialogActionButton6 = dialogActionButtonArr10[0];
                int measuredWidth6 = measuredWidth5 - dialogActionButton6.getMeasuredWidth();
                dialogActionButton6.layout(measuredWidth6, measuredHeight3, measuredWidth5, measuredHeight4);
                measuredWidth5 = measuredWidth6;
            }
            DialogActionButton[] dialogActionButtonArr11 = this.actionButtons;
            if (dialogActionButtonArr11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (ViewsKt.isVisible(dialogActionButtonArr11[1])) {
                DialogActionButton[] dialogActionButtonArr12 = this.actionButtons;
                if (dialogActionButtonArr12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                DialogActionButton dialogActionButton7 = dialogActionButtonArr12[1];
                dialogActionButton7.layout(measuredWidth5 - dialogActionButton7.getMeasuredWidth(), measuredHeight3, measuredWidth5, measuredHeight4);
            }
        }
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "");
        super.onDraw(canvas);
        if (getDrawDivider()) {
            canvas.drawLine(0.0f, 0.0f, getMeasuredWidth(), getDividerHeight(), dividerPaint());
        }
    }

    private final int requiredHeightForButtons() {
        if (getVisibleButtons().length == 0) {
            return 0;
        }
        if (this.stackButtons) {
            return this.buttonFrameSpecHeight * getVisibleButtons().length;
        }
        return this.buttonFrameSpecHeight;
    }
}
