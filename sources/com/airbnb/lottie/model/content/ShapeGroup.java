package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeGroup implements ContentModel {
    public final List<ContentModel> KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    public final String getAuthRequestContext;

    public ShapeGroup(String str, List<ContentModel> list, boolean z) {
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.MyBillsEntityDataFactory = z;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content BuiltInFictitiousFunctionClassFactory(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeGroup{name='");
        sb.append(this.getAuthRequestContext);
        sb.append("' Shapes: ");
        sb.append(Arrays.toString(this.KClassImpl$Data$declaredNonStaticMembers$2.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
