package androidx.emoji.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;

/* loaded from: classes6.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    private static Paint PlaceComponentResult;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (EmojiCompat.MyBillsEntityDataFactory().PlaceComponentResult()) {
            float f2 = i3;
            float BuiltInFictitiousFunctionClassFactory = f + BuiltInFictitiousFunctionClassFactory();
            float f3 = i5;
            if (PlaceComponentResult == null) {
                TextPaint textPaint = new TextPaint();
                PlaceComponentResult = textPaint;
                textPaint.setColor(EmojiCompat.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory());
                PlaceComponentResult.setStyle(Paint.Style.FILL);
            }
            canvas.drawRect(f, f2, BuiltInFictitiousFunctionClassFactory, f3, PlaceComponentResult);
        }
        EmojiMetadata MyBillsEntityDataFactory = MyBillsEntityDataFactory();
        Typeface typeface = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(), MyBillsEntityDataFactory.MyBillsEntityDataFactory * 2, 2, f, i4, paint);
        paint.setTypeface(typeface2);
    }
}
