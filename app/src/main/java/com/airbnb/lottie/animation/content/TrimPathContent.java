package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    final ShapeTrimPath.Type BuiltInFictitiousFunctionClassFactory;
    public final BaseKeyframeAnimation<?, Float> KClassImpl$Data$declaredNonStaticMembers$2;
    public final BaseKeyframeAnimation<?, Float> MyBillsEntityDataFactory;
    final List<BaseKeyframeAnimation.AnimationListener> PlaceComponentResult = new ArrayList();
    public final BaseKeyframeAnimation<?, Float> getAuthRequestContext;
    private final String lookAheadTest;
    private final boolean moveToNextValue;

    @Override // com.airbnb.lottie.animation.content.Content
    public final void MyBillsEntityDataFactory(List<Content> list, List<Content> list2) {
    }

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        this.lookAheadTest = shapeTrimPath.getAuthRequestContext;
        this.moveToNextValue = shapeTrimPath.KClassImpl$Data$declaredNonStaticMembers$2();
        this.BuiltInFictitiousFunctionClassFactory = shapeTrimPath.BuiltInFictitiousFunctionClassFactory;
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(shapeTrimPath.MyBillsEntityDataFactory.PlaceComponentResult);
        this.getAuthRequestContext = floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2 = new FloatKeyframeAnimation(shapeTrimPath.PlaceComponentResult.PlaceComponentResult);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = floatKeyframeAnimation2;
        FloatKeyframeAnimation floatKeyframeAnimation3 = new FloatKeyframeAnimation(shapeTrimPath.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        this.MyBillsEntityDataFactory = floatKeyframeAnimation3;
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation2);
        baseLayer.MyBillsEntityDataFactory.add(floatKeyframeAnimation3);
        floatKeyframeAnimation.MyBillsEntityDataFactory.add(this);
        floatKeyframeAnimation2.MyBillsEntityDataFactory.add(this);
        floatKeyframeAnimation3.MyBillsEntityDataFactory.add(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void PlaceComponentResult() {
        for (int i = 0; i < this.PlaceComponentResult.size(); i++) {
            this.PlaceComponentResult.get(i).PlaceComponentResult();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getAuthRequestContext() {
        return this.lookAheadTest;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
