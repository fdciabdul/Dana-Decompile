package com.alibaba.griver.lottie.model.content;

import android.graphics.PointF;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.animation.content.Content;
import com.alibaba.griver.lottie.animation.content.RectangleContent;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatablePointValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableValue;
import com.alibaba.griver.lottie.model.layer.BaseLayer;

/* loaded from: classes6.dex */
public class RectangleShape implements ContentModel {
    private final AnimatableFloatValue cornerRadius;
    private final boolean hidden;
    private final String name;
    private final AnimatableValue<PointF, PointF> position;
    private final AnimatablePointValue size;

    public RectangleShape(String str, AnimatableValue<PointF, PointF> animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.name = str;
        this.position = animatableValue;
        this.size = animatablePointValue;
        this.cornerRadius = animatableFloatValue;
        this.hidden = z;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableFloatValue getCornerRadius() {
        return this.cornerRadius;
    }

    public AnimatablePointValue getSize() {
        return this.size;
    }

    public AnimatableValue<PointF, PointF> getPosition() {
        return this.position;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.alibaba.griver.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RectangleShape{position=");
        sb.append(this.position);
        sb.append(", size=");
        sb.append(this.size);
        sb.append('}');
        return sb.toString();
    }
}
