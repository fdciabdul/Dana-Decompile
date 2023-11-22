package io.split.android.client.dtos;

/* loaded from: classes6.dex */
public class MySegment {

    /* renamed from: id  reason: collision with root package name */
    public String f8252id;
    public String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((MySegment) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
