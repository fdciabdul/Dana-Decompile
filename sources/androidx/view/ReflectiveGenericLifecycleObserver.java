package androidx.view;

import androidx.view.ClassesInfoCache;
import androidx.view.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
@Deprecated
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final Object MyBillsEntityDataFactory;
    private final ClassesInfoCache.CallbackInfo PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.MyBillsEntityDataFactory = obj;
        ClassesInfoCache classesInfoCache = ClassesInfoCache.PlaceComponentResult;
        Class<?> cls = obj.getClass();
        ClassesInfoCache.CallbackInfo callbackInfo = classesInfoCache.getAuthRequestContext.get(cls);
        this.PlaceComponentResult = callbackInfo == null ? classesInfoCache.getAuthRequestContext(cls, null) : callbackInfo;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ClassesInfoCache.CallbackInfo callbackInfo = this.PlaceComponentResult;
        Object obj = this.MyBillsEntityDataFactory;
        ClassesInfoCache.CallbackInfo.BuiltInFictitiousFunctionClassFactory(callbackInfo.KClassImpl$Data$declaredNonStaticMembers$2.get(event), lifecycleOwner, event, obj);
        ClassesInfoCache.CallbackInfo.BuiltInFictitiousFunctionClassFactory(callbackInfo.KClassImpl$Data$declaredNonStaticMembers$2.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
    }
}
