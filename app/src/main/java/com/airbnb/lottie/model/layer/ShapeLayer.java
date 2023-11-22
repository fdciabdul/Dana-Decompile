package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final CompositionLayer moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer, CompositionLayer compositionLayer) {
        super(lottieDrawable, layer);
        this.moveToNextValue = compositionLayer;
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.NetworkUserEntityData$$ExternalSyntheticLambda1, false));
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = contentGroup;
        contentGroup.MyBillsEntityDataFactory(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    final void BuiltInFictitiousFunctionClassFactory(Canvas canvas, Matrix matrix, int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(canvas, matrix, i);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void getAuthRequestContext(RectF rectF, Matrix matrix, boolean z) {
        super.getAuthRequestContext(rectF, matrix, z);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(rectF, this.BuiltInFictitiousFunctionClassFactory, z);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final BlurEffect BuiltInFictitiousFunctionClassFactory() {
        BlurEffect BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory();
        return BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : this.moveToNextValue.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final DropShadowEffect KClassImpl$Data$declaredNonStaticMembers$2() {
        DropShadowEffect KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
        return KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2 : this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    protected final void getAuthRequestContext(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(keyPath, i, list, keyPath2);
    }
}
