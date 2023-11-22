package com.alibaba.ariver.resource.api.prepare;

/* loaded from: classes6.dex */
public interface PrepareStep {
    void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback) throws PrepareException;

    void finish();

    StepType getType();

    boolean isFinished();
}
