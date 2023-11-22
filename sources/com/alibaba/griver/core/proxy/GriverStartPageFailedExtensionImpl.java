package com.alibaba.griver.core.proxy;

import android.content.Context;
import com.alibaba.griver.api.common.page.GriverStartPageFailedExtension;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.core.R;

/* loaded from: classes6.dex */
public class GriverStartPageFailedExtensionImpl implements GriverStartPageFailedExtension {
    @Override // com.alibaba.griver.api.common.page.GriverStartPageFailedExtension
    public void startFailed(Throwable th, Context context) {
        ToastUtils.showToast(context, context.getString(R.string.griver_core_create_page_failed), 0);
    }
}
