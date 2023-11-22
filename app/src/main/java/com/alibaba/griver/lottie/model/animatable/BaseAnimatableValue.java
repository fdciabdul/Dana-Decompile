package com.alibaba.griver.lottie.model.animatable;

import com.alibaba.griver.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> keyframes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.keyframes = list;
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public List<Keyframe<V>> getKeyframes() {
        return this.keyframes;
    }

    @Override // com.alibaba.griver.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.keyframes.isEmpty()) {
            return true;
        }
        return this.keyframes.size() == 1 && this.keyframes.get(0).isStatic();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.keyframes.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.keyframes.toArray()));
        }
        return sb.toString();
    }
}
