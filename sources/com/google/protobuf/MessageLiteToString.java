package com.google.protobuf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.GeneratedMessageLite;
import id.dana.cashier.view.InputCardNumberView;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    MessageLiteToString() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb, int i) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (java.lang.reflect.Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            boolean z = true;
            if (substring.endsWith(LIST_SUFFIX) && !substring.endsWith(BUILDER_LIST_SUFFIX) && !substring.equals(LIST_SUFFIX)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(substring.substring(0, 1).toLowerCase());
                sb2.append(substring.substring(1, substring.length() - 4));
                String obj = sb2.toString();
                java.lang.reflect.Method method2 = (java.lang.reflect.Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    printField(sb, i, camelCaseToSnakeCase(obj), GeneratedMessageLite.invokeOrDie(method2, messageLite, new Object[0]));
                }
            }
            if (substring.endsWith(MAP_SUFFIX) && !substring.equals(MAP_SUFFIX)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(substring.substring(0, 1).toLowerCase());
                sb3.append(substring.substring(1, substring.length() - 3));
                String obj2 = sb3.toString();
                java.lang.reflect.Method method3 = (java.lang.reflect.Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    printField(sb, i, camelCaseToSnakeCase(obj2), GeneratedMessageLite.invokeOrDie(method3, messageLite, new Object[0]));
                }
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("set");
            sb4.append(substring);
            if (((java.lang.reflect.Method) hashMap2.get(sb4.toString())) != null) {
                if (substring.endsWith(BYTES_SUFFIX)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("get");
                    sb5.append(substring.substring(0, substring.length() - 5));
                    if (!hashMap.containsKey(sb5.toString())) {
                    }
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append(substring.substring(0, 1).toLowerCase());
                sb6.append(substring.substring(1));
                String obj3 = sb6.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append("get");
                sb7.append(substring);
                java.lang.reflect.Method method4 = (java.lang.reflect.Method) hashMap.get(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("has");
                sb8.append(substring);
                java.lang.reflect.Method method5 = (java.lang.reflect.Method) hashMap.get(sb8.toString());
                if (method4 != null) {
                    Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method4, messageLite, new Object[0]);
                    if (method5 == null) {
                        if (isDefaultValue(invokeOrDie)) {
                            z = false;
                        }
                    } else {
                        z = ((Boolean) GeneratedMessageLite.invokeOrDie(method5, messageLite, new Object[0])).booleanValue();
                    }
                    if (z) {
                        printField(sb, i, camelCaseToSnakeCase(obj3), invokeOrDie);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> it = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (it.hasNext()) {
                Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next = it.next();
                StringBuilder sb9 = new StringBuilder();
                sb9.append("[");
                sb9.append(next.getKey().getNumber());
                sb9.append("]");
                printField(sb, i, sb9.toString(), next.getValue());
            }
        }
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) messageLite;
        if (generatedMessageLite.unknownFields != null) {
            generatedMessageLite.unknownFields.printWithIndent(sb, i);
        }
    }

    private static boolean isDefaultValue(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        } else if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        } else if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            return obj instanceof MessageLite ? obj == ((MessageLite) obj).getDefaultInstanceForType() : (obj instanceof java.lang.Enum) && ((java.lang.Enum) obj).ordinal() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void printField(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                printField(sb, i, str, it.next());
            }
        } else if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                printField(sb, i, str, (Map.Entry) it2.next());
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(InputCardNumberView.DIVIDER);
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.escapeText((String) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof ByteString) {
                sb.append(": \"");
                sb.append(TextFormatEscaper.escapeBytes((ByteString) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(InputCardNumberView.DIVIDER);
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                printField(sb, i4, "key", entry.getKey());
                printField(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(InputCardNumberView.DIVIDER);
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String camelCaseToSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
