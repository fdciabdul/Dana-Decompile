package com.alibaba.griver.lottie.animation.keyframe;

import android.graphics.Path;
import com.alibaba.griver.lottie.model.content.ShapeData;
import com.alibaba.griver.lottie.utils.MiscUtils;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    private final Path tempPath;
    private final ShapeData tempShapeData;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.tempShapeData = new ShapeData();
        this.tempPath = new Path();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    public Path getValue(Keyframe<ShapeData> keyframe, float f) {
        this.tempShapeData.interpolateBetween(keyframe.startValue, keyframe.endValue, f);
        MiscUtils.getPathFromData(this.tempShapeData, this.tempPath);
        return this.tempPath;
    }
}
