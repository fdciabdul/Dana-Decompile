package com.google.firebase.perf.v1;

import com.google.protobuf.Internal;

/* loaded from: classes.dex */
public enum ApplicationProcessState implements Internal.EnumLite {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);

    public static final int APPLICATION_PROCESS_STATE_UNKNOWN_VALUE = 0;
    public static final int BACKGROUND_VALUE = 2;
    public static final int FOREGROUND_BACKGROUND_VALUE = 3;
    public static final int FOREGROUND_VALUE = 1;
    private static final Internal.EnumLiteMap<ApplicationProcessState> internalValueMap = new Internal.EnumLiteMap<ApplicationProcessState>() { // from class: com.google.firebase.perf.v1.ApplicationProcessState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public ApplicationProcessState findValueByNumber(int i) {
            return ApplicationProcessState.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static ApplicationProcessState valueOf(int i) {
        return forNumber(i);
    }

    public static ApplicationProcessState forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return FOREGROUND_BACKGROUND;
                }
                return BACKGROUND;
            }
            return FOREGROUND;
        }
        return APPLICATION_PROCESS_STATE_UNKNOWN;
    }

    public static Internal.EnumLiteMap<ApplicationProcessState> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ApplicationProcessStateVerifier.INSTANCE;
    }

    /* loaded from: classes.dex */
    static final class ApplicationProcessStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new ApplicationProcessStateVerifier();

        private ApplicationProcessStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public final boolean isInRange(int i) {
            return ApplicationProcessState.forNumber(i) != null;
        }
    }

    ApplicationProcessState(int i) {
        this.value = i;
    }
}
