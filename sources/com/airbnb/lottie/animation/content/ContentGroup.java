package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final LottieDrawable BuiltInFictitiousFunctionClassFactory;
    private final List<Content> KClassImpl$Data$declaredNonStaticMembers$2;
    TransformKeyframeAnimation MyBillsEntityDataFactory;
    private List<PathContent> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final boolean PlaceComponentResult;
    final Matrix getAuthRequestContext;
    private final String getErrorConfigVersion;
    private final RectF initRecordTimeStamp;
    private final RectF lookAheadTest;
    private final Path moveToNextValue;
    private final Paint scheduleImpl;

    private static List<Content> PlaceComponentResult(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Content BuiltInFictitiousFunctionClassFactory = list.get(i).BuiltInFictitiousFunctionClassFactory(lottieDrawable, baseLayer);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                arrayList.add(BuiltInFictitiousFunctionClassFactory);
            }
        }
        return arrayList;
    }

    private static AnimatableTransform BuiltInFictitiousFunctionClassFactory(List<ContentModel> list) {
        for (int i = 0; i < list.size(); i++) {
            ContentModel contentModel = list.get(i);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, List<Content> list, AnimatableTransform animatableTransform) {
        this.scheduleImpl = new LPaint();
        this.lookAheadTest = new RectF();
        this.getAuthRequestContext = new Matrix();
        this.moveToNextValue = new Path();
        this.initRecordTimeStamp = new RectF();
        this.getErrorConfigVersion = str;
        this.BuiltInFictitiousFunctionClassFactory = lottieDrawable;
        this.PlaceComponentResult = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
            this.MyBillsEntityDataFactory = transformKeyframeAnimation;
            transformKeyframeAnimation.MyBillsEntityDataFactory(baseLayer);
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).BuiltInFictitiousFunctionClassFactory(list.listIterator(list.size()));
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.getErrorConfigVersion;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.KClassImpl$Data$declaredNonStaticMembers$2.size());
        arrayList.addAll(list);
        for (int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
            Content content = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
            content.MyBillsEntityDataFactory(arrayList, this.KClassImpl$Data$declaredNonStaticMembers$2.subList(0, size));
            arrayList.add(content);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<PathContent> BuiltInFictitiousFunctionClassFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
            for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
                Content content = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
                if (content instanceof PathContent) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add((PathContent) content);
                }
            }
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.MyBillsEntityDataFactory;
        if (transformKeyframeAnimation != null) {
            this.getAuthRequestContext.set(transformKeyframeAnimation.PlaceComponentResult());
        }
        this.moveToNextValue.reset();
        if (this.PlaceComponentResult) {
            return this.moveToNextValue;
        }
        for (int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
            Content content = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
            if (content instanceof PathContent) {
                this.moveToNextValue.addPath(((PathContent) content).KClassImpl$Data$declaredNonStaticMembers$2(), this.getAuthRequestContext);
            }
        }
        return this.moveToNextValue;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(Canvas canvas, Matrix matrix, int i) {
        if (this.PlaceComponentResult) {
            return;
        }
        this.getAuthRequestContext.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.MyBillsEntityDataFactory;
        if (transformKeyframeAnimation != null) {
            this.getAuthRequestContext.preConcat(transformKeyframeAnimation.PlaceComponentResult());
            i = (int) (((((this.MyBillsEntityDataFactory.MyBillsEntityDataFactory == null ? 100 : this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp() && MyBillsEntityDataFactory() && i != 255;
        if (z) {
            this.lookAheadTest.set(0.0f, 0.0f, 0.0f, 0.0f);
            getAuthRequestContext(this.lookAheadTest, this.getAuthRequestContext, true);
            this.scheduleImpl.setAlpha(i);
            Utils.getAuthRequestContext(canvas, this.lookAheadTest, this.scheduleImpl);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
            Content content = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getAuthRequestContext(canvas, this.getAuthRequestContext, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    private boolean MyBillsEntityDataFactory() {
        int i = 0;
        for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i2++) {
            if ((this.KClassImpl$Data$declaredNonStaticMembers$2.get(i2) instanceof DrawingContent) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        this.getAuthRequestContext.set(matrix);
        TransformKeyframeAnimation transformKeyframeAnimation = this.MyBillsEntityDataFactory;
        if (transformKeyframeAnimation != null) {
            this.getAuthRequestContext.preConcat(transformKeyframeAnimation.PlaceComponentResult());
        }
        this.initRecordTimeStamp.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size() - 1; size >= 0; size--) {
            Content content = this.KClassImpl$Data$declaredNonStaticMembers$2.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getAuthRequestContext(this.initRecordTimeStamp, this.getAuthRequestContext, z);
                rectF.union(this.initRecordTimeStamp);
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final <T> void PlaceComponentResult(T t, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.MyBillsEntityDataFactory;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.BuiltInFictitiousFunctionClassFactory(t, lottieValueCallback);
        }
    }

    public ContentGroup(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable, baseLayer, shapeGroup.getAuthRequestContext, shapeGroup.MyBillsEntityDataFactory(), PlaceComponentResult(lottieDrawable, baseLayer, shapeGroup.KClassImpl$Data$declaredNonStaticMembers$2), BuiltInFictitiousFunctionClassFactory(shapeGroup.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void KClassImpl$Data$declaredNonStaticMembers$2(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.getAuthRequestContext(this.getErrorConfigVersion, i) || "__container".equals(this.getErrorConfigVersion)) {
            if (!"__container".equals(this.getErrorConfigVersion)) {
                String str = this.getErrorConfigVersion;
                KeyPath keyPath3 = new KeyPath(keyPath2);
                keyPath3.KClassImpl$Data$declaredNonStaticMembers$2.add(str);
                if (keyPath.PlaceComponentResult(this.getErrorConfigVersion, i)) {
                    KeyPath keyPath4 = new KeyPath(keyPath3);
                    keyPath4.BuiltInFictitiousFunctionClassFactory = this;
                    list.add(keyPath4);
                }
                keyPath2 = keyPath3;
            }
            if (keyPath.MyBillsEntityDataFactory(this.getErrorConfigVersion, i)) {
                int BuiltInFictitiousFunctionClassFactory = keyPath.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, i);
                for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i2++) {
                    Content content = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i2);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).KClassImpl$Data$declaredNonStaticMembers$2(keyPath, i + BuiltInFictitiousFunctionClassFactory, list, keyPath2);
                    }
                }
            }
        }
    }
}
