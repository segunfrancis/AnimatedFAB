package com.android.computer.animatedfab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class ViewAnimation {

    public static boolean rotateFab(View view, boolean rotate) {
        view.animate().setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                }).rotation(rotate ? 135f : 0f);
        return rotate;
    }

    public static void showIn(final View view) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0f);
        view.setTranslationY(view.getHeight());
        view.animate().setDuration(300).translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                }).alpha(1f)
                .start();
    }

    public static void showOut(final View view) {
        view.setVisibility(View.VISIBLE);
        view.setAlpha(1f);
        view.setTranslationY(0);
        view.animate().setDuration(300).translationY(view.getHeight())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                }).alpha(0f)
                .start();
    }

    public static void init(final View view) {
        view.setVisibility(View.GONE);
        view.setTranslationY(view.getHeight());
        view.setAlpha(0f);
    }
}
