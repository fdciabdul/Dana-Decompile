package com.alibaba.griver.video.base;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class BeeVideoPlayerBuilder {
    public VideoConfig mVideoConfig = new VideoConfig();
    public UIConfig mUIConfig = new UIConfig();

    public BeeVideoPlayerBuilder setAutoHideInterval(long j) {
        if (j <= 0) {
            j = 3000;
        }
        this.mUIConfig.hideInterval = j;
        return this;
    }

    @Deprecated
    public BeeVideoPlayerBuilder setNeedTouchEvent(boolean z) {
        this.mUIConfig.needTouchEvent = z;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedBottomToolBar(boolean z, boolean z2) {
        this.mUIConfig.needBottomToolbar = z;
        this.mUIConfig.showBottomBarWhenStarted = z2;
        return this;
    }

    public BeeVideoPlayerBuilder setAlwaysShowBottomBar(boolean z) {
        this.mUIConfig.alwaysShowBottomBar = z;
        return this;
    }

    public BeeVideoPlayerBuilder setAlwaysShowSliceProgress(boolean z) {
        this.mUIConfig.alwaysShowSliceProgress = z;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedSliceProgressBar(boolean z) {
        this.mUIConfig.needSliceProgress = z;
        return this;
    }

    public BeeVideoPlayerBuilder setToolbarBackground(Drawable drawable) {
        this.mUIConfig.useUserBackground = true;
        this.mUIConfig.bottomBackground = drawable;
        return this;
    }

    public BeeVideoPlayerBuilder setToolbarStyle(boolean z, boolean z2) {
        this.mUIConfig.showControlBar = z;
        this.mUIConfig.showMuteBtn = z2;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedPlayBtnOrMuteBtn(boolean z, boolean z2) {
        this.mUIConfig.showPlayBtn = z;
        this.mUIConfig.showMuteBtn = z2;
        return this;
    }

    public BeeVideoPlayerBuilder setHandleTouchEventByPlaceHolder(boolean z) {
        this.mUIConfig.handleTouchEventByPlaceHolder = z;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedAdjustPlaySpeed(boolean z) {
        this.mUIConfig.showAdjustPlaySpeed = z;
        return this;
    }

    public BeeVideoPlayerBuilder setToolbarStyle(boolean z, boolean z2, boolean z3) {
        setToolbarStyle(z, z2);
        this.mUIConfig.showFullScreenBtn = z3;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedCloseBtn(boolean z, int i, boolean z2) {
        this.mUIConfig.needCloseBtn = z;
        this.mUIConfig.closeBtnPos = i;
        this.mUIConfig.showCloseBtnWhenStarted = z2;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedCenterPlayBtn(boolean z, boolean z2) {
        this.mUIConfig.needCenterPlayBtn = z;
        this.mUIConfig.showCenterPlayBtnWhenStarted = z2;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedBufferingView(boolean z) {
        this.mUIConfig.needBufferingView = z;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedErrorHint(boolean z) {
        this.mUIConfig.needErrorHint = z;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedMobileNetHint(boolean z) {
        if (z) {
            this.mUIConfig.mobileNetHintLevel = 1;
        } else {
            this.mUIConfig.mobileNetHintLevel = 0;
        }
        return this;
    }

    public BeeVideoPlayerBuilder setMobileNetHintLevel(int i) {
        this.mUIConfig.mobileNetHintLevel = i;
        return this;
    }

    public BeeVideoPlayerBuilder setSeekbarForeColor(String str) {
        this.mUIConfig.seekbarForeColor = str;
        return this;
    }

    public BeeVideoPlayerBuilder setHandleTouchEvent(boolean z) {
        this.mUIConfig.handleTouchEvent = z;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedSwipeClose(boolean z, int i) {
        this.mUIConfig.needSwipeClose = z;
        this.mUIConfig.swipeDirection = i;
        return this;
    }

    public BeeVideoPlayerBuilder setPlaceHolderDrawable(String str, Drawable drawable) {
        this.mUIConfig.placeHolderId = str;
        this.mUIConfig.placeHolderDefaultDrawable = drawable;
        return this;
    }

    public BeeVideoPlayerBuilder showFirstFrameAsPoster(boolean z) {
        this.mUIConfig.showFirstFrameAsPoster = z;
        return this;
    }

    public BeeVideoPlayerBuilder setShowPlaceHolderWhenStopped(boolean z) {
        this.mUIConfig.showPlaceHolderWhenStopped = z;
        return this;
    }

    public BeeVideoPlayerBuilder setPosterUrl(String str) {
        this.mUIConfig.posterUrl = str;
        return this;
    }

    public BeeVideoPlayerBuilder setVideoId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mVideoConfig.videoId = str.trim();
        }
        return this;
    }

    public BeeVideoPlayerBuilder setBusinessId(String str) {
        this.mVideoConfig.businessId = str;
        return this;
    }

    public BeeVideoPlayerBuilder setKeepScreenOn(boolean z) {
        this.mVideoConfig.keepScreenOn = z;
        return this;
    }

    public BeeVideoPlayerBuilder setLooping(boolean z) {
        this.mVideoConfig.isLooping = z;
        this.mVideoConfig.loopCount = Integer.MAX_VALUE;
        return this;
    }

    public BeeVideoPlayerBuilder setLoopCount(int i) {
        this.mVideoConfig.isLooping = true;
        if (i <= 0) {
            this.mVideoConfig.loopCount = Integer.MAX_VALUE;
        } else {
            this.mVideoConfig.loopCount = i;
        }
        return this;
    }

    public BeeVideoPlayerBuilder setNeedPlayHistory(boolean z) {
        this.mUIConfig.needPlayHistory = z;
        return this;
    }

    public BeeVideoPlayerBuilder setMobileNetPromptBackgroundUrl(String str) {
        this.mUIConfig.mobileNetHintBackgroundUrl = str;
        return this;
    }

    public BeeVideoPlayerBuilder setPlayerStoppedCoverUrl(String str) {
        this.mUIConfig.playerStoppedCoverUrl = str;
        return this;
    }

    public BeeVideoPlayerBuilder forceUseLocalStorage() {
        this.mVideoConfig.forceOpenLocalStorage = true;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedContentSecurity(boolean z) {
        this.mVideoConfig.needContentSecurity = z;
        return this;
    }

    public BeeVideoPlayerBuilder setVideoDuration(long j) {
        this.mVideoConfig.videoDuration = j;
        return this;
    }

    public BeeVideoPlayerBuilder setSelfLooping(boolean z, long j, long j2) {
        this.mVideoConfig.selfLooping = z;
        this.mVideoConfig.loopingStartPos = j;
        this.mVideoConfig.loopingStopPos = j2;
        return this;
    }

    public BeeVideoPlayerBuilder setMuteWhenStartPlaying(boolean z) {
        this.mVideoConfig.isMuteWhenPlaying = z;
        return this;
    }

    public BeeVideoPlayerBuilder setExtraInfo(JSONObject jSONObject) {
        this.mVideoConfig.extraInfo = jSONObject;
        return this;
    }

    public BeeVideoPlayerBuilder setCCodeFromYouku(String str) {
        this.mVideoConfig.youkuCCode = str;
        return this;
    }

    public BeeVideoPlayerBuilder setPlayEffect(int i) {
        this.mVideoConfig.videoEffect = i;
        return this;
    }

    public BeeVideoPlayerBuilder setAutoFitCenter(boolean z) {
        this.mVideoConfig.autoFitCenter = z;
        return this;
    }

    public BeeVideoPlayerBuilder setThumbUrl(String str) {
        this.mVideoConfig.thumbUrl = str;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedThumbnail(boolean z) {
        this.mVideoConfig.needThumbnail = z;
        return this;
    }

    public BeeVideoPlayerBuilder setNeedFullScreen(boolean z) {
        this.mVideoConfig.needCenterCrop = z;
        return this;
    }

    public BeeVideoPlayerBuilder setVideoDimension(int i, int i2) {
        this.mVideoConfig.videoWidth = i;
        this.mVideoConfig.videoHeight = i2;
        return this;
    }

    public BeeVideoPlayerBuilder setVideoRotation(int i) {
        this.mVideoConfig.videoRotation = i;
        return this;
    }

    public BeeVideoPlayerBuilder addExtraConfig(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mVideoConfig.addExtra(str, str2);
        }
        return this;
    }

    public VideoConfig buildVideoConfig() {
        return this.mVideoConfig;
    }

    public UIConfig buildUIConfig() {
        return this.mUIConfig;
    }
}
