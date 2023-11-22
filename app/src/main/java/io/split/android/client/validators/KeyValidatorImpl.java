package io.split.android.client.validators;

import com.google.common.base.Strings;

/* loaded from: classes6.dex */
public class KeyValidatorImpl implements KeyValidator {
    private final int MAX_MATCHING_KEY_LENGTH = ValidationConfig.getInstance().getMaximumKeyLength();
    private final int MAX_BUCKETING_KEY_LENGTH = ValidationConfig.getInstance().getMaximumKeyLength();

    @Override // io.split.android.client.validators.KeyValidator
    public ValidationErrorInfo validate(String str, String str2) {
        if (str == null) {
            return new ValidationErrorInfo(200, "you passed a null key, matching key must be a non-empty string");
        }
        if (Strings.isNullOrEmpty(str.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty string, matching key must be a non-empty string");
        }
        if (str.length() > this.MAX_MATCHING_KEY_LENGTH) {
            StringBuilder sb = new StringBuilder();
            sb.append("matching key too long - must be ");
            sb.append(this.MAX_MATCHING_KEY_LENGTH);
            sb.append(" characters or less");
            return new ValidationErrorInfo(200, sb.toString());
        } else if (str2 != null) {
            if (Strings.isNullOrEmpty(str2.trim())) {
                return new ValidationErrorInfo(200, "you passed an empty string, bucketing key must be null or a non-empty string");
            }
            if (str2.length() > this.MAX_BUCKETING_KEY_LENGTH) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bucketing key too long - must be ");
                sb2.append(this.MAX_MATCHING_KEY_LENGTH);
                sb2.append(" characters or less");
                return new ValidationErrorInfo(200, sb2.toString());
            }
            return null;
        } else {
            return null;
        }
    }
}
