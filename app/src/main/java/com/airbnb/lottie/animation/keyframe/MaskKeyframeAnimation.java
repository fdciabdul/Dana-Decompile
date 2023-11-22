package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class MaskKeyframeAnimation {
    public final List<BaseKeyframeAnimation<Integer, Integer>> BuiltInFictitiousFunctionClassFactory;
    public final List<BaseKeyframeAnimation<ShapeData, Path>> MyBillsEntityDataFactory;
    public final List<Mask> getAuthRequestContext;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.getAuthRequestContext = list;
        this.MyBillsEntityDataFactory = new ArrayList(list.size());
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.MyBillsEntityDataFactory.add(new ShapeKeyframeAnimation(list.get(i).PlaceComponentResult.PlaceComponentResult));
            this.BuiltInFictitiousFunctionClassFactory.add(new IntegerKeyframeAnimation(list.get(i).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult));
        }
    }
}
