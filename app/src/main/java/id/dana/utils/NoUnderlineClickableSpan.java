package id.dana.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes5.dex */
public class NoUnderlineClickableSpan extends ClickableSpan {
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    private OnClickListener MyBillsEntityDataFactory;
    private Intent getAuthRequestContext;

    /* loaded from: classes5.dex */
    public interface OnClickListener {
        void PlaceComponentResult();
    }

    public NoUnderlineClickableSpan(Context context, Intent intent) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.getAuthRequestContext = intent;
    }

    public NoUnderlineClickableSpan(OnClickListener onClickListener) {
        this.MyBillsEntityDataFactory = onClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Intent intent = this.getAuthRequestContext;
        if (intent != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.startActivity(intent);
        } else {
            this.MyBillsEntityDataFactory.PlaceComponentResult();
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
    }
}
