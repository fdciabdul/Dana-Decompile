package com.apiguard3.internal;

import java.io.IOException;

/* loaded from: classes7.dex */
public final class setAnimationMatrix extends setScaleX<Object> {
    private static final setPivotX APIGuard = valueOf(setTouchDelegate.DOUBLE);
    private static int valueOf = 0;
    private static int values = 1;
    private final setScreenReaderFocusable getSharedInstance;

    /* synthetic */ setAnimationMatrix(setScreenReaderFocusable setscreenreaderfocusable, setCameraDistance setcameradistance) {
        this(setscreenreaderfocusable);
    }

    static {
        int i = values + 1;
        valueOf = i % 128;
        if (i % 2 == 0) {
            return;
        }
        throw null;
    }

    private setAnimationMatrix(setScreenReaderFocusable setscreenreaderfocusable) {
        this.getSharedInstance = setscreenreaderfocusable;
    }

    private static setPivotX valueOf(final setCameraDistance setcameradistance) {
        setPivotX setpivotx = new setPivotX() { // from class: com.apiguard3.internal.setAnimationMatrix.5
            private static int AGState = 1;
            private static int APIGuard;

            @Override // com.apiguard3.internal.setPivotX
            public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
                int i = APIGuard + 75;
                AGState = i % 128;
                char c = i % 2 == 0 ? '\r' : '5';
                Class<? super T> AGState2 = setscrollbarfadingenabled.AGState();
                if (c == '\r') {
                    throw new ArithmeticException();
                } else if (AGState2 != Object.class) {
                    int i2 = APIGuard + 105;
                    AGState = i2 % 128;
                    if ((i2 % 2 == 0 ? '\n' : 'B') == 'B') {
                        return null;
                    }
                    throw null;
                } else {
                    return new setAnimationMatrix(setscreenreaderfocusable, setCameraDistance.this);
                }
            }
        };
        int i = valueOf + 119;
        values = i % 128;
        if (i % 2 != 0) {
            return setpivotx;
        }
        throw new NullPointerException();
    }

    public static setPivotX values(setCameraDistance setcameradistance) {
        int i = values + 5;
        valueOf = i % 128;
        if ((i % 2 != 0 ? 'B' : '4') != 'B') {
            if (setcameradistance == setTouchDelegate.DOUBLE) {
                setPivotX setpivotx = APIGuard;
                int i2 = values + 125;
                valueOf = i2 % 128;
                if ((i2 % 2 != 0 ? '\r' : (char) 15) == 15) {
                    return setpivotx;
                }
                throw new ArithmeticException();
            }
            return valueOf(setcameradistance);
        }
        setTouchDelegate settouchdelegate = setTouchDelegate.DOUBLE;
        throw new NullPointerException();
    }

    @Override // com.apiguard3.internal.setScaleX
    public final void getSharedInstance(setLayerType setlayertype, Object obj) throws IOException {
        values = (valueOf + 101) % 128;
        if (obj == null) {
            setlayertype.analyzeResponse();
            int i = valueOf + 1;
            values = i % 128;
            if ((i % 2 == 0 ? '9' : 'c') == 'c') {
                return;
            }
            throw new ArithmeticException();
        }
        setScaleX valueOf2 = this.getSharedInstance.valueOf((Class) obj.getClass());
        if ((!(valueOf2 instanceof setAnimationMatrix)) != true) {
            setlayertype.AGState();
            setlayertype.getSharedInstance();
            return;
        }
        valueOf2.getSharedInstance(setlayertype, obj);
    }
}
