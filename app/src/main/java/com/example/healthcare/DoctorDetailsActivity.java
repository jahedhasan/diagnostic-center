package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name : Jahed Hasan", "Hospital Address : Gazipur", "Exp : 5yrs", "Mobile No. : 01829284769", "600"},
            {"Doctor Name : Sanir Ahmed", "Hospital Address : Feni", "Exp : 5yrs", "Mobile No. : 01928374681", "700"},
            {"Doctor Name : Hossain Jahed", "Hospital Address : Dhaka", "Exp : 5yrs", "Mobile No. : 01829212229", "500"},
            {"Doctor Name : Kazi Himel", "Hospital Address : Joydevpur", "Exp : 5yrs", "Mobile No. : 01777784769", "600"},
            {"Doctor Name : Kazi Sanir Ahmed", "Hospital Address : Shibbari", "Exp : 5yrs", "Mobile No. : 01999284744", "800"}
    };
    private String[][] doctor_details2 = {
            {"Doctor Name : Mohammad Jahed", "Hospital Address : Dhaka", "Exp : 6yrs", "Mobile No. : 01829284769", "600"},
            {"Doctor Name : Hasan Jahed", "Hospital Address : Chattagram", "Exp : 5yrs", "Mobile No. : 01829212229", "300"},
            {"Doctor Name : Sanir Ahmed Himel", "Hospital Address : Mirpur", "Exp : 4yrs", "Mobile No. : 01777784769", "500"},
            {"Doctor Name : Sojib Hossain", "Hospital Address : Mohammadpur", "Exp : 5yrs", "Mobile No. : 01928374681", "600"},
            {"Doctor Name : Kazi Hasan", "Hospital Address : Feni", "Exp : 3yrs", "Mobile No. : 01999284744", "800"}
    };
    private String[][] doctor_details3 = {
            {"Doctor Name : Jahed Bhuiyan", "Hospital Address : Shariatpur", "Exp : 1yrs", "Mobile No. : 01928374681", "600"},
            {"Doctor Name : Hasan Bin Siddique", "Hospital Address : Cumilla", "Exp : 4rs", "Mobile No. : 01829212229", "400"},
            {"Doctor Name : Kazi Sanir Ahmed", "Hospital Address : Maymansing", "Exp : 5yrs", "Mobile No. : 01777784769", "500"},
            {"Doctor Name : Mehedi Hasan", "Hospital Address : Tangail", "Exp : 2yrs", "Mobile No. : 01829284769", "800"},
            {"Doctor Name : Sojibur Rahman", "Hospital Address : Feni", "Exp : 5yrs", "Mobile No. : 01999284744", "600"}
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Md. Kamal Ahmed", "Hospital Address : Gazipur", "Exp : 5yrs", "Mobile No. : 01829284769", "600"},
            {"Doctor Name : Md. Jahed Hasan", "Hospital Address : Feni", "Exp : 1yrs", "Mobile No. : 01829212229", "300"},
            {"Doctor Name : Jahed Hasan Bhuiyan", "Hospital Address : Narayanganj", "Exp : 2yrs", "Mobile No. : 01777784769", "400"},
            {"Doctor Name : Hasan Fazlul", "Hospital Address : Cumilla", "Exp : 8yrs", "Mobile No. : 01928374681", "500"},
            {"Doctor Name : Jakaria Hossain", "Hospital Address : Dhaka", "Exp : 5yrs", "Mobile No. : 01999284744", "700"}
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Kibria Hasan", "Hospital Address : Joydebpur", "Exp : 7yrs", "Mobile No. : 01999284744", "600"},
            {"Doctor Name : Sojib Hossain", "Hospital Address : Shibbari", "Exp : 4yrs", "Mobile No. : 01928374681", "400"},
            {"Doctor Name : Nurul Absar", "Hospital Address : Gazipur", "Exp : 5yrs", "Mobile No. : 01829212229", "300"},
            {"Doctor Name : Sakib Biswas", "Hospital Address : Abdullahpur", "Exp : 3yrs", "Mobile No. : 01829284769", "350"},
            {"Doctor Name : Sanir Ahmed", "Hospital Address : Kustia", "Exp : 2yrs", "Mobile No. : 01777784769", "900"}
    };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);
        Intent it =getIntent();
        String  title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0; i<doctor_details.length;i++)
        {
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+ doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"} ,
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
              Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
              it.putExtra("text1", title);
              it.putExtra("text2", doctor_details[i][0]);
              it.putExtra("text3", doctor_details[i][1]);
              it.putExtra("text4", doctor_details[i][3]);
              it.putExtra("text5", doctor_details[i][4]);

              startActivity(it);
            }
        });
    }
}