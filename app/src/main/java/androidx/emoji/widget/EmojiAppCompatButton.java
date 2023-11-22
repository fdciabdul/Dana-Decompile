package androidx.emoji.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;

/* loaded from: classes6.dex */
public class EmojiAppCompatButton extends AppCompatButton {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private EmojiTextViewHelper getAuthRequestContext;

    public EmojiAppCompatButton(Context context) {
        super(context);
        PlaceComponentResult();
    }

    public EmojiAppCompatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PlaceComponentResult();
    }

    public EmojiAppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlaceComponentResult();
    }

    private void PlaceComponentResult() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult.PlaceComponentResult(inputFilterArr));
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult.MyBillsEntityDataFactory(z);
    }

    private EmojiTextViewHelper KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        return this.getAuthRequestContext;
    }
}
