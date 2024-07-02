package com.spacECE.spaceceedu.growth_tracker;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.guilhe.views.CircularProgressView;
import com.spacECE.spaceceedu.R;

import java.util.ArrayList;
import java.util.List;

public class track_food_fitness_vaccination extends AppCompatActivity {

    CircularProgressView circularProgressView_food, circularProgressView_vaccinations, circularProgressView_fitness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_track_food_fitness_vaccination);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        circularProgressView_food = findViewById(R.id.growth_tracker_circular_pie_food);
        circularProgressView_vaccinations = findViewById(R.id.growth_tracker_circular_pie_vaccinations);
        circularProgressView_fitness = findViewById(R.id.growth_tracker_circular_pie_fitness);

        set_food_circular_pie_chart(10.0f, 30.0f, 60.0f);

        set_vaccinations_circular_pie_chart(30.0f, 40.0f, 30.0f);

        set_fitness_circular_pie_chart(70.0f, 20.0f, 10.0f);


    }

    void set_food_circular_pie_chart(float food_water, float food_fruits, float food_vegitables){
        List<Float> val = new ArrayList<>();
        val.add(food_water);
        val.add(food_fruits);
        val.add(food_vegitables);

        List<Integer> col = new ArrayList<>();
        col.add(getColor(R.color.growth_tracker_water));
        col.add(getColor(R.color.growth_tracker_fruit));
        col.add(getColor(R.color.growth_tracker_vegitable));

        circularProgressView_food.setProgress(val, col);
    }

    void set_vaccinations_circular_pie_chart(float upcomming_vaccinated, float not_vaccinated, float vaccinated){
        List<Float> val = new ArrayList<>();
        val.add(upcomming_vaccinated);
        val.add(not_vaccinated);
        val.add(vaccinated);

        List<Integer> col = new ArrayList<>();
        col.add(getColor(R.color.growth_tracker_upcoming_vaccine));
        col.add(getColor(R.color.growth_tracker_not_vaccine));
        col.add(getColor(R.color.growth_tracker_vaccinated));

        circularProgressView_vaccinations.setProgress(val, col);
    }

    void set_fitness_circular_pie_chart(float play_time, float screnn_time, float sleep_time){
        List<Float> val = new ArrayList<>();
        val.add(play_time);
        val.add(screnn_time);
        val.add(sleep_time);

        List<Integer> col = new ArrayList<>();
        col.add(getColor(R.color.growth_tracker_play_time));
        col.add(getColor(R.color.growth_tracker_screen_time));
        col.add(getColor(R.color.growth_tracker_sleep_time));

        circularProgressView_fitness.setProgress(val, col);
    }
}