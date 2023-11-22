package com.google.api;

import com.google.protobuf.Internal;

/* loaded from: classes7.dex */
public enum FieldBehavior implements Internal.EnumLite {
    FIELD_BEHAVIOR_UNSPECIFIED(0),
    OPTIONAL(1),
    REQUIRED(2),
    OUTPUT_ONLY(3),
    INPUT_ONLY(4),
    IMMUTABLE(5),
    UNRECOGNIZED(-1);

    public static final int FIELD_BEHAVIOR_UNSPECIFIED_VALUE = 0;
    public static final int IMMUTABLE_VALUE = 5;
    public static final int INPUT_ONLY_VALUE = 4;
    public static final int OPTIONAL_VALUE = 1;
    public static final int OUTPUT_ONLY_VALUE = 3;
    public static final int REQUIRED_VALUE = 2;
    private static final Internal.EnumLiteMap<FieldBehavior> internalValueMap = new Internal.EnumLiteMap<FieldBehavior>() { // from class: com.google.api.FieldBehavior.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public FieldBehavior findValueByNumber(int i) {
            return FieldBehavior.forNumber(i);
        }
    };
    private final int value;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this == UNRECOGNIZED) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        return this.value;
    }

    @Deprecated
    public static FieldBehavior valueOf(int i) {
        return forNumber(i);
    }

    public static FieldBehavior forNumber(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return IMMUTABLE;
                        }
                        return INPUT_ONLY;
                    }
                    return OUTPUT_ONLY;
                }
                return REQUIRED;
            }
            return OPTIONAL;
        }
        return FIELD_BEHAVIOR_UNSPECIFIED;
    }

    public static Internal.EnumLiteMap<FieldBehavior> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FieldBehaviorVerifier.INSTANCE;
    }

    /* loaded from: classes7.dex */
    static final class FieldBehaviorVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new FieldBehaviorVerifier();

        private FieldBehaviorVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public final boolean isInRange(int i) {
            return FieldBehavior.forNumber(i) != null;
        }
    }

    FieldBehavior(int i) {
        this.value = i;
    }
}
