package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.core.graphics.ColorUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static AppCompatDrawableManager BuiltInFictitiousFunctionClassFactory;
    private static final PorterDuff.Mode getAuthRequestContext = PorterDuff.Mode.SRC_IN;
    private ResourceManagerInternal PlaceComponentResult;

    public static void PlaceComponentResult() {
        synchronized (AppCompatDrawableManager.class) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                BuiltInFictitiousFunctionClassFactory = appCompatDrawableManager;
                appCompatDrawableManager.PlaceComponentResult = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2();
                ResourceManagerInternal resourceManagerInternal = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                ResourceManagerInternal.ResourceManagerHooks resourceManagerHooks = new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1
                    private final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {R.drawable.I, R.drawable.F, R.drawable.getAuthRequestContext};
                    private final int[] MyBillsEntityDataFactory = {R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda1, R.drawable.readMicros, R.drawable.newProxyInstance, R.drawable.isLayoutRequested, R.drawable.PrepareContext, R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda8, R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda7};
                    private final int[] BuiltInFictitiousFunctionClassFactory = {R.drawable.H, R.drawable.AppCompatEmojiTextHelper, R.drawable.GetContactSyncConfig, R.drawable.VerifyPinStateManager$executeRiskChallenge$2$2, R.drawable.D, R.drawable.getOnBoardingScenario, R.drawable.E};
                    private final int[] getAuthRequestContext = {R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda5, R.drawable.lookAheadTest, R.drawable.FragmentBottomSheetPaymentSettingBinding};
                    private final int[] moveToNextValue = {R.drawable.getValueOfTouchPositionAbsolute, R.drawable.G};
                    private final int[] PlaceComponentResult = {R.drawable.PlaceComponentResult, R.drawable.moveToNextValue, R.drawable.MyBillsEntityDataFactory, R.drawable.getErrorConfigVersion};

                    private ColorStateList getAuthRequestContext(Context context) {
                        return MyBillsEntityDataFactory(context, ThemeUtils.getAuthRequestContext(context, R.attr.FragmentBottomSheetPaymentSettingBinding));
                    }

                    private ColorStateList MyBillsEntityDataFactory(Context context) {
                        return MyBillsEntityDataFactory(context, 0);
                    }

                    private ColorStateList KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
                        return MyBillsEntityDataFactory(context, ThemeUtils.getAuthRequestContext(context, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda5));
                    }

                    private ColorStateList MyBillsEntityDataFactory(Context context, int i) {
                        int authRequestContext = ThemeUtils.getAuthRequestContext(context, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda6);
                        return new ColorStateList(new int[][]{ThemeUtils.BuiltInFictitiousFunctionClassFactory, ThemeUtils.NetworkUserEntityData$$ExternalSyntheticLambda0, ThemeUtils.KClassImpl$Data$declaredNonStaticMembers$2, ThemeUtils.getAuthRequestContext}, new int[]{ThemeUtils.MyBillsEntityDataFactory(context, R.attr.FragmentBottomSheetPaymentSettingBinding), ColorUtils.BuiltInFictitiousFunctionClassFactory(authRequestContext, i), ColorUtils.BuiltInFictitiousFunctionClassFactory(authRequestContext, i), i});
                    }

                    private ColorStateList BuiltInFictitiousFunctionClassFactory(Context context) {
                        int[][] iArr = new int[3];
                        int[] iArr2 = new int[3];
                        ColorStateList BuiltInFictitiousFunctionClassFactory2 = ThemeUtils.BuiltInFictitiousFunctionClassFactory(context, R.attr.getCallingPid);
                        if (BuiltInFictitiousFunctionClassFactory2 != null && BuiltInFictitiousFunctionClassFactory2.isStateful()) {
                            int[] iArr3 = ThemeUtils.BuiltInFictitiousFunctionClassFactory;
                            iArr[0] = iArr3;
                            iArr2[0] = BuiltInFictitiousFunctionClassFactory2.getColorForState(iArr3, 0);
                            iArr[1] = ThemeUtils.MyBillsEntityDataFactory;
                            iArr2[1] = ThemeUtils.getAuthRequestContext(context, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda3);
                            iArr[2] = ThemeUtils.getAuthRequestContext;
                            iArr2[2] = BuiltInFictitiousFunctionClassFactory2.getDefaultColor();
                        } else {
                            iArr[0] = ThemeUtils.BuiltInFictitiousFunctionClassFactory;
                            iArr2[0] = ThemeUtils.MyBillsEntityDataFactory(context, R.attr.getCallingPid);
                            iArr[1] = ThemeUtils.MyBillsEntityDataFactory;
                            iArr2[1] = ThemeUtils.getAuthRequestContext(context, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda3);
                            iArr[2] = ThemeUtils.getAuthRequestContext;
                            iArr2[2] = ThemeUtils.getAuthRequestContext(context, R.attr.getCallingPid);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public Drawable KClassImpl$Data$declaredNonStaticMembers$2(ResourceManagerInternal resourceManagerInternal2, Context context, int i) {
                        if (i == R.drawable.scheduleImpl) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal2.BuiltInFictitiousFunctionClassFactory(context, R.drawable.lookAheadTest), resourceManagerInternal2.BuiltInFictitiousFunctionClassFactory(context, R.drawable.GetContactSyncConfig)});
                        }
                        if (i == R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                            return getAuthRequestContext(resourceManagerInternal2, context, R.dimen.lookAheadTest);
                        }
                        if (i == R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda3) {
                            return getAuthRequestContext(resourceManagerInternal2, context, R.dimen.moveToNextValue);
                        }
                        if (i == R.drawable.SubSequence) {
                            return getAuthRequestContext(resourceManagerInternal2, context, R.dimen.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        }
                        return null;
                    }

                    private LayerDrawable getAuthRequestContext(ResourceManagerInternal resourceManagerInternal2, Context context, int i) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
                        Drawable BuiltInFictitiousFunctionClassFactory2 = resourceManagerInternal2.BuiltInFictitiousFunctionClassFactory(context, R.drawable.C);
                        Drawable BuiltInFictitiousFunctionClassFactory3 = resourceManagerInternal2.BuiltInFictitiousFunctionClassFactory(context, R.drawable.B);
                        if ((BuiltInFictitiousFunctionClassFactory2 instanceof BitmapDrawable) && BuiltInFictitiousFunctionClassFactory2.getIntrinsicWidth() == dimensionPixelSize && BuiltInFictitiousFunctionClassFactory2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable = (BitmapDrawable) BuiltInFictitiousFunctionClassFactory2;
                            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            BuiltInFictitiousFunctionClassFactory2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            BuiltInFictitiousFunctionClassFactory2.draw(canvas);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
                        if ((BuiltInFictitiousFunctionClassFactory3 instanceof BitmapDrawable) && BuiltInFictitiousFunctionClassFactory3.getIntrinsicWidth() == dimensionPixelSize && BuiltInFictitiousFunctionClassFactory3.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) BuiltInFictitiousFunctionClassFactory3;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            BuiltInFictitiousFunctionClassFactory3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            BuiltInFictitiousFunctionClassFactory3.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }

                    private void PlaceComponentResult(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (DrawableUtils.BuiltInFictitiousFunctionClassFactory(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = AppCompatDrawableManager.getAuthRequestContext;
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(i, mode));
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public boolean getAuthRequestContext(Context context, int i, Drawable drawable) {
                        if (i == R.drawable.getSupportButtonTintMode) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            PlaceComponentResult(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getAuthRequestContext(context, R.attr.whenAvailable), AppCompatDrawableManager.getAuthRequestContext);
                            PlaceComponentResult(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getAuthRequestContext(context, R.attr.whenAvailable), AppCompatDrawableManager.getAuthRequestContext);
                            PlaceComponentResult(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getAuthRequestContext(context, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda3), AppCompatDrawableManager.getAuthRequestContext);
                            return true;
                        } else if (i == R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda6 || i == R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda3 || i == R.drawable.SubSequence) {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            PlaceComponentResult(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.MyBillsEntityDataFactory(context, R.attr.whenAvailable), AppCompatDrawableManager.getAuthRequestContext);
                            PlaceComponentResult(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getAuthRequestContext(context, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda3), AppCompatDrawableManager.getAuthRequestContext);
                            PlaceComponentResult(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getAuthRequestContext(context, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda3), AppCompatDrawableManager.getAuthRequestContext);
                            return true;
                        } else {
                            return false;
                        }
                    }

                    private boolean BuiltInFictitiousFunctionClassFactory(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public ColorStateList PlaceComponentResult(Context context, int i) {
                        if (i == R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                            return AppCompatResources.getAuthRequestContext(context, R.color.MyBillsEntityDataFactory);
                        }
                        if (i == R.drawable.BottomSheetCardBindingView$watcherCardNumberView$1) {
                            return AppCompatResources.getAuthRequestContext(context, R.color.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        }
                        if (i == R.drawable.VerifyPinStateManager$executeRiskChallenge$2$1) {
                            return BuiltInFictitiousFunctionClassFactory(context);
                        }
                        if (i == R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                            return getAuthRequestContext(context);
                        }
                        if (i == R.drawable.KClassImpl$Data$declaredNonStaticMembers$2) {
                            return MyBillsEntityDataFactory(context);
                        }
                        if (i == R.drawable.BuiltInFictitiousFunctionClassFactory) {
                            return KClassImpl$Data$declaredNonStaticMembers$2(context);
                        }
                        if (i == R.drawable.getCallingPid || i == R.drawable.A) {
                            return AppCompatResources.getAuthRequestContext(context, R.color.scheduleImpl);
                        }
                        if (BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, i)) {
                            return ThemeUtils.BuiltInFictitiousFunctionClassFactory(context, R.attr.whenAvailable);
                        }
                        if (BuiltInFictitiousFunctionClassFactory(this.moveToNextValue, i)) {
                            return AppCompatResources.getAuthRequestContext(context, R.color.KClassImpl$Data$declaredNonStaticMembers$2);
                        }
                        if (BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, i)) {
                            return AppCompatResources.getAuthRequestContext(context, R.color.getAuthRequestContext);
                        }
                        if (i == R.drawable.whenAvailable) {
                            return AppCompatResources.getAuthRequestContext(context, R.color.moveToNextValue);
                        }
                        return null;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:48:0x0047  */
                    /* JADX WARN: Removed duplicated region for block: B:55:0x0062 A[RETURN] */
                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public boolean PlaceComponentResult(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.getAuthRequestContext()
                            int[] r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2
                            boolean r1 = r6.BuiltInFictitiousFunctionClassFactory(r1, r8)
                            r2 = 1
                            r3 = 16842801(0x1010031, float:2.3693695E-38)
                            r4 = 0
                            r5 = -1
                            if (r1 == 0) goto L15
                            int r3 = androidx.appcompat.R.attr.whenAvailable
                            goto L3e
                        L15:
                            int[] r1 = r6.BuiltInFictitiousFunctionClassFactory
                            boolean r1 = r6.BuiltInFictitiousFunctionClassFactory(r1, r8)
                            if (r1 == 0) goto L20
                            int r3 = androidx.appcompat.R.attr.NetworkUserEntityData$$ExternalSyntheticLambda3
                            goto L3e
                        L20:
                            int[] r1 = r6.getAuthRequestContext
                            boolean r1 = r6.BuiltInFictitiousFunctionClassFactory(r1, r8)
                            if (r1 == 0) goto L2b
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L3e
                        L2b:
                            int r1 = androidx.appcompat.R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda4
                            if (r8 != r1) goto L3a
                            r8 = 16842800(0x1010030, float:2.3693693E-38)
                            r1 = 1109603123(0x42233333, float:40.8)
                            int r1 = java.lang.Math.round(r1)
                            goto L40
                        L3a:
                            int r1 = androidx.appcompat.R.drawable.DatabaseTableConfigUtil
                            if (r8 != r1) goto L42
                        L3e:
                            r8 = r3
                            r1 = -1
                        L40:
                            r3 = 1
                            goto L45
                        L42:
                            r8 = 0
                            r1 = -1
                            r3 = 0
                        L45:
                            if (r3 == 0) goto L62
                            boolean r3 = androidx.appcompat.widget.DrawableUtils.BuiltInFictitiousFunctionClassFactory(r9)
                            if (r3 == 0) goto L51
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L51:
                            int r7 = androidx.appcompat.widget.ThemeUtils.getAuthRequestContext(r7, r8)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(r7, r0)
                            r9.setColorFilter(r7)
                            if (r1 == r5) goto L61
                            r9.setAlpha(r1)
                        L61:
                            return r2
                        L62:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.PlaceComponentResult(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public PorterDuff.Mode KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                        if (i == R.drawable.VerifyPinStateManager$executeRiskChallenge$2$1) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                };
                synchronized (resourceManagerInternal) {
                    resourceManagerInternal.MyBillsEntityDataFactory = resourceManagerHooks;
                }
            }
        }
    }

    public static AppCompatDrawableManager KClassImpl$Data$declaredNonStaticMembers$2() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult();
            }
            appCompatDrawableManager = BuiltInFictitiousFunctionClassFactory;
        }
        return appCompatDrawableManager;
    }

    public final Drawable getAuthRequestContext(Context context, int i) {
        Drawable BuiltInFictitiousFunctionClassFactory2;
        synchronized (this) {
            BuiltInFictitiousFunctionClassFactory2 = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(context, i);
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    public final Drawable MyBillsEntityDataFactory(Context context, int i, boolean z) {
        Drawable PlaceComponentResult;
        synchronized (this) {
            PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(context, i, z);
        }
        return PlaceComponentResult;
    }

    public final void BuiltInFictitiousFunctionClassFactory(Context context) {
        synchronized (this) {
            ResourceManagerInternal resourceManagerInternal = this.PlaceComponentResult;
            synchronized (resourceManagerInternal) {
                LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = resourceManagerInternal.PlaceComponentResult.get(context);
                if (longSparseArray != null) {
                    longSparseArray.getAuthRequestContext();
                }
            }
        }
    }

    public final ColorStateList PlaceComponentResult(Context context, int i) {
        ColorStateList MyBillsEntityDataFactory;
        synchronized (this) {
            MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory(context, i);
        }
        return MyBillsEntityDataFactory;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2(drawable, tintInfo, iArr);
    }

    public static PorterDuffColorFilter BuiltInFictitiousFunctionClassFactory(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter PlaceComponentResult;
        synchronized (AppCompatDrawableManager.class) {
            PlaceComponentResult = ResourceManagerInternal.PlaceComponentResult(i, mode);
        }
        return PlaceComponentResult;
    }
}
