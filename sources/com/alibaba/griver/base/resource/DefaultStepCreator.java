package com.alibaba.griver.base.resource;

import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepCreator;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.prepare.steps.StartStep;
import com.alibaba.ariver.resource.prepare.steps.UpdateStep;

/* loaded from: classes6.dex */
class DefaultStepCreator implements StepCreator {

    /* renamed from: com.alibaba.griver.base.resource.DefaultStepCreator$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType;

        static {
            int[] iArr = new int[StepType.values().length];
            $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType = iArr;
            try {
                iArr[StepType.SETUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[StepType.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[StepType.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[StepType.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepCreator
    public PrepareStep createStep(StepType stepType) {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[stepType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return new StartStep();
                }
                return new GRVDownloadStep();
            }
            return new UpdateStep();
        }
        return new GRVSetUpStep();
    }
}
