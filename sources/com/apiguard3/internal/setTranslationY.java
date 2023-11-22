package com.apiguard3.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: classes7.dex */
public final class setTranslationY<E> extends setScaleX<Object> {
    private static int AGState = 1;
    public static final setPivotX APIGuard = new setPivotX() { // from class: com.apiguard3.internal.setTranslationY.5
        private static int APIGuard = 1;
        private static int values;

        @Override // com.apiguard3.internal.setPivotX
        public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
            Type sharedInstance = setscrollbarfadingenabled.getSharedInstance();
            if ((!(sharedInstance instanceof GenericArrayType) ? 'S' : (char) 14) != 14) {
                int i = values;
                APIGuard = (i + 123) % 128;
                if ((!(sharedInstance instanceof Class)) == true) {
                    return null;
                }
                APIGuard = (i + 19) % 128;
                if (!((Class) sharedInstance).isArray()) {
                    return null;
                }
            }
            Type valueOf2 = setForceDarkAllowed.valueOf(sharedInstance);
            return new setTranslationY(setscreenreaderfocusable, setscreenreaderfocusable.AGState(setScrollbarFadingEnabled.getSharedInstance(valueOf2)), setForceDarkAllowed.AGState(valueOf2));
        }
    };
    private static int valueOf;
    private final setScaleX<E> getSharedInstance;

    static {
        int i = valueOf + 125;
        AGState = i % 128;
        if (i % 2 == 0) {
            throw new NullPointerException();
        }
    }

    public setTranslationY(setScreenReaderFocusable setscreenreaderfocusable, setScaleX<E> setscalex, Class<E> cls) {
        this.getSharedInstance = new setLayoutParams(setscreenreaderfocusable, setscalex, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.apiguard3.internal.setScaleX
    public final void getSharedInstance(setLayerType setlayertype, Object obj) throws IOException {
        if ((obj == null ? '!' : '6') == '6') {
            setlayertype.valueOf();
            int length = Array.getLength(obj);
            int i = 0;
            while (true) {
                if ((i < length ? '`' : '%') != '%') {
                    int i2 = AGState + 115;
                    valueOf = i2 % 128;
                    if (i2 % 2 != 0) {
                        this.getSharedInstance.getSharedInstance(setlayertype, Array.get(obj, i));
                        i += 126;
                    } else {
                        this.getSharedInstance.getSharedInstance(setlayertype, Array.get(obj, i));
                        i++;
                    }
                    AGState = (valueOf + 69) % 128;
                } else {
                    setlayertype.values();
                    return;
                }
            }
        } else {
            int i3 = AGState + 31;
            valueOf = i3 % 128;
            if (i3 % 2 == 0) {
                setlayertype.analyzeResponse();
            } else {
                setlayertype.analyzeResponse();
                throw new ArithmeticException();
            }
        }
    }
}
