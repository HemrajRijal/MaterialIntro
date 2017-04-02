package com.module.material.materialintro;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.MessageButtonBehaviour;
import agency.tango.materialintroscreen.SlideFragmentBuilder;
import agency.tango.materialintroscreen.animations.IViewTranslation;

/**
 * Created by Hemraj on 4/1/2017.
 */

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.first_slide_background)
                        .buttonsColor(R.color.first_slide_buttons)
                        .image(R.drawable.donor)
                        .title("Let's try to Save People with Us")
                        .description("Would you try?")
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(IntroActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }, "Let's Get Started"));

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.second_slide_background)
                .buttonsColor(R.color.second_slide_buttons)
                .image(R.drawable.gift)
                .title("Be a Donor...")
                .description("Five minutes of your time + 350 ml. of your blood \n" +
                        "= One life saved")
                .build());

        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.fifth_slide_background)
                .buttonsColor(R.color.fifth_slide_buttons)
                .image(R.drawable.request_blood)
                .title("Request Blood")
                .description("There are thousands of people willing to help.")
                .build());

        addSlide(new CustomSlide());

        addSlide(new SlideFragmentBuilder()
                        .backgroundColor(R.color.third_slide_background)
                        .buttonsColor(R.color.third_slide_background)
                        .possiblePermissions(new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.READ_SMS})
                        .neededPermissions(new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION})
                        .image(R.drawable.img_equipment)
                        .title("We provide best platform to request and donate Blood ever")
                        .description("Will you be part our project?")
                        .build(),
                new MessageButtonBehaviour(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(IntroActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                }, "Let's Start"));
//
//        addSlide(new SlideFragmentBuilder()
//                .backgroundColor(R.color.fourth_slide_background)
//                .buttonsColor(R.color.fourth_slide_buttons)
//                .image(R.drawable.request_blood)
//                .title("Request Blood")
//                .description("There are thousands of people willing to help.")
//                .build());
    }

    @Override
    public void onFinish() {
        super.onFinish();
        Toast.makeText(this, "Welcome to our project BloodBank :)", Toast.LENGTH_SHORT).show();
    }
}