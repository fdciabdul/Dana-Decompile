package com.apiguard3.cvm.safe.fs;

import com.apiguard3.internal.setWillNotDraw;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class FraudScore implements setWillNotDraw<String>, Serializable {
    private static int APIGuard = 0;
    private static int getSharedInstance = 1;
    private static final long serialVersionUID = -3520884770453645806L;
    private String score;
    private long timestamp = System.currentTimeMillis();

    @Override // com.apiguard3.internal.setWillNotDraw
    public /* synthetic */ String AGState() {
        APIGuard = (getSharedInstance + 43) % 128;
        String sharedInstance = getSharedInstance();
        int i = APIGuard + 115;
        getSharedInstance = i % 128;
        if (!(i % 2 == 0)) {
            return sharedInstance;
        }
        throw null;
    }

    public FraudScore(String str) {
        this.score = str;
    }

    public long APIGuard() {
        int i = getSharedInstance;
        APIGuard = (i + 115) % 128;
        long j = this.timestamp;
        int i2 = i + 75;
        APIGuard = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return j;
        }
        throw new NullPointerException();
    }

    public String getSharedInstance() {
        int i = getSharedInstance;
        APIGuard = (i + 19) % 128;
        String str = this.score;
        APIGuard = (i + 33) % 128;
        return str;
    }
}
