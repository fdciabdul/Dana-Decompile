package Catalano.Math.Optimization;

import java.util.Comparator;

/* loaded from: classes6.dex */
public class MixedIntegerLinearProgramming {

    /* loaded from: classes6.dex */
    public enum Objective {
        Minimize,
        Maximize
    }

    /* renamed from: Catalano.Math.Optimization.MixedIntegerLinearProgramming$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Comparator<Solution> {
        @Override // java.util.Comparator
        public /* synthetic */ int compare(Solution solution, Solution solution2) {
            return Double.compare(solution2.getAuthRequestContext, solution.getAuthRequestContext);
        }
    }

    /* renamed from: Catalano.Math.Optimization.MixedIntegerLinearProgramming$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements Comparator<Solution> {
        @Override // java.util.Comparator
        public /* synthetic */ int compare(Solution solution, Solution solution2) {
            return Double.compare(solution.getAuthRequestContext, solution2.getAuthRequestContext);
        }
    }

    /* loaded from: classes6.dex */
    class Solution {
        private double getAuthRequestContext;
    }
}
