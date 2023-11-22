package com.alibaba.griver.video.listeners;

import android.graphics.Point;
import android.os.Bundle;

/* loaded from: classes6.dex */
public interface BeeVideoPlayerListener {
    void onControlsShow(String str, boolean z, Object obj);

    void onFirstFrameRendered();

    void onFullScreenStateChanged(boolean z, String str);

    void onGainAudioFocus();

    void onHeadsetConnectChanged(boolean z, boolean z2);

    void onLossAudioFocus();

    void onPlayerInfo(int i, String str, Bundle bundle);

    void onProgressUpdate(long j, long j2);

    void onProgressUpdate(long j, long j2, long j3);

    boolean onStopClicked();

    void onVideoSizeChanged(int i, int i2, Bundle bundle);

    void onViewClicked(Point point, Point point2);

    void playerBuffering();

    void playerBufferingEnd();

    void playerError(int i, String str, Bundle bundle);

    void playerPaused();

    void playerPlayCompletion();

    void playerPlaying();

    void playerPrepared(Bundle bundle);

    void playerSeekComplete(boolean z);

    void playerSeeking();

    void playerStateChanged(int i, int i2);

    void playerStopped();

    void playerToolbarAction(String str, Object obj);

    void playerToolbarAction(String str, Object obj, boolean z);
}
