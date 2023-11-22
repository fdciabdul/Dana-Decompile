package com.alibaba.griver.video.listeners;

import android.graphics.Point;
import android.os.Bundle;

/* loaded from: classes6.dex */
public abstract class DefaultBeeVideoPlayerListener implements BeeVideoPlayerListener {
    public void didFinishPlay() {
    }

    public void didStartPlay() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onControlsShow(String str, boolean z, Object obj) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onFirstFrameRendered() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onFullScreenStateChanged(boolean z, String str) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onGainAudioFocus() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onHeadsetConnectChanged(boolean z, boolean z2) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onLossAudioFocus() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onPlayerInfo(int i, String str, Bundle bundle) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onProgressUpdate(long j, long j2, long j3) {
    }

    public void onReuseFirstFrameRendered() {
    }

    public void onReuseVideoSizeChanged(int i, int i2) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public boolean onStopClicked() {
        return true;
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onVideoSizeChanged(int i, int i2, Bundle bundle) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void onViewClicked(Point point, Point point2) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerBuffering() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerBufferingEnd() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerError(int i, String str, Bundle bundle) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerPaused() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerPlayCompletion() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerPlaying() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerPrepared(Bundle bundle) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerSeekComplete(boolean z) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerSeeking() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerStateChanged(int i, int i2) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerStopped() {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerToolbarAction(String str, Object obj) {
    }

    @Override // com.alibaba.griver.video.listeners.BeeVideoPlayerListener
    public void playerToolbarAction(String str, Object obj, boolean z) {
    }

    public void reportFirstFrameRendered() {
    }
}
