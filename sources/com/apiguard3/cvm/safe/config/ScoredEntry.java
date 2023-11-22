package com.apiguard3.cvm.safe.config;

import com.apiguard3.internal.setWillNotDraw;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class ScoredEntry implements setWillNotDraw<String>, Serializable {
    private static int AGState = 1;
    private static final long serialVersionUID = 1452964406245549076L;
    private static int values;
    private String urlPattern;

    @Override // com.apiguard3.internal.setWillNotDraw
    public /* synthetic */ String AGState() {
        values = (AGState + 91) % 128;
        String APIGuard = APIGuard();
        AGState = (values + 23) % 128;
        return APIGuard;
    }

    public ScoredEntry(String str) {
        this.urlPattern = str;
    }

    public String APIGuard() {
        int i = AGState;
        values = (i + 97) % 128;
        String str = this.urlPattern;
        int i2 = i + 113;
        values = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        return str;
    }
}
