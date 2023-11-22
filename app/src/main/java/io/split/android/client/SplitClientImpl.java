package io.split.android.client;

import com.google.common.base.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.telemetry.model.Method;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.SplitValidator;
import io.split.android.client.validators.TreatmentManager;
import io.split.android.client.validators.TreatmentManagerHelper;
import io.split.android.client.validators.ValidationMessageLogger;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.SplitParser;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class SplitClientImpl implements SplitClient {
    private static final double TRACK_DEFAULT_VALUE = 0.0d;
    private final AttributesManager mAttributesManager;
    private final WeakReference<SplitClientContainer> mClientContainer;
    private final SplitClientConfig mConfig;
    private final SplitEventsManager mEventsManager;
    private final EventsTracker mEventsTracker;
    private boolean mIsClientDestroyed;
    private final Key mKey;
    private final WeakReference<SplitFactory> mSplitFactory;
    private final SplitValidator mSplitValidator;
    private final TelemetryStorageProducer mTelemetryStorageProducer;
    private final TreatmentManager mTreatmentManager;
    private final ValidationMessageLogger mValidationLogger;

    public SplitClientImpl(SplitFactory splitFactory, SplitClientContainer splitClientContainer, Key key, SplitParser splitParser, ImpressionListener impressionListener, SplitClientConfig splitClientConfig, SplitEventsManager splitEventsManager, EventsTracker eventsTracker, AttributesManager attributesManager, TelemetryStorageProducer telemetryStorageProducer, SplitValidator splitValidator, TreatmentManager treatmentManager) {
        this(splitFactory, splitClientContainer, key, splitParser, impressionListener, splitClientConfig, splitEventsManager, eventsTracker, attributesManager, telemetryStorageProducer, treatmentManager, splitValidator);
    }

    public SplitClientImpl(SplitFactory splitFactory, SplitClientContainer splitClientContainer, Key key, SplitParser splitParser, ImpressionListener impressionListener, SplitClientConfig splitClientConfig, SplitEventsManager splitEventsManager, EventsTracker eventsTracker, AttributesManager attributesManager, TelemetryStorageProducer telemetryStorageProducer, TreatmentManager treatmentManager, SplitValidator splitValidator) {
        this.mIsClientDestroyed = false;
        Preconditions.checkNotNull(splitParser);
        Preconditions.checkNotNull(impressionListener);
        this.mSplitFactory = new WeakReference<>((SplitFactory) Preconditions.checkNotNull(splitFactory));
        this.mClientContainer = new WeakReference<>((SplitClientContainer) Preconditions.checkNotNull(splitClientContainer));
        this.mKey = (Key) Preconditions.checkNotNull(key);
        this.mConfig = (SplitClientConfig) Preconditions.checkNotNull(splitClientConfig);
        this.mEventsManager = (SplitEventsManager) Preconditions.checkNotNull(splitEventsManager);
        this.mEventsTracker = (EventsTracker) Preconditions.checkNotNull(eventsTracker);
        this.mValidationLogger = new ValidationMessageLoggerImpl();
        this.mTelemetryStorageProducer = telemetryStorageProducer;
        this.mTreatmentManager = treatmentManager;
        this.mAttributesManager = (AttributesManager) Preconditions.checkNotNull(attributesManager);
        this.mSplitValidator = (SplitValidator) Preconditions.checkNotNull(splitValidator);
    }

    @Override // io.split.android.client.SplitClient
    public final void destroy() {
        SplitFactory splitFactory;
        this.mIsClientDestroyed = true;
        SplitClientContainer splitClientContainer = this.mClientContainer.get();
        if (splitClientContainer != null) {
            splitClientContainer.remove(this.mKey);
            if (!splitClientContainer.getAll().isEmpty() || (splitFactory = this.mSplitFactory.get()) == null) {
                return;
            }
            splitFactory.destroy();
        }
    }

    @Override // io.split.android.client.SplitClient
    public final void flush() {
        SplitFactory splitFactory = this.mSplitFactory.get();
        if (splitFactory != null) {
            splitFactory.flush();
        }
    }

    @Override // io.split.android.client.SplitClient
    public final boolean isReady() {
        return this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY);
    }

    @Override // io.split.android.client.SplitClient
    public final String getTreatment(String str) {
        return getTreatment(str, Collections.emptyMap());
    }

    @Override // io.split.android.client.SplitClient
    public final String getTreatment(String str, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatment(str, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e("Client getTreatment exception", e);
            this.mTelemetryStorageProducer.recordException(Method.TREATMENT);
            return "control";
        }
    }

    @Override // io.split.android.client.SplitClient
    public final SplitResult getTreatmentWithConfig(String str, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatmentWithConfig(str, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e("Client getTreatmentWithConfig exception", e);
            this.mTelemetryStorageProducer.recordException(Method.TREATMENT_WITH_CONFIG);
            return new SplitResult("control", "exception");
        }
    }

    @Override // io.split.android.client.SplitClient
    public final Map<String, String> getTreatments(List<String> list, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatments(list, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e("Client getTreatments exception", e);
            this.mTelemetryStorageProducer.recordException(Method.TREATMENTS);
            return TreatmentManagerHelper.controlTreatmentsForSplits(list, this.mSplitValidator);
        }
    }

    @Override // io.split.android.client.SplitClient
    public final Map<String, SplitResult> getTreatmentsWithConfig(List<String> list, Map<String, Object> map) {
        try {
            return this.mTreatmentManager.getTreatmentsWithConfig(list, map, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e("Client getTreatmentsWithConfig exception", e);
            this.mTelemetryStorageProducer.recordException(Method.TREATMENTS_WITH_CONFIG);
            return TreatmentManagerHelper.controlTreatmentsForSplitsWithConfig(list, this.mSplitValidator);
        }
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

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2) {
        return track(this.mKey.matchingKey(), str, str2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null);
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2, double d) {
        return track(this.mKey.matchingKey(), str, str2, d, null);
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null);
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, double d) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), str, d, null);
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2, Map<String, Object> map) {
        return track(this.mKey.matchingKey(), str, str2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, map);
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, String str2, double d, Map<String, Object> map) {
        return track(this.mKey.matchingKey(), str, str2, d, map);
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, Map<String, Object> map) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, map);
    }

    @Override // io.split.android.client.SplitClient
    public final boolean track(String str, double d, Map<String, Object> map) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), str, d, map);
    }

    private boolean track(String str, String str2, String str3, double d, Map<String, Object> map) {
        if (this.mIsClientDestroyed) {
            this.mValidationLogger.e("Client has already been destroyed - no calls possible", "track");
            return false;
        }
        return this.mEventsTracker.track(str, str2, str3, d, map, this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY));
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean setAttribute(String str, Object obj) {
        try {
            return this.mAttributesManager.setAttribute(str, obj);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error setting attribute: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return false;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final Object getAttribute(String str) {
        try {
            return this.mAttributesManager.getAttribute(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting attribute: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return null;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean setAttributes(Map<String, Object> map) {
        try {
            return this.mAttributesManager.setAttributes(map);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error setting attributes: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return false;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final Map<String, Object> getAllAttributes() {
        try {
            return this.mAttributesManager.getAllAttributes();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error getting attributes: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return Collections.emptyMap();
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean removeAttribute(String str) {
        try {
            return this.mAttributesManager.removeAttribute(str);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error removing attribute: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return false;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public final boolean clearAttributes() {
        try {
            return this.mAttributesManager.clearAttributes();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error clearing attributes: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(sb.toString());
            return false;
        }
    }
}
