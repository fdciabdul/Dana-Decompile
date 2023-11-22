package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes7.dex */
public interface MoneyOrBuilder extends MessageLiteOrBuilder {
    String getCurrencyCode();

    ByteString getCurrencyCodeBytes();

    int getNanos();

    long getUnits();
}
