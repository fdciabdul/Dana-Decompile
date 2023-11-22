package com.alibaba.ariver.kernel.api.track;

import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.Map;

@DefaultImpl("com.alibaba.ariver.kernel.track.DefaultEventTracker")
/* loaded from: classes2.dex */
public interface EventTracker extends Proxiable {
    void addAttr(Node node, String str, String str2);

    void clearRecordTimeStamp(Map<String, Object> map);

    Event cost(Node node, String str, long j);

    Event error(Node node, String str, String str2);

    void event(Node node, Event event);

    void initRecordTimeStamp(Map<String, Object> map);

    Event interceptLoad(Node node, String str, Map<String, Object> map);

    void logPageAbnormal(Node node);

    void logPageException(Node node, String str, Map<String, Object> map);

    void recordTimeStampByKey(String str, String str2, Map<String, Object> map, boolean z);

    Event stub(Node node, String str);

    Event stub(Node node, String str, long j);

    Event whiteScreen(Node node, String str, String str2, String str3, Map<String, Object> map);

    Event whiteScreen(Node node, String str, String str2, Map<String, Object> map);

    Event whiteScreen(String str, String str2, Map<String, Object> map);
}
