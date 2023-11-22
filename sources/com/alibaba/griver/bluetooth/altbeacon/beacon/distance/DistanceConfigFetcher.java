package com.alibaba.griver.bluetooth.altbeacon.beacon.distance;

/* loaded from: classes6.dex */
public class DistanceConfigFetcher {
    private static final String TAG = "DistanceConfigFetcher";
    protected Exception mException;
    protected String mResponse;
    private int mResponseCode = -1;
    private String mUrlString;
    private String mUserAgentString;

    public DistanceConfigFetcher(String str, String str2) {
        this.mUrlString = str;
        this.mUserAgentString = str2;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public String getResponseString() {
        return this.mResponse;
    }

    public Exception getException() {
        return this.mException;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc A[ADDED_TO_REGION, EDGE_INSN: B:59:0x00bc->B:40:0x00bc BREAK  A[LOOP:0: B:3:0x000d->B:63:0x000d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void request() {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.bluetooth.altbeacon.beacon.distance.DistanceConfigFetcher.request():void");
    }
}
