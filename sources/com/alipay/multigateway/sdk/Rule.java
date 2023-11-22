package com.alipay.multigateway.sdk;

import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Rule {
    private List<Condition> conditions = new ArrayList();
    private GatewayInfo gatewayInfo;
    private final String name;
    private final int priority;

    public Rule(String str, int i) {
        this.name = str;
        this.priority = i;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setConditions(List<Condition> list) {
        this.conditions = list;
    }

    public void setGatewayInfo(GatewayInfo gatewayInfo) {
        this.gatewayInfo = gatewayInfo;
    }

    public GatewayInfo getGatewayInfo() {
        return this.gatewayInfo;
    }

    public List<Condition> getConditions() {
        return this.conditions;
    }

    public void addCondition(Condition condition) {
        this.conditions.add(condition);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rule<");
        sb.append(this.name);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }
}
