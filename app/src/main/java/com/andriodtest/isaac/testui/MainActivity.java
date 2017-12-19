package com.andriodtest.isaac.testui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.andriodtest.isaac.testui.ListVIew.Celebrity;
import com.andriodtest.isaac.testui.ListVIew.PersonAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

public class MainActivity extends Activity {

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Date_init();
    }
    /**---------ListView--Start---------**/
    private ListView list_celebrity;
    private LinkedList<Celebrity> cele_Data = null;
    private PersonAdapter personAdapter = null;
    public void ListView_init(){
        setContentView(R.layout.celebrity_list);
        mContext = MainActivity.this;
        list_celebrity = (ListView)findViewById(R.id.list_view);
        cele_Data = new LinkedList<>();
        cele_Data.add(new Celebrity("鲁迅","其实地上本没有路，走的人多了，也便成了路。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","书籍是人类进步的阶梯",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","惟沉默是最高的轻蔑。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","面具戴太久，就会长到脸上，再想揭下来，除非伤筋动骨扒皮。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","猛兽总是独行，牛羊才成群结队。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","友谊是两颗心真诚相待，而不是一颗心对另一颗心的敲打。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","贪安稳就没有自由，要自由就要历些危险。只有这两条路。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","哀其不幸，怒其不争。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","真的猛士，敢于直面惨淡的人生，敢于正视淋漓的鲜血。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","度尽劫波兄弟在，相逢一笑泯恩仇。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","卑怯的人，即使有万丈的怒火，除弱草以外，又能烧掉什么呢？",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","我翻开历史一查，这历史没有年代。歪歪斜斜的每页上都写着“仁义道德”几个字，我横竖睡不着，仔细看了半夜，才从字缝里看出来，满本上都写着两个字“吃人",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","横眉冷对千夫指，俯首甘为孺子牛。",R.mipmap.iv_icon_1));
        cele_Data.add(new Celebrity("鲁迅","人生得一知己足矣，斯世当以同怀视之",R.mipmap.iv_icon_1));


        personAdapter = new PersonAdapter((LinkedList<Celebrity>)cele_Data,mContext);
        list_celebrity.setAdapter(personAdapter);
    }

    /**---------ListView--End----------**/
    /**---------ViewFlipper--Start---------**/
    private ViewFlipper vflp_help;
    private int[] resId = {R.mipmap.ic_help_view_1,R.mipmap.ic_help_view_2,
    R.mipmap.ic_help_view_3,R.mipmap.ic_help_view_4};
    private final static int MIN_MOVE = 200;  // 最小距离
    private MyGestureListener mgListener;
    private GestureDetector mDetector;
    //重写onTouchEvent触发MyGestureListener里的方法
    public boolean onTouchEvent(MotionEvent event){
        return mDetector.onTouchEvent(event);
    }
    //自定义GestureListener
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onFling(MotionEvent e1,MotionEvent e2,float v1,float v2){
            if(e1.getX() - e2.getX() > MIN_MOVE){
                vflp_help.setInAnimation(mContext,R.anim.right_in);
                vflp_help.setOutAnimation(mContext, R.anim.right_out);
                vflp_help.showNext();
            }else if(e2.getX() - e1.getX() > MIN_MOVE){
                vflp_help.setInAnimation(mContext,R.anim.left_in);
                vflp_help.setOutAnimation(mContext, R.anim.left_out);
                vflp_help.showPrevious();
            }
            return true;
        }
    }
    private ImageView getImageView(int resId){
        ImageView img = new ImageView(this);
        img.setBackgroundResource(resId);
        return img;
    }
    private void flipperPage_init(){
        mContext = MainActivity.this;
        //实例化SimpleOnGestureListenner 与 GestureDetector对象
        setContentView(R.layout.school_message);
        mgListener = new MyGestureListener();
        mDetector = new GestureDetector(this,mgListener);
        vflp_help = (ViewFlipper)findViewById(R.id.vflp_help);
        //动态导入添加子View
        for(int i=0;i<resId.length;i++){
            if(vflp_help==null)System.out.print("114");
            vflp_help.addView(getImageView(resId[i]));
        }
    }
    /**---------ViewFlipper--End----------**/

    /**------------Menu--Start-----------------**/
    final private int personalPage = 110;
    final private int others = 111;
    final private int schools = 112;
    final private int celebritys = 113;
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(1,personalPage,0,"个人信息");
        menu.add(1,schools,0,"学校照片");
        menu.add(1,celebritys,0,"名言警句");
        menu.add(1,others,0,"修改信息");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case personalPage:
                GridView_init();
                break;
            case schools:
                flipperPage_init();
                break;
            case celebritys:
                ListView_init();
                break;
            case others:
                setContentView(R.layout.activity_main);
                Date_init();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /**------------Menu--End-----------------**/

    /**------------GridView--Start-----------------**/
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;
    private void GridView_init(){
        setContentView(R.layout.personal_page);
        mContext = MainActivity.this;
        grid_photo = (GridView) findViewById(R.id.grid_photo);

        mData = new ArrayList<>();

        mData.add(new Icon(R.mipmap.iv_icon_1,"Kyrie Irving"));
        mData.add(new Icon(R.mipmap.iv_icon_2,"James Harden"));
        mData.add(new Icon(R.mipmap.iv_icon_3,"Stephen Curry"));
        mData.add(new Icon(R.mipmap.iv_icon_4,"Kevin Durant"));
        mData.add(new Icon(R.mipmap.iv_icon_5,"Dirk Nowitzki"));
        mData.add(new Icon(R.mipmap.iv_icon_6,"LeBron James"));

        mAdapter = new MyAdapter<Icon>(mData,R.layout.item_grid_icon){
            public void bindView(ViewHolder holder,Icon obj){
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon,obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);
//        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            public void onItemClick(AdapterView<?> parent, View view , int position,long id){
//                Toast.makeText(mContext, "你点击了第 " + position + " 项", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    /**------------GridVIew--End-----------------**/

    /**------------DatePicker-start------------------**/

    private DatePicker datePicker;
    private TextView mDateDisplay;
    private EditText modifyText;
    private int mYear,mMonth,mDay;
    static final int DATE_DIALOG_ID = 0;
    private void Date_init(){
        mDateDisplay = (TextView)findViewById(R.id.birthday);

        mDateDisplay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //显示对话框
                showDialog(DATE_DIALOG_ID);
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,mDateSetListener,mYear,mMonth,mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

            mDateDisplay.setText(new StringBuffer().append(mYear).append("-").append(mMonth+1).append("-").append(mDay));
        }
    };

    /**---DatePicker-End------------------**/

    public void onClickSex(View view){

    }
}
