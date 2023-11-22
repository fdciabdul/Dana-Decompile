package com.zhuinden.simplestack;

import com.zhuinden.simplestack.Backstack;
import java.util.Map;
import javax.annotation.Nonnull;

/* loaded from: classes2.dex */
public class DefaultStateClearStrategy implements Backstack.StateClearStrategy {
    @Override // com.zhuinden.simplestack.Backstack.StateClearStrategy
    public void clearStatesNotIn(@Nonnull Map<Object, SavedState> map, @Nonnull StateChange stateChange) {
        map.keySet().retainAll(stateChange.getNewKeys());
    }
}
