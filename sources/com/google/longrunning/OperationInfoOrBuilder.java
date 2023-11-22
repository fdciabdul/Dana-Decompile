package com.google.longrunning;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* loaded from: classes7.dex */
public interface OperationInfoOrBuilder extends MessageLiteOrBuilder {
    String getMetadataType();

    ByteString getMetadataTypeBytes();

    String getResponseType();

    ByteString getResponseTypeBytes();
}
