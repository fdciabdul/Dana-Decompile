package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes7.dex */
public interface ContextOrBuilder extends MessageLiteOrBuilder {
    ContextRule getRules(int i);

    int getRulesCount();

    List<ContextRule> getRulesList();
}
