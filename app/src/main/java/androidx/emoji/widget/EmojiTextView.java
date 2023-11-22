package androidx.emoji.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

/* loaded from: classes6.dex */
public class EmojiTextView extends TextView {
    private EmojiTextViewHelper MyBillsEntityDataFactory;
    private boolean getAuthRequestContext;

    public EmojiTextView(Context context) {
        super(context);
        if (this.getAuthRequestContext) {
            return;
        }
        this.getAuthRequestContext = true;
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new EmojiTextViewHelper(this);
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (this.getAuthRequestContext) {
            return;
        }
        this.getAuthRequestContext = true;
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new EmojiTextViewHelper(this);
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (this.getAuthRequestContext) {
            return;
        }
        this.getAuthRequestContext = true;
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new EmojiTextViewHelper(this);
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (this.getAuthRequestContext) {
            return;
        }
        this.getAuthRequestContext = true;
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new EmojiTextViewHelper(this);
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new EmojiTextViewHelper(this);
        }
        this.MyBillsEntityDataFactory.PlaceComponentResult.MyBillsEntityDataFactory(z);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.BuiltInFictitiousFunctionClassFactory(this, callback));
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new EmojiTextViewHelper(this);
        }
        super.setFilters(this.MyBillsEntityDataFactory.PlaceComponentResult.PlaceComponentResult(inputFilterArr));
    }
}
