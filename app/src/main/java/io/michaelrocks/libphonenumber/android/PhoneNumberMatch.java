package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonenumber;
import java.util.Arrays;

/* loaded from: classes9.dex */
public final class PhoneNumberMatch {
    private final Phonenumber.PhoneNumber number;
    private final String rawString;
    private final int start;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PhoneNumberMatch(int i, String str, Phonenumber.PhoneNumber phoneNumber) {
        if (i < 0) {
            throw new IllegalArgumentException("Start index must be >= 0.");
        }
        if (str == null || phoneNumber == null) {
            throw null;
        }
        this.start = i;
        this.rawString = str;
        this.number = phoneNumber;
    }

    public final Phonenumber.PhoneNumber number() {
        return this.number;
    }

    public final int start() {
        return this.start;
    }

    public final int end() {
        return this.start + this.rawString.length();
    }

    public final String rawString() {
        return this.rawString;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.start), this.rawString, this.number});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PhoneNumberMatch) {
            PhoneNumberMatch phoneNumberMatch = (PhoneNumberMatch) obj;
            return this.rawString.equals(phoneNumberMatch.rawString) && this.start == phoneNumberMatch.start && this.number.equals(phoneNumberMatch.number);
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PhoneNumberMatch [");
        sb.append(start());
        sb.append(",");
        sb.append(end());
        sb.append(") ");
        sb.append(this.rawString);
        return sb.toString();
    }
}
