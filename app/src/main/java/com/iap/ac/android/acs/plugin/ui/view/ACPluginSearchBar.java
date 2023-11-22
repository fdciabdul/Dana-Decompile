package com.iap.ac.android.acs.plugin.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.transition.R;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class ACPluginSearchBar extends EditText {
    public Drawable mClearBtnDrawable;
    public OnSearchListener mOnSearchListener;

    /* loaded from: classes8.dex */
    public interface OnSearchListener {
        void onSearch(CharSequence charSequence);
    }

    public ACPluginSearchBar(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        int dp2px = UIUtils.dp2px(getContext(), 20);
        Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.acplugin_clear_icon);
        this.mClearBtnDrawable = Resources_getDrawable;
        Resources_getDrawable.setBounds(0, 0, dp2px, dp2px);
        setClearBtnVisible(false);
        addTextChangedListener(new TextWatcher() { // from class: com.iap.ac.android.acs.plugin.ui.view.ACPluginSearchBar.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ACPluginSearchBar.this.setClearBtnVisible(!TextUtils.isEmpty(charSequence));
                if (ACPluginSearchBar.this.mOnSearchListener != null) {
                    ACPluginSearchBar.this.mOnSearchListener.onSearch(charSequence);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClearBtnVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.mClearBtnDrawable : null, getCompoundDrawables()[3]);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            setCursorVisible(false);
            setClearBtnVisible(false);
            return;
        }
        setCursorVisible(true);
        setClearBtnVisible(true ^ TextUtils.isEmpty(getText().toString()));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((getCompoundDrawables()[2] != null) && motionEvent.getAction() == 1) {
            if (motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.mClearBtnDrawable.getIntrinsicWidth()))) {
                ACLog.d("IAPConnectPlugin", "ACPluginSearchBar#onTouchEvent, click X button");
                setText("");
                setClearBtnVisible(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnSearchListener(OnSearchListener onSearchListener) {
        this.mOnSearchListener = onSearchListener;
    }

    public ACPluginSearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public ACPluginSearchBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
