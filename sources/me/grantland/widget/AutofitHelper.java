package me.grantland.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class AutofitHelper {
    private static final int DEFAULT_MIN_TEXT_SIZE = 8;
    private static final float DEFAULT_PRECISION = 0.5f;
    private static final boolean SPEW = false;
    private static final String TAG = "AutoFitTextHelper";
    private boolean mEnabled;
    private boolean mIsAutofitting;
    private ArrayList<OnTextSizeChangeListener> mListeners;
    private int mMaxLines;
    private float mMaxTextSize;
    private float mMinTextSize;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private TextPaint mPaint;
    private float mPrecision;
    private float mTextSize;
    private TextView mTextView;
    private TextWatcher mTextWatcher;

    /* loaded from: classes9.dex */
    public interface OnTextSizeChangeListener {
        void onTextSizeChange(float f, float f2);
    }

    public static AutofitHelper create(TextView textView) {
        return create(textView, null, 0);
    }

    public static AutofitHelper create(TextView textView, AttributeSet attributeSet) {
        return create(textView, attributeSet, 0);
    }

    public static AutofitHelper create(TextView textView, AttributeSet attributeSet, int i) {
        AutofitHelper autofitHelper = new AutofitHelper(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            int minTextSize = (int) autofitHelper.getMinTextSize();
            float precision = autofitHelper.getPrecision();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutofitTextView, i, 0);
            z = obtainStyledAttributes.getBoolean(R.styleable.AutofitTextView_sizeToFit, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AutofitTextView_minTextSize, minTextSize);
            float f = obtainStyledAttributes.getFloat(R.styleable.AutofitTextView_precision, precision);
            obtainStyledAttributes.recycle();
            autofitHelper.setMinTextSize(0, dimensionPixelSize).setPrecision(f);
        }
        autofitHelper.setEnabled(z);
        return autofitHelper;
    }

    private static void autofit(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        int width;
        if (i <= 0 || i == Integer.MAX_VALUE || (width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()) <= 0) {
            return;
        }
        CharSequence text = textView.getText();
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            text = transformationMethod.getTransformation(text, textView);
        }
        Context context = textView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        DisplayMetrics displayMetrics = system.getDisplayMetrics();
        textPaint.set(textView.getPaint());
        textPaint.setTextSize(f2);
        float autofitTextSize = ((i != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) && getLineCount(text, textPaint, f2, (float) width, displayMetrics) <= i) ? f2 : getAutofitTextSize(text, textPaint, width, i, 0.0f, f2, f3, displayMetrics);
        if (autofitTextSize < f) {
            autofitTextSize = f;
        }
        textView.setTextSize(0, autofitTextSize);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r16v1 ??, still in use, count: 1, list:
          (r16v1 ?? I:android.text.Layout) from 0x0033: INVOKE (r7v4 ?? I:int) = (r16v1 ?? I:android.text.Layout) type: VIRTUAL call: android.text.Layout.getLineCount():int A[MD:():int (c)] (LINE:154)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:89)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:88)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    private static float getAutofitTextSize(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r16v1 ??, still in use, count: 1, list:
          (r16v1 ?? I:android.text.Layout) from 0x0033: INVOKE (r7v4 ?? I:int) = (r16v1 ?? I:android.text.Layout) type: VIRTUAL call: android.text.Layout.getLineCount():int A[MD:():int (c)] (LINE:154)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:89)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:88)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r18v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:233)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    private static int getLineCount(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    private static int getMaxLines(TextView textView) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod == null || !(transformationMethod instanceof SingleLineTransformationMethod)) {
            if (Build.VERSION.SDK_INT >= 16) {
                return textView.getMaxLines();
            }
            return -1;
        }
        return 1;
    }

    private AutofitHelper(TextView textView) {
        this.mTextWatcher = new AutofitTextWatcher();
        this.mOnLayoutChangeListener = new AutofitOnLayoutChangeListener();
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.mTextView = textView;
        this.mPaint = new TextPaint();
        setRawTextSize(textView.getTextSize());
        this.mMaxLines = getMaxLines(textView);
        this.mMinTextSize = f * 8.0f;
        this.mMaxTextSize = this.mTextSize;
        this.mPrecision = DEFAULT_PRECISION;
    }

    public AutofitHelper addOnTextSizeChangeListener(OnTextSizeChangeListener onTextSizeChangeListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(onTextSizeChangeListener);
        return this;
    }

    public AutofitHelper removeOnTextSizeChangeListener(OnTextSizeChangeListener onTextSizeChangeListener) {
        ArrayList<OnTextSizeChangeListener> arrayList = this.mListeners;
        if (arrayList != null) {
            arrayList.remove(onTextSizeChangeListener);
        }
        return this;
    }

    public float getPrecision() {
        return this.mPrecision;
    }

    public AutofitHelper setPrecision(float f) {
        if (this.mPrecision != f) {
            this.mPrecision = f;
            autofit();
        }
        return this;
    }

    public float getMinTextSize() {
        return this.mMinTextSize;
    }

    public AutofitHelper setMinTextSize(float f) {
        return setMinTextSize(2, f);
    }

    public AutofitHelper setMinTextSize(int i, float f) {
        Context context = this.mTextView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        setRawMinTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    private void setRawMinTextSize(float f) {
        if (f != this.mMinTextSize) {
            this.mMinTextSize = f;
            autofit();
        }
    }

    public float getMaxTextSize() {
        return this.mMaxTextSize;
    }

    public AutofitHelper setMaxTextSize(float f) {
        return setMaxTextSize(2, f);
    }

    public AutofitHelper setMaxTextSize(int i, float f) {
        Context context = this.mTextView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        setRawMaxTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    private void setRawMaxTextSize(float f) {
        if (f != this.mMaxTextSize) {
            this.mMaxTextSize = f;
            autofit();
        }
    }

    public int getMaxLines() {
        return this.mMaxLines;
    }

    public AutofitHelper setMaxLines(int i) {
        if (this.mMaxLines != i) {
            this.mMaxLines = i;
            autofit();
        }
        return this;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public AutofitHelper setEnabled(boolean z) {
        if (this.mEnabled != z) {
            this.mEnabled = z;
            if (z) {
                this.mTextView.addTextChangedListener(this.mTextWatcher);
                this.mTextView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
                autofit();
            } else {
                this.mTextView.removeTextChangedListener(this.mTextWatcher);
                this.mTextView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
                this.mTextView.setTextSize(0, this.mTextSize);
            }
        }
        return this;
    }

    public float getTextSize() {
        return this.mTextSize;
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public void setTextSize(int i, float f) {
        if (this.mIsAutofitting) {
            return;
        }
        Context context = this.mTextView.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void setRawTextSize(float f) {
        if (this.mTextSize != f) {
            this.mTextSize = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autofit() {
        float textSize = this.mTextView.getTextSize();
        this.mIsAutofitting = true;
        autofit(this.mTextView, this.mPaint, this.mMinTextSize, this.mMaxTextSize, this.mMaxLines, this.mPrecision);
        this.mIsAutofitting = false;
        float textSize2 = this.mTextView.getTextSize();
        if (textSize2 != textSize) {
            sendTextSizeChange(textSize2, textSize);
        }
    }

    private void sendTextSizeChange(float f, float f2) {
        ArrayList<OnTextSizeChangeListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return;
        }
        Iterator<OnTextSizeChangeListener> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onTextSizeChange(f, f2);
        }
    }

    /* loaded from: classes9.dex */
    class AutofitTextWatcher implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private AutofitTextWatcher() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AutofitHelper.this.autofit();
        }
    }

    /* loaded from: classes9.dex */
    class AutofitOnLayoutChangeListener implements View.OnLayoutChangeListener {
        private AutofitOnLayoutChangeListener() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AutofitHelper.this.autofit();
        }
    }
}
