package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* loaded from: classes3.dex */
class AppCompatCheckedTextViewHelper {
    private boolean getAuthRequestContext;
    private final CheckedTextView lookAheadTest;
    private ColorStateList PlaceComponentResult = null;
    private PorterDuff.Mode BuiltInFictitiousFunctionClassFactory = null;
    private boolean MyBillsEntityDataFactory = false;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.lookAheadTest = checkedTextView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002f, B:11:0x0041, B:13:0x0049, B:15:0x0053, B:16:0x0060, B:18:0x0068, B:19:0x0073, B:21:0x007b), top: B:28:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002f, B:11:0x0041, B:13:0x0049, B:15:0x0053, B:16:0x0060, B:18:0x0068, B:19:0x0073, B:21:0x007b), top: B:28:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b A[Catch: all -> 0x0094, TRY_LEAVE, TryCatch #0 {all -> 0x0094, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002f, B:11:0x0041, B:13:0x0049, B:15:0x0053, B:16:0x0060, B:18:0x0068, B:19:0x0073, B:21:0x007b), top: B:28:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void KClassImpl$Data$declaredNonStaticMembers$2(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CheckedTextView r0 = r10.lookAheadTest
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.SizeSelectors$OrSelector
            r2 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.getAuthRequestContext(r0, r11, r1, r12, r2)
            android.widget.CheckedTextView r3 = r10.lookAheadTest
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R.styleable.SizeSelectors$OrSelector
            android.content.res.TypedArray r7 = r0.BuiltInFictitiousFunctionClassFactory
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.MyBillsEntityDataFactory(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R.styleable.r     // Catch: java.lang.Throwable -> L94
            boolean r11 = r0.getAuthRequestContext(r11)     // Catch: java.lang.Throwable -> L94
            if (r11 == 0) goto L3e
            int r11 = androidx.appcompat.R.styleable.r     // Catch: java.lang.Throwable -> L94
            android.content.res.TypedArray r12 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L94
            int r11 = r12.getResourceId(r11, r2)     // Catch: java.lang.Throwable -> L94
            if (r11 == 0) goto L3e
            android.widget.CheckedTextView r12 = r10.lookAheadTest     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L94
            android.content.Context r1 = r12.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L94
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.KClassImpl$Data$declaredNonStaticMembers$2(r1, r11)     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L94
            r12.setCheckMarkDrawable(r11)     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L94
            r11 = 1
            goto L3f
        L3e:
            r11 = 0
        L3f:
            if (r11 != 0) goto L60
            int r11 = androidx.appcompat.R.styleable.s     // Catch: java.lang.Throwable -> L94
            boolean r11 = r0.getAuthRequestContext(r11)     // Catch: java.lang.Throwable -> L94
            if (r11 == 0) goto L60
            int r11 = androidx.appcompat.R.styleable.s     // Catch: java.lang.Throwable -> L94
            android.content.res.TypedArray r12 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L94
            int r11 = r12.getResourceId(r11, r2)     // Catch: java.lang.Throwable -> L94
            if (r11 == 0) goto L60
            android.widget.CheckedTextView r12 = r10.lookAheadTest     // Catch: java.lang.Throwable -> L94
            android.content.Context r1 = r12.getContext()     // Catch: java.lang.Throwable -> L94
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.KClassImpl$Data$declaredNonStaticMembers$2(r1, r11)     // Catch: java.lang.Throwable -> L94
            r12.setCheckMarkDrawable(r11)     // Catch: java.lang.Throwable -> L94
        L60:
            int r11 = androidx.appcompat.R.styleable.q     // Catch: java.lang.Throwable -> L94
            boolean r11 = r0.getAuthRequestContext(r11)     // Catch: java.lang.Throwable -> L94
            if (r11 == 0) goto L73
            android.widget.CheckedTextView r11 = r10.lookAheadTest     // Catch: java.lang.Throwable -> L94
            int r12 = androidx.appcompat.R.styleable.q     // Catch: java.lang.Throwable -> L94
            android.content.res.ColorStateList r12 = r0.PlaceComponentResult(r12)     // Catch: java.lang.Throwable -> L94
            androidx.core.widget.CheckedTextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(r11, r12)     // Catch: java.lang.Throwable -> L94
        L73:
            int r11 = androidx.appcompat.R.styleable.t     // Catch: java.lang.Throwable -> L94
            boolean r11 = r0.getAuthRequestContext(r11)     // Catch: java.lang.Throwable -> L94
            if (r11 == 0) goto L8e
            android.widget.CheckedTextView r11 = r10.lookAheadTest     // Catch: java.lang.Throwable -> L94
            int r12 = androidx.appcompat.R.styleable.t     // Catch: java.lang.Throwable -> L94
            android.content.res.TypedArray r1 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L94
            r2 = -1
            int r12 = r1.getInt(r12, r2)     // Catch: java.lang.Throwable -> L94
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.DrawableUtils.MyBillsEntityDataFactory(r12, r1)     // Catch: java.lang.Throwable -> L94
            androidx.core.widget.CheckedTextViewCompat.BuiltInFictitiousFunctionClassFactory(r11, r12)     // Catch: java.lang.Throwable -> L94
        L8e:
            android.content.res.TypedArray r11 = r0.BuiltInFictitiousFunctionClassFactory
            r11.recycle()
            return
        L94:
            r11 = move-exception
            android.content.res.TypedArray r12 = r0.BuiltInFictitiousFunctionClassFactory
            r12.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextViewHelper.KClassImpl$Data$declaredNonStaticMembers$2(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(ColorStateList colorStateList) {
        this.PlaceComponentResult = colorStateList;
        this.MyBillsEntityDataFactory = true;
        getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult(PorterDuff.Mode mode) {
        this.BuiltInFictitiousFunctionClassFactory = mode;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult() {
        if (this.getAuthRequestContext) {
            this.getAuthRequestContext = false;
            return;
        }
        this.getAuthRequestContext = true;
        getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext() {
        Drawable MyBillsEntityDataFactory = CheckedTextViewCompat.MyBillsEntityDataFactory(this.lookAheadTest);
        if (MyBillsEntityDataFactory != null) {
            if (this.MyBillsEntityDataFactory || this.KClassImpl$Data$declaredNonStaticMembers$2) {
                Drawable mutate = DrawableCompat.scheduleImpl(MyBillsEntityDataFactory).mutate();
                if (this.MyBillsEntityDataFactory) {
                    DrawableCompat.PlaceComponentResult(mutate, this.PlaceComponentResult);
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(mutate, this.BuiltInFictitiousFunctionClassFactory);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.lookAheadTest.getDrawableState());
                }
                this.lookAheadTest.setCheckMarkDrawable(mutate);
            }
        }
    }
}
