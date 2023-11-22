package io.split.android.client;

import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public class AlwaysReturnControlSplitClient implements SplitClient {
    @Override // io.split.android.client.attributes.AttributesManager
    public boolean clearAttributes() {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public void destroy() {
    }

    @Override // io.split.android.client.SplitClient
    public void flush() {
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Object getAttribute(String str) {
        return null;
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String str) {
        return "control";
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String str, Map<String, Object> map) {
        return "control";
    }

    @Override // io.split.android.client.SplitClient
    public boolean isReady() {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public void on(SplitEvent splitEvent, SplitEventTask splitEventTask) {
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean removeAttribute(String str) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttribute(String str, Object obj) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttributes(Map<String, Object> map) {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str, double d) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str, double d, Map<String, Object> map) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str, String str2) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str, String str2, double d) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str, String str2, double d, Map<String, Object> map) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str, String str2, Map<String, Object> map) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String str, Map<String, Object> map) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatments(List<String> list, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), "control");
        }
        return hashMap;
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> list, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), new SplitResult("control"));
        }
        return hashMap;
    }

    @Override // io.split.android.client.SplitClient
    public SplitResult getTreatmentWithConfig(String str, Map<String, Object> map) {
        return new SplitResult("control");
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Map<String, Object> getAllAttributes() {
        return new HashMap();
    }
}
