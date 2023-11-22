package com.alibaba.griver.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import androidx.collection.ContainerHelpers;
import androidx.collection.LongSparseArray;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.lottie.LottieComposition;
import com.alibaba.griver.lottie.LottieDrawable;
import com.alibaba.griver.lottie.LottieProperty;
import com.alibaba.griver.lottie.animation.content.ContentGroup;
import com.alibaba.griver.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.TextKeyframeAnimation;
import com.alibaba.griver.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.alibaba.griver.lottie.model.DocumentData;
import com.alibaba.griver.lottie.model.Font;
import com.alibaba.griver.lottie.model.FontCharacter;
import com.alibaba.griver.lottie.model.animatable.AnimatableTextProperties;
import com.alibaba.griver.lottie.model.content.ShapeGroup;
import com.alibaba.griver.lottie.utils.Utils;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class TextLayer extends BaseLayer {
    private final String DEFAULT_TEXT_ID;
    private final String TAG;
    private final LongSparseArray<String> codePointCache;
    private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
    private final LottieComposition composition;
    private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter;
    private final Paint fillPaint;
    private final Map<String, String> lineBreakCache;
    private boolean lineBreakCacheEnabled;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final RectF rectF;
    private final StringBuilder stringBuilder;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
    private BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
    private final Paint strokePaint;
    private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
    private BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
    private final TextKeyframeAnimation textAnimation;
    private BaseKeyframeAnimation<Float, Float> textSizeAnimation;
    private BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingAnimation;
    private BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;

    public TextLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.TAG = "TextLayer";
        this.DEFAULT_TEXT_ID = "TEXT@All@";
        this.stringBuilder = new StringBuilder(2);
        this.rectF = new RectF();
        this.matrix = new Matrix();
        int i = 1;
        this.fillPaint = new Paint(i) { // from class: com.alibaba.griver.lottie.model.layer.TextLayer.1
            {
                TextLayer.this = this;
                setStyle(Paint.Style.FILL);
            }
        };
        this.strokePaint = new Paint(i) { // from class: com.alibaba.griver.lottie.model.layer.TextLayer.2
            {
                TextLayer.this = this;
                setStyle(Paint.Style.STROKE);
            }
        };
        this.contentsForCharacter = new HashMap();
        this.codePointCache = new LongSparseArray<>();
        this.lineBreakCache = new HashMap();
        this.lineBreakCacheEnabled = true;
        this.lottieDrawable = lottieDrawable;
        this.composition = layer.getComposition();
        TextKeyframeAnimation createAnimation = layer.getText().createAnimation();
        this.textAnimation = createAnimation;
        createAnimation.addUpdateListener(this);
        addAnimation(createAnimation);
        AnimatableTextProperties textProperties = layer.getTextProperties();
        if (textProperties != null && textProperties.color != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation2 = textProperties.color.createAnimation();
            this.colorAnimation = createAnimation2;
            createAnimation2.addUpdateListener(this);
            addAnimation(this.colorAnimation);
        }
        if (textProperties != null && textProperties.stroke != null) {
            BaseKeyframeAnimation<Integer, Integer> createAnimation3 = textProperties.stroke.createAnimation();
            this.strokeColorAnimation = createAnimation3;
            createAnimation3.addUpdateListener(this);
            addAnimation(this.strokeColorAnimation);
        }
        if (textProperties != null && textProperties.strokeWidth != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation4 = textProperties.strokeWidth.createAnimation();
            this.strokeWidthAnimation = createAnimation4;
            createAnimation4.addUpdateListener(this);
            addAnimation(this.strokeWidthAnimation);
        }
        if (textProperties != null && textProperties.tracking != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation5 = textProperties.tracking.createAnimation();
            this.trackingAnimation = createAnimation5;
            createAnimation5.addUpdateListener(this);
            addAnimation(this.trackingAnimation);
        }
        if (TextUtils.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_Android_LineBreak_Cache_Disable"), SummaryActivity.CHECKED)) {
            this.lineBreakCacheEnabled = false;
        }
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z) {
        super.getBounds(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.composition.getBounds().width(), this.composition.getBounds().height());
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (!this.lottieDrawable.useTextGlyphs()) {
            canvas.concat(matrix);
        }
        DocumentData value = this.textAnimation.getValue();
        Font font = this.composition.getFonts().get(value.fontName);
        if (font == null) {
            font = Font.getDefault();
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
        if (baseKeyframeAnimation != null) {
            this.fillPaint.setColor(baseKeyframeAnimation.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.colorAnimation;
            if (baseKeyframeAnimation2 != null) {
                this.fillPaint.setColor(baseKeyframeAnimation2.getValue().intValue());
            } else {
                this.fillPaint.setColor(value.color);
            }
        }
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation3 = this.strokeColorCallbackAnimation;
        if (baseKeyframeAnimation3 != null) {
            this.strokePaint.setColor(baseKeyframeAnimation3.getValue().intValue());
        } else {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation4 = this.strokeColorAnimation;
            if (baseKeyframeAnimation4 != null) {
                this.strokePaint.setColor(baseKeyframeAnimation4.getValue().intValue());
            } else {
                this.strokePaint.setColor(value.strokeColor);
            }
        }
        int intValue = ((this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue()) * 255) / 100;
        this.fillPaint.setAlpha(intValue);
        this.strokePaint.setAlpha(intValue);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.strokeWidthCallbackAnimation;
        if (baseKeyframeAnimation5 != null) {
            this.strokePaint.setStrokeWidth(baseKeyframeAnimation5.getValue().floatValue());
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.strokeWidthAnimation;
            if (baseKeyframeAnimation6 != null) {
                this.strokePaint.setStrokeWidth(baseKeyframeAnimation6.getValue().floatValue());
            } else {
                this.strokePaint.setStrokeWidth(value.strokeWidth * Utils.dpScale() * Utils.getScale(matrix));
            }
        }
        if (value.framePosition != null) {
            canvas.translate(value.framePosition.x * Utils.dpScale(), (value.framePosition.y + ((font.getAscent() * value.size) / 100.0f)) * Utils.dpScale());
        }
        if (this.lottieDrawable.useTextGlyphs()) {
            drawTextGlyphs(value, matrix, font, canvas);
        } else {
            drawTextWithFont(value, font, matrix, canvas);
        }
        canvas.restore();
    }

    private void drawTextGlyphs(DocumentData documentData, Matrix matrix, Font font, Canvas canvas) {
        float f;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.textSizeCallbackAnimation;
        if (baseKeyframeAnimation != null) {
            f = baseKeyframeAnimation.getValue().floatValue();
        } else {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.textSizeAnimation;
            if (baseKeyframeAnimation2 != null) {
                f = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                f = documentData.size;
            }
        }
        float f2 = f / 100.0f;
        float scale = Utils.getScale(matrix);
        String str = documentData.text;
        float dpScale = documentData.lineHeight * Utils.dpScale();
        List<String> textLines = getTextLines(str);
        int size = textLines.size();
        for (int i = 0; i < size; i++) {
            String str2 = textLines.get(i);
            float textLineWidthForGlyphs = getTextLineWidthForGlyphs(str2, font, f2, scale);
            canvas.save();
            applyJustification(documentData.justification, canvas, textLineWidthForGlyphs);
            canvas.translate(0.0f, (i * dpScale) - ((((float) (size - 1)) * dpScale) / 2.0f));
            drawGlyphTextLine(str2, documentData, matrix, font, canvas, scale, f2);
            canvas.restore();
        }
    }

    private void drawGlyphTextLine(String str, DocumentData documentData, Matrix matrix, Font font, Canvas canvas, float f, float f2) {
        float floatValue;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter BuiltInFictitiousFunctionClassFactory = this.composition.getCharacters().BuiltInFictitiousFunctionClassFactory(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (BuiltInFictitiousFunctionClassFactory != null) {
                drawCharacterAsGlyph(BuiltInFictitiousFunctionClassFactory, matrix, f2, documentData, canvas);
                float width = (float) BuiltInFictitiousFunctionClassFactory.getWidth();
                float dpScale = Utils.dpScale();
                float f3 = documentData.tracking / 10.0f;
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.trackingCallbackAnimation;
                if (baseKeyframeAnimation != null) {
                    floatValue = baseKeyframeAnimation.getValue().floatValue();
                } else {
                    BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.trackingAnimation;
                    if (baseKeyframeAnimation2 != null) {
                        floatValue = baseKeyframeAnimation2.getValue().floatValue();
                    }
                    canvas.translate((width * f2 * dpScale * f) + (f3 * f), 0.0f);
                }
                f3 += floatValue;
                canvas.translate((width * f2 * dpScale * f) + (f3 * f), 0.0f);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void drawTextWithFont(com.alibaba.griver.lottie.model.DocumentData r8, com.alibaba.griver.lottie.model.Font r9, android.graphics.Matrix r10, android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.model.layer.TextLayer.drawTextWithFont(com.alibaba.griver.lottie.model.DocumentData, com.alibaba.griver.lottie.model.Font, android.graphics.Matrix, android.graphics.Canvas):void");
    }

    private String processLineBreak(String str, String str2, String str3, Paint paint) {
        float measureText;
        try {
            measureText = paint.measureText(str);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("processLineBreak fail:");
            sb.append(th);
            GriverLogger.d("TextLayer", sb.toString());
        }
        if (paint.measureText(str2) <= measureText) {
            return str2;
        }
        float measureText2 = paint.measureText("....");
        if ("truncatingHead".equalsIgnoreCase(str3)) {
            int breakText = paint.breakText(str2, false, measureText - measureText2, null);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("...");
            sb2.append(str2.substring((str2.length() - breakText) - 1));
            str2 = sb2.toString();
        } else if ("truncatingTail".equalsIgnoreCase(str3)) {
            int breakText2 = paint.breakText(str2, true, measureText - measureText2, null);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2.substring(0, breakText2));
            sb3.append("...");
            str2 = sb3.toString();
        } else if ("truncatingMiddle".equalsIgnoreCase(str3)) {
            float f = (measureText - measureText2) / 2.0f;
            int breakText3 = paint.breakText(str2, true, f, null);
            int breakText4 = paint.breakText(str2, false, f, null);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2.substring(0, breakText3));
            sb4.append("...");
            sb4.append(str2.substring((str2.length() - breakText4) - 1));
            str2 = sb4.toString();
        }
        return str2;
    }

    private List<String> getTextLines(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void drawFontTextLine(String str, DocumentData documentData, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String codePointToString = codePointToString(str, i);
            i += codePointToString.length();
            drawCharacterFromFont(codePointToString, documentData, canvas);
            canvas.translate(this.fillPaint.measureText(codePointToString) + f, 0.0f);
        }
    }

    private float getTextLineWidthForGlyphs(String str, Font font, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            FontCharacter BuiltInFictitiousFunctionClassFactory = this.composition.getCharacters().BuiltInFictitiousFunctionClassFactory(FontCharacter.hashFor(str.charAt(i), font.getFamily(), font.getStyle()));
            if (BuiltInFictitiousFunctionClassFactory != null) {
                double d = f3;
                double width = BuiltInFictitiousFunctionClassFactory.getWidth();
                double d2 = f;
                double dpScale = Utils.dpScale();
                double d3 = f2;
                Double.isNaN(d2);
                Double.isNaN(dpScale);
                Double.isNaN(d3);
                Double.isNaN(d);
                f3 = (float) (d + (width * d2 * dpScale * d3));
            }
        }
        return f3;
    }

    /* renamed from: com.alibaba.griver.lottie.model.layer.TextLayer$3 */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$lottie$model$DocumentData$Justification;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            $SwitchMap$com$alibaba$griver$lottie$model$DocumentData$Justification = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$model$DocumentData$Justification[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$model$DocumentData$Justification[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void applyJustification(DocumentData.Justification justification, Canvas canvas, float f) {
        int i = AnonymousClass3.$SwitchMap$com$alibaba$griver$lottie$model$DocumentData$Justification[justification.ordinal()];
        if (i == 2) {
            canvas.translate(-f, 0.0f);
        } else if (i == 3) {
            canvas.translate((-f) / 2.0f, 0.0f);
        }
    }

    private void drawCharacterAsGlyph(FontCharacter fontCharacter, Matrix matrix, float f, DocumentData documentData, Canvas canvas) {
        List<ContentGroup> contentsForCharacter = getContentsForCharacter(fontCharacter);
        for (int i = 0; i < contentsForCharacter.size(); i++) {
            Path path = contentsForCharacter.get(i).getPath();
            path.computeBounds(this.rectF, false);
            this.matrix.set(matrix);
            this.matrix.preTranslate(0.0f, (-documentData.baselineShift) * Utils.dpScale());
            this.matrix.preScale(f, f);
            path.transform(this.matrix);
            if (documentData.strokeOverFill) {
                drawGlyph(path, this.fillPaint, canvas);
                drawGlyph(path, this.strokePaint, canvas);
            } else {
                drawGlyph(path, this.strokePaint, canvas);
                drawGlyph(path, this.fillPaint, canvas);
            }
        }
    }

    private void drawGlyph(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void drawCharacterFromFont(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.strokeOverFill) {
            drawCharacter(str, this.fillPaint, canvas);
            drawCharacter(str, this.strokePaint, canvas);
            return;
        }
        drawCharacter(str, this.strokePaint, canvas);
        drawCharacter(str, this.fillPaint, canvas);
    }

    private void drawCharacter(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<ContentGroup> getContentsForCharacter(FontCharacter fontCharacter) {
        if (this.contentsForCharacter.containsKey(fontCharacter)) {
            return this.contentsForCharacter.get(fontCharacter);
        }
        List<ShapeGroup> shapes = fontCharacter.getShapes();
        int size = shapes.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new ContentGroup(this.lottieDrawable, this, shapes.get(i)));
        }
        this.contentsForCharacter.put(fontCharacter, arrayList);
        return arrayList;
    }

    private String codePointToString(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!isModifier(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        LongSparseArray<String> longSparseArray = this.codePointCache;
        long j = codePointAt;
        if (longSparseArray.MyBillsEntityDataFactory) {
            longSparseArray.BuiltInFictitiousFunctionClassFactory();
        }
        if (ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(longSparseArray.PlaceComponentResult, longSparseArray.KClassImpl$Data$declaredNonStaticMembers$2, j) < 0) {
            this.stringBuilder.setLength(0);
            while (i < charCount) {
                int codePointAt3 = str.codePointAt(i);
                this.stringBuilder.appendCodePoint(codePointAt3);
                i += Character.charCount(codePointAt3);
            }
            String obj = this.stringBuilder.toString();
            this.codePointCache.getAuthRequestContext(j, obj);
            return obj;
        }
        return this.codePointCache.MyBillsEntityDataFactory(j, null);
    }

    private boolean isModifier(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // com.alibaba.griver.lottie.model.layer.BaseLayer, com.alibaba.griver.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t, lottieValueCallback);
        if (t == LottieProperty.COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.colorCallbackAnimation;
            if (baseKeyframeAnimation != null) {
                removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            addAnimation(this.colorCallbackAnimation);
        } else if (t == LottieProperty.STROKE_COLOR) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.strokeColorCallbackAnimation;
            if (baseKeyframeAnimation2 != null) {
                removeAnimation(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == null) {
                this.strokeColorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeColorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            addAnimation(this.strokeColorCallbackAnimation);
        } else if (t == LottieProperty.STROKE_WIDTH) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.strokeWidthCallbackAnimation;
            if (baseKeyframeAnimation3 != null) {
                removeAnimation(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.strokeWidthCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.strokeWidthCallbackAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
            addAnimation(this.strokeWidthCallbackAnimation);
        } else if (t == LottieProperty.TEXT_TRACKING) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4 = this.trackingCallbackAnimation;
            if (baseKeyframeAnimation4 != null) {
                removeAnimation(baseKeyframeAnimation4);
            }
            if (lottieValueCallback == null) {
                this.trackingCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.trackingCallbackAnimation = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            addAnimation(this.trackingCallbackAnimation);
        } else if (t == LottieProperty.TEXT_SIZE) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation5 = this.textSizeCallbackAnimation;
            if (baseKeyframeAnimation5 != null) {
                removeAnimation(baseKeyframeAnimation5);
            }
            if (lottieValueCallback == null) {
                this.textSizeCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.textSizeCallbackAnimation = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            addAnimation(this.textSizeCallbackAnimation);
        }
    }
}
