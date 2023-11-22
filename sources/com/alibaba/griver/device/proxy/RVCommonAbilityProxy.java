package com.alibaba.griver.device.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.griver.device.jsapi.contact.AddPhoneContactView;

/* loaded from: classes2.dex */
public interface RVCommonAbilityProxy extends Proxiable {
    public static final String HIGH = "high";
    public static final String LOW = "low";
    public static final String MIDDLE = "middle";
    public static final String UNKNOWN = "unknown";

    /* loaded from: classes3.dex */
    public @interface Performance {
    }

    AddPhoneContactView getAddPhoneContactDialog();

    String getAppAlias();

    String getDevicePerformance();

    float getFontSizeSetting();

    String getLocalLanguage();

    boolean hasRootStatusPermission(String str);
}
