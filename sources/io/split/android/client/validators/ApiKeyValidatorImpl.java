package io.split.android.client.validators;

import com.google.common.base.Strings;

/* loaded from: classes6.dex */
public class ApiKeyValidatorImpl implements ApiKeyValidator {
    @Override // io.split.android.client.validators.ApiKeyValidator
    public ValidationErrorInfo validate(String str) {
        if (str == null) {
            return new ValidationErrorInfo(200, "you passed a null sdkKey, the sdkKey must be a non-empty string");
        }
        if (Strings.isNullOrEmpty(str.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty sdkKey, sdkKey must be a non-empty string");
        }
        return null;
    }
}
