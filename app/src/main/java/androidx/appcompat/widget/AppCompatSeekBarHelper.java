package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private Drawable NetworkUserEntityData$$ExternalSyntheticLambda0;
    private PorterDuff.Mode getErrorConfigVersion;
    private boolean lookAheadTest;
    private ColorStateList moveToNextValue;
    private final SeekBar scheduleImpl;
    public static final byte[] PlaceComponentResult = {Ascii.DC4, -68, -64, 70, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 91;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.moveToNextValue = null;
        this.getErrorConfigVersion = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.lookAheadTest = false;
        this.scheduleImpl = seekBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet, int i) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i);
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(this.scheduleImpl.getContext(), attributeSet, R.styleable.J, i, 0);
        SeekBar seekBar = this.scheduleImpl;
        ViewCompat.MyBillsEntityDataFactory(seekBar, seekBar.getContext(), R.styleable.J, attributeSet, authRequestContext.BuiltInFictitiousFunctionClassFactory, i, 0);
        Drawable MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory(R.styleable.K);
        if (MyBillsEntityDataFactory != null) {
            this.scheduleImpl.setThumb(MyBillsEntityDataFactory);
        }
        BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory(authRequestContext, R.styleable.M));
        if (authRequestContext.getAuthRequestContext(R.styleable.P)) {
            this.getErrorConfigVersion = DrawableUtils.MyBillsEntityDataFactory(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.P, -1), this.getErrorConfigVersion);
            this.lookAheadTest = true;
        }
        if (authRequestContext.getAuthRequestContext(R.styleable.N)) {
            this.moveToNextValue = authRequestContext.PlaceComponentResult(R.styleable.N);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        PlaceComponentResult();
    }

    void BuiltInFictitiousFunctionClassFactory(Drawable drawable) {
        Drawable drawable2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = drawable;
        if (drawable != null) {
            drawable.setCallback(this.scheduleImpl);
            DrawableCompat.getAuthRequestContext(drawable, ViewCompat.initRecordTimeStamp(this.scheduleImpl));
            if (drawable.isStateful()) {
                drawable.setState(this.scheduleImpl.getDrawableState());
            }
            PlaceComponentResult();
        }
        this.scheduleImpl.invalidate();
    }

    private void PlaceComponentResult() {
        Drawable drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (drawable != null) {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 || this.lookAheadTest) {
                Drawable scheduleImpl = DrawableCompat.scheduleImpl(drawable.mutate());
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = scheduleImpl;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    DrawableCompat.PlaceComponentResult(scheduleImpl, this.moveToNextValue);
                }
                if (this.lookAheadTest) {
                    DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.getErrorConfigVersion);
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.isStateful()) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.setState(this.scheduleImpl.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory() {
        Drawable drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        Drawable drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.scheduleImpl.getDrawableState())) {
            this.scheduleImpl.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(Canvas canvas) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            int max = this.scheduleImpl.getMax();
            if (max > 1) {
                int intrinsicWidth = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getIntrinsicWidth();
                int intrinsicHeight = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.setBounds(-i, -i2, i, i2);
                float width = ((this.scheduleImpl.getWidth() - this.scheduleImpl.getPaddingLeft()) - this.scheduleImpl.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.scheduleImpl.getPaddingLeft(), this.scheduleImpl.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x0048). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable MyBillsEntityDataFactory(androidx.appcompat.widget.TintTypedArray r10, int r11) {
        /*
            byte[] r0 = androidx.appcompat.widget.AppCompatSeekBarHelper.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 97
            r4 = 0
            r5 = 3
            if (r0 != 0) goto L17
            r5 = r1
            r6 = 3
            r7 = 0
            r8 = 22
            r1 = r0
            r0 = r11
            r11 = r10
            goto L48
        L17:
            r3 = r1
            r5 = 97
            r6 = 3
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1f:
            int r6 = r6 + 1
            byte r8 = (byte) r5
            r3[r7] = r8
            if (r7 != r2) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3c
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3c:
            android.graphics.drawable.Drawable r10 = r11.BuiltInFictitiousFunctionClassFactory(r0)
            return r10
        L41:
            r8 = r1[r6]
            int r7 = r7 + 1
            r9 = r5
            r5 = r3
            r3 = r9
        L48:
            int r3 = r3 + r8
            int r3 = r3 + (-8)
            r9 = r5
            r5 = r3
            r3 = r9
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSeekBarHelper.MyBillsEntityDataFactory(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
