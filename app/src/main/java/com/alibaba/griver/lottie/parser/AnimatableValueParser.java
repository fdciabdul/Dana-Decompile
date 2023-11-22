package com.alibaba.griver.lottie.parser;

import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.model.animatable.AnimatableColorValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableFloatValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableGradientColorValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableIntegerValue;
import com.alibaba.griver.lottie.model.animatable.AnimatablePointValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableScaleValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableShapeValue;
import com.alibaba.griver.lottie.model.animatable.AnimatableTextFrame;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.alibaba.griver.lottie.utils.Utils;
import com.alibaba.griver.lottie.value.Keyframe;
import java.io.IOException;
import java.util.List;

/* loaded from: classes6.dex */
public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return parseFloat(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition, boolean z) throws IOException {
        return new AnimatableFloatValue(parse(jsonReader, z ? Utils.dpScale() : 1.0f, lottieComposition, FloatParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableIntegerValue parseInteger(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(parse(jsonReader, lottieComposition, IntegerParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatablePointValue parsePoint(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(parse(jsonReader, Utils.dpScale(), lottieComposition, PointFParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableScaleValue parseScale(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue(parse(jsonReader, lottieComposition, ScaleXYParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableShapeValue parseShapeData(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(parse(jsonReader, Utils.dpScale(), lottieComposition, ShapeDataParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableTextFrame parseDocumentData(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(parse(jsonReader, lottieComposition, DocumentDataParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableColorValue parseColor(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(parse(jsonReader, lottieComposition, ColorParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableGradientColorValue parseGradientColor(JsonReader jsonReader, LottieComposition lottieComposition, int i) throws IOException {
        return new AnimatableGradientColorValue(parse(jsonReader, lottieComposition, new GradientColorParser(i)));
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.parse(jsonReader, lottieComposition, 1.0f, valueParser);
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, float f, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.parse(jsonReader, lottieComposition, f, valueParser);
    }
}
