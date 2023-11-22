package com.alibaba.griver.lottie.model.content;

import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.animation.content.Content;
import com.alibaba.griver.lottie.animation.content.RepeaterContent;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableTransform;
import com.alibaba.griver.lottie.model.layer.BaseLayer;

/* loaded from: classes6.dex */
public class Repeater implements ContentModel {
    private final AnimatableFloatValue copies;
    private final boolean hidden;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableTransform transform;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z) {
        this.name = str;
        this.copies = animatableFloatValue;
        this.offset = animatableFloatValue2;
        this.transform = animatableTransform;
        this.hidden = z;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableFloatValue getCopies() {
        return this.copies;
    }

    public AnimatableFloatValue getOffset() {
        return this.offset;
    }

    public AnimatableTransform getTransform() {
        return this.transform;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.alibaba.griver.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }
}
