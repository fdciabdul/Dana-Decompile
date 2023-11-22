package com.alibaba.griver.video.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Surface;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.video.listeners.BeeVideoPlayerListener;
import com.alibaba.griver.video.utils.PlayerStateUtils;
import com.alibaba.griver.video.utils.SystemUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public abstract class BasePlayer extends FrameLayout {
    public static final String ACTION_CENTER_PLAY = "action_center_play";
    public static final String ACTION_ERROR_REPLAY = "action_error_replay";
    public static final String ACTION_MOBILENET_PLAY = "action_mobilenet_play";
    public static final String ACTION_TOOLBAR_FULLSCREEN = "action_toolbar_fullscreen";
    public static final String ACTION_TOOLBAR_MUTE = "action_toolbar_mute";
    public static final String ACTION_TOOLBAR_PLAY = "action_toolbar_play";
    public static final String MODE_BACKGROUND_BLUR = "background_blur";
    public static final String MODE_CONTAIN = "contain";
    public static final String MODE_FILL = "fill";
    protected static final int PREPARE_TYPE_NOT_PREPARE = 0;
    protected static final int PREPARE_TYPE_PREPARED = 2;
    protected static final int PREPARE_TYPE_PREPAREING = 1;
    protected boolean mFirstPlay;
    protected boolean mHasAudioFocus;
    public boolean mIsFullScreen;
    public boolean mIsMute;
    public long mPlayTime;
    public BeeVideoPlayerListener mPlayerListener;
    public int mPrepareType;
    protected SystemUtils mScreenUtils;
    public PlayerStateUtils mStateMachine;
    protected UIConfig mUIConfig;
    protected VideoConfig mVideoConfig;

    public abstract long getCurrentPosition();

    public abstract int getPlayerType();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    protected abstract void hideRLController();

    public abstract void onMute(boolean z);

    protected abstract void onPause();

    protected abstract void onPlay(long j);

    protected abstract void onPlayerError();

    protected abstract void onRelease();

    public abstract void onSeek(long j);

    public abstract void onSetPlayerConfig(VideoConfig videoConfig, UIConfig uIConfig);

    public abstract void onStop();

    public abstract void setPlayRate(float f);

    public abstract void setPlayerSurface(Surface surface, int i, int i2);

    public abstract void setScreenDirection(int i);

    protected abstract void showRLController();

    public Bitmap takeSnapshot() {
        return null;
    }

    public BasePlayer(Context context) {
        super(context);
        this.mPrepareType = 0;
        WeakReference<Activity> topActivity = GriverEnv.getTopActivity();
        if (topActivity != null && topActivity.get() != null) {
            this.mScreenUtils = new SystemUtils(topActivity.get(), new SystemUtils.OnAudioFocusChangedListener() { // from class: com.alibaba.griver.video.base.BasePlayer.1
                @Override // com.alibaba.griver.video.utils.SystemUtils.OnAudioFocusChangedListener
                public void onLossFocus() {
                    if (!BasePlayer.this.isPlaying() || BasePlayer.this.mIsMute) {
                        return;
                    }
                    BasePlayer.this.pause();
                    if (BasePlayer.this.mPlayerListener != null) {
                        BasePlayer.this.mPlayerListener.onLossAudioFocus();
                    }
                }

                @Override // com.alibaba.griver.video.utils.SystemUtils.OnAudioFocusChangedListener
                public void onGainFocus() {
                    if (BasePlayer.this.isPaused() && !BasePlayer.this.mFirstPlay) {
                        BasePlayer.this.play(0L);
                    }
                    if (BasePlayer.this.mPlayerListener != null) {
                        BasePlayer.this.mPlayerListener.onGainAudioFocus();
                    }
                }
            });
        }
        this.mStateMachine = new PlayerStateUtils(0);
    }

    public void setBeeVideoPlayerListener(BeeVideoPlayerListener beeVideoPlayerListener) {
        this.mPlayerListener = beeVideoPlayerListener;
    }

    public void setPlayerConfig(VideoConfig videoConfig, UIConfig uIConfig) {
        UIConfig uIConfig2;
        if (videoConfig == null || uIConfig == null) {
            return;
        }
        VideoConfig videoConfig2 = this.mVideoConfig;
        if (videoConfig2 == null || !videoConfig2.equals(videoConfig) || (uIConfig2 = this.mUIConfig) == null || !uIConfig2.equals(uIConfig)) {
            try {
                this.mVideoConfig = (VideoConfig) videoConfig.clone();
            } catch (Exception unused) {
                this.mVideoConfig = videoConfig;
            }
            try {
                this.mUIConfig = (UIConfig) uIConfig.clone();
            } catch (Exception unused2) {
                this.mUIConfig = uIConfig;
            }
            boolean z = this.mVideoConfig.isMuteWhenPlaying;
            this.mIsMute = z;
            mute(z);
            onSetPlayerConfig(videoConfig, uIConfig);
            this.mStateMachine.switchState(1);
        }
    }

    public void play(long j) {
        if (this.mStateMachine.switchState(2)) {
            this.mPlayerListener.playerPlaying();
            onPlay(j);
        }
    }

    public void pause() {
        if (this.mPrepareType == 2 && this.mStateMachine.switchState(3)) {
            this.mPlayerListener.playerPaused();
            onPause();
        }
    }

    public void stopBeforeRelease() {
        stop();
    }

    public void stop() {
        if (this.mStateMachine.switchState(4)) {
            this.mPlayerListener.playerStopped();
            this.mFirstPlay = true;
            abandonAudioFocus();
            this.mPlayTime = 0L;
            onStop();
        }
    }

    public void playerError(int i, String str, Bundle bundle) {
        this.mStateMachine.switchState(-1);
        this.mPlayerListener.playerError(i, str, bundle);
        VideoConfig videoConfig = this.mVideoConfig;
        if (videoConfig != null) {
            monit(videoConfig.videoId, String.valueOf(i), str);
        } else {
            monit("", String.valueOf(i), str);
        }
        onPlayerError();
    }

    public void mute(boolean z) {
        this.mIsMute = z;
        if (z) {
            requestAudioFocus();
        } else {
            abandonAudioFocus();
        }
        onMute(z);
    }

    public void abandonAudioFocus() {
        SystemUtils systemUtils = this.mScreenUtils;
        if (systemUtils == null || !this.mHasAudioFocus) {
            return;
        }
        systemUtils.abandonAudioFocus();
        this.mHasAudioFocus = false;
    }

    public void requestAudioFocus() {
        SystemUtils systemUtils = this.mScreenUtils;
        if (systemUtils == null || this.mHasAudioFocus) {
            return;
        }
        systemUtils.requestAudioFocus();
        this.mHasAudioFocus = true;
    }

    public void seek(long j) {
        this.mPlayerListener.playerSeekComplete(true);
        onSeek(j);
    }

    public void release() {
        onRelease();
    }

    public void switchFullScreen(final boolean z, final boolean z2) {
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.base.BasePlayer.2
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append("switchFullScreen, current mIsFullScreen=");
                sb.append(BasePlayer.this.mIsFullScreen);
                sb.append(", request fullscreen=");
                sb.append(z);
                GriverLogger.d("BasePlayerProxy", sb.toString());
                boolean z3 = BasePlayer.this.mIsFullScreen;
                boolean z4 = z;
                if (z3 == z4) {
                    return;
                }
                BasePlayer.this.mIsFullScreen = z4;
                if (BasePlayer.this.mPlayerListener != null) {
                    BasePlayer.this.mPlayerListener.playerToolbarAction(BasePlayer.ACTION_TOOLBAR_FULLSCREEN, Boolean.valueOf(BasePlayer.this.mIsFullScreen), z2);
                }
            }
        });
    }

    public void monit(String str, String str2, String str3) {
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.append("src", str).append("errorCode", str2).append("errorMessage", str3);
        GriverMonitor.event(GriverMonitorConstants.KEY_GRV_VIDEO_PLAYER_ERROR, "GriverAppContainer", builder.build());
    }

    public boolean isPlaying() {
        return this.mStateMachine.getState() == 2;
    }

    public boolean isPaused() {
        return this.mStateMachine.getState() == 3;
    }

    public void playerBufferingEnd() {
        this.mPlayerListener.playerBufferingEnd();
    }

    public void playerBuffering() {
        this.mPlayerListener.playerBuffering();
    }
}
