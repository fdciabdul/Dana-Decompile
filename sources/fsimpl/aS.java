package fsimpl;

import android.graphics.Shader;

/* loaded from: classes4.dex */
/* synthetic */ class aS {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7833a;

    static {
        int[] iArr = new int[Shader.TileMode.values().length];
        f7833a = iArr;
        try {
            iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7833a[Shader.TileMode.MIRROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7833a[Shader.TileMode.REPEAT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
