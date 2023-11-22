package io.split.android.client.validators;

import com.google.common.base.Strings;

/* loaded from: classes6.dex */
public class SplitValidatorImpl implements SplitValidator {
    @Override // io.split.android.client.validators.SplitValidator
    public ValidationErrorInfo validateName(String str) {
        if (str == null) {
            return new ValidationErrorInfo(200, "you passed a null feature flag name, flag name must be a non-empty string");
        }
        if (Strings.isNullOrEmpty(str.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty feature flag name, flag name must be a non-empty string");
        }
        if (str.trim().length() != str.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append("feature flag name '");
            sb.append(str);
            sb.append("' has extra whitespace, trimming");
            return new ValidationErrorInfo(100, sb.toString(), true);
        }
        return null;
    }

    @Override // io.split.android.client.validators.SplitValidator
    public String splitNotFoundMessage(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("split: you passed '");
        sb.append(str);
        sb.append("' that does not exist in this environment, please double check what feature flags exist in the Split user interface.");
        return sb.toString();
    }
}
