package io.split.android.client.validators;

import com.google.common.base.Strings;
import io.split.android.client.dtos.Event;
import io.split.android.client.storage.splits.SplitsStorage;

/* loaded from: classes6.dex */
public class EventValidatorImpl implements EventValidator {
    private final String TYPE_REGEX = ValidationConfig.getInstance().getTrackEventNamePattern();
    private KeyValidator mKeyValidator;
    private final SplitsStorage mSplitsStorage;

    public EventValidatorImpl(KeyValidator keyValidator, SplitsStorage splitsStorage) {
        this.mKeyValidator = keyValidator;
        this.mSplitsStorage = splitsStorage;
    }

    @Override // io.split.android.client.validators.EventValidator
    public ValidationErrorInfo validate(Event event, boolean z) {
        if (event == null) {
            return new ValidationErrorInfo(200, "Event could not be null");
        }
        ValidationErrorInfo validate = this.mKeyValidator.validate(event.key, null);
        if (validate != null) {
            return validate;
        }
        if (event.trafficTypeName == null) {
            return new ValidationErrorInfo(200, "you passed a null or undefined traffic_type_name, traffic_type_name must be a non-empty string");
        }
        if (Strings.isNullOrEmpty(event.trafficTypeName.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty traffic_type_name, traffic_type_name must be a non-empty string");
        }
        if (event.eventTypeId == null) {
            return new ValidationErrorInfo(200, "you passed a null or undefined event_type, event_type must be a non-empty String");
        }
        if (Strings.isNullOrEmpty(event.eventTypeId.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty event_type, event_type must be a non-empty String");
        }
        if (!event.eventTypeId.matches(this.TYPE_REGEX)) {
            StringBuilder sb = new StringBuilder();
            sb.append("you passed ");
            sb.append(event.eventTypeId);
            sb.append(", event name must adhere to the regular expression ");
            sb.append(this.TYPE_REGEX);
            sb.append(". This means an event name must be alphanumeric, cannot be more than 80 characters long, and can only include a dash,  underscore, period, or colon as separators of alphanumeric characters.");
            return new ValidationErrorInfo(200, sb.toString());
        }
        if (!event.trafficTypeName.toLowerCase().equals(event.trafficTypeName)) {
            validate = new ValidationErrorInfo(101, "traffic_type_name should be all lowercase - converting string to lowercase", true);
        }
        if (!z || this.mSplitsStorage.isValidTrafficType(event.trafficTypeName)) {
            return validate;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Traffic Type ");
        sb2.append(event.trafficTypeName);
        sb2.append(" does not have any corresponding feature flags in this environment, make sure you’re tracking your events to a valid traffic type defined in the Split user interface");
        String obj = sb2.toString();
        if (validate == null) {
            return new ValidationErrorInfo(102, obj, true);
        }
        validate.addWarning(102, obj);
        return validate;
    }
}
