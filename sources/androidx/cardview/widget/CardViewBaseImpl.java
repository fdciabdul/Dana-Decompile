package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* loaded from: classes3.dex */
class CardViewBaseImpl implements CardViewImpl {
    final RectF PlaceComponentResult = new RectF();

    @Override // androidx.cardview.widget.CardViewImpl
    public void getErrorConfigVersion(CardViewDelegate cardViewDelegate) {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void PlaceComponentResult() {
        RoundRectDrawableWithShadow.BuiltInFictitiousFunctionClassFactory = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: androidx.cardview.widget.CardViewBaseImpl.1
            @Override // androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper
            public void PlaceComponentResult(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = f * 2.0f;
                float width = (rectF.width() - f2) - 1.0f;
                float height = rectF.height();
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    CardViewBaseImpl.this.PlaceComponentResult.set(f4, f4, f3, f3);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(CardViewBaseImpl.this.PlaceComponentResult, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.PlaceComponentResult, 180.0f, 90.0f, true, paint);
                    canvas.translate((height - f2) - 1.0f, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.PlaceComponentResult, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.PlaceComponentResult, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, (rectF.right - f3) + 1.0f, rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, (rectF.right - f3) + 1.0f, rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void PlaceComponentResult(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        RoundRectDrawableWithShadow PlaceComponentResult = PlaceComponentResult(context, colorStateList, f, f2, f3);
        PlaceComponentResult.PlaceComponentResult = cardViewDelegate.BuiltInFictitiousFunctionClassFactory();
        PlaceComponentResult.invalidateSelf();
        cardViewDelegate.MyBillsEntityDataFactory(PlaceComponentResult);
        moveToNextValue(cardViewDelegate);
    }

    private RoundRectDrawableWithShadow PlaceComponentResult(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f, f2, f3);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void moveToNextValue(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        scheduleImpl(cardViewDelegate).getPadding(rect);
        cardViewDelegate.BuiltInFictitiousFunctionClassFactory((int) Math.ceil(getAuthRequestContext(cardViewDelegate)), (int) Math.ceil(MyBillsEntityDataFactory(cardViewDelegate)));
        cardViewDelegate.MyBillsEntityDataFactory(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void lookAheadTest(CardViewDelegate cardViewDelegate) {
        RoundRectDrawableWithShadow scheduleImpl = scheduleImpl(cardViewDelegate);
        scheduleImpl.PlaceComponentResult = cardViewDelegate.BuiltInFictitiousFunctionClassFactory();
        scheduleImpl.invalidateSelf();
        moveToNextValue(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void KClassImpl$Data$declaredNonStaticMembers$2(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        RoundRectDrawableWithShadow scheduleImpl = scheduleImpl(cardViewDelegate);
        scheduleImpl.MyBillsEntityDataFactory(colorStateList);
        scheduleImpl.invalidateSelf();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList PlaceComponentResult(CardViewDelegate cardViewDelegate) {
        return scheduleImpl(cardViewDelegate).KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void MyBillsEntityDataFactory(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawableWithShadow scheduleImpl = scheduleImpl(cardViewDelegate);
        if (f >= 0.0f) {
            float f2 = (int) (f + 0.5f);
            if (scheduleImpl.getAuthRequestContext != f2) {
                scheduleImpl.getAuthRequestContext = f2;
                scheduleImpl.MyBillsEntityDataFactory = true;
                scheduleImpl.invalidateSelf();
            }
            moveToNextValue(cardViewDelegate);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid radius ");
        sb.append(f);
        sb.append(". Must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float NetworkUserEntityData$$ExternalSyntheticLambda0(CardViewDelegate cardViewDelegate) {
        return scheduleImpl(cardViewDelegate).getAuthRequestContext;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void getAuthRequestContext(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawableWithShadow scheduleImpl = scheduleImpl(cardViewDelegate);
        scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(f, scheduleImpl.scheduleImpl);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float BuiltInFictitiousFunctionClassFactory(CardViewDelegate cardViewDelegate) {
        return scheduleImpl(cardViewDelegate).NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void BuiltInFictitiousFunctionClassFactory(CardViewDelegate cardViewDelegate, float f) {
        RoundRectDrawableWithShadow scheduleImpl = scheduleImpl(cardViewDelegate);
        scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0, f);
        moveToNextValue(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float KClassImpl$Data$declaredNonStaticMembers$2(CardViewDelegate cardViewDelegate) {
        return scheduleImpl(cardViewDelegate).scheduleImpl;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getAuthRequestContext(CardViewDelegate cardViewDelegate) {
        RoundRectDrawableWithShadow scheduleImpl = scheduleImpl(cardViewDelegate);
        float f = scheduleImpl.scheduleImpl;
        return (Math.max(f, scheduleImpl.getAuthRequestContext + scheduleImpl.lookAheadTest + (f / 2.0f)) * 2.0f) + ((scheduleImpl.scheduleImpl + scheduleImpl.lookAheadTest) * 2.0f);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float MyBillsEntityDataFactory(CardViewDelegate cardViewDelegate) {
        RoundRectDrawableWithShadow scheduleImpl = scheduleImpl(cardViewDelegate);
        float f = scheduleImpl.scheduleImpl;
        return (Math.max(f, scheduleImpl.getAuthRequestContext + scheduleImpl.lookAheadTest + ((f * 1.5f) / 2.0f)) * 2.0f) + (((scheduleImpl.scheduleImpl * 1.5f) + scheduleImpl.lookAheadTest) * 2.0f);
    }

    private RoundRectDrawableWithShadow scheduleImpl(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
