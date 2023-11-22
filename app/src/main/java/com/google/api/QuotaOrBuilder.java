package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes7.dex */
public interface QuotaOrBuilder extends MessageLiteOrBuilder {
    QuotaLimit getLimits(int i);

    int getLimitsCount();

    List<QuotaLimit> getLimitsList();

    MetricRule getMetricRules(int i);

    int getMetricRulesCount();

    List<MetricRule> getMetricRulesList();
}
