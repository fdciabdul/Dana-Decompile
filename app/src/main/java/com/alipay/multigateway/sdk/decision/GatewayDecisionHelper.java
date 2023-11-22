package com.alipay.multigateway.sdk.decision;

import android.text.TextUtils;
import com.alipay.multigateway.sdk.ConditionValueGetter;
import com.alipay.multigateway.sdk.GatewayInfo;
import com.alipay.multigateway.sdk.Rule;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.alipay.multigateway.sdk.decision.condition.ConditionProcessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class GatewayDecisionHelper {
    private ConditionValueGetter conditionValueGetter;
    private List<Rule> rules = new ArrayList();
    private ConditionProcessor conditionProcessor = new ConditionProcessor();

    public GatewayDecisionHelper(ConditionValueGetter conditionValueGetter) {
        this.conditionValueGetter = conditionValueGetter;
    }

    public List<Rule> getRules() {
        return this.rules;
    }

    public void replaceRules(List<Rule> list) {
        synchronized (this) {
            sortRules(list);
            this.rules = list;
        }
    }

    public void addRules(List<Rule> list) {
        synchronized (this) {
            if (list.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Rule rule : list) {
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= this.rules.size()) {
                        break;
                    }
                    if (TextUtils.equals(rule.getName(), this.rules.get(i).getName())) {
                        this.rules.set(i, rule);
                        z = true;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    arrayList.add(rule);
                }
            }
            this.rules.addAll(arrayList);
            sortRules(this.rules);
        }
    }

    private static void sortRules(List<Rule> list) {
        Collections.sort(list, new Comparator<Rule>() { // from class: com.alipay.multigateway.sdk.decision.GatewayDecisionHelper.1
            @Override // java.util.Comparator
            public final int compare(Rule rule, Rule rule2) {
                if (rule == null || rule2 == null) {
                    return 0;
                }
                return rule2.getPriority() - rule.getPriority();
            }
        });
    }

    public GatewayInfo decide(Object obj) {
        synchronized (this) {
            for (Rule rule : this.rules) {
                for (Condition condition : rule.getConditions()) {
                    Object value = this.conditionValueGetter.getValue(condition.type, obj);
                    if (value != null && this.conditionProcessor.isMatch(condition, value)) {
                    }
                }
                return rule.getGatewayInfo();
            }
            return null;
        }
    }
}
