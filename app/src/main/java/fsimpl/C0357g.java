package fsimpl;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: fsimpl.g  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0357g extends Animation {

    /* renamed from: a  reason: collision with root package name */
    static Transformation f7993a = new Transformation();

    public static float a(Animation animation) {
        animation.applyTransformation(1.0f, f7993a);
        return f7993a.getAlpha();
    }
}
