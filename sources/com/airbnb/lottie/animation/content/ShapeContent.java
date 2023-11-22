package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    private final LottieDrawable BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    private boolean getAuthRequestContext;
    private final ShapeKeyframeAnimation getErrorConfigVersion;
    private final Path PlaceComponentResult = new Path();
    private final CompoundTrimPathContent lookAheadTest = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shapePath.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = shapePath.getAuthRequestContext();
        this.BuiltInFictitiousFunctionClassFactory = lottieDrawable;
        ShapeKeyframeAnimation shapeKeyframeAnimation = new ShapeKeyframeAnimation(shapePath.MyBillsEntityDataFactory.PlaceComponentResult);
        this.getErrorConfigVersion = shapeKeyframeAnimation;
        baseLayer.MyBillsEntityDataFactory.add(shapeKeyframeAnimation);
        shapeKeyframeAnimation.MyBillsEntityDataFactory.add(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.BuiltInFictitiousFunctionClassFactory == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.lookAheadTest.BuiltInFictitiousFunctionClassFactory.add(trimPathContent);
                    trimPathContent.PlaceComponentResult.add(this);
                }
            }
            if (content instanceof ShapeModifierContent) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((ShapeModifierContent) content);
            }
        }
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.getAuthRequestContext) {
            return this.PlaceComponentResult;
        }
        this.PlaceComponentResult.reset();
        if (this.MyBillsEntityDataFactory) {
            this.getAuthRequestContext = true;
            return this.PlaceComponentResult;
        }
        Path NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0();
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            return this.PlaceComponentResult;
        }
        this.PlaceComponentResult.set(NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.PlaceComponentResult.setFillType(Path.FillType.EVEN_ODD);
        this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
        this.getAuthRequestContext = true;
        return this.PlaceComponentResult;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory.invalidateSelf();
    }
}
