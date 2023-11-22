package androidx.emoji.text;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

/* loaded from: classes6.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    private final EmojiMetadata KClassImpl$Data$declaredNonStaticMembers$2;
    private final Paint.FontMetricsInt getAuthRequestContext = new Paint.FontMetricsInt();
    private short MyBillsEntityDataFactory = -1;
    private short BuiltInFictitiousFunctionClassFactory = -1;
    private float PlaceComponentResult = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiSpan(EmojiMetadata emojiMetadata) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(emojiMetadata, "metadata cannot be null");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = emojiMetadata;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.getAuthRequestContext);
        this.PlaceComponentResult = (Math.abs(this.getAuthRequestContext.descent - this.getAuthRequestContext.ascent) * 1.0f) / this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory = (short) (this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory() * this.PlaceComponentResult);
        this.MyBillsEntityDataFactory = (short) (this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult() * this.PlaceComponentResult);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = this.getAuthRequestContext.ascent;
            fontMetricsInt.descent = this.getAuthRequestContext.descent;
            fontMetricsInt.top = this.getAuthRequestContext.top;
            fontMetricsInt.bottom = this.getAuthRequestContext.bottom;
        }
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final EmojiMetadata MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
