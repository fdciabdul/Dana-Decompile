package io.split.android.client.validators;

import com.google.common.base.Preconditions;
import io.split.android.client.EvaluationResult;
import io.split.android.client.Evaluator;
import io.split.android.client.SplitResult;
import io.split.android.client.TreatmentLabels;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.attributes.AttributesMerger;
import io.split.android.client.events.ListenableEventsManager;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.impressions.Impression;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.telemetry.model.Method;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.logger.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class TreatmentManagerImpl implements TreatmentManager {
    private final AttributesManager mAttributesManager;
    private final AttributesMerger mAttributesMerger;
    private final String mBucketingKey;
    private final Evaluator mEvaluator;
    private final ListenableEventsManager mEventsManager;
    private final ImpressionListener mImpressionListener;
    private final KeyValidator mKeyValidator;
    private final boolean mLabelsEnabled;
    private final String mMatchingKey;
    private final SplitValidator mSplitValidator;
    private final TelemetryStorageProducer mTelemetryStorageProducer;
    private final String CLIENT_DESTROYED_MESSAGE = "Client has already been destroyed - no calls possible";
    private final ValidationMessageLogger mValidationLogger = new ValidationMessageLoggerImpl();

    /* loaded from: classes9.dex */
    static class ValidationTag {
        public static final String GET_TREATMENT = "getTreatment";
        public static final String GET_TREATMENTS = "getTreatments";
        public static final String GET_TREATMENTS_WITH_CONFIG = "getTreatmentsWithConfig";
        public static final String GET_TREATMENT_WITH_CONFIG = "getTreatmentWithConfig";

        private ValidationTag() {
        }
    }

    public TreatmentManagerImpl(String str, String str2, Evaluator evaluator, KeyValidator keyValidator, SplitValidator splitValidator, ImpressionListener impressionListener, boolean z, ListenableEventsManager listenableEventsManager, AttributesManager attributesManager, AttributesMerger attributesMerger, TelemetryStorageProducer telemetryStorageProducer) {
        this.mEvaluator = evaluator;
        this.mKeyValidator = keyValidator;
        this.mSplitValidator = splitValidator;
        this.mMatchingKey = str;
        this.mBucketingKey = str2;
        this.mImpressionListener = impressionListener;
        this.mLabelsEnabled = z;
        this.mEventsManager = listenableEventsManager;
        this.mAttributesManager = (AttributesManager) Preconditions.checkNotNull(attributesManager);
        this.mAttributesMerger = (AttributesMerger) Preconditions.checkNotNull(attributesMerger);
        this.mTelemetryStorageProducer = (TelemetryStorageProducer) Preconditions.checkNotNull(telemetryStorageProducer);
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public String getTreatment(String str, Map<String, Object> map, boolean z) {
        if (z) {
            Logger.e("getTreatmentClient has already been destroyed - no calls possible");
            return "control";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String treatment = getTreatmentWithConfigWithoutMetrics(str, map, ValidationTag.GET_TREATMENT).treatment();
        recordLatency(Method.TREATMENT, currentTimeMillis);
        return treatment;
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public SplitResult getTreatmentWithConfig(String str, Map<String, Object> map, boolean z) {
        if (z) {
            Logger.e("getTreatmentWithConfigClient has already been destroyed - no calls possible");
            return new SplitResult("control");
        }
        long currentTimeMillis = System.currentTimeMillis();
        SplitResult treatmentWithConfigWithoutMetrics = getTreatmentWithConfigWithoutMetrics(str, map, ValidationTag.GET_TREATMENT_WITH_CONFIG);
        recordLatency(Method.TREATMENT_WITH_CONFIG, currentTimeMillis);
        return treatmentWithConfigWithoutMetrics;
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, String> getTreatments(List<String> list, Map<String, Object> map, boolean z) {
        if (list == null) {
            this.mValidationLogger.e("split_names must be a non-empty array", ValidationTag.GET_TREATMENTS);
            return new HashMap();
        } else if (z) {
            this.mValidationLogger.e("Client has already been destroyed - no calls possible", ValidationTag.GET_TREATMENTS);
            return controlTreatmentsForSplits(list, ValidationTag.GET_TREATMENTS);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, SplitResult> treatmentsWithConfigWithoutMetrics = getTreatmentsWithConfigWithoutMetrics(list, map, ValidationTag.GET_TREATMENTS);
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, SplitResult> entry : treatmentsWithConfigWithoutMetrics.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().treatment());
            }
            recordLatency(Method.TREATMENTS, currentTimeMillis);
            return hashMap;
        }
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> list, Map<String, Object> map, boolean z) {
        if (list == null) {
            this.mValidationLogger.e("split_names must be a non-empty array", ValidationTag.GET_TREATMENTS_WITH_CONFIG);
            return new HashMap();
        } else if (z) {
            Logger.e("getTreatmentsWithConfigClient has already been destroyed - no calls possible");
            return controlTreatmentsForSplitsWithConfig(list, ValidationTag.GET_TREATMENTS_WITH_CONFIG);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, SplitResult> treatmentsWithConfigWithoutMetrics = getTreatmentsWithConfigWithoutMetrics(list, map, ValidationTag.GET_TREATMENTS_WITH_CONFIG);
            recordLatency(Method.TREATMENTS_WITH_CONFIG, currentTimeMillis);
            return treatmentsWithConfigWithoutMetrics;
        }
    }

    private SplitResult getTreatmentWithConfigWithoutMetrics(String str, Map<String, Object> map, String str2) {
        ValidationErrorInfo validate = this.mKeyValidator.validate(this.mMatchingKey, this.mBucketingKey);
        if (validate != null) {
            this.mValidationLogger.e(validate, str2);
            return new SplitResult("control");
        }
        ValidationErrorInfo validateName = this.mSplitValidator.validateName(str);
        if (validateName != null) {
            if (validateName.isError()) {
                this.mValidationLogger.e(validateName, str2);
                return new SplitResult("control");
            }
            this.mValidationLogger.w(validateName, str2);
            str = str.trim();
        }
        String str3 = str;
        Map<String, Object> merge = this.mAttributesMerger.merge(this.mAttributesManager.getAllAttributes(), map);
        EvaluationResult evaluateIfReady = evaluateIfReady(str3, merge, str2);
        SplitResult splitResult = new SplitResult(evaluateIfReady.getTreatment(), evaluateIfReady.getConfigurations());
        if (evaluateIfReady.getLabel().equals(TreatmentLabels.DEFINITION_NOT_FOUND)) {
            this.mValidationLogger.w(this.mSplitValidator.splitNotFoundMessage(str3), str2);
            return splitResult;
        }
        logImpression(this.mMatchingKey, this.mBucketingKey, str3, evaluateIfReady.getTreatment(), this.mLabelsEnabled ? evaluateIfReady.getLabel() : null, evaluateIfReady.getChangeNumber(), merge);
        return splitResult;
    }

    private Map<String, SplitResult> getTreatmentsWithConfigWithoutMetrics(List<String> list, Map<String, Object> map, String str) {
        ValidationErrorInfo validate = this.mKeyValidator.validate(this.mMatchingKey, this.mBucketingKey);
        if (validate != null) {
            this.mValidationLogger.log(validate, str);
            return controlTreatmentsForSplitsWithConfig(list, str);
        }
        HashMap hashMap = new HashMap();
        if (list.size() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(": split_names is an empty array or has null values");
            Logger.w(sb.toString());
            return hashMap;
        }
        Map<String, Object> merge = this.mAttributesMerger.merge(this.mAttributesManager.getAllAttributes(), map);
        for (String str2 : list) {
            ValidationErrorInfo validateName = this.mSplitValidator.validateName(str2);
            if (validateName != null) {
                if (validateName.isError()) {
                    this.mValidationLogger.e(validateName, str);
                } else {
                    this.mValidationLogger.w(validateName, str);
                }
            }
            EvaluationResult evaluateIfReady = evaluateIfReady(str2.trim(), merge, str);
            hashMap.put(str2.trim(), new SplitResult(evaluateIfReady.getTreatment(), evaluateIfReady.getConfigurations()));
            if (evaluateIfReady.getLabel().equals(TreatmentLabels.DEFINITION_NOT_FOUND)) {
                this.mValidationLogger.w(this.mSplitValidator.splitNotFoundMessage(str2), str);
            } else {
                logImpression(this.mMatchingKey, this.mBucketingKey, str2, evaluateIfReady.getTreatment(), this.mLabelsEnabled ? evaluateIfReady.getLabel() : null, evaluateIfReady.getChangeNumber(), merge);
            }
        }
        return hashMap;
    }

    private void logImpression(String str, String str2, String str3, String str4, String str5, Long l, Map<String, Object> map) {
        try {
            this.mImpressionListener.log(new Impression(str, str2, str3, str4, System.currentTimeMillis(), str5, l, map));
        } catch (Throwable th) {
            Logger.e(th);
        }
    }

    private Map<String, SplitResult> controlTreatmentsForSplitsWithConfig(List<String> list, String str) {
        return TreatmentManagerHelper.controlTreatmentsForSplitsWithConfig(list, this.mSplitValidator, str, this.mValidationLogger);
    }

    private Map<String, String> controlTreatmentsForSplits(List<String> list, String str) {
        return TreatmentManagerHelper.controlTreatmentsForSplits(list, this.mSplitValidator, str, this.mValidationLogger);
    }

    private EvaluationResult evaluateIfReady(String str, Map<String, Object> map, String str2) {
        if (!this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY) && !this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY_FROM_CACHE)) {
            this.mValidationLogger.w("the SDK is not ready, results may be incorrect. Make sure to wait for SDK readiness before using this method", str2);
            this.mTelemetryStorageProducer.recordNonReadyUsage();
            return new EvaluationResult("control", TreatmentLabels.NOT_READY, null, null);
        }
        return this.mEvaluator.getTreatment(this.mMatchingKey, this.mBucketingKey, str, map);
    }

    private void recordLatency(Method method, long j) {
        this.mTelemetryStorageProducer.recordLatency(method, System.currentTimeMillis() - j);
    }
}
