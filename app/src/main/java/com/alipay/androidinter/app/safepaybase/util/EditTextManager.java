package com.alipay.androidinter.app.safepaybase.util;

/* loaded from: classes6.dex */
public class EditTextManager {
    private static EditTextUtil mEditTextUtils;

    public static EditTextUtil getEditTextUtils() {
        if (mEditTextUtils == null) {
            mEditTextUtils = new EditTextUtil();
        }
        return mEditTextUtils;
    }
}
