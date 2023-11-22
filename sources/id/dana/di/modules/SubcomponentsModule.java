package id.dana.di.modules;

import dagger.Module;
import id.dana.di.modules.features.danapoly.DanapolySubComponentModule;
import id.dana.di.modules.features.globalsend.GlobalSendSubComponentModule;
import id.dana.di.modules.features.groupsend.GroupSendSubComponentModule;
import id.dana.di.modules.features.imagecapture.ImageCaptureSubComponentModule;
import id.dana.di.modules.features.installedapp.InstalledAppSubComponentModule;
import id.dana.di.modules.features.mybills.MyBillsSubComponentModule;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/di/modules/SubcomponentsModule;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {GroupSendSubComponentModule.class, InstalledAppSubComponentModule.class, MyBillsSubComponentModule.class, DanapolySubComponentModule.class, ImageCaptureSubComponentModule.class, GlobalSendSubComponentModule.class})
/* loaded from: classes2.dex */
public final class SubcomponentsModule {
}
