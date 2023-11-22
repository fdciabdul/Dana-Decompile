package com.alibaba.ariver.engine.common.track.recovery;

import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

/* loaded from: classes6.dex */
public interface DeepRecoverARiverProxy extends Proxiable {
    public static final int TYPE_ENTITY_APP = 257;
    public static final int TYPE_ENTITY_ONLINE_PAGE = 261;
    public static final int TYPE_ENTITY_PLUGIN = 259;
    public static final int TYPE_ENTITY_TA_PAGE = 260;
    public static final int TYPE_ENTITY_TEMPLATE = 258;
    public static final int TYPE_EXCEPTION_CANNOT_CRASH_APP = 517;
    public static final int TYPE_EXCEPTION_CANNOT_CRASH_PAGE = 516;
    public static final int TYPE_EXCEPTION_CANNOT_OPEN_APP = 514;
    public static final int TYPE_EXCEPTION_CANNOT_OPEN_PAGE = 515;
    public static final int TYPE_EXCEPTION_WHITE_SCREEN = 513;

    void abnormalPage(Map<String, Object> map);

    Object getValByKey(String str);

    void normalPage(Map<String, Object> map);

    Object setValByKey(String str, Object obj);

    void whiteScreenPage(Map<String, Object> map);
}
