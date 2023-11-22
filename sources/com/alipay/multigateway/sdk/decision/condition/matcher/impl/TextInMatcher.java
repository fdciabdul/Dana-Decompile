package com.alipay.multigateway.sdk.decision.condition.matcher.impl;

import com.alipay.multigateway.sdk.decision.condition.matcher.Matcher;

/* loaded from: classes3.dex */
public final class TextInMatcher implements Matcher<String> {
    @Override // com.alipay.multigateway.sdk.decision.condition.matcher.Matcher
    public final boolean isMatch(String str, String str2) {
        for (String str3 : str.split(",")) {
            if (str3.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
