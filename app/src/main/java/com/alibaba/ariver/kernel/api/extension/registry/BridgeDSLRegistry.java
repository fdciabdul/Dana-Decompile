package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BridgeDSLRegistry {

    /* renamed from: a  reason: collision with root package name */
    private List<BridgeDSL> f6086a;

    public void register(List<BridgeDSL> list) {
        if (this.f6086a == null) {
            this.f6086a = new ArrayList();
        }
        this.f6086a.addAll(list);
    }

    public void unRegister(BridgeDSL bridgeDSL) {
        List<BridgeDSL> list = this.f6086a;
        if (list != null) {
            list.remove(bridgeDSL);
        }
    }

    public List<BridgeDSL> getBridgeDSLs() {
        List<BridgeDSL> list = this.f6086a;
        return list != null ? list : new ArrayList();
    }
}
