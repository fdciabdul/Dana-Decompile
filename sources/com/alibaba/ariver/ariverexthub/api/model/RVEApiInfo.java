package com.alibaba.ariver.ariverexthub.api.model;

/* loaded from: classes3.dex */
public class RVEApiInfo {
    public String handlerName;
    public RVEHandlerProcess process;
    public RVEHandlerScope scope;
    public RVEHandlerSource source;

    public static RVEApiInfo makeApi(String str, RVEHandlerScope rVEHandlerScope, RVEHandlerProcess rVEHandlerProcess) {
        return new RVEApiInfo(str, rVEHandlerScope, rVEHandlerProcess);
    }

    public static RVEApiInfo makeApi(String str, RVEHandlerScope rVEHandlerScope, RVEHandlerProcess rVEHandlerProcess, RVEHandlerSource rVEHandlerSource) {
        return new RVEApiInfo(str, rVEHandlerScope, rVEHandlerProcess, rVEHandlerSource);
    }

    private RVEApiInfo(String str, RVEHandlerScope rVEHandlerScope, RVEHandlerProcess rVEHandlerProcess, RVEHandlerSource rVEHandlerSource) {
        this.handlerName = str;
        this.scope = rVEHandlerScope;
        this.process = rVEHandlerProcess;
        this.source = rVEHandlerSource;
    }

    private RVEApiInfo(String str, RVEHandlerScope rVEHandlerScope, RVEHandlerProcess rVEHandlerProcess) {
        this.handlerName = str;
        this.scope = rVEHandlerScope;
        this.process = rVEHandlerProcess;
        this.source = RVEHandlerSource.All;
    }

    public String getHandlerName() {
        return this.handlerName;
    }

    public void setHandlerName(String str) {
        this.handlerName = str;
    }

    public RVEHandlerScope getScope() {
        return this.scope;
    }

    public void setScope(RVEHandlerScope rVEHandlerScope) {
        this.scope = rVEHandlerScope;
    }

    public RVEHandlerProcess getProcess() {
        return this.process;
    }

    public void setProcess(RVEHandlerProcess rVEHandlerProcess) {
        this.process = rVEHandlerProcess;
    }
}
