package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* loaded from: classes6.dex */
public class CoreComponentFactory extends android.app.AppComponentFactory {

    /* loaded from: classes6.dex */
    public interface CompatWrapped {
        Object MyBillsEntityDataFactory();
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object MyBillsEntityDataFactory;
        Activity instantiateActivity = super.instantiateActivity(classLoader, str, intent);
        if ((instantiateActivity instanceof CompatWrapped) && (MyBillsEntityDataFactory = ((CompatWrapped) instantiateActivity).MyBillsEntityDataFactory()) != null) {
            instantiateActivity = MyBillsEntityDataFactory;
        }
        return instantiateActivity;
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader, String str) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object MyBillsEntityDataFactory;
        Application instantiateApplication = super.instantiateApplication(classLoader, str);
        if ((instantiateApplication instanceof CompatWrapped) && (MyBillsEntityDataFactory = ((CompatWrapped) instantiateApplication).MyBillsEntityDataFactory()) != null) {
            instantiateApplication = MyBillsEntityDataFactory;
        }
        return instantiateApplication;
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object MyBillsEntityDataFactory;
        BroadcastReceiver instantiateReceiver = super.instantiateReceiver(classLoader, str, intent);
        if ((instantiateReceiver instanceof CompatWrapped) && (MyBillsEntityDataFactory = ((CompatWrapped) instantiateReceiver).MyBillsEntityDataFactory()) != null) {
            instantiateReceiver = MyBillsEntityDataFactory;
        }
        return instantiateReceiver;
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader classLoader, String str) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object MyBillsEntityDataFactory;
        ContentProvider instantiateProvider = super.instantiateProvider(classLoader, str);
        if ((instantiateProvider instanceof CompatWrapped) && (MyBillsEntityDataFactory = ((CompatWrapped) instantiateProvider).MyBillsEntityDataFactory()) != null) {
            instantiateProvider = MyBillsEntityDataFactory;
        }
        return instantiateProvider;
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Object MyBillsEntityDataFactory;
        Service instantiateService = super.instantiateService(classLoader, str, intent);
        if ((instantiateService instanceof CompatWrapped) && (MyBillsEntityDataFactory = ((CompatWrapped) instantiateService).MyBillsEntityDataFactory()) != null) {
            instantiateService = MyBillsEntityDataFactory;
        }
        return instantiateService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        T t2;
        return (!(t instanceof CompatWrapped) || (t2 = (T) ((CompatWrapped) t).MyBillsEntityDataFactory()) == null) ? t : t2;
    }
}
