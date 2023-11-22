package com.alibaba.griver.video.base;

/* loaded from: classes6.dex */
public class PlayerState {
    public static final int STATE_CONFIGURED = 1;
    public static final int STATE_ERROR = -1;
    public static final int STATE_INITED = 0;
    public static final int STATE_PAUSED = 3;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_STOPPED = 4;
    public static final int STATE_UNKNOWN = -100;

    public static String state2String(int i) {
        return i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : "STATE_STOPPED" : "STATE_PAUSED" : "STATE_PLAYING" : "STATE_CONFIGURED" : "STATE_INITED" : "STATE_ERROR";
    }
}
