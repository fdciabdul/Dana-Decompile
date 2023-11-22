package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    public final void getAuthRequestContext(final LottieValueCallback<String> lottieValueCallback) {
        final LottieFrameInfo lottieFrameInfo = new LottieFrameInfo();
        final DocumentData documentData = new DocumentData();
        super.BuiltInFictitiousFunctionClassFactory(new LottieValueCallback<DocumentData>() { // from class: com.airbnb.lottie.animation.keyframe.TextKeyframeAnimation.1
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public final /* synthetic */ DocumentData BuiltInFictitiousFunctionClassFactory(LottieFrameInfo<DocumentData> lottieFrameInfo2) {
                DocumentData documentData2;
                lottieFrameInfo.MyBillsEntityDataFactory(lottieFrameInfo2.moveToNextValue, lottieFrameInfo2.KClassImpl$Data$declaredNonStaticMembers$2, lottieFrameInfo2.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0, lottieFrameInfo2.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, lottieFrameInfo2.getAuthRequestContext, lottieFrameInfo2.PlaceComponentResult, lottieFrameInfo2.MyBillsEntityDataFactory);
                String str = (String) lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieFrameInfo);
                if (lottieFrameInfo2.PlaceComponentResult == 1.0f) {
                    documentData2 = lottieFrameInfo2.BuiltInFictitiousFunctionClassFactory;
                } else {
                    documentData2 = lottieFrameInfo2.lookAheadTest;
                }
                DocumentData documentData3 = documentData2;
                documentData.PlaceComponentResult(str, documentData3.KClassImpl$Data$declaredNonStaticMembers$2, documentData3.lookAheadTest, documentData3.getAuthRequestContext, documentData3.GetContactSyncConfig, documentData3.MyBillsEntityDataFactory, documentData3.PlaceComponentResult, documentData3.BuiltInFictitiousFunctionClassFactory, documentData3.moveToNextValue, documentData3.scheduleImpl, documentData3.getErrorConfigVersion);
                return documentData;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    final /* synthetic */ Object MyBillsEntityDataFactory(Keyframe keyframe, float f) {
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            LottieValueCallback<A> lottieValueCallback = this.BuiltInFictitiousFunctionClassFactory;
            return (DocumentData) lottieValueCallback.BuiltInFictitiousFunctionClassFactory(lottieValueCallback.scheduleImpl.MyBillsEntityDataFactory(keyframe.lookAheadTest, keyframe.MyBillsEntityDataFactory == null ? Float.MAX_VALUE : keyframe.MyBillsEntityDataFactory.floatValue(), (DocumentData) keyframe.moveToNextValue, keyframe.KClassImpl$Data$declaredNonStaticMembers$2 == 0 ? keyframe.moveToNextValue : keyframe.KClassImpl$Data$declaredNonStaticMembers$2, f, getAuthRequestContext(), KClassImpl$Data$declaredNonStaticMembers$2()));
        } else if (f != 1.0f || keyframe.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            return (DocumentData) keyframe.moveToNextValue;
        } else {
            return (DocumentData) keyframe.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
