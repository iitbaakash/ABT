package com.example.gkaakash;

import java.util.ArrayList;
import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class edit_account extends Activity{
	
	private ListView lvitem;
	private EditText etSerach;
	private String listmenu[] = { "Ferrari", "BMW", "Benz", "Lambo", "Swift","Alto", "Nano"};
	private ArrayList<String> array_sort= new ArrayList<String>();
	int textlength=0;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_acc_tab);
        
        lvitem = (ListView) findViewById(R.id.ltAccname);
        etSerach = (EditText) findViewById(R.id.etSearch);
        lvitem.setCacheColorHint(color.transparent);
        lvitem.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listmenu));
        
        //attaching listener to textView
        etSerach.addTextChangedListener(new TextWatcher()
        {
        public void beforeTextChanged(CharSequence s,
        int start, int count, int after)
        {
        // Abstract Method of TextWatcher Interface.
        }
        public void onTextChanged(CharSequence s,
        int start, int before, int count)
        {
        //for loop for search
        textlength = etSerach.getText().length();
        array_sort.clear();
        for (int i = 0; i < listmenu.length; i++)
        {
        if (textlength <= listmenu[i].length())
        {
        if(etSerach.getText().toString().equalsIgnoreCase((String)listmenu[i].subSequence(0,textlength)))
        {
          array_sort.add(listmenu[i]);
        }
        }
        }
        lvitem.setAdapter(new ArrayAdapter<String>(edit_account.this,android.R.layout.simple_list_item_1, array_sort));
        }
		@Override
		public void afterTextChanged(Editable arg0) {
			// Abstract Method of ArrayAdapter Interface
		}
        });
 }
}