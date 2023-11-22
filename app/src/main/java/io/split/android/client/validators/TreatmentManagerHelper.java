package io.split.android.client.validators;

import io.split.android.client.SplitResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class TreatmentManagerHelper {
    public static Map<String, SplitResult> controlTreatmentsForSplitsWithConfig(List<String> list, SplitValidator splitValidator, String str, ValidationMessageLogger validationMessageLogger) {
        HashMap hashMap = new HashMap();
        for (String str2 : list) {
            if (!isInvalidSplit(splitValidator, str, validationMessageLogger, str2)) {
                hashMap.put(str2.trim(), new SplitResult("control"));
            }
        }
        return hashMap;
    }

    public static Map<String, String> controlTreatmentsForSplits(List<String> list, SplitValidator splitValidator, String str, ValidationMessageLogger validationMessageLogger) {
        HashMap hashMap = new HashMap();
        for (String str2 : list) {
            if (!isInvalidSplit(splitValidator, str, validationMessageLogger, str2)) {
                hashMap.put(str2.trim(), "control");
            }
        }
        return hashMap;
    }

    private static boolean isInvalidSplit(SplitValidator splitValidator, String str, ValidationMessageLogger validationMessageLogger, String str2) {
        ValidationErrorInfo validateName;
        if (splitValidator == null || (validateName = splitValidator.validateName(str2)) == null) {
            return false;
        }
        if (validateName.isError()) {
            if (validationMessageLogger != null) {
                validationMessageLogger.e(validateName, str);
                return true;
            }
            return true;
        } else if (validationMessageLogger != null) {
            validationMessageLogger.w(validateName, str);
            return false;
        } else {
            return false;
        }
    }

    public static Map<String, String> controlTreatmentsForSplits(List<String> list, SplitValidator splitValidator) {
        return controlTreatmentsForSplits(list, splitValidator, null, null);
    }

    public static Map<String, SplitResult> controlTreatmentsForSplitsWithConfig(List<String> list, SplitValidator splitValidator) {
        return controlTreatmentsForSplitsWithConfig(list, splitValidator, null, null);
    }
}
