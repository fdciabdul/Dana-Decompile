package androidx.emoji.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
public class EmojiAppCompatTextView extends AppCompatTextView {
    private boolean MyBillsEntityDataFactory;
    private EmojiTextViewHelper getAuthRequestContext;

    public EmojiAppCompatTextView(Context context) {
        super(context);
        PlaceComponentResult();
    }

    public EmojiAppCompatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PlaceComponentResult();
    }

    public EmojiAppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlaceComponentResult();
    }

    private void PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        this.MyBillsEntityDataFactory = true;
        getAuthRequestContext().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getAuthRequestContext().PlaceComponentResult.PlaceComponentResult(inputFilterArr));
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getAuthRequestContext().PlaceComponentResult.MyBillsEntityDataFactory(z);
    }

    private EmojiTextViewHelper getAuthRequestContext() {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        return this.getAuthRequestContext;
    }
}
