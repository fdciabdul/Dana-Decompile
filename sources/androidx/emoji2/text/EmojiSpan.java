package androidx.emoji2.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

/* loaded from: classes3.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    private final EmojiMetadata KClassImpl$Data$declaredNonStaticMembers$2;
    private final Paint.FontMetricsInt MyBillsEntityDataFactory = new Paint.FontMetricsInt();
    private short getAuthRequestContext = -1;
    private short PlaceComponentResult = -1;
    private float BuiltInFictitiousFunctionClassFactory = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiSpan(EmojiMetadata emojiMetadata) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(emojiMetadata, "metadata cannot be null");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = emojiMetadata;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.MyBillsEntityDataFactory);
        this.BuiltInFictitiousFunctionClassFactory = (Math.abs(this.MyBillsEntityDataFactory.descent - this.MyBillsEntityDataFactory.ascent) * 1.0f) / this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
        this.PlaceComponentResult = (short) (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult() * this.BuiltInFictitiousFunctionClassFactory);
        this.getAuthRequestContext = (short) (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() * this.BuiltInFictitiousFunctionClassFactory);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = this.MyBillsEntityDataFactory.ascent;
            fontMetricsInt.descent = this.MyBillsEntityDataFactory.descent;
            fontMetricsInt.top = this.MyBillsEntityDataFactory.top;
            fontMetricsInt.bottom = this.MyBillsEntityDataFactory.bottom;
        }
        return this.getAuthRequestContext;
    }

    public final EmojiMetadata KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }
}
