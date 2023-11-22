package com.alibaba.griver.video.base;

import android.graphics.drawable.Drawable;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class UIConfig implements Serializable, Cloneable {
    public static final int CLOSE_BUTTON_UP_LEFT = 0;
    public static final int CLOSE_BUTTON_UP_RIGHT = 1;
    public static final long DEFAULT_HIDE_DURATION = 3000;
    public static final int SWIPE_CLOSE_DOWN_UP = 2;
    public static final int SWIPE_CLOSE_UP_DOWN = 1;
    public Drawable placeHolderDefaultDrawable;
    public boolean showWaterMarkWhenStarted = true;
    public boolean showSliceBarWhenStarted = true;
    public long hideInterval = 3000;
    public boolean needTouchEvent = true;
    public boolean needBottomToolbar = true;
    public boolean needSliceProgress = false;
    public boolean sliceProgressSeekable = false;
    public boolean showBottomBarWhenStarted = true;
    public boolean alwaysShowBottomBar = false;
    public boolean alwaysShowSliceProgress = false;
    public boolean alwaysShowCenterPlayBtn = false;
    public boolean alwaysShowTopToolbar = false;
    public boolean useUserBackground = false;
    public Drawable bottomBackground = null;
    public boolean showControlBar = true;
    public boolean showMuteBtn = true;
    public boolean showSwitchDefinitionBtn = true;
    public boolean showAdjustPlaySpeed = true;
    public boolean showFullScreenBtn = false;
    public boolean showPlayBtn = true;
    public boolean needCloseBtn = true;
    public int closeBtnPos = 0;
    public boolean showCloseBtnWhenStarted = false;
    public boolean needCenterPlayBtn = false;
    public boolean showCenterPlayBtnWhenStarted = true;
    public boolean needBufferingView = false;
    public boolean needErrorHint = true;
    public int mobileNetHintLevel = 1;
    public boolean showFlowRate = false;
    public String mobileNetHintBackgroundUrl = "";
    public String playerStoppedCoverUrl = "";
    public boolean needBackView = true;
    public boolean needYoukuWaterMark = true;
    public boolean needSwipeClose = false;
    public int swipeDirection = 1;
    public boolean needGestureOper = false;
    public boolean needPageGesture = false;
    public boolean needProgressGesture = true;
    public boolean needPlayHistory = false;
    public boolean showFirstFrameAsPoster = true;
    public String posterUrl = "";
    public String posterSize = "";
    public String placeHolderId = "";
    public boolean showPlaceHolderWhenStopped = false;
    public String seekbarForeColor = "";
    public boolean handleTouchEvent = true;
    public boolean handleTouchEventByPlaceHolder = true;
    public boolean bufferingViewUnderPlaceHolder = false;
    public String[] customSpeedTitles = null;
    public float[] customSpeeds = null;
    public int direction = -100;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UIConfig uIConfig = (UIConfig) obj;
        if (this.hideInterval == uIConfig.hideInterval && this.needTouchEvent == uIConfig.needTouchEvent && this.needBottomToolbar == uIConfig.needBottomToolbar && this.needSliceProgress == uIConfig.needSliceProgress && this.showBottomBarWhenStarted == uIConfig.showBottomBarWhenStarted && this.alwaysShowBottomBar == uIConfig.alwaysShowBottomBar && this.useUserBackground == uIConfig.useUserBackground && this.showControlBar == uIConfig.showControlBar && this.showMuteBtn == uIConfig.showMuteBtn && this.showFullScreenBtn == uIConfig.showFullScreenBtn && this.showPlayBtn == uIConfig.showPlayBtn && this.needCloseBtn == uIConfig.needCloseBtn && this.closeBtnPos == uIConfig.closeBtnPos && this.showCloseBtnWhenStarted == uIConfig.showCloseBtnWhenStarted && this.needCenterPlayBtn == uIConfig.needCenterPlayBtn && this.showCenterPlayBtnWhenStarted == uIConfig.showCenterPlayBtnWhenStarted && this.needBufferingView == uIConfig.needBufferingView && this.needErrorHint == uIConfig.needErrorHint && this.mobileNetHintLevel == uIConfig.mobileNetHintLevel && this.showFlowRate == uIConfig.showFlowRate && this.needBackView == uIConfig.needBackView && this.needYoukuWaterMark == uIConfig.needYoukuWaterMark && this.needSwipeClose == uIConfig.needSwipeClose && this.swipeDirection == uIConfig.swipeDirection && this.needGestureOper == uIConfig.needGestureOper && this.needPageGesture == uIConfig.needPageGesture && this.needProgressGesture == uIConfig.needProgressGesture && this.showFirstFrameAsPoster == uIConfig.showFirstFrameAsPoster && this.needPlayHistory == uIConfig.needPlayHistory) {
            Drawable drawable = this.bottomBackground;
            if (drawable == null ? uIConfig.bottomBackground == null : drawable.equals(uIConfig.bottomBackground)) {
                String str = this.placeHolderId;
                if (str == null ? uIConfig.placeHolderId == null : str.equals(uIConfig.placeHolderId)) {
                    Drawable drawable2 = this.placeHolderDefaultDrawable;
                    if (drawable2 == null ? uIConfig.placeHolderDefaultDrawable == null : drawable2.equals(uIConfig.placeHolderDefaultDrawable)) {
                        String str2 = this.posterUrl;
                        if (str2 == null ? uIConfig.posterUrl == null : str2.equals(uIConfig.posterUrl)) {
                            String str3 = this.posterSize;
                            if (str3 == null ? uIConfig.posterSize == null : str3.equals(uIConfig.posterSize)) {
                                String str4 = this.seekbarForeColor;
                                String str5 = uIConfig.seekbarForeColor;
                                return str4 != null ? str4.equals(str5) : str5 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        long j = this.hideInterval;
        int i = (int) (j ^ (j >>> 32));
        boolean z = this.needTouchEvent;
        boolean z2 = this.needBottomToolbar;
        boolean z3 = this.needSliceProgress;
        boolean z4 = this.showBottomBarWhenStarted;
        boolean z5 = this.alwaysShowBottomBar;
        boolean z6 = this.useUserBackground;
        Drawable drawable = this.bottomBackground;
        int hashCode = drawable != null ? drawable.hashCode() : 0;
        boolean z7 = this.showControlBar;
        boolean z8 = this.showMuteBtn;
        boolean z9 = this.showFullScreenBtn;
        boolean z10 = this.showPlayBtn;
        boolean z11 = this.needCloseBtn;
        int i2 = this.closeBtnPos;
        boolean z12 = this.showCloseBtnWhenStarted;
        boolean z13 = this.needCenterPlayBtn;
        boolean z14 = this.showCenterPlayBtnWhenStarted;
        boolean z15 = this.needBufferingView;
        boolean z16 = this.needErrorHint;
        int i3 = this.mobileNetHintLevel;
        boolean z17 = this.showFlowRate;
        boolean z18 = this.needBackView;
        boolean z19 = this.needYoukuWaterMark;
        boolean z20 = this.needSwipeClose;
        int i4 = this.swipeDirection;
        boolean z21 = this.needGestureOper;
        boolean z22 = this.needPageGesture;
        boolean z23 = this.needProgressGesture;
        String str = this.placeHolderId;
        int hashCode2 = str != null ? str.hashCode() : 0;
        Drawable drawable2 = this.placeHolderDefaultDrawable;
        int hashCode3 = drawable2 != null ? drawable2.hashCode() : 0;
        boolean z24 = this.showFirstFrameAsPoster;
        String str2 = this.posterUrl;
        int hashCode4 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.posterSize;
        int hashCode5 = str3 != null ? str3.hashCode() : 0;
        boolean z25 = this.needPlayHistory;
        String str4 = this.seekbarForeColor;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((i * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (z3 ? 1 : 0)) * 31) + (z4 ? 1 : 0)) * 31) + (z5 ? 1 : 0)) * 31) + (z6 ? 1 : 0)) * 31) + hashCode) * 31) + (z7 ? 1 : 0)) * 31) + (z8 ? 1 : 0)) * 31) + (z9 ? 1 : 0)) * 31) + (z10 ? 1 : 0)) * 31) + (z11 ? 1 : 0)) * 31) + i2) * 31) + (z12 ? 1 : 0)) * 31) + (z13 ? 1 : 0)) * 31) + (z14 ? 1 : 0)) * 31) + (z15 ? 1 : 0)) * 31) + (z16 ? 1 : 0)) * 31) + i3) * 31) + (z17 ? 1 : 0)) * 31) + (z18 ? 1 : 0)) * 31) + (z19 ? 1 : 0)) * 31) + (z20 ? 1 : 0)) * 31) + i4) * 31) + (z21 ? 1 : 0)) * 31) + (z22 ? 1 : 0)) * 31) + (z23 ? 1 : 0)) * 31) + hashCode2) * 31) + hashCode3) * 31) + (z24 ? 1 : 0)) * 31) + hashCode4) * 31) + hashCode5) * 31) + (z25 ? 1 : 0)) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UIConfig{hideInterval=");
        sb.append(this.hideInterval);
        sb.append(", needTouchEvent=");
        sb.append(this.needTouchEvent);
        sb.append(", needBottomToolbar=");
        sb.append(this.needBottomToolbar);
        sb.append(", needSliceProgress=");
        sb.append(this.needSliceProgress);
        sb.append(", sliceProgressSeekable=");
        sb.append(this.sliceProgressSeekable);
        sb.append(", showBottomBarWhenStarted=");
        sb.append(this.showBottomBarWhenStarted);
        sb.append(", alwaysShowSliceProgress=");
        sb.append(this.alwaysShowSliceProgress);
        sb.append(", alwaysShowBottomBar=");
        sb.append(this.alwaysShowBottomBar);
        sb.append(", alwaysShowCenterPlayBtn=");
        sb.append(this.alwaysShowCenterPlayBtn);
        sb.append(", alwaysShowTopToolbar=");
        sb.append(this.alwaysShowTopToolbar);
        sb.append(", useUserBackground=");
        sb.append(this.useUserBackground);
        sb.append(", bottomBackground=");
        sb.append(this.bottomBackground);
        sb.append(", showControlBar=");
        sb.append(this.showControlBar);
        sb.append(", showMuteBtn=");
        sb.append(this.showMuteBtn);
        sb.append(", showSwitchDefinitionBtn=");
        sb.append(this.showSwitchDefinitionBtn);
        sb.append(", showAdjustPlaySpeed=");
        sb.append(this.showAdjustPlaySpeed);
        sb.append(", showFullScreenBtn=");
        sb.append(this.showFullScreenBtn);
        sb.append(", showPlayBtn=");
        sb.append(this.showPlayBtn);
        sb.append(", needCloseBtn=");
        sb.append(this.needCloseBtn);
        sb.append(", closeBtnPos=");
        sb.append(this.closeBtnPos);
        sb.append(", showCloseBtnWhenStarted=");
        sb.append(this.showCloseBtnWhenStarted);
        sb.append(", needCenterPlayBtn=");
        sb.append(this.needCenterPlayBtn);
        sb.append(", showCenterPlayBtnWhenStarted=");
        sb.append(this.showCenterPlayBtnWhenStarted);
        sb.append(", needBufferingView=");
        sb.append(this.needBufferingView);
        sb.append(", needErrorHint=");
        sb.append(this.needErrorHint);
        sb.append(", mobileNetHintLevel=");
        sb.append(this.mobileNetHintLevel);
        sb.append(", showFlowRate=");
        sb.append(this.showFlowRate);
        sb.append(", mobileNetHintBackgroundUrl='");
        sb.append(this.mobileNetHintBackgroundUrl);
        sb.append('\'');
        sb.append(", playerStoppedCoverUrl='");
        sb.append(this.playerStoppedCoverUrl);
        sb.append('\'');
        sb.append(", needBackView=");
        sb.append(this.needBackView);
        sb.append(", needYoukuWaterMark=");
        sb.append(this.needYoukuWaterMark);
        sb.append(", needSwipeClose=");
        sb.append(this.needSwipeClose);
        sb.append(", swipeDirection=");
        sb.append(this.swipeDirection);
        sb.append(", needGestureOper=");
        sb.append(this.needGestureOper);
        sb.append(", needPageGesture=");
        sb.append(this.needPageGesture);
        sb.append(", needProgressGesture=");
        sb.append(this.needProgressGesture);
        sb.append(", placeHolderId='");
        sb.append(this.placeHolderId);
        sb.append('\'');
        sb.append(", placeHolderDefaultDrawable=");
        sb.append(this.placeHolderDefaultDrawable);
        sb.append(", showPlaceHolderWhenStopped=");
        sb.append(this.showPlaceHolderWhenStopped);
        sb.append(", showFirstFrameAsPoster=");
        sb.append(this.showFirstFrameAsPoster);
        sb.append(", posterUrl='");
        sb.append(this.posterUrl);
        sb.append('\'');
        sb.append(", posterSize='");
        sb.append(this.posterSize);
        sb.append('\'');
        sb.append(", needPlayHistory=");
        sb.append(this.needPlayHistory);
        sb.append(", seekbarForeColor='");
        sb.append(this.seekbarForeColor);
        sb.append('\'');
        sb.append(", handleTouchEvent=");
        sb.append(this.handleTouchEvent);
        sb.append(", handleTouchEventByPlaceHolder=");
        sb.append(this.handleTouchEventByPlaceHolder);
        sb.append(", bufferingViewUnderPlaceHolder=");
        sb.append(this.bufferingViewUnderPlaceHolder);
        sb.append(", showWaterMarkWhenStarted=");
        sb.append(this.showWaterMarkWhenStarted);
        sb.append(", showSliceBarWhenStarted=");
        sb.append(this.showSliceBarWhenStarted);
        sb.append('}');
        return sb.toString();
    }
}
