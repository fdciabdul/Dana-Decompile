package com.apiguard3.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class setTranslationX extends setScaleX<Date> {
    public static final setPivotX AGState = new setPivotX() { // from class: com.apiguard3.internal.setTranslationX.2
        private static int APIGuard = 0;
        private static int values = 1;

        @Override // com.apiguard3.internal.setPivotX
        public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
            int i = values + 103;
            APIGuard = i % 128;
            if (!(i % 2 == 0)) {
                setscrollbarfadingenabled.AGState();
                throw new NullPointerException();
            } else if (setscrollbarfadingenabled.AGState() == Date.class) {
                return new setTranslationX();
            } else {
                int i2 = APIGuard + 65;
                values = i2 % 128;
                if ((i2 % 2 == 0 ? (char) 19 : '.') != 19) {
                    return null;
                }
                throw null;
            }
        }
    };
    private static int getSharedInstance = 0;
    private static int values = (getSharedInstance + 101) % 128;
    private final List<DateFormat> valueOf;

    @Override // com.apiguard3.internal.setScaleX
    public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Date date) throws IOException {
        int i = getSharedInstance + 71;
        values = i % 128;
        boolean z = i % 2 == 0;
        getSharedInstance2(setlayertype, date);
        if (z) {
            throw new NullPointerException();
        }
    }

    public setTranslationX() {
        ArrayList arrayList = new ArrayList();
        this.valueOf = arrayList;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (setPivotY.getSharedInstance()) {
            arrayList.add(setBottom.valueOf());
        }
    }

    /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
    private void getSharedInstance2(setLayerType setlayertype, Date date) throws IOException {
        synchronized (this) {
            int i = getSharedInstance + 73;
            values = i % 128;
            if ((i % 2 == 0 ? ']' : '(') != '(') {
                throw new NullPointerException();
            } else if (date != null) {
                setlayertype.AGState(this.valueOf.get(0).format(date));
            } else {
                setlayertype.analyzeResponse();
                getSharedInstance = (values + 93) % 128;
            }
        }
    }
}
