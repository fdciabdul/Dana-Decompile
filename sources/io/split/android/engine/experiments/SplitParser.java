package io.split.android.engine.experiments;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import io.split.android.client.dtos.Condition;
import io.split.android.client.dtos.DependencyMatcherData;
import io.split.android.client.dtos.MatcherGroup;
import io.split.android.client.dtos.MatcherType;
import io.split.android.client.dtos.Partition;
import io.split.android.client.dtos.Split;
import io.split.android.client.dtos.Status;
import io.split.android.client.storage.mysegments.EmptyMySegmentsStorage;
import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.matchers.AllKeysMatcher;
import io.split.android.engine.matchers.AttributeMatcher;
import io.split.android.engine.matchers.BetweenMatcher;
import io.split.android.engine.matchers.BooleanMatcher;
import io.split.android.engine.matchers.CombiningMatcher;
import io.split.android.engine.matchers.DependencyMatcher;
import io.split.android.engine.matchers.EqualToMatcher;
import io.split.android.engine.matchers.GreaterThanOrEqualToMatcher;
import io.split.android.engine.matchers.LessThanOrEqualToMatcher;
import io.split.android.engine.matchers.Matcher;
import io.split.android.engine.matchers.MySegmentsMatcher;
import io.split.android.engine.matchers.collections.ContainsAllOfSetMatcher;
import io.split.android.engine.matchers.collections.ContainsAnyOfSetMatcher;
import io.split.android.engine.matchers.collections.EqualToSetMatcher;
import io.split.android.engine.matchers.collections.PartOfSetMatcher;
import io.split.android.engine.matchers.strings.ContainsAnyOfMatcher;
import io.split.android.engine.matchers.strings.EndsWithAnyOfMatcher;
import io.split.android.engine.matchers.strings.RegularExpressionMatcher;
import io.split.android.engine.matchers.strings.StartsWithAnyOfMatcher;
import io.split.android.engine.matchers.strings.WhitelistMatcher;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class SplitParser {
    private final MySegmentsStorageContainer PlaceComponentResult;

    public SplitParser(MySegmentsStorageContainer mySegmentsStorageContainer) {
        this.PlaceComponentResult = (MySegmentsStorageContainer) Preconditions.checkNotNull(mySegmentsStorageContainer);
    }

    /* renamed from: io.split.android.engine.experiments.SplitParser$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[MatcherType.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[MatcherType.ALL_KEYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.IN_SEGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.WHITELIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.EQUAL_TO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.LESS_THAN_OR_EQUAL_TO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.BETWEEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.EQUAL_TO_SET.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.PART_OF_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.CONTAINS_ALL_OF_SET.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.CONTAINS_ANY_OF_SET.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.STARTS_WITH.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.ENDS_WITH.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.CONTAINS_STRING.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.MATCHES_STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.IN_SPLIT_TREATMENT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                MyBillsEntityDataFactory[MatcherType.EQUAL_TO_BOOLEAN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public final ParsedSplit KClassImpl$Data$declaredNonStaticMembers$2(Split split, String str) {
        int i;
        Matcher allKeysMatcher;
        String str2;
        if (split != null) {
            boolean z = true;
            try {
                if (split.status == Status.ACTIVE) {
                    try {
                        if (split.conditions.size() > 50) {
                            Logger.w("Dropping feature flag name=%s due to large number of conditions(%d)", split.name, Integer.valueOf(split.conditions.size()));
                        } else {
                            ArrayList newArrayList = Lists.newArrayList();
                            for (Condition condition : split.conditions) {
                                List<Partition> list = condition.partitions;
                                MatcherGroup matcherGroup = condition.matcherGroup;
                                List<io.split.android.client.dtos.Matcher> list2 = matcherGroup.matchers;
                                Preconditions.checkArgument(list2.isEmpty() ^ z);
                                ArrayList newArrayList2 = Lists.newArrayList();
                                for (io.split.android.client.dtos.Matcher matcher : list2) {
                                    switch (AnonymousClass1.MyBillsEntityDataFactory[matcher.matcherType.ordinal()]) {
                                        case 1:
                                            allKeysMatcher = new AllKeysMatcher();
                                            break;
                                        case 2:
                                            Preconditions.checkNotNull(matcher.userDefinedSegmentMatcherData);
                                            allKeysMatcher = new MySegmentsMatcher(str != null ? this.PlaceComponentResult.getStorageForKey(str) : new EmptyMySegmentsStorage(), matcher.userDefinedSegmentMatcherData.segmentName);
                                            break;
                                        case 3:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new WhitelistMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 4:
                                            Preconditions.checkNotNull(matcher.unaryNumericMatcherData);
                                            allKeysMatcher = new EqualToMatcher(matcher.unaryNumericMatcherData.value, matcher.unaryNumericMatcherData.dataType);
                                            break;
                                        case 5:
                                            Preconditions.checkNotNull(matcher.unaryNumericMatcherData);
                                            allKeysMatcher = new GreaterThanOrEqualToMatcher(matcher.unaryNumericMatcherData.value, matcher.unaryNumericMatcherData.dataType);
                                            break;
                                        case 6:
                                            Preconditions.checkNotNull(matcher.unaryNumericMatcherData);
                                            allKeysMatcher = new LessThanOrEqualToMatcher(matcher.unaryNumericMatcherData.value, matcher.unaryNumericMatcherData.dataType);
                                            break;
                                        case 7:
                                            Preconditions.checkNotNull(matcher.betweenMatcherData);
                                            allKeysMatcher = new BetweenMatcher(matcher.betweenMatcherData.start, matcher.betweenMatcherData.end, matcher.betweenMatcherData.dataType);
                                            break;
                                        case 8:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new EqualToSetMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 9:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new PartOfSetMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 10:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new ContainsAllOfSetMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 11:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new ContainsAnyOfSetMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 12:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new StartsWithAnyOfMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 13:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new EndsWithAnyOfMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 14:
                                            Preconditions.checkNotNull(matcher.whitelistMatcherData);
                                            allKeysMatcher = new ContainsAnyOfMatcher(matcher.whitelistMatcherData.whitelist);
                                            break;
                                        case 15:
                                            Preconditions.checkNotNull(matcher.stringMatcherData);
                                            allKeysMatcher = new RegularExpressionMatcher(matcher.stringMatcherData);
                                            break;
                                        case 16:
                                            DependencyMatcherData dependencyMatcherData = matcher.dependencyMatcherData;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("MatcherType is ");
                                            sb.append(matcher.matcherType);
                                            sb.append(". matcher.dependencyMatcherData() MUST NOT BE null");
                                            Preconditions.checkNotNull(dependencyMatcherData, sb.toString());
                                            allKeysMatcher = new DependencyMatcher(matcher.dependencyMatcherData.split, matcher.dependencyMatcherData.treatments);
                                            break;
                                        case 17:
                                            Boolean bool = matcher.booleanMatcherData;
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("MatcherType is ");
                                            sb2.append(matcher.matcherType);
                                            sb2.append(". matcher.booleanMatcherData() MUST NOT BE null");
                                            Preconditions.checkNotNull(bool, sb2.toString());
                                            allKeysMatcher = new BooleanMatcher(matcher.booleanMatcherData.booleanValue());
                                            break;
                                        default:
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("Unknown matcher type: ");
                                            sb3.append(matcher.matcherType);
                                            throw new IllegalArgumentException(sb3.toString());
                                    }
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("We were not able to create a matcher for: ");
                                    sb4.append(matcher.matcherType);
                                    Preconditions.checkNotNull(allKeysMatcher, sb4.toString());
                                    if (matcher.keySelector != null) {
                                        try {
                                            if (matcher.keySelector.attribute != null) {
                                                str2 = matcher.keySelector.attribute;
                                                newArrayList2.add(new AttributeMatcher(str2, allKeysMatcher, matcher.negate));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            i = 1;
                                            Object[] objArr = new Object[i];
                                            objArr[0] = split;
                                            Logger.e(th, "Could not parse feature flag: %s", objArr);
                                            return null;
                                        }
                                    }
                                    str2 = null;
                                    newArrayList2.add(new AttributeMatcher(str2, allKeysMatcher, matcher.negate));
                                }
                                newArrayList.add(new ParsedCondition(condition.conditionType, new CombiningMatcher(matcherGroup.combiner, newArrayList2), list, condition.label));
                                z = true;
                            }
                            return new ParsedSplit(split.name, split.seed, split.killed, split.defaultTreatment, newArrayList, split.trafficTypeName, split.changeNumber, split.trafficAllocation.intValue(), split.trafficAllocationSeed.intValue(), split.algo, split.configurations);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = 1;
                        Object[] objArr2 = new Object[i];
                        objArr2[0] = split;
                        Logger.e(th, "Could not parse feature flag: %s", objArr2);
                        return null;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }
}
