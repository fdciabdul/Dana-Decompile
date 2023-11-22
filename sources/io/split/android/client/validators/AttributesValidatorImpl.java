package io.split.android.client.validators;

import java.util.Collection;

/* loaded from: classes6.dex */
public class AttributesValidatorImpl implements AttributesValidator {
    @Override // io.split.android.client.validators.AttributesValidator
    public boolean isValid(Object obj) {
        return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Collection);
    }
}
