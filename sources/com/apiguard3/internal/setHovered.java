package com.apiguard3.internal;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes7.dex */
public abstract class setHovered {
    private static int getSharedInstance = 0;
    private static int valueOf = 1;

    public final boolean values() {
        int i = (valueOf + 81) % 128;
        getSharedInstance = i;
        boolean z = this instanceof setSaveFromParentEnabled;
        valueOf = (i + 29) % 128;
        return z;
    }

    public final boolean APIGuard() {
        int i = valueOf;
        int i2 = i + 21;
        getSharedInstance = i2 % 128;
        if ((i2 % 2 != 0 ? 'L' : '3') == 'L') {
            throw new NullPointerException();
        }
        boolean z = this instanceof setImportantForAccessibility;
        int i3 = i + 71;
        getSharedInstance = i3 % 128;
        if (i3 % 2 == 0) {
            return z;
        }
        throw null;
    }

    public final boolean getRequestHeaders() {
        int i = getSharedInstance;
        valueOf = (i + 75) % 128;
        boolean z = this instanceof setScrollY;
        valueOf = (i + 17) % 128;
        return z;
    }

    public final boolean parseResponseHeaders() {
        int i = valueOf + 17;
        getSharedInstance = i % 128;
        if ((i % 2 != 0 ? '8' : (char) 25) != '8') {
            return this instanceof setAccessibilityLiveRegion;
        }
        throw new NullPointerException();
    }

    public final setImportantForAccessibility initialize() {
        valueOf = (getSharedInstance + 109) % 128;
        if ((APIGuard() ? '\t' : '^') != '^') {
            int i = valueOf + 29;
            getSharedInstance = i % 128;
            if ((i % 2 != 0 ? (char) 23 : '\'') != 23) {
                return (setImportantForAccessibility) this;
            }
            setImportantForAccessibility setimportantforaccessibility = (setImportantForAccessibility) this;
            throw new ArithmeticException();
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(this)));
    }

    public final setSaveFromParentEnabled generateHeaders() {
        int i = valueOf + 89;
        getSharedInstance = i % 128;
        if (i % 2 == 0) {
            if ((values() ? 'E' : '!') != '!') {
                setSaveFromParentEnabled setsavefromparentenabled = (setSaveFromParentEnabled) this;
                getSharedInstance = (valueOf + 125) % 128;
                return setsavefromparentenabled;
            }
            throw new IllegalStateException("Not a JSON Array: ".concat(String.valueOf(this)));
        }
        values();
        throw new NullPointerException();
    }

    public final setScrollY analyzeResponse() {
        getSharedInstance = (valueOf + 33) % 128;
        if ((!getRequestHeaders()) == true) {
            throw new IllegalStateException("Not a JSON Primitive: ".concat(String.valueOf(this)));
        }
        int i = (getSharedInstance + 81) % 128;
        valueOf = i;
        setScrollY setscrolly = (setScrollY) this;
        getSharedInstance = (i + 99) % 128;
        return setscrolly;
    }

    public boolean valueOf() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number AGState() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getSharedInstance() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            setLayerType setlayertype = new setLayerType(stringWriter);
            setlayertype.AGState(true);
            setBottom.APIGuard(this, setlayertype);
            String obj = stringWriter.toString();
            int i = getSharedInstance + 13;
            valueOf = i % 128;
            if (i % 2 != 0) {
                return obj;
            }
            throw new NullPointerException();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
