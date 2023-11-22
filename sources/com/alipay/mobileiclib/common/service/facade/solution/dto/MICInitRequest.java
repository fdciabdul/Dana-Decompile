package com.alipay.mobileiclib.common.service.facade.solution.dto;

import java.util.Map;

/* loaded from: classes3.dex */
public class MICInitRequest extends MICRpcRequest {
    public String action;
    public String bizId;
    public Map<String, Object> externParams;
    public String module;
    public String sceneId;

    @Override // com.alipay.mobileiclib.common.service.facade.solution.dto.MICRpcRequest
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MICInitRequest{sceneId='");
        sb.append(this.sceneId);
        sb.append('\'');
        sb.append(", bizId='");
        sb.append(this.bizId);
        sb.append('\'');
        sb.append(", module='");
        sb.append(this.module);
        sb.append('\'');
        sb.append(", action='");
        sb.append(this.action);
        sb.append('\'');
        sb.append(", externParams=");
        sb.append(this.externParams);
        sb.append('}');
        return sb.toString();
    }
}
