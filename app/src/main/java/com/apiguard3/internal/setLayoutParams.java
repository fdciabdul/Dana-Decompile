package com.apiguard3.internal;

import com.apiguard3.internal.setOutlineSpotShadowColor;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class setLayoutParams<T> extends setScaleX<T> {
    private static int AGState = 1;
    private static int valueOf;
    private final setScaleX<T> APIGuard;
    private final Type getSharedInstance;
    private final setScreenReaderFocusable values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public setLayoutParams(setScreenReaderFocusable setscreenreaderfocusable, setScaleX<T> setscalex, Type type) {
        this.values = setscreenreaderfocusable;
        this.APIGuard = setscalex;
        this.getSharedInstance = type;
    }

    @Override // com.apiguard3.internal.setScaleX
    public final void getSharedInstance(setLayerType setlayertype, T t) throws IOException {
        setScaleX<T> setscalex = this.APIGuard;
        Type sharedInstance = getSharedInstance(this.getSharedInstance, t);
        if (sharedInstance != this.getSharedInstance) {
            valueOf = (AGState + 35) % 128;
            setscalex = this.values.AGState(setScrollbarFadingEnabled.getSharedInstance(sharedInstance));
            if (setscalex instanceof setOutlineSpotShadowColor.APIGuard) {
                setScaleX<T> setscalex2 = this.APIGuard;
                if (!(setscalex2 instanceof setOutlineSpotShadowColor.APIGuard)) {
                    valueOf = (AGState + 123) % 128;
                    setscalex = setscalex2;
                }
            }
        }
        setscalex.getSharedInstance(setlayertype, t);
    }

    private static Type getSharedInstance(Type type, Object obj) {
        if (obj != null) {
            int i = AGState;
            int i2 = i + 33;
            valueOf = i2 % 128;
            if ((i2 % 2 != 0 ? '\r' : '`') == '\r') {
                throw new ArithmeticException();
            }
            if ((type != Object.class ? '!' : (char) 23) == '!' && !(type instanceof TypeVariable)) {
                int i3 = i + 119;
                valueOf = i3 % 128;
                if (i3 % 2 != 0) {
                    throw new ArithmeticException();
                } else if (!(type instanceof Class)) {
                    return type;
                }
            }
            return obj.getClass();
        }
        return type;
    }
}
