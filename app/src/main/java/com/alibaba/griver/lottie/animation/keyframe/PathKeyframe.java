package com.alibaba.griver.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.utils.Utils;
import com.alibaba.griver.lottie.value.Keyframe;

/* loaded from: classes6.dex */
public class PathKeyframe extends Keyframe<PointF> {
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    public void createPath() {
        boolean z = (this.endValue == 0 || this.startValue == 0 || !((PointF) this.startValue).equals(((PointF) this.endValue).x, ((PointF) this.endValue).y)) ? false : true;
        if (this.endValue == 0 || z) {
            return;
        }
        this.path = Utils.createPath((PointF) this.startValue, (PointF) this.endValue, this.pointKeyFrame.pathCp1, this.pointKeyFrame.pathCp2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path getPath() {
        return this.path;
    }
}
