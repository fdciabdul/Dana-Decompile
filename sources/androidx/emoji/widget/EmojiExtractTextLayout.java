package androidx.emoji.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.inputmethodservice.InputMethodService;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.emoji.R;

/* loaded from: classes6.dex */
public class EmojiExtractTextLayout extends LinearLayout {
    private ExtractButtonCompat BuiltInFictitiousFunctionClassFactory;
    private ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;
    private EmojiExtractEditText MyBillsEntityDataFactory;
    private boolean PlaceComponentResult;
    private View.OnClickListener getAuthRequestContext;

    public EmojiExtractTextLayout(Context context) {
        super(context);
        BuiltInFictitiousFunctionClassFactory(context, null, 0, 0);
    }

    public EmojiExtractTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        BuiltInFictitiousFunctionClassFactory(context, attributeSet, 0, 0);
    }

    public EmojiExtractTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        BuiltInFictitiousFunctionClassFactory(context, attributeSet, i, 0);
    }

    public EmojiExtractTextLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        BuiltInFictitiousFunctionClassFactory(context, attributeSet, i, i2);
    }

    private void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet, int i, int i2) {
        if (this.PlaceComponentResult) {
            return;
        }
        this.PlaceComponentResult = true;
        setOrientation(0);
        View inflate = LayoutInflater.from(context).inflate(R.layout.input_method_extract_view, (ViewGroup) this, true);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (ViewGroup) inflate.findViewById(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a08ff);
        this.BuiltInFictitiousFunctionClassFactory = (ExtractButtonCompat) inflate.findViewById(R.id.getAuthRequestContext_res_0x7f0a0900);
        this.MyBillsEntityDataFactory = (EmojiExtractEditText) inflate.findViewById(16908325);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, i, i2);
            ViewCompat.MyBillsEntityDataFactory(this, context, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, attributeSet, obtainStyledAttributes, i, i2);
            this.MyBillsEntityDataFactory.setEmojiReplaceStrategy(obtainStyledAttributes.getInteger(R.styleable.getAuthRequestContext, 0));
            obtainStyledAttributes.recycle();
        }
    }

    public void setEmojiReplaceStrategy(int i) {
        this.MyBillsEntityDataFactory.setEmojiReplaceStrategy(i);
    }

    public int getEmojiReplaceStrategy() {
        return this.MyBillsEntityDataFactory.getEmojiReplaceStrategy();
    }

    public void onUpdateExtractingViews(InputMethodService inputMethodService, EditorInfo editorInfo) {
        if (inputMethodService.isExtractViewShown() && this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            boolean z = true;
            if (editorInfo.actionLabel == null && ((editorInfo.imeOptions & 255) == 1 || (editorInfo.imeOptions & 536870912) != 0 || editorInfo.inputType == 0)) {
                z = false;
            }
            if (z) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                if (this.BuiltInFictitiousFunctionClassFactory != null) {
                    if (editorInfo.actionLabel != null) {
                        this.BuiltInFictitiousFunctionClassFactory.setText(editorInfo.actionLabel);
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory.setText(inputMethodService.getTextForImeAction(editorInfo.imeOptions));
                    }
                    ExtractButtonCompat extractButtonCompat = this.BuiltInFictitiousFunctionClassFactory;
                    if (this.getAuthRequestContext == null) {
                        this.getAuthRequestContext = new ButtonOnclickListener(inputMethodService);
                    }
                    extractButtonCompat.setOnClickListener(this.getAuthRequestContext);
                    return;
                }
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
            ExtractButtonCompat extractButtonCompat2 = this.BuiltInFictitiousFunctionClassFactory;
            if (extractButtonCompat2 != null) {
                extractButtonCompat2.setOnClickListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class ButtonOnclickListener implements View.OnClickListener {
        private final InputMethodService BuiltInFictitiousFunctionClassFactory;

        ButtonOnclickListener(InputMethodService inputMethodService) {
            this.BuiltInFictitiousFunctionClassFactory = inputMethodService;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EditorInfo currentInputEditorInfo = this.BuiltInFictitiousFunctionClassFactory.getCurrentInputEditorInfo();
            InputConnection currentInputConnection = this.BuiltInFictitiousFunctionClassFactory.getCurrentInputConnection();
            if (currentInputEditorInfo == null || currentInputConnection == null) {
                return;
            }
            if (currentInputEditorInfo.actionId != 0) {
                currentInputConnection.performEditorAction(currentInputEditorInfo.actionId);
            } else if ((currentInputEditorInfo.imeOptions & 255) != 1) {
                currentInputConnection.performEditorAction(currentInputEditorInfo.imeOptions & 255);
            }
        }
    }
}
