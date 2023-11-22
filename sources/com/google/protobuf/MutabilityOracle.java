package com.google.protobuf;

/* loaded from: classes7.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() { // from class: com.google.protobuf.MutabilityOracle.1
        @Override // com.google.protobuf.MutabilityOracle
        public final void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
