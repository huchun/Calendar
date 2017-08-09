package com.xss.calendar;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xss.datepicker.MonthDateView;
import com.xss.datepicker.MonthDateView.DateClick;
import com.xss.datepicker.MonthDateView.DateTouch;

public class MainActivity extends FragmentActivity {
	private ImageView iv_left;
	private ImageView iv_right;
	private TextView tv_date;
	private TextView tv_week;
	private TextView tv_today;
	private MonthDateView monthDateView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		List<Integer> list = new ArrayList<Integer>();
		list.add(20160810);
		list.add(20160812);
		list.add(20160815);
		list.add(20160816);
		setContentView(R.layout.activity_date);
		iv_left = (ImageView) findViewById(R.id.iv_left);
		iv_right = (ImageView) findViewById(R.id.iv_right);
		monthDateView = (MonthDateView) findViewById(R.id.monthDateView);
		tv_date = (TextView) findViewById(R.id.date_text);
		tv_week = (TextView) findViewById(R.id.week_text);
		tv_today = (TextView) findViewById(R.id.tv_today);
		monthDateView.setTextView(tv_date, tv_week);
		monthDateView.setDaysHasThingList(list);
		monthDateView.setDateClick(new DateClick() {

			@Override
			public void onClickOnDate() {
				Toast.makeText(getApplication(),
						"点击了：" +monthDateView.getmSelDate(), Toast.LENGTH_SHORT)
						.show();
			}
		});
		monthDateView.setDateTouch(new DateTouch() {
			
			@Override
			public void onTouchOnDate(String touch) {
				if(touch.equals("L")){
					monthDateView.onRightClick();
				}
				if(touch.equals("R")){
					monthDateView.onLeftClick();
				}
			}
		});
		setOnlistener();
	}

	private void setOnlistener() {
		
		iv_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				monthDateView.onLeftClick();
			}
		});

		iv_right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				monthDateView.onRightClick();
			}
		});

		tv_today.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				monthDateView.setTodayToView();
			}
		});
		
	
	}
}
