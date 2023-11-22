package com.google.android.gms.fido.fido2.api.common;

/* loaded from: classes3.dex */
public enum EC2Algorithm implements Algorithm {
    ED256(-260),
    ED512(-261),
    ED25519(-8),
    ES256(-7),
    ECDH_HKDF_256(-25),
    ES384(-35),
    ES512(-36);

    private final int zzb;

    EC2Algorithm(int i) {
        this.zzb = i;
    }

    @Override // com.google.android.gms.fido.fido2.api.common.Algorithm
    public final int getAlgoValue() {
        return this.zzb;
    }
}
