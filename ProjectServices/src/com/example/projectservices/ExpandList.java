package com.example.projectservices;

//import android.R;

import java.util.HashMap;

import com.example.projectservices.R.id;

import android.R.drawable;
import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;


public class ExpandList extends BaseExpandableListAdapter {

	//Declare the parent values && the child values.
	//Declare the Context to access to all data in App.
	public Context context;
	static TextView textview=null;
	static TextView textview2=null;
	//String [] Parent={"Ministry of Interior","Ministry of Higher Education","Ministry of Commerce and Industry "};
	int [][] Child={
			//{0,1,2,3,4,5,6,7,8,9,10,11,12,13},
			//{15,16,17},
			//{18,19,20},
			//{20,22,23},
			{0,1,2,3,4,5,6,7,8,9},
			{10,11,12},
			{13,14,15},
			{16,17,18,19},
			{20,21,22},
			{23,24},
			{25,26},
			};
	static int language2;
	String [][] lang={
			{"Ministry of Interior","  وزارة الداخلية"},
			{"Civil Defense","الدفاع المدني"},
			{"Passports","الجوازات"},
			{"Police","الشرطه"},
			{"Civil Affairs","الهلال الاحمر"},
			{"Border Guards","حرس الحدود"},
			{"","المرور"},
			{"","آمن الطرق"},
			{"","الاستخبارات العامة"},
			{"","نجم"},
	
			{"Ministry of Higher Education"," وزارة التعليم العالي"},
			{"new ministory",""},
			{"Civil Affairs","الاسعاف"},
			
			{"Ministry Headquarters",""},
			{"Civil Defense","الدفاع المدني"},
			{"Passports","الجوازات"},
			
			{"Ministry of low Education"," وزارة التربية التعليم"},
			{"","وكالة التخطيط والتطوير"},
			{"","وكالة التعليم-بنين"},
			{"","وكالة التعليم-بنات"},
			
			{"Ministry of health"," وزارة الصحة"},
			{"health","الادارة العامة للطواري الصحية"},
			{"health","استشارة الصحة"},
			
			{" Ministry of health"," وزارة التجارة"},
			{"health","مركز البلاغات"},
			
			{" Banks","بنك"},
			{"Albilad","بنك البلاد"},// we added new bank
			
			/*
			{"Ministry of Interior","  وزارة الداخلية"},
			{"Civil Defense","الدفاع المدني"},
			{"Passports","الجوازات"},
			{"Police","الشرطه"},
			{"Civil Affairs","الاسعاف"},
			{"Border Guards","حرس الحدود"},
			{""},
			{""},
			{""},
			{""},
			{""},
			{""},
			{""},
			{""},
			{""},
			{"Ministry of Higher Education","وزارة التعليم العالي"},
			{"new ministory",""},
			{"Civil Affairs","الاسعاف"},
			{"Ministry Headquarters",""},
			{""},
			{""},
			{"Ministry of low Education","وزارة التربية التعليم"},
			{" "},
			{" "},
			{"Ministry of health","وزارة الصحة"},
			{"health","وزارة الصحة"}
			*/
	};
	public ExpandList(Context c){
		this.context=c;	
	}
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(final int parentPostion,final int childPosition, boolean arg2, View view,
			ViewGroup arg4) {
		// TODO Auto-generated method stub
		// to create view that using XML Layout. 
		
	LayoutInflater inflater= LayoutInflater.from(context);
	
	ImageView imageview = null;
	
	if(view==null){
		//calling the childitems which is the layout xml I have declared 
		view=inflater.inflate(R.layout.letf_to_right, null);
		
	}
	//access to TextView in the LayoutXML Childitems.
	if(language2==0){
		textview=(TextView) view.findViewById(R.id.HeaderValues);
		textview.setText(lang[Child[parentPostion][childPosition+1]][language2]);
		textview.setPadding(29, 0, 0, 0);
		textview.setTextColor(Color.parseColor("#000000"));
		textview.setTextSize(16);
		imageview=(ImageView) view.findViewById(R.id.imageView1);
	}
	else 
	{
			view=inflater.inflate(R.layout.right_to_left,null);
			textview2=(TextView) view.findViewById(R.id.HeaderValues2);
			textview2.setText(lang[Child[parentPostion][childPosition+1]][language2]);
			textview2.setPadding(29, 0, 0, 0);
			textview2.setTextColor(Color.parseColor("#000000"));
			textview2.setTextSize(16);
			imageview=(ImageView) view.findViewById(R.id.imageView1);
		}	
		imageview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = null;
				String[][] phoneNum={
						{"332","330","753"},
						{"100","087","099"},
						{"656","434","176"},
						{"656","434","176"},
				};
			intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phoneNum[parentPostion][childPosition]));
			//task to have the ability to access to startActitviy from MainActivity.
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			MainActivity.getcContext().startActivity(intent);
						
			}
				/*
				switch(parentPostion){
				case 0:
					if(childPosition==0){
					intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:0582275592"));
					//task to have the ability to access to startActitviy from MainActivity.
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					MainActivity.getcContext().startActivity(intent);
					}
					else if(childPosition==1){
					intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:0581110987"));
					//task to have the ability to access to startActitviy from MainActivity.
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					MainActivity.getcContext().startActivity(intent);	
					}
					break;
				case 1:
					if(childPosition==0){
					 intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:0544476961"));
					 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					 MainActivity.getcContext().startActivity(intent);
					}
					else if(childPosition==1){
						intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:997"));
						 intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						 MainActivity.getcContext().startActivity(intent);
					}
				break;
				case 2:
					Toast.makeText(context , "value"+childPosition, Toast.LENGTH_SHORT).show();
				}	
				*/
			
		});
		
		
		//return view 
		return view;
		}
	@Override
	public int getChildrenCount(int pos) {
		// TODO Auto-generated method stub
		return Child[pos].length-1;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 7;//MainActivity.Parent.length;
	}
	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getGroupView(int parentposition, boolean arg1, View view, ViewGroup arg3) {
		// TODO Auto-generated method stub
		
		TextView parentView=new TextView(context);    
	    parentView.setText(lang[Child[parentposition][0]][language2]);//MainActivity.Parent[parentposition]);
		parentView.setPadding(39, 19, 0, 0);	
		parentView.setBackgroundColor(Color.parseColor("#006600"));
		parentView.setTextColor(Color.parseColor("#ffffff"));
		parentView.setHeight(77);
		parentView.setTextSize(20);
		return parentView;
		
	}
	public void setGroupIndicator (drawable groupIndicator){
		
	}
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
}
