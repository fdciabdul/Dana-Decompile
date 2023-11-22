package com.apiguard3.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* loaded from: classes7.dex */
final class setScrollBarDefaultDelayBeforeFade extends setScaleX<Date> {
    private final DateFormat getSharedInstance;
    static final setPivotX AGState = new setPivotX() { // from class: com.apiguard3.internal.setScrollBarDefaultDelayBeforeFade.1
        private static int APIGuard = 0;
        private static int valueOf = 1;

        @Override // com.apiguard3.internal.setPivotX
        public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
            int i = APIGuard + 11;
            valueOf = i % 128;
            if (i % 2 != 0) {
                if (setscrollbarfadingenabled.AGState() == Date.class) {
                    return new setScrollBarDefaultDelayBeforeFade(r0);
                }
                int i2 = APIGuard + 75;
                valueOf = i2 % 128;
                if ((i2 % 2 != 0 ? (byte) 1 : (byte) 0) == 1) {
                    return null;
                }
                throw new NullPointerException();
            }
            setscrollbarfadingenabled.AGState();
            throw new NullPointerException();
        }
    };
    private static int values = 1;
    private static int valueOf = (values + 61) % 128;

    /* synthetic */ setScrollBarDefaultDelayBeforeFade(byte b) {
        this();
    }

    @Override // com.apiguard3.internal.setScaleX
    public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Date date) throws IOException {
        values = (valueOf + 123) % 128;
        APIGuard(setlayertype, date);
        values = (valueOf + 107) % 128;
    }

    private setScrollBarDefaultDelayBeforeFade() {
        this.getSharedInstance = new SimpleDateFormat("MMM d, yyyy");
    }

    private void APIGuard(setLayerType setlayertype, Date date) throws IOException {
        String str;
        synchronized (this) {
            if (!(date == null)) {
                str = this.getSharedInstance.format((java.util.Date) date);
            } else {
                int i = (values + 35) % 128;
                valueOf = i;
                values = (i + 81) % 128;
                str = null;
            }
            setlayertype.AGState(str);
        }
    }
}
