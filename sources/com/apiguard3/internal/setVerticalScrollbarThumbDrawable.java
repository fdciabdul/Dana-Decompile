package com.apiguard3.internal;

import java.util.Random;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setVerticalScrollbarThumbDrawable implements unregisterForContextMenu {
    private static Random getSharedInstance = new Random();
    private static int valueOf = 1;
    private static int values;
    private onContextItemSelected AGState = new setFadingEdgeLength();
    private final byte[] APIGuard;

    static {
        int i = values + 77;
        valueOf = i % 128;
        if ((i % 2 != 0 ? 'Z' : (char) 2) == 'Z') {
            return;
        }
        throw new ArithmeticException();
    }

    public setVerticalScrollbarThumbDrawable() {
        byte[] bArr = new byte[32];
        this.APIGuard = bArr;
        getSharedInstance.nextBytes(bArr);
    }

    @Override // com.apiguard3.internal.unregisterForContextMenu
    public final byte[] values(byte[] bArr) {
        int i = valueOf + 39;
        values = i % 128;
        if ((i % 2 != 0 ? '!' : Typography.quote) == '!') {
            this.AGState.values(bArr, this.APIGuard);
            throw null;
        }
        byte[] values2 = this.AGState.values(bArr, this.APIGuard);
        valueOf = (values + 41) % 128;
        return values2;
    }

    @Override // com.apiguard3.internal.unregisterForContextMenu
    public final byte[] APIGuard(byte[] bArr) {
        values = (valueOf + 123) % 128;
        byte[] AGState = this.AGState.AGState(bArr, this.APIGuard);
        values = (valueOf + 81) % 128;
        return AGState;
    }
}
