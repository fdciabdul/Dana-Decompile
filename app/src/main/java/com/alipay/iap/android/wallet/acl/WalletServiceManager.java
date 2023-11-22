package com.alipay.iap.android.wallet.acl;

import com.alipay.iap.android.wallet.acl.base.BaseService;
import com.alipay.iap.android.wallet.acl.base.ServiceMetaInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class WalletServiceManager {
    private static WalletServiceManager instance;
    private final String TAG = "WalletServiceManager";
    Map<Class<? extends BaseService>, BaseService> serviceMap = new HashMap();
    private final String IllegalAccessException = "10001";
    private final String InstantiationException = "10002";
    private final String InvocationTargetException = "10003";

    private WalletServiceManager() {
    }

    public static WalletServiceManager getInstance() {
        if (instance == null) {
            instance = new WalletServiceManager();
        }
        return instance;
    }

    public void registerServices(Class<? extends BaseService>... clsArr) throws BaseService.NoServiceMetaInfoException, BaseService.ServiceRegisterException {
        for (Class<? extends BaseService> cls : clsArr) {
            InterfaceDetail findAnnotation = findAnnotation(cls, ServiceMetaInfo.class);
            if (findAnnotation.annotation != 0) {
                try {
                    this.serviceMap.put(findAnnotation.serviceInterface, cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (IllegalAccessException unused) {
                    throw new BaseService.ServiceRegisterException("Service initialization error [10001]");
                } catch (InstantiationException unused2) {
                    throw new BaseService.ServiceRegisterException("Service initialization error [10002]");
                } catch (NoSuchMethodException unused3) {
                    throw new BaseService.ServiceRegisterException("No default null constructor found. Please ensure a null constructor is available");
                } catch (InvocationTargetException unused4) {
                    throw new BaseService.ServiceRegisterException("Service initialization error [10003]");
                }
            }
        }
    }

    public <T extends BaseService> T getService(Class<? extends T> cls) throws ServiceNotFoundException {
        T t = (T) this.serviceMap.get(cls);
        if (t != null) {
            return t;
        }
        throw new ServiceNotFoundException("Service is not found");
    }

    /* loaded from: classes.dex */
    public class ServiceNotFoundException extends Exception {
        public ServiceNotFoundException(String str) {
            super(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> InterfaceDetail findAnnotation(Class cls, Class<T> cls2) throws BaseService.NoServiceMetaInfoException {
        InterfaceDetail interfaceDetail;
        if (cls == null) {
            throw new BaseService.NoServiceMetaInfoException("Please associate ServiceMetaInfo annotation to the subclass of BaseService");
        }
        Annotation annotation = cls.getAnnotation(cls2);
        if (annotation == null) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (true) {
                interfaceDetail = null;
                if (i >= length) {
                    break;
                }
                Class<?> cls3 = interfaces[i];
                if (BaseService.class.isAssignableFrom(cls3)) {
                    annotation = cls3.getAnnotation(cls2);
                    interfaceDetail = new InterfaceDetail(annotation, cls3);
                    break;
                }
                i++;
            }
            return annotation == null ? findAnnotation(cls.getSuperclass(), cls2) : interfaceDetail;
        }
        return new InterfaceDetail(annotation, cls);
    }

    public void clearAllLoadedService() {
        this.serviceMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class InterfaceDetail<T> {
        protected T annotation;
        protected Class<? extends BaseService> serviceInterface;

        protected InterfaceDetail(T t, Class<? extends BaseService> cls) {
            this.annotation = t;
            this.serviceInterface = cls;
        }
    }
}
