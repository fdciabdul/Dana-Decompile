package org.yaml.snakeyaml.introspector;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes6.dex */
public abstract class GenericProperty extends Property {
    private final Type MyBillsEntityDataFactory;
    private Class<?>[] PlaceComponentResult;
    private boolean getAuthRequestContext;

    public GenericProperty(String str, Class<?> cls, Type type) {
        super(str, cls);
        this.MyBillsEntityDataFactory = type;
        this.getAuthRequestContext = type == null;
    }

    @Override // org.yaml.snakeyaml.introspector.Property
    public final Class<?>[] BuiltInFictitiousFunctionClassFactory() {
        if (!this.getAuthRequestContext) {
            Type type = this.MyBillsEntityDataFactory;
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                if (actualTypeArguments.length > 0) {
                    this.PlaceComponentResult = new Class[actualTypeArguments.length];
                    int i = 0;
                    while (true) {
                        if (i >= actualTypeArguments.length) {
                            break;
                        }
                        Type type2 = actualTypeArguments[i];
                        if (type2 instanceof Class) {
                            this.PlaceComponentResult[i] = (Class) type2;
                        } else if (type2 instanceof ParameterizedType) {
                            this.PlaceComponentResult[i] = (Class) ((ParameterizedType) type2).getRawType();
                        } else if (type2 instanceof GenericArrayType) {
                            Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                            if (genericComponentType instanceof Class) {
                                this.PlaceComponentResult[i] = Array.newInstance((Class) genericComponentType, 0).getClass();
                            } else {
                                this.PlaceComponentResult = null;
                                break;
                            }
                        } else {
                            this.PlaceComponentResult = null;
                            break;
                        }
                        i++;
                    }
                }
            } else if (type instanceof GenericArrayType) {
                Type genericComponentType2 = ((GenericArrayType) type).getGenericComponentType();
                if (genericComponentType2 instanceof Class) {
                    this.PlaceComponentResult = new Class[]{(Class) genericComponentType2};
                }
            } else if ((type instanceof Class) && ((Class) type).isArray()) {
                this.PlaceComponentResult = r0;
                Class<?>[] clsArr = {KClassImpl$Data$declaredNonStaticMembers$2().getComponentType()};
            }
            this.getAuthRequestContext = true;
        }
        return this.PlaceComponentResult;
    }
}
