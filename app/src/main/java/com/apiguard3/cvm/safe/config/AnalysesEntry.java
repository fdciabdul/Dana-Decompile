package com.apiguard3.cvm.safe.config;

import com.apiguard3.internal.setWillNotDraw;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class AnalysesEntry implements setWillNotDraw<String>, Serializable {
    private static int APIGuard = 1;
    private static int getSharedInstance = 0;
    private static final long serialVersionUID = -1592337098982454365L;
    private String urlPattern;

    @Override // com.apiguard3.internal.setWillNotDraw
    public /* synthetic */ String AGState() {
        int i = APIGuard + 13;
        getSharedInstance = i % 128;
        if (i % 2 == 0) {
            return values();
        }
        values();
        throw new NullPointerException();
    }

    public AnalysesEntry(String str) {
        this.urlPattern = str;
    }

    public String values() {
        int i = (APIGuard + 63) % 128;
        getSharedInstance = i;
        String str = this.urlPattern;
        int i2 = i + 41;
        APIGuard = i2 % 128;
        if (i2 % 2 == 0) {
            throw new NullPointerException();
        }
        return str;
    }
}
