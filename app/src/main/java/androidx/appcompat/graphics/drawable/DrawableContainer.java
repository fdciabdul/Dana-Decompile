package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.fullstory.instrumentation.FSDraw;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DrawableContainer extends Drawable implements Drawable.Callback, FSDraw {
    private Drawable GetContactSyncConfig;
    private Runnable KClassImpl$Data$declaredNonStaticMembers$2;
    private BlockInvalidateCallback MyBillsEntityDataFactory;
    private Rect NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Drawable getAuthRequestContext;
    private DrawableContainerState getErrorConfigVersion;
    private long lookAheadTest;
    private long moveToNextValue;
    private boolean scheduleImpl;
    private int BuiltInFictitiousFunctionClassFactory = 255;
    private int PlaceComponentResult = -1;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.GetContactSyncConfig;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.getErrorConfigVersion.getChangingConfigurations();
    }

    private boolean PlaceComponentResult() {
        return isAutoMirrored() && DrawableCompat.PlaceComponentResult(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect moveToNextValue = this.getErrorConfigVersion.moveToNextValue();
        if (moveToNextValue != null) {
            rect.set(moveToNextValue);
            padding = (moveToNextValue.right | ((moveToNextValue.left | moveToNextValue.top) | moveToNextValue.bottom)) != 0;
        } else {
            Drawable drawable = this.getAuthRequestContext;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (PlaceComponentResult()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.scheduleImpl && this.BuiltInFictitiousFunctionClassFactory == i) {
            return;
        }
        this.scheduleImpl = true;
        this.BuiltInFictitiousFunctionClassFactory = i;
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            if (this.moveToNextValue == 0) {
                drawable.setAlpha(i);
            } else {
                BuiltInFictitiousFunctionClassFactory(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.getErrorConfigVersion.newProxyInstance != z) {
            this.getErrorConfigVersion.newProxyInstance = z;
            Drawable drawable = this.getAuthRequestContext;
            if (drawable != null) {
                drawable.setDither(this.getErrorConfigVersion.newProxyInstance);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
        if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda2 != colorFilter) {
            this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda2 = colorFilter;
            Drawable drawable = this.getAuthRequestContext;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.getErrorConfigVersion.readMicros = true;
        if (this.getErrorConfigVersion.BottomSheetCardBindingView$watcherCardNumberView$1 != colorStateList) {
            this.getErrorConfigVersion.BottomSheetCardBindingView$watcherCardNumberView$1 = colorStateList;
            DrawableCompat.PlaceComponentResult(this.getAuthRequestContext, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.getErrorConfigVersion.whenAvailable = true;
        if (this.getErrorConfigVersion.VerifyPinStateManager$executeRiskChallenge$2$2 != mode) {
            this.getErrorConfigVersion.VerifyPinStateManager$executeRiskChallenge$2$2 = mode;
            DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.GetContactSyncConfig;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.getAuthRequestContext;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.getErrorConfigVersion.MyBillsEntityDataFactory != z) {
            this.getErrorConfigVersion.MyBillsEntityDataFactory = z;
            Drawable drawable = this.getAuthRequestContext;
            if (drawable != null) {
                DrawableCompat.BuiltInFictitiousFunctionClassFactory(drawable, this.getErrorConfigVersion.MyBillsEntityDataFactory);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.getErrorConfigVersion.MyBillsEntityDataFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.GetContactSyncConfig;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.GetContactSyncConfig = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.getAuthRequestContext;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.scheduleImpl) {
                this.getAuthRequestContext.setAlpha(this.BuiltInFictitiousFunctionClassFactory);
            }
        }
        if (this.lookAheadTest != 0) {
            this.lookAheadTest = 0L;
            z = true;
        }
        if (this.moveToNextValue != 0) {
            this.moveToNextValue = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            DrawableCompat.getAuthRequestContext(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (rect == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            DrawableCompat.getAuthRequestContext(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.GetContactSyncConfig;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.getAuthRequestContext;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.GetContactSyncConfig;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.getAuthRequestContext;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.getErrorConfigVersion.getAuthRequestContext(i, getAuthRequestContext());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            return this.getErrorConfigVersion.scheduleImpl();
        }
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            return this.getErrorConfigVersion.getErrorConfigVersion();
        }
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            return this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            return this.getErrorConfigVersion.lookAheadTest();
        }
        Drawable drawable = this.getAuthRequestContext;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        DrawableContainerState drawableContainerState = this.getErrorConfigVersion;
        if (drawableContainerState != null) {
            drawableContainerState.GetContactSyncConfig();
        }
        if (drawable != this.getAuthRequestContext || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.getAuthRequestContext || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.getAuthRequestContext || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.GetContactSyncConfig;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.getAuthRequestContext;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.getAuthRequestContext;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.getErrorConfigVersion.DatabaseTableConfigUtil();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAuthRequestContext() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i == this.PlaceComponentResult) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda4 > 0) {
            Drawable drawable = this.GetContactSyncConfig;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.getAuthRequestContext;
            if (drawable2 != null) {
                this.GetContactSyncConfig = drawable2;
                this.lookAheadTest = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda4 + uptimeMillis;
            } else {
                this.GetContactSyncConfig = null;
                this.lookAheadTest = 0L;
            }
        } else {
            Drawable drawable3 = this.getAuthRequestContext;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0 && i < this.getErrorConfigVersion.getCallingPid) {
            Drawable KClassImpl$Data$declaredNonStaticMembers$2 = this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(i);
            this.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
            this.PlaceComponentResult = i;
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda5 > 0) {
                    this.moveToNextValue = uptimeMillis + this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda5;
                }
                PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        } else {
            this.getAuthRequestContext = null;
            this.PlaceComponentResult = -1;
        }
        if (this.moveToNextValue != 0 || this.lookAheadTest != 0) {
            Runnable runnable = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (runnable == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: androidx.appcompat.graphics.drawable.DrawableContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableContainer.this.BuiltInFictitiousFunctionClassFactory(true);
                        DrawableContainer.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            BuiltInFictitiousFunctionClassFactory(true);
        }
        invalidateSelf();
        return true;
    }

    private void PlaceComponentResult(Drawable drawable) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new BlockInvalidateCallback();
        }
        BlockInvalidateCallback blockInvalidateCallback = this.MyBillsEntityDataFactory;
        blockInvalidateCallback.KClassImpl$Data$declaredNonStaticMembers$2 = drawable.getCallback();
        drawable.setCallback(blockInvalidateCallback);
        try {
            if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda5 <= 0 && this.scheduleImpl) {
                drawable.setAlpha(this.BuiltInFictitiousFunctionClassFactory);
            }
            if (this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                drawable.setColorFilter(this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda2);
            } else {
                if (this.getErrorConfigVersion.readMicros) {
                    DrawableCompat.PlaceComponentResult(drawable, this.getErrorConfigVersion.BottomSheetCardBindingView$watcherCardNumberView$1);
                }
                if (this.getErrorConfigVersion.whenAvailable) {
                    DrawableCompat.KClassImpl$Data$declaredNonStaticMembers$2(drawable, this.getErrorConfigVersion.VerifyPinStateManager$executeRiskChallenge$2$2);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.getErrorConfigVersion.newProxyInstance);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.getAuthRequestContext(drawable, DrawableCompat.PlaceComponentResult(this));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                DrawableCompat.BuiltInFictitiousFunctionClassFactory(drawable, this.getErrorConfigVersion.MyBillsEntityDataFactory);
            }
            Rect rect = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                DrawableCompat.getAuthRequestContext(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            BlockInvalidateCallback blockInvalidateCallback2 = this.MyBillsEntityDataFactory;
            Drawable.Callback callback = blockInvalidateCallback2.KClassImpl$Data$declaredNonStaticMembers$2;
            blockInvalidateCallback2.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            drawable.setCallback(callback);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void BuiltInFictitiousFunctionClassFactory(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.scheduleImpl = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.getAuthRequestContext
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.moveToNextValue
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L20
            int r9 = r13.BuiltInFictitiousFunctionClassFactory
            r3.setAlpha(r9)
            goto L38
        L20:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r9 = r13.getErrorConfigVersion
            int r9 = r9.NetworkUserEntityData$$ExternalSyntheticLambda5
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.getAuthRequestContext
            int r3 = 255 - r3
            int r10 = r13.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L3b
        L38:
            r13.moveToNextValue = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.GetContactSyncConfig
            if (r9 == 0) goto L65
            long r10 = r13.lookAheadTest
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r6, r6)
            r0 = 0
            r13.GetContactSyncConfig = r0
            goto L65
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r4 = r13.getErrorConfigVersion
            int r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.GetContactSyncConfig
            int r5 = r13.BuiltInFictitiousFunctionClassFactory
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L68
        L65:
            r13.lookAheadTest = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.KClassImpl$Data$declaredNonStaticMembers$2
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainer.BuiltInFictitiousFunctionClassFactory(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(Resources resources) {
        this.getErrorConfigVersion.PlaceComponentResult(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.getErrorConfigVersion.getAuthRequestContext(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.getErrorConfigVersion.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.getErrorConfigVersion.getAuthRequestContext()) {
            this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory = getChangingConfigurations();
            return this.getErrorConfigVersion;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 && super.mutate() == this) {
            DrawableContainerState BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        }
        return this;
    }

    DrawableContainerState BuiltInFictitiousFunctionClassFactory() {
        return this.getErrorConfigVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        final DrawableContainer A;
        boolean B;
        ColorStateList BottomSheetCardBindingView$watcherCardNumberView$1;
        int BuiltInFictitiousFunctionClassFactory;
        Resources C;
        boolean D;
        int DatabaseTableConfigUtil;
        SparseArray<Drawable.ConstantState> FragmentBottomSheetPaymentSettingBinding;
        int GetContactSyncConfig;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        int NetworkUserEntityData$$ExternalSyntheticLambda1;
        ColorFilter NetworkUserEntityData$$ExternalSyntheticLambda2;
        Drawable[] NetworkUserEntityData$$ExternalSyntheticLambda3;
        int NetworkUserEntityData$$ExternalSyntheticLambda4;
        int NetworkUserEntityData$$ExternalSyntheticLambda5;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
        int NetworkUserEntityData$$ExternalSyntheticLambda7;
        int NetworkUserEntityData$$ExternalSyntheticLambda8;
        Rect PrepareContext;
        boolean SubSequence;
        int VerifyPinStateManager$executeRiskChallenge$2$1;
        PorterDuff.Mode VerifyPinStateManager$executeRiskChallenge$2$2;
        int getCallingPid;
        boolean getErrorConfigVersion;
        int getSupportButtonTintMode;
        int initRecordTimeStamp;
        boolean isLayoutRequested;
        boolean lookAheadTest;
        boolean moveToNextValue;
        boolean newProxyInstance;
        boolean readMicros;
        boolean scheduleImpl;
        boolean whenAvailable;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainer drawableContainer, Resources resources) {
            Resources resources2;
            this.D = false;
            this.isLayoutRequested = false;
            this.newProxyInstance = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
            this.A = drawableContainer;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = drawableContainerState != null ? drawableContainerState.C : null;
            }
            this.C = resources2;
            int KClassImpl$Data$declaredNonStaticMembers$2 = DrawableContainer.KClassImpl$Data$declaredNonStaticMembers$2(resources, drawableContainerState != null ? drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda7 : 0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (drawableContainerState != null) {
                this.BuiltInFictitiousFunctionClassFactory = drawableContainerState.BuiltInFictitiousFunctionClassFactory;
                this.initRecordTimeStamp = drawableContainerState.initRecordTimeStamp;
                this.getErrorConfigVersion = true;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                this.D = drawableContainerState.D;
                this.isLayoutRequested = drawableContainerState.isLayoutRequested;
                this.newProxyInstance = drawableContainerState.newProxyInstance;
                this.SubSequence = drawableContainerState.SubSequence;
                this.getSupportButtonTintMode = drawableContainerState.getSupportButtonTintMode;
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda5;
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda4;
                this.MyBillsEntityDataFactory = drawableContainerState.MyBillsEntityDataFactory;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda2;
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda6;
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = drawableContainerState.BottomSheetCardBindingView$watcherCardNumberView$1;
                this.VerifyPinStateManager$executeRiskChallenge$2$2 = drawableContainerState.VerifyPinStateManager$executeRiskChallenge$2$2;
                this.readMicros = drawableContainerState.readMicros;
                this.whenAvailable = drawableContainerState.whenAvailable;
                if (drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda7 == KClassImpl$Data$declaredNonStaticMembers$2) {
                    if (drawableContainerState.scheduleImpl) {
                        this.PrepareContext = drawableContainerState.PrepareContext != null ? new Rect(drawableContainerState.PrepareContext) : null;
                        this.scheduleImpl = true;
                    }
                    if (drawableContainerState.lookAheadTest) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        this.DatabaseTableConfigUtil = drawableContainerState.DatabaseTableConfigUtil;
                        this.GetContactSyncConfig = drawableContainerState.GetContactSyncConfig;
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        this.lookAheadTest = true;
                    }
                }
                if (drawableContainerState.moveToNextValue) {
                    this.VerifyPinStateManager$executeRiskChallenge$2$1 = drawableContainerState.VerifyPinStateManager$executeRiskChallenge$2$1;
                    this.moveToNextValue = true;
                }
                if (drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    this.B = drawableContainerState.B;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
                Drawable[] drawableArr = drawableContainerState.NetworkUserEntityData$$ExternalSyntheticLambda3;
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new Drawable[drawableArr.length];
                this.getCallingPid = drawableContainerState.getCallingPid;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.FragmentBottomSheetPaymentSettingBinding;
                if (sparseArray != null) {
                    this.FragmentBottomSheetPaymentSettingBinding = sparseArray.clone();
                } else {
                    this.FragmentBottomSheetPaymentSettingBinding = new SparseArray<>(this.getCallingPid);
                }
                int i = this.getCallingPid;
                for (int i2 = 0; i2 < i; i2++) {
                    Drawable drawable = drawableArr[i2];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.FragmentBottomSheetPaymentSettingBinding.put(i2, constantState);
                        } else {
                            this.NetworkUserEntityData$$ExternalSyntheticLambda3[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new Drawable[10];
            this.getCallingPid = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.BuiltInFictitiousFunctionClassFactory | this.initRecordTimeStamp;
        }

        public final int PlaceComponentResult(Drawable drawable) {
            int i = this.getCallingPid;
            if (i >= this.NetworkUserEntityData$$ExternalSyntheticLambda3.length) {
                MyBillsEntityDataFactory(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.A);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3[i] = drawable;
            this.getCallingPid++;
            this.initRecordTimeStamp = drawable.getChangingConfigurations() | this.initRecordTimeStamp;
            GetContactSyncConfig();
            this.PrepareContext = null;
            this.scheduleImpl = false;
            this.lookAheadTest = false;
            this.getErrorConfigVersion = false;
            return i;
        }

        void GetContactSyncConfig() {
            this.moveToNextValue = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda3.length;
        }

        private void initRecordTimeStamp() {
            SparseArray<Drawable.ConstantState> sparseArray = this.FragmentBottomSheetPaymentSettingBinding;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda3[this.FragmentBottomSheetPaymentSettingBinding.keyAt(i)] = KClassImpl$Data$declaredNonStaticMembers$2(this.FragmentBottomSheetPaymentSettingBinding.valueAt(i).newDrawable(this.C));
                }
                this.FragmentBottomSheetPaymentSettingBinding = null;
            }
        }

        private Drawable KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.getAuthRequestContext(drawable, this.getSupportButtonTintMode);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.A);
            return mutate;
        }

        public final int MyBillsEntityDataFactory() {
            return this.getCallingPid;
        }

        public final Drawable KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            int indexOfKey;
            Drawable drawable = this.NetworkUserEntityData$$ExternalSyntheticLambda3[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.FragmentBottomSheetPaymentSettingBinding;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(this.FragmentBottomSheetPaymentSettingBinding.valueAt(indexOfKey).newDrawable(this.C));
            this.NetworkUserEntityData$$ExternalSyntheticLambda3[i] = KClassImpl$Data$declaredNonStaticMembers$2;
            this.FragmentBottomSheetPaymentSettingBinding.removeAt(indexOfKey);
            if (this.FragmentBottomSheetPaymentSettingBinding.size() == 0) {
                this.FragmentBottomSheetPaymentSettingBinding = null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        final boolean getAuthRequestContext(int i, int i2) {
            int i3 = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean authRequestContext = Build.VERSION.SDK_INT >= 23 ? DrawableCompat.getAuthRequestContext(drawableArr[i4], i) : false;
                    if (i4 == i2) {
                        z = authRequestContext;
                    }
                }
            }
            this.getSupportButtonTintMode = i;
            return z;
        }

        final void PlaceComponentResult(Resources resources) {
            if (resources != null) {
                this.C = resources;
                int KClassImpl$Data$declaredNonStaticMembers$2 = DrawableContainer.KClassImpl$Data$declaredNonStaticMembers$2(resources, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = KClassImpl$Data$declaredNonStaticMembers$2;
                if (i != KClassImpl$Data$declaredNonStaticMembers$2) {
                    this.lookAheadTest = false;
                    this.scheduleImpl = false;
                }
            }
        }

        final void getAuthRequestContext(Resources.Theme theme) {
            if (theme != null) {
                initRecordTimeStamp();
                int i = this.getCallingPid;
                Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                for (int i2 = 0; i2 < i; i2++) {
                    Drawable drawable = drawableArr[i2];
                    if (drawable != null && DrawableCompat.MyBillsEntityDataFactory(drawable)) {
                        DrawableCompat.BuiltInFictitiousFunctionClassFactory(drawableArr[i2], theme);
                        this.initRecordTimeStamp |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                PlaceComponentResult(Api21Impl.PlaceComponentResult(theme));
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (DrawableCompat.MyBillsEntityDataFactory(drawable)) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.FragmentBottomSheetPaymentSettingBinding.get(i2);
                    if (constantState != null && Api21Impl.MyBillsEntityDataFactory(constantState)) {
                        return true;
                    }
                }
            }
            return false;
        }

        void KClassImpl$Data$declaredNonStaticMembers$2() {
            int i = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.SubSequence = true;
        }

        public final void getAuthRequestContext(boolean z) {
            this.D = z;
        }

        public final Rect moveToNextValue() {
            Rect rect = null;
            if (this.D) {
                return null;
            }
            Rect rect2 = this.PrepareContext;
            if (rect2 != null || this.scheduleImpl) {
                return rect2;
            }
            initRecordTimeStamp();
            Rect rect3 = new Rect();
            int i = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    if (rect3.left > rect.left) {
                        rect.left = rect3.left;
                    }
                    if (rect3.top > rect.top) {
                        rect.top = rect3.top;
                    }
                    if (rect3.right > rect.right) {
                        rect.right = rect3.right;
                    }
                    if (rect3.bottom > rect.bottom) {
                        rect.bottom = rect3.bottom;
                    }
                }
            }
            this.scheduleImpl = true;
            this.PrepareContext = rect;
            return rect;
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
            this.isLayoutRequested = z;
        }

        public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
            return this.isLayoutRequested;
        }

        public final int scheduleImpl() {
            if (!this.lookAheadTest) {
                PlaceComponentResult();
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }

        public final int getErrorConfigVersion() {
            if (!this.lookAheadTest) {
                PlaceComponentResult();
            }
            return this.DatabaseTableConfigUtil;
        }

        public final int NetworkUserEntityData$$ExternalSyntheticLambda0() {
            if (!this.lookAheadTest) {
                PlaceComponentResult();
            }
            return this.GetContactSyncConfig;
        }

        public final int lookAheadTest() {
            if (!this.lookAheadTest) {
                PlaceComponentResult();
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }

        protected void PlaceComponentResult() {
            this.lookAheadTest = true;
            initRecordTimeStamp();
            int i = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            this.DatabaseTableConfigUtil = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = -1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
            this.GetContactSyncConfig = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.NetworkUserEntityData$$ExternalSyntheticLambda8) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.DatabaseTableConfigUtil) {
                    this.DatabaseTableConfigUtil = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.GetContactSyncConfig) {
                    this.GetContactSyncConfig = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1 = minimumHeight;
                }
            }
        }

        public final void PlaceComponentResult(int i) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = i;
        }

        public final void MyBillsEntityDataFactory(int i) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = i;
        }

        public final int DatabaseTableConfigUtil() {
            if (this.moveToNextValue) {
                return this.VerifyPinStateManager$executeRiskChallenge$2$1;
            }
            initRecordTimeStamp();
            int i = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.VerifyPinStateManager$executeRiskChallenge$2$1 = opacity;
            this.moveToNextValue = true;
            return opacity;
        }

        public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return this.B;
            }
            initRecordTimeStamp();
            int i = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            this.B = z;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            return z;
        }

        public void MyBillsEntityDataFactory(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            Drawable[] drawableArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = drawableArr;
        }

        public boolean getAuthRequestContext() {
            if (this.getErrorConfigVersion) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            initRecordTimeStamp();
            this.getErrorConfigVersion = true;
            int i = this.getCallingPid;
            Drawable[] drawableArr = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    return false;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult(DrawableContainerState drawableContainerState) {
        this.getErrorConfigVersion = drawableContainerState;
        int i = this.PlaceComponentResult;
        if (i >= 0) {
            Drawable KClassImpl$Data$declaredNonStaticMembers$2 = drawableContainerState.KClassImpl$Data$declaredNonStaticMembers$2(i);
            this.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        this.GetContactSyncConfig = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class BlockInvalidateCallback implements Drawable.Callback {
        Drawable.Callback KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        BlockInvalidateCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int KClassImpl$Data$declaredNonStaticMembers$2(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        return i == 0 ? BlobStatic.MONITOR_IMAGE_WIDTH : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean MyBillsEntityDataFactory(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static Resources PlaceComponentResult(Resources.Theme theme) {
            return theme.getResources();
        }
    }
}
