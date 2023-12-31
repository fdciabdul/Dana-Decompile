package com.alipayplus.mobile.component.common.facade.base.result;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes3.dex */
public class BaseServiceResult implements Serializable {
    public String errorCode;
    public String errorMessage;
    public Map<String, String> extendInfo;
    public boolean success;
}
