package com.alibaba.griver.lottie.animation.content;

import android.graphics.Path;
import com.alibaba.griver.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CompoundTrimPathContent {
    private List<TrimPathContent> contents = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTrimPath(TrimPathContent trimPathContent) {
        this.contents.add(trimPathContent);
    }

    public void apply(Path path) {
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Utils.applyTrimPathIfNeeded(path, this.contents.get(size));
        }
    }
}
