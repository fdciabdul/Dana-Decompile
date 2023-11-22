package io.split.android.client;

import com.google.common.base.Preconditions;
import io.split.android.client.dtos.Event;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.telemetry.model.Method;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.EventValidator;
import io.split.android.client.validators.ValidationErrorInfo;
import io.split.android.client.validators.ValidationMessageLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class EventsTrackerImpl implements EventsTracker {
    private static final int ESTIMATED_EVENT_SIZE_WITHOUT_PROPS = 1024;
    private final AtomicBoolean isTrackingEnabled = new AtomicBoolean(true);
    private final EventPropertiesProcessor mEventPropertiesProcessor;
    private final EventValidator mEventValidator;
    private final SyncManager mSyncManager;
    private final TelemetryStorageProducer mTelemetryStorageProducer;
    private final ValidationMessageLogger mValidationLogger;

    public EventsTrackerImpl(EventValidator eventValidator, ValidationMessageLogger validationMessageLogger, TelemetryStorageProducer telemetryStorageProducer, EventPropertiesProcessor eventPropertiesProcessor, SyncManager syncManager) {
        this.mEventValidator = (EventValidator) Preconditions.checkNotNull(eventValidator);
        this.mValidationLogger = (ValidationMessageLogger) Preconditions.checkNotNull(validationMessageLogger);
        this.mTelemetryStorageProducer = (TelemetryStorageProducer) Preconditions.checkNotNull(telemetryStorageProducer);
        this.mEventPropertiesProcessor = (EventPropertiesProcessor) Preconditions.checkNotNull(eventPropertiesProcessor);
        this.mSyncManager = (SyncManager) Preconditions.checkNotNull(syncManager);
    }

    @Override // io.split.android.client.EventsTracker
    public void enableTracking(boolean z) {
        this.isTrackingEnabled.set(z);
    }

    @Override // io.split.android.client.EventsTracker
    public boolean track(String str, String str2, String str3, double d, Map<String, Object> map, boolean z) {
        if (!this.isTrackingEnabled.get()) {
            Logger.v("Event not tracked because tracking is disabled");
            return false;
        }
        try {
            Event event = new Event();
            event.eventTypeId = str3;
            event.trafficTypeName = str2;
            event.key = str;
            event.value = d;
            event.timestamp = System.currentTimeMillis();
            event.properties = map;
            ValidationErrorInfo validate = this.mEventValidator.validate(event, z);
            if (validate != null) {
                if (validate.isError()) {
                    this.mValidationLogger.e(validate, "track");
                    return false;
                }
                this.mValidationLogger.w(validate, "track");
                event.trafficTypeName = event.trafficTypeName.toLowerCase();
            }
            ProcessedEventProperties process = this.mEventPropertiesProcessor.process(event.properties);
            if (process.isValid()) {
                long currentTimeMillis = System.currentTimeMillis();
                event.properties = process.getProperties();
                event.setSizeInBytes(process.getSizeInBytes() + 1024);
                this.mSyncManager.pushEvent(event);
                this.mTelemetryStorageProducer.recordLatency(Method.TRACK, System.currentTimeMillis() - currentTimeMillis);
                return true;
            }
            return false;
        } catch (Exception unused) {
            this.mTelemetryStorageProducer.recordException(Method.TRACK);
            return false;
        }
    }
}
