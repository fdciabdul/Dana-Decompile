package ru.noties.markwon.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

/* loaded from: classes6.dex */
public class LinkSpan extends URLSpan {
    private final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final Resolver MyBillsEntityDataFactory;
    private final SpannableTheme PlaceComponentResult;

    /* loaded from: classes6.dex */
    public interface Resolver {
        void BuiltInFictitiousFunctionClassFactory(View view, String str);
    }

    public LinkSpan(SpannableTheme spannableTheme, String str, Resolver resolver) {
        super(str);
        this.PlaceComponentResult = spannableTheme;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = resolver;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(view, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.PlaceComponentResult.getAuthRequestContext(textPaint);
    }
}
