package androidx.emoji.widget;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.Button;
import androidx.core.widget.TextViewCompat;

/* loaded from: classes6.dex */
public class EmojiButton extends Button {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private EmojiTextViewHelper getAuthRequestContext;

    public EmojiButton(Context context) {
        super(context);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public EmojiButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public EmojiButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public EmojiButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        this.getAuthRequestContext.PlaceComponentResult.MyBillsEntityDataFactory(z);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.BuiltInFictitiousFunctionClassFactory(this, callback));
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new EmojiTextViewHelper(this);
        }
        super.setFilters(this.getAuthRequestContext.PlaceComponentResult.PlaceComponentResult(inputFilterArr));
    }
}
