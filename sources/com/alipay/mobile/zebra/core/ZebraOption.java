package com.alipay.mobile.zebra.core;

import com.alipay.mobile.zebra.data.BoxData;
import com.alipay.mobile.zebra.data.ImageData;
import com.alipay.mobile.zebra.data.TextData;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.internal.ZebraLog;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class ZebraOption {
    public static final ZebraOption NORMAL = new ZebraOption();

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Class<? extends ZebraData>> f7314a = new HashMap<String, Class<? extends ZebraData>>() { // from class: com.alipay.mobile.zebra.core.ZebraOption.1
        {
            put("box", BoxData.class);
            put("text", TextData.class);
            put("image", ImageData.class);
        }
    };
    public boolean mCompatCamelName;

    public boolean isCompatCamelName() {
        return false;
    }

    public void put(String str, Class<? extends ZebraData> cls) {
        this.f7314a.put(str, cls);
    }

    public Class<? extends ZebraData> get(String str) {
        if (str == null) {
            return null;
        }
        Class<? extends ZebraData> cls = this.f7314a.get(str.toLowerCase());
        return cls != null ? cls : handleUnknownComponent(str);
    }

    public void remove(String str) {
        this.f7314a.remove(str);
    }

    protected Class<? extends ZebraData> handleUnknownComponent(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("handle unknown component: ");
        sb.append(str);
        ZebraLog.w("ZebraOption", sb.toString());
        return BoxData.class;
    }

    public void setCompatCamelName(boolean z) {
        this.mCompatCamelName = z;
    }
}
