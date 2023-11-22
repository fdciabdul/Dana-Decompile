package com.alibaba.griver.video;

/* loaded from: classes6.dex */
public interface IVideoControl {
    long getCurrentPosition();

    long getDuration();

    void pausePlay();

    void resumePlay();

    void seekTo(long j);
}
