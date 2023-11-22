package com.apiguard3.internal;

/* loaded from: classes7.dex */
public enum setRotation {
    DEFAULT { // from class: com.apiguard3.internal.setRotation.3
    },
    STRING { // from class: com.apiguard3.internal.setRotation.4
    };

    private static int AGState = 0;
    private static int APIGuard = (AGState + 13) % 128;

    /* synthetic */ setRotation(byte b) {
        this();
    }

    public static setRotation valueOf(String str) {
        AGState = (APIGuard + 123) % 128;
        setRotation setrotation = (setRotation) Enum.valueOf(setRotation.class, str);
        APIGuard = (AGState + 91) % 128;
        return setrotation;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static setRotation[] valuesCustom() {
        APIGuard = (AGState + 65) % 128;
        setRotation[] setrotationArr = (setRotation[]) values().clone();
        int i = APIGuard + 11;
        AGState = i % 128;
        if ((i % 2 != 0 ? 'L' : '-') == '-') {
            return setrotationArr;
        }
        throw null;
    }
}
