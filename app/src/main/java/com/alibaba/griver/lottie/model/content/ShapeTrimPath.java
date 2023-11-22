package com.alibaba.griver.lottie.model.content;

import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.animation.content.Content;
import com.alibaba.griver.lottie.animation.content.TrimPathContent;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.layer.BaseLayer;

/* loaded from: classes6.dex */
public class ShapeTrimPath implements ContentModel {
    private final AnimatableFloatValue end;
    private final boolean hidden;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableFloatValue start;
    private final Type type;

    /* loaded from: classes6.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i) {
            if (i != 1) {
                if (i == 2) {
                    return INDIVIDUALLY;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown trim path type ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.name = str;
        this.type = type;
        this.start = animatableFloatValue;
        this.end = animatableFloatValue2;
        this.offset = animatableFloatValue3;
        this.hidden = z;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public AnimatableFloatValue getEnd() {
        return this.end;
    }

    public AnimatableFloatValue getStart() {
        return this.start;
    }

    public AnimatableFloatValue getOffset() {
        return this.offset;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Override // com.alibaba.griver.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trim Path: {start: ");
        sb.append(this.start);
        sb.append(", end: ");
        sb.append(this.end);
        sb.append(", offset: ");
        sb.append(this.offset);
        sb.append("}");
        return sb.toString();
    }
}
