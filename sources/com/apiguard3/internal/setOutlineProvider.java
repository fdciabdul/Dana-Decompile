package com.apiguard3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes7.dex */
public final class setOutlineProvider implements setPivotX {
    private static int AGState = 1;
    private static int getSharedInstance;
    final boolean valueOf = false;
    private final setAlpha values;

    public setOutlineProvider(setAlpha setalpha, boolean z) {
        this.values = setalpha;
    }

    @Override // com.apiguard3.internal.setPivotX
    public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
        int i = AGState + 99;
        getSharedInstance = i % 128;
        if (!(i % 2 == 0)) {
            setscrollbarfadingenabled.getSharedInstance();
            setscrollbarfadingenabled.AGState();
            throw null;
        }
        Type sharedInstance = setscrollbarfadingenabled.getSharedInstance();
        if (Map.class.isAssignableFrom(setscrollbarfadingenabled.AGState())) {
            Type[] AGState2 = setForceDarkAllowed.AGState(sharedInstance, setForceDarkAllowed.AGState(sharedInstance));
            setScaleX<?> sharedInstance2 = getSharedInstance(setscreenreaderfocusable, AGState2[0]);
            setScaleX<T> AGState3 = setscreenreaderfocusable.AGState(setScrollbarFadingEnabled.getSharedInstance(AGState2[1]));
            this.values.APIGuard(setscrollbarfadingenabled);
            return new APIGuard(setscreenreaderfocusable, AGState2[0], sharedInstance2, AGState2[1], AGState3);
        }
        int i2 = AGState + 21;
        getSharedInstance = i2 % 128;
        if (i2 % 2 == 0) {
            return null;
        }
        throw null;
    }

    private static setScaleX<?> getSharedInstance(setScreenReaderFocusable setscreenreaderfocusable, Type type) {
        if ((type != Boolean.TYPE ? 'B' : (char) 5) == 'B') {
            AGState = (getSharedInstance + 99) % 128;
            if (type != Boolean.class) {
                return setscreenreaderfocusable.AGState(setScrollbarFadingEnabled.getSharedInstance(type));
            }
        }
        setScaleX<Boolean> setscalex = setHorizontalFadingEdgeEnabled.values;
        AGState = (getSharedInstance + 109) % 128;
        return setscalex;
    }

    /* loaded from: classes7.dex */
    final class APIGuard<K, V> extends setScaleX<Map<K, V>> {
        private static int AGState = 1;
        private static int getSharedInstance;
        private final setScaleX<K> valueOf;
        private final setScaleX<V> values;

        @Override // com.apiguard3.internal.setScaleX
        public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Object obj) throws IOException {
            int i = getSharedInstance + 87;
            AGState = i % 128;
            boolean z = i % 2 != 0;
            APIGuard(setlayertype, (Map) obj);
            if (z) {
                return;
            }
            throw new ArithmeticException();
        }

        public APIGuard(setScreenReaderFocusable setscreenreaderfocusable, Type type, setScaleX<K> setscalex, Type type2, setScaleX<V> setscalex2) {
            setOutlineProvider.this = r1;
            this.valueOf = new setLayoutParams(setscreenreaderfocusable, setscalex, type);
            this.values = new setLayoutParams(setscreenreaderfocusable, setscalex2, type2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void APIGuard(setLayerType setlayertype, Map<K, V> map) throws IOException {
            if (map == null) {
                setlayertype.analyzeResponse();
            } else if (!setOutlineProvider.this.valueOf) {
                setlayertype.AGState();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    setlayertype.APIGuard(String.valueOf(entry.getKey()));
                    this.values.getSharedInstance(setlayertype, entry.getValue());
                }
                setlayertype.getSharedInstance();
                int i = AGState + 23;
                getSharedInstance = i % 128;
                if (i % 2 == 0) {
                    return;
                }
                throw null;
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
                boolean z = false;
                while (true) {
                    boolean z2 = true;
                    if (it.hasNext()) {
                        getSharedInstance = (AGState + 5) % 128;
                        Map.Entry<K, V> next = it.next();
                        setHovered APIGuard = this.valueOf.APIGuard(next.getKey());
                        arrayList.add(APIGuard);
                        arrayList2.add(next.getValue());
                        if (!APIGuard.values()) {
                            int i2 = getSharedInstance + 61;
                            AGState = i2 % 128;
                            if ((i2 % 2 == 0 ? 'R' : '_') != '_') {
                                APIGuard.APIGuard();
                                throw new ArithmeticException();
                            } else if (!APIGuard.APIGuard()) {
                                z2 = false;
                            }
                        }
                        z |= z2;
                    } else if (z) {
                        AGState = (getSharedInstance + 23) % 128;
                        setlayertype.valueOf();
                        int size = arrayList.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            setlayertype.valueOf();
                            setBottom.APIGuard((setHovered) arrayList.get(i3), setlayertype);
                            this.values.getSharedInstance(setlayertype, arrayList2.get(i3));
                            setlayertype.values();
                        }
                        setlayertype.values();
                        return;
                    } else {
                        setlayertype.AGState();
                        int size2 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (!(i4 < size2)) {
                                setlayertype.getSharedInstance();
                                return;
                            }
                            setlayertype.APIGuard(valueOf((setHovered) arrayList.get(i4)));
                            this.values.getSharedInstance(setlayertype, arrayList2.get(i4));
                            i4++;
                        }
                    }
                }
            }
        }

        private static String valueOf(setHovered sethovered) {
            if (!sethovered.getRequestHeaders()) {
                if (sethovered.parseResponseHeaders()) {
                    return "null";
                }
                throw new AssertionError();
            }
            int i = getSharedInstance + 45;
            AGState = i % 128;
            if (!(i % 2 != 0)) {
                sethovered.analyzeResponse().updateKernel();
                throw null;
            }
            setScrollY analyzeResponse = sethovered.analyzeResponse();
            if ((!analyzeResponse.updateKernel()) == true) {
                if (analyzeResponse.getState()) {
                    int i2 = getSharedInstance + 101;
                    AGState = i2 % 128;
                    if (i2 % 2 != 0) {
                        return Boolean.toString(analyzeResponse.valueOf());
                    }
                    analyzeResponse.valueOf();
                    throw new ArithmeticException();
                } else if (analyzeResponse.APIGuard$Callback()) {
                    int i3 = AGState + 3;
                    getSharedInstance = i3 % 128;
                    if (i3 % 2 == 0) {
                        return analyzeResponse.getSharedInstance();
                    }
                    analyzeResponse.getSharedInstance();
                    throw new ArithmeticException();
                } else {
                    throw new AssertionError();
                }
            }
            return String.valueOf(analyzeResponse.AGState());
        }
    }
}
