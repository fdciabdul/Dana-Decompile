package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class Layer {
    public final long BuiltInFictitiousFunctionClassFactory;
    final int DatabaseTableConfigUtil;
    final AnimatableTransform FragmentBottomSheetPaymentSettingBinding;
    final int GetContactSyncConfig;
    final DropShadowEffect KClassImpl$Data$declaredNonStaticMembers$2;
    final List<Keyframe<Float>> MyBillsEntityDataFactory;
    final MatteType NetworkUserEntityData$$ExternalSyntheticLambda0;
    final List<ContentModel> NetworkUserEntityData$$ExternalSyntheticLambda1;
    final int NetworkUserEntityData$$ExternalSyntheticLambda2;
    final float NetworkUserEntityData$$ExternalSyntheticLambda4;
    final AnimatableFloatValue NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    final AnimatableTextFrame NetworkUserEntityData$$ExternalSyntheticLambda7;
    final int NetworkUserEntityData$$ExternalSyntheticLambda8;
    final BlurEffect PlaceComponentResult;
    final AnimatableTextProperties PrepareContext;
    final LottieComposition getAuthRequestContext;
    final long getErrorConfigVersion;
    final String initRecordTimeStamp;
    final int isLayoutRequested;
    public final LayerType lookAheadTest;
    final String moveToNextValue;
    final float newProxyInstance;
    final List<Mask> scheduleImpl;

    /* loaded from: classes3.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes3.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, AnimatableTransform animatableTransform, int i, int i2, int i3, float f, float f2, int i4, int i5, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean z, BlurEffect blurEffect, DropShadowEffect dropShadowEffect) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = list;
        this.getAuthRequestContext = lottieComposition;
        this.moveToNextValue = str;
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.lookAheadTest = layerType;
        this.getErrorConfigVersion = j2;
        this.initRecordTimeStamp = str2;
        this.scheduleImpl = list2;
        this.FragmentBottomSheetPaymentSettingBinding = animatableTransform;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = i;
        this.isLayoutRequested = i2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = i3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = f;
        this.newProxyInstance = f2;
        this.GetContactSyncConfig = i4;
        this.DatabaseTableConfigUtil = i5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = animatableTextFrame;
        this.PrepareContext = animatableTextProperties;
        this.MyBillsEntityDataFactory = list3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = matteType;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = animatableFloatValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = z;
        this.PlaceComponentResult = blurEffect;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dropShadowEffect;
    }

    public String toString() {
        return getAuthRequestContext("");
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6;
    }

    public final String getAuthRequestContext(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.moveToNextValue);
        sb.append("\n");
        Layer MyBillsEntityDataFactory = this.getAuthRequestContext.lookAheadTest.MyBillsEntityDataFactory(this.getErrorConfigVersion, null);
        if (MyBillsEntityDataFactory != null) {
            sb.append("\t\tParents: ");
            sb.append(MyBillsEntityDataFactory.moveToNextValue);
            Layer MyBillsEntityDataFactory2 = this.getAuthRequestContext.lookAheadTest.MyBillsEntityDataFactory(MyBillsEntityDataFactory.getErrorConfigVersion, null);
            while (MyBillsEntityDataFactory2 != null) {
                sb.append("->");
                sb.append(MyBillsEntityDataFactory2.moveToNextValue);
                MyBillsEntityDataFactory2 = this.getAuthRequestContext.lookAheadTest.MyBillsEntityDataFactory(MyBillsEntityDataFactory2.getErrorConfigVersion, null);
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!this.scheduleImpl.isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(this.scheduleImpl.size());
            sb.append("\n");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != 0 && this.isLayoutRequested != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda8), Integer.valueOf(this.isLayoutRequested), Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda2)));
        }
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda1.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (ContentModel contentModel : this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(contentModel);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
