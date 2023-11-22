package com.google.protobuf;

/* loaded from: classes.dex */
final class OneofInfo {
    private final java.lang.reflect.Field caseField;

    /* renamed from: id  reason: collision with root package name */
    private final int f7443id;
    private final java.lang.reflect.Field valueField;

    public OneofInfo(int i, java.lang.reflect.Field field, java.lang.reflect.Field field2) {
        this.f7443id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public final int getId() {
        return this.f7443id;
    }

    public final java.lang.reflect.Field getCaseField() {
        return this.caseField;
    }

    public final java.lang.reflect.Field getValueField() {
        return this.valueField;
    }
}
