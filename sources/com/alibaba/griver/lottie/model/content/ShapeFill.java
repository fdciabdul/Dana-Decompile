package com.alibaba.griver.lottie.model.content;

import android.graphics.Path;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.animation.content.Content;
import com.alibaba.griver.lottie.animation.content.FillContent;
import com.alibaba.griver.lottie.model.animatable.AnimatableColorValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableIntegerValue;
import com.alibaba.griver.lottie.model.layer.BaseLayer;

/* loaded from: classes6.dex */
public class ShapeFill implements ContentModel {
    private final AnimatableColorValue color;
    private final boolean fillEnabled;
    private final Path.FillType fillType;
    private final boolean hidden;
    private final String name;
    private final AnimatableIntegerValue opacity;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.name = str;
        this.fillEnabled = z;
        this.fillType = fillType;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
        this.hidden = z2;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public Path.FillType getFillType() {
        return this.fillType;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.alibaba.griver.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeFill{color=, fillEnabled=");
        sb.append(this.fillEnabled);
        sb.append('}');
        return sb.toString();
    }
}
