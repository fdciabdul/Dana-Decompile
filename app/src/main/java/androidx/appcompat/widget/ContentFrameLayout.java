package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    private TypedValue BuiltInFictitiousFunctionClassFactory;
    private OnAttachListener KClassImpl$Data$declaredNonStaticMembers$2;
    private TypedValue MyBillsEntityDataFactory;
    private TypedValue PlaceComponentResult;
    private final Rect getAuthRequestContext;
    private TypedValue getErrorConfigVersion;
    private TypedValue lookAheadTest;
    private TypedValue scheduleImpl;

    /* loaded from: classes.dex */
    public interface OnAttachListener {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = new Rect();
    }

    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onAttachListener;
    }

    public void setDecorPadding(int i, int i2, int i3, int i4) {
        this.getAuthRequestContext.set(i, i2, i3, i4);
        if (ViewCompat.getValueOfTouchPositionAbsolute(this)) {
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.getErrorConfigVersion == null) {
            this.getErrorConfigVersion = new TypedValue();
        }
        return this.getErrorConfigVersion;
    }

    public TypedValue getMinWidthMinor() {
        if (this.lookAheadTest == null) {
            this.lookAheadTest = new TypedValue();
        }
        return this.lookAheadTest;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new TypedValue();
        }
        return this.PlaceComponentResult;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.scheduleImpl == null) {
            this.scheduleImpl = new TypedValue();
        }
        return this.scheduleImpl;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new TypedValue();
        }
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new TypedValue();
        }
        return this.MyBillsEntityDataFactory;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onAttachListener != null) {
            onAttachListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onAttachListener != null) {
            onAttachListener.PlaceComponentResult();
        }
    }
}
