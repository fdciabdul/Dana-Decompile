package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes3.dex */
abstract class BaseKeyPool<T extends Poolable> {
    final Queue<T> PlaceComponentResult = Util.BuiltInFictitiousFunctionClassFactory(20);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T KClassImpl$Data$declaredNonStaticMembers$2();
}
