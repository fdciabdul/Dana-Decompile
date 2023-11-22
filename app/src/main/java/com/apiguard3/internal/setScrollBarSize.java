package com.apiguard3.internal;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes7.dex */
final class setScrollBarSize extends setScaleX<Timestamp> {
    private static int APIGuard = 1;
    static final setPivotX getSharedInstance = new setPivotX() { // from class: com.apiguard3.internal.setScrollBarSize.3
        private static int APIGuard = 1;
        private static int getSharedInstance;

        @Override // com.apiguard3.internal.setPivotX
        public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
            APIGuard = (getSharedInstance + 45) % 128;
            if (setscrollbarfadingenabled.AGState() == Timestamp.class) {
                setScrollBarSize setscrollbarsize = new setScrollBarSize(setscreenreaderfocusable.valueOf((Class) Date.class), (byte) 0);
                getSharedInstance = (APIGuard + 91) % 128;
                return setscrollbarsize;
            }
            return null;
        }
    };
    private static int values;
    private final setScaleX<Date> AGState;

    /* synthetic */ setScrollBarSize(setScaleX setscalex, byte b) {
        this(setscalex);
    }

    @Override // com.apiguard3.internal.setScaleX
    public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Timestamp timestamp) throws IOException {
        int i = APIGuard + 83;
        values = i % 128;
        char c = i % 2 != 0 ? '\f' : '/';
        valueOf(setlayertype, timestamp);
        if (c != '\f') {
            return;
        }
        throw new ArithmeticException();
    }

    static {
        int i = values + 53;
        APIGuard = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw new ArithmeticException();
    }

    private setScrollBarSize(setScaleX<Date> setscalex) {
        this.AGState = setscalex;
    }

    private void valueOf(setLayerType setlayertype, Timestamp timestamp) throws IOException {
        int i = APIGuard + 123;
        values = i % 128;
        if ((i % 2 != 0 ? 'H' : '\\') == 'H') {
            this.AGState.getSharedInstance(setlayertype, timestamp);
            throw new NullPointerException();
        }
        this.AGState.getSharedInstance(setlayertype, timestamp);
        values = (APIGuard + 83) % 128;
    }
}
