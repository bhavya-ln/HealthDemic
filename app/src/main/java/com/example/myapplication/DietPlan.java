package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityDietPlanBinding;

import static com.example.myapplication.BMI.EXTRA_HEIGHT;
import static com.example.myapplication.BMI.EXTRA_WEIGHT;

public class DietPlan extends AppCompatActivity {
    private static final String EXTRA_HEIGHT1 = "com.example.myapplication.extra.height";
    String weight;
    String height;
    double bmi;
    TextView plan_text;
    Button show;
    ActivityDietPlanBinding planBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        planBinding = ActivityDietPlanBinding.inflate(getLayoutInflater());
        setContentView(planBinding.getRoot());
        planBinding.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                bmi = Double.parseDouble(intent.getStringExtra(BMI.EXTRA_BMI));
                weight=intent.getStringExtra(BMI.EXTRA_WEIGHT).toString();
                height=intent.getStringExtra(BMI.EXTRA_HEIGHT).toString();

                String diet_plan="";
                if (bmi<25.0)
                    diet_plan="You're BMI is normal. You can continue with your routine or alternate follow this plan:\n Breakfast: 1 bowl of sprouts and vegetable poha and 1 glass milk (add 1 tbsp walnuts + crushed almond powder + ½ tsp sugar) + half an apple Or 3 whole eggs (scrambled/poached/boiled) + few vegetables + half an apple\n" +
                            "Lunch: 2 rotis (multigrain with added ghee) + 1 bowl of pulses or dal or chicken + 1 bowl of vegetables + 1 bowl of tofu or paneer salad\n" +
                            "Dinner:Brown rice pulao with rajma + 1 bowl of stir-fried vegetables + half a bowl of raita\n";
                else if(bmi>=25.0 && bmi< 35.0)
                    diet_plan="You are Obese. We suggest the following diet plan:\n Early morning - 1 glass warm water with some herb brewed in it +2-3 soaked almonds\n" +
                            "\n" +
                            "Morning - Lemon tea/ Ginger Tea/Coffee/ milk 1 cup (150 ml)\n" +
                            "\n" +
                            "Breakfast - Eggs omelette with spinach and shredded vegetables cooked or Idlis / dosa/ Poha/ upma 1 cup cooked\n" +
                            "\n" +
                            "Lunch - Salad with fresh vegetables and curd 1 cup\n" +
                            " Phulkas ( multigrain ) 1 piece , Rice ½ cup ,Cooked vegetables/ greens/ palya 1 cup (150 gms)\n" +
                            "\n" +
                            "Evening - 6 pm Fruit/ sprouts/ cucumber –carrot slices/ vegetable soup\n" +
                            "Dinner - 7.30 Pm salad with fresh vegetables 1 cup, Methi Dal / sambar/rasam 1 cup , Phulkas ( multigrain ) 1-2 piece Cooked vegetables/ greens/ palya 1 cup (150 gms)";
                else if(bmi>=35.0 && bmi< 40.0)
                    diet_plan="You are Very Obese. We suggest the following diet plan:\n Early morning - 1 glass warm water with some herb brewed in it +2-3 soaked almonds\n" +
                            "\n" +
                            "Morning - Lemon tea/ Ginger Tea/Coffee/ milk 1 cup (150 ml)\n" +
                            "\n" +
                            "Breakfast - Eggs omelette with spinach and shredded vegetables cooked or Idlis / dosa/ Poha/ upma 1 cup cooked\n" +
                            "\n" +
                            "Lunch - Salad with fresh vegetables and curd 1 cup\n" +
                            " Phulkas ( multigrain ) 1 piece , Rice ½ cup ,Cooked vegetables/ greens/ palya 1 cup (150 gms)\n" +
                            "\n" +
                            "Evening - 6 pm Fruit/ sprouts/ cucumber –carrot slices/ vegetable soup\n" +
                            "Dinner - 7.30 Pm salad with fresh vegetables 1 cup, Methi Dal / sambar/rasam 1 cup , Phulkas ( multigrain ) 1-2 piece Cooked vegetables/ greens/ palya 1 cup (150 gms)";
                else if(bmi>=40.0)
                    diet_plan="You are Morbidly Obese. We suggest the following diet plan:\n Early morning - 1 glass warm water with some herb brewed in it +2-3 soaked almonds\n" +
                            "\n" +
                            "Morning - Lemon tea/ Ginger Tea/Coffee/ milk 1 cup (150 ml)\n" +
                            "\n" +
                            "Breakfast - Eggs omelette with spinach and shredded vegetables cooked or Idlis / dosa/ Poha/ upma 1 cup cooked\n" +
                            "\n" +
                            "Lunch - Salad with fresh vegetables and curd 1 cup\n" +
                            " Phulkas ( multigrain ) 1 piece , Rice ½ cup ,Cooked vegetables/ greens/ palya 1 cup (150 gms)\n" +
                            "\n" +
                            "Evening - 6 pm Fruit/ sprouts/ cucumber –carrot slices/ vegetable soup\n" +
                            "Dinner - 7.30 Pm salad with fresh vegetables 1 cup, Methi Dal / sambar/rasam 1 cup , Phulkas ( multigrain ) 1-2 piece Cooked vegetables/ greens/ palya 1 cup (150 gms)";


                planBinding.planText.setText(""+diet_plan);

            }
        });

        }
    public void openDietPlan(View view){
        Intent intent=new Intent(this,ExercisePlan.class);
        intent.putExtra(EXTRA_HEIGHT,height);
        intent.putExtra(EXTRA_WEIGHT, weight);
        startActivity(intent);

    }
}