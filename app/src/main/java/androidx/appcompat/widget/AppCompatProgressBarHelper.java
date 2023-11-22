package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
class AppCompatProgressBarHelper {
    private final ProgressBar BuiltInFictitiousFunctionClassFactory;
    private Bitmap PlaceComponentResult;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_DIR, -98, 98, -100, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 64;
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {16843067, 16843068};

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.BuiltInFictitiousFunctionClassFactory = progressBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(AttributeSet attributeSet, int i) {
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.getContext(), attributeSet, KClassImpl$Data$declaredNonStaticMembers$2, i, 0);
        Drawable MyBillsEntityDataFactory2 = authRequestContext.MyBillsEntityDataFactory(0);
        if (MyBillsEntityDataFactory2 != null) {
            this.BuiltInFictitiousFunctionClassFactory.setIndeterminateDrawable(MyBillsEntityDataFactory(MyBillsEntityDataFactory2));
        }
        Drawable MyBillsEntityDataFactory3 = authRequestContext.MyBillsEntityDataFactory(1);
        if (MyBillsEntityDataFactory3 != null) {
            this.BuiltInFictitiousFunctionClassFactory.setProgressDrawable(getAuthRequestContext(MyBillsEntityDataFactory3, false));
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
    }

    Drawable getAuthRequestContext(Drawable drawable, boolean z) {
        if (drawable instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable;
            Drawable PlaceComponentResult = wrappedDrawable.PlaceComponentResult();
            if (PlaceComponentResult != null) {
                wrappedDrawable.PlaceComponentResult(getAuthRequestContext(PlaceComponentResult, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id2 = layerDrawable.getId(i);
                drawableArr[i] = getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(layerDrawable, i), id2 == 16908301 || id2 == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
                if (Build.VERSION.SDK_INT >= 23) {
                    Api23Impl.BuiltInFictitiousFunctionClassFactory(layerDrawable, layerDrawable2, i2);
                }
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(MyBillsEntityDataFactory());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable MyBillsEntityDataFactory(Drawable drawable) {
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            AnimationDrawable animationDrawable2 = new AnimationDrawable();
            animationDrawable2.setOneShot(animationDrawable.isOneShot());
            for (int i = 0; i < numberOfFrames; i++) {
                Drawable authRequestContext = getAuthRequestContext(animationDrawable.getFrame(i), true);
                authRequestContext.setLevel(10000);
                animationDrawable2.addFrame(authRequestContext, animationDrawable.getDuration(i));
            }
            animationDrawable2.setLevel(10000);
            return animationDrawable2;
        }
        return drawable;
    }

    private Shape MyBillsEntityDataFactory() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap getAuthRequestContext() {
        return this.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(LayerDrawable layerDrawable, LayerDrawable layerDrawable2, int i) {
            layerDrawable2.setLayerGravity(i, layerDrawable.getLayerGravity(i));
            layerDrawable2.setLayerWidth(i, layerDrawable.getLayerWidth(i));
            layerDrawable2.setLayerHeight(i, layerDrawable.getLayerHeight(i));
            layerDrawable2.setLayerInsetLeft(i, layerDrawable.getLayerInsetLeft(i));
            layerDrawable2.setLayerInsetRight(i, layerDrawable.getLayerInsetRight(i));
            layerDrawable2.setLayerInsetTop(i, layerDrawable.getLayerInsetTop(i));
            layerDrawable2.setLayerInsetBottom(i, layerDrawable.getLayerInsetBottom(i));
            layerDrawable2.setLayerInsetStart(i, layerDrawable.getLayerInsetStart(i));
            layerDrawable2.setLayerInsetEnd(i, layerDrawable.getLayerInsetEnd(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable KClassImpl$Data$declaredNonStaticMembers$2(android.graphics.drawable.LayerDrawable r11, int r12) {
        /*
            byte[] r0 = androidx.appcompat.widget.AppCompatProgressBarHelper.getAuthRequestContext
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = 3
            if (r0 != 0) goto L13
            r5 = r2
            r6 = 3
            r7 = 23
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L44
        L13:
            r5 = 97
            r4 = r2
            r6 = 3
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1b:
            byte r8 = (byte) r5
            int r9 = r7 + 1
            r4[r7] = r8
            int r6 = r6 + 1
            if (r9 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            r7 = r2[r6]
            r10 = r5
            r5 = r4
            r4 = r10
        L44:
            int r4 = r4 + r7
            int r4 = r4 + (-8)
            r7 = r9
            r10 = r5
            r5 = r4
            r4 = r10
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatProgressBarHelper.KClassImpl$Data$declaredNonStaticMembers$2(android.graphics.drawable.LayerDrawable, int):android.graphics.drawable.Drawable");
    }
}
