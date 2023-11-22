package com.otaliastudios.cameraview.engine.action;

import java.util.Arrays;

/* loaded from: classes8.dex */
public class Actions {
    public static BaseAction KClassImpl$Data$declaredNonStaticMembers$2(BaseAction... baseActionArr) {
        return new TogetherAction(Arrays.asList(baseActionArr));
    }

    public static BaseAction getAuthRequestContext(BaseAction... baseActionArr) {
        return new SequenceAction(Arrays.asList(baseActionArr));
    }

    public static BaseAction KClassImpl$Data$declaredNonStaticMembers$2(long j, BaseAction baseAction) {
        return new TimeoutAction(j, baseAction);
    }
}
