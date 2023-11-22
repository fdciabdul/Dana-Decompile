package id.dana.explore.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.textview.MaterialTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.data.services.repository.ServicesEntityRepository;
import id.dana.explore.domain.sku.model.ExploreServiceModel;
import id.dana.explore.model.ExploreServiceWrapper;
import id.dana.mybills.ui.constant.MyBillsServiceKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/explore/view/ExploreServiceViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/model/ExploreServiceWrapper;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/explore/model/ExploreServiceWrapper;)V", "PlaceComponentResult", "getAuthRequestContext", "", "(Z)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreServiceViewHolder extends BaseRecyclerViewHolder<ExploreServiceWrapper> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int[] MyBillsEntityDataFactory = {-1763235217, 697012916, -1782369776, 229170562, -389196500, -840950015, -2026326830, 1136303050, -672151075, 1210398671, 356106006, -1643034037, -1697330127, 560326876, 1183562602, -2137181776, -1204750085, 1517509462};
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;

    private static void PlaceComponentResult(AppCompatImageView appCompatImageView, int i) {
        int i2 = getAuthRequestContext + 97;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        try {
            if (!(appCompatImageView instanceof ImageView)) {
                appCompatImageView.setImageResource(i);
                return;
            }
            int i4 = getAuthRequestContext + 105;
            PlaceComponentResult = i4 % 128;
            boolean z = i4 % 2 != 0;
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            if (!z) {
                return;
            }
            int i5 = 17 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ExploreServiceWrapper exploreServiceWrapper) {
        int i = PlaceComponentResult + 45;
        getAuthRequestContext = i % 128;
        try {
            if ((i % 2 == 0 ? '#' : 'L') != '#') {
                KClassImpl$Data$declaredNonStaticMembers$2(exploreServiceWrapper);
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(exploreServiceWrapper);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreServiceViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_explore_service, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0074  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.explore.model.ExploreServiceWrapper r8) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreServiceViewHolder.getAuthRequestContext(id.dana.explore.model.ExploreServiceWrapper):void");
    }

    private final void PlaceComponentResult(ExploreServiceWrapper p0) {
        ExploreServiceModel exploreServiceModel;
        View view = this.itemView;
        String key = (p0 == null || (exploreServiceModel = p0.BuiltInFictitiousFunctionClassFactory) == null) ? null : exploreServiceModel.getKey();
        if (!(key == null)) {
            int hashCode = key.hashCode();
            if (!(hashCode != -1735081801)) {
                if (key.equals(ServicesEntityRepository.SERVICE_GAMES)) {
                    ((AppCompatImageView) view.findViewById(R.id.iv_service_icon)).setContentDescription(view.getContext().getString(R.string.icon_games));
                    ((MaterialTextView) view.findViewById(R.id.setDrawValueAboveBar)).setContentDescription(view.getContext().getString(R.string.lbl_games_title));
                    ((MaterialTextView) view.findViewById(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1)).setContentDescription(view.getContext().getString(R.string.lbl_games_description));
                }
            } else if (hashCode == 930525159) {
                if ((key.equals(MyBillsServiceKey.ELECTRICITY) ? '@' : 'N') != 'N') {
                    ((AppCompatImageView) view.findViewById(R.id.iv_service_icon)).setContentDescription(view.getContext().getString(R.string.icon_electricity));
                    ((MaterialTextView) view.findViewById(R.id.setDrawValueAboveBar)).setContentDescription(view.getContext().getString(R.string.lbl_electricity_title));
                    ((MaterialTextView) view.findViewById(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1)).setContentDescription(view.getContext().getString(R.string.lbl_electricity_description));
                }
            } else {
                int i = getAuthRequestContext + 75;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                if ((hashCode == 2038502419 ? '/' : 'U') != 'U') {
                    Object[] objArr = new Object[1];
                    a(View.MeasureSpec.makeMeasureSpec(0, 0) + 22, new int[]{-990361619, 322445489, -59298405, -935912847, 870035226, 1025348124, -1039170712, -268206289, 1670582048, 2067841768, 1345753012, -34595755}, objArr);
                    if (key.equals(((String) objArr[0]).intern())) {
                        int i3 = PlaceComponentResult + 73;
                        getAuthRequestContext = i3 % 128;
                        int i4 = i3 % 2;
                        ((AppCompatImageView) view.findViewById(R.id.iv_service_icon)).setContentDescription(view.getContext().getString(R.string.icon_pulsa));
                        ((MaterialTextView) view.findViewById(R.id.setDrawValueAboveBar)).setContentDescription(view.getContext().getString(R.string.lbl_pulsa_title));
                        ((MaterialTextView) view.findViewById(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1)).setContentDescription(view.getContext().getString(R.string.lbl_pulsa_description));
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0025, code lost:
    
        if ((!r6) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0043, code lost:
    
        if ((r6 ^ false ? 'N' : '+') != 'N') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0045, code lost:
    
        r2 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0048, code lost:
    
        r6 = id.dana.explore.view.ExploreServiceViewHolder.getAuthRequestContext + 113;
        id.dana.explore.view.ExploreServiceViewHolder.PlaceComponentResult = r6 % 128;
        r6 = r6 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(boolean r6) {
        /*
            r5 = this;
            int r0 = id.dana.explore.view.ExploreServiceViewHolder.PlaceComponentResult     // Catch: java.lang.Exception -> L56
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.explore.view.ExploreServiceViewHolder.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L56
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r3 = ""
            if (r0 == r1) goto L2a
            android.view.View r0 = r5.itemView     // Catch: java.lang.Exception -> L28
            int r4 = id.dana.R.id.iv_maintenance_badge     // Catch: java.lang.Exception -> L56
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.view.View r0 = (android.view.View) r0
            r6 = r6 ^ r1
            if (r6 == 0) goto L45
            goto L48
        L28:
            r6 = move-exception
            throw r6
        L2a:
            android.view.View r0 = r5.itemView
            int r1 = id.dana.R.id.iv_maintenance_badge
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.view.View r0 = (android.view.View) r0
            r6 = r6 ^ r2
            r1 = 78
            if (r6 == 0) goto L41
            r6 = 78
            goto L43
        L41:
            r6 = 43
        L43:
            if (r6 == r1) goto L48
        L45:
            r2 = 8
            goto L52
        L48:
            int r6 = id.dana.explore.view.ExploreServiceViewHolder.getAuthRequestContext
            int r6 = r6 + 113
            int r1 = r6 % 128
            id.dana.explore.view.ExploreServiceViewHolder.PlaceComponentResult = r1
            int r6 = r6 % 2
        L52:
            r0.setVisibility(r2)     // Catch: java.lang.Exception -> L56
            return
        L56:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreServiceViewHolder.getAuthRequestContext(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0100, code lost:
    
        if ((r9.getMyBillsEntityDataFactory() ? 'Z' : 'D') != 'Z') goto L143;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.explore.model.ExploreServiceWrapper r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreServiceViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.explore.model.ExploreServiceWrapper):void");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int length;
        int[] iArr2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i3 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = MyBillsEntityDataFactory;
        if (!(iArr3 == null)) {
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i4 = $10 + 103;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            for (int i6 = 0; i6 < length2; i6++) {
                iArr4[i6] = (int) (iArr3[i6] ^ (-3152031022165484798L));
            }
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = MyBillsEntityDataFactory;
        if (iArr6 != null) {
            int i7 = $10 + 33;
            $11 = i7 % 128;
            if ((i7 % 2 == 0 ? '7' : 'A') != '7') {
                length = iArr6.length;
                iArr2 = new int[length];
            } else {
                length = iArr6.length;
                iArr2 = new int[length];
            }
            int i8 = $11 + 115;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            int i10 = 0;
            while (i10 < length) {
                int i11 = $10 + 91;
                $11 = i11 % 128;
                int i12 = i11 % i3;
                iArr2[i10] = (int) (iArr6[i10] ^ (-3152031022165484798L));
                i10++;
                length3 = length3;
                i3 = 2;
            }
            iArr6 = iArr2;
            i2 = length3;
        } else {
            i2 = length3;
        }
        System.arraycopy(iArr6, 0, iArr5, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            try {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                int i13 = $10 + 59;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                int i15 = 0;
                while (true) {
                    if (!(i15 >= 16)) {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i15];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i16;
                        i15++;
                    }
                }
                int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i17;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
                int i18 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i19 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            } catch (Exception e) {
                throw e;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
