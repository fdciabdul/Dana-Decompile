package io.michaelrocks.libphonenumber.android.internal;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public final class RegexBasedMatcher implements MatcherApi {
    private final RegexCache regexCache = new RegexCache(100);

    public static MatcherApi create() {
        return new RegexBasedMatcher();
    }

    private RegexBasedMatcher() {
    }

    @Override // io.michaelrocks.libphonenumber.android.internal.MatcherApi
    public final boolean matchNationalNumber(CharSequence charSequence, Phonemetadata.PhoneNumberDesc phoneNumberDesc, boolean z) {
        String nationalNumberPattern = phoneNumberDesc.getNationalNumberPattern();
        if (nationalNumberPattern.length() == 0) {
            return false;
        }
        return match(charSequence, this.regexCache.getPatternForRegex(nationalNumberPattern), z);
    }

    private static boolean match(CharSequence charSequence, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(charSequence);
        if (matcher.lookingAt()) {
            if (matcher.matches()) {
                return true;
            }
            return z;
        }
        return false;
    }
}
