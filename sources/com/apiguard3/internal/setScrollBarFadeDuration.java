package com.apiguard3.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes7.dex */
final class setScrollBarFadeDuration extends setScaleX<Time> {
    private final DateFormat getSharedInstance;
    static final setPivotX valueOf = new setPivotX() { // from class: com.apiguard3.internal.setScrollBarFadeDuration.1
        private static int AGState = 1;
        private static int getSharedInstance;

        @Override // com.apiguard3.internal.setPivotX
        public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
            int i = AGState + 93;
            getSharedInstance = i % 128;
            if ((i % 2 != 0 ? (char) 16 : '\\') != '\\') {
                setscrollbarfadingenabled.AGState();
                throw new ArithmeticException();
            } else if (setscrollbarfadingenabled.AGState() == Time.class) {
                return new setScrollBarFadeDuration((byte) 0);
            } else {
                AGState = (getSharedInstance + 21) % 128;
                return null;
            }
        }
    };
    private static int values;
    private static int AGState = (values + 45) % 128;

    /* synthetic */ setScrollBarFadeDuration(byte b) {
        this();
    }

    @Override // com.apiguard3.internal.setScaleX
    public final /* bridge */ /* synthetic */ void getSharedInstance(setLayerType setlayertype, Time time) throws IOException {
        int i = values + 77;
        AGState = i % 128;
        char c = i % 2 == 0 ? 'a' : 'W';
        getSharedInstance2(setlayertype, time);
        if (c != 'a') {
            return;
        }
        throw null;
    }

    private setScrollBarFadeDuration() {
        this.getSharedInstance = new SimpleDateFormat("hh:mm:ss a");
    }

    /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
    private void getSharedInstance2(setLayerType setlayertype, Time time) throws IOException {
        String format;
        synchronized (this) {
            int i = AGState + 125;
            int i2 = i % 128;
            values = i2;
            if (i % 2 != 0) {
                throw new NullPointerException();
            }
            if (!(time != null)) {
                AGState = (i2 + 99) % 128;
                format = null;
            } else {
                format = this.getSharedInstance.format((Date) time);
            }
            setlayertype.AGState(format);
            AGState = (values + 7) % 128;
        }
    }
}
