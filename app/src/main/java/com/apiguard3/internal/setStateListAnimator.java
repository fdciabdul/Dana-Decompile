package com.apiguard3.internal;

import java.io.IOException;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setStateListAnimator extends setScaleX<Number> {
    private static final setPivotX APIGuard = AGState(setTouchDelegate.LAZILY_PARSED_NUMBER);
    private static int AGState = 0;
    private static int values = (AGState + 79) % 128;

    @Override // com.apiguard3.internal.setScaleX
    public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
        AGState = (values + 35) % 128;
        APIGuard(setlayertype, number);
        int i = AGState + 11;
        values = i % 128;
        if ((i % 2 == 0 ? (char) 19 : '.') == '.') {
            return;
        }
        throw null;
    }

    private setStateListAnimator() {
    }

    private static setPivotX AGState(setCameraDistance setcameradistance) {
        setPivotX setpivotx = new setPivotX() { // from class: com.apiguard3.internal.setStateListAnimator.4
            private static int valueOf = 0;
            private static int values = 1;

            @Override // com.apiguard3.internal.setPivotX
            public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
                int i = valueOf + 55;
                values = i % 128;
                if ((i % 2 == 0 ? '1' : '_') == '1') {
                    setscrollbarfadingenabled.AGState();
                    throw null;
                } else if (setscrollbarfadingenabled.AGState() == Number.class) {
                    int i2 = (values + 75) % 128;
                    valueOf = i2;
                    setStateListAnimator setstatelistanimator = setStateListAnimator.this;
                    values = (i2 + 109) % 128;
                    return setstatelistanimator;
                } else {
                    return null;
                }
            }
        };
        int i = AGState + 113;
        values = i % 128;
        if ((i % 2 == 0 ? Typography.dollar : '\r') == '\r') {
            return setpivotx;
        }
        throw new ArithmeticException();
    }

    public static setPivotX valueOf(setCameraDistance setcameradistance) {
        int i = values + 95;
        AGState = i % 128;
        if (i % 2 == 0) {
            if (!(setcameradistance != setTouchDelegate.LAZILY_PARSED_NUMBER)) {
                setPivotX setpivotx = APIGuard;
                values = (AGState + 77) % 128;
                return setpivotx;
            }
            return AGState(setcameradistance);
        }
        setTouchDelegate settouchdelegate = setTouchDelegate.LAZILY_PARSED_NUMBER;
        throw new NullPointerException();
    }

    private static void APIGuard(setLayerType setlayertype, Number number) throws IOException {
        values = (AGState + 121) % 128;
        setlayertype.APIGuard(number);
        int i = AGState + 69;
        values = i % 128;
        if ((i % 2 == 0 ? '_' : '\n') == '\n') {
            return;
        }
        throw new ArithmeticException();
    }
}
