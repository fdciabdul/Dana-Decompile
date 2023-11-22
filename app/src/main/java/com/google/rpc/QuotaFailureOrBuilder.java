package com.google.rpc;

import com.google.protobuf.MessageLiteOrBuilder;
import com.google.rpc.QuotaFailure;
import java.util.List;

/* loaded from: classes7.dex */
public interface QuotaFailureOrBuilder extends MessageLiteOrBuilder {
    QuotaFailure.Violation getViolations(int i);

    int getViolationsCount();

    List<QuotaFailure.Violation> getViolationsList();
}
