package androidx.core.content.pm;

import java.util.List;

/* loaded from: classes3.dex */
public abstract class ShortcutInfoCompatSaver<T> {

    /* loaded from: classes3.dex */
    public static class NoopImpl extends ShortcutInfoCompatSaver<Void> {
        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        public Void getAuthRequestContext() {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        public Void MyBillsEntityDataFactory(List<ShortcutInfoCompat> list) {
            return null;
        }
    }

    public abstract T MyBillsEntityDataFactory(List<ShortcutInfoCompat> list);

    public abstract T getAuthRequestContext();
}
