package com.alibaba.ariver.app.api.ui.darkmode;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;

/* loaded from: classes2.dex */
public interface ColorSchemeDecider {
    public static final String TAG = "AriverApp:ColorSchemeDecider";

    ColorSchemeType getCurrentColorScheme();

    /* loaded from: classes6.dex */
    public static class DefaultDecider implements ColorSchemeDecider {

        /* renamed from: a  reason: collision with root package name */
        private JSONArray f5972a;

        public DefaultDecider(JSONArray jSONArray) {
            this.f5972a = jSONArray;
            StringBuilder sb = new StringBuilder();
            sb.append("initialize ColorDecider by supportColorScheme: ");
            sb.append(jSONArray);
            RVLogger.d(ColorSchemeDecider.TAG, sb.toString());
        }

        @Override // com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider
        public ColorSchemeType getCurrentColorScheme() {
            JSONArray jSONArray = this.f5972a;
            if (jSONArray == null || jSONArray.size() == 0) {
                return ColorSchemeType.DEFAULT;
            }
            if (ThemeUtils.isDarkMode(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()) && this.f5972a.contains("dark")) {
                return ColorSchemeType.DARK;
            }
            if (this.f5972a.contains("light")) {
                return ColorSchemeType.LIGHT;
            }
            return ColorSchemeType.DEFAULT;
        }
    }
}
