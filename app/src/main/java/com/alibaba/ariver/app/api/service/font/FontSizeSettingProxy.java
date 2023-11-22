package com.alibaba.ariver.app.api.service.font;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface FontSizeSettingProxy extends Proxiable {

    /* loaded from: classes6.dex */
    public interface OnFontSizeSettingChangeListener {
        void onChange(FontSizeSetting fontSizeSetting);
    }

    FontSizeSetting getFontSizeSetting();

    void registerFontSizeChangeListener(OnFontSizeSettingChangeListener onFontSizeSettingChangeListener);

    void unRegiseterFontSizeChangeListener(OnFontSizeSettingChangeListener onFontSizeSettingChangeListener);
}
