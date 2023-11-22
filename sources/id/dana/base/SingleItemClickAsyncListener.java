package id.dana.base;

import id.dana.base.BaseAsyncRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/base/SingleItemClickAsyncListener;", "Lid/dana/base/BaseAsyncRecyclerViewHolder$OnItemClickListener;", "", "p0", "", "getAuthRequestContext", "(I)V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/MultipleClickHandler;", "MyBillsEntityDataFactory", "Lid/dana/base/MultipleClickHandler;", "<init>", "(Lid/dana/base/MultipleClickHandler;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class SingleItemClickAsyncListener implements BaseAsyncRecyclerViewHolder.OnItemClickListener {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MultipleClickHandler getAuthRequestContext;

    public abstract void BuiltInFictitiousFunctionClassFactory(int p0);

    public SingleItemClickAsyncListener(MultipleClickHandler multipleClickHandler) {
        Intrinsics.checkNotNullParameter(multipleClickHandler, "");
        this.getAuthRequestContext = multipleClickHandler;
    }

    @Override // id.dana.base.BaseAsyncRecyclerViewHolder.OnItemClickListener
    public final void getAuthRequestContext(int p0) {
        if (this.getAuthRequestContext.isClickable()) {
            this.getAuthRequestContext.disableClick();
            BuiltInFictitiousFunctionClassFactory(p0);
        }
    }
}
