package io.split.android.client;

import io.split.android.client.dtos.ConditionType;
import io.split.android.client.exceptions.ChangeNumberExceptionWrapper;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.logger.Logger;
import io.split.android.engine.experiments.ParsedCondition;
import io.split.android.engine.experiments.ParsedSplit;
import io.split.android.engine.experiments.SplitParser;
import io.split.android.engine.splitter.Splitter;
import java.util.Map;

/* loaded from: classes6.dex */
public class EvaluatorImpl implements Evaluator {
    private final SplitParser mSplitParser;
    private final SplitsStorage mSplitsStorage;

    public EvaluatorImpl(SplitsStorage splitsStorage, SplitParser splitParser) {
        this.mSplitsStorage = splitsStorage;
        this.mSplitParser = splitParser;
    }

    @Override // io.split.android.client.Evaluator
    public EvaluationResult getTreatment(String str, String str2, String str3, Map<String, Object> map) {
        try {
            ParsedSplit KClassImpl$Data$declaredNonStaticMembers$2 = this.mSplitParser.KClassImpl$Data$declaredNonStaticMembers$2(this.mSplitsStorage.get(str3), str);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return new EvaluationResult("control", TreatmentLabels.DEFINITION_NOT_FOUND);
            }
            return getTreatment(str, str2, KClassImpl$Data$declaredNonStaticMembers$2, map);
        } catch (ChangeNumberExceptionWrapper e) {
            Logger.e(e, "Catch Change Number Exception", new Object[0]);
            return new EvaluationResult("control", "exception");
        } catch (Exception e2) {
            Logger.e(e2, "Catch All Exception", new Object[0]);
            return new EvaluationResult("control", "exception");
        }
    }

    private EvaluationResult getTreatment(String str, String str2, ParsedSplit parsedSplit, Map<String, Object> map) throws ChangeNumberExceptionWrapper {
        try {
            if (parsedSplit.PlaceComponentResult()) {
                return new EvaluationResult(parsedSplit.getAuthRequestContext, TreatmentLabels.KILLED, Long.valueOf(parsedSplit.BuiltInFictitiousFunctionClassFactory), configForTreatment(parsedSplit, parsedSplit.getAuthRequestContext));
            }
            boolean z = false;
            String str3 = str2 == null ? str : str2;
            for (ParsedCondition parsedCondition : parsedSplit.PlaceComponentResult) {
                if (!z && parsedCondition.BuiltInFictitiousFunctionClassFactory == ConditionType.ROLLOUT) {
                    if (parsedSplit.moveToNextValue < 100 && Splitter.MyBillsEntityDataFactory(str3, parsedSplit.scheduleImpl, parsedSplit.MyBillsEntityDataFactory) > parsedSplit.moveToNextValue) {
                        return new EvaluationResult(parsedSplit.getAuthRequestContext, TreatmentLabels.NOT_IN_SPLIT, Long.valueOf(parsedSplit.BuiltInFictitiousFunctionClassFactory), configForTreatment(parsedSplit, parsedSplit.getAuthRequestContext));
                    }
                    z = true;
                }
                if (parsedCondition.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(str, str2, map, this)) {
                    String PlaceComponentResult = Splitter.PlaceComponentResult(str3, parsedSplit.NetworkUserEntityData$$ExternalSyntheticLambda0, parsedCondition.getAuthRequestContext, parsedSplit.MyBillsEntityDataFactory);
                    return new EvaluationResult(PlaceComponentResult, parsedCondition.MyBillsEntityDataFactory, Long.valueOf(parsedSplit.BuiltInFictitiousFunctionClassFactory), configForTreatment(parsedSplit, PlaceComponentResult));
                }
            }
            return new EvaluationResult(parsedSplit.getAuthRequestContext, TreatmentLabels.DEFAULT_RULE, Long.valueOf(parsedSplit.BuiltInFictitiousFunctionClassFactory), configForTreatment(parsedSplit, parsedSplit.getAuthRequestContext));
        } catch (Exception e) {
            throw new ChangeNumberExceptionWrapper(e, parsedSplit.BuiltInFictitiousFunctionClassFactory);
        }
    }

    private String configForTreatment(ParsedSplit parsedSplit, String str) {
        if (parsedSplit.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return parsedSplit.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
        }
        return null;
    }
}
