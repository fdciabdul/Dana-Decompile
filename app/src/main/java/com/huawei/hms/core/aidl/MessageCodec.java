package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class MessageCodec {
    protected void BuiltInFictitiousFunctionClassFactory(String str, List list, Bundle bundle) {
        Bundle bundle2 = null;
        for (Object obj : list) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(str, bundle2);
                bundle2.putInt("_val_type_", 1);
            }
            Bundle bundle3 = new Bundle();
            MyBillsEntityDataFactory("_value_", obj, bundle3);
            bundle2.putBundle("_next_item_", bundle3);
            bundle2 = bundle3;
        }
    }

    public final IMessageEntity KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle, IMessageEntity iMessageEntity) {
        if (bundle == null) {
            return iMessageEntity;
        }
        bundle.setClassLoader(getClass().getClassLoader());
        for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    try {
                        Object authRequestContext = getAuthRequestContext(field, bundle);
                        if (authRequestContext != null) {
                            boolean isAccessible = field.isAccessible();
                            field.setAccessible(true);
                            field.set(iMessageEntity, authRequestContext);
                            field.setAccessible(isAccessible);
                        }
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("decode, set value of the field exception, field name:");
                        sb.append(field.getName());
                        InstrumentInjector.log_e("MessageCodec", sb.toString());
                    }
                }
            }
        }
        return iMessageEntity;
    }

    protected List<Object> MyBillsEntityDataFactory(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle2 = bundle.getBundle("_next_item_"); bundle2 != null; bundle2 = bundle2.getBundle("_next_item_")) {
            Object obj = bundle2.get("_value_");
            if (!obj.getClass().isPrimitive() && !(obj instanceof String) && !(obj instanceof Serializable)) {
                if (obj instanceof Bundle) {
                    Bundle bundle3 = (Bundle) obj;
                    int i = bundle3.getInt("_val_type_", -1);
                    if (i == 1) {
                        throw new InstantiationException("Nested List can not be supported");
                    }
                    if (i == 0) {
                        arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2(bundle3, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                    } else {
                        throw new InstantiationException("Unknown type can not be supported");
                    }
                } else {
                    continue;
                }
            } else {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(String str, Object obj, Bundle bundle) {
        if (obj == null || BuiltInFictitiousFunctionClassFactory(str, obj, bundle)) {
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof List) {
            BuiltInFictitiousFunctionClassFactory(str, (List) obj, bundle);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj instanceof IMessageEntity) {
            Bundle PlaceComponentResult = PlaceComponentResult((IMessageEntity) obj, new Bundle());
            PlaceComponentResult.putInt("_val_type_", 0);
            bundle.putBundle(str, PlaceComponentResult);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("cannot support type, ");
            sb.append(str);
            InstrumentInjector.log_e("MessageCodec", sb.toString());
        }
    }

    public final Bundle PlaceComponentResult(IMessageEntity iMessageEntity, Bundle bundle) {
        for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    try {
                        boolean isAccessible = field.isAccessible();
                        field.setAccessible(true);
                        MyBillsEntityDataFactory(field.getName(), field.get(iMessageEntity), bundle);
                        field.setAccessible(isAccessible);
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("encode, get value of the field exception, field name: ");
                        sb.append(field.getName());
                        InstrumentInjector.log_e("MessageCodec", sb.toString());
                    }
                }
            }
        }
        return bundle;
    }

    private Object getAuthRequestContext(Field field, Bundle bundle) {
        String name = field.getName();
        Object obj = bundle.get(name);
        if (obj instanceof Bundle) {
            try {
                Bundle bundle2 = (Bundle) obj;
                int i = bundle2.getInt("_val_type_", -1);
                if (i == 1) {
                    return MyBillsEntityDataFactory(field.getGenericType(), bundle2);
                }
                if (i == 0) {
                    return KClassImpl$Data$declaredNonStaticMembers$2((Bundle) obj, (IMessageEntity) field.getType().newInstance());
                }
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("decode, read value of the field exception, field name: ");
                sb.append(name);
                InstrumentInjector.log_e("MessageCodec", sb.toString());
                return null;
            }
        }
        return obj;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str, Object obj, Bundle bundle) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else {
            return false;
        }
    }
}
