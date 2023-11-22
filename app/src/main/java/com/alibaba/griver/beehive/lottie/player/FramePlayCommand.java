package com.alibaba.griver.beehive.lottie.player;

import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class FramePlayCommand extends AbstractPlayCommand {
    private static final String TAG = "LottiePlayer:FramePlayCommand";
    private int end;
    private int initRepeatCount;
    private LottiePlayer lottiePlayer;
    private int repeatCount;
    private int start;

    public FramePlayCommand(LottiePlayer lottiePlayer, int i, int i2, int i3) {
        this.lottiePlayer = lottiePlayer;
        this.start = i;
        this.end = i2;
        this.repeatCount = i3;
        this.initRepeatCount = i3;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.AbstractPlayCommand
    public void play() {
        StringBuilder sb = new StringBuilder();
        sb.append("Command play repeatCount=");
        sb.append(this.repeatCount);
        sb.append(",");
        sb.append(this.lottiePlayer.getLottieSource());
        GriverLogger.d(TAG, sb.toString());
        this.lottiePlayer.play(this.start, this.end);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.AbstractPlayCommand
    public void repeatPlay() {
        StringBuilder sb = new StringBuilder();
        sb.append("Command repeatPlay repeatCount=");
        sb.append(this.repeatCount);
        sb.append(",");
        sb.append(this.lottiePlayer.getLottieSource());
        GriverLogger.d(TAG, sb.toString());
        int i = this.repeatCount;
        if (i > 0) {
            this.repeatCount = i - 1;
        } else if (i == 0) {
            return;
        }
        play();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.AbstractPlayCommand
    public boolean continueToRePlay() {
        return this.repeatCount != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FramePlayCommand{lottiePlayer=");
        sb.append(this.lottiePlayer);
        sb.append(", start=");
        sb.append(this.start);
        sb.append(", end=");
        sb.append(this.end);
        sb.append(", repeatCount=");
        sb.append(this.repeatCount);
        sb.append('}');
        return sb.toString();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.AbstractPlayCommand
    public void reset() {
        this.repeatCount = this.initRepeatCount;
    }
}
