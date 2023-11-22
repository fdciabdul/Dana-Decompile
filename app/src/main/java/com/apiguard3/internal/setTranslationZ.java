package com.apiguard3.internal;

/* loaded from: classes7.dex */
public final class setTranslationZ implements setPivotX {
    private static int AGState = 0;
    private static int values = 1;
    private final setAlpha valueOf;

    public setTranslationZ(setAlpha setalpha) {
        this.valueOf = setalpha;
    }

    @Override // com.apiguard3.internal.setPivotX
    public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
        setScaleY setscaley = (setScaleY) setscrollbarfadingenabled.AGState().getAnnotation(setScaleY.class);
        if ((setscaley == null ? '.' : 'X') != '.') {
            return (setScaleX<T>) APIGuard(this.valueOf, setscreenreaderfocusable, setscrollbarfadingenabled, setscaley);
        }
        int i = (values + 61) % 128;
        AGState = i;
        int i2 = i + 99;
        values = i2 % 128;
        if (i2 % 2 == 0) {
            throw new NullPointerException();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static setScaleX<?> APIGuard(setAlpha setalpha, setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<?> setscrollbarfadingenabled, setScaleY setscaley) {
        setScaleX<?> setscalex;
        Object values2 = setalpha.APIGuard(setScrollbarFadingEnabled.valueOf(setscaley.values())).values();
        if (values2 instanceof setScaleX) {
            setscalex = (setScaleX) values2;
        } else if (!(values2 instanceof setPivotX)) {
            boolean z = values2 instanceof setScrollX;
            if (!z) {
                AGState = (values + 67) % 128;
                if (!(values2 instanceof setFocusedByDefault)) {
                    StringBuilder sb = new StringBuilder("Invalid attempt to bind an instance of ");
                    sb.append(values2.getClass().getName());
                    sb.append(" as a @JsonAdapter for ");
                    sb.append(setscrollbarfadingenabled.toString());
                    sb.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            setscalex = new setClipToOutline<>(z ? (setScrollX) values2 : null, setscreenreaderfocusable, setscrollbarfadingenabled, null);
        } else {
            values = (AGState + 53) % 128;
            setscalex = ((setPivotX) values2).valueOf(setscreenreaderfocusable, setscrollbarfadingenabled);
        }
        if ((setscalex != null ? 'Z' : '5') != '5') {
            AGState = (values + 69) % 128;
            return setscaley.getSharedInstance() ? setscalex.AGState() : setscalex;
        }
        return setscalex;
    }
}
