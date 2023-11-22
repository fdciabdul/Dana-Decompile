package id.dana.danah5.extension;

import com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension;
import id.dana.utils.LocaleUtil;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danah5/extension/DanaGriverAppLanguageExtension;", "Lcom/alibaba/griver/base/common/bridge/GriverAppLanguageExtension;", "", "getAppLanguage", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaGriverAppLanguageExtension implements GriverAppLanguageExtension {
    @Inject
    public DanaGriverAppLanguageExtension() {
    }

    @Override // com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension
    public final String getAppLanguage() {
        String MyBillsEntityDataFactory = LocaleUtil.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }
}
