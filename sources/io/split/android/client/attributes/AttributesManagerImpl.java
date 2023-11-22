package io.split.android.client.attributes;

import com.google.common.base.Preconditions;
import io.split.android.client.service.attributes.AttributeTaskFactory;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.validators.AttributesValidator;
import io.split.android.client.validators.ValidationMessageLogger;
import java.util.Map;

/* loaded from: classes6.dex */
public class AttributesManagerImpl implements AttributesManager {
    private final AttributeTaskFactory mAttributeTaskFactory;
    private final AttributesStorage mAttributesStorage;
    private final AttributesValidator mAttributesValidator;
    private final PersistentAttributesStorage mPersistentAttributesStorage;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final ValidationMessageLogger mValidationMessageLogger;

    AttributesManagerImpl(AttributesStorage attributesStorage, AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger) {
        this.mAttributesStorage = (AttributesStorage) Preconditions.checkNotNull(attributesStorage);
        this.mAttributesValidator = (AttributesValidator) Preconditions.checkNotNull(attributesValidator);
        this.mValidationMessageLogger = (ValidationMessageLogger) Preconditions.checkNotNull(validationMessageLogger);
        this.mPersistentAttributesStorage = null;
        this.mAttributeTaskFactory = null;
        this.mSplitTaskExecutor = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributesManagerImpl(AttributesStorage attributesStorage, AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger, PersistentAttributesStorage persistentAttributesStorage, AttributeTaskFactory attributeTaskFactory, SplitTaskExecutor splitTaskExecutor) {
        this.mAttributesStorage = (AttributesStorage) Preconditions.checkNotNull(attributesStorage);
        this.mAttributesValidator = (AttributesValidator) Preconditions.checkNotNull(attributesValidator);
        this.mValidationMessageLogger = (ValidationMessageLogger) Preconditions.checkNotNull(validationMessageLogger);
        this.mPersistentAttributesStorage = persistentAttributesStorage;
        this.mAttributeTaskFactory = attributeTaskFactory;
        this.mSplitTaskExecutor = splitTaskExecutor;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttribute(String str, Object obj) {
        if (!this.mAttributesValidator.isValid(obj)) {
            logValidationWarning(str);
            return false;
        }
        this.mAttributesStorage.set(str, obj);
        submitUpdateTask(this.mPersistentAttributesStorage, this.mAttributesStorage.getAll());
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Object getAttribute(String str) {
        return this.mAttributesStorage.get(str);
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttributes(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.mAttributesValidator.isValid(entry.getValue())) {
                logValidationWarning(entry.getKey());
                return false;
            }
        }
        this.mAttributesStorage.set(map);
        submitUpdateTask(this.mPersistentAttributesStorage, this.mAttributesStorage.getAll());
        return true;
    }

    private void logValidationWarning(String str) {
        ValidationMessageLogger validationMessageLogger = this.mValidationMessageLogger;
        StringBuilder sb = new StringBuilder();
        sb.append("You passed an invalid attribute value for ");
        sb.append(str);
        sb.append(", acceptable types are String, double, float, long, int, boolean or Collections");
        validationMessageLogger.w(sb.toString(), "split attributes");
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Map<String, Object> getAllAttributes() {
        return this.mAttributesStorage.getAll();
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean removeAttribute(String str) {
        this.mAttributesStorage.remove(str);
        submitUpdateTask(this.mPersistentAttributesStorage, this.mAttributesStorage.getAll());
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean clearAttributes() {
        this.mAttributesStorage.clear();
        submitClearTask(this.mPersistentAttributesStorage);
        return true;
    }

    private void submitUpdateTask(PersistentAttributesStorage persistentAttributesStorage, Map<String, Object> map) {
        SplitTaskExecutor splitTaskExecutor;
        AttributeTaskFactory attributeTaskFactory;
        if (persistentAttributesStorage == null || (splitTaskExecutor = this.mSplitTaskExecutor) == null || (attributeTaskFactory = this.mAttributeTaskFactory) == null) {
            return;
        }
        splitTaskExecutor.submit(attributeTaskFactory.createAttributeUpdateTask(persistentAttributesStorage, map), null);
    }

    private void submitClearTask(PersistentAttributesStorage persistentAttributesStorage) {
        SplitTaskExecutor splitTaskExecutor;
        AttributeTaskFactory attributeTaskFactory;
        if (persistentAttributesStorage == null || (splitTaskExecutor = this.mSplitTaskExecutor) == null || (attributeTaskFactory = this.mAttributeTaskFactory) == null) {
            return;
        }
        splitTaskExecutor.submit(attributeTaskFactory.createAttributeClearTask(persistentAttributesStorage), null);
    }
}
