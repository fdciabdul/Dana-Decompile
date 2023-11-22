package com.apiguard3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes7.dex */
public final class setElevation implements setPivotX {
    private static int APIGuard = 0;
    private static int getSharedInstance = 1;
    private final setAlpha values;

    public setElevation(setAlpha setalpha) {
        this.values = setalpha;
    }

    @Override // com.apiguard3.internal.setPivotX
    public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
        int i = APIGuard + 79;
        getSharedInstance = i % 128;
        if (!(i % 2 == 0)) {
            Type sharedInstance = setscrollbarfadingenabled.getSharedInstance();
            Class<? super T> AGState = setscrollbarfadingenabled.AGState();
            if ((!Collection.class.isAssignableFrom(AGState) ? '`' : '\r') != '`') {
                Type values = setForceDarkAllowed.values(sharedInstance, AGState);
                setScaleX<T> AGState2 = setscreenreaderfocusable.AGState(setScrollbarFadingEnabled.getSharedInstance(values));
                this.values.APIGuard(setscrollbarfadingenabled);
                valueOf valueof = new valueOf(setscreenreaderfocusable, values, AGState2);
                int i2 = APIGuard + 101;
                getSharedInstance = i2 % 128;
                if (i2 % 2 != 0) {
                    return valueof;
                }
                throw null;
            }
            return null;
        }
        setscrollbarfadingenabled.getSharedInstance();
        setscrollbarfadingenabled.AGState();
        throw new NullPointerException();
    }

    /* loaded from: classes7.dex */
    static final class valueOf<E> extends setScaleX<Collection<E>> {
        private static int AGState = 1;
        private static int getSharedInstance;
        private final setScaleX<E> values;

        @Override // com.apiguard3.internal.setScaleX
        public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Object obj) throws IOException {
            getSharedInstance = (AGState + 95) % 128;
            valueOf(setlayertype, (Collection) obj);
            AGState = (getSharedInstance + 85) % 128;
        }

        public valueOf(setScreenReaderFocusable setscreenreaderfocusable, Type type, setScaleX<E> setscalex) {
            this.values = new setLayoutParams(setscreenreaderfocusable, setscalex, type);
        }

        private void valueOf(setLayerType setlayertype, Collection<E> collection) throws IOException {
            if ((collection == null ? ':' : '#') != '#') {
                getSharedInstance = (AGState + 69) % 128;
                setlayertype.analyzeResponse();
                AGState = (getSharedInstance + 45) % 128;
                return;
            }
            setlayertype.valueOf();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                int i = getSharedInstance + 107;
                AGState = i % 128;
                if (!(i % 2 != 0)) {
                    this.values.getSharedInstance(setlayertype, it.next());
                    throw new NullPointerException();
                }
                this.values.getSharedInstance(setlayertype, it.next());
            }
            setlayertype.values();
        }
    }
}
