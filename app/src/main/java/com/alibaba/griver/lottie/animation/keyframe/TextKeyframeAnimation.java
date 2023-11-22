package com.alibaba.griver.lottie.animation.keyframe;

import com.alibaba.griver.lottie.model.DocumentData;
import com.alibaba.griver.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes6.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<DocumentData>) keyframe, f);
    }

    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    @Override // com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation
    DocumentData getValue(Keyframe<DocumentData> keyframe, float f) {
        return keyframe.startValue;
    }
}
