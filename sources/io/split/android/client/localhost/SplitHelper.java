package io.split.android.client.localhost;

import io.reactivex.annotations.SchedulerSupport;
import io.split.android.client.dtos.Condition;
import io.split.android.client.dtos.ConditionType;
import io.split.android.client.dtos.Matcher;
import io.split.android.client.dtos.MatcherCombiner;
import io.split.android.client.dtos.MatcherGroup;
import io.split.android.client.dtos.MatcherType;
import io.split.android.client.dtos.Partition;
import io.split.android.client.dtos.Split;
import io.split.android.client.dtos.Status;
import io.split.android.client.dtos.WhitelistMatcherData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
class SplitHelper {
    SplitHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Split createDefaultSplit(String str) {
        Split split = new Split();
        split.name = str;
        split.defaultTreatment = "control";
        split.status = Status.ACTIVE;
        split.algo = 2;
        split.trafficTypeName = SchedulerSupport.CUSTOM;
        split.trafficAllocation = 100;
        split.trafficAllocationSeed = 1;
        split.seed = 1;
        split.conditions = new ArrayList();
        return split;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Condition createWhiteListCondition(List<String> list, String str) {
        Condition condition = new Condition();
        MatcherGroup matcherGroup = new MatcherGroup();
        Matcher matcher = new Matcher();
        WhitelistMatcherData whitelistMatcherData = new WhitelistMatcherData();
        Partition partition = new Partition();
        condition.conditionType = ConditionType.WHITELIST;
        matcherGroup.combiner = MatcherCombiner.AND;
        matcher.matcherType = MatcherType.WHITELIST;
        whitelistMatcherData.whitelist = list;
        matcher.whitelistMatcherData = whitelistMatcherData;
        partition.size = 100;
        partition.treatment = str;
        matcherGroup.matchers = Arrays.asList(matcher);
        condition.matcherGroup = matcherGroup;
        condition.partitions = Arrays.asList(partition);
        StringBuilder sb = new StringBuilder();
        sb.append("LOCAL_");
        sb.append(list.toString());
        condition.label = sb.toString();
        return condition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Condition createRolloutCondition(String str) {
        Condition condition = new Condition();
        MatcherGroup matcherGroup = new MatcherGroup();
        Matcher matcher = new Matcher();
        Partition partition = new Partition();
        condition.conditionType = ConditionType.ROLLOUT;
        matcherGroup.combiner = MatcherCombiner.AND;
        matcher.matcherType = MatcherType.ALL_KEYS;
        partition.size = 100;
        partition.treatment = str;
        matcherGroup.matchers = Arrays.asList(matcher);
        condition.matcherGroup = matcherGroup;
        condition.partitions = Arrays.asList(partition);
        condition.label = "in segment all";
        return condition;
    }
}
