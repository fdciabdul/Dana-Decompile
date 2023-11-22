package com.alipay.multigateway.sdk.decision.condition.matcher.impl;

import com.alipay.multigateway.sdk.decision.condition.matcher.Matcher;

/* loaded from: classes3.dex */
public final class TextStartWithMatcher implements Matcher<String> {
    @Override // com.alipay.multigateway.sdk.decision.condition.matcher.Matcher
    public final boolean isMatch(String str, String str2) {
        return str2.startsWith(str);
    }
}
