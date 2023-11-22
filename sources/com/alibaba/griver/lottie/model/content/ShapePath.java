package com.alibaba.griver.lottie.model.content;

import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.animation.content.Content;
import com.alibaba.griver.lottie.animation.content.ShapeContent;
import com.alibaba.griver.lottie.model.animatable.AnimatableShapeValue;
import com.alibaba.griver.lottie.model.layer.BaseLayer;

/* loaded from: classes6.dex */
public class ShapePath implements ContentModel {
    private final boolean hidden;
    private final int index;
    private final String name;
    private final AnimatableShapeValue shapePath;

    public ShapePath(String str, int i, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.name = str;
        this.index = i;
        this.shapePath = animatableShapeValue;
        this.hidden = z;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableShapeValue getShapePath() {
        return this.shapePath;
    }

    @Override // com.alibaba.griver.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapePath{name=");
        sb.append(this.name);
        sb.append(", index=");
        sb.append(this.index);
        sb.append('}');
        return sb.toString();
    }
}
