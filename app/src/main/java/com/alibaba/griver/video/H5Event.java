package com.alibaba.griver.video;

/* loaded from: classes6.dex */
public class H5Event {
    public static final int CODE_STATE_INFO_COMPLETION = 5;
    public static final int CODE_STATE_INFO_LOADING = 3;
    public static final int CODE_STATE_INFO_LOADING_END = 4;
    public static final int CODE_STATE_INFO_PAUSE = 2;
    public static final int CODE_STATE_INFO_PLAYING = 1;
    public static final int CODE_STATE_INFO_RENDER_START = 6;
    public static final int CODE_STATE_INFO_STOP = 0;
    public static final int CODE_STATE_INFO_VIDEO_DIMENSION = 7;
    public static final int EVENT_CHANGE_STATE = 0;
    public static final int EVENT_CONTROLS_SHOWED = 4;
    public static final int EVENT_DEFINITION_INFO = 7;
    public static final int EVENT_ERROR = -1;
    public static final int EVENT_INFO = 6;
    public static final int EVENT_SCREEN_CHANGED = 2;
    public static final int EVENT_SEI_INFO_GOT = 9;
    public static final int EVENT_SUCCESS = 100;
    public static final int EVENT_TIME_UPDATE = 1;
    public static final int EVENT_TOOLBAR_ACTION = 3;
    public static final int EVENT_UPS_INFO_GOT = 8;
    public static final int EVENT_VIEW_CLICKED = 5;
    public int code;
    public String desc;
    public int event;
    public Object extra;

    /* loaded from: classes6.dex */
    public static class TimeStruct {
        public long curPlayTime;
        public long curTime;
        public long duration;

        public TimeStruct(long j, long j2, long j3) {
            this.curTime = j;
            this.curPlayTime = j2;
            this.duration = j3;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("TimeStruct{curTime=");
            sb.append(this.curTime);
            sb.append(", curPlayTime=");
            sb.append(this.curPlayTime);
            sb.append(", duration=");
            sb.append(this.duration);
            sb.append('}');
            return sb.toString();
        }
    }

    public H5Event(int i, int i2, String str) {
        this(i, i2, str, null);
    }

    public H5Event(int i, int i2, String str, Object obj) {
        this.event = i;
        this.code = i2;
        this.desc = str;
        this.extra = obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("H5Event{event=");
        sb.append(this.event);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", desc='");
        sb.append(this.desc);
        sb.append('\'');
        sb.append(", extra=");
        sb.append(this.extra);
        sb.append('}');
        return sb.toString();
    }
}
