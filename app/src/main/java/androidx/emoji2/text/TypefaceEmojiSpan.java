package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;

/* loaded from: classes6.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    private static Paint BuiltInFictitiousFunctionClassFactory;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory()) {
            float f2 = i3;
            float BuiltInFictitiousFunctionClassFactory2 = f + BuiltInFictitiousFunctionClassFactory();
            float f3 = i5;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                TextPaint textPaint = new TextPaint();
                BuiltInFictitiousFunctionClassFactory = textPaint;
                textPaint.setColor(EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult());
                BuiltInFictitiousFunctionClassFactory.setStyle(Paint.Style.FILL);
            }
            canvas.drawRect(f, f2, BuiltInFictitiousFunctionClassFactory2, f3, BuiltInFictitiousFunctionClassFactory);
        }
        EmojiMetadata KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        Typeface typeface = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(), KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext * 2, 2, f, i4, paint);
        paint.setTypeface(typeface2);
    }
}
