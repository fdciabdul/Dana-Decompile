package com.alipay.multigateway.sdk.decision.condition.matcher.impl;

import com.alipay.multigateway.sdk.decision.condition.matcher.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class RegexMatcher implements Matcher<String> {
    @Override // com.alipay.multigateway.sdk.decision.condition.matcher.Matcher
    public final boolean isMatch(String str, String str2) {
        return Pattern.matches(str, str2);
    }
}
