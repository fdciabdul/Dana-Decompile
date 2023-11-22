package com.alibaba.griver.lottie.parser;

import android.graphics.PointF;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatablePathValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableScaleValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableValue;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.lottie.value.Keyframe;
import com.alibaba.griver.lottie.value.ScaleXY;
import id.dana.data.constant.BranchLinkConstant;

/* loaded from: classes6.dex */
public class AnimatableTransformParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("a", BranchLinkConstant.PayloadKey.PROMO_CODE, "s", "rz", BranchLinkConstant.PayloadKey.REFERRAL, "o", RVParams.SHOW_OPTION_MENU, "eo", "sk", "sa");
    private static JsonReader.Options ANIMATABLE_NAMES = JsonReader.Options.of("k");

    private AnimatableTransformParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.griver.lottie.model.animatable.AnimatableTransform parse(com.alibaba.griver.lottie.parser.moshi.JsonReader r27, com.alibaba.griver.lottie.LottieComposition r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.parser.AnimatableTransformParser.parse(com.alibaba.griver.lottie.parser.moshi.JsonReader, com.alibaba.griver.lottie.LottieComposition):com.alibaba.griver.lottie.model.animatable.AnimatableTransform");
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        return animatablePathValue == null || (animatablePathValue.isStatic() && animatablePathValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f));
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        return animatableValue == null || (!(animatableValue instanceof AnimatableSplitDimensionPathValue) && animatableValue.isStatic() && animatableValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f));
    }

    private static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    private static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        return animatableScaleValue == null || (animatableScaleValue.isStatic() && ((ScaleXY) ((Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f));
    }

    private static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    private static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }
}
