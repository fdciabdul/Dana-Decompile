package com.google.firebase.heartbeatinfo;

/* loaded from: classes.dex */
public interface HeartBeatInfo {
    HeartBeat getHeartBeatCode(String str);

    /* loaded from: classes3.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }
}
