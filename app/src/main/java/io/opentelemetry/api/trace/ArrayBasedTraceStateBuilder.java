package io.opentelemetry.api.trace;

import io.opentelemetry.api.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
final class ArrayBasedTraceStateBuilder implements TraceStateBuilder {
    private static final ArrayBasedTraceState EMPTY = ArrayBasedTraceState.create(Collections.emptyList());
    private static final int KEY_MAX_SIZE = 256;
    private static final int MAX_ENTRIES = 32;
    private static final int MAX_TENANT_ID_SIZE = 240;
    private static final int MAX_VENDOR_ID_SIZE = 13;
    private static final int VALUE_MAX_SIZE = 256;
    int numEntries;
    private final List<String> reversedEntries;

    private static boolean isNotDigit(char c) {
        return c < '0' || c > '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TraceState empty() {
        return EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBasedTraceStateBuilder() {
        this.reversedEntries = new ArrayList();
        this.numEntries = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBasedTraceStateBuilder(ArrayBasedTraceState arrayBasedTraceState) {
        List<String> entries = arrayBasedTraceState.getEntries();
        int size = entries.size();
        this.reversedEntries = new ArrayList(size);
        for (int i = size - 2; i >= 0; i -= 2) {
            this.reversedEntries.add(entries.get(i));
            this.reversedEntries.add(entries.get(i + 1));
        }
        this.numEntries = size / 2;
    }

    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public final TraceStateBuilder put(String str, String str2) {
        if (isKeyValid(str) && isValueValid(str2) && this.numEntries < 32) {
            for (int i = 0; i < this.reversedEntries.size(); i += 2) {
                if (this.reversedEntries.get(i).equals(str)) {
                    int i2 = i + 1;
                    String str3 = this.reversedEntries.get(i2);
                    this.reversedEntries.set(i2, str2);
                    if (str3 == null) {
                        this.numEntries++;
                    }
                    return this;
                }
            }
            this.reversedEntries.add(str);
            this.reversedEntries.add(str2);
            this.numEntries++;
        }
        return this;
    }

    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public final TraceStateBuilder remove(String str) {
        if (str == null) {
            return this;
        }
        for (int i = 0; i < this.reversedEntries.size(); i += 2) {
            if (this.reversedEntries.get(i).equals(str)) {
                this.reversedEntries.set(i + 1, null);
                this.numEntries--;
                return this;
            }
        }
        return this;
    }

    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public final TraceState build() {
        if (this.numEntries == 0) {
            return empty();
        }
        if (this.reversedEntries.size() == 2) {
            return ArrayBasedTraceState.create(new ArrayList(this.reversedEntries));
        }
        String[] strArr = new String[this.numEntries * 2];
        int i = 0;
        for (int size = this.reversedEntries.size() - 2; size >= 0; size -= 2) {
            String str = this.reversedEntries.get(size);
            String str2 = this.reversedEntries.get(size + 1);
            if (str2 != null) {
                int i2 = i + 1;
                strArr[i] = str;
                strArr[i2] = str2;
                i = i2 + 1;
            }
        }
        return ArrayBasedTraceState.create(Arrays.asList(strArr));
    }

    private static boolean isKeyValid(@Nullable String str) {
        int length;
        if (str == null || str.length() > 256 || str.isEmpty() || isNotLowercaseLetterOrDigit(str.charAt(0))) {
            return false;
        }
        boolean z = false;
        for (int i = 1; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (isNotLegalKeyCharacter(charAt)) {
                return false;
            }
            if (charAt == '@') {
                if (z || i > 240 || (length = (str.length() - i) - 1) > 13 || length == 0) {
                    return false;
                }
                z = true;
            }
        }
        if (z) {
            return true;
        }
        return isNotDigit(str.charAt(0));
    }

    private static boolean isNotLegalKeyCharacter(char c) {
        return (!isNotLowercaseLetterOrDigit(c) || c == '_' || c == '-' || c == '@' || c == '*' || c == '/') ? false : true;
    }

    private static boolean isNotLowercaseLetterOrDigit(char c) {
        return (c < 'a' || c > 'z') && isNotDigit(c);
    }

    private static boolean isValueValid(@Nullable String str) {
        if (StringUtils.isNullOrEmpty(str) || str.length() > 256 || str.charAt(str.length() - 1) == ' ') {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ',' || charAt == '=' || charAt < ' ' || charAt > '~') {
                return false;
            }
        }
        return true;
    }
}
