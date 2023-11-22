package zoloz.ap.com.toolkit.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.Map;
import zoloz.ap.com.toolkit.R;

/* loaded from: classes9.dex */
public class ReplaceTextToImgTextView extends CustomTextView {
    private Map<String, Integer> mReplaceResInfo;

    public ReplaceTextToImgTextView(Context context) {
        super(context);
        this.mReplaceResInfo = null;
    }

    public ReplaceTextToImgTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mReplaceResInfo = null;
    }

    public ReplaceTextToImgTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mReplaceResInfo = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // zoloz.ap.com.toolkit.ui.CustomTextView
    public void init(Context context, AttributeSet attributeSet) {
        super.init(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReplaceTextToImgTextView);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ReplaceTextToImgTextView_z_replace_str_array, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.ReplaceTextToImgTextView_z_replace_res_array, -1);
        if (resourceId != -1 && resourceId2 != -1) {
            parseReplaceInfo(resourceId, resourceId2);
        }
        addTextChangedListener(new TextWatcher() { // from class: zoloz.ap.com.toolkit.ui.ReplaceTextToImgTextView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ReplaceTextToImgTextView.this.updateText();
            }
        });
        setText(getText());
    }

    private void parseReplaceInfo(int i, int i2) {
        this.mReplaceResInfo = new HashMap();
        String[] stringArray = getResources().getStringArray(i);
        TypedArray obtainTypedArray = getResources().obtainTypedArray(i2);
        int length = obtainTypedArray.length();
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = obtainTypedArray.getResourceId(i3, -1);
        }
        for (int i4 = 0; i4 < stringArray.length && i4 < length; i4++) {
            this.mReplaceResInfo.put(stringArray[i4], Integer.valueOf(iArr[i4]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateText() {
        if (this.mReplaceResInfo == null) {
            return;
        }
        Editable editableText = getEditableText();
        String obj = editableText.toString();
        for (Map.Entry<String, Integer> entry : this.mReplaceResInfo.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue().intValue() != -1) {
                int indexOf = obj.indexOf(entry.getKey());
                editableText.setSpan(new CustomImgSpan(getContext(), entry.getValue().intValue(), (int) getTextSize(), (int) getTextSize()), indexOf, indexOf + 1, 18);
            }
        }
    }
}
