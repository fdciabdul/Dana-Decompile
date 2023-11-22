package com.twilio.verify.models;

import com.alipay.mobile.rome.longlinkservice.LongLinkMsgConstants;
import kotlin.jvm.JvmName;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t"}, d2 = {"Lcom/twilio/verify/models/FactorType;", "", "", "factorTypeName", "Ljava/lang/String;", "getFactorTypeName", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PUSH"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public enum FactorType {
    PUSH(LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH);

    private final String factorTypeName;

    FactorType(String str) {
        this.factorTypeName = str;
    }

    @JvmName(name = "getFactorTypeName")
    public final String getFactorTypeName() {
        return this.factorTypeName;
    }
}
