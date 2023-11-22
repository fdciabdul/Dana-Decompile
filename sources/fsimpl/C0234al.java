package fsimpl;

import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.LayerDrawable;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.FSDraw;
import com.fullstory.instrumentation.frameworks.compose.FSComposeDraw;
import com.fullstory.util.Log;
import com.google.common.base.Ascii;

/* renamed from: fsimpl.al  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0234al {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f7855a;
    private aP b;
    private boolean c;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {38, -105, 32, Ascii.RS, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int BuiltInFictitiousFunctionClassFactory = 89;

    public C0234al(aP aPVar, C0230ah c0230ah) {
        this.b = aPVar;
        this.c = c0230ah != null && c0230ah.o();
    }

    private static Drawable a(Drawable drawable) {
        while (drawable instanceof DrawableContainer) {
            drawable = ((DrawableContainer) drawable).getCurrent();
        }
        return drawable;
    }

    private TextureView a(View view) {
        if (this.c && (view instanceof TextureView)) {
            String name = view.getClass().getName();
            if (name.startsWith("com.google.") && name.contains(".maps.")) {
                return (TextureView) view;
            }
        }
        return null;
    }

    private boolean a(View view, C0223aa c0223aa) {
        if (view instanceof ImageView) {
            Drawable a2 = a(((ImageView) view).getDrawable());
            if (a2 instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) a2;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                boolean z = false;
                for (int i = 0; i < numberOfLayers; i++) {
                    Drawable drawable = layerDrawable.getDrawable(i);
                    if (fd.a(drawable)) {
                        c0223aa.a(drawable, view, false);
                        z = true;
                    }
                }
                if (z) {
                    return true;
                }
            }
            if (fd.a(a2)) {
                c0223aa.a(a2, view, false);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            byte[] r0 = fsimpl.C0234al.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = 106 - r8
            int r7 = r7 * 2
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r7
            goto L38
        L18:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r6 = r6 + r7
            int r6 = r6 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: fsimpl.C0234al.d(int, byte, short, java.lang.Object[]):void");
    }

    public int a(View view, RectF rectF, C0367q c0367q, C0223aa c0223aa, O o2, C0275bz c0275bz) {
        Drawable drawable;
        TextView textView;
        Drawable[] compoundDrawables;
        C0350eu.a("renderView", new Object[0]);
        c0223aa.a(view, rectF, c0367q.e(view));
        Drawable a2 = a(view.getBackground());
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        boolean z = ((scrollX | scrollY) == 0 || a2 == null) ? false : true;
        if (z) {
            c0223aa.translate(scrollX, scrollY);
        }
        if (fd.a(a2)) {
            c0223aa.a(a2, view, true);
        } else if (a2 != null) {
            a2.draw(c0223aa);
        }
        if (z) {
            c0223aa.translate(-scrollX, -scrollY);
        }
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr = new Object[1];
            d(14, b, b, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            d(b2, (byte) (b2 + 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr2);
            int intValue = ((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, view)).intValue();
            if (!C0262bm.a(view)) {
                if ((view instanceof TextureView) || (view instanceof SurfaceView)) {
                    TextureView a3 = a(view);
                    if (a3 != null) {
                        int a4 = o2.a(intValue);
                        o2.a(intValue, a4 == 0 ? c0223aa.a(a3.getBitmap(c0275bz.b().a("textureView", true)), 0.0f, 0.0f, view.getWidth(), view.getHeight()) : c0223aa.a(a4, 0.0f, 0.0f, view.getWidth(), view.getHeight()));
                    } else {
                        c0223aa.drawRGB(170, 170, 170);
                    }
                } else if (!(view instanceof WebView) && !a(view, c0223aa)) {
                    if (view instanceof ProgressBar) {
                        c0223aa.fsDrawProgressBar((ProgressBar) view);
                    } else if (view instanceof CompoundButton) {
                        CompoundButton compoundButton = (CompoundButton) view;
                        Drawable a5 = AbstractC0358h.a(compoundButton);
                        if (a5 instanceof AnimatedStateListDrawable) {
                            a(compoundButton, a5.getCurrent(), c0223aa);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("CompoundButton getButtonDrawable was not an AnimatedStateListDrawable. falling back to standard drawing. was: ");
                            sb.append(a5 != null ? a5.getClass().getName() : "null");
                            Log.d(sb.toString());
                            AbstractC0329e.a(compoundButton, c0223aa);
                        }
                    } else if (view instanceof FSDraw) {
                        view.draw(c0223aa);
                    } else {
                        if ((view instanceof TextView) && (compoundDrawables = (textView = (TextView) view).getCompoundDrawables()) != null && compoundDrawables.length > 0) {
                            int length = compoundDrawables.length;
                            for (int i = 0; i < length; i++) {
                                Drawable drawable2 = compoundDrawables[i];
                                if (fd.a(drawable2)) {
                                    c0223aa.fsDrawCompoundVectorDrawable(drawable2, textView, i);
                                }
                            }
                        }
                        AbstractC0329e.a(view, c0223aa);
                        if (view instanceof FSDispatchDraw) {
                            AbstractC0329e.b(view, c0223aa);
                        }
                    }
                }
            }
            if (!f7855a && c0223aa.isEmpty() && (view instanceof ImageView) && (drawable = ((ImageView) view).getDrawable()) != null) {
                f7855a = true;
                c0223aa.a(String.format("Failed to draw anything from an imageview (%s)with a non-empty drawable: %s", view.getClass(), drawable.getClass()));
            }
            return this.b.a(intValue, c0223aa.h());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public int a(FSComposeDraw fSComposeDraw, C0367q c0367q, Object obj, C0223aa c0223aa, RectF rectF) {
        C0350eu.a("renderNode", new Object[0]);
        c0223aa.a(fSComposeDraw, rectF.left, rectF.top, c0367q.e(fSComposeDraw));
        c0223aa.drawRect(rectF, (Paint) null);
        fSComposeDraw._fsComposeDraw(obj);
        try {
            Object[] objArr = {fSComposeDraw};
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr2 = new Object[1];
            d(14, b, b, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr3 = new Object[1];
            d(b2, (byte) (b2 + 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr3);
            return this.b.a(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue(), c0223aa.g());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public void a(CompoundButton compoundButton, Drawable drawable, C0223aa c0223aa) {
        if (!fd.a(drawable)) {
            StringBuilder sb = new StringBuilder();
            sb.append("current drawable for checkbox was not a vector. falling back to standard drawing.");
            sb.append(drawable != null ? drawable.getClass().getName() : "null");
            Log.d(sb.toString());
            AbstractC0329e.a(compoundButton, c0223aa);
            return;
        }
        int gravity = compoundButton.getGravity() & 112;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int height = gravity != 16 ? gravity != 80 ? 0 : c0223aa.getHeight() - intrinsicHeight : (c0223aa.getHeight() - intrinsicHeight) / 2;
        int i = intrinsicHeight + height;
        int width = compoundButton.isLayoutRtl() ? c0223aa.getWidth() - intrinsicWidth : 0;
        if (compoundButton.isLayoutRtl()) {
            intrinsicWidth = c0223aa.getWidth();
        }
        drawable.setBounds(width, height, intrinsicWidth, i);
        Drawable background = compoundButton.getBackground();
        if (background != null) {
            background.setHotspotBounds(width, height, intrinsicWidth, i);
            if (fd.a(background)) {
                c0223aa.a(background, (View) compoundButton, true);
            }
        }
        AbstractC0329e.a(compoundButton, c0223aa);
        int scrollX = compoundButton.getScrollX();
        int scrollY = compoundButton.getScrollY();
        if (scrollX == 0 && scrollY == 0) {
            c0223aa.a(drawable, (View) compoundButton, false);
            return;
        }
        c0223aa.translate(scrollX, scrollY);
        c0223aa.a(drawable, (View) compoundButton, false);
        c0223aa.translate(-scrollX, -scrollY);
    }
}
