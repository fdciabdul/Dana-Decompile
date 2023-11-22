package io.split.android.client.validators;

import com.google.common.base.Preconditions;
import io.split.android.client.Evaluator;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.attributes.AttributesMerger;
import io.split.android.client.events.ListenableEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;

/* loaded from: classes6.dex */
public class TreatmentManagerFactoryImpl implements TreatmentManagerFactory {
    private final AttributesMerger mAttributesMerger;
    private final ImpressionListener mCustomerImpressionListener;
    private final Evaluator mEvaluator;
    private final KeyValidator mKeyValidator;
    private final boolean mLabelsEnabled;
    private final SplitValidator mSplitValidator;
    private final TelemetryStorageProducer mTelemetryStorageProducer;

    public TreatmentManagerFactoryImpl(KeyValidator keyValidator, SplitValidator splitValidator, ImpressionListener impressionListener, boolean z, AttributesMerger attributesMerger, TelemetryStorageProducer telemetryStorageProducer, Evaluator evaluator) {
        this.mKeyValidator = (KeyValidator) Preconditions.checkNotNull(keyValidator);
        this.mSplitValidator = (SplitValidator) Preconditions.checkNotNull(splitValidator);
        this.mCustomerImpressionListener = (ImpressionListener) Preconditions.checkNotNull(impressionListener);
        this.mLabelsEnabled = z;
        this.mAttributesMerger = (AttributesMerger) Preconditions.checkNotNull(attributesMerger);
        this.mTelemetryStorageProducer = (TelemetryStorageProducer) Preconditions.checkNotNull(telemetryStorageProducer);
        this.mEvaluator = (Evaluator) Preconditions.checkNotNull(evaluator);
    }

    @Override // io.split.android.client.validators.TreatmentManagerFactory
    public TreatmentManager getTreatmentManager(Key key, ListenableEventsManager listenableEventsManager, AttributesManager attributesManager) {
        return new TreatmentManagerImpl(key.matchingKey(), key.bucketingKey(), this.mEvaluator, this.mKeyValidator, this.mSplitValidator, this.mCustomerImpressionListener, this.mLabelsEnabled, listenableEventsManager, attributesManager, this.mAttributesMerger, this.mTelemetryStorageProducer);
    }
}
