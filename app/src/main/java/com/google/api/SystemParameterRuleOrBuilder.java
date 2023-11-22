package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes7.dex */
public interface SystemParameterRuleOrBuilder extends MessageLiteOrBuilder {
    SystemParameter getParameters(int i);

    int getParametersCount();

    List<SystemParameter> getParametersList();

    String getSelector();

    ByteString getSelectorBytes();
}
