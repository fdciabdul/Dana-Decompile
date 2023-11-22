package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CardViewApi21Impl implements CardViewImpl {
    @Override // androidx.cardview.widget.CardViewImpl
    public void PlaceComponentResult() {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void PlaceComponentResult(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        cardViewDelegate.MyBillsEntityDataFactory(new RoundRectDrawable(colorStateList, f));
        View MyBillsEntityDataFactory = cardViewDelegate.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.setClipToOutline(true);
        MyBillsEntityDataFactory.setElevation(f2);
        BuiltInFictitiousFunctionClassFactory(cardViewDelegate, f3);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void MyBillsEntityDataFactory(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawable scheduleImpl = scheduleImpl(cardViewDelegate);
        if (f != scheduleImpl.BuiltInFictitiousFunctionClassFactory) {
            scheduleImpl.BuiltInFictitiousFunctionClassFactory = f;
            scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(null);
            scheduleImpl.invalidateSelf();
        }
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void BuiltInFictitiousFunctionClassFactory(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawable scheduleImpl = scheduleImpl(cardViewDelegate);
        boolean PlaceComponentResult = cardViewDelegate.PlaceComponentResult();
        boolean BuiltInFictitiousFunctionClassFactory = cardViewDelegate.BuiltInFictitiousFunctionClassFactory();
        if (f != scheduleImpl.getAuthRequestContext || scheduleImpl.MyBillsEntityDataFactory != PlaceComponentResult || scheduleImpl.PlaceComponentResult != BuiltInFictitiousFunctionClassFactory) {
            scheduleImpl.getAuthRequestContext = f;
            scheduleImpl.MyBillsEntityDataFactory = PlaceComponentResult;
            scheduleImpl.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(null);
            scheduleImpl.invalidateSelf();
        }
        moveToNextValue(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float KClassImpl$Data$declaredNonStaticMembers$2(CardViewDelegate cardViewDelegate) {
        return scheduleImpl(cardViewDelegate).getAuthRequestContext;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getAuthRequestContext(CardViewDelegate cardViewDelegate) {
        return NetworkUserEntityData$$ExternalSyntheticLambda0(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float MyBillsEntityDataFactory(CardViewDelegate cardViewDelegate) {
        return NetworkUserEntityData$$ExternalSyntheticLambda0(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float NetworkUserEntityData$$ExternalSyntheticLambda0(CardViewDelegate cardViewDelegate) {
        return scheduleImpl(cardViewDelegate).BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void getAuthRequestContext(CardViewDelegate cardViewDelegate, float f) {
        cardViewDelegate.MyBillsEntityDataFactory().setElevation(f);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float BuiltInFictitiousFunctionClassFactory(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.MyBillsEntityDataFactory().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void moveToNextValue(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.PlaceComponentResult()) {
            cardViewDelegate.MyBillsEntityDataFactory(0, 0, 0, 0);
            return;
        }
        float KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(cardViewDelegate);
        float NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(cardViewDelegate);
        int ceil = (int) Math.ceil(RoundRectDrawableWithShadow.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda0, cardViewDelegate.BuiltInFictitiousFunctionClassFactory()));
        int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, NetworkUserEntityData$$ExternalSyntheticLambda0, cardViewDelegate.BuiltInFictitiousFunctionClassFactory()));
        cardViewDelegate.MyBillsEntityDataFactory(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void getErrorConfigVersion(CardViewDelegate cardViewDelegate) {
        BuiltInFictitiousFunctionClassFactory(cardViewDelegate, KClassImpl$Data$declaredNonStaticMembers$2(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void lookAheadTest(CardViewDelegate cardViewDelegate) {
        BuiltInFictitiousFunctionClassFactory(cardViewDelegate, KClassImpl$Data$declaredNonStaticMembers$2(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void KClassImpl$Data$declaredNonStaticMembers$2(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        RoundRectDrawable scheduleImpl = scheduleImpl(cardViewDelegate);
        scheduleImpl.BuiltInFictitiousFunctionClassFactory(colorStateList);
        scheduleImpl.invalidateSelf();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList PlaceComponentResult(CardViewDelegate cardViewDelegate) {
        return scheduleImpl(cardViewDelegate).KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private RoundRectDrawable scheduleImpl(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
