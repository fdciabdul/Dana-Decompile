package com.alipay.multigateway.sdk.decision.condition.matcher.impl;

import com.alipay.multigateway.sdk.decision.condition.matcher.Matcher;
import com.alipay.multigateway.sdk.util.ParseUtil;

/* loaded from: classes3.dex */
public final class NumberEqualsMatcher implements Matcher<Float> {
    @Override // com.alipay.multigateway.sdk.decision.condition.matcher.Matcher
    public final boolean isMatch(String str, Float f) {
        return f.floatValue() == ParseUtil.parseFloat(str);
    }
}
