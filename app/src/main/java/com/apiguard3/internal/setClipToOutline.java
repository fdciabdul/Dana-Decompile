package com.apiguard3.internal;

import java.io.IOException;

/* loaded from: classes7.dex */
public final class setClipToOutline<T> extends setScaleX<T> {
    private static int analyzeResponse = 1;
    private static int generateHeaders;
    private final setPivotX AGState;
    private final setScrollbarFadingEnabled<T> APIGuard;
    private setScreenReaderFocusable getSharedInstance;
    private setScaleX<T> valueOf;
    private final setScrollX<T> values;

    public setClipToOutline(setScrollX<T> setscrollx, setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled, setPivotX setpivotx) {
        this.values = setscrollx;
        this.getSharedInstance = setscreenreaderfocusable;
        this.APIGuard = setscrollbarfadingenabled;
        this.AGState = setpivotx;
    }

    @Override // com.apiguard3.internal.setScaleX
    public final void getSharedInstance(setLayerType setlayertype, T t) throws IOException {
        int i = (analyzeResponse + 21) % 128;
        generateHeaders = i;
        setScrollX<T> setscrollx = this.values;
        if (setscrollx == null) {
            analyzeResponse = (i + 73) % 128;
            getSharedInstance().getSharedInstance(setlayertype, t);
            return;
        }
        if ((t == null ? '@' : (char) 2) == '@') {
            analyzeResponse = (i + 49) % 128;
            setlayertype.analyzeResponse();
            generateHeaders = (analyzeResponse + 79) % 128;
            return;
        }
        this.APIGuard.getSharedInstance();
        setBottom.APIGuard(setscrollx.getSharedInstance(), setlayertype);
    }

    private setScaleX<T> getSharedInstance() {
        analyzeResponse = (generateHeaders + 93) % 128;
        setScaleX<T> setscalex = this.valueOf;
        if (setscalex != null) {
            return setscalex;
        }
        setScaleX<T> APIGuard = this.getSharedInstance.APIGuard(this.AGState, this.APIGuard);
        this.valueOf = APIGuard;
        generateHeaders = (analyzeResponse + 37) % 128;
        return APIGuard;
    }
}
