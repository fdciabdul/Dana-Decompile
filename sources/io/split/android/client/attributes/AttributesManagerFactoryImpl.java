package io.split.android.client.attributes;

import com.google.common.base.Preconditions;
import io.split.android.client.service.attributes.AttributeTaskFactoryImpl;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.validators.AttributesValidator;
import io.split.android.client.validators.ValidationMessageLogger;

/* loaded from: classes6.dex */
public class AttributesManagerFactoryImpl implements AttributesManagerFactory {
    private final AttributesValidator mAttributesValidator;
    private final PersistentAttributesStorage mPersistentAttributesStorage;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final ValidationMessageLogger mValidationMessageLogger;

    public AttributesManagerFactoryImpl(AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger) {
        this(attributesValidator, validationMessageLogger, null, null);
    }

    public AttributesManagerFactoryImpl(AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger, PersistentAttributesStorage persistentAttributesStorage, SplitTaskExecutor splitTaskExecutor) {
        this.mAttributesValidator = (AttributesValidator) Preconditions.checkNotNull(attributesValidator);
        this.mValidationMessageLogger = (ValidationMessageLogger) Preconditions.checkNotNull(validationMessageLogger);
        this.mPersistentAttributesStorage = persistentAttributesStorage;
        this.mSplitTaskExecutor = splitTaskExecutor;
    }

    @Override // io.split.android.client.attributes.AttributesManagerFactory
    public AttributesManager getManager(String str, AttributesStorage attributesStorage) {
        return new AttributesManagerImpl(attributesStorage, this.mAttributesValidator, this.mValidationMessageLogger, this.mPersistentAttributesStorage, new AttributeTaskFactoryImpl(str, attributesStorage), this.mSplitTaskExecutor);
    }
}
