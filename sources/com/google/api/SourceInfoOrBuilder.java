package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes7.dex */
public interface SourceInfoOrBuilder extends MessageLiteOrBuilder {
    Any getSourceFiles(int i);

    int getSourceFilesCount();

    List<Any> getSourceFilesList();
}
