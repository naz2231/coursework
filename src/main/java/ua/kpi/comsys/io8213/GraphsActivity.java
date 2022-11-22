package ua.kpi.comsys.io8213;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import lecho.lib.hellocharts.model.ChartData;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;
import lecho.lib.hellocharts.view.PieChartView;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;

public class GraphsActivity extends AppCompatActivity implements View.OnClickListener {
    Button pieChartButton;
    Button linearChartButton;
    private LineGraphSeries<DataPoint> series1;
    PieChartView pieChartView;
    GraphView linearChartView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        pieChartButton = (Button) findViewById(R.id.pieChartButton);
        pieChartButton.setOnClickListener(this);

        linearChartButton = (Button) findViewById(R.id.linearChart);
        linearChartButton.setOnClickListener(this);

        linearChartView = findViewById(R.id.linearGraph);
        linearChartView.setVisibility(View.INVISIBLE);

        pieChartView = findViewById(R.id.chart);
        pieChartView.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pieChartButton:
                linearChartView.setVisibility(View.INVISIBLE);

                //PieChartView pieChartView = findViewById(R.id.chart);

                pieChartView.setVisibility(View.VISIBLE);

                List<SliceValue> pieData = new ArrayList<>();

                pieData.add(new SliceValue(5, 0xffcd853f));
                pieData.add(new SliceValue(5, Color.CYAN));
                pieData.add(new SliceValue(10, 0xffff8c00));
                pieData.add(new SliceValue(80, Color.BLUE));

                PieChartData pieChartData = new PieChartData(pieData);

                pieChartView.setPieChartData(pieChartData);
                break;
            case R.id.linearChart:
                this.pieChartView.setVisibility(View.INVISIBLE);

                linearChartView.setVisibility(View.VISIBLE);

                GraphView linearChartView = (GraphView) findViewById(R.id.linearGraph);

                double x, y;
                x = -10;
                series1 = new LineGraphSeries<>();
                int numDataPoints = 500;
                for(int i = 0; i < numDataPoints; i++){
                    x = x + 0.1;
                    y = Math.sin(x);
                    series1.appendData(new DataPoint(x,y), true, 1000);
                }
                // set manual X bounds
                linearChartView.getViewport().setYAxisBoundsManual(true);
                linearChartView.getViewport().setMinY(-1);
                linearChartView.getViewport().setMaxY(1);

                linearChartView.getViewport().setXAxisBoundsManual(true);
                linearChartView.getViewport().setMinX(-7);
                linearChartView.getViewport().setMaxX(7);

                // enable scaling and scrolling
                linearChartView.getViewport().setScalable(true);
                linearChartView.getViewport().setScalableY(true);


                linearChartView.addSeries(series1);

            default:
                break;
        }
    }
}