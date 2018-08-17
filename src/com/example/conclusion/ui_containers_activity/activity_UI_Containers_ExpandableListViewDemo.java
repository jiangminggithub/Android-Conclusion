package com.example.conclusion.ui_containers_activity;

import java.util.ArrayList;
import java.util.List;
import com.example.conclusion.R;
import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class activity_UI_Containers_ExpandableListViewDemo extends Activity {

	ExpandableListView expandablelistview;
	private List<String> groupArray;
	private List<List<String>> childArray;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_expandablelistview_demo);
		expandablelistview=(ExpandableListView) findViewById(R.id.expandlv_containers_ExpandableListView);
		
		groupArray=new ArrayList<String>();
		childArray=new ArrayList<List<String>>();
		
		groupArray.add("第一行");
		groupArray.add("第二行");
		groupArray.add("第三行");
		
		List<String> tempArray=new ArrayList<String>();
		tempArray.add("-->第1条");
		tempArray.add("-->第2条");
		tempArray.add("-->第3条");
		tempArray.add("-->第4条");
		
		for(int i=0;i<groupArray.size();i++){
			childArray.add(tempArray);
		}
		
		expandablelistview.setAdapter(new ExpandableListAdapter() {
			
			@Override
			public void unregisterDataSetObserver(DataSetObserver observer) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registerDataSetObserver(DataSetObserver observer) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onGroupExpanded(int groupPosition) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onGroupCollapsed(int groupPosition) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEmpty() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				String str=groupArray.get(groupPosition);
				return getGenericView(str);
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return groupArray.size();
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return groupArray.get(groupPosition);
			}
			
			@Override
			public long getCombinedGroupId(long groupId) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getCombinedChildId(long groupId, long childId) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return childArray.get(groupPosition).size();
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
					ViewGroup parent) {
				String str=childArray.get(groupPosition).get(childPosition);
				
				return getGenericView(str);
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childArray.get(groupPosition).get(childPosition);
			}
			
			@Override
			public boolean areAllItemsEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
			
			
			 public  TextView getGenericView(String string)  
			    {  
			        // Layout parameters for the ExpandableListView   
			        AbsListView.LayoutParams layoutParams = new  AbsListView.LayoutParams(  
			                ViewGroup.LayoutParams.FILL_PARENT, 64 );  
			        TextView text = new  TextView(activity_UI_Containers_ExpandableListViewDemo.this);  
			        text.setLayoutParams(layoutParams);  
			        // Center the text vertically   
			        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);  
			        // Set the text starting position   
			        text.setPadding(36 , 0 , 0 , 0 );  
			        text.setText(string);  
			        return  text;  
			    }  
		});
	}
	
	/*//自定义的Adapter   
	public  class  ExpandableAdapter extends  BaseExpandableListAdapter  
	{  
	    Activity activity;  
	      
	    public  ExpandableAdapter(Activity a)  
	    {  
	        activity = a;  
	    }  
	    public  Object getChild(int  groupPosition, int  childPosition)  
	    {  
	        return  childArray.get(groupPosition).get(childPosition);  
	    }  
	    public  long  getChildId(int  groupPosition, int  childPosition)  
	    {  
	        return  childPosition;  
	    }  
	    public  int  getChildrenCount(int  groupPosition)  
	    {  
	        return  childArray.get(groupPosition).size();  
	    }  
	    public  View getChildView(int  groupPosition, int  childPosition,  
	            boolean  isLastChild, View convertView, ViewGroup parent)  
	    {  
	        String string = childArray.get(groupPosition).get(childPosition);  
	        return  getGenericView(string);  
	    }  
	    // group method stub   
	    public  Object getGroup(int  groupPosition)  
	    {  
	        return  groupArray.get(groupPosition);  
	    }  
	    public  int  getGroupCount()  
	    {  
	        return  groupArray.size();  
	    }  
	    public  long  getGroupId(int  groupPosition)  
	    {  
	        return  groupPosition;  
	    }  
	    public  View getGroupView(int  groupPosition, boolean  isExpanded,  
	            View convertView, ViewGroup parent)  
	    {  
	        String string = groupArray.get(groupPosition);  
	        return  getGenericView(string);  
	    }  
	    // View stub to create Group/Children 's View   
	    public  TextView getGenericView(String string)  
	    {  
	        // Layout parameters for the ExpandableListView   
	        AbsListView.LayoutParams layoutParams = new  AbsListView.LayoutParams(  
	                ViewGroup.LayoutParams.FILL_PARENT, 64 );  
	        TextView text = new  TextView(activity);  
	        text.setLayoutParams(layoutParams);  
	        // Center the text vertically   
	        text.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);  
	        // Set the text starting position   
	        text.setPadding(36 , 0 , 0 , 0 );  
	        text.setText(string);  
	        return  text;  
	    }  
	    public  boolean  hasStableIds()  
	    {  
	        return  false ;  
	    }  
	    public  boolean  isChildSelectable(int  groupPosition, int  childPosition)  
	    {  
	        return  true ;  
	    }  
	}  */
}
