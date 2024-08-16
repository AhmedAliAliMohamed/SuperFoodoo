package com.example.kotlinappfood.ui.fragments.auth.onBoarding

import android.app.Application
import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.kotlinappfood.R
import com.example.kotlinappfood.models.OnBoardingModel
import com.example.kotlinappfood.ui.base.BaseViewModel
import javax.inject.Inject

 class OnBoardingViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

     fun getListForOnBoarding(context: Context) : List<OnBoardingModel>{
          val onBoardList = listOf(
            OnBoardingModel(
                R.drawable.ic_onboarding_one,
                context.getString(R.string.trending_foods),
                context.getString(R.string.the_application_allows_you_to_learn_about_all_the_trendy_meals_first_and_latest_dishes)
            ),
            OnBoardingModel(
                R.drawable.ic_onboarding_two,
                context.getString(R.string.fast_delivery),
                context.getString(R.string.your_order_will_be_delivered_as_quickly_as_possible_so_you_can_get_your_meal_hot_and_fresh)
            ),
            OnBoardingModel(
                R.drawable.ic_onboarding_three,
                context.getString(R.string.find_nearby_restaurants),
                context.getString(R.string.we_allow_you_to_see_all_the_restaurants_closest_to_you)
            ),
            OnBoardingModel(
                R.drawable.ic_onboarding_four,
                context.getString(R.string.easy_ordering),
                context.getString(R.string.easily_order_your_meal_from_your_favorite_meals)
            ),
            OnBoardingModel(
                R.drawable.ic_onboarding_five,
                context.getString(R.string.welcome_to_super_foodoo),
                context.getString(R.string.the_application_closest_to_you_for_ordering_meals_and_booking_restaurants_closest_to_you)
            ),
        )
        return onBoardList
    }


     fun getAnimationFroGetStartedButton(context: Context) : Animation? {
         val  slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down)
         return slideDown
     }
}