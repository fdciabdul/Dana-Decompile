package com.apiguard3.internal;

import java.io.IOException;

/* loaded from: classes7.dex */
public abstract class setScaleX<T> {
    private static int APIGuard = 1;
    private static int values;

    public abstract void getSharedInstance(setLayerType setlayertype, T t) throws IOException;

    public final setScaleX<T> AGState() {
        setScaleX<T> setscalex = new setScaleX<T>() { // from class: com.apiguard3.internal.setScaleX.3
            private static int APIGuard = 0;
            private static int getSharedInstance = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final void getSharedInstance(setLayerType setlayertype, T t) throws IOException {
                int i = getSharedInstance + 91;
                APIGuard = i % 128;
                if (i % 2 != 0) {
                    throw null;
                } else if (t == null) {
                    setlayertype.analyzeResponse();
                } else {
                    setScaleX.this.getSharedInstance(setlayertype, t);
                    int i2 = APIGuard + 89;
                    getSharedInstance = i2 % 128;
                    if (i2 % 2 != 0) {
                        return;
                    }
                    throw null;
                }
            }
        };
        APIGuard = (values + 81) % 128;
        return setscalex;
    }

    public final setHovered APIGuard(T t) {
        try {
            setZ setz = new setZ();
            getSharedInstance(setz, t);
            setHovered APIGuard2 = setz.APIGuard();
            values = (APIGuard + 37) % 128;
            return APIGuard2;
        } catch (IOException e) {
            throw new setDefaultFocusHighlightEnabled(e);
        }
    }
}
