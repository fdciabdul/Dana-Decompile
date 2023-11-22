package com.alibaba.ariver.resource.api;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes6.dex */
public interface RVAttributeConfigProxy extends Proxiable {
    public static final String FORCE_CONFIG_SERVICE = "forceConfigService";
    public static final String FORCE_TA_CONFIG = "forceTaConfig";

    String get(String str, AppModel appModel);

    String get(String str, AppModel appModel, String str2);
}
