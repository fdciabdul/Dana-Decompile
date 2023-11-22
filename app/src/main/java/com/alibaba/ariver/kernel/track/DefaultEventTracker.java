package com.alibaba.ariver.kernel.track;

import android.os.SystemClock;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Map;

/* loaded from: classes6.dex */
public class DefaultEventTracker implements EventTracker {
    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void logPageAbnormal(Node node) {
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event stub(Node node, String str) {
        return stub(node, str, SystemClock.elapsedRealtime());
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event stub(Node node, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker stub ");
        sb.append(str);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
        Event.Stub stub = new Event.Stub(j);
        stub.setTrackId(str);
        return stub;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event cost(Node node, String str, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker cost ");
        sb.append(str);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
        Event.Cost cost = new Event.Cost(j);
        cost.setTrackId(str);
        return cost;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event error(Node node, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker error ");
        sb.append(str);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
        Event.Error error = new Event.Error(str2);
        error.setTrackId(str);
        return error;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(Node node, String str, String str2, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker whiteScreen ");
        sb.append(str);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(Node node, String str, String str2, String str3, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker whiteScreen ");
        sb.append(str);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(String str, String str2, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker whiteScreen ");
        sb.append(str);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event interceptLoad(Node node, String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker interceptLoad ");
        sb.append(str);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void event(Node node, Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker event ");
        sb.append(event);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void addAttr(Node node, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker addAttr ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void logPageException(Node node, String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker abnormalScreen ");
        sb.append(node);
        sb.append("errorType: ");
        sb.append(str);
        sb.append("extraInfo: ");
        sb.append(map);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void initRecordTimeStamp(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker initRecordTimeStamp map: ");
        sb.append(map);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void clearRecordTimeStamp(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker clearRecordTimeStamp map: ");
        sb.append(map);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void recordTimeStampByKey(String str, String str2, Map<String, Object> map, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("EventTracker recordTimeStampByKey map: ");
        sb.append(map);
        RVLogger.d("AriverKernel:EventTracker", sb.toString());
    }
}
