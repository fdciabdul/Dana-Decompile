package com.alibaba.ariver.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.Visit;

/* loaded from: classes6.dex */
public class VisitNode extends NodeInstance implements Visit {
    public static final Parcelable.Creator<VisitNode> CREATOR = new Parcelable.Creator<VisitNode>() { // from class: com.alibaba.ariver.app.VisitNode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisitNode createFromParcel(Parcel parcel) {
            return new VisitNode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisitNode[] newArray(int i) {
            return new VisitNode[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f5963a;

    public VisitNode(Page page) {
        super(page);
    }

    public void setVisitUrl(String str) {
        this.f5963a = str;
    }

    @Override // com.alibaba.ariver.app.api.Visit
    public String getVisitUrl() {
        return this.f5963a;
    }

    public VisitNode(Parcel parcel) {
        super(parcel);
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}
