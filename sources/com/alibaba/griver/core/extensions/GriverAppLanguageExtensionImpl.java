package com.alibaba.griver.core.extensions;

import com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension;
import java.util.Locale;

/* loaded from: classes6.dex */
public class GriverAppLanguageExtensionImpl implements GriverAppLanguageExtension {
    @Override // com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension
    public String getAppLanguage() {
        StringBuilder sb = new StringBuilder();
        sb.append(Locale.getDefault().getLanguage());
        sb.append("-");
        sb.append(Locale.getDefault().getCountry());
        return sb.toString();
    }
}
