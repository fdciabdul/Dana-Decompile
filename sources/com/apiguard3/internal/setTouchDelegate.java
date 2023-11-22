package com.apiguard3.internal;

/* loaded from: classes7.dex */
public enum setTouchDelegate implements setCameraDistance {
    DOUBLE { // from class: com.apiguard3.internal.setTouchDelegate.2
    },
    LAZILY_PARSED_NUMBER { // from class: com.apiguard3.internal.setTouchDelegate.3
    },
    LONG_OR_DOUBLE { // from class: com.apiguard3.internal.setTouchDelegate.4
    },
    BIG_DECIMAL { // from class: com.apiguard3.internal.setTouchDelegate.1
    };

    private static int initialize = 0;
    private static int parseResponseHeaders = (initialize + 111) % 128;

    /* synthetic */ setTouchDelegate(byte b) {
        this();
    }

    public static setTouchDelegate valueOf(String str) {
        int i = parseResponseHeaders + 3;
        initialize = i % 128;
        char c = i % 2 != 0 ? 'W' : '(';
        setTouchDelegate settouchdelegate = (setTouchDelegate) Enum.valueOf(setTouchDelegate.class, str);
        if (c == 'W') {
            throw null;
        }
        initialize = (parseResponseHeaders + 87) % 128;
        return settouchdelegate;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static setTouchDelegate[] valuesCustom() {
        parseResponseHeaders = (initialize + 123) % 128;
        setTouchDelegate[] settouchdelegateArr = (setTouchDelegate[]) values().clone();
        int i = parseResponseHeaders + 119;
        initialize = i % 128;
        if ((i % 2 != 0 ? ':' : 'F') != ':') {
            return settouchdelegateArr;
        }
        throw new ArithmeticException();
    }
}
