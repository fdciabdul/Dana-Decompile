package io.split.android.client.localhost;

import com.google.common.base.Preconditions;
import io.split.android.client.Evaluator;
import io.split.android.client.EvaluatorImpl;
import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitResult;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.attributes.AttributesMerger;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.KeyValidatorImpl;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.TreatmentManager;
import io.split.android.client.validators.TreatmentManagerImpl;
import io.split.android.engine.experiments.SplitParser;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class LocalhostSplitClient implements SplitClient {
    private final WeakReference<SplitClientContainer> mClientContainer;
    private final Evaluator mEvaluator;
    private final SplitEventsManager mEventsManager;
    private final WeakReference<LocalhostSplitFactory> mFactoryRef;
    private boolean mIsClientDestroyed = false;
    private final Key mKey;
    private final TreatmentManager mTreatmentManager;

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean clearAttributes() {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public final void flush() {
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final Object getAttribute(String str) {
        return null;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean removeAttribute(String str) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean setAttribute(String str, Object obj) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean setAttributes(Map<String, Object> map) {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, double d) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, double d, Map<String, Object> map) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2, double d) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2, double d, Map<String, Object> map) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2, Map<String, Object> map) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, Map<String, Object> map) {
        return false;
    }

    public LocalhostSplitClient(LocalhostSplitFactory localhostSplitFactory, SplitClientContainer splitClientContainer, SplitClientConfig splitClientConfig, Key key, SplitsStorage splitsStorage, SplitEventsManager splitEventsManager, SplitParser splitParser, AttributesManager attributesManager, AttributesMerger attributesMerger, TelemetryStorageProducer telemetryStorageProducer) {
        this.mFactoryRef = new WeakReference<>((LocalhostSplitFactory) Preconditions.checkNotNull(localhostSplitFactory));
        this.mClientContainer = new WeakReference<>((SplitClientContainer) Preconditions.checkNotNull(splitClientContainer));
        Key key2 = (Key) Preconditions.checkNotNull(key);
        this.mKey = key2;
        this.mEventsManager = (SplitEventsManager) Preconditions.checkNotNull(splitEventsManager);
        EvaluatorImpl evaluatorImpl = new EvaluatorImpl(splitsStorage, splitParser);
        this.mEvaluator = evaluatorImpl;
        this.mTreatmentManager = new TreatmentManagerImpl(key2.matchingKey(), key2.bucketingKey(), evaluatorImpl, new KeyValidatorImpl(), new SplitValidatorImpl(), getImpressionsListener(splitClientConfig), splitClientConfig.labelsEnabled(), splitEventsManager, attributesManager, attributesMerger, telemetryStorageProducer);
    }

    @Override // io.split.android.client.SplitClient
    public final String getTreatment(String str) {
        try {
            return this.mTreatmentManager.getTreatment(str, null, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return "control";
        }
    }

    @Override // io.split.android.client.SplitClient
    public final String getTreatment(String str, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatment(str, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return "control";
        }
    }

    @Override // io.split.android.client.SplitClient
    public final SplitResult getTreatmentWithConfig(String str, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatmentWithConfig(str, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return new SplitResult("control");
        }
    }

    @Override // io.split.android.client.SplitClient
    public final Map<String, String> getTreatments(List<String> list, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatments(list, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            HashMap hashMap = new HashMap();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                hashMap.put(it.next(), "control");
            }
            return hashMap;
        }
    }

    @Override // io.split.android.client.SplitClient
    public final Map<String, SplitResult> getTreatmentsWithConfig(List<String> list, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatmentsWithConfig(list, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            HashMap hashMap = new HashMap();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                hashMap.put(it.next(), new SplitResult("control"));
            }
            return hashMap;
        }
    }

    @Override // io.split.android.client.SplitClient
    public final void destroy() {
        this.mIsClientDestroyed = true;
        SplitClientContainer splitClientContainer = this.mClientContainer.get();
        if (splitClientContainer != null) {
            splitClientContainer.remove(this.mKey);
        }
        LocalhostSplitFactory localhostSplitFactory = this.mFactoryRef.get();
        if (localhostSplitFactory != null) {
            localhostSplitFactory.destroy();
        }
    }

    @Override // io.split.android.client.SplitClient
    public final boolean isReady() {
        return this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY);
    }

    @Override // io.split.android.client.SplitClient
    public final void on(SplitEvent splitEvent, SplitEventTask splitEventTask) {
        Preconditions.checkNotNull(splitEvent);
        Preconditions.checkNotNull(splitEventTask);
        if (splitEvent.equals(SplitEvent.SDK_READY_FROM_CACHE) || !this.mEventsManager.eventAlreadyTriggered(splitEvent)) {
            this.mEventsManager.register(splitEvent, splitEventTask);
        } else {
            Logger.w(String.format("A listener was added for %s on the SDK, which has already fired and won’t be emitted again. The callback won’t be executed.", splitEvent.toString()));
        }
    }

    private ImpressionListener getImpressionsListener(SplitClientConfig splitClientConfig) {
        if (splitClientConfig.impressionListener() != null) {
            return splitClientConfig.impressionListener();
        }
        return new LocalhostImpressionsListener();
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final Map<String, Object> getAllAttributes() {
        return new HashMap();
    }
}
